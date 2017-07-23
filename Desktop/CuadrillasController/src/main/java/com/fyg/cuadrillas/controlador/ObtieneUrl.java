package com.fyg.cuadrillas.controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.util.*;
public class ObtieneUrl {
	/**
  	 * Consume WS con los parametros enviados
  	 * @param theUrl obtiene la url
  	 * @return regresa los datos
  	 */
  	  public String getUrlContents(String theUrl)
  	  {
  	    StringBuilder content = new StringBuilder();
  	    Properties prop = new Properties();
		InputStream is = null;
    
  	    // many of these calls can throw exceptions, so i've just
  	    // wrapped them all in one try/catch statement.
  	    try
  	    {
  	    	is = new FileInputStream("src/main/resources/com/fyg/cuadrillas/controlador/ServerConfig.properties");
			prop.load(is);
			
			String servidor = prop.getProperty("servidor.direccion");
			
			String urlCompuesto = servidor + theUrl;
  	      // create a url object
  	      URL url = new URL(urlCompuesto);

  	      // create a urlconnection object
  	      URLConnection urlConnection = url.openConnection();

  	      // wrap the urlconnection in a bufferedreader
  	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

  	      String line;

  	      // read from the urlconnection via the bufferedreader
  	      while ((line = bufferedReader.readLine()) != null)
  	      {
  	        content.append(line + "\n");
  	      }
  	      bufferedReader.close();
  	    }
  	    catch (Exception e)
  	    {
  	      e.printStackTrace();
  	    }
  	    return content.toString();
    
  	  }
}
