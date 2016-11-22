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
	/** The LONGITUD_CODIGO_TIPO_COMBUSTIBLE. */
	private static final  int LONGITUD_CODIGO_TIPO_COMBUSTIBLE = 10;
	/** LA LONGITUD DEL CODIGO DE TIPO ARTICULO */
	private static final int LONGITUD_CODIGO_TIPO_ARTICULO = 10;
	/** LA LONGITUD DEL CODIGO ESTADO*/
	private static final int LONGITUD_CODIGO_ESTADO = 10;
	/** The LONGITUD_DESCRIPCION_HERRAMIENTA. */
	private static final  int LONGITUD_DESCRIPCION_HERRAMIENTA = 100;
	
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
	    	if (herramienta.getNombre() == null || herramienta.getNombre().trim().isEmpty()) {
	    		throw new ExcepcionesCuadrillas("Es necesario el nombre de la herramienta.");
	    	}
	    	if(herramienta.getOrden() == null || herramienta.getOrden().isEmpty()) {
	    		herramienta.setOrden("A");
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
				if(herramienta.getNombre() == null || herramienta.getNombre().trim().isEmpty()) { 
					throw new ExcepcionesCuadrillas("El campo nombre es necesario.");
				} 
		        if(herramienta.getDescripcion() == null || herramienta.getDescripcion().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo descripcion es necesario.");
				} 
		        if (herramienta.getCodigoTipoCombustible() ==  null || herramienta.getCodigoTipoCombustible().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo codigo tipo combustible es necesario.");
				} 
		        if (herramienta.getCodigoTipoArticulo() == null || herramienta.getCodigoTipoArticulo().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo codigo tipo articulo es necesario.");
				} 
		        if (herramienta.getCodigoEstado() == null || herramienta.getCodigoEstado().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo codigo estado es necesario.");
				} 
		        if (herramienta.getMantenimiento() == null || herramienta.getMantenimiento().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo mantenimiento es necesario.");
				}
		        if (herramienta.getDescripcion().length() > LONGITUD_DESCRIPCION_HERRAMIENTA)
		        {
		        	throw new ExcepcionesCuadrillas("La descripcion de la herramienta NO puede ser maximo de "
							+ LONGITUD_DESCRIPCION_HERRAMIENTA + " caracteres.");
		        }
		        if (herramienta.getCodigoTipoCombustible().length() > LONGITUD_CODIGO_TIPO_COMBUSTIBLE) 
		        {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo combustible puede ser maximo de 10 caracteres.");
		        }
		        if (herramienta.getCodigoTipoCombustible().contains(" ")) {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo combustible NO puede tener espacios.");
		        }
		        if (herramienta.getCodigoTipoArticulo().length() > LONGITUD_CODIGO_TIPO_ARTICULO) {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo articulo puede ser maximo de 10 caracteres.");
		        }
		        if (herramienta.getCodigoTipoArticulo().contains(" ")) {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo articulo NO puede tener espacios.");
		        }
		        if (herramienta.getCodigoEstado().length() > LONGITUD_CODIGO_ESTADO) {
		        	throw new ExcepcionesCuadrillas("El codigo estado puede ser maximo de 10 caracteres.");
		        }
		        if (herramienta.getCodigoEstado().contains(" ")) {
		        	throw new ExcepcionesCuadrillas("El codigo estado NO puede tener espacios.");
		        }
        HerramientasDAO dao = new HerramientasDAO();
		respuesta = dao.registraHerramienta(uid, herramienta);
			}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "registraHerramienta - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "registraHerramienta - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "registraHerramienta - Datos Salida: " + respuesta);
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
