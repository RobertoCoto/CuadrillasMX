package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.ParametroDTO;

public class ParametroDAO {
	/**
	 * Metodo para consultar parametros
	 * @param uid unico
	 * @param parametro recibe el valor de parametro
	 * @return regresa el parametro
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String consultaParametro(String uid, String  parametro) throws Exception {
		SqlSession sessionNTx = null;		
		String valor = null;
		try {			
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla parametros
			valor = (String) sessionNTx.selectOne("ConsultasCuadrillasDAO.consultaParametro", parametro);
			
			if (valor == null || valor.trim().isEmpty()) {
				throw new Exception("No se encontro el valor en parametros: " + parametro);
			}
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            throw new Exception();
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return valor;
	}
}
