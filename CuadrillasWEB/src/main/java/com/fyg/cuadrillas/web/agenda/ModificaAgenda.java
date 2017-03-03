package com.fyg.cuadrillas.web.agenda;

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
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaDetalleDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ModificaAgenda
 */
public class ModificaAgenda extends HttpServlet {
	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaAgenda() {
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
			//leer json Array
			JSONParser parser = new JSONParser();
			Object jsonModificaAgenda = parser.parse(request.getParameter("JSONModificaAgenda"));
			JSONObject jsonObject = (JSONObject) jsonModificaAgenda;

			/* descomentar para proxy FISA
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080"); */

			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();

			//se crea objeto agenda
			AgendaDTO agenda = new AgendaDTO();

			//se desglosan los datos para convertirlos a objetos
			Integer idContrato = (Integer) jsonObject.get("idContrato");
			String  fechaInicio = (String) jsonObject.get("fechaInicio");
			String  fechaFin = (String) jsonObject.get("fechaFin");
			Integer noHoras = (Integer) jsonObject.get("noHoras");
			Integer noTrabajadores = (Integer) jsonObject.get("noTrabajadores");
			Integer noSemana = (Integer) jsonObject.get("noSemana");
			String usuario = (String) jsonObject.get("codigoContrato");
			JSONArray listaAgendaDetalle = (JSONArray) jsonObject.get("agendaDetalle");

			//Se crea lista de agendaDetalle
			List<AgendaDetalleDTO> agendaDetalle = new ArrayList<AgendaDetalleDTO>();

			//se pasan a nuestros objetos
			agenda.setIdContrato(idContrato);
			agenda.setFechaInicio(fechaInicio);
			agenda.setFechaFin(fechaFin);
			agenda.setNoHoras(noHoras);
			agenda.setNoSemana(noSemana);
			agenda.setNoTrabajadores(noTrabajadores);
			agenda.setUsuario(usuario);

			//se obtiene los detalles de la agenda
			for (int i = 0; i < listaAgendaDetalle.size(); i++)
			{
				AgendaDetalleDTO  detalle = new AgendaDetalleDTO();
				JSONObject detalleAgenda = (JSONObject) listaAgendaDetalle.get(i);
				String fecha = (String) detalleAgenda.get("fecha");
				Integer avanceEsperado = (Integer) detalleAgenda.get("avanceEsperado");
				String observaciones = (String) detalleAgenda.get("observaciones");
				String usuarioAlta = (String) detalleAgenda.get("usuarioAgenda");

				JSONArray agendaActividades = (JSONArray) detalleAgenda.get("Actividades");
				JSONArray agendaMateriales = (JSONArray) detalleAgenda.get("Materiales");
				JSONArray agendaCoordenadas = (JSONArray)  detalleAgenda.get("coordenadas");

				List<String> actividades = new ArrayList<String>();
				List<String> materiales  = new ArrayList<String>();
				List<CoordenadaDTO> coordenadas = new ArrayList<CoordenadaDTO>();
				for (int k = 0; k < agendaActividades.size(); k++)
				{
				
					JSONObject agendaActividad = (JSONObject) agendaActividades.get(k);
					String codigoActividad = (String) agendaActividad.get("codigoActividad");
					String usuarioActividad = (String) agendaActividad.get("usuarioActividad");
					
					actividades.add(codigoActividad);
					actividades.add(usuarioActividad);
				}
				for (int j = 0; j < agendaMateriales.size(); j++) {

					JSONObject material = (JSONObject) agendaMateriales.get(j);
					String codigoMaterial = (String) material.get("codigoMaterial");
					String usuarioMaterial = (String) material.get("usuarioMaterial");
					materiales.add(usuarioMaterial);
					materiales.add(codigoMaterial);
				}
				for (int l = 0; l < agendaCoordenadas.size(); l++) {
					CoordenadaDTO codigo = new CoordenadaDTO();

					JSONObject coorde = (JSONObject) agendaCoordenadas.get(l);
					Integer orden = (Integer) coorde.get("orden");
					String direccion = (String)  coorde.get("direccion");
					Float latitud = (Float) coorde.get("latitud");
					Float longitud = (Float) coorde.get("longitud");
					codigo.setDireccion(direccion);
					codigo.setLatitud(latitud);
					codigo.setLongitud(longitud);
					codigo.setOrden(orden);
				    coordenadas.add(codigo);
				}
				 detalle.setActividades(actividades);
				 detalle.setMateriales(materiales);
				 detalle.setCoordenadas(coordenadas);
				 detalle.setAvanceEsperado(avanceEsperado);
				 detalle.setFecha(fecha);
				 detalle.setObservaciones(observaciones);
				 detalle.setUsuarioAlta(usuarioAlta);
				 agendaDetalle.add(detalle);

			}
			agenda.setDiasAgenda(agendaDetalle);
			respuesta = negocio.modificaAgenda(agenda);
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
