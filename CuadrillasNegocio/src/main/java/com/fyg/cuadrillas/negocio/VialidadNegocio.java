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
	public VialidadRespuesta consultaVialidad (VialidadDTO vialidad) {
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
					if(vialidad.getLatitud() == null) {
						throw new ExcepcionesCuadrillas("Es necesario la latitud para la busqueda.");
					}
					if (vialidad.getLongitud() == null) {
						throw new ExcepcionesCuadrillas("Es necesario la longitud para la busqueda.");
					}
					if (vialidad.getOrden() == null || vialidad.getOrden().isEmpty()) {
			    		vialidad.setOrden("A");
			    	}
					listaVialidad = new VialidadDAO().consultaVialidad(uid, vialidad);
					respuesta.setVialidad(listaVialidad);
				}catch  (ExcepcionesCuadrillas ex) {
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
}
