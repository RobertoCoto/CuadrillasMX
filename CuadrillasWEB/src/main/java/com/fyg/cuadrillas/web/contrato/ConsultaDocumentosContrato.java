package com.fyg.cuadrillas.web.contrato;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
	 * Directorio para almacenar las imagenes de las incidencias.
	 */
	private static final String DESTINATION_DIR_PATH = "/documentos/contrato_documentos/";
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
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */

			//crea objeto de negocio
			final ContratoNegocio negocio = new ContratoNegocio();
			ContratoDocumentoDTO contratoDocumento = new ContratoDocumentoDTO();
			contratoDocumento.setIdContrato(idContrato);
			List<ContratoDocumentoDTO> res = new ArrayList<ContratoDocumentoDTO>();
			respuesta = negocio.consultaDocumentoCon(contratoDocumento);
			for (int i = 0; i < respuesta.getContratoDocumento().size(); i++) {
				ContratoDocumentoDTO con = new ContratoDocumentoDTO();
				String rutaSistema = System.getProperty("user.dir").replace("\\", "/");
				con.setIdDocumento(respuesta.getContratoDocumento().get(i).getIdDocumento());
				con.setIdContrato(respuesta.getContratoDocumento().get(i).getIdContrato());
				con.setNombre(respuesta.getContratoDocumento().get(i).getNombre());
				con.setDescripcionDocumento(respuesta.getContratoDocumento().get(i).getDescripcionDocumento());
				con.setFechaAlta(respuesta.getContratoDocumento().get(i).getFechaAlta());
				con.setUrl(rutaSistema + DESTINATION_DIR_PATH + respuesta.getContratoDocumento().get(i).getUrl());
				res.add(con);
			}
			//convierte  a formato Json
			out.println(sg.toJson(res));
			out.flush();
		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}

}
