package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.menu.MenuDTO;

public class MenuDAO {
	/**
	 * Metodo para consultar el menu Hijo
	 * @param uid  uid unico 
	 * @param menu Recibe valores de menu
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
			System.out.println("Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			System.out.println("Consultando");
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
