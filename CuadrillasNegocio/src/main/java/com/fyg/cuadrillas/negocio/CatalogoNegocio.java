package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.CatalogoDAO;
import com.fyg.cuadrillas.dto.Catalogo;

public class CatalogoNegocio {
	/**
	 * Metodo para la consulta de catalogos
	 * @param catalogoOV recibe valores del catalogo
	 * @return regresa los resultados del catalogo
	 */
	public List<Catalogo> consultarCatalogo(Catalogo catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraNegocio - Daton Entrada: " + catalogoOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Catalogo> listaCatalogo = null;
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
	    	 listaCatalogo = new CatalogoDAO().consultaCatalogo(uid, catalogoOV);
	    	 for (int i = 0; i < listaCatalogo.size(); i++) {
	    		 System.out.println(listaCatalogo.get(i).getCodigo() + listaCatalogo.get(i).getDescripcion());
	    	 }
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
	/**
	 * Metodo para buscar todos los catalogos
	 * @param catalogoOV recibe valores de catalogo
	 * @return regresa un catalogo
	 */
	public List<Catalogo> consultarListaCatalogo(Catalogo catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraNegocio - Daton Entrada: " + catalogoOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Catalogo> listaCatalogo = null;
	    try {
	    	 listaCatalogo = new CatalogoDAO().consultaListaCatalogo(uid, catalogoOV);
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
	
	/**
	 * Metodo que elimina un catalogo
	 * @param catalogoOV recibe valores del catalogo
	 * @return regresa el resultado
	 */
	public EncabezadoRespuesta eliminaCatalogo(Catalogo catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "eliminaCatalogo - Datos Entrada: " + catalogoOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		List<Catalogo> listaCatalogo = null;
		try {
			//Validaciones Negocio
			listaCatalogo = new CatalogoDAO().consultaListaCatalogo(uid, catalogoOV);
			 for (int i = 0; i < listaCatalogo.size(); i++) {
				 if (listaCatalogo.get(i).getEstatus().equals("A")) {
	            		//Mandamos a la parte del dao
					 	  CatalogoDAO dao = new CatalogoDAO();
	          			  respuesta = dao.eliminarCatalogo(uid, catalogoOV);
	            	  } else {
	            		  throw new ExcepcionesCuadrillas("Ya se encuentra inactivo.");
	            	  }
			 }
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "eliminaCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "eliminaCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "eliminaCatalogo - Datos Salida: " + respuesta);
		return respuesta;
}
	/**
	 * Metodo para registrar un catalogo
	 * @param catalogoOV recibe valores de catalogo
	 * @return regresa un resultado
	 */
	public EncabezadoRespuesta registraCatalogo(Catalogo catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraHerramientas - Datos Entrada: " + catalogoOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			//Validaciones Negocio
			if (catalogoOV.getTipoCatalogo() == null || catalogoOV.getTipoCatalogo().isEmpty()) {
				throw new ExcepcionesCuadrillas("El campo tipo catalogo es necesario.");
			} else if (catalogoOV.getCodigo() == null || catalogoOV.getCodigo().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el campo codigo.");
			} else if (catalogoOV.getDescripcion() == null || catalogoOV.getDescripcion().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el campo descripcion.");
			} else if (catalogoOV.getFechaAlta() == null) {
				throw new ExcepcionesCuadrillas("es necesaria la fecha.");
			} else if (catalogoOV.getEstatus() == null || catalogoOV.getEstatus().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario un estatus.");
			} else {
				CatalogoDAO dao = new CatalogoDAO();
    			respuesta = dao.registraCatalogo(uid, catalogoOV);
			}
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "registraCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "registraCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "registraCatalogo - Datos Salida: " + respuesta);
		return respuesta;
}
}
