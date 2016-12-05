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
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Validamos si ya existe un permiso
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existePermiso= (Integer) sessionNTx.selectOne("PermisoLaboralDAO.existePermiso", permiso);
			if (existePermiso > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe un permiso vigente.");
			}
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
			FabricaConexiones.close(sessionNTx);
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
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("autorizacion correcta.");	
		try {
			//Validamos si ya existe una autorizacion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeAutorizacion= (Integer) sessionNTx.selectOne("PermisoLaboralDAO.existeAutorizacion", permiso);
			if (existeAutorizacion > 0) {
				throw new ExcepcionesCuadrillas("Error al autorizar, ya se encuentra autorizado el permiso.");
			}
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
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}
	/**
	 * Metodo para dar de baja un permiso
	 * @param uid unico de registro
	 * @param permiso recibe valores de permiso
	 * @return regresa  una respuesta
	 */
	public EncabezadoRespuesta bajaPermiso(String uid, PermisoLaboralDTO permiso) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("baja correcta.");
		
		try {
			//Validamos si ya esta dado de baja
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeBajaPermiso = (Integer) sessionNTx.selectOne("PermisoLaboralDAO.existeBajaPermiso", permiso);
			if (existeBajaPermiso > 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja, ya se encuentra inactivo.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("PermisoLaboralDAO.bajaPermiso", permiso);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al inhabilitar el permiso.");
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
