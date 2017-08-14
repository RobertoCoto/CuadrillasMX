package com.fyg.cuadrillas.ws.service.empleado;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fyg.cuadrillas.dto.empleado.EmpleadoHuellaDTO;
import com.fyg.cuadrillas.dto.asistencia.ConsultaHuella;
import com.fyg.cuadrillas.dto.empleado.EmpleadoHuellaRespuesta;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
import com.google.gson.Gson;
import com.digitalpersona.onetouch.DPFPData;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;

import javax.swing.SwingUtilities;

@Path("/consultaHuella")
public class ConsultaHuellaEmpleadoWS {
	/**
	 * Ruta absoluta server
	 */
	private static final String DESTINATION_DIR_PATH = "C:/Sistema_TATEI/huellas/";
	
	   /**
	    * Verifica que la huella sea correcta
	    */
		//private DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();
	/**
	 * Metodo para consultar huella
	 * @param idEmpleado recibe id
	 * @return regresa respuesta
	 */
	@GET
	@Path("/empleado")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultaHuella(@QueryParam("idEmpleado")Integer idEmpleado) {
		EmpleadoHuellaRespuesta respuesta = new EmpleadoHuellaRespuesta();
		Gson sg = new Gson();
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO empleadoHuella = new EmpleadoHuellaDTO();
			empleadoHuella.setIdEmpleado(idEmpleado);
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
	
	/**
	 * Metodo para consultar huella
	 * @param idEmpleado recibe id
	 * @return regresa respuesta
	 */
	@GET
	@Path("/verificador")
	@Produces({MediaType.APPLICATION_JSON})
	public Response verifHuella(@QueryParam("idEmpleado")Integer idEmpleado) {
		EmpleadoHuellaRespuesta respuesta = new EmpleadoHuellaRespuesta();
		Gson sg = new Gson();
		String huellaEmpleado = null;
		try {
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO empleadoHuella = new EmpleadoHuellaDTO();
			empleadoHuella.setIdEmpleado(idEmpleado);
			respuesta = negocio.consultaHuella(empleadoHuella);

			huellaEmpleado = convierte64(respuesta.getEmpleadoHuella());
		} catch (Exception ex) {
			String result =null;
			if(huellaEmpleado == null) {
				result = sg.toJson(respuesta);
			} 
			return Response.serverError().entity(result).build();
		}
		String result = huellaEmpleado;
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();
		
	}
	
	@SuppressWarnings("unchecked")
	public String convierte64(List<EmpleadoHuellaDTO> huellas) {
		String ruta = null;
		JSONArray array = new JSONArray();
		for (int i = 0; i<huellas.size();i++) {
			 ruta = DESTINATION_DIR_PATH + huellas.get(i).getHuella();
			 
             try {
    	FileInputStream stream = new FileInputStream(new File(ruta));
		byte[] data = new byte[stream.available()];
		stream.read(data);
		stream.close();
	    array.add(encodeImage(data));
    	
                } catch (Exception ex) {
    	           ex.printStackTrace();
                }
		  }
		
		
		return array.toString();
	}

	/*@POST
	@Path("/verificaHuella")
	@Consumes("application/json")
	@Produces({MediaType.APPLICATION_JSON})
	public Response verificaHuella(ConsultaHuella consulta) {
		EmpleadoHuellaRespuesta respuesta = new EmpleadoHuellaRespuesta();
		Gson sg = new Gson();
        Object collect = new Object();
        String datos = null;
       
		try {
			System.out.println("idEmpleado=" + consulta.getIdEmpleado());
			System.out.println("encodedHuella=" + consulta.getFileEncoded());
			
			if(consulta.getFileEncoded() == null || consulta.getFileEncoded().trim().isEmpty()) {
				throw new Exception("Es necesario el arreglo de bytes de la huella.");
			}
			// Converting a Base64 String into Image byte array
			 byte[] imageByteArray = decodeImage(consulta.getFileEncoded());
			
			
			
			
					
			
			EmpleadoNegocio negocio = new EmpleadoNegocio();
			EmpleadoHuellaDTO empleadoHuella = new EmpleadoHuellaDTO();
			empleadoHuella.setIdEmpleado(consulta.getIdEmpleado());
			respuesta = negocio.consultaHuella(empleadoHuella);
        datos = comparaHuella(imageByteArray, respuesta.getEmpleadoHuella());
			
		} catch (Exception ex) {
			String result = sg.toJson(datos);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(datos);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();
		
		
	}*/
	/**
	 * template a almacenar
	 */
	public static String TEMPLATE_PROPERTY = "template";
	/**
	 * template
	 */
	private DPFPTemplate template;
	
	
	public DPFPTemplate getTemplate() {
		return template;
	}
	
	public void setTemplate(DPFPTemplate template) {
		this.template = template;
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
		
		
	/*	public String comparaHuella(byte[] dataHuella, List<EmpleadoHuellaDTO> empleadoHuella ) {
			String resultado = null;
			DPFPFeatureSet features = DPFPGlobal.getFeatureSetFactory().createFeatureSet();
			features.deserialize(dataHuella);
			try {
				
				
				for(int i=0; i< empleadoHuella.size(); i++) {
					File raw = new File(DESTINATION_DIR_PATH + empleadoHuella.get(i).getHuella());
					String rut = raw.toString();
					
					List<String> rutas = new ArrayList<String>();
					rutas.add(rut);
					
					
					for (int j = 0; j< rutas.size(); j++) {
						
						FileInputStream stream = new FileInputStream(new File(rutas.get(j)));
						byte[] data = new byte[stream.available()];
						stream.read(data);
						stream.close();
						DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
						t.deserialize(data);

						if (features != null)
						{
							// Compare the feature set with our template
							
							DPFPVerificationResult result = verificator.verify(features, getTemplate());
							
							if (result.isVerified()) {
								resultado = "true";
							}
								
							else {
								resultado = "false";
							}	
						}
					         }
				}
				
			} catch(Exception x) {
				x.printStackTrace();
			}
			
			return resultado;
		}*/

}
