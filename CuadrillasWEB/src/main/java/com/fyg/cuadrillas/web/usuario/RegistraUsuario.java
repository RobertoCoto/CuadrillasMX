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
 * Servlet implementation class RegistraUsuario
 */
public class RegistraUsuario extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			Integer idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
			String nombre = request.getParameter("nombre");
			String apellidoPat = request.getParameter("apellidoPat");
			String apellidoMat = request.getParameter("apellidoMat");
			String sexo = request.getParameter("sexo");
			String rfc = request.getParameter("rfc");
			String fechaNac = request.getParameter("fechaNac");
			Integer idPerfil = Integer.parseInt(request.getParameter("idPerfil"));

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
	        usuario.setContrasena(password);
	        usuario.setNombre(nombre);
	        usuario.setApellidoPat(apellidoPat);
	        usuario.setApellidoMat(apellidoMat);
	        usuario.setSexo(sexo);
	        usuario.setRfc(rfc);
	       usuario.setFechaNacimiento(fechaNac);
	        usuario.setIdPerfil(idPerfil);
	        usuario.setIdEmpleado(idEmpleado);
	        respuesta = negocio.altaUsuario(usuario);

	        if (respuesta.isEstatus()) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
	      //convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();

		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.setMensajeFuncional("Error: " + e.getMessage());
			respuesta.setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
