package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.resources.FabricaConexiones;
import com.fyg.cuadrillas.dto.PruebaDTO;

public class ConsultasCuadrillasDAO {
	@SuppressWarnings("unchecked")
	public List<PruebaDTO> consultaPrueba(String uid, PruebaDTO prueba) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<PruebaDTO> listaPrueba = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaPrueba = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaPrueba", prueba);
			System.out.println(listaPrueba);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaPrueba;
	}

}
