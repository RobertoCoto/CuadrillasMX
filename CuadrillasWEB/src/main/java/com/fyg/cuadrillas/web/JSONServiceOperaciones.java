package com.fyg.cuadrillas.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Se importa dependencias
 */
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.fyg.cuadrillas.dto.Empleado;

@Path("/operaciones")	
public class JSONServiceOperaciones {
	
	/**
	 * Metodo que consulta un empleado y genera json
	 * @param f recibe el valor a buscar
	 * @return regresa un JSON
	 * @throws JSONException si surge algun error
	 */
	@GET
	@Path("/consultaEmpleado/{i}")
	@Produces("application/json")
	 public Response jsonConsultaEmpleado(@PathParam("i") Integer f) throws JSONException {
		 JSONObject jsonObject = new JSONObject();
		 Empleado datosEmpleado = new Empleado();
		 /**
		  * Se le asigna valores
		  */
		 datosEmpleado.setId_empleado(f);
		 List<Empleado> consultaEmpleado = new EmpleadoNegocio().consultaEmpleado(datosEmpleado);
		  for(int k = 0; k < consultaEmpleado.size(); k++) {
			  /**
			   * Se agregan los valores a nuestro json
			   */
			  jsonObject.put("nombreEmpleado", consultaEmpleado.get(k).getNombre());
			  jsonObject.put("apellidoPat", consultaEmpleado.get(k).getApellido_pat());
			  jsonObject.put("apellidoMat", consultaEmpleado.get(k).getApellido_mat());
			  jsonObject.put("RFC", consultaEmpleado.get(k).getRfc());
			  jsonObject.put("sexo", consultaEmpleado.get(k).getSexo());
			  jsonObject.put("fechaNac", consultaEmpleado.get(k).getFecha_nacimiento());
		  }
		 
		 
		 String result = "" + jsonObject;
         return Response.status(200).entity(result).build();
	 }

}
