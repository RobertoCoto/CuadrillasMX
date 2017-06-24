package com.fyg.cuadrillas.ws.service.actividad;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDetalleDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/registraActividadDiaria")
public class RegistraActividadDiariaWS {
	/**
	 * Metodo para registrar Actividades en la BD
	 * @return regresa la lista de empleados
	 */
	@GET
	@Path("/actividad")
	@Produces({MediaType.APPLICATION_JSON})
	public Response registraActividad(@QueryParam("jsonRegistraActividad") String jsonEntrada) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		try {
			Gson gson = new GsonBuilder().create();
			ActividadDiariaDetalleDTO actividadDiaria = gson.fromJson(jsonEntrada, ActividadDiariaDetalleDTO.class);
			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();
			respuesta = negocio.registraActividadDiaria(actividadDiaria);
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
