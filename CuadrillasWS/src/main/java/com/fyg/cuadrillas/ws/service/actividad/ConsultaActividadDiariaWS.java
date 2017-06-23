package com.fyg.cuadrillas.ws.service.actividad;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoRespuesta;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;

@Path("/consultaActividadDiaria")
public class ConsultaActividadDiariaWS {
	/**
	 * Metodo para Consultar Actividades en la BD
	 * @return regresa la lista de empleados
	 */
	@GET
	@Path("/actividad")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultarActividad(@QueryParam("idAgendaDetalle") Integer idAgendaDetalle) {
		ActividadDiariaCampoRespuesta respuesta = new ActividadDiariaCampoRespuesta();
		Gson sg = new Gson();
		try {
			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();

			//valores
			ActividadDiariaCampoDTO actividadDiaria = new ActividadDiariaCampoDTO();
			actividadDiaria.setIdAgendaDetalle(idAgendaDetalle);
			respuesta = negocio.consultaActividadDiaria(actividadDiaria);
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();
	}
}
