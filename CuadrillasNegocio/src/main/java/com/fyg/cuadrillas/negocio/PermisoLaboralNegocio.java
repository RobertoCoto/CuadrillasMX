package com.fyg.cuadrillas.negocio;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.PermisoLaboralDAO;
import com.fyg.cuadrillas.dto.empleado.PermisoLaboralDTO;


public class PermisoLaboralNegocio {
	/**
	 * Metodo para dar de alta el permiso
	 * @param permiso recibe valores de permiso
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta altaPermiso(PermisoLaboralDTO permiso) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(permiso);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "altaPermiso - Datos Entrada: " + permiso);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		
		try {
			if (permiso.getIdEmpleado() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id del empleado.");
			}
			if (permiso.getTipoPermiso() == null || permiso.getTipoPermiso().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el tipo de permiso.");
			}
			if (permiso.getUsuarioAlta() == null || permiso.getUsuarioAlta().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario.");
			}
			PermisoLaboralDAO dao = new PermisoLaboralDAO();
			respuesta = dao.altaPermiso(uid, permiso);
			
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "altaPermiso - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "altaPermiso - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "altaPermiso - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * Metodo para autorizar el permiso
	 * @param permiso recibe valores de permiso
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta autorizacionPermiso(PermisoLaboralDTO permiso) {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(permiso);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "autorizacionPermiso - Datos Entrada: " + permiso);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (permiso.getIdPermiso() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el id del permiso.");
					}
					if (permiso.getIdEmpleado() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el id del empleado.");
					}
					if (permiso.getUsuarioAutorizacion() == null || permiso.getUsuarioAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario.");
					}
					if (permiso.getComentarios() == null || permiso.getComentarios().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario un comentario.");
					}
					PermisoLaboralDAO dao = new PermisoLaboralDAO();
					respuesta = dao.autorizacionPermiso(uid, permiso);
					
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "autorizacionPermiso - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "autorizacionPermiso - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "autorizacionPermiso - Datos Salida: " + respuesta);
				return respuesta;
	}
	/**
	 * Metodo para dar de baja un permiso
	 * @param permiso recibe valores de permiso
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta bajaPermiso(PermisoLaboralDTO permiso) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(permiso);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "bajaPermiso - Datos Entrada: " + permiso);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try { 
			if (permiso.getIdPermiso() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id del permiso.");
			}
			if (permiso.getIdEmpleado() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id del empleado.");
			}
			if(permiso.getUsuarioBaja() == null || permiso.getUsuarioBaja().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario.");
			}
			PermisoLaboralDAO dao = new PermisoLaboralDAO();
			respuesta = dao.bajaPermiso(uid, permiso);
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaPermiso - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaPermiso - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaPermiso - Datos Salida: " + respuesta);
		return respuesta;
	}
}
