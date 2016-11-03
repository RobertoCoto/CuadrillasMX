package com.fyg.cuadrillas.dao;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.resources.FabricaConexiones;
import com.fyg.cuadrillas.dto.PruebaDTO;
import com.fyg.cuadrillas.dto.Usuario;

public class OperacionesCuadrillasDAO {
/**
 * Metodo para registrar datos prueba
 * @param uid id unico de registro
 * @param prueba , recibe valores de prueba
 * @return regresa respuesta de registro
 */
 public EncabezadoRespuesta registraPrueba(String uid, PruebaDTO prueba) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Registro correcto.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
     	int registros = sessionTx.insert("OperacionesCuadrillasDAO.insertaPrueba", prueba);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error en registrar.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		}
		catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!!");
			FabricaConexiones.rollBack(sessionTx);
         LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
         respuesta.setEstatus(false);
 		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return respuesta;
 }
 /**
  * Metodo para registrar un usuario
  * @param uid unico de registro
  * @param usuario  recibe valores de usuario
  * @return regresa si el usuario fue registrado
  */
 public EncabezadoRespuesta altaUsuario(String uid, Usuario usuario) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Registro correcto.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
  	int registros = sessionTx.insert("OperacionesCuadrillasDAO.insertaUsuario", usuario);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error en registrar.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		}
		catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!!");
			FabricaConexiones.rollBack(sessionTx);
      LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
      respuesta.setEstatus(false);
		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return respuesta;
}
 /**
  * Metodo para dar de baja un usuario
  * @param uid unico de registro
  * @param usuario recibe valores de usuario
  * @return regresa la respuesta
  */
 public EncabezadoRespuesta bajaUsuario(String uid, Usuario usuario) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Baja correcta.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
  	int registros = sessionTx.update("OperacionesCuadrillasDAO.bajaUsuario", usuario);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al bajar el usuario.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		}
		catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!!");
			FabricaConexiones.rollBack(sessionTx);
      LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
      respuesta.setEstatus(false);
		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return respuesta;
}
}
