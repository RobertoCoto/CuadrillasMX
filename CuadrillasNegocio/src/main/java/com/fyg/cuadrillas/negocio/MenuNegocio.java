package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.MenuDAO;
import com.fyg.cuadrillas.dto.MenuDTO;


public class MenuNegocio {
	public List<MenuDTO> consultarMenu(MenuDTO menu) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(menu);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraNegocio - Daton Entrada: " + menu);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<MenuDTO> listaMenus = null;
	    try {
	    	
	    	 listaMenus = new MenuDAO().consultaCatalogo(uid, menu);
	    	 
	    }  catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "ParametrosNegocio - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaNegocio - Datos Salida: " + respuesta);
		return listaMenus;
	}
}
