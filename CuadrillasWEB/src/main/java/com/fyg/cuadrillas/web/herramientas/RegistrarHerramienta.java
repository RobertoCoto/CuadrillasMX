package com.fyg.cuadrillas.web.herramientas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.herramienta.HerramientaDTO;
import com.fyg.cuadrillas.negocio.HerramientaNegocio;
import com.google.gson.Gson;
/**
 * Servlet implementation class RegistrarHerramientas
 */
public class RegistrarHerramienta extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarHerramienta() {
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
			//Se obtiene los valores
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String codigoTipoCombustible = request.getParameter("codigoTipoCombustible");
			String codigoTipoArticulo = request.getParameter("codigoTipoArticulo");
			String codigoEstado = request.getParameter("codigoEstado");
			String mantenimiento = request.getParameter("mantenimiento");
			String usuarioAlta = request.getParameter("usuarioAlta");

			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */

			//crea objeto de negocio
			final HerramientaNegocio negocio = new HerramientaNegocio();

			//Lista de direcciones
			HerramientaDTO herramienta = new HerramientaDTO();
			herramienta.setNombre(nombre);
			herramienta.setDescripcion(descripcion);
			herramienta.setCodigoTipoCombustible(codigoTipoCombustible);
			herramienta.setCodigoTipoArticulo(codigoTipoArticulo);
			herramienta.setCodigoEstado(codigoEstado);
			herramienta.setMantenimiento(mantenimiento);
			herramienta.setUsuarioAlta(usuarioAlta);
			respuesta = negocio.registrarHerramienta(herramienta);
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
