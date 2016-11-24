package com.fyg.cuadrillas.web.vialidad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.dto.vialidad.VialidadDTO;
import com.fyg.cuadrillas.negocio.VialidadNegocio;
import com.google.gson.Gson;
/**
 * Servlet implementation class EliminaVialidad
 */
public class EliminaVialidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaVialidad() {
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
			String latitud = request.getParameter("latitud");
			String longitud = request.getParameter("longitud");
			String usuario = request.getParameter("usuario");
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
			vialidad.setLatitud(latitud);
			vialidad.setLongitud(longitud);
			vialidad.setUsuarioBaja(usuario);
			vialidad.setUsuarioUltMod(usuario);
			respuesta = negocio.eliminaVialidad(vialidad);
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch (Exception e) {
			System.out.println("errores" + e);
			respuesta.setMensajeFuncional("Error: " + e.getMessage());
			respuesta.setEstatus(false);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
