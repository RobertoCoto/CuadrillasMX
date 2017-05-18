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
 * Servlet implementation class EliminarHerramienta
 */
public class EliminarHerramienta extends HttpServlet {
	/**
	 * serialuid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarHerramienta() {
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
			String idHerramienta = request.getParameter("idHerramienta");

			if (idHerramienta == null || idHerramienta.trim().isEmpty()) {
				idHerramienta = "0";
			}
			//crea objeto de negocio
			final HerramientaNegocio negocio = new HerramientaNegocio();

			//Lista de direcciones
			HerramientaDTO herramienta = new HerramientaDTO();
			herramienta.setIdHerramienta(Integer.valueOf(idHerramienta));
			respuesta = negocio.eliminaHerramientas(herramienta);
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
