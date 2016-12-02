package com.fyg.cuadrillas.negocio;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.CuadrillaDAO;
import com.fyg.cuadrillas.dto.cuadrilla.CuadrillaDTO;

public class CuadrillaNegocio {

	/**
	 * Metodo para dar de alta una cuadrilla
	 * @param cuadrilla
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta altaCuadrilla(CuadrillaDTO cuadrilla) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(cuadrilla);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "altaCuadrilla - Datos Entrada: " + cuadrilla);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try { 
			if (cuadrilla.getNombreCuadrilla() == null || cuadrilla.getNombreCuadrilla().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el nombre de la cuadrilla.");
			}
			if (cuadrilla.getNumeroPersonas() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el numero de personas.");
			}
			if (cuadrilla.getCalificacion() == null) {
				throw new ExcepcionesCuadrillas("Es necesario la calificación.");
			}
			if (cuadrilla.getDireccionInicial() == null || cuadrilla.getDireccionInicial().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario la direccion inicial.");
			}
			if (cuadrilla.getDireccionFinal() == null || cuadrilla.getDireccionFinal().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario la direccion Final.");
			}
			CuadrillaDAO dao = new CuadrillaDAO();
			respuesta = dao.altaCuadrilla(uid, cuadrilla);
			
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "altaCuadrilla - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "altaCuadrilla - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "altaCuadrilla - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * Metodo para dar de baja una cuadrilla
	 * @param cuadrilla recibe valores de cuadrillas
	 * @return regrea una respuesta
	 */
	public EncabezadoRespuesta bajaCuadrilla (CuadrillaDTO cuadrilla) {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(cuadrilla);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "bajaCuadrilla - Datos Entrada: " + cuadrilla);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				
				try {
					if (cuadrilla.getIdCuadrilla() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el id de la cuadrilla para la baja.");
					}
					CuadrillaDAO dao = new CuadrillaDAO();
					respuesta = dao.bajaCuadrilla(uid, cuadrilla);
				}
				catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "bajaCuadrilla - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "bajaCuadrilla - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "bajaCuadrilla - Datos Salida: " + respuesta);
				return respuesta;
	}
}
