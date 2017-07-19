package com.fyg.cuadrillas.negocio.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestUploadFileREST {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		File file  = new File("C:\\logo_fyg_color.jpg");
		try {
			
			FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
 
            // Converting Image byte array into Base64 String
            String imageDataString = encodeImage(imageData);
            
            System.out.println(imageDataString);
            String sURL = "http://localhost:8080/CuadrillasWS/service/registraHuella/registraHuella";
            
            /*
            URL url = new URL(sURL + "?idEmpleado=1&file="  		+ imageDataString);
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setRequestMethod("GET");
    		conn.setRequestProperty("Accept", "application/json");

    		if (conn.getResponseCode() != 200) {
    			throw new RuntimeException("Failed : HTTP error code : "
    					+ conn.getResponseCode());
    		}

    		BufferedReader br = new BufferedReader(new InputStreamReader(
    			(conn.getInputStream())));

    		String output;
    		System.out.println("Output from Server .... \n");
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}

    		conn.disconnect();
			
			*/
            
            DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPost postRequest = new HttpPost(sURL);


    		StringEntity input = new StringEntity("{"
    				+ "\"idEmpleado\":" + "1"
    				+ ",\"fileEncoded\":\"" + imageDataString + "\""
    				+ ",\"fileName\":\"" + "prueba.jpg"  + "\""			
    				+ ",\"codigoMano\":\"" + "DERE"  + "\""
    				+ ",\"codigoDedo\":\"" + "ANUL"  + "\""
    				+ "}");
    		System.out.println("*****" + input);
    		input.setContentType("application/json");
    		postRequest.setEntity(input);

    		HttpResponse response = httpClient.execute(postRequest);

    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new RuntimeException("Failed : HTTP error code : "
    				+ response.getStatusLine().getStatusCode());
    		}

    		BufferedReader br = new BufferedReader(
                            new InputStreamReader((response.getEntity().getContent())));

    		String output;
    		System.out.println("Output from Server .... \n");
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}

    		httpClient.getConnectionManager().shutdown();

		 } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
		
		
		
		
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
}
