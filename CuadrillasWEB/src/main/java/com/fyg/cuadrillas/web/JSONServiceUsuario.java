package com.fyg.cuadrillas.web;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.fyg.cuadrillas.dto.Usuario;

@Path("/userLogin")
public class JSONServiceUsuario {
	
	  @Path("{i}")
	  @GET
	  @Produces("application/json")
	  public Response jsonUsuario(@PathParam("i") Integer f) throws JSONException {
		    JSONObject jsonObject = new JSONObject();
		    
		    String result = "" + jsonObject;
			return Response.status(200).entity(result).build();
	  }
}
