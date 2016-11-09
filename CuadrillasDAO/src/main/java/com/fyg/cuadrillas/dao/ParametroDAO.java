package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Parametros;

public class ParametroDAO {
	/**
	 * Metodo para consultar parametros
	 * @param uid unico
	 * @param parametro recibe el valor de parametro
	 * @return regresa el parametro
	 */
	@SuppressWarnings("unchecked")
	public List<Parametros> consultaParametro(String uid, Parametros parametro) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Parametros> listaParametros = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla parametros
			listaParametros = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaParametro", parametro);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaParametros;
	}
}
