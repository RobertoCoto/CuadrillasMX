package com.fyg.cuadrillas.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Se importa dependencias
 */
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.dto.EmpleadoDocumentos;

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
		@POST
		@Path("/bajaEmpleado/{i}+{j}+{k}+{l}+{m}")
		public Response jsonBajaEmpleado(@PathParam("i") Integer f,@PathParam("j") String status,@PathParam("k") String causa, @PathParam("l") String tipoSalida
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
        return Response.status(201).entity(result).build();
	}
		
		@POST
		@Path("/altaEmpleado/{i}+{j}+{k}+{l}+{m}+{n}+{o}+{p}+{q}+{r}+{s}+{t}+{u}+{v}+{w}+{d1}+{d2}+{d3}+{d4}")
		public Response jsonAltaEmpleado(@PathParam("i") String nombre, 
				@PathParam("j") String apePat,@PathParam("k") String apeMat,@PathParam("l") String sexo, @PathParam("m") Date fechaNac
				,@PathParam("n") String rfc, @PathParam("o") String curp, @PathParam("p") String codPuesto,
				@PathParam("q")String codVial,@PathParam("r") String codArea,@PathParam("s") String codTalla,
				@PathParam("t") String tel,@PathParam("u") String nss,@PathParam("v") String infonavit,@PathParam("w") String observaciones,
				@PathParam("d1") String doc1, @PathParam("d2") String doc2, @PathParam("d3")String doc3, @PathParam("d4") String doc4) throws JSONException {
			/**
			 * Se crean objetos 
			 */
			Empleado datosEmpleado = new Empleado();
			EmpleadoNegocio alta = new EmpleadoNegocio();
			/**
			 * Se registran los valores
			 */
			datosEmpleado.setNombre(nombre);
			datosEmpleado.setApellido_pat(apePat);
			datosEmpleado.setApellido_mat(apeMat);
			datosEmpleado.setSexo(sexo);
			datosEmpleado.setFecha_nacimiento(fechaNac);
			datosEmpleado.setRfc(rfc);
			datosEmpleado.setCurp(curp);
			datosEmpleado.setCodigo_puesto(codPuesto);
			datosEmpleado.setCodigo_vialidad(codVial);
			datosEmpleado.setCodigo_area(codArea);
			datosEmpleado.setCodigo_talla(codTalla);
			datosEmpleado.setTelefono(tel);
			datosEmpleado.setNss(nss);
			datosEmpleado.setNo_credito_infonavit(infonavit);
			datosEmpleado.setObservaciones(observaciones);
			/**
			 * Documentos
			 */
		    EmpleadoDocumentos docEmpleado = new EmpleadoDocumentos();
			EmpleadoDocumentos docEmpleado2 = new EmpleadoDocumentos();
			EmpleadoDocumentos docEmpleado3 = new EmpleadoDocumentos();
			EmpleadoDocumentos docEmpleado4  = new EmpleadoDocumentos();
			ArrayList<EmpleadoDocumentos> dataDocumentos = new ArrayList<EmpleadoDocumentos>();;
			
			docEmpleado.setCodigo_emp_doc(doc1);
			docEmpleado2.setCodigo_emp_doc(doc2);
			docEmpleado3.setCodigo_emp_doc(doc3);
			docEmpleado4.setCodigo_emp_doc(doc4);
			dataDocumentos.add(docEmpleado);
			dataDocumentos.add(docEmpleado2);
			dataDocumentos.add(docEmpleado3);
			dataDocumentos.add(docEmpleado4);
			datosEmpleado.setObjDocumentos(dataDocumentos);
			 try {
				 /**
				  * Se le envian los valores al metodo
				  */
				 alta.registraEmpleado(datosEmpleado);
			 } 
			 catch(Exception e)
			 {
				 String alert = "SE HA PRODUCIDO UN ERROR";
				 return Response.status(400).entity(alert).build();
			 }
			
			String result = "DATOS CORRECTAMENTE ENVIADOS";
	        return Response.status(201).entity(result).build();
	}
		
		@POST
		@Path("/modificaEmpleado/{i}+{j}+{k}+{l}+{m}+{n}+{w}+{d1}+{d2}+{d3}+{d4}")
		public Response jsonModificaEmpleado(@PathParam("i") String nombre, 
				@PathParam("j") String apePat,@PathParam("k") String apeMat,@PathParam("l") String sexo, @PathParam("m") Date fechaNac
				,@PathParam("n") String rfc,@PathParam("w") String observacion,
				@PathParam("d1") String doc1, @PathParam("d2") String doc2, @PathParam("d3")String doc3, @PathParam("d4") String doc4) throws JSONException {
			/**
			 * Se crean objetos 
			 */
			Empleado datosEmpleado = new Empleado();
			EmpleadoNegocio modificacion = new EmpleadoNegocio();
			datosEmpleado.setNombre(nombre);
			datosEmpleado.setApellido_pat(apePat);
			datosEmpleado.setApellido_mat(apeMat);
			datosEmpleado.setSexo(sexo);
			datosEmpleado.setFecha_nacimiento(fechaNac);
			datosEmpleado.setRfc(rfc);
			datosEmpleado.setObservaciones(observacion);
			/**
			 * Documentos
			 */
		    EmpleadoDocumentos docEmpleado = new EmpleadoDocumentos();
			EmpleadoDocumentos docEmpleado2 = new EmpleadoDocumentos();
			EmpleadoDocumentos docEmpleado3 = new EmpleadoDocumentos();
			EmpleadoDocumentos docEmpleado4  = new EmpleadoDocumentos();
			ArrayList<EmpleadoDocumentos> dataDocumentos = new ArrayList<EmpleadoDocumentos>();;
			
			docEmpleado.setCodigo_emp_doc(doc1);
			docEmpleado2.setCodigo_emp_doc(doc2);
			docEmpleado3.setCodigo_emp_doc(doc3);
			docEmpleado4.setCodigo_emp_doc(doc4);
			dataDocumentos.add(docEmpleado);
			dataDocumentos.add(docEmpleado2);
			dataDocumentos.add(docEmpleado3);
			dataDocumentos.add(docEmpleado4);
			datosEmpleado.setObjDocumentos(dataDocumentos);
			try {
				 /**
				  * Se le envian los valores al metodo
				  */
				 modificacion.modificaEmpleado(datosEmpleado);
			 } 
			 catch(Exception e)
			 {
				 String alert = "SE HA PRODUCIDO UN ERROR";
				 return Response.status(400).entity(alert).build();
			 }
			String result = "DATOS CORRECTAMENTE ENVIADOS";
	        return Response.status(200).entity(result).build();
	}
}
