package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaDetalleDTO;


public class AgendaDAO {

	/**
	 * Metodo para registrar la agenda de un contrato
	 * @param uid identificador unico de la transaccion
	 * @param agenda datos de la agenda
	 * @return respuesta del registro
	 */
	public EncabezadoRespuesta altaAgenda(String uid, AgendaDTO agenda) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Validamos si ya existe un contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeContrato = (Integer) sessionNTx.selectOne("AgendaDAO.existeAgenda", agenda);
			if (existeContrato > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe un registro del mismo "
						+ "tipo de documento y numero documento vigente.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("AgendaDAO.altaAgenda", agenda);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al registrar la agenda.");
			}
			System.out.println("ID agenda = " + agenda.getIdAgenda());
			if (agenda.getDiasAgenda().size() > 0) {
				for (AgendaDetalleDTO agendaDetalle : agenda.getDiasAgenda()) {
					agendaDetalle.setIdAgenda(agenda.getIdAgenda());
				}
				altaAgendaDetalle(uid, agenda.getDiasAgenda(), sessionTx);
				
			}
			
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();

		} catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!");
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}
	/**
	 * Metodo para registrar detalle de agenda
	 * @param uid unico de registro
	 * @param agendaDetalle recibe los valores de agenda detalle
	 * @param session se abre session bd
	 * @throws Exception por si surge un error
	 */
	public void altaAgendaDetalle(String uid, List<AgendaDetalleDTO> agendaDetalle, SqlSession session) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
	
				for (int j = 0; j < agendaDetalle.size(); j++) {

					//Validamos el registro
					int registros = sessionTx.insert("AgendaDAO.registraAgendaDetalles", agendaDetalle);
					if ( registros == 0) {
						if ( session == null ) {
							FabricaConexiones.rollBack(sessionTx);
							FabricaConexiones.close(sessionTx);
						}
						throw new ExcepcionesCuadrillas("No se pudo registrar.");
						
						
					}
					
					if (agendaDetalle.get(j).getActividades().size() > 0) {
					for (AgendaDetalleDTO agendaActividad : agendaDetalle.get(j).getActividades()) {
						agendaActividad.setIdAgendaDetalle(agendaDetalle.get(j).getIdAgendaDetalle());
					}
					altaActividadDetalle(uid, agendaDetalle.get(j).getActividades(), sessionTx);
				}
				if (agendaDetalle.get(j).getMateriales().size() > 0) {
					for (AgendaDetalleDTO agendaMaterial : agendaDetalle.get(j).getMateriales()) {
						agendaMaterial.setIdAgendaDetalle(agendaDetalle.get(j).getIdAgendaDetalle());
					}
					altaMaterialDetalle(uid, agendaDetalle.get(j).getMateriales(), sessionTx);
				}
				if (agendaDetalle.get(j).getCoordenadas().size() > 0) {
					for (CoordenadaDTO agendaCoordenadas : agendaDetalle.get(j).getCoordenadas()) {
						agendaCoordenadas.setIdAgendaDetalle(agendaDetalle.get(j).getIdAgendaDetalle());
					}
					altaCoordenadaDetalle(uid, agendaDetalle.get(j).getCoordenadas(), sessionTx);
				}
				}
				
		//La conexion no es atomica realizamos commit
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Commit conexion.");
			sessionTx.commit();
		}
		//La conexion no es atomica cerramos
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Cerramos conexion.");
			FabricaConexiones.close(sessionTx);
		}
	}
	/**
	 * Metodo para registrar los detalles de las actividades
	 * @param uid unico de registro
	 * @param actividad recibe valores
	 * @param session abre session BD
	 * @throws Exception crea una excepcion
	 */
	public void altaActividadDetalle(String uid, List<AgendaDetalleDTO> actividad, SqlSession session ) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		int registros = sessionTx.insert("AgendaDAO.registraAgendaActividad", actividad);
		if ( registros == 0) {
			if ( session == null ) {
				FabricaConexiones.rollBack(sessionTx);
				FabricaConexiones.close(sessionTx);
			}
			throw new ExcepcionesCuadrillas("No se pudo registrar.");
		}
		//La conexion no es atomica realizamos commit
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Commit conexion.");
			sessionTx.commit();
		}
		//La conexion no es atomica cerramos
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Cerramos conexion.");
			FabricaConexiones.close(sessionTx);
		}
	}
	/**
	 * Metodo para registrar los detalles de las materias
	 * @param uid unico de registro
	 * @param materia recibe valores
	 * @param session abre session BD
	 * @throws Exception crea una excepcion
	 */
	public void altaMaterialDetalle(String uid, List<AgendaDetalleDTO> materia, SqlSession session ) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		int registros = sessionTx.insert("AgendaDAO.registraAgendaMateria", materia);
		if ( registros == 0) {
			if ( session == null ) {
				FabricaConexiones.rollBack(sessionTx);
				FabricaConexiones.close(sessionTx);
			}
			throw new ExcepcionesCuadrillas("No se pudo registrar.");
		}
		//La conexion no es atomica realizamos commit
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Commit conexion.");
			sessionTx.commit();
		}
		//La conexion no es atomica cerramos
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Cerramos conexion.");
			FabricaConexiones.close(sessionTx);
		}
	}
	/**
	 * Metodo para registrar los detalles de las actividades
	 * @param uid unico de registro
	 * @param coordenada recibe valores
	 * @param session abre session BD
	 * @throws Exception crea una excepcion
	 */
	public void altaCoordenadaDetalle(String uid, List<CoordenadaDTO> coordenada, SqlSession session ) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		int registros = sessionTx.insert("AgendaDAO.registraAgendaCoordenada", coordenada);
		if ( registros == 0) {
			if ( session == null ) {
				FabricaConexiones.rollBack(sessionTx);
				FabricaConexiones.close(sessionTx);
			}
			throw new ExcepcionesCuadrillas("No se pudo registrar.");
		}
		//La conexion no es atomica realizamos commit
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Commit conexion.");
			sessionTx.commit();
		}
		//La conexion no es atomica cerramos
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Cerramos conexion.");
			FabricaConexiones.close(sessionTx);
		}
	}
	/**
	 * Metodo para dar de baja la agenda
	 * @param uid unico de registro
	 * @param agenda recibe valores de agenda
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta bajaAgenda(String uid, AgendaDTO agenda) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("La agenda ha sido dado de baja correctamente.");
		try {
			//Validamos si ya esta dado de baja la agenda
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeBajaAgenda = (Integer) sessionNTx.selectOne("AgendaDAO.existeBajaAgenda", agenda);
			if (existeBajaAgenda > 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja, la agenda ya se encuentra inactivo.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("AgendaDAO.bajaAgenda", agenda);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja la agenda.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		} catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!");
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}
	/**
	 * Metodo para consultar las agendas disponibles
	 * @param uid unico de registro
	 * @param agenda recibe valores de agenda
	 * @return regresa lista de las agendas disponibles
	 * @throws Exception si se genera un error
	 */
	@SuppressWarnings("unchecked")
	public List<AgendaDTO> consultaAgenda(String uid, AgendaDTO agenda) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<AgendaDTO> listaConsultaAgenda = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla
			listaConsultaAgenda = sessionNTx.selectList("AgendaDAO.consultaAgenda", agenda);
			if ( listaConsultaAgenda.size() == 0) {
				throw new ExcepcionesCuadrillas("No existe agendas actualmente.");
			}
			for (AgendaDTO c : listaConsultaAgenda) {
				List<CoordenadaDTO> coordenadas = null;
				coordenadas = sessionNTx.selectList("AgendaDAO.consultaAgendaCoordenadas", c);
				c.setCoordenadas(coordenadas);
		    }
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaConsultaAgenda;
	}
	/**
	 * Metodo para actualizar la agenda
	 * @param uid unico de registro
	 * @param agenda recibira valores de agenda
	 * @return regresara respuesta
	 */
	public EncabezadoRespuesta actualizaAgenda(String uid, AgendaDTO agenda) {
		SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("La agenda ha sido modificada correctamente.");
		try {

			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
			int registros = sessionTx.update("AgendaDAO.modificaAgenda", agenda);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar la agenda.");
			}
			if (agenda.getDiasAgenda().size() > 0) {
				for (AgendaDetalleDTO agendaDetalle : agenda.getDiasAgenda()) {
					agendaDetalle.setIdAgenda(agenda.getIdAgenda());
				}
				modificaAgendaDetalle(uid, agenda.getDiasAgenda(), sessionTx);
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		} catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!");
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return respuesta;
	}
	/**
	 * Metodo para actualizar agenda detalle
	 * @param uid unico de registro
	 * @param agendaDetalle recibe valores de agenda detalle
	 * @param session crea una session de BD
	 * @throws Exception por si surge una excepcion
	 */
 public void modificaAgendaDetalle(String uid, List<AgendaDetalleDTO> agendaDetalle, SqlSession session) throws Exception {
	 SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		int registros = sessionTx.update("AgendaDAO.modificaAgendaDetalle", agendaDetalle);
		if ( registros == 0) {
			if ( session == null ) {
				FabricaConexiones.rollBack(sessionTx);
				FabricaConexiones.close(sessionTx);
			}
			throw new ExcepcionesCuadrillas("No se pudo registrar.");
		}
		AgendaDetalleDTO detalle = new AgendaDetalleDTO();
		 detalle.setIdAgendaDetalle(detalle.getIdAgendaDetalle());
				//elimina actividades
				eliminaActividades(uid, detalle, sessionTx);
				//eliminaMateriales
				eliminaMateriales(uid, detalle, sessionTx);
				//elimina las coordenadas
				eliminaCoordenadas(uid, detalle, sessionTx);
				//enviamos los demas datos a la BD
				for (int j = 0; j < agendaDetalle.size(); j++) {
					System.out.println("ID agendaDetalle = " + agendaDetalle.get(j).getIdAgendaDetalle());
					if (agendaDetalle.get(j).getActividades().size() > 0) {
						for (AgendaDetalleDTO agendaActividad : agendaDetalle.get(j).getActividades()) {
							agendaActividad.setIdAgendaDetalle(agendaDetalle.get(j).getIdAgendaDetalle());
						}
						altaActividadDetalle(uid, agendaDetalle.get(j).getActividades(), sessionTx);
					}
					if (agendaDetalle.get(j).getMateriales().size() > 0) {
						for (AgendaDetalleDTO agendaMaterial : agendaDetalle.get(j).getMateriales()) {
							agendaMaterial.setIdAgendaDetalle(agendaDetalle.get(j).getIdAgendaDetalle());
						}
						altaMaterialDetalle(uid, agendaDetalle.get(j).getMateriales(), sessionTx);
					}
					if (agendaDetalle.get(j).getCoordenadas().size() > 0) {
						for (CoordenadaDTO agendaCoordenadas : agendaDetalle.get(j).getCoordenadas()) {
							agendaCoordenadas.setIdAgendaDetalle(agendaDetalle.get(j).getIdAgendaDetalle());
						}
						altaCoordenadaDetalle(uid, agendaDetalle.get(j).getCoordenadas(), sessionTx);
					}
				}
		//La conexion no es atomica realizamos commit
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Commit conexion.");
			sessionTx.commit();
		}
		//La conexion no es atomica cerramos
		if ( session == null ) {
			LogHandler.debug(uid, this.getClass(), "Cerramos conexion.");
			FabricaConexiones.close(sessionTx);
		}
 }
 /**
  * Metodo para dar de baja las actividades
  * @param uid unico de registro
  * @param agendaDetalle recibe valores de agenda detalle
  * @param session abre session de BD
  */
 public void eliminaActividades(String uid, AgendaDetalleDTO agendaDetalle, SqlSession session) throws Exception {
	 int registros = session.delete("AgendaDAO.eliminaActividades", agendaDetalle);
	 LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
 }
 /**
  * Metodo para eliminar los materiales
  * @param uid unico de registro
  * @param agendaDetalle recibe valores de agenda detalle
  * @param session abre session de BD
  * @throws Exception
  */
 public void eliminaMateriales(String uid, AgendaDetalleDTO agendaDetalle, SqlSession session) throws Exception {
	 int registros = session.delete("AgendaDAO.eliminaMateriales", agendaDetalle);
	 LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
 }
 /**
  * Metodo para eliminar los materiales
  * @param uid unico de registro
  * @param agendaDetalle recibe valores de agenda detalle
  * @param session abre session de BD
  * @throws Exception
  */
 public void eliminaCoordenadas(String uid, AgendaDetalleDTO agendaDetalle, SqlSession session) throws Exception {
	 int registros = session.delete("AgendaDAO.eliminaCoordenadas", agendaDetalle);
	 LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
 }
 /**
	 * Metodo para consultar las agendas disponibles con fecha
	 * @param uid unico de registro
	 * @param agenda recibe valores de agenda
	 * @return regresa lista de las agendas disponibles
	 * @throws Exception si se genera un error
	 */
	@SuppressWarnings("unchecked")
	public List<AgendaDTO> consultaAgendaContrato(String uid, AgendaDTO agenda) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<AgendaDTO> listaConsultaAgenda = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla
			listaConsultaAgenda = sessionNTx.selectList("AgendaDAO.consultaAgendaContrato", agenda);
			if ( listaConsultaAgenda.size() == 0) {
				throw new ExcepcionesCuadrillas("No existe agendas actualmente.");
			}
			for (AgendaDTO c : listaConsultaAgenda) {
				List<CoordenadaDTO> coordenadas = null;
				coordenadas = sessionNTx.selectList("AgendaDAO.consultaAgendaCoordenadas", c);
				c.setCoordenadas(coordenadas);
		    }
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaConsultaAgenda;
	}
}
