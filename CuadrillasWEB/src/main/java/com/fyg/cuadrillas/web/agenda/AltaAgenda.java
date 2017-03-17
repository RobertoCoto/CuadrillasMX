package com.fyg.cuadrillas.web.agenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AltaAgenda
 */
public class AltaAgenda extends HttpServlet {
	/**
	 * serial uid
	 */
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
			List<FileItem> multiparts = null;
			String jSonEntrada = null;
			String dataJson = null;
			if (ServletFileUpload.isMultipartContent(request)) {
				  multiparts = (List<FileItem>) new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				  for (FileItem item : multiparts) {
					  if (item.isFormField()) {
						  if (item.getFieldName().trim().equalsIgnoreCase("jsonAgenda")) {
							  System.out.println(item.getString());
							  dataJson = item.getString();
							  jSonEntrada = new String (dataJson.getBytes ("iso-8859-1"), "UTF-8");
						  }
					  }
				   }

			}
			Gson gson = new GsonBuilder().create();
			AgendaDTO agenda = gson.fromJson(jSonEntrada, AgendaDTO.class);

			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */

			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();
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
