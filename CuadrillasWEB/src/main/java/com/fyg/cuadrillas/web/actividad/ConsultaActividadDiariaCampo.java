package com.fyg.cuadrillas.web.actividad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoRespuesta;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ConsultaActividadDiariaCampo
 */
public class ConsultaActividadDiariaCampo extends HttpServlet {
	/**
	 * SerialUID
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividadDiariaCampo() {
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
		ActividadDiariaCampoRespuesta respuesta = new ActividadDiariaCampoRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

	try {
		Integer idAgendaDetalle = Integer.parseInt(request.getParameter("idAgendaDetalle"));

		//crea objeto de negocio
		final AgendaNegocio negocio = new AgendaNegocio();

		//valores
		ActividadDiariaCampoDTO actividadDiaria = new ActividadDiariaCampoDTO();
		actividadDiaria.setIdAgendaDetalle(idAgendaDetalle);
		respuesta = negocio.consultaActividadDiaria(actividadDiaria);
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
