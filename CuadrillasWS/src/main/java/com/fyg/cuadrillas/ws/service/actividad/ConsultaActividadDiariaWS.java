package com.fyg.cuadrillas.ws.service.actividad;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoRespuesta;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaDTO;
import com.fyg.cuadrillas.dto.asistencia.AsistenciaRespuesta;
import com.fyg.cuadrillas.negocio.AgendaNegocio;
import com.fyg.cuadrillas.negocio.AsistenciaNegocio;
import com.google.gson.Gson;

@Path("/consultaActividadDiaria")
public class ConsultaActividadDiariaWS {
	/**
	 * Metodo para Consultar Actividades en la BD
	 * @return regresa la lista de empleados
	 */
	@GET
	@Path("/actividad")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultarActividad(@QueryParam("idAgendaDetalle") Integer idAgendaDetalle) {
		ActividadDiariaCampoRespuesta respuesta = new ActividadDiariaCampoRespuesta();
		Gson sg = new Gson();
		try {
			//crea objeto de negocio
			final AgendaNegocio negocio = new AgendaNegocio();

			//valores
			ActividadDiariaCampoDTO actividadDiaria = new ActividadDiariaCampoDTO();
			actividadDiaria.setIdAgendaDetalle(idAgendaDetalle);
			respuesta = negocio.consultaActividadDiaria(actividadDiaria);
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();
	}

	/*
	 * Metodo para consultar la lista de asistencia
	 */
	@GET
	@Path("/consultarAsistencia")
	@Produces({MediaType.APPLICATION_JSON})
	public Response consultarAsistencia(@QueryParam("idCuadrilla") Integer idCuadrilla) {
		AsistenciaRespuesta respuesta = new AsistenciaRespuesta();
		Gson sg = new Gson();
		try {
			//crea objeto de negocio
			final AsistenciaNegocio negocio = new AsistenciaNegocio();
			Date fechaActual = new Date();
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			String fechaSistema = formateador.format(fechaActual);
			//valores
			AsistenciaDTO asistencia = new AsistenciaDTO();
			asistencia.setIdCuadrilla(idCuadrilla);
			asistencia.setFecha(fechaSistema);
			LogHandler.debug(null, this.getClass(), "Consultando " + fechaSistema );
			respuesta = negocio.consultaAsistencia(asistencia);
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();
	}

	/*
	 * Metodo para registrar entrada la asistencia
	 */
	@GET
	@Path("/entradaAsistencia")
	@Produces({MediaType.APPLICATION_JSON})
	public Response entradaAsistencia(@QueryParam("idEmpleado") Integer idEmpleado,
			@QueryParam("comentarios") String comentarios,
			@QueryParam("usuario")     String usuario
			) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		try {
			//crea objeto de negocio
			final AsistenciaNegocio negocio = new AsistenciaNegocio();
			//valores
			AsistenciaDTO asistencia = new AsistenciaDTO();
			asistencia.setIdEmpleado(idEmpleado);
			asistencia.setComentarios(comentarios);
			asistencia.setUsuarioAlta(usuario);
			respuesta = negocio.entradaAsistencia(asistencia);
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();
	}

	/*
	 * Metodo para registrar entrada la asistencia
	 */
	@GET
	@Path("/salidaAsistencia")
	@Produces({MediaType.APPLICATION_JSON})
	public Response salidaAsistencia(@QueryParam("idEmpleado") Integer idEmpleado,
			@QueryParam("usuario")     String usuario
			) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		Gson sg = new Gson();
		try {
			//crea objeto de negocio
			final AsistenciaNegocio negocio = new AsistenciaNegocio();
			//valores
			AsistenciaDTO asistencia = new AsistenciaDTO();
			asistencia.setIdEmpleado(idEmpleado);
			asistencia.setUsuarioUltMod(usuario);
			respuesta = negocio.salidaAsistencia(asistencia);
		} catch (Exception ex) {
			String result = sg.toJson(respuesta);
			return Response.serverError().entity(result).build();
		}
		String result = sg.toJson(respuesta);
		return Response.ok().entity(result).header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true").build();
	}
}
