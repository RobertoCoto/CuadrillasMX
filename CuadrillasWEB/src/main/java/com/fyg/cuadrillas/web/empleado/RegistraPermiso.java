package com.fyg.cuadrillas.web.empleado;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.empleado.PermisoLaboralDTO;
import com.fyg.cuadrillas.negocio.PermisoLaboralNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class RegistraPermiso
 */
public class RegistraPermiso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraPermiso() {
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
			String comentario = request.getParameter("comentario");
			String fechaSolicitudMinima = request.getParameter("fechaSolicitudMinima");
			String fechaSolicitudMaxima = request.getParameter("fechaSolicitudMaxima");
			String horaSolicitudMinima = request.getParameter("horaSolicitudMinima");
			String horaSolicitudMaxima = request.getParameter("horaSolicitudMaxima");
			String tipoPermiso = request.getParameter("tipoPermiso");
			String usuario = request.getParameter("usuario");
			
			//conversor hora y fecha
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
			SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
			Date fechaMin = formato.parse(fechaSolicitudMinima);
			Date fechaMax = formato.parse(fechaSolicitudMaxima);
			Date horaMin = formatoHora.parse(horaSolicitudMinima);
			Date horaMax = formatoHora.parse(horaSolicitudMaxima);
			
			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */
			
			//crea objeto de negocio
			final PermisoLaboralNegocio negocio = new PermisoLaboralNegocio();
			
			PermisoLaboralDTO permiso = new PermisoLaboralDTO();
			permiso.setIdEmpleado(idEmpleado);
			permiso.setComentarios(comentario);
			permiso.setFechaSolicitudMinimo(fechaMin);
			permiso.setFechaSolicitudMaximo(fechaMax);
			permiso.setHoraSolicitudMinimo(horaMin);
			permiso.setHoraSolicitudMaxima(horaMax);
			permiso.setTipoPermiso(tipoPermiso);
			permiso.setUsuarioAlta(usuario);
			respuesta = negocio.altaPermiso(permiso);
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
