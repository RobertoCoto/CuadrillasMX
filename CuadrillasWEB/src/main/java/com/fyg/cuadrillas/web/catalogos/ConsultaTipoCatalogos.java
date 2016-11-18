package com.fyg.cuadrillas.web.catalogos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.dto.catalogo.CatalogoRespuesta;
import com.fyg.cuadrillas.dto.catalogo.TipoCatalogoRespuesta;
import com.fyg.cuadrillas.negocio.CatalogoNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ConsultaTipoCatalogos
 */
public class ConsultaTipoCatalogos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaTipoCatalogos() {
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
		TipoCatalogoRespuesta respuesta = new TipoCatalogoRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080");

			//crea objeto de negocio
			final CatalogoNegocio negocio = new CatalogoNegocio();
			respuesta = negocio.consultarTipoCatalogos();
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch (Exception e) {
			System.out.println("errores" + e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
