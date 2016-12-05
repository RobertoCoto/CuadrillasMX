package com.fyg.cuadrillas.dao;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.empleado.PermisoLaboralDTO;

public class PermisoLaboralDAO {
	/**
	 * Metodo para dar de alta el permiso.
	 * @param uid unico de registro
	 * @param permiso recibe valores de permiso
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta altaPermiso(String uid, PermisoLaboralDTO permiso) {
		SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("PermisoLaboralDAO.altaPermiso", permiso);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al registrar el permiso.");
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
	 * Metodo para autorizar el permiso
	 * @param uid unico de registro
	 * @param permiso recibe valores de permiso
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta autorizacionPermiso(String uid, PermisoLaboralDTO permiso) {
		SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("autorizacion correcta.");	
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("PermisoLaboralDAO.autorizaPermiso", permiso);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al autorizar el permiso.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		}catch (Exception ex) {
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
}
