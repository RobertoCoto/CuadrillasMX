package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.HerramientasDAO;
import com.fyg.cuadrillas.dto.Herramientas;

public class HerramientasNegocio {
	/**
	 * Metodo para consultar herramientas
	 * @param herramientaOV recibe valores de herramientas
	 * @return regresa lista de herramientas
	 */
	public List<Herramientas> consultarHerramientas(Herramientas herramientaOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(herramientaOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "herramientaOV -  Entrada: " + herramientaOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Herramientas> listaHerramientas = null;
	    try {
	    	 listaHerramientas = new HerramientasDAO().consultaHerramientas(uid, herramientaOV);
	    } catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "herramientaOV - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "herramientaOV - Datos Salida: " + respuesta);
		return listaHerramientas;
	}
	public EncabezadoRespuesta registraHerramientas(Herramientas herramientaOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(herramientaOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraHerramientas - Datos Entrada: " + herramientaOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			//Validaciones Negocio
		if(herramientaOV.getNombre() == null || herramientaOV.getNombre().isEmpty()) { 
			throw new ExcepcionesCuadrillas("El campo nombre es necesario.");
		} else if(herramientaOV.getDescripcion() == null || herramientaOV.getDescripcion().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo descripcion es necesario.");
		} else if (herramientaOV.getCodigo_tipo_combustible() ==  null || herramientaOV.getCodigo_tipo_combustible().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo codigo tipo combustible es necesario.");
		} else if (herramientaOV.getCodigo_tipo_articulo() == null || herramientaOV.getCodigo_tipo_articulo().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo codigo tipo articulo es necesario.");
		} else if (herramientaOV.getCodigo_estado() == null || herramientaOV.getCodigo_estado().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo codigo estado es necesario.");
		} else if (herramientaOV.getMantenimiento() == null || herramientaOV.getMantenimiento().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo mantenimiento es necesario.");
		} else {
			HerramientasDAO dao = new HerramientasDAO();
			respuesta = dao.registraHerramientas(uid, herramientaOV);
		}
			}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "registraHerramientas - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "registraHerramientas - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "registraHerramientas - Datos Salida: " + respuesta);
		return respuesta;
}
	/**
	 * Metodo para dar de baja una herramienta
	 * @param herramientaOV
	 * @return
	 */
	public EncabezadoRespuesta eliminaHerramientas(Herramientas herramientaOV) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(herramientaOV);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraSitio - Daton Entrada: " + herramientaOV);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		List<Herramientas> listaHerramientas = null;
		try {
			//Validaciones Negocio
			listaHerramientas = new HerramientasDAO().consultaListaHerramientas(uid, herramientaOV);
			 for (int i = 0; i < listaHerramientas.size(); i++) {
				 if (listaHerramientas.get(i).getEstatus().equals("A")) {
	            		//Mandamos a la parte del dao
					 HerramientasDAO dao = new HerramientasDAO();
	          			  respuesta = dao.eliminarHerramientas(uid, herramientaOV);
	            	  } else {
	            		  throw new ExcepcionesCuadrillas("ya se encuentra inactivo.");
	            	  }
			 }
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaUsuario - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaUsuario - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaUsuario - Datos Salida: " + respuesta);
		return respuesta;
}
}
