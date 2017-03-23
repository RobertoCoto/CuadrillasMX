package com.fyg.cuadrillas.web.agenda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaRespuesta;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;
/**
 * Servlet implementation class ConsultaAgendaSemanal
 */
public class ConsultaAgendaSemanal extends HttpServlet {
	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaAgendaSemanal() {
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
		AgendaRespuesta respuesta = new AgendaRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Integer idContrato = Integer.parseInt(request.getParameter("idContrato"));
			Integer noSemana = Integer.parseInt(request.getParameter("noSemana"));
			String fechaBusqueda = request.getParameter("fechaBusqueda");
			//crea objeto de negocio
			final AgendaNegocio  negocio = new AgendaNegocio();
			AgendaDTO agenda = new AgendaDTO();
			agenda.setIdContrato(idContrato);
			agenda.setNoSemana(noSemana);
			agenda.setFechaBusqueda(fechaBusqueda);
			respuesta = negocio.consultaAgendaSemanal(agenda);
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
