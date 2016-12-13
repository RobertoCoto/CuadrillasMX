package com.fyg.cuadrillas.web.actividad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadRespuesta;
import com.fyg.cuadrillas.negocio.ActividadNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ConsultaActividad
 */
public class ConsultaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividad() {
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
			ActividadRespuesta respuesta = new ActividadRespuesta();
			Gson sg = new Gson();
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
		try {
			Integer idCuadrilla = Integer.parseInt(request.getParameter("idCuadrilla"));
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */
			
			//crea objeto de negocio
			final ActividadNegocio negocio = new ActividadNegocio();
			
			//valores
			ActividadDTO actividad = new ActividadDTO();
			actividad.setIdCuadrilla(idCuadrilla);
			respuesta = negocio.consultaActividad(actividad);
			
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
