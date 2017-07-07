package com.fyg.cuadrillas.web.contrato;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.contrato.ContratoDocumentoDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDocumentoRespuesta;
import com.fyg.cuadrillas.negocio.ContratoNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ConsultaDocumentosContrato
 */
public class ConsultaDocumentosContrato extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaDocumentosContrato() {
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
		ContratoDocumentoRespuesta respuesta = new ContratoDocumentoRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Integer idContrato =  Integer.parseInt(request.getParameter("idContrato"));

			//crea objeto de negocio
			final ContratoNegocio negocio = new ContratoNegocio();
			ContratoDocumentoDTO contratoDocumento = new ContratoDocumentoDTO();
			contratoDocumento.setIdContrato(idContrato);
			respuesta = negocio.consultaDocumentoCon(contratoDocumento);
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
