package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.catalogo.CatalogoDTO;
import com.fyg.cuadrillas.dto.catalogo.TipoCatalogoDTO;

public class CatalogoDAO {


	/**
	 * Metodo para consultar los tipos de catalogos
	 * @param uid unico de registro
	 * @return regresa una lista de catalogos
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TipoCatalogoDTO> consultaTipoCatalogos(String uid) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<TipoCatalogoDTO> listaTipoCatalogos = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.debug(uid, this.getClass(), "Consultando");
			//Se hace una consulta a la tabla contacto
			listaTipoCatalogos = sessionNTx.selectList("CatalogoDAO.consultaTipoCatalogos");
			if ( listaTipoCatalogos.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen catalogos definidos.");
			}
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaTipoCatalogos;
	}


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
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.debug(uid, this.getClass(), "Consultando");
			//Se hace una consulta a la tabla contacto
			if ( catalogo.getOrden().equals("A")) {
				listaCatalogos = sessionNTx.selectList("CatalogoDAO.consultaCatalogoAsc", catalogo);
			} else {
				listaCatalogos = sessionNTx.selectList("CatalogoDAO.consultaCatalogoDesc", catalogo);
			}

		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
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
	  * @param catalogo recibe los valores del catalogo
	  * @return regresa el resultado de la baja
	  */
	 public EncabezadoRespuesta eliminarCatalogo(String uid, CatalogoDTO catalogo) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("La baja del catalogo fue correcta.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.update("CatalogoDAO.inactivaCatalogo", catalogo);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("No fue posible dar de baja el catalogo.");
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
	  * @param catalogo recibe valores de catalogo
	  * @return regresa si el registro fue correcto
	  */
	 public EncabezadoRespuesta registraCatalogo(String uid, CatalogoDTO catalogo) {
		 	SqlSession sessionTx = null;
		 	SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("registro correcto.");
			try {
				//Validamos si el catalogo ya existe
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				int existeCodigo = (Integer) sessionNTx.selectOne("CatalogoDAO.existeCatalogoCodigo", catalogo);
				if (existeCodigo > 0) {
					throw new ExcepcionesCuadrillas("Error en registrar catalogo, el codigo ya existe.");
				}
				int existeDes = (Integer) sessionNTx.selectOne("CatalogoDAO.existeCatalogoDescripcion", catalogo);
				if (existeDes > 0) {
					throw new ExcepcionesCuadrillas("Error en registrar catalogo, la descripcion ya existe.");
				}
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.insert("CatalogoDAO.registraCatalogo", catalogo);
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
				FabricaConexiones.close(sessionNTx);
			}
			return respuesta;
	}
	 /**
	  * Metodo para la baja de un catalogo
	  * @param uid unico de registro
	  * @param catalogo recibe los valores del catalogo
	  * @return regresa el resultado de la baja
	  */
	 public EncabezadoRespuesta actualizarCatalogo(String uid, CatalogoDTO catalogo) {
		 	SqlSession sessionTx = null;
		 	SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("La actualizacion del catalogo fue correcta.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				int existeDes = (Integer) sessionNTx.selectOne("CatalogoDAO.existeCatalogoDescripcion", catalogo);
				if (existeDes > 0) {
					throw new ExcepcionesCuadrillas("Error en registrar catalogo, la descripcion ya existe.");
				}				
		        int registros = sessionTx.update("CatalogoDAO.actualizarCatalogo", catalogo);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("No fue posible actualizar el catalogo.");
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
				FabricaConexiones.close(sessionNTx);
			}
			return respuesta;
	}
}
