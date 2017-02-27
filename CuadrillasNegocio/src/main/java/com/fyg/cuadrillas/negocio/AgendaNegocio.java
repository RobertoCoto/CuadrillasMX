package com.fyg.cuadrillas.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.AgendaDAO;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaDetalleDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaRespuesta;

public class AgendaNegocio {

	/**
	 * Metodo para registrar la agenda de un contrato
	 * @param agenda datos de la agenda
	 * @return respuesta del registro
	 */
	public EncabezadoRespuesta altaAgenda(AgendaDTO agenda) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(agenda);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "altaAgenda - Datos Entrada: " + agenda);
		SimpleDateFormat formateador = new SimpleDateFormat("YYYY-mm-dd");
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (agenda.getIdContrato() == null || agenda.getIdContrato() <= 0) {
				throw new ExcepcionesCuadrillas("Es necesario el ID del Contrato de la Agenda.");
			}
			if (agenda.getFechaInicio() == null || agenda.getFechaInicio().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesaria la Fecha de Inicio de la Agenda.");
			}
			if (agenda.getFechaFin() == null || agenda.getFechaFin().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesaria la Fecha de Fin de la Agenda.");
			}
			if (agenda.getUsuario() == null || agenda.getUsuario().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario para la operacion.");
			}
			if (agenda.getNoSemana() <= 0) {
				throw new ExcepcionesCuadrillas("Es necesaria el numero de semana de la Agenda.");
			}
			if (agenda.getNoTrabajadores() <= 0) {
				throw new ExcepcionesCuadrillas("Es necesario el numero de trabajadores de la Agenda.");
			}
			if (agenda.getNoHoras() <= 0) {
				throw new ExcepcionesCuadrillas("Es necesario el numero de horas de la Agenda.");
			}
			if (agenda.getDiasAgenda().size() == 0) {
				throw new ExcepcionesCuadrillas("Es necesario al menos un dia de actividades de la Agenda.");
			}

			Date fechaInicio = formateador.parse(agenda.getFechaInicio());
			Date fechaFin = formateador.parse(agenda.getFechaFin());
			if ( fechaInicio.before(fechaFin) ) {
				throw new ExcepcionesCuadrillas("La fecha inicio no puede ser igual o mayor a la fecha fin.");
			}

			for ( AgendaDetalleDTO detalleAgenda : agenda.getDiasAgenda() ) {
				Date fechaAgenda = formateador.parse(detalleAgenda.getFecha());
				if ((fechaAgenda.after(fechaInicio) && fechaAgenda.before(fechaFin))) {
					throw new ExcepcionesCuadrillas("La fecha de la Agenda no esta en el rango de fechas indicado.");
				}
				if (detalleAgenda.getAvanceEsperado() <= 0) {
					throw new ExcepcionesCuadrillas("Fecha Agenda: " + detalleAgenda.getFecha()
							+ ", es necesario el avance esperado.");
				}
				if (detalleAgenda.getObservaciones() == null || detalleAgenda.getObservaciones().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("Fecha Agenda: " + detalleAgenda.getFecha()
							+ ", es necesario las observaciones.");
				}
				if (detalleAgenda.getCoordenadas() == null || detalleAgenda.getCoordenadas().size() < 2)  {
					throw new ExcepcionesCuadrillas("Fecha Agenda: " + detalleAgenda.getFecha()
							+ ", es necesario al menos dos coordenadas GPS.");
				}
				if (detalleAgenda.getMateriales() == null || detalleAgenda.getMateriales().size() == 0) {
					throw new ExcepcionesCuadrillas("Fecha Agenda: " + detalleAgenda.getFecha()
							+ ", es necesario al menos un material.");
				}
				if (detalleAgenda.getActividades() == null || detalleAgenda.getActividades().size() == 0) {
					throw new ExcepcionesCuadrillas("Fecha Agenda: " + detalleAgenda.getFecha()
							+ ", es necesaria al menos una actividad.");
				}
			}

			AgendaDAO dao = new AgendaDAO();
			respuesta = dao.altaAgenda(uid, agenda);
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "altaAgenda - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "altaAgenda - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * Metodo para dar de baja la agenda
	 * @param agenda recibe valores de agenda
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta bajaAgenda(AgendaDTO agenda) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(agenda);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "bajaAgenda - Datos Entrada: " + agenda);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (agenda.getIdAgenda() == null || agenda.getIdAgenda() <= 0) {
				throw new ExcepcionesCuadrillas("Es necesario el ID del Contrato de la Agenda.");
			}
			if (agenda.getUsuario() == null || agenda.getUsuario().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario para la operacion.");
			}
			AgendaDAO dao = new AgendaDAO();
			respuesta = dao.bajaAgenda(uid, agenda);
		} catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "altaAgenda - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "altaAgenda - Datos Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * Metodo para consultar las agendas disponibles
	 * @param agenda recibe valores de agenda
	 * @return regresa respuesta
	 */
	public AgendaRespuesta consultaAgenda(AgendaDTO agenda) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(new String(""));
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "consultaAgenda - Datos Entrada: ");
		 AgendaRespuesta respuesta = new AgendaRespuesta();
		 respuesta.setHeader( new EncabezadoRespuesta());
		 respuesta.getHeader().setUid(uid);
		 respuesta.getHeader().setEstatus(true);
		 respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		 List<AgendaDTO> listaAgenda = null;
		 try {
			 if (agenda.getIdAgenda() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID de la de la Agenda.");
			 }
			 listaAgenda = new AgendaDAO().consultaAgenda(uid, agenda);
			 respuesta.setAgenda(listaAgenda);
		 } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "consultaAgenda - Error: " + ex.getMessage(), ex);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "consultaAgenda - Error: " + ex.getMessage(), ex);
		    	respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "consultaAgenda - Datos Salida: " + respuesta);
			return respuesta;
		}
	}

