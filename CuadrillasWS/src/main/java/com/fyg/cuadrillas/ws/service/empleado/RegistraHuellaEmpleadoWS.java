package com.fyg.cuadrillas.ws.service.empleado;

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
import com.mysql.jdbc.Blob;

@Path("/registraHuella")
public class RegistraHuellaEmpleadoWS {
	@GET
	@Path("/huella")
	@Produces({MediaType.APPLICATION_JSON})
	public Response regHuella(@QueryParam("idEmpleado")Integer idEmpleado,@QueryParam("codigoMano")String mano,@QueryParam("codigoDedo")String dedo) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO huella = new EmpleadoHuellaDTO();
			huella.setIdEmpleado(idEmpleado);
			huella.setCodigoMano(mano);
			huella.setCodigoDedo(dedo);
			//huella.setHuella(huellaData);
			respuesta = negocio.registrarHuella(huella);
			
		} catch (Exception x) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).build();
	}

}
