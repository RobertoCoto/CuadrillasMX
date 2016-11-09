package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Catalogos;

public class CatalogoDAO {
	/**
	 * Metodo para consultar los catalogos
	 * @param uid unico de registro
	 * @param catalogo valores de catalogos
	 * @return regresa una lista de catalogos
	 */
	@SuppressWarnings("unchecked")
	public List<Catalogos> consultaCatalogo(String uid, Catalogos catalogo) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Catalogos> listaCatalogos = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaCatalogos = sessionNTx.selectList("CatalogoDAO.consultaCatalogo", catalogo);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaCatalogos;
	}
	/**
	 * Metodo para consultar los catalogos
	 * @param uid unico de registro
	 * @param catalogoOV valores de catalogos
	 * @return regresa una lista de catalogos
	 */
	@SuppressWarnings("unchecked")
	public List<Catalogos> consultaListaCatalogo(String uid, Catalogos catalogoOV) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Catalogos> listaCatalogos = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaCatalogos = sessionNTx.selectList("CatalogoDAO.consultaListaCatalogo", catalogoOV);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaCatalogos;
	}
	
	/**
	  * Metodo para la baja de un catalogo
	  * @param uid unico de registro
	  * @param catalogoOV recibe los valores del catalogo
	  * @return regresa el resultado de la baja
	  */
	 public EncabezadoRespuesta eliminarCatalogo(String uid, Catalogos catalogoOV) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Baja correcta.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.update("CatalogoDAO.inactivaCatalogo", catalogoOV);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("Error al bajar el catalogo.");
				}
				//Realizamos commit
				LogHandler.debug(uid, this.getClass(), "Commit!!!");
				sessionTx.commit();
			}
			catch (Exception ex) {
				//Realizamos rollBack
				LogHandler.debug(uid, this.getClass(), "RollBack!!!");
				FabricaConexiones.rollBack(sessionTx);
	   LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
	   respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sessionTx);
			}
			return respuesta;
	}
	 /**
	  * Metodo para registrar Catalogos
	  * @param uid unico de registro
	  * @param catalogoOV recibe valores de catalogo
	  * @return regresa si el registro fue correcto
	  */
	 public EncabezadoRespuesta registraCatalogo(String uid, Catalogos catalogoOV) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("registro correcto.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.update("CatalogoDAO.registraCatalogo", catalogoOV);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("Error al registrar el catalogo.");
				}
				//Realizamos commit
				LogHandler.debug(uid, this.getClass(), "Commit!!!");
				sessionTx.commit();
			}
			catch (Exception ex) {
				//Realizamos rollBack
				LogHandler.debug(uid, this.getClass(), "RollBack!!");
				FabricaConexiones.rollBack(sessionTx);
	LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
	respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sessionTx);
			}
			return respuesta;
	}
}
