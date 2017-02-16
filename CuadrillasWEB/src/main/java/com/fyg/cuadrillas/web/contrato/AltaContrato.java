package com.fyg.cuadrillas.web.contrato;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaContrato() {
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
			//leer json Array
			JSONParser parser = new JSONParser();
			Object JSONContrato = parser.parse(request.getParameter("JSONContrato"));
			JSONObject jsonObject = (JSONObject) JSONContrato;
			
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
			Integer metros = (Integer) jsonObject.get("metros");
			Double monto = (Double) jsonObject.get("monto");
			Double subtotal = (Double) jsonObject.get("subtotal");
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
			
			//se obtienen las cordenadas
			
			for(int i = 0; i < listaCoordenadas.size(); i++)
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
