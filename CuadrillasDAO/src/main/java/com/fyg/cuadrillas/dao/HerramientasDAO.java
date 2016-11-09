package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Herramientas;

public class HerramientasDAO {
	/**
	 * Metodo para consultar Herramientas
	 * @param uid unico de registro
	 * @param herramientasOV recibe valores de herramienta
	 * @return regresa lista de herramientas
	 */
	@SuppressWarnings("unchecked")
	public List<Herramientas> consultaHerramientas(String uid, Herramientas herramientasOV) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Herramientas> listaHerramientas = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaHerramientas = sessionNTx.selectList("HerramientasDAO.consultaHerramientas", herramientasOV);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaHerramientas;
	}
	/**
	 * Metodo general para consultar
	 * @param uid unico de registro
	 * @param herramientasOV recibe valores de herramientas
	 * @return regresa una lista de herramientas
	 */
	@SuppressWarnings("unchecked")
	public List<Herramientas> consultaListaHerramientas(String uid, Herramientas herramientasOV) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Herramientas> listaHerramientas = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaHerramientas = sessionNTx.selectList("HerramientasDAO.consultaListaHerramientas", herramientasOV);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaHerramientas;
	}
	/**
	  * Metodo para registrar herramientas
	  * @param uid unico de registro
	  * @param herramientaOV recibe valores de herramienta
	  * @return regresa la respuesta de la transaccion
	  */
	 public EncabezadoRespuesta registraHerramientas(String uid, Herramientas herramientaOV) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("registro correcto.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.update("HerramientasDAO.registraHerramientas", herramientaOV);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("Error al registrar la Herramienta.");
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
	  * Metodo para dar de baja las herramientas
	  * @param uid unico de registgro
	  * @param herramientaOV recibe valores de herramientas
	  * @return regresa el resultado de la transaccion
	  */
	 public EncabezadoRespuesta eliminarHerramientas(String uid, Herramientas herramientaOV) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Baja correcta.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.update("HerramientasDAO.inactivaHerramientas", herramientaOV);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("Error al bajar la herramienta.");
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
}
