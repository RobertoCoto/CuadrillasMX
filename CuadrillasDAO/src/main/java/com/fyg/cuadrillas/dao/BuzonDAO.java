package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.buzon.BuzonDTO;
public class BuzonDAO {

	/**
	 * Metodo para consultar las tareas activas
	 * @param uid unico de registro
	 * @param buzon recibe valores de buzon
	 * @return devuelve una lista de tareas
	 * @throws Exception para una excepcion
	 */
	@SuppressWarnings("unchecked")
	public List<BuzonDTO> consultaTareas(String uid, BuzonDTO buzon)throws Exception {
		 SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Consulta correcta.");
			List<BuzonDTO> listaTareas = null;
			try {
				//Abrimos conexion Transaccional
				LogHandler.debug(uid, this.getClass(), "Abriendo");
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.debug(uid, this.getClass(), "Consultando");
				//Se hace una consulta a la tabla contacto
				listaTareas = sessionNTx.selectList("BuzonDAO.consultaTareas", buzon);
				if ( listaTareas.size() == 0) {
					throw new ExcepcionesCuadrillas("No existen tareas pendientes.");
				}
			} catch (Exception ex) {
				LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
				throw new Exception(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sessionNTx);
			}
			return listaTareas;
	}
	/**
	 * Metodo para consultar las tareas activas
	 * @param uid unico de registro
	 * @param buzon recibe valores de buzon
	 * @return devuelve una lista de tareas
	 * @throws Exception para una excepcion
	 */
	@SuppressWarnings("unchecked")
	public List<BuzonDTO> consultaBuzonResidente(String uid, BuzonDTO buzon)throws Exception {
		 SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Consulta correcta.");
			List<BuzonDTO> listaBuzonResidente = null;
			try {
				//Abrimos conexion Transaccional
				LogHandler.debug(uid, this.getClass(), "Abriendo");
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.debug(uid, this.getClass(), "Consultando");
				//Se hace una consulta a la tabla contacto
				listaBuzonResidente = sessionNTx.selectList("BuzonDAO.consultaTareasResidente", buzon);
				if ( listaBuzonResidente.size() == 0) {
					throw new ExcepcionesCuadrillas("No existen tareas pendientes.");
				}
			} catch (Exception ex) {
				LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
				throw new Exception(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sessionNTx);
			}
			return listaBuzonResidente;
	}
}
