package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.PermisoLaboralDAO;
import com.fyg.cuadrillas.dto.empleado.PermisoLaboralDTO;
import com.fyg.cuadrillas.dto.empleado.PermisoLaboralRespuesta;


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
	/**
	 * Metodo para consultar permiso temporal
	 * @param permiso recibe valores de permiso
	 * @return regresa respuesta
	 */
	public PermisoLaboralRespuesta consultaPermisoTemporal(PermisoLaboralDTO permiso) {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(permiso);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "consultaPermisoTemporal - Datos Entrada: " + permiso);
				//Variable de resultado
				PermisoLaboralRespuesta respuesta = new PermisoLaboralRespuesta();
				respuesta.setHeader( new EncabezadoRespuesta());
				respuesta.getHeader().setUid(uid);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
				List<PermisoLaboralDTO> listaPermiso = null;
				try {
					if(permiso.getIdEmpleado() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el id del empleado para la busqueda.");
					}
					listaPermiso = new PermisoLaboralDAO().consultaPermisoTemporal(uid, permiso);
					respuesta.setPermiso(listaPermiso);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "ConsultaEmpleado - Error: " + ex.getMessage(), ex);			
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
				} catch (Exception ex) {
			    	LogHandler.error(uid, this.getClass(), "ConsultaEmpleado - Error: " + ex.getMessage(), ex);
			    	respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			    }
			    LogHandler.debug(uid, this.getClass(), "consultaEmpleado - Datos Salida: " + respuesta);
			    return respuesta;
	}
}
