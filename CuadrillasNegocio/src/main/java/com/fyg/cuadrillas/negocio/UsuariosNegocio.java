package com.fyg.cuadrillas.negocio;


import java.util.List;


import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.PerfilDAO;
import com.fyg.cuadrillas.dao.UsuarioDAO;
import com.fyg.cuadrillas.dto.Perfil;
import com.fyg.cuadrillas.dto.Usuario;

public class UsuariosNegocio {
	/**
	 * Objeto para recibir  datos perfil
	 */
	 private Perfil perfilUsuario;
	 /**
		 * Metodo para dar de alta un usuario
		 * @param usuario Recibe valores de usuario
		 * @return regresa la respuesta si fue registrado
		 */
		public EncabezadoRespuesta altaUsuario(Usuario usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "altaUsuario - Datos Entrada: " + usuario);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			//Para perfiles
			List<Perfil> listaPerfil = null;
			try {
				//Validaciones de campos.
				if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
					throw new ExcepcionesCuadrillas("Es necesario especificar un usuario.");
				} 
				 //se incia con la obtencion del perfil
				 perfilUsuario = new Perfil();
				 perfilUsuario.setIdPerfil(usuario.getIdPerfil());
				 listaPerfil = new PerfilDAO().consultaPerfil(uid, perfilUsuario);
				 for (int k = 0; k < listaPerfil.size(); k++) {
					 int idPerfil = listaPerfil.get(k).getIdPerfil();
					 if (idPerfil <= 0) {
						 throw new ExcepcionesCuadrillas("no existe el perfil");
					 }
				 }
					UsuarioDAO dao = new UsuarioDAO();
					respuesta = dao.altaUsuario(uid, usuario);
			} catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "altaUsuario - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			catch  (Exception ex) {
				LogHandler.error(uid, this.getClass(), "altaUsuario- Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			LogHandler.debug(uid, this.getClass(), "altaUsuario - Daton Salida: " + respuesta);
			return respuesta;
		}
		/**
		 * metodo para dar de baja un usuario
		 * @param usuario recibe valores de usuario
		 * @return regresa una respuesta
		 */
		public EncabezadoRespuesta bajaUsuario(Usuario usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "registraSitio - Daton Entrada: " + usuario);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			List<Usuario> listaUsuario = null;
			try {
				//Validaciones Negocio
				listaUsuario = new UsuarioDAO().consultaUsuario(uid, usuario);
				 for (int i = 0; i < listaUsuario.size(); i++) {
	              if (listaUsuario.get(i).getUsuario().equals(usuario.getUsuario())) {
	            	  if (listaUsuario.get(i).getEstatus().equals("A")) {
	            		//Mandamos a la parte del dao
	            		  UsuarioDAO dao = new UsuarioDAO();
	          			  respuesta = dao.bajaUsuario(uid, usuario);
	            	  } else {
	            		  throw new ExcepcionesCuadrillas("El usuario ya se encuentra inactivo.");
	            	  }
					 } else if (listaUsuario.get(i).getUsuario() == null || listaUsuario.get(i).getUsuario().isEmpty()) {
						 throw new ExcepcionesCuadrillas("No existe el usuario.");
					 }
				 }
			}
			catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "bajaUsuario - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			catch  (Exception ex) {
				LogHandler.error(uid, this.getClass(), "bajaUsuario - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			LogHandler.debug(uid, this.getClass(), "bajaUsuario - Datos Salida: " + respuesta);
			return respuesta;
	}
	/**
	 * Metodo para realizar login de usuario
	 * @param usuario recibe valores del usuario
	 * @return retorna los datos del usuario
	 */
		public List<Usuario> loginUsuario(Usuario usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "loginUsuario - Datos Entrada: " + usuario);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Consulta correcta.");
			List<Usuario> loginUsuario = null;
		    try {
		    	loginUsuario = new UsuarioDAO().loginUsuario(uid, usuario);
		    	//validaciones
		    	if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
		    		throw new ExcepcionesCuadrillas("Es necesario el campo usuario.");
		    	} else if (usuario.getContrasena() == null || usuario.getContrasena().isEmpty()) {
		    		throw new ExcepcionesCuadrillas("Es necesario la contraseña.");
		    	} else { 
		    		for (int i = 0; i < loginUsuario.size(); i++) {
		    			if (loginUsuario.get(i).getUsuario().isEmpty()) {
		    				throw new ExcepcionesCuadrillas("El usuario no existe.");
		    			}
		    	}
		    		System.out.println(loginUsuario);
		    	}
		    } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "loginUsuario - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "loginUsuario - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "loginUsuario - Datos Salida: " + respuesta);
			return loginUsuario;
		}	
}
