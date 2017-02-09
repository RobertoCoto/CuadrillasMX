package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;

public class UsuarioDAO {
	/**
	 * Metodo para consultar usuario
	 * @param uid unico
	 * @param usuario recibe valores de usuario
	 * @return regresa resultado de usuarios
	 */
	@SuppressWarnings("unchecked")
	public List<UsuarioDTO> consultaUsuario(String uid, UsuarioDTO usuario)throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<UsuarioDTO> listaUsuario = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			LogHandler.debug(uid, this.getClass(), "Consultando");
			listaUsuario = sessionNTx.selectList("UsuarioDAO.consultaUsuario", usuario);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaUsuario;
	}
	/**
	  * Metodo para registrar un usuario
	  * @param uid unico de registro
	  * @param usuario  recibe valores de usuario
	  * @return regresa si el usuario fue registrado
	  */
	 public EncabezadoRespuesta altaUsuario(String uid, UsuarioDTO usuario) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Se ha registrado el usuario correctamente.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
	  	int registros = sessionTx.insert("UsuarioDAO.insertaUsuario", usuario);
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
	 public EncabezadoRespuesta bajaUsuario(String uid, UsuarioDTO usuario) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("El usuario ha sido dado de baja correctamente.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
	  	        int registros = sessionTx.update("UsuarioDAO.inactivaUsuario", usuario);
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
	/**
	 * Metodo para Hacer Login usuario
	 * @param uid unico de registro
	 * @param usuario recibe valores de usuario
	 * @return regresa lista usuario
	 */
	public UsuarioDTO loginUsuario(String uid, UsuarioDTO usuario) throws Exception {
			SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Consulta correcta.");
			UsuarioDTO loginUsuario = null;
			try {
				//Abrimos conexion Transaccional
				LogHandler.debug(uid, this.getClass(), "Abriendo");
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				//Se hace una consulta a la tabla contacto
				LogHandler.debug(uid, this.getClass(), "Consultando");
				loginUsuario = (UsuarioDTO) sessionNTx.selectOne("UsuarioDAO.loginUsuario", usuario);
				if (loginUsuario == null) {
					throw new ExcepcionesCuadrillas("Usuario y/o contraseña incorrecta.");
				}
			}
			catch (Exception ex) {
				LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
				throw new Exception(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sessionNTx);
			}
			return loginUsuario;
		}
	/**
	 * Metodo para actualizar la contraseña
	 * @param uid unico de registro
	 * @param usuario recibe valores de usuario
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta modificaContrasena(String uid,UsuarioDTO usuario) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Se ha modificado la contraseña correctamente.");
		try {
			//Validamos si el usuario esta activo
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeUsuarioActivo= (Integer) sessionNTx.selectOne("UsuarioDAO.existeUsuarioActivo", usuario);
			if (existeUsuarioActivo > 0) {
				throw new ExcepcionesCuadrillas("Error al modificar, el usuario esta inactivo.");
			}
			int verificaContrasena = (Integer) sessionNTx.selectOne("UsuarioDAO.verificaContrasena", usuario);
			if (verificaContrasena == 0) {
				throw new ExcepcionesCuadrillas("La contraseña anterior no coincide.");
			}
			
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("UsuarioDAO.modificaContrasena", usuario);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar la contraseña.");
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
	 * Metodo para actualizar la contraseña
	 * @param uid unico de registro
	 * @param usuario recibe valores de usuario
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta recuperaContrasena(String uid,UsuarioDTO usuario) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Se ha modificado la contraseña correctamente.");
		try {
			//Validamos si el usuario esta activo
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeUsuarioActivo= (Integer) sessionNTx.selectOne("UsuarioDAO.existeUsuarioActivo", usuario);
			if (existeUsuarioActivo > 0) {
				throw new ExcepcionesCuadrillas("Error al modificar, el usuario esta inactivo.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("UsuarioDAO.modificaContrasena", usuario);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar la contraseña.");
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
	/**Metodo para consultar todos los usuarios existentes
	 * @param uid unico de registro
	 * @return regresa lista de usuarios
	 * @throws Exception crea una excepcion
	 */
	@SuppressWarnings("unchecked")
	public List<UsuarioDTO> consultaListaUsuario(String uid) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<UsuarioDTO> listaUsuario = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.debug(uid, this.getClass(), "Consultando");
			//Se hace una consulta a la tabla contacto
			listaUsuario = sessionNTx.selectList("UsuarioDAO.consultaListaUsuario");
			if ( listaUsuario.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen catalogos definidos.");
			}
		}catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaUsuario;
		
	}
}
