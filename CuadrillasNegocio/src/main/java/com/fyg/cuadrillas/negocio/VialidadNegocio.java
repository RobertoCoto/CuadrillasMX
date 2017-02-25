package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.VialidadDAO;
import com.fyg.cuadrillas.dto.vialidad.VialidadDTO;
import com.fyg.cuadrillas.dto.vialidad.VialidadRespuesta;

public class VialidadNegocio {
/**
 * Metodo para consultar la vialidad
 * @param vialidad recibe valores de vialidad
 * @return regresa un resultado
 */
	public VialidadRespuesta consultaVialidad(VialidadDTO vialidad) {
		       //Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(vialidad);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "consultaVialidad - Datos Entrada: " + vialidad);
				//Variable de resultado
				VialidadRespuesta respuesta = new VialidadRespuesta();
				respuesta.setHeader( new EncabezadoRespuesta());
				respuesta.getHeader().setUid(uid);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
				List<VialidadDTO> listaVialidad = null;
				try {
					if (vialidad.getOrden() == null || vialidad.getOrden().isEmpty()) {
			    		vialidad.setOrden("A");
			    	}
					listaVialidad = new VialidadDAO().consultaVialidad(uid, vialidad);
					respuesta.setVialidad(listaVialidad);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "consultaVialidad - Error: " + ex.getMessage(), ex);
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
				} catch (Exception ex) {
			    	LogHandler.error(uid, this.getClass(), "consultaVialidad - Error: " + ex.getMessage(), ex);
			    	respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			    }
			    LogHandler.debug(uid, this.getClass(), "consultaVialidad - Datos Salida: " + respuesta);
				return respuesta;
	}
	/**
	 * Metodo para registrar vialidades
	 * @param vialidad recibe valores de vialidad
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta altaVialidad(VialidadDTO vialidad) {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(vialidad);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "altaVialidad - Datos Entrada: " + vialidad);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (vialidad.getNombre() == null || vialidad.getNombre().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el nombre de la vialidad.");
					}
					if (vialidad.getCoordenadas().size() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario las coordenadas para la vialidad.");
					}
					VialidadDAO dao = new VialidadDAO();
					respuesta = dao.altaVialidad(uid, vialidad);
				} catch (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "altaVialidad - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "altaVialidad - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "altaVialidad - Datos Salida: " + respuesta);
				return respuesta;
	}
	/**
	 * Metodo para dar de baja una vialidad
	 * @param vialidad recibe valores de vialidad
	 * @return regresa una repsuesta
	 */
	public EncabezadoRespuesta eliminaVialidad(VialidadDTO  vialidad) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(vialidad);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "eliminaVialidad - Datos Entrada: " + vialidad);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (vialidad.getIdVialidad() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id de la vialidad.");
			}
			VialidadDAO dao = new VialidadDAO();
			respuesta = dao.bajaVialidad(uid, vialidad);
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "altaVialidad - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "altaVialidad - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "altaVialidad - Datos Salida: " + respuesta);
		return respuesta;
	}
}
