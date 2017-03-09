package com.fyg.cuadrillas.web.empleado;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ActualizaEmpleado
 */
public class ActualizaEmpleado extends HttpServlet {
	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request para realizar la peticion
	 * @param response para dar una respuesta al servicio
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			//Se obtiene parametros
			String noEmpleado = request.getParameter("noEmpleado");
			Integer idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
			Integer idCuadrilla = Integer.parseInt(request.getParameter("idCuadrilla"));
			String nombre = request.getParameter("nombre");
			String apellidoPaterno = request.getParameter("apellidoPaterno");
			String apellidoMaterno = request.getParameter("apellidoMaterno");
			String sexo = request.getParameter("sexo");
			String rfc = request.getParameter("rfc");
			String altaIMSS = request.getParameter("altaIMSS");
			String fechaNacimiento = request.getParameter("fechaNacimiento");
			String codigoEmpresa = request.getParameter("codigoEmpresa");
			String codigoPuesto = request.getParameter("codigoPuesto");
			String codigoVialidad = request.getParameter("codigoVialidad");
			String codigoArea = request.getParameter("codigoArea");
			String codigoTalla = request.getParameter("codigoTalla");
			Integer calificacion = Integer.parseInt(request.getParameter("calificacion"));
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
			empleado.setIdEmpleado(idEmpleado);
			empleado.setIdCuadrilla(idCuadrilla);
			empleado.setNombre(nombre);
			empleado.setApellidoPat(apellidoPaterno);
			empleado.setApellidoMat(apellidoMaterno);
			empleado.setSexo(sexo);
			empleado.setRfc(rfc);
			empleado.setFechaNacimiento(fechaNacimiento);
			empleado.setCodigoEmpresa(codigoEmpresa);
			empleado.setCodigoPuesto(codigoPuesto);
			empleado.setCodigoVialidad(codigoVialidad);
			empleado.setCalificacion(calificacion);
			empleado.setCodigoArea(codigoArea);
			empleado.setCodigoTalla(codigoTalla);
			empleado.setNss(nss);
			empleado.setAltaImss(altaIMSS);
			double  sueldoEmpleado = Double.parseDouble(sueldo);
			empleado.setSueldo(sueldoEmpleado);
			empleado.setFrecuenciaPago(frecuenciaPago);
			empleado.setTelefono(telefono);
			empleado.setNoCreditoInfonavit(noCreditoInfonavit);
			empleado.setObservaciones(observaciones);
			empleado.setUsuarioAlta(usuario);

			JSONArray listaDocumentos = (JSONArray) jsonObject.get("documentacion");

			List <EmpleadoDocumentoDTO> documentos = new ArrayList<EmpleadoDocumentoDTO>();
			for (int i = 0; i < listaDocumentos.size(); i++)
			{
				EmpleadoDocumentoDTO codigo = new EmpleadoDocumentoDTO();
				JSONObject docs = (JSONObject) listaDocumentos.get(i);
				String codigoDocumento = (String) docs.get("codigoDocumento");
				String estatusDocumento = (String) docs.get("estatusDocumento");
				codigo.setCodigoEmpDoc(codigoDocumento);
				codigo.setEstatus(estatusDocumento);
				documentos.add(codigo);
				LogHandler.debug(null, this.getClass(), "datos " + documentos);

			}
			empleado.setDocumentos(documentos);
			respuesta = negocio.modificaEmpleado(empleado);
			if (respuesta.isEstatus()) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
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
