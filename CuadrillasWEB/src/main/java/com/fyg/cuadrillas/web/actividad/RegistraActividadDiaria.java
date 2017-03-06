package com.fyg.cuadrillas.web.actividad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDTO;
import com.fyg.cuadrillas.negocio.ActividadNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class AltaActividad
 */
public class RegistraActividadDiaria extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraActividadDiaria() {
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
			Integer idCuadrilla = Integer.parseInt(request.getParameter("idCuadrilla"));
			String tramoInicialPlanificado = request.getParameter("tramoInicialPlanificado");
			String tramoFinalPlanificado = request.getParameter("tramoFinalPlanificado");
			Float alcancePlanificado = Float.parseFloat(request.getParameter("alcancePlanificado"));
			String tramoInicialReal = request.getParameter("tramoInicialReal");
			String tramoFinalReal = request.getParameter("tramoFinalReal");
			Float alcanceReal = Float.parseFloat(request.getParameter("alcanceReal"));
			String nombreActividad = request.getParameter("nombreActividad");
			String  prioridad = request.getParameter("prioridad");
			String estado = request.getParameter("estado");
			Integer tiempoDestinado = Integer.parseInt(request.getParameter("tiempoDestinado"));
			Integer numeroPersonas = Integer.parseInt(request.getParameter("numeroPersona"));
			Integer numeroUnidades = Integer.parseInt(request.getParameter("numeroUnidades"));
			Float porcentajeCompletado = Float.parseFloat(request.getParameter("porcentajecompletado"));
			String listoVencido = request.getParameter("listoVencido");
			String observacionesActividad = request.getParameter("observacionesActividad");
			String usuario = request.getParameter("usuario");
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */

			//crea objeto de negocio
			final ActividadNegocio negocio = new ActividadNegocio();

			//datos
			ActividadDTO actividad = new ActividadDTO();
			actividad.setIdCuadrilla(idCuadrilla);
			actividad.setTramoInicialPlanificado(tramoInicialPlanificado);
			actividad.setTramoFinalPlanificado(tramoFinalPlanificado);
			actividad.setAlcancePlanificado(alcancePlanificado);
			actividad.setTramoInicialReal(tramoInicialReal);
			actividad.setTramoFinalReal(tramoFinalReal);
			actividad.setAlcanceReal(alcanceReal);
			actividad.setActividad(nombreActividad);
			actividad.setPrioridad(prioridad);
			actividad.setEstado(estado);
			actividad.setTiempoEstimado(tiempoDestinado);
			actividad.setNumeroPersonas(numeroPersonas);
			actividad.setNumeroUnidades(numeroUnidades);
			actividad.setPorcentajeCompletado(porcentajeCompletado);
			actividad.setListoVencido(listoVencido);
			actividad.setObservacionesActividades(observacionesActividad);
			actividad.setUsuarioAlta(usuario);
			respuesta = negocio.registraActividad(actividad);
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
