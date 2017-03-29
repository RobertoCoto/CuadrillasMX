package com.fyg.cuadrillas.ws.service.catalogo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.dto.catalogo.CatalogoDTO;
import com.fyg.cuadrillas.dto.catalogo.CatalogoRespuesta;
import com.fyg.cuadrillas.negocio.CatalogoNegocio;
import com.google.gson.Gson;

@Path("/consultaCatalogo")
public class ConsultaCatalogoWS {
	/**
	 * Metodo para consultar catalogos
	 * @param tipoCatalogo recibira valores del catalogo
	 * @return regresara respuesta
	 */
	@GET
	@Path("/catalogo")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultarCatalogo(@QueryParam("tipoCatalogo") String tipoCatalogo) {
		CatalogoRespuesta respuesta = new CatalogoRespuesta();
		Gson sg = new Gson();
		try {
			//crea objeto de negocio
			final CatalogoNegocio negocio = new CatalogoNegocio();
			//Lista de direcciones
			CatalogoDTO catalogo = new CatalogoDTO();
			catalogo.setTipoCatalogo(tipoCatalogo);
			respuesta = negocio.consultarCatalogo(catalogo);
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).build();
	}

}
