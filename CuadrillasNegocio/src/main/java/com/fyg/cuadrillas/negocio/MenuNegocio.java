package com.fyg.cuadrillas.negocio;

import java.util.ArrayList;
import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.MenuDAO;
import com.fyg.cuadrillas.dto.menu.MenuDTO;
import com.fyg.cuadrillas.dto.menu.MenuRespuesta;


public class MenuNegocio {

	/**
	 * Metodo para validar el login y traer el menu
	 * @param uid identificador unico
	 * @param idPerfil ide del perfil para cargar el menu
	 * @return menu
	 */
	public MenuRespuesta consultarMenuIdPerfil(String uid, Integer idPerfil) {
		MenuRespuesta respuesta = new MenuRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		LogHandler.debug(uid, this.getClass(), "consultarMenuIdPerfil - Datos Entrada: " + idPerfil);
		List<MenuDTO> listaMenu = null;
		try {
	    	 listaMenu = new MenuDAO().consultaMenu(uid, idPerfil);

	    	 if ( listaMenu.size() == 0) {
	    		 throw new Exception("No existe configurado menu para el perfil solicitado.");
	    	 }

	    	 List<MenuDTO> listaRespuesta = new ArrayList<MenuDTO>();

	    	 for ( MenuDTO menu : listaMenu) {
	    		 //LogHandler.debug(uid, this.getClass(), "******* ");
	    		 //LogHandler.debug(uid, this.getClass(), "MENU * " + menu);
	    		 if (menu.getIdPadre() == null) {
	    			 LogHandler.debug(uid, this.getClass(), "***AGREGAR PADRE**** ");
	    			 MenuDTO menuPadre = new MenuDTO();
	    			 menuPadre.setDescripcion(menu.getDescripcion());
	    			 menuPadre.setMenu(menu.getMenu());
	    			 menuPadre.setUrl("");
	    			 menuPadre.setIdMenu(menu.getIdMenu());
	    			 menuPadre.setIdPadre(menu.getIdPadre());
	    			 menuPadre.setHijos(new ArrayList<MenuDTO>());
	    			 for ( MenuDTO posiblesHijo : listaMenu) {
	    				 //LogHandler.debug(uid, this.getClass(), "MENU PADRE " + menuPadre);
	    				 //LogHandler.debug(uid, this.getClass(), "MENU HIJO " + posiblesHijo);
	    				 if (posiblesHijo.getIdPadre() != null) {

		    				 if (menu.getIdMenu().intValue() == posiblesHijo.getIdPadre().intValue() ) {
		    					 MenuDTO menuHijo = new MenuDTO();
		    					 menuHijo.setDescripcion(posiblesHijo.getDescripcion());
		    					 menuHijo.setMenu(posiblesHijo.getMenu());
		    					 menuHijo.setUrl(posiblesHijo.getUrl());
		    					 menuHijo.setIdMenu(posiblesHijo.getIdMenu());
		    					 menuHijo.setIdPadre(posiblesHijo.getIdPadre());
		    					 menuPadre.getHijos().add(menuHijo);
		    				 }
	    				 }
	    			 }
	    			 listaRespuesta.add(menuPadre);
	    		 }
	    	 }

	    	 LogHandler.debug(uid, this.getClass(), "consultarMenuIdPerfil - Datos Salida: " + listaRespuesta);
	    	 respuesta.setMenu(listaRespuesta);
	    }  catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "MenuNegocio - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultarMenuIdPerfil - Datos Salida: " + respuesta);
		return respuesta;
	}
}
