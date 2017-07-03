package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaDTO;

public class AsistenciaDAO {
	/**
	 * Metodo para registrar la entrada del empleado
	 * @param uid unico de registro
	 * @param asistencia recibe los valores de asistencia
	 * @return regresa respuesta de registro
	 */
	public EncabezadoRespuesta entradaAsistencia(String uid, AsistenciaDTO asistencia) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Se ha registrado la entrada del empleado correctamente.");
		try {
			//Validamos si el empleado esta activo
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int activoEmpleado = (Integer) sessionNTx.selectOne("AsistenciaDAO.empleadoActivo", asistencia);
			if (activoEmpleado > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar,El usuario no esta activo y no tiene permitido el registro.");
			}
			int existeEntradaAsistencia = (Integer) sessionNTx.selectOne("AsistenciaDAO.consultaHoraAsistencia");
			if (existeEntradaAsistencia > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar,El empleado no puede registrar su entrada 2 veces.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("AsistenciaDAO.entradaAsistencia", asistencia);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("No fue posible registrar la entrada.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		}
		catch (Exception ex) {
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
	 * Metodo para registrar la hora de salida del empleado
	 * @param uid unico de registro
	 * @param asistencia recibe valores de asistencia
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta salidaAsistencia(String uid, AsistenciaDTO asistencia) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Se ha registrado la salida del empleado correctamente..");
		try {
			//Validamos si la hora de entrada ya fue registrada
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeHoraEntrada = (Integer) sessionNTx.selectOne("AsistenciaDAO.consultaHoraAsistencia", asistencia);
			if (existeHoraEntrada <= 0) {
				throw new ExcepcionesCuadrillas("Error al registrar la hora salida, no se ha encontrado la hora entrada.");
			}
			int existeSalidaAsistencia = (Integer) sessionNTx.selectOne("AsistenciaDAO.existeSalidaAsistencia");
			if (existeSalidaAsistencia > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar,El Empleado no puede registrar su salida 2 veces.");
			}
			int activoEmpleado = (Integer) sessionNTx.selectOne("AsistenciaDAO.empleadoActivo", asistencia);
			if (activoEmpleado > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar,El usuario no esta activo y no tiene permitido el registro.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("AsistenciaDAO.salidaAsistencia", asistencia);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("No fue posible registrar la salida.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		}
		catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!");
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
			FabricaConexiones.close(sessionTx);
		}
		return respuesta;
	}
	/**
	 * Metodo para dar de baja una asistencia
	 * @param uid unico de registro
	 * @param asistencia recibe valores de la asistencia
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta bajaAsistencia(String uid, AsistenciaDTO asistencia) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Se ha realizado la baja de la asistencia correctamente.");

		try {
			//Validamos si la hora de entrada ya fue registrada
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeBajaAsistencia = (Integer) sessionNTx.selectOne("AsistenciaDAO.existeBajaAsistencia");
			if (existeBajaAsistencia > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar,El Empleado no puede registrar su baja 2 veces.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("AsistenciaDAO.bajaAsistencia", asistencia);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("No fue posible dar la baja.");
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
	 * Metodo para consultar lista de Asistencia
	 * @param uid unico de registro
	 * @param asistencia recibe valores de asistencia
	 * @return regresa lista de asistencia
	 * @throws Exception crea una excepcion
	 */
	@SuppressWarnings("unchecked")
	public List<AsistenciaDTO> consultaAsistencia(String uid, AsistenciaDTO asistencia) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta asistencia correcta.");
		List<AsistenciaDTO> listaAsistencia = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.debug(uid, this.getClass(), "Consultando");
			//Se hace una consulta a la tabla contacto
			listaAsistencia = sessionNTx.selectList("AsistenciaDAO.consultaAsistencia", asistencia);
			if ( listaAsistencia.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen registros de asistencia.");
			}
			for ( AsistenciaDTO a : listaAsistencia) {
				if ( a.getHoraEntrada() == null) {
					a.setsHoraEntrada(" ");
				} else {
					a.setsHoraEntrada(a.getHoraEntrada().toString());
				}
				if ( a.getHoraSalida() == null) {
					a.setsHoraSalida(" ");
				} else {
					a.setsHoraSalida(a.getHoraSalida().toString());
				}
				if ( a.getComentarios() == null) {
					a.setComentarios(" ");
				}
			}
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaAsistencia;
	}
}
