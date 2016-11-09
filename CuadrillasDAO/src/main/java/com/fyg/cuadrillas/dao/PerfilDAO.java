package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Perfil;

public class PerfilDAO {
	/**
	 * Metodo para consultar el perfil existente
	 * @param uid unico
	 * @param perfil recibe valores perfil
	 * @return regresa resultados
	 */
	@SuppressWarnings("unchecked")
	public List<Perfil> consultaPerfil(String uid, Perfil perfil) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Perfil> listaPerfil = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaPerfil = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaPerfil", perfil);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaPerfil;
	}
}
