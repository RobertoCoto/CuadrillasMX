package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.MenuDAO;
import com.fyg.cuadrillas.dto.menu.MenuDTO;
import com.fyg.cuadrillas.dto.menu.MenuRespuesta;


public class MenuNegocio {
	public MenuRespuesta consultarMenu(MenuDTO menu) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(menu);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "MenuNegocio - Datos Entrada: " + menu);
		//Variable de resultado
		MenuRespuesta respuesta = new MenuRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		List<MenuDTO> listaMenu = null;
	    try {
	    	
	    	 listaMenu = new MenuDAO().consultaMenu(uid, menu);
	    	 respuesta.setMenu(listaMenu);
	    }  catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "MenuNegocio - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "MenuNegocio - Datos Salida: " + respuesta);
		return respuesta;
	}
}
