package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.dao.ConsultasCuadrillasDAO;
import com.fyg.cuadrillas.dto.Catalogos;

public class ConsultasCuadrillasNegocio {

	/**
	 * Metodo para la consulta de catalogos
	 * @param catalogoOV recibe valores del catalogo
	 * @return regresa los resultados del catalogo
	 */
	public List<Catalogos> consultarCatalogo(Catalogos catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraNegocio - Daton Entrada: " + catalogoOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Catalogos> listaCatalogo = null;
	    try {
	    	//validaciones
	    	 if (catalogoOV.getOrden() == null || catalogoOV.getOrden().isEmpty()) {
	    		 throw new ExcepcionesCuadrillas("Es necesario un orden para la busqueda.");
	    	} else if (catalogoOV.getEstatus() == null || catalogoOV.getEstatus().isEmpty()) {
	    		throw new ExcepcionesCuadrillas("Es Necesario el estatus para la busqueda.");
	    	} else if (catalogoOV.getEstatus().equals("I"))
	    	{
	    		throw new ExcepcionesCuadrillas("Solo es permitido estatus activo.");
	    	}
	    	 listaCatalogo = new ConsultasCuadrillasDAO().consultaCatalogo(uid, catalogoOV);
	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "ConsultaCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "ParametrosNegocio - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaNegocio - Datos Salida: " + respuesta);
		return listaCatalogo;
	}
}
