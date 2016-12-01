package com.fyg.cuadrillas.dao;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.cuadrilla.CuadrillaDTO;

public class CuadrillaDAO {

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
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe un contrato vigente.");
			}
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
