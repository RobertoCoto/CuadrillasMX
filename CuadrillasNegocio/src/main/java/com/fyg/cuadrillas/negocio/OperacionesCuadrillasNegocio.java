package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.dto.Usuario;
import com.fyg.cuadrillas.dao.ConsultasCuadrillasDAO;
import com.fyg.cuadrillas.dao.OperacionesCuadrillasDAO;

public class OperacionesCuadrillasNegocio {
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
			listaUsuario = new ConsultasCuadrillasDAO().consultaUsuario(uid, usuario);
			 for (int i = 0; i < listaUsuario.size(); i++) {
              if (listaUsuario.get(i).getUsuario().equals(usuario.getUsuario())) {
            	  if (listaUsuario.get(i).getEstatus().equals("A")) {
            		//Mandamos a la parte del dao
                	  OperacionesCuadrillasDAO dao = new OperacionesCuadrillasDAO();
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
}
