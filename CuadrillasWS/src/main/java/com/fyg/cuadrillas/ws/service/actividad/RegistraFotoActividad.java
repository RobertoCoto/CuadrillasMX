package com.fyg.cuadrillas.ws.service.actividad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/registraFotoActividad")
public class RegistraFotoActividad {


	/** The path to the folder where we want to store the uploaded files */
	private static final String UPLOAD_FOLDER = "C:/Sistema_TATEI/actividades/";
/*
	@POST
	@Path("/imagen")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData) {
	    try
	    {
	        int read = 0;
	        byte[] bytes = new byte[1024];

	        OutputStream out = new FileOutputStream(new File(UPLOAD_FOLDER + fileMetaData.getFileName()));
	        while ((read = fileInputStream.read(bytes)) != -1)
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e)
	    {
	        System.out.println("Error: "  + e.getMessage());
	    }
	    return Response.ok("Data uploaded successfully !!").build();
	}
*/
}

