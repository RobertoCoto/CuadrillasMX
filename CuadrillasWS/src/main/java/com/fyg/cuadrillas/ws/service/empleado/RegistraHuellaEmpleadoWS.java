package com.fyg.cuadrillas.ws.service.empleado;

import java.sql.Blob;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.dto.empleado.EmpleadoHuellaDTO;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.google.gson.Gson;

@Path("/RegistraHuella")
public class RegistraHuellaEmpleadoWS {
	/**
	 * Metodo para registrar la huella
	 * @param idEmpleado id del empleado
	 * @param mano codigo de la mano
	 * @param dedo codigo del deldo
	 * @param huella huella tomada
	 * @return regresa respuesta
	 */
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response tomaHuella(@QueryParam("idEmpleado")Integer idEmpleado, @QueryParam("mano") String mano,
			@QueryParam("dedo") String dedo, @QueryParam("huella") Blob huella) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO empleadoHuella = new EmpleadoHuellaDTO();
			empleadoHuella.setIdEmpleado(idEmpleado);
			empleadoHuella.setCodigoMano(mano);
			empleadoHuella.setCodigoDedo(dedo);
			empleadoHuella.setHuella(huella);
			respuesta = negocio.registrarHuella(empleadoHuella);
			
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).build();
	}

}
