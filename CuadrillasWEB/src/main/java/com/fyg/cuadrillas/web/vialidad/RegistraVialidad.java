package com.fyg.cuadrillas.web.vialidad;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.vialidad.VialidadCoordenadasDTO;
import com.fyg.cuadrillas.dto.vialidad.VialidadDTO;
import com.fyg.cuadrillas.negocio.VialidadNegocio;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class RegistraVialidad
 */
public class RegistraVialidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraVialidad() {
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
		List<VialidadCoordenadasDTO> coordenada = new ArrayList<VialidadCoordenadasDTO>();
		VialidadCoordenadasDTO datos = new VialidadCoordenadasDTO();
		
		
		try {
			String nombre = request.getParameter("nombre");
			String usuario = request.getParameter("usuario");
			
			//se parsea json
			JsonParser parser = new JsonParser();
			Object coordenadasVialidad = parser.parse(request.getParameter("coordenadasVialidad"));
			JSONObject jsonObject = (JSONObject) coordenadasVialidad;
			
			/*Proxy fisa
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080");
	        */
			
			//crea objeto de negocio
			final VialidadNegocio negocio = new VialidadNegocio();
			
			//Lista de direcciones
			VialidadDTO vialidad = new VialidadDTO();
			vialidad.setNombre(nombre);
			vialidad.setUsuarioAlta(usuario);
			vialidad.setUsuarioUltMod(usuario);
			
			//coordenadas
			Float latitud = (Float) jsonObject.get("latitud");
			Float longitud = (Float) jsonObject.get("longitud");
			
			datos.setLatitud(latitud);
			datos.setLongitud(longitud);
			
			coordenada.add(datos);
			vialidad.setCoordenadas(coordenada);
			
			respuesta = negocio.altaVialidad(vialidad);
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
