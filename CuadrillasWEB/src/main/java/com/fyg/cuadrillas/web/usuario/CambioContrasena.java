package com.fyg.cuadrillas.web.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class CambioContrasena
 */
public class CambioContrasena extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambioContrasena() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String contrasenaAnterior = request.getParameter("contrasenaAnterior");
			String contrasenaNueva = request.getParameter("contrasenaNueva");
			String repiteContrasena = request.getParameter("repiteContrasena");
			String user = request.getParameter("user");
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */
			
			 //crea objeto del negocio usuario
	        final UsuariosNegocio negocio = new UsuariosNegocio();
	        
	        //Login usuario
	        UsuarioDTO usuario = new UsuarioDTO();
	        usuario.setUsuario(user);
	        usuario.setContrasena(contrasenaAnterior);
	        usuario.setContrasenaNueva(contrasenaNueva);
	        usuario.setRepetirContrasenaNueva(repiteContrasena);
	        respuesta = negocio.modificaContrasena(usuario);
	        if (respuesta.isEstatus()) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
	      //convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch(Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.setMensajeFuncional("Error: " + e.getMessage());
			respuesta.setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
