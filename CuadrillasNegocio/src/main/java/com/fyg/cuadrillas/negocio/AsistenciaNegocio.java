package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.AsistenciaDAO;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaDTO;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaRespuesta;

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
		        	if(asistencia.getIdEmpleado() == null) {
		        		throw new ExcepcionesCuadrillas("Es necesario el id del empleado.");
		        	}
		        	if(asistencia.getUsuarioAlta() == null || asistencia.getUsuarioAlta().trim().isEmpty())
		        	{
		        		throw new ExcepcionesCuadrillas("Es necesario el usuario.");
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
					if(asistencia.getIdEmpleado() == null) {
		        		throw new ExcepcionesCuadrillas("Es necesario el id del empleado.");
		        	}
		        	if(asistencia.getUsuarioUltMod() == null || asistencia.getUsuarioUltMod().trim().isEmpty())
		        	{
		        		throw new ExcepcionesCuadrillas("Es necesario el usuario.");
		        	}
		        	AsistenciaDAO  dao = new AsistenciaDAO();
		        	respuesta = dao.salidaAsistencia(uid, asistencia);
				} catch  (ExcepcionesCuadrillas ex) {
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
	/**
	 * Metodo para dar de baja una asistencia
	 * @param asistencia recibe valores de asistencia
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta bajaAsistencia(AsistenciaDTO asistencia) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(asistencia);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "bajaAsistencia - Datos Entrada: " + asistencia);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try { 
			if(asistencia.getIdEmpleado() == null) {
        		throw new ExcepcionesCuadrillas("Es necesario el id del empleado.");
        	}
        	if(asistencia.getUsuarioBaja() == null || asistencia.getUsuarioBaja().trim().isEmpty())
        	{
        		throw new ExcepcionesCuadrillas("Es necesario el usuario para la baja.");
        	}
        	if(asistencia.getUsuarioUltMod() == null || asistencia.getUsuarioUltMod().trim().isEmpty())
        	{
        		throw new ExcepcionesCuadrillas("Es necesario el usuario para la modificacion.");
        	}
        	AsistenciaDAO  dao = new AsistenciaDAO();
        	respuesta = dao.bajaAsistencia(uid, asistencia);
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaAsistencia - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaAsistencia - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaAsistencia - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * Metodo para consultar una lista de asistencia
	 * @return regresa lista de asistencia
	 */
	public AsistenciaRespuesta consultaAsistencia() {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(new String(""));
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "consultaAsistencia - Datos Entrada: ");
				//Variable de resultado
				AsistenciaRespuesta respuesta = new AsistenciaRespuesta();
				respuesta.setHeader( new EncabezadoRespuesta());
				respuesta.getHeader().setUid(uid);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
				List<AsistenciaDTO> listaAsistencia = null;
				 try {
					 listaAsistencia = new AsistenciaDAO().consultaAsistencia(uid);
				    	respuesta.setAsistencia(listaAsistencia);
				    } catch  (ExcepcionesCuadrillas ex) {
						LogHandler.error(uid, this.getClass(), "consultaAsistencia - Error: " + ex.getMessage(), ex);
						respuesta.getHeader().setEstatus(false);
						respuesta.getHeader().setMensajeFuncional(ex.getMessage());
						respuesta.getHeader().setMensajeTecnico(ex.getMessage());
					} catch (Exception ex) {
				    	LogHandler.error(uid, this.getClass(), "consultaAsistencia - Error: " + ex.getMessage(), ex);
				    	respuesta.getHeader().setEstatus(false);
						respuesta.getHeader().setMensajeFuncional(ex.getMessage());
						respuesta.getHeader().setMensajeTecnico(ex.getMessage());
				    }
				    LogHandler.debug(uid, this.getClass(), "consultaAsistencia - Datos Salida: " + respuesta);
					return respuesta;
	}
}
