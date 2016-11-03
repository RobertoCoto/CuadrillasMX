package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.dto.Parametros;
import com.fyg.cuadrillas.dao.ConsultaParametro;
public class ParametrosNegocio {

	/**
	 * Metodo para consultar parametros
	 * @param parametro recibe valores de parametros
	 * @return regresa el valor del parametro
	 */
	public List<Parametros> consultaParametro(Parametros parametro) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(parametro);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraNegocio - Daton Entrada: " + parametro);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Parametros> listaParametro = null;
	    try {
	    	//validaciones
	    	if (parametro.getParametro() == null || parametro.getParametro().isEmpty()) {
	    		throw new ExcepcionesCuadrillas("Es necesario un parametro.");
	    	} else {
	    		listaParametro = new ConsultaParametro().consultaParametro(uid, parametro);
	    		 for (int i = 0; i < listaParametro.size(); i++) {
	    			 if (listaParametro.get(i).getParametro() == null || listaParametro.get(i).getParametro().isEmpty()) {
	    				 throw new ExcepcionesCuadrillas("No existe el parametro en la BD.");
	    			 }
	    			 LogHandler.debug(uid, this.getClass(), "El valor del parametro es: " + listaParametro.get(i).getValor());
	    			}
	    	}
	    } catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "ParametrosNegocio - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaNegocio - Datos Salida: " + respuesta);
		return listaParametro;
	}

}
