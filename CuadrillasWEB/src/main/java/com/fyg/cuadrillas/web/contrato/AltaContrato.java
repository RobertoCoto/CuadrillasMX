package com.fyg.cuadrillas.web.contrato;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;
import com.fyg.cuadrillas.negocio.ContratoNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class AltaContrato
 */
public class AltaContrato extends HttpServlet {
	/**
	 * serial uid
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
    public AltaContrato() {
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
					            item.write( new File(uploadDirectory + File.separator + new SimpleDateFormat("dd-MM-yyyy hhMMss ").format(new Date()) + name));
					            rutaArchivo = uploadDirectory + File.separator + new SimpleDateFormat("dd-MM-yyyy hhMMss ").format(new Date()) + name;
					            rutaImagen = rutaArchivo;
					      }
					   }

				}
			} catch (Exception e) {
				System.out.println("No se enviaron todos los parametros para registrar la indicencia. Error: " + e.getMessage());
				e.printStackTrace();
				throw new Exception("FALTAN PARAMETROS");
			}
			//leer json Array
			JSONParser parser = new JSONParser();
			Object jsonContrato = parser.parse(request.getParameter("JSONContrato"));
			JSONObject jsonObject = (JSONObject) jsonContrato;

			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */

			//crea objeto de negocio
			final ContratoNegocio negocio = new ContratoNegocio();

			ContratoDTO contrato = new ContratoDTO();
			//se desglosan los datos para convertirlos a objetos
			String codigoContrato = (String) jsonObject.get("codigoContrato");
			String codigoDocumento = (String) jsonObject.get("codigoDocumento");
			String codigoEmpresa = (String) jsonObject.get("codigoEmpresa");
			String codigoVialidad = (String) jsonObject.get("codigoVialidad");
			String numeroDocumento = (String) jsonObject.get("numeroDocumento");
			Double metros = (Double) jsonObject.get("metros");
			Double monto = (Double) jsonObject.get("monto");
			Double subtotal = (Double) jsonObject.get("subtotal");
			String fechaInicio = (String) jsonObject.get("fechaInicio");
			String fechaTermino = (String) jsonObject.get("fechaTermino");
			String usuario = (String) jsonObject.get("usuario");
			Integer idCuadrilla = (Integer) jsonObject.get("idCuadrilla");
			JSONArray listaCoordenadas = (JSONArray) jsonObject.get("coordenadas");

			//se crea objeto lista
			List<CoordenadaDTO> coordenadas = new ArrayList<CoordenadaDTO>();

			//se asignan para enviarlos a negocio
			contrato.setCodigoContrato(codigoContrato);
			contrato.setCodigoDocumento(codigoDocumento);
			contrato.setCodigoEmpresa(codigoEmpresa);
			contrato.setCodigoVialidad(codigoVialidad);
			contrato.setNumeroDocumento(numeroDocumento);
			contrato.setMetros(metros);
			contrato.setMonto(monto);
			contrato.setSubtotal(subtotal);
			contrato.setFechaInicio(fechaInicio);
			contrato.setFechaFin(fechaTermino);
			contrato.setUsuarioAlta(usuario);
			contrato.setIdCuadrilla(idCuadrilla);
			contrato.setUrl(rutaImagen);
			LogHandler.debug(null, this.getClass(), "RUTA DE LA IMAGEN: " + rutaImagen);
			//se obtienen las cordenadas

			for (int i = 0; i < listaCoordenadas.size(); i++)
			{
				CoordenadaDTO codigo = new CoordenadaDTO();
				JSONObject direcc = (JSONObject) listaCoordenadas.get(i);

				String direccion = (String) direcc.get("direccion");
				Float latitud = (Float) direcc.get("latitud");
				Float longitud =  (Float) direcc.get("longitud");

				codigo.setDireccion(direccion);
				codigo.setLatitud(latitud);
				codigo.setLongitud(longitud);

				coordenadas.add(codigo);
				//LogHandler.debug(null, this.getClass(), "datos " + coordenadas);

			}
			contrato.setCoordenadas(coordenadas);

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
