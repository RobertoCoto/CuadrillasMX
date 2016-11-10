package com.fyg.cuadrillas.web;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
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
		    Usuario  user = new Usuario();
		    user.setUsuario(f);
		    user.setContrasena(p);
		    
		    List<Usuario> loginData = new UsuariosNegocio().loginUsuario(user);
		    JSONArray jsonArray   = new JSONArray();
		    for(int k = 0; k < loginData.size(); k++) {
		    	JSONObject TEMP = new JSONObject();
		    	
		    	TEMP.put("nombre", loginData.get(k).getNombre());
		    	TEMP.put("apellidoPat", loginData.get(k).getApellido_pat());
		    	TEMP.put("apellidoMat", loginData.get(k).getApellido_mat());
		    	TEMP.put("perfilNombre", loginData.get(k).getPerfilNombre());
		    	TEMP.put("perfilOrden", loginData.get(k).getPerfilOrden());
		    	TEMP.put("id_menu", loginData.get(k).getId_menu());
		    	TEMP.put("id_padre", loginData.get(k).getId_padre());
		    	TEMP.put("menu", loginData.get(k).getMenu());
		    	TEMP.put("menuDescripcion", loginData.get(k).getMenuDescripcion());
		    	TEMP.put("menuUrl", loginData.get(k).getMenuUrl());
		    	 jsonArray.put(TEMP);
		    }
		    String result = "" + jsonArray;
			return Response.status(200).entity(result).build();
	  }
}
