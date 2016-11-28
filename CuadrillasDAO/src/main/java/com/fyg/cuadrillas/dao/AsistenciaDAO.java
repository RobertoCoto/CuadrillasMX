package com.fyg.cuadrillas.dao;

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
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro de entrada correcto.");
		
		try {
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
		respuesta.setMensajeFuncional("actualización salida correcta.");
		
		try { 
			//Validamos si la hora de entrada ya fue registrada
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeHoraEntrada= (Integer) sessionNTx.selectOne("AsistenciaDAO.consultaHoraAsistencia", asistencia);
			if (existeHoraEntrada > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar la hora salida, no se ha encontrado la hora entrada.");
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
			FabricaConexiones.close(sessionTx);
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}

}
