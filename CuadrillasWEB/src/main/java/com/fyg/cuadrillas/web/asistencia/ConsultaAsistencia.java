package com.fyg.cuadrillas.web.asistencia;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaDTO;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaRespuesta;
import com.fyg.cuadrillas.negocio.AsistenciaNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ConsultaAsistencia
 */
public class ConsultaAsistencia extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaAsistencia() {
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
		AsistenciaRespuesta respuesta = new AsistenciaRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Integer idCuadrilla = Integer.parseInt(request.getParameter("idCuadrilla"));

			 Date fechaActual = new Date();
			 SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			 String fechaSistema = formateador.format(fechaActual);

			//crea objeto de negocio
			final AsistenciaNegocio negocio = new AsistenciaNegocio();
			AsistenciaDTO  asistencia = new AsistenciaDTO();
			asistencia.setIdCuadrilla(idCuadrilla);
			asistencia.setFecha(fechaSistema);
			LogHandler.debug(null, this.getClass(), "Consultando " + fechaSistema );
			respuesta = negocio.consultaAsistencia(asistencia);
			if (respuesta.getHeader().isEstatus()) {
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
