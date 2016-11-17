package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.catalogo.CatalogoDTO;

public class CatalogoDAO {
	/**
	 * Metodo para consultar los catalogos
	 * @param uid unico de registro
	 * @param catalogo valores de catalogos
	 * @return regresa una lista de catalogos
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<CatalogoDTO> consultaCatalogo(String uid, CatalogoDTO catalogo) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<CatalogoDTO> listaCatalogos = null;
		try {
			//Abrimos conexion Transaccional
			System.out.println("Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			System.out.println("Consultando");
			//Se hace una consulta a la tabla contacto
			if ( catalogo.getOrden().equals("A")) {
				listaCatalogos = sessionNTx.selectList("CatalogoDAO.consultaCatalogoAsc", catalogo);
			} else {
				listaCatalogos = sessionNTx.selectList("CatalogoDAO.consultaCatalogoDesc", catalogo);
			}
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new Exception(ex.getMessage());
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
	 public EncabezadoRespuesta eliminarCatalogo(String uid, CatalogoDTO catalogoOV) {
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
	 public EncabezadoRespuesta registraCatalogo(String uid, CatalogoDTO catalogoOV) {
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
