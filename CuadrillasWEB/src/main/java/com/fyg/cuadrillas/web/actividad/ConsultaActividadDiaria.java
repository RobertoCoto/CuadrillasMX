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
public class ConsultaActividadDiaria extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividadDiaria() {
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
		ActividadRespuesta respuesta = new ActividadRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
	try {
		Integer idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
		String fecha  = request.getParameter("fecha");
		/* descomentar para proxy FISA
		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080"); */
		//crea objeto de negocio
		final ActividadNegocio negocio = new ActividadNegocio();
		//valores
		ActividadDTO actividad = new ActividadDTO();
		actividad.setIdEmpleado(idEmpleado);
		actividad.setFechaActividad(fecha);
		respuesta = negocio.consultaActividadDiaria(actividad);
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
		respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
		respuesta.getHeader().setEstatus(false);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		out.println(sg.toJson(respuesta));
		out.flush();
	}
	}
}
