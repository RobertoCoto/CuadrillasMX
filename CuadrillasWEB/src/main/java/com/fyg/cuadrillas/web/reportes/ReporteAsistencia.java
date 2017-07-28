package com.fyg.cuadrillas.web.reportes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.reporte.PeticionReporteDTO;
import com.fyg.cuadrillas.dto.reporte.RespuestaReporteDTO;
import com.fyg.cuadrillas.negocio.ReporteNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ReporteAsistencia
 */
public class ReporteAsistencia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteAsistencia() {
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
		RespuestaReporteDTO respuesta = new RespuestaReporteDTO();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			String fechaInicio = request.getParameter("fechaInicio");
			String fechaFin = request.getParameter("fechaFin");

			//crea objeto de negocio
			final ReporteNegocio negocio = new ReporteNegocio();

			//Lista de direcciones
			PeticionReporteDTO peticion = new PeticionReporteDTO();
			peticion.setFechaInicio(fechaInicio);
			peticion.setFechaFin(fechaFin);
			respuesta = negocio.reporteAsistencia(peticion);
			if (respuesta.getHeader().isEstatus()) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		}  catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
