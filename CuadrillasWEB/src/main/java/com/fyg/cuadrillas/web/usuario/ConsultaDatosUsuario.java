package com.fyg.cuadrillas.web.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;
import com.fyg.cuadrillas.dto.usuario.UsuarioRespuesta;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ConsultaDatosUsuario
 */
public class ConsultaDatosUsuario extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaDatosUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioRespuesta respuesta = new UsuarioRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			//se obtiene valores de usuario y contrasena
			String user = request.getParameter("user");
			//crea objeto del negocio usuario
	        final UsuariosNegocio negocio = new UsuariosNegocio();

	        //Login usuario
	        UsuarioDTO usuario = new UsuarioDTO();
	        usuario.setUsuario(user);
	        respuesta = negocio.consultaUsuarioDatos(usuario);
	        //convierte  a formato Json
	        if (respuesta.getHeader().isEstatus()) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
