package com.fyg.cuadrillas.web.agenda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.agenda.AgendaDetalleDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ValidaEliminaAgendaDetalle
 */
public class ValidaEliminaAgendaDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidaEliminaAgendaDetalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			//Forma Simple
			String idAgenda = request.getParameter("idAgenda").toString();
			String idAgendaDetalle = request.getParameter("idAgendaDetalle").toString();
			Gson gson = new GsonBuilder().create();
			AgendaDetalleDTO agenda = new AgendaDetalleDTO();
			agenda.setIdAgenda(Integer.valueOf(idAgenda));
			agenda.setIdAgendaDetalle(Integer.valueOf(idAgendaDetalle));
			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();
			respuesta = negocio.validaEliminaAgendaDetalle(agenda);
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
