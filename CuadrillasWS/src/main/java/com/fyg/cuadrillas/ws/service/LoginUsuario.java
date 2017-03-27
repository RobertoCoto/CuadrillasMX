package com.fyg.cuadrillas.ws.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;
import com.fyg.cuadrillas.dto.usuario.UsuarioRespuesta;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.google.gson.Gson;

@Path("/loginUsuario")
public class LoginUsuario {
	/**
	 * Metodo para iniciar sesion
	 * @param user recibe usuario
	 * @param pass recibe contraseña
	 * @return regresa respuesta del login
	 */
	@GET
	@Path("/user")
	@Produces({MediaType.APPLICATION_JSON})
	public Response loginUser(@QueryParam("usuario")String user, @QueryParam("password") String pass) {
		 UsuarioRespuesta respuesta = new UsuarioRespuesta();
		 Gson sg = new Gson();
		try {
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setUsuario(user);
			usuario.setContrasena(pass);
			UsuariosNegocio negocio = new UsuariosNegocio();
			respuesta = negocio.loginUsuarioWS(usuario);
		} catch (Exception e) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		 String result = sg.toJson(respuesta);
		return Response.ok().entity(result).build();
	}

}
