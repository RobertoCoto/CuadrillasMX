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
	
	  @Path("{i}+{j}")
	  @GET
	  @Produces("application/json")
	  public Response jsonUsuario(@PathParam("i") String f,@PathParam("j") String p) throws JSONException {
		    JSONObject jsonObject = new JSONObject();
		    Usuario  user = new Usuario();
		    user.setUsuario(f);
		    user.setContrasena(p);
		    
		    List<Usuario> loginData = new UsuariosNegocio().loginUsuario(user);
		    for(int k = 0; k < loginData.size(); k++) {
		    	jsonObject.put("nombre", loginData.get(k).getNombre());
		    	jsonObject.put("apellidoPat", loginData.get(k).getApellido_pat());
		    	jsonObject.put("apellidoMat", loginData.get(k).getApellido_mat());
		    	jsonObject.put("perfilNombre", loginData.get(k).getPerfilNombre());
		    	jsonObject.put("perfilOrden", loginData.get(k).getPerfilOrden());
		    	jsonObject.put("menu", loginData.get(k).getMenu());
		    	jsonObject.put("menuDescripcion", loginData.get(k).getMenuDescripcion());
		    	jsonObject.put("menuUrl", loginData.get(k).getMenuUrl());
		    }
		    String result = "" + jsonObject;
			return Response.status(200).entity(result).build();
	  }
}
