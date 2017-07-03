package com.fyg.cuadrillas.ws.service.empleado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.dto.empleado.EmpleadoRespuesta;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.google.gson.Gson;

@Path("/consultaEmpleado")
public class ConsultaEmpleadoWS {
	/**
	 * Metodo para Consultar Empleados en la BD
	 * @return regresa la lista de empleados
	 */
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response loginUser() {
		EmpleadoRespuesta respuesta  = new EmpleadoRespuesta();
		Gson sg = new Gson();
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			respuesta = negocio.consultaGeneralWS();
		} catch (Exception e) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();

	}

}
