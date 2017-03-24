package com.fyg.cuadrillas.ws.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.ws.TestWS;
import com.google.gson.Gson;

@Path("/HolaMundo")
public class MensajeBienvenida {
/**
 * Metodo get para recibir valores
 * @param i recibe un parametro
 * @return regresa una respuesta en json
 */
	@GET
	@Path("/nombre")
	@Produces({MediaType.APPLICATION_JSON})
	public Response mensajeData(@QueryParam("empleado")String i) {
		TestWS datos = new TestWS();
		Gson sg = new Gson();
		datos.setMsg("Bienvenido");
		datos.setEmpleado(i);
		String data = sg.toJson(datos);
		return Response.ok().entity(data).build();
	}
}
