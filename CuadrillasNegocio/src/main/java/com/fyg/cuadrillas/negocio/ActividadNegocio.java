package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.ActividadDAO;
import com.fyg.cuadrillas.dto.actividad.ActividadDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadRespuesta;

public class ActividadNegocio {
	/**
	 * Metodo para registrar una actividad
	 * @param actividad recibe valores de la actividad
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta registraActividad (ActividadDTO actividad) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(actividad);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraActividad - Datos Entrada: " + actividad);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (actividad.getIdCuadrilla() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id de la cuadrilla.");
			}
			if (actividad.getTramoInicialPlanificado() == null || actividad.getTramoInicialPlanificado().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el tramo inicial.");
			}
			if (actividad.getTramoFinalPlanificado() == null || actividad.getTramoFinalPlanificado().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el tramo final.");
			}
			if (actividad.getTramoInicialReal() == null || actividad.getTramoInicialReal().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el tramo inicial real.");
			}
			if (actividad.getTramoFinalReal() == null || actividad.getTramoFinalReal().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el tramo final real.");
			}
			if (actividad.getActividad() == null || actividad.getActividad().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario la actividad a realizarse.");
			}
			if (actividad.getPrioridad() == null || actividad.getPrioridad().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario la prioridad de la actividad.");
			}
			if (actividad.getEstado() == null || actividad.getEstado().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario especificar el estado de la actividad.");
			}
			if (actividad.getTiempoEstimado() == null) {
				throw new ExcepcionesCuadrillas("Es necesario especificar el tiempo asignado.");
			}
			if (actividad.getNumeroPersonas() == null) {
				throw new ExcepcionesCuadrillas("Es necesario especificar el numero de personas.");
			}
			if (actividad.getNumeroUnidades()== null) {
				throw new ExcepcionesCuadrillas("Es necesario especificar el numero de unidades.");
			}
			if (actividad.getListoVencido() == null || actividad.getListoVencido().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario especificar si esta listo o vencido la actividad.");
			}
			if (actividad.getObservacionesActividades() == null || actividad.getObservacionesActividades().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario las observaciones a esta actividad.");
			}
			ActividadDAO dao = new ActividadDAO();
			respuesta = dao.registraActividad(uid, actividad);
			
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "registraActividad - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "registraActividad - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "registraActividad - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * metodo para autorizar una actividad
	 * @param actividad recibe valores de actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta autorizaActividad (ActividadDTO actividad) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(actividad);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "autorizaActividad - Datos Entrada: " + actividad);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				
				try {
					if (actividad.getAutorizacion() == null || actividad.getAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario especificar la autorizacion.");	
					}
					if (actividad.getIdActividad() == null) {
						throw new ExcepcionesCuadrillas("Es necesario especificar el id de la actividad.");
					}
					if (actividad.getIdCuadrilla() == null) {
						throw new ExcepcionesCuadrillas("Es necesario especificar el id de la cuadrilla.");
					}
					if(actividad.getUsuarioAutorizacion() == null || actividad.getUsuarioAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario especificar el usuario que autoriza.");
					}
					ActividadDAO dao = new ActividadDAO();
					respuesta = dao.autorizaActividad(uid, actividad);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "autorizaActividad - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "autorizaActividad - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "autorizaActividad - Datos Salida: " + respuesta);
				return respuesta;
	}
	/**
	 * metodo para dar de baja actividad
	 * @param actividad recibe valores d actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta bajaActividad(ActividadDTO actividad) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(actividad);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "bajaActividad - Datos Entrada: " + actividad);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		
		try {
			if (actividad.getIdActividad() == null) {
				throw new ExcepcionesCuadrillas("Es necesario especificar el id de la actividad.");
			}
			if (actividad.getIdCuadrilla() == null) {
				throw new ExcepcionesCuadrillas("Es necesario especificar el id de la cuadrilla.");
			}
			if(actividad.getUsuarioBaja() == null || actividad.getUsuarioBaja().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario especificar el usuario.");
			}
			ActividadDAO dao = new ActividadDAO();
			respuesta = dao.bajaActividad(uid, actividad);
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaActividad - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaActividad - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaActividad - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * metodo para consultar las actividades
	 * @param actividad resibe valores de actividad
	 * @return regresa respuesta
	 */
	public ActividadRespuesta consultaActividad (ActividadDTO actividad) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(actividad);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaActividad - Datos Entrada: " + actividad);
		//Variable de resultado
		ActividadRespuesta respuesta = new ActividadRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		List<ActividadDTO> listaActividad = null;
		try {
			if(actividad.getIdCuadrilla() == null)
	    	{
	    		throw new ExcepcionesCuadrillas("Es necesario el id de la cuadrilla para la busqueda.");
	    	}
			listaActividad = new ActividadDAO().consultaActividad(uid, actividad);
			respuesta.setActividad(listaActividad);
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "consultaActividad - Error: " + ex.getMessage(), ex);			
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "consultaActividad - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaActividad - Datos Salida: " + respuesta);
	    return respuesta;
	}
}
