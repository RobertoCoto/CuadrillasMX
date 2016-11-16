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
			  jsonObject.put("curp", consultaEmpleado.get(k).getCurp());
			  jsonObject.put("fechaIngreso", consultaEmpleado.get(k).getFecha_ingreso());
			  jsonObject.put("codigoPuesto", consultaEmpleado.get(k).getCodigo_puesto());
			  jsonObject.put("codigoVialidad", consultaEmpleado.get(k).getCodigo_vialidad());
			  jsonObject.put("codigoArea", consultaEmpleado.get(k).getCodigo_area());
			  jsonObject.put("sueldo", consultaEmpleado.get(k).getSueldo());
			  jsonObject.put("telefono", consultaEmpleado.get(k).getTelefono());
			  jsonObject.put("observaciones", consultaEmpleado.get(k).getObservaciones());
			  jsonObject.put("estatus", consultaEmpleado.get(k).getEstatus());
		  }
		 String result = "" + jsonObject;
         return Response.status(200).entity(result).build();
	 }
	
		/**
		 * Metodo para dar de baja un empleado
		 */
		@GET
		@Path("/bajaEmpleado/{i}+{j}+{k}+{l}+{m}")
		public Response jsonAltaEmpleado(@PathParam("i") Integer f,@PathParam("j") String status,@PathParam("k") String causa, @PathParam("l") String tipoSalida
				,@PathParam("m") String observacion) throws JSONException {
		Empleado bajaEmpleado = new Empleado();
		EmpleadoNegocio baja = new EmpleadoNegocio();
		/**
		 * Se le asignan valores para enviarlo al metodo
		 */
		bajaEmpleado.setId_empleado(f);
		bajaEmpleado.setEstatus(status);
		bajaEmpleado.setCodigo_causa_salida(causa);
		bajaEmpleado.setCodigo_tipo_salida(tipoSalida);
		bajaEmpleado.setObservaciones(observacion);
		
		 try {
			 /**
			  * Se le envian los valores al metodo
			  */
			 baja.bajaEmpleado(bajaEmpleado);
		 } 
		 catch(Exception e)
		 {
			 String alert = "SE HA PRODUCIDO UN ERROR";
			 return Response.status(400).entity(alert).build();
		 }
		
		String result = "DATOS CORRECTAMENTE ENVIADOS";
        return Response.status(200).entity(result).build();
	}
		
		@GET
		@Path("/altaEmpleado/{i}")
		public Response jsonBajaEmpleado(@PathParam("i") Integer f) throws JSONException {
			String result = "DATOS CORRECTAMENTE ENVIADOS";
	        return Response.status(200).entity(result).build();
	}
		
		@GET
		@Path("/modificaEmpleado/{i}")
		public Response jsonModificaEmpleado(@PathParam("i") Integer f) throws JSONException {
			String result = "DATOS CORRECTAMENTE ENVIADOS";
	        return Response.status(200).entity(result).build();
	}
}
