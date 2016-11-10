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
		    JSONArray child = new JSONArray();
		    for(int k = 0; k < loginData.size(); k++) {
		    	JSONObject TEMP = new JSONObject();
		    	JSONObject hijo = new JSONObject();
		    	
		    	if (loginData.get(k).getId_padre() == null)
		    	{ 
		    		TEMP.put("menuPadre", loginData.get(k).getMenu());
		    		Integer id_menu = loginData.get(k).getId_menu();
		    		
		    		if(id_menu.equals(loginData.get(k).getId_padre())) {
		    			hijo.put("menuHijo",loginData.get(k).getMenu());
		    			child.put(hijo);
		    			TEMP.put("child", child);
		    		}
		    		
		    	}
		    	
		    	 jsonArray.put(TEMP);
		    }
		    String result = "" + jsonArray;
			return Response.status(200).entity(result).build();
	  }
}
