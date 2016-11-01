package com.fyg.cuadrillas.dao;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.resources.FabricaConexiones;
import com.fyg.cuadrillas.dto.PruebaDTO;

public class OperacionesCuadrillasDAO {
	
	
 public EncabezadoRespuesta registraPrueba(String uid, PruebaDTO prueba) {
	 	SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Registro correcto.");
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionTx();
     	int registros = sessionNTx.insert("OperacionesCuadrillasDAO.insertaPrueba", prueba);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error en registrar.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionNTx.commit();
		}
		catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!!");
			FabricaConexiones.rollBack(sessionNTx);
         LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
         respuesta.setEstatus(false);
 		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
 }
}
