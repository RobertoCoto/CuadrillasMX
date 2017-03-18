package com.fyg.cuadrillas.dao;

import java.util.HashMap;
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
		respuesta.setMensajeFuncional("La agenda se ha registrado correctamente.");
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
			for (AgendaDetalleDTO agendaDetalle : agenda.getDiasAgenda()) {
				agendaDetalle.setIdAgenda(agenda.getIdAgenda());
				agendaDetalle.setUsuarioAlta(agenda.getUsuario());
				altaAgendaDetalle(uid, agendaDetalle, sessionTx);
				System.out.println("**********" + agendaDetalle.getIdAgendaDetalle());
				altaActividadDetalle(uid, agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getActividades(), sessionTx);
				altaMaterialDetalle(uid, agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getMateriales(), sessionTx);
				altaCoordenadaDetalle(uid, agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getCoordenadas(), sessionTx);
				altaActividadDiaria(uid,agendaDetalle.getIdAgenda() ,agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getActividades(), sessionTx);
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
	public void altaAgendaDetalle(String uid, AgendaDetalleDTO agendaDetalle, SqlSession session) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}

		int registros = sessionTx.insert("AgendaDAO.registraAgendaDetalles", agendaDetalle);
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
	 * @param idAgendaDetalle id agenda
	 * @param usuario usuario
	 * @param actividades lista de actividades
	 * @param session transaccional
	 * @throws Exception
	 */
	public void altaActividadDetalle(String uid, int idAgendaDetalle, String usuario,
				List<String> actividades, SqlSession session ) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		for (String actividad : actividades) {
			HashMap<Object, Object> parametros = new HashMap<Object, Object>();
			parametros.put("id_agenda_detalle", idAgendaDetalle);
			parametros.put("actividad", actividad);
			parametros.put("usuario", usuario);
			int registros = sessionTx.insert("AgendaDAO.registraAgendaActividad", parametros);
			if ( registros == 0) {
				if ( session == null ) {
					FabricaConexiones.rollBack(sessionTx);
					FabricaConexiones.close(sessionTx);
				}
				throw new ExcepcionesCuadrillas("No se pudo registrar.");
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
	 * Metodo para registrar los detalles de las materias
	 * @param uid unico de registro
	 * @param materiales recibe valores
	 * @param session abre session BD
	 * @throws Exception crea una excepcion
	 */
	public void altaMaterialDetalle(String uid, int idAgendaDetalle, String usuario, 
			List<String> materiales, SqlSession session ) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		for (String material : materiales) {
			HashMap<Object, Object> parametros = new HashMap<Object, Object>();
			parametros.put("id_agenda_detalle", idAgendaDetalle);
			parametros.put("material", material);
			parametros.put("usuario", usuario);
			int registros = sessionTx.insert("AgendaDAO.registraAgendaMateria", parametros);
			if ( registros == 0) {
				if ( session == null ) {
					FabricaConexiones.rollBack(sessionTx);
					FabricaConexiones.close(sessionTx);
				}
				throw new ExcepcionesCuadrillas("No se pudo registrar.");
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
	 * @param coordenada recibe valores
	 * @param session abre session BD
	 * @throws Exception crea una excepcion
	 */
	public void altaCoordenadaDetalle(String uid, int idAgendaDetalle, String usuario,
			List<CoordenadaDTO> coordenada, SqlSession session ) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		for (CoordenadaDTO coordenadas : coordenada) {
			HashMap<Object, Object> parametros = new HashMap<Object, Object>();
			parametros.put("id_agenda_detalle", idAgendaDetalle);
			parametros.put("orden", coordenadas.getOrden());
			parametros.put("direccion", coordenadas.getDireccion());
			parametros.put("latitud", coordenadas.getLatitud());
			parametros.put("longitud", coordenadas.getLongitud());
			parametros.put("usuario", usuario);
			int registros = sessionTx.insert("AgendaDAO.registraAgendaCoordenada", parametros);
			if ( registros == 0) {
				if ( session == null ) {
					FabricaConexiones.rollBack(sessionTx);
					FabricaConexiones.close(sessionTx);
				}
				throw new ExcepcionesCuadrillas("No se pudo registrar.");
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
	 * Metodo para registrar las actividades diarias
	 * @param uid unico de registro
	 * @param idAgenda recibe el id de la agenda
	 * @param idAgendaDetalle recibe el id agenda detalle
	 * @param codigoActividad recibe el codigo act
	 * @param usuario recibe el usuario
	 * @param session abre una sesion de BD
	 * @throws Exception genera excepcion
	 */
	public void altaActividadDiaria(String uid, int idAgenda, Integer idAgendaDetalle, String usuario, List<String> actividades, SqlSession session) throws Exception {
		SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		//Validamos el registro
		for (String codigo_actividad : actividades) {
			HashMap<Object, Object> parametros = new HashMap<Object, Object>();
			parametros.put("id_agenda", idAgenda);
			parametros.put("id_agenda_detalle", idAgendaDetalle);
			parametros.put("codigo_actividad", codigo_actividad);
			parametros.put("usuario_alta", usuario);
			int registros = sessionTx.insert("AgendaDAO.registroDiarioActividad", parametros);
			if ( registros == 0) {
				if ( session == null ) {
					FabricaConexiones.rollBack(sessionTx);
					FabricaConexiones.close(sessionTx);
				}
				throw new ExcepcionesCuadrillas("No se pudo registrar.");
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
			System.out.println("ID agenda = " + agenda.getIdAgenda());
			for (AgendaDetalleDTO agendaDetalle : agenda.getDiasAgenda()) {
				agendaDetalle.setIdAgenda(agenda.getIdAgenda());
				agendaDetalle.setIdAgendaDetalle(agendaDetalle.getIdAgendaDetalle());
				agendaDetalle.setUsuarioAlta(agenda.getUsuario());
				modificaAgendaDetalle(uid, agendaDetalle, sessionTx);
				System.out.println("**********" + agendaDetalle.getIdAgendaDetalle());
				//elimina actividades
				eliminaActividades(uid, agendaDetalle.getIdAgendaDetalle(), sessionTx);
				//eliminaMateriales
				eliminaMateriales(uid, agendaDetalle.getIdAgendaDetalle(), sessionTx);
				//elimina las coordenadas
				eliminaCoordenadas(uid, agendaDetalle.getIdAgendaDetalle(), sessionTx);
				//elimina las activ diarias
				eliminaActividadesDiarias(uid, agendaDetalle.getIdAgendaDetalle(), sessionTx);
				altaActividadDetalle(uid, agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getActividades(), sessionTx);
				altaMaterialDetalle(uid, agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getMateriales(), sessionTx);
				altaCoordenadaDetalle(uid, agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getCoordenadas(), sessionTx);
				altaActividadDiaria(uid,agendaDetalle.getIdAgenda() ,agendaDetalle.getIdAgendaDetalle(), agenda.getUsuario(),
						agendaDetalle.getActividades(), sessionTx);
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
 public void modificaAgendaDetalle(String uid, AgendaDetalleDTO agendaDetalle, SqlSession session) throws Exception {
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
 public void eliminaActividades(String uid, int idAgendaDetalle, SqlSession session) throws Exception {
	 HashMap<Object, Object> parametros = new HashMap<Object, Object>();
		parametros.put("id_agenda_detalle", idAgendaDetalle);
	 int registros = session.delete("AgendaDAO.eliminaActividades", parametros);
	 LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
 }
 /**
  * Metodo para eliminar los materiales
  * @param uid unico de registro
  * @param agendaDetalle recibe valores de agenda detalle
  * @param session abre session de BD
  * @throws Exception
  */
 public void eliminaMateriales(String uid, int idAgendaDetalle, SqlSession session) throws Exception {
	 HashMap<Object, Object> parametros = new HashMap<Object, Object>();
		parametros.put("id_agenda_detalle", idAgendaDetalle);
	 int registros = session.delete("AgendaDAO.eliminaMateriales", parametros);
	 LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
 }
 /**
  * Metodo para eliminar los materiales
  * @param uid unico de registro
  * @param agendaDetalle recibe valores de agenda detalle
  * @param session abre session de BD
  * @throws Exception
  */
 public void eliminaCoordenadas(String uid, int idAgendaDetalle, SqlSession session) throws Exception {
	 HashMap<Object, Object> coor = new HashMap<Object, Object>();
		coor.put("agenda_detalle", idAgendaDetalle);
	 int registros = session.delete("AgendaDAO.eliminaAgendaCoordenadas", coor);
	 LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
 }
 /**
  * Metodo para eliminar las actividades diarias
  * @param uid unico de registro
  * @param idAgendaDetalle recibe id de la agenda
  * @param session abre sesion de bd
  * @throws Exception se crea excepcion
  */
 public void eliminaActividadesDiarias(String uid, int idAgendaDetalle, SqlSession session) throws Exception {
	 HashMap<Object, Object> parametros = new HashMap<Object, Object>();
		parametros.put("id_agenda_detalle", idAgendaDetalle);
	 int registros = session.delete("AgendaDAO.eliminaActividadesDiarias", parametros);
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
	/**
	 * Metodo para consultar agenda semanal
	 * @param uid unico de registro
	 * @param agenda recive valores de agenda
	 * @return regresa lista de la agenda semanal
	 * @throws Exception crea una excepcion
	 */
	@SuppressWarnings("unchecked")
	public List<AgendaDTO> consultaAgendaSemanal(String uid, AgendaDTO agenda) throws Exception {
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
			listaConsultaAgenda = sessionNTx.selectList("AgendaDAO.consultaAgendaSemanal", agenda);
			if ( listaConsultaAgenda.size() == 0) {
				throw new ExcepcionesCuadrillas("No existe agendas en esa semana.");
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
