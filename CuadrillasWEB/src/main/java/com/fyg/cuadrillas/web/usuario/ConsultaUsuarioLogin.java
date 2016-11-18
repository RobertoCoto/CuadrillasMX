package com.fyg.cuadrillas.web.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;
import com.fyg.cuadrillas.dto.usuario.UsuarioRespuesta;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.google.gson.Gson;
/**
 * Servlet implementation class ConsultaUsuarioLogin
 */
public class ConsultaUsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuarioLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioRespuesta respuesta = new UsuarioRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			//se obtiene valores de usuario y contrasena
			String user = request.getParameter("usuario");
			String password = request.getParameter("contrasena");
			
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080");
	        
	        //crea objeto del negocio usuario
	        final UsuariosNegocio negocio = new UsuariosNegocio();
	        
	        //usuarios
	        UsuarioDTO usuario = new UsuarioDTO();
	        usuario.setUsuario(user);
	        usuario.setContrasena(password);
	        respuesta = negocio.loginUsuario(usuario);
	        //convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch(Exception e) {
			System.out.println("errores" + e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
		
	}

}
