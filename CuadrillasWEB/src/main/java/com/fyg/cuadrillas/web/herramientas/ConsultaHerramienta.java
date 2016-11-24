package com.fyg.cuadrillas.web.herramientas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.herramienta.HerramientaDTO;
import com.fyg.cuadrillas.dto.herramienta.HerramientaRespuesta;
import com.fyg.cuadrillas.negocio.HerramientaNegocio;
import com.google.gson.Gson;
/**
 * Servlet implementation class ConsultaHerramienta
 */
public class ConsultaHerramienta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaHerramienta() {
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
		HerramientaRespuesta respuesta = new HerramientaRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			String nombreHerramienta = request.getParameter("nombreHerramienta");
			String orden = request.getParameter("orden");
			
			/* QUITAR PARA PROXY FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080");
	        */
			
			//crea objeto de negocio
			final HerramientaNegocio negocio = new HerramientaNegocio();
			
			//Lista de direcciones
			HerramientaDTO herramienta = new HerramientaDTO();
			herramienta.setNombre(nombreHerramienta);
			herramienta.setOrden(orden);
			
			respuesta = negocio.consultarHerramienta(herramienta);
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		}  catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
