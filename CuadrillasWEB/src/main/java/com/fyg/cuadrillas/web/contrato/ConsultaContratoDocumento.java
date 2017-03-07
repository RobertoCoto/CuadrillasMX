package com.fyg.cuadrillas.web.contrato;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoRespuesta;
import com.fyg.cuadrillas.negocio.ContratoNegocio;


/**
 * Servlet implementation class ConsultaContratoDocumento
 */
public class ConsultaContratoDocumento extends HttpServlet {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Directorio para almacenar las imagenes de las incidencias.
	 */
	private static final String DESTINATION_DIR_PATH = "/bin/documentos/contratos/";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaContratoDocumento() {
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
		ContratoRespuesta respuesta = new ContratoRespuesta();
		try {
			Integer idContrato =  Integer.parseInt(request.getParameter("idContrato"));

			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */

			//crea objeto de negocio
			final ContratoNegocio negocio = new ContratoNegocio();

			ContratoDTO contrato = new ContratoDTO();
			contrato.setIdContrato(idContrato);
			respuesta = negocio.consultaContratoDocumento(contrato);
			String resultado = null;
			for (int i = 0; i < respuesta.getContrato().size(); i++) {
				resultado = respuesta.getContrato().get(i).getUrl();
			}

			String nombreArchivo =  resultado;
			// ruta sistema
			String rutaSistema = System.getProperty("user.dir").replace("\\", "/");
			//Obtengo el path absoluto de la imagen
			String carpetaArchivos = rutaSistema + DESTINATION_DIR_PATH + nombreArchivo;
			LogHandler.debug(null, this.getClass(), "carpetaArchivos = " + carpetaArchivos);
			//Obtener el mimeType dinamicamente
			String mime = null;
			LogHandler.debug(null, this.getClass(), "nombreArchivo = " + nombreArchivo);
			String[] array =  nombreArchivo.split("\\.");
			LogHandler.debug(null, this.getClass(), "array = " + array.length);

			if ( array.length != 2 ) {
				LogHandler.debug(null, this.getClass(), "nombre de archivo INCORRECTO");
				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				return;
			}

			if (array[1].equals("doc")) {
				mime = "application/msword";
			}
			else if (array[1].equals("docx")) {
				mime = "application/msword";
			}
			else if (array[1].equals("pdf")) {
				mime = "application/pdf";
			}
			if (mime == null) {
				LogHandler.debug(null, this.getClass(), "mime NULL");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}

			response.setContentType(mime);
			LogHandler.debug(null, this.getClass(), "Tipo mime = " + mime);
			File file = new File(carpetaArchivos);
			response.setContentLength((int) file.length());
			LogHandler.debug(null, this.getClass(), "Content Length = " + (int) file.length());

			FileInputStream entrada = new FileInputStream(file);
			OutputStream salida = response.getOutputStream();

			//Copio el contenido del archivo a un output Stream
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = entrada.read(buffer)) >= 0) {
				salida.write(buffer, 0, count);
			}
			salida.close();
			entrada.close();

		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
