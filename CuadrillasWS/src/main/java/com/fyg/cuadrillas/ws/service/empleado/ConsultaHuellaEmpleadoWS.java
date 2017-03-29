package com.fyg.cuadrillas.ws.service.empleado;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.dto.empleado.EmpleadoHuellaDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoHuellaRespuesta;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.google.gson.Gson;

@Path("/consultaHuella")
public class ConsultaHuellaEmpleadoWS {
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultaHuella(@QueryParam("idEmpleado")Integer idEmpleado) {
		EmpleadoHuellaRespuesta respuesta = new EmpleadoHuellaRespuesta();
		Gson sg = new Gson();
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO empleadoHuella = new EmpleadoHuellaDTO();
			empleadoHuella.setIdEmpleado(idEmpleado);
			respuesta = negocio.consultaHuella(empleadoHuella);
			
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).build();
	}

}
