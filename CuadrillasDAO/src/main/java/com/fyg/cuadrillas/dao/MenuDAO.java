package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.menu.MenuDTO;

public class MenuDAO {
	/**
	 * Metodo para consultar el menu Hijo
	 * @param uid  id unico
	 * @param idPerfil  id Perfil
	 * @return regresa los menus
	 */
	@SuppressWarnings("unchecked")
	public List<MenuDTO> consultaMenu(String uid, Integer idPerfil) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<MenuDTO> listaMenus = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			LogHandler.debug(uid, this.getClass(), "Consultando");
			listaMenus = sessionNTx.selectList("MenuDAO.consultaMenu", idPerfil);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaMenus;
	}
}
