package com.fyg.cuadrillas.dao;

import java.util.List;

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
	public EncabezadoRespuesta altaCuadrilla(String uid, CuadrillaDTO cuadrilla) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Se ha registrado la cuadrilla correctamente.");
		try {
			//Validamos si ya existe una misma cuadrilla
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			int existeMismaCuadrilla = (Integer) sessionNTx.selectOne("CuadrillaDAO.existeMismaCuadrilla", cuadrilla);
			if (existeMismaCuadrilla > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe una cuadrilla con el mismo nombre.");
			}
			int existeMismaVialidad = (Integer) sessionNTx.selectOne("CuadrillaDAO.existeMismaVialidad", cuadrilla);
			if (existeMismaVialidad > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe una cuadrilla asignad a la vialidad.");
			}
			int existeMismaIdCuadrilla = (Integer) sessionNTx.selectOne("CuadrillaDAO.existeMismaIdCuadrilla", cuadrilla);
			if (existeMismaIdCuadrilla > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe el ID de la cuadrilla.");
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
	public EncabezadoRespuesta bajaCuadrilla(String uid, CuadrillaDTO cuadrilla) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("La cuadrilla ha sido dado de baja exitosamente.");

		try {
			//Validamos si ya esta dado de baja el contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeBaja = (Integer) sessionNTx.selectOne("CuadrillaDAO.existeBajaCuadrilla", cuadrilla);
			if (existeBaja > 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja, la cuadrilla ya se encuentra inactiva.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("CuarillaDAO.bajaCuadrilla", cuadrilla);
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
	/**
	 * Metodo para consultar Cuadrillas
	 * @param uid unico de registro
	 * @return regresa lista de cuadrillas
	 * @throws Exception se genera excepcion
	 */
	@SuppressWarnings("unchecked")
	public List<CuadrillaDTO> consultaCuadrilla(String uid)throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<CuadrillaDTO> listaCuadrilla = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.debug(uid, this.getClass(), "Consultando");
			//Se hace una consulta a la tabla contacto
			listaCuadrilla = sessionNTx.selectList("CuadrillaDAO.consultaCuadrilla");
			if ( listaCuadrilla.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen cuadrillas definidas.");
			}
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaCuadrilla;
	}
	/**
	 * Metodo para modificar las cuadrillas
	 * @param uid unico de registro
	 * @param cuadrilla recibe valores de cuadrilla
	 * @return regresa una lista
	 */
	public EncabezadoRespuesta modificaCuadrilla(String uid, CuadrillaDTO cuadrilla) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("La cuadrilla se ha modificado correctamente.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeMismaCuadrilla = (Integer) sessionNTx.selectOne("CuadrillaDAO.existeMismaCuadrilla", cuadrilla);
			if (existeMismaCuadrilla > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe una cuadrilla con el mismo nombre.");
			}
			int existeMismaVialidad = (Integer) sessionNTx.selectOne("CuadrillaDAO.existeMismaVialidad", cuadrilla);
			if (existeMismaVialidad > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe una cuadrilla asignad a la vialidad.");
			}

	        int registros = sessionTx.update("CuadrillaDAO.modificaCuadrilla", cuadrilla);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar una cuadrilla.");
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
}
