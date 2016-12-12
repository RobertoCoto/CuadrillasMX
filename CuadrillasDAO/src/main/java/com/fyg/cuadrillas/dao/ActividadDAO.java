package com.fyg.cuadrillas.dao;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDTO;

public class ActividadDAO {
	/**
	 * Metodo para registrar la actividad diaria
	 * @param uid unico de registro
	 * @param actividad recibe los valores e actividad
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta registraActividad(String uid, ActividadDTO actividad) {
		SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("ActividadDAO.registraActividad", actividad);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("No fue posible registrar la actividad diaria.");
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
	 * Metodo para autorizar una actividad diaria
	 * @param uid unico de registro
	 * @param actividad recibe valores de actividad
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta autorizaActividad (String uid, ActividadDTO actividad) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("autorización correcta.");
		
		try {
			//Validamos si ya esta autorizado la actividad
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeAutorizacion= (Integer) sessionNTx.selectOne("ActividadDAO.existeActividad", actividad);
			if (existeAutorizacion > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, la actividad esta autorizada.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("ActividadDAO.autorizaActividad", actividad);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al autorizar la actividad.");
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
}
