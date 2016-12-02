package com.fyg.cuadrillas.web.cuadrilla;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.cuadrilla.CuadrillaDTO;
import com.fyg.cuadrillas.negocio.CuadrillaNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class BajaCuadrilla
 */
public class BajaCuadrilla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaCuadrilla() {
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
			Integer idCuadrilla = Integer.parseInt(request.getParameter("idCuadrilla"));
			String usuario = request.getParameter("usuario");
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */
			
			//crea objeto de negocio
			final CuadrillaNegocio negocio = new CuadrillaNegocio();
			
			CuadrillaDTO cuadrilla = new CuadrillaDTO();
			cuadrilla.setIdCuadrilla(idCuadrilla);
			cuadrilla.setUsuarioAlta(usuario);
			respuesta = negocio.bajaCuadrilla(cuadrilla);
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
			
		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.setMensajeFuncional("Error: " + e.getMessage());
			respuesta.setEstatus(false);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
