package com.fyg.cuadrillas.web.actividad;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDocumentosDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class RegistraFotoActividad
 */
public class RegistraFotoActividad extends HttpServlet {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Directorio para almacenar la informacion.
	 */
	private static final String DESTINATION_DIR_PATH = "C:/Sistema_TATEI/actividades/";

	/**
	 * Directorio para almacenar las imagenes de las incidencias.
	 */
	private String uploadDirectory = "";
	/**
	 * Carga la ruta donde se guardara el archivo.
	 * @param config Congiguracion Inicial del Servlet.
	 */
	public void init(ServletConfig config) throws ServletException {

	    super.init(config);
	    String realPath = DESTINATION_DIR_PATH;
	    //String rutaDestino = System.getProperty("user.dir").replace("\\", "/") + realPath;
	    String rutaDestino = realPath;
	    uploadDirectory = rutaDestino;
	    System.out.println("INIT uploadDirectory..." + uploadDirectory);

	    File destinationDir = new File(uploadDirectory);
	    if ( !destinationDir.isDirectory()) {
	      throw new ServletException(uploadDirectory + " no es un directorio valido.");
	    }
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraFotoActividad() {
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String dataJson = "";
		String json = "";
		try {
			String rutaImagen = "";
			List<FileItem> multiparts = null;
			String fileName = "";
			String name = "";
			String rutaArchivo = "";
			try {
				if (ServletFileUpload.isMultipartContent(request)) {
					  multiparts = (List<FileItem>) new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					  for (FileItem item : multiparts) {
				          System.out.println("Nombre Archivo FormField() = " + item.getFieldName());
				          System.out.println("item: " + item.toString());
						  if (item.isFormField()) {

							  if (item.getFieldName().trim().equalsIgnoreCase("json")) {
								  System.out.println(item.getString());
								   dataJson = item.getString();
								  json = new String(dataJson.getBytes("iso-8859-1"), "UTF-8");
								  LogHandler.debug(null, this.getClass(), "JSON AQUI: " + json);
							  }
					          if (item.getFieldName().trim().equalsIgnoreCase("actividad")) {
					              fileName = item.getString().trim();
					              System.out.println("Nombre Archivo FormField() = " + fileName );
					          }
						  }
					      else {
					            name = new File(item.getName()).getName();
					            System.out.println("name: " + name.toString());
					            item.write( new File(uploadDirectory
					            		+ File.separator + new SimpleDateFormat("dd-MM-yyyy_HHmmss_").format(new Date()) + name));
					            rutaArchivo = uploadDirectory + File.separator + name;
					            System.out.println("Ruta Archivo compuesta: " + rutaArchivo);
					            rutaImagen = new SimpleDateFormat("dd-MM-yyyy_HHmmss_").format(new Date()) + name;
					            System.out.println("Archivo Guardado en la siguiente ruta: " + rutaImagen);
					      }
					   }

				}
			} catch (Exception e) {
				System.out.println("No se enviaron todos los parametros . Error: " + e.getMessage());
				e.printStackTrace();
				throw new Exception("FALTAN PARAMETROS");
			}
			Gson gson = new GsonBuilder().create();
			ActividadDiariaDocumentosDTO documento = gson.fromJson(json, ActividadDiariaDocumentosDTO.class);
			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();
			documento.setUrl(rutaImagen);
			respuesta = negocio.registraActividadDiariaDocumentos(documento);
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
