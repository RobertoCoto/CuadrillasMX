package com.fyg.cuadrillas.web.contrato;

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

/**
 * Servlet de prueba
 * @author hersonSamano
 * @version 1.0
 * @fecha_creacion: 25-02-2017
 */
public class Test extends HttpServlet {
	/**
	 *Serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Directorio para almacenar la informacion.
	 */
	private static final String DESTINATION_DIR_PATH = "/testUpload";

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

	    String realPathoracle = System.getProperty("user.dir").replace("\\", "/");
	    System.out.println("INIT..." + realPathoracle);
	    String realPath = DESTINATION_DIR_PATH;
	    String rutaDestino = realPathoracle + realPath;
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
    public Test() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// Respuesta JSON
		response.setContentType("application/json");
		String json = "La incidencia se registro correctamente.";

		try {
			String rutaImagen = "";

			try {
				List<FileItem> multiparts = null;
				System.out.println("ARCHIVO...");
				String fileName = "";
				String name = "";
				String rutaArchivo = "";
				if (ServletFileUpload.isMultipartContent(request)) {
					  multiparts = (List<FileItem>) new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					  for (FileItem item : multiparts) {
				          System.out.println("Nombre Archivo FormField() = " + item.getFieldName());
				          System.out.println("item: " + item.toString());
						  if (item.isFormField()) {

							  if (item.getFieldName().trim().equalsIgnoreCase("json")) {
								  System.out.println(item.getString());
								  //incidencia.setIdAmbito(Integer.valueOf(item.getString()));
							  }
					          if (item.getFieldName().trim().equalsIgnoreCase("contrato")) {
					              fileName = item.getString().trim();
					              System.out.println("Nombre Archivo FormField() = " + fileName );
					          }
						  }
					      else {
					            name = new File(item.getName()).getName();
					            System.out.println("name: " + name.toString());
					            item.write( new File(uploadDirectory
					            		+ File.separator + new SimpleDateFormat("dd-MM-yyyy hhMMss ").format(new Date()) + name));
					            rutaArchivo = uploadDirectory + File.separator + name;
					            System.out.println("Ruta Archivo compuesta: " + rutaArchivo);
					            rutaImagen = name;
					            System.out.println("Archivo Guardado en la siguiente ruta: " + rutaImagen);
					      }
					   }

				}

			} catch (Exception e) {
				System.out.println("No se enviaron todos los parametros para registrar la indicencia. Error: " + e.getMessage());
				e.printStackTrace();
				throw new Exception("FALTAN PARAMETROS");
			}

			System.out.println("Va a llamar al metodo de negocio");


			// Regresa catalogo en formato json
			PrintWriter out = response.getWriter();
			out.println("{ \"success\": true, \"mensaje\" : \" " + json + " \" }");
			out.flush();

		} catch (Exception e) {
			System.out.println("Error al registrar la incidencia. Error: " + e.getMessage());
			//Regresa error en un formato tipo json
			PrintWriter out = response.getWriter();
			out.println("{ \"success\": false, \"mensaje\" : \" Error al registrar la incidencia. \" }");
			out.flush();

		}
	}

}
