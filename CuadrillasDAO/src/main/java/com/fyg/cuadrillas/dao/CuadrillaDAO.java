package com.fyg.cuadrillas.dao;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.cuadrilla.CuadrillaDTO;

public class CuadrillaDAO {
	/**
	 * Metodo para dar de alta una cuadrilla
	 * @param uid unico de registro
	 * @param cuadrilla recibe valores de cuadrilla
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta altaCuadrilla (String uid, CuadrillaDTO cuadrilla) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Validamos si ya existe una misma cuadrilla
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeMismaCuadrilla= (Integer) sessionNTx.selectOne("CuadrillaDAO.existeMismaCuadrilla", cuadrilla);
			if (existeMismaCuadrilla > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe la cuadrilla.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("CuadrillaDAO.altaCuadrilla", cuadrilla);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al registrar una cuadrilla.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		} catch (Exception ex) {
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
	 * Metodo para dar de baja una cuadrilla
	 * @param uid unico de registro
	 * @param cuadrilla recibe valores de cuadrilla
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta bajaCuadrilla (String uid, CuadrillaDTO cuadrilla) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("inactivación correcta.");
		
		try {
			//Validamos si ya esta dado de baja el contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeBaja= (Integer) sessionNTx.selectOne("CuadrillaDAO.existeBaja", cuadrilla);
			if (existeBaja > 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja, la cuadrilla ya se encuentra inactiva.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("CuarillaDAO.bajaContrato", cuadrilla);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja la cuadrilla.");
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
}
