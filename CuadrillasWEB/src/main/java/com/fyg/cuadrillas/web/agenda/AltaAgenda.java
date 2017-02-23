package com.fyg.cuadrillas.web.agenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class AltaAgenda
 */
public class AltaAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaAgenda() {
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
			//leer json Array
			JSONParser parser = new JSONParser();
			Object JSONAltaAgenda = parser.parse(request.getParameter("JSONAltaAgenda"));
			JSONObject jsonObject = (JSONObject) JSONAltaAgenda;
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */
			
			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();
			
			//se crea objeto agenda
			AgendaDTO agenda = new AgendaDTO();
			
			//se desglosan los datos para convertirlos a objetos 
			Integer idContrato = (Integer) jsonObject.get("idContrato");
			String  fechaInicio = (String) jsonObject.get("fechaInicio");
			String  fechaFin = (String) jsonObject.get("fechaFin");
			Integer noHoras = (Integer) jsonObject.get("noHoras");
			Integer noTrabajadores = (Integer) jsonObject.get("noTrabajadores");
			Integer noSemana = (Integer) jsonObject.get("noSemana"); 
			String usuario = (String) jsonObject.get("codigoContrato");
			
			//se pasan a nuestros objetos 
			agenda.setIdContrato(idContrato);
			agenda.setFechaInicio(fechaInicio);
			agenda.setFechaFin(fechaFin);
			agenda.setNoHoras(noHoras);
			agenda.setNoSemana(noSemana);
			agenda.setNoTrabajadores(noTrabajadores);
			agenda.setUsuario(usuario);
			respuesta = negocio.altaAgenda(agenda);
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
