package com.fyg.cuadrillas.web.asistencia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaDTO;
import com.fyg.cuadrillas.negocio.AsistenciaNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class EntradaAsistencia
 */
public class EntradaAsistencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntradaAsistencia() {
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
			Integer idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
			String nombres = request.getParameter("nombres");
			String puesto = request.getParameter("puesto");
			String comentarios = request.getParameter("comentarios");
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */
			
			//crea objeto de negocio
			final AsistenciaNegocio  negocio = new AsistenciaNegocio();
			
			AsistenciaDTO asistencia = new AsistenciaDTO();
			asistencia.setIdEmpleado(idEmpleado);
			asistencia.setNombres(nombres);
			asistencia.setPuesto(puesto);
			asistencia.setComentarios(comentarios);
			respuesta = negocio.entradaAsistencia(asistencia);
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
			
		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.setMensajeFuncional("Error: " + e.getMessage());
			respuesta.setEstatus(false);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
