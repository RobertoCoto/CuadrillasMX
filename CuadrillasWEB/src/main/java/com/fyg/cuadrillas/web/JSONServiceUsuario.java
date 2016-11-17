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
import com.fyg.cuadrillas.dto.UsuarioDTO;
import com.fyg.cuadrillas.dto.MenuDTO;
import com.fyg.cuadrillas.negocio.MenuNegocio;

@Path("/userLogin")
public class JSONServiceUsuario {
	
	  @Path("{i}+{j}")
	  @GET
	  @Produces("application/json")
	  public Response jsonUsuario(@PathParam("i") String f,@PathParam("j") String p) throws JSONException {
		    UsuarioDTO  user = new UsuarioDTO();
		    MenuDTO dataMenu = new MenuDTO();
		    user.setUsuario(f);
		    user.setContrasena(p);
		    
		    List<UsuarioDTO> loginData = new UsuariosNegocio().loginUsuario(user);
		    JSONArray jsonArray   = new JSONArray();
		    
		    for(int k = 0; k < loginData.size(); k++) {
			    JSONArray child = new JSONArray();
			    JSONObject TEMP = new JSONObject();
		    	
			     dataMenu.setIdPadre(loginData.get(k).getIdMenu());
			     List<MenuDTO> menuData = new MenuNegocio().consultarMenu(dataMenu);
		    	
		    	for(int l = 0; l < menuData.size(); l++) {
		    		    JSONObject hijo = new JSONObject();
		    		    TEMP.put("menuPadre", loginData.get(k).getMenu());
			    		hijo.put("menuHijo", menuData.get(l).getMenu());
			    		hijo.put("descripcionMenu", menuData.get(l).getDescripcion());
			    		hijo.put("url", menuData.get(l).getUrl());
			    		child.put(hijo);
			    		TEMP.put("subMenus", child);
				    	
		    	}
		    	jsonArray.put(TEMP);
		    	
		    	System.out.println(jsonArray);
		    	 
		    }
		    String result = "" + jsonArray;
		   
			return Response.status(200).entity(result).build();
	  }
}
