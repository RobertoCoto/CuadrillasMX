package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.CatalogoDAO;
import com.fyg.cuadrillas.dto.catalogo.CatalogoDTO;
import com.fyg.cuadrillas.dto.catalogo.CatalogoRespuesta;
import com.fyg.cuadrillas.dto.catalogo.TipoCatalogoDTO;
import com.fyg.cuadrillas.dto.catalogo.TipoCatalogoRespuesta;

public class CatalogoNegocio {

	/** The LONGITUD_CODIGO_CATALOGO. */
	private static final  int LONGITUD_CODIGO_CATALOGO = 10;
	/** The LONGITUD_DESCRIPCION_CATALOGO. */
	private static final  int LONGITUD_DESCRIPCION_CATALOGO = 100;

	/**
	 * Metodo para la consulta de catalogos
	 * @param catalogoOV recibe valores
	 * @return regresa los resultados del catalogo
	 */
	public TipoCatalogoRespuesta consultarTipoCatalogos() {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(new String(""));
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultarTipoCatalogos - Daton Entrada: ");
		//Variable de resultado
		TipoCatalogoRespuesta respuesta = new TipoCatalogoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");

		List<TipoCatalogoDTO> listaTipoCatalogo = null;
	    try {
	    	listaTipoCatalogo = new CatalogoDAO().consultaTipoCatalogos(uid);
	    	respuesta.setCatalogo(listaTipoCatalogo);
	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "consultarTipoCatalogos - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "consultarTipoCatalogos - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultarTipoCatalogos - Datos Salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo para la consulta de catalogos
	 * @param catalogoOV recibe valores del catalogo
	 * @return regresa los resultados del catalogo
	 */
	public CatalogoRespuesta consultarCatalogo(CatalogoDTO catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultarCatalogo - Daton Entrada: " + catalogoOV);
		//Variable de resultado
		CatalogoRespuesta respuesta = new CatalogoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");

		List<CatalogoDTO> listaCatalogo = null;
	    try {
	    	//validaciones
	    	if (catalogoOV.getTipoCatalogo() == null || catalogoOV.getTipoCatalogo().trim().isEmpty()) {
	    		System.out.println("ERROR");
	    		throw new ExcepcionesCuadrillas("Es necesario el tipo catalogo para la busqueda.");
	    	}
	    	if (catalogoOV.getOrden() == null || catalogoOV.getOrden().isEmpty()) {
	    		catalogoOV.setOrden("A");
	    	}

	    	listaCatalogo = new CatalogoDAO().consultaCatalogo(uid, catalogoOV);
	    	respuesta.setCatalogo(listaCatalogo);
	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "ConsultaCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "consultarCatalogo - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultarCatalogo - Datos Salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo para registrar un catalogo
	 * @param catalogoOV recibe valores de catalogo
	 * @return regresa un resultado
	 */
	public EncabezadoRespuesta registraCatalogo(CatalogoDTO catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraCatalogo - Datos Entrada: " + catalogoOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			//Validaciones Negocio
			if (catalogoOV.getTipoCatalogo() == null || catalogoOV.getTipoCatalogo().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El campo tipo catalogo es necesario.");
			}
			if (catalogoOV.getCodigo() == null || catalogoOV.getCodigo().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el campo codigo.");
			}
			if (catalogoOV.getDescripcion() == null || catalogoOV.getDescripcion().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el campo descripcion.");
			}
			if (catalogoOV.getCodigo().length() > LONGITUD_CODIGO_CATALOGO) {
				throw new ExcepcionesCuadrillas("El codigo del catalogo puede ser maximo de 10 caracteres.");
			}
			if (catalogoOV.getCodigo().length() > LONGITUD_CODIGO_CATALOGO) {
				throw new ExcepcionesCuadrillas("El codigo del catalogo NO puede ser maximo de "
						+ LONGITUD_CODIGO_CATALOGO + " caracteres.");
			}
			if (catalogoOV.getCodigo().contains(" ")) {
				throw new ExcepcionesCuadrillas("El codigo del catalogo NO puede tener espacios.");
			}
			if (catalogoOV.getDescripcion().length() > LONGITUD_DESCRIPCION_CATALOGO) {
				throw new ExcepcionesCuadrillas("La descripcion del catalogo NO puede ser maximo de "
						+ LONGITUD_DESCRIPCION_CATALOGO + " caracteres.");
			}
			CatalogoDAO dao = new CatalogoDAO();
			respuesta = dao.registraCatalogo(uid, catalogoOV);
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

	/**
	 * Metodo que elimina un catalogo
	 * @param catalogoOV recibe valores del catalogo
	 * @return regresa el resultado
	 */
	public EncabezadoRespuesta eliminaCatalogo(CatalogoDTO catalogoOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(catalogoOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "eliminaCatalogo - Datos Entrada: " + catalogoOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		List<CatalogoDTO> listaCatalogo = null;
		try {
			//Validaciones Negocio
			//listaCatalogo = new CatalogoDAO().consultaListaCatalogo(uid, catalogoOV);
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

}
