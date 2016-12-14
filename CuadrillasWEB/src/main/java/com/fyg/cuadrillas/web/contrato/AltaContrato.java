package com.fyg.cuadrillas.web.contrato;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;
import com.fyg.cuadrillas.negocio.ContratoNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class AltaContrato
 */
public class AltaContrato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaContrato() {
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
			Integer numeroContrato = Integer.parseInt(request.getParameter("numeroContrato"));
			Integer idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
			Integer idVialidad = Integer.parseInt(request.getParameter("idVialidad"));
			String direccionInicial = request.getParameter("direccionInicial");
			float latitudInicial = Float.parseFloat(request.getParameter("latitudInicial"));
			float longitudInicial = Float.parseFloat(request.getParameter("longitudInicial"));
			String direccionFinal = request.getParameter("direccionInicial");
			float latitudFinal = Float.parseFloat(request.getParameter("latitudFinal"));
			float longitudFinal = Float.parseFloat(request.getParameter("longitudFinal"));
			String observaciones = request.getParameter("observaciones");
			String url = request.getParameter("url");
			String usuario = request.getParameter("usuario");
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */
			
			//crea objeto de negocio
			final ContratoNegocio negocio = new ContratoNegocio();
			
			ContratoDTO contrato = new ContratoDTO();
			contrato.setNumeroContrato(numeroContrato);
			contrato.setIdEmpleado(idEmpleado);
			contrato.setIdVialidad(idVialidad);
			contrato.setDireccionInicial(direccionInicial);
			contrato.setLatitudInicial(latitudInicial);
			contrato.setLongitudInicial(longitudInicial);
			contrato.setDireccionFinal(direccionFinal);
			contrato.setLatitudFinal(latitudFinal);
			contrato.setLongitudFinal(longitudFinal);
			contrato.setUrl(url);
			contrato.setObservaciones(observaciones);
			contrato.setUsuarioAlta(usuario);
			respuesta = negocio.altaContrato(contrato);
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
