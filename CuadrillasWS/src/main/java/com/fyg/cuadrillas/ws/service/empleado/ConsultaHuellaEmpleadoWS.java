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
	/**
	 * Metodo para consultar huella
	 * @param idEmpleado recibe id
	 * @return regresa respuesta
	 */
	@GET
	@Path("/empleado")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultaHuella(@QueryParam("idEmpleado")Integer idEmpleado,@QueryParam("codigoMano")String codigoMano
			,@QueryParam("codigoDedo")String codigoDedo) {
		EmpleadoHuellaRespuesta respuesta = new EmpleadoHuellaRespuesta();
		Gson sg = new Gson();
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO empleadoHuella = new EmpleadoHuellaDTO();
			empleadoHuella.setIdEmpleado(idEmpleado);
			empleadoHuella.setCodigoMano(codigoMano);
			empleadoHuella.setCodigoDedo(codigoDedo);
			respuesta = negocio.consultaHuella(empleadoHuella);
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
