package com.fyg.cuadrillas.web.empleado;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoDTO;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.google.gson.Gson;
/**
 * Servlet implementation class AltaEmpleado
 */
public class RegistraEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List <EmpleadoDocumentoDTO> documentos = new ArrayList<EmpleadoDocumentoDTO>();
		EmpleadoDocumentoDTO codigo = new EmpleadoDocumentoDTO();
		
		try {
			//Se obtiene parametros
			String noEmpleado = request.getParameter("noEmpleado");
			String nombre = request.getParameter("nombre");
			String apellidoPaterno = request.getParameter("apellidoPaterno");
			String apellidoMaterno = request.getParameter("apellidoMaterno");
			String sexo = request.getParameter("sexo");
			String rfc = request.getParameter("rfc");
			String fechaNacimiento = request.getParameter("fechaNacimiento");
			String fechaIngreso = request.getParameter("fechaIngreso");
			String codigoPuesto = request.getParameter("codigoPuesto");
			String codigoVialidad = request.getParameter("codigoVialidad");
			String codigoArea = request.getParameter("codigoArea");
			String codigoTalla = request.getParameter("codigoTalla");
			Integer idCuadrilla = Integer.parseInt(request.getParameter("idCuadrilla"));
			String sueldo = request.getParameter("sueldo");
			String frecuenciaPago = request.getParameter("frecuenciaPago");
			String nss = request.getParameter("nss");
			String telefono = request.getParameter("telefono");
			String noCreditoInfonavit = request.getParameter("noCreditoInfonavit");
			String observaciones = request.getParameter("observaciones");
			String usuario = request.getParameter("usuario");
			
			//leer json Array
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(request.getParameter("documentoEmpleado"));
			JSONObject jsonObject = (JSONObject) obj;

			/* proxy fisa
			System.setProperty("http.proxyHost", "169.169.4.85");
	        System.setProperty("http.proxyPort", "8080");
	        System.setProperty("https.proxyHost", "169.169.4.85");
	        System.setProperty("https.proxyPort", "8080");
	        */
			
			//crea objeto de negocio
			final EmpleadoNegocio negocio = new EmpleadoNegocio();
			
			//Lista de direcciones
			EmpleadoDTO empleado = new EmpleadoDTO();
			empleado.setNoEmpleado(noEmpleado);
			empleado.setNombre(nombre);
			empleado.setApellidoPat(apellidoPaterno);
			empleado.setApellidoMat(apellidoMaterno);
			empleado.setSexo(sexo);
			empleado.setRfc(rfc);
			empleado.setFechaNacimiento(fechaNacimiento);
			empleado.setFechaIngreso(fechaIngreso);
			empleado.setCodigoPuesto(codigoPuesto);
			empleado.setCodigoVialidad(codigoVialidad);
			empleado.setCodigoArea(codigoArea);
			empleado.setCodigoTalla(codigoTalla);
			empleado.setIdCuadrilla(idCuadrilla);
			empleado.setNss(nss);
			double  sueldoEmpleado = Double.parseDouble(sueldo);
			empleado.setSueldo(sueldoEmpleado);
			empleado.setFrecuenciaPago(frecuenciaPago);
			empleado.setTelefono(telefono);
			empleado.setNoCreditoInfonavit(noCreditoInfonavit);
			empleado.setObservaciones(observaciones);
			empleado.setUsuarioAlta(usuario);
			
			JSONArray listaCodigo = (JSONArray) jsonObject.get("documentacion");
			
			for(int i = 0; i < listaCodigo.size(); i++)
			{
				LogHandler.debug(null, this.getClass(), "datos " + listaCodigo.get(i));
				codigo.setCodigoEmpDoc((String) listaCodigo.get(i));
				codigo.setEstatus("A");
				
				
			}
			documentos.add(codigo);
			empleado.setDocumentos(documentos);
			 
			
            
			respuesta = negocio.registraEmpleado(empleado);
			
			//convierte  a formato Json
			out.println(sg.toJson(respuesta));
			out.flush();
		} catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.setMensajeFuncional("Error: " + e.getMessage());
			respuesta.setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println(sg.toJson(respuesta));
			out.flush();
		}
	}

}
