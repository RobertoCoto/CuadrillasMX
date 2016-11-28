package com.fyg.cuadrillas.negocio;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.AsistenciaDAO;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaDTO;

public class AsistenciaNegocio {
	/**
	 * Metodo para registrar la entrada del empleado
	 * @param asistencia recibe valores de asistencia
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta entradaAsistencia(AsistenciaDTO asistencia) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(asistencia);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "entradaAsistencia - Datos Entrada: " + asistencia);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		        try {
		        	if(asistencia.getNombres() == null || asistencia.getNombres().trim().isEmpty()) {
		        		throw new ExcepcionesCuadrillas("Es necesario el campo nombres.");
		        	}
		        	if(asistencia.getPuesto() == null || asistencia.getPuesto().trim().isEmpty()) {
		        		throw new ExcepcionesCuadrillas("Es necesario el campo puesto.");
		        	}
		        	AsistenciaDAO  dao = new AsistenciaDAO();
		        	respuesta = dao.entradaAsistencia(uid, asistencia);
		        	
		        }catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "entradaAsistencia - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "entradaAsistencia - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "entradaAsistencia - Datos Salida: " + respuesta);
				return respuesta;
	}
	/**
	 * Metodo para registrar la salida del empleado
	 * @param asistencia recibe valores de asistencia
	 * @return regresa una respuesta 
	 */
	public EncabezadoRespuesta salidaAsistencia (AsistenciaDTO asistencia) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(asistencia);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "salidaAsistencia - Datos Entrada: " + asistencia);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if(asistencia.getNombres() == null || asistencia.getNombres().trim().isEmpty()) {
		        		throw new ExcepcionesCuadrillas("Es necesario el campo nombres.");
		        	}
		        	if(asistencia.getPuesto() == null || asistencia.getPuesto().trim().isEmpty()) {
		        		throw new ExcepcionesCuadrillas("Es necesario el campo puesto.");
		        	}
		        	AsistenciaDAO  dao = new AsistenciaDAO();
		        	respuesta = dao.salidaAsistencia(uid, asistencia);
					
				}catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "salidaAsistencia - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "salidaAsistencia - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "salidaAsistencia - Datos Salida: " + respuesta);
				return respuesta;
	}
}
