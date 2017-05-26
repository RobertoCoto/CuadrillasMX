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
	private static final  int LONGITUD_CODIGO_ESTATUS = 4;
	/** LA LONGITUD DEL CODIGO DE TIPO ARTICULO */
	private static final int LONGITUD_CODIGO_TIPO_ARTICULO = 4;
	/** LA LONGITUD DEL CODIGO ESTADO*/
	/** The LONGITUD_DESCRIPCION_HERRAMIENTA. */
	private static final  int LONGITUD_DESCRIPCION_HERRAMIENTA = 100;

	/**
	 * Metodo para consultar herramientas
	 * @param herramienta recibe valores de herramientas
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
	    	listaHerramienta = new HerramientasDAO().consultaHerramienta(uid, herramienta);
	    	respuesta.setHerramienta(listaHerramienta);

	    } catch  (ExcepcionesCuadrillas ex) {
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
				if (herramienta.getNombre() == null || herramienta.getNombre().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo nombre es necesario.");
				}
		        if (herramienta.getDescripcion() == null || herramienta.getDescripcion().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo descripcion es necesario.");
				}
		        if (herramienta.getCodigoEstatus() ==  null || herramienta.getCodigoEstatus().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo codigo del estatus de la herramienta es necesario.");
				}
		        if (herramienta.getCodigoTipo() == null || herramienta.getCodigoTipo().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo codigo tipo articulo es necesario.");
				}
		        if (herramienta.getMarca() == null || herramienta.getMarca().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo Marca es necesario.");
				}
		        if (herramienta.getModelo() == null || herramienta.getModelo().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo Modelo es necesario.");
				}
		        if (herramienta.getNoSerie() == null || herramienta.getNoSerie().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo Numero de Serie es necesario.");
				}
		        if (herramienta.getUsuarioAlta() == null || herramienta.getUsuarioAlta().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El usuario es necesario para la peticion.");
				}
		        if (herramienta.getDescripcion().length() > LONGITUD_DESCRIPCION_HERRAMIENTA) {
		        	throw new ExcepcionesCuadrillas("La descripcion de la herramienta NO puede ser mayor de "
							+ LONGITUD_DESCRIPCION_HERRAMIENTA + " caracteres.");
		        }
		        if (herramienta.getCodigoEstatus().length() < LONGITUD_CODIGO_ESTATUS)  {
		        	throw new ExcepcionesCuadrillas("El codigo del estatus es incorrecto.");
		        }
		        if (herramienta.getCodigoEstatus().contains(" ")) {
		        	throw new ExcepcionesCuadrillas("El codigo del estatus NO puede tener espacios.");
		        }
		        if (herramienta.getCodigoTipo().length() < LONGITUD_CODIGO_TIPO_ARTICULO) {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo articulo es incorrecto.");
		        }
		        if (herramienta.getCodigoTipo().contains(" ")) {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo articulo NO puede tener espacios.");
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
	 * @param herramienta dto
	 * @return respuesta
	 */
	public EncabezadoRespuesta eliminaHerramientas(HerramientaDTO herramienta) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(herramienta);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraSitio - Daton Entrada: " + herramienta);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();

		try {
			//Validaciones Negocio
			if (herramienta.getIdHerramienta() == null || herramienta.getIdHerramienta() == 0) {
				throw new ExcepcionesCuadrillas("El campo id Herramienta es necesario.");
			}
	        HerramientasDAO dao = new HerramientasDAO();
			respuesta = dao.eliminarHerramienta(uid, herramienta);
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "eliminaHerramienta - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "eliminaHerramienta - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "eliminaHerramienta - Datos Salida: " + respuesta);
		return respuesta;
}

	/**
	 * Metodo para actualizar la info de una herramienta
	 * @param herramienta recibe valores de herramienta
	 * @return regresa la respuesta de modificacion
	 */
	public EncabezadoRespuesta actualizaHerramienta(HerramientaDTO herramienta) {
		//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(herramienta);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "actualizaHerramienta - Datos Entrada: " + herramienta);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();

			try {
				if (herramienta.getIdHerramienta() == null || herramienta.getIdHerramienta() == 0) {
					throw new ExcepcionesCuadrillas("El campo id Herramienta es necesario.");
				}
				if (herramienta.getNombre() == null || herramienta.getNombre().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo nombre es necesario.");
				}
		        if (herramienta.getDescripcion() == null || herramienta.getDescripcion().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo descripcion es necesario.");
				}
		        if (herramienta.getCodigoEstatus() ==  null || herramienta.getCodigoEstatus().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo codigo del estatus de la herramienta es necesario.");
				}
		        if (herramienta.getCodigoTipo() == null || herramienta.getCodigoTipo().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo codigo tipo articulo es necesario.");
				}
		        if (herramienta.getMarca() == null || herramienta.getMarca().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo Marca es necesario.");
				}
		        if (herramienta.getModelo() == null || herramienta.getModelo().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo Modelo es necesario.");
				}
		        if (herramienta.getNoSerie() == null || herramienta.getNoSerie().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo Numero de Serie es necesario.");
				}
		        if (herramienta.getUsuarioAlta() == null || herramienta.getUsuarioAlta().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El usuario es necesario para la peticion.");
				}
		        if (herramienta.getDescripcion().length() > LONGITUD_DESCRIPCION_HERRAMIENTA) {
		        	throw new ExcepcionesCuadrillas("La descripcion de la herramienta NO puede ser mayor de "
							+ LONGITUD_DESCRIPCION_HERRAMIENTA + " caracteres.");
		        }
		        if (herramienta.getCodigoEstatus().length() < LONGITUD_CODIGO_ESTATUS)  {
		        	throw new ExcepcionesCuadrillas("El codigo del estatus es incorrecto.");
		        }
		        if (herramienta.getCodigoEstatus().contains(" ")) {
		        	throw new ExcepcionesCuadrillas("El codigo del estatus NO puede tener espacios.");
		        }
		        if (herramienta.getCodigoTipo().length() < LONGITUD_CODIGO_TIPO_ARTICULO) {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo articulo es incorrecto.");
		        }
		        if (herramienta.getCodigoTipo().contains(" ")) {
		        	throw new ExcepcionesCuadrillas("El codigo del tipo articulo NO puede tener espacios.");
		        }

		        HerramientasDAO dao = new HerramientasDAO();
				respuesta = dao.actualizaHerramienta(uid, herramienta);

			} catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "actualizaHerramienta - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			catch  (Exception ex) {
				LogHandler.error(uid, this.getClass(), "actualizaHerramienta - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}

		LogHandler.debug(uid, this.getClass(), "actualizaHerramienta - Datos Salida: " + respuesta);
		return respuesta;
	}

}
