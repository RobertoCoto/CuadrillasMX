package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.dto.ParametroDTO;
import com.fyg.cuadrillas.dao.ParametroDAO;
public class ParametroNegocio {

	/**
	 * Metodo para consultar parametros
	 * @param parametro recibe valores de parametros
	 * @return regresa el valor del parametro
	 * @throws ExcepcionesCuadrillas, Exception 
	 */
	public  String consultaParametro(String uid, String parametro) throws ExcepcionesCuadrillas, Exception {
		
		LogHandler.debug(uid, this.getClass() , "ConsultaParametros - Datos Entrada: " + parametro);		
		String valor = null;
	    try {
	    	//validaciones
	    	if (parametro == null || parametro.trim().isEmpty()) {
	    		throw new ExcepcionesCuadrillas("Es necesario un parametro.");
	    	} 
	    		
	    	valor = new ParametroDAO().consultaParametro(uid, parametro);	    		 
	    	
	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "ConsultaParametro - Error: " + ex.getMessage(), ex);
			throw new ExcepcionesCuadrillas(ex.getMessage());
			
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "ParametrosNegocio - Error: " + ex.getMessage(), ex);
	    	throw new Exception(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaParametros - Datos Salida: " + valor);
		return valor; 
	}

}
