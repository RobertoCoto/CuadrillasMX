package com.fyg.cuadrillas.ws.service.empleado;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.dto.asistencia.RegistroHuella;
import com.fyg.cuadrillas.dto.empleado.EmpleadoHuellaDTO;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.google.gson.Gson;


@Path("/registraHuella")
public class RegistraHuellaEmpleadoWS {
	
	private static final String DESTINATION_DIR_PATH = "C:/Sistema_TATEI/huellas/";

	/**
	 * Metodo para registrar la huella del empleado
	 * @param idEmpleado id del empleado
	 * @param mano codigo mano
	 * @param dedo codigo dedo
	 * @param ruta ruta de la imagen
	 * @return regresa respuesta
	 */
	@GET
	@Path("/huella")
	@Produces({MediaType.APPLICATION_JSON})
	public Response regHuella(@QueryParam("idEmpleado")Integer idEmpleado,
			@QueryParam("codigoMano")String mano, @QueryParam("codigoDedo")String dedo
			, @QueryParam("ruta") String ruta) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO huella = new EmpleadoHuellaDTO();
			huella.setIdEmpleado(idEmpleado);
			huella.setCodigoMano(mano);
			huella.setCodigoDedo(dedo);
			huella.setHuella(ruta);
			respuesta = negocio.registrarHuella(huella);
		} catch (Exception x) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();		
	}

	/**
	 * Metodo para registrar la huella del empleado
	 * @param idEmpleado id del empleado
	 * @param mano codigo mano
	 * @param dedo codigo dedo
	 * @param ruta ruta de la imagen
	 * @return regresa respuesta
	 */
	@POST
	@Path("/registraHuella")
	@Consumes("application/json")
	@Produces({MediaType.APPLICATION_JSON})
	public Response registraHuella(RegistroHuella registroHuella
			) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		try {
			System.out.println("idEmpleado=" + registroHuella.getIdEmpleado());
			System.out.println("encodedFile=" + registroHuella.getFileEncoded());
			System.out.println("fileName=" + registroHuella.getFileName());
			
			if (registroHuella.getFileEncoded() == null || registroHuella.getFileEncoded().trim().isEmpty()) {
				throw new Exception("Es necesario el arreglo de bytes del archivo.");
			}
			if (registroHuella.getFileName() == null || registroHuella.getFileName().trim().isEmpty()) {
				throw new Exception("Es necesario el nombre del archivo.");
			}
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = decodeImage(registroHuella.getFileEncoded());
	
			String nameFile = registroHuella.getIdEmpleado() + "_"
					+ new SimpleDateFormat("dd-MM-yyyy_HHmmss_").format(new Date())
					+  registroHuella.getFileName().trim();
			// Write a image byte array into file system
			FileOutputStream imageOutFile = new FileOutputStream(
					DESTINATION_DIR_PATH + nameFile);
	
			imageOutFile.write(imageByteArray);	
			imageOutFile.close();

			
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO huella = new EmpleadoHuellaDTO();
			huella.setIdEmpleado(registroHuella.getIdEmpleado());
			huella.setCodigoMano(registroHuella.getCodigoMano());
			huella.setCodigoDedo(registroHuella.getCodigoDedo());
			huella.setHuella(nameFile);
			respuesta = negocio.registrarHuella(huella);
			
		} catch (Exception x) {
			respuesta.setEstatus(false);
			respuesta.setMensajeTecnico(x.getMessage());
			respuesta.setMensajeTecnico(x.getMessage());
			System.out.println("Error: " + x.getMessage());
			String result = sg.toJson(respuesta);
			System.out.println("result: " + result);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();		
	}

	/**
	 * Encodes the byte array into base64 string
	 *
	 * @param imageByteArray - byte array
	 * @return String a {@link java.lang.String}
	 */
	public static String encodeImage(byte[] imageByteArray) {
		return Base64.encodeBase64URLSafeString(imageByteArray);
	}

	/**
	 * Decodes the base64 string into byte array
	 *
	 * @param imageDataString - a {@link java.lang.String}
	 * @return byte array
	 */
	public static byte[] decodeImage(String imageDataString) {
		return Base64.decodeBase64(imageDataString);
	}
}
