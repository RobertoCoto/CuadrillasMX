package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.herramienta.HerramientaDTO;

public class HerramientasDAO {
	/**
	 * Metodo para consultar Herramientas
	 * @param uid unico de registro
	 * @param herramientasOV recibe valores de herramienta
	 * @return regresa lista de herramientas
	 */
	@SuppressWarnings("unchecked")
	public List<HerramientaDTO> consultaHerramienta(String uid, HerramientaDTO herramienta)throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<HerramientaDTO> listaHerramientas = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaHerramientas = sessionNTx.selectList("HerramientasDAO.consultaHerramientas", herramienta);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new Exception(ex.getMessage());
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
	public List<HerramientaDTO> consultaListaHerramienta(String uid, HerramientaDTO herramienta) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<HerramientaDTO> listaHerramientas = null;
		try {
			//Abrimos conexion Transaccional
			System.out.println("Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla
			System.out.println("Consultando");
			listaHerramientas = sessionNTx.selectList("HerramientaDAO.consultaListaHerramientas", herramienta);
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
	 public EncabezadoRespuesta registraHerramienta(String uid, HerramientaDTO herramienta) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("registro correcto.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.update("HerramientasDAO.registraHerramientas", herramienta);
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
	 public EncabezadoRespuesta eliminarHerramienta(String uid, HerramientaDTO herramienta) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Baja correcta.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.update("HerramientaDAO.inactivaHerramientas", herramienta);
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
