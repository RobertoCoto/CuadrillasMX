package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.HerramientasDAO;
import com.fyg.cuadrillas.dto.herramienta.HerramientaDTO;
import com.fyg.cuadrillas.dto.herramienta.HerramientaRespuesta;

public class HerramientaNegocio {
	/**
	 * Metodo para consultar herramientas
	 * @param herramientaOV recibe valores de herramientas
	 * @return regresa lista de herramientas
	 */
	public HerramientaRespuesta consultarHerramienta(HerramientaDTO herramienta) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(herramienta);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "herramientaOV -  Entrada: " + herramienta);
		//Variable de resultado
		HerramientaRespuesta respuesta = new HerramientaRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		
		List<HerramientaDTO> listaHerramienta = null;
	    try {
	    	//validacion
	    	if(herramienta.getEstatus() == null || herramienta.getEstatus().trim().isEmpty())
	    	{
	    		System.out.println("ERROR");
	    		throw new ExcepcionesCuadrillas("Es necesario el estatus para la busqueda.");
	    	} else if(herramienta.getOrden() == null || herramienta.getOrden().trim().isEmpty()) {
	    		System.out.println("ERROR");
	    		throw new ExcepcionesCuadrillas("Es necesario la orden para la busqueda.");
	    	}
	    	 listaHerramienta = new HerramientasDAO().consultaHerramienta(uid, herramienta);
	    	 respuesta.setHerramienta(listaHerramienta);
	    	 
	    }catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "ConsultaHerramienta - Error: " + ex.getMessage(), ex);			
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "herramienta - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "herramienta - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * Metodo para registrar las herramientas
	 * @param herramienta recibe parametros de herramienta
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta registrarHerramienta(HerramientaDTO herramienta) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(herramienta);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraHerramientas - Datos Entrada: " + herramienta);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			//Validaciones Negocio
		if(herramienta.getNombre() == null || herramienta.getNombre().isEmpty()) { 
			throw new ExcepcionesCuadrillas("El campo nombre es necesario.");
		} else if(herramienta.getDescripcion() == null || herramienta.getDescripcion().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo descripcion es necesario.");
		} else if (herramienta.getCodigoTipoCombustible() ==  null || herramienta.getCodigoTipoCombustible().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo codigo tipo combustible es necesario.");
		} else if (herramienta.getCodigoTipoArticulo() == null || herramienta.getCodigoTipoArticulo().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo codigo tipo articulo es necesario.");
		} else if (herramienta.getCodigoEstado() == null || herramienta.getCodigoEstado().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo codigo estado es necesario.");
		} else if (herramienta.getMantenimiento() == null || herramienta.getMantenimiento().isEmpty()) {
			throw new ExcepcionesCuadrillas("El campo mantenimiento es necesario.");
		} else {
			HerramientasDAO dao = new HerramientasDAO();
			respuesta = dao.registraHerramienta(uid, herramienta);
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
	public EncabezadoRespuesta eliminaHerramientas(HerramientaDTO herramienta) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(herramienta);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraSitio - Daton Entrada: " + herramienta);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		List<HerramientaDTO> listaHerramientas = null;
		try {
			//Validaciones Negocio
			listaHerramientas = new HerramientasDAO().consultaListaHerramienta(uid, herramienta);
			 for (int i = 0; i < listaHerramientas.size(); i++) {
				 if (listaHerramientas.get(i).getEstatus().equals("A")) {
	            		//Mandamos a la parte del dao
					 HerramientasDAO dao = new HerramientasDAO();
	          			  respuesta = dao.eliminarHerramienta(uid, herramienta);
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
