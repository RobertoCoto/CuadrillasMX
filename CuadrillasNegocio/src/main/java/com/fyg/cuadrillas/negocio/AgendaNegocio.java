package com.fyg.cuadrillas.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.AgendaDAO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoRespuesta;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCoordenadasDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDetalleDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDocumentosDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDocumentosRespuesta;
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
			if ( fechaInicio.after(fechaFin) ) {
				throw new ExcepcionesCuadrillas("La fecha inicio no puede ser igual o mayor a la fecha fin.");
			}

			for ( AgendaDetalleDTO detalleAgenda : agenda.getDiasAgenda() ) {
				Date fechaAgenda = formateador.parse(detalleAgenda.getFecha());
				if (fechaAgenda.after(fechaFin) && fechaAgenda.before(fechaInicio)) {
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
			if (agenda.getIdAgenda() == null) {
				agenda.setIdAgenda(0);
			}

			AgendaDAO dao = new AgendaDAO();
			if (agenda.getIdAgenda() == 0) {
				respuesta = dao.altaAgenda(uid, agenda);
			} else {
				respuesta = dao.actualizaAgenda(uid, agenda);
			}
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
	public AgendaRespuesta consultaAgendaDia(AgendaDTO agenda) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(new String(""));
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaAgenda - Datos Entrada: " + agenda);
		 AgendaRespuesta respuesta = new AgendaRespuesta();
		 respuesta.setHeader( new EncabezadoRespuesta());
		 respuesta.getHeader().setUid(uid);
		 respuesta.getHeader().setEstatus(true);
		 respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		 AgendaDTO agendaConsulta = null;
		 try {
			 if (agenda.getIdCuadrilla() == null || agenda.getIdCuadrilla() <= 0) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID de la cuadrilla para la busqueda.");
			 }
			 if (agenda.getFechaBusqueda() == null || agenda.getFechaBusqueda().trim().isEmpty()) {
				 throw new ExcepcionesCuadrillas("Es necesario la fecha para la busqueda.");
			 }
			 agendaConsulta = new AgendaDAO().consultaAgendaDia(uid, agenda);
			 respuesta.setAgenda(agendaConsulta);
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

	/**
	 * Metodo para consultar las agendas disponibles
	 * @param agenda recibe valores de agenda
	 * @return regresa respuesta
	 */
	public AgendaRespuesta consultaAgendaContrato(AgendaDTO agenda) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(new String(""));
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "consultaAgendaContrato - Datos Entrada: ");
		 AgendaRespuesta respuesta = new AgendaRespuesta();
		 respuesta.setHeader( new EncabezadoRespuesta());
		 respuesta.getHeader().setUid(uid);
		 respuesta.getHeader().setEstatus(true);
		 respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		 List<AgendaDTO> listaAgenda = null;
		 try {
			 if (agenda.getIdContrato() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID del contrato.");
			 }
			 if (agenda.getFechaAgenda() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario una fecha para la busqueda.");
			 }
			 listaAgenda = new AgendaDAO().consultaAgendaContrato(uid, agenda);
			 respuesta.setAgenda(listaAgenda.get(0));
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
	/**
	 * Metodo para consultar agenda semanal
	 * @param agenda recibe valores de la agenda
	 * @return regresa respuesta
	 */
	public AgendaRespuesta consultaAgendaSemanal(AgendaDTO agenda) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(new String(""));
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaAgendaSemanal - Datos Entrada: ");
		 AgendaRespuesta respuesta = new AgendaRespuesta();
		 respuesta.setHeader( new EncabezadoRespuesta());
		 respuesta.getHeader().setUid(uid);
		 respuesta.getHeader().setEstatus(true);
		 respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		 AgendaDTO agendaRespuesta = null;
		 try {
			 if (agenda.getIdContrato() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID del contrato.");
			 }
			 if (agenda.getFechaBusqueda() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario una fecha para la busqueda.");
			 }
			 if (agenda.getNoSemana() < 0) {
				 throw new ExcepcionesCuadrillas("Es necesario el numero de la semana.");
			 }
			 agendaRespuesta = new AgendaDAO().consultaAgendaSemanal(uid, agenda);
			 respuesta.setAgenda(agendaRespuesta);
		 } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "consultaAgendaSemanal - Error: " + ex.getMessage(), ex);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "consultaAgendaSemanal - Error: " + ex.getMessage(), ex);
		    	respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "consultaAgendaSemanal - Datos Salida: " + respuesta);
			return respuesta;
		}
	/**
	 * Metodo para consulta las actividades diarias
	 * @param actividadDiaria recibe actividad diaria
	 * @return regresa respuesta
	 */
	public ActividadDiariaCampoRespuesta consultaActividadDiaria(ActividadDiariaCampoDTO actividadDiaria) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(actividadDiaria);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaActividadDiaria - Datos Entrada: " + actividadDiaria);
		ActividadDiariaCampoRespuesta respuesta = new ActividadDiariaCampoRespuesta();
		 respuesta.setHeader( new EncabezadoRespuesta());
		 respuesta.getHeader().setUid(uid);
		 respuesta.getHeader().setEstatus(true);
		 respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		 ActividadDiariaCampoDTO actividadDiariaRespuesta = null;
		 try {
			 if (actividadDiaria.getIdAgendaDetalle() == null || actividadDiaria.getIdAgendaDetalle() == 0) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID de la agenda para la busqueda.");
			 }
			 actividadDiariaRespuesta = new AgendaDAO().consultaActividadDiaria(uid, actividadDiaria);
			 respuesta.setActividadDiaria(actividadDiariaRespuesta);
		 } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "consultaActividadDiaria - Error: " + ex.getMessage(), ex);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "consultaActividadDiaria - Error: " + ex.getMessage(), ex);
		    	respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "consultaActividadDiaria - Datos Salida: " + respuesta);
			return respuesta;
		}
	/**
	 * Metodo para registrar las actividades diarias.
	 * @param actividadDiaria recibe valores de actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta registraActividadDiaria(ActividadDiariaDetalleDTO actividadDiaria) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(actividadDiaria);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "registraActividadDiaria - Datos Entrada: " + actividadDiaria);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (actividadDiaria.getIdActividadDiaria() == null || actividadDiaria.getIdActividadDiaria() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario el id Actividad Diaria de la actividad.");
					}
					if (actividadDiaria.getCodigoActividad() == null || actividadDiaria.getCodigoActividad().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el codigo de la actividad.");
					}
					if (actividadDiaria.getCodigoEstado() == null || actividadDiaria.getCodigoEstado().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el codigo del estado de la actividad.");
					}
					if (actividadDiaria.getCodigoListoVencido() == null
							|| actividadDiaria.getCodigoListoVencido().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el codigo listo vencido.");
					}
					if (actividadDiaria.getNumeroPersonas() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el numero de personas.");
					}
					if (actividadDiaria.getNumeroUnidades() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el numero de unidades.");
					}
					if (actividadDiaria.getPorcentaje() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el porcentaje avanzado.");
					}
					if (actividadDiaria.getTiempoDestinado() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el tiempo destinado.");
					}
					if (actividadDiaria.getObservaciones() == null || actividadDiaria.getObservaciones().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario una observacion.");
					}
					if (actividadDiaria.getUsuarioAlta() == null || actividadDiaria.getUsuarioAlta().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario de la trasaccion.");
					}
					if (!(actividadDiaria.getPlaneada().trim().equals("S")
							|| actividadDiaria.getPlaneada().trim().equals("N"))) {
						throw new ExcepcionesCuadrillas("El valor de la actividad planeada debe ser S o N.");
					}
					
					//Validaciones por Codigo Estado Actividad
					//COMPLETO
					if (actividadDiaria.getCodigoEstado().trim().equals("COMP")) {						
						if (actividadDiaria.getPorcentaje() != 100.0f) {
							throw new ExcepcionesCuadrillas("La actividad esta COMPLETA, debe tener 100% de porcentaje avance.");
						}
						if (actividadDiaria.getNumeroPersonas() <= 0) {
							throw new ExcepcionesCuadrillas("La actividad esta COMPLETA, el numero de personas debe ser mayor a 0.");
						}
						if (actividadDiaria.getNumeroUnidades() <= 0) {
							throw new ExcepcionesCuadrillas("La actividad esta COMPLETA, el numero de unidades ML, M2, M3 debe ser mayor a 0.");
						}
						if (actividadDiaria.getTiempoDestinado() <= 0) {
							throw new ExcepcionesCuadrillas("La actividad esta COMPLETA, el tiempo destinado debe ser mayor a 0.");
						}
					}
					//NO INICIADA
					if (actividadDiaria.getCodigoEstado().trim().equals("NOIN")) {						
						if (actividadDiaria.getPorcentaje() != 0.0f) {
							throw new ExcepcionesCuadrillas("La actividad esta NO INICIADA, debe tener 0% de porcentaje avance.");
						}
						if (actividadDiaria.getNumeroPersonas() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta NO INICIADA, el numero de personas debe ser  0.");
						}
						if (actividadDiaria.getNumeroUnidades() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta NO INICIADA, el numero de unidades ML, M2, M3 debe ser 0.");
						}
						if (actividadDiaria.getTiempoDestinado() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta NO INICIADA, el tiempo destinado debe ser 0.");
						}
					}
					//PROGRESO
					if (actividadDiaria.getCodigoEstado().trim().equals("PROG")) {						
						if (actividadDiaria.getPorcentaje() == 0.0f) {
							throw new ExcepcionesCuadrillas("La actividad esta EN PROGRESO, debe tener algo de porcentaje avance.");
						}
						if (actividadDiaria.getNumeroPersonas() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta EN PROGRESO, el numero de personas debe ser mayor  0.");
						}
						if (actividadDiaria.getNumeroUnidades() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta EN PROGRESO, el numero de unidades ML, M2, M3 debe ser mayor 0.");
						}
						if (actividadDiaria.getTiempoDestinado() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta EN PROGRESO, el tiempo destinado debe ser mayor 0.");
						}
					}
					//APLAZADA
					if (actividadDiaria.getCodigoEstado().trim().equals("APLA")) {						
						if (actividadDiaria.getPorcentaje() != 0.0f) {
							throw new ExcepcionesCuadrillas("La actividad esta APLAZADA, debe tener 0% de porcentaje avance.");
						}
						if (actividadDiaria.getNumeroPersonas() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta APLAZADA, el numero de personas debe ser  0.");
						}
						if (actividadDiaria.getNumeroUnidades() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta APLAZADA, el numero de unidades ML, M2, M3 debe ser 0.");
						}
						if (actividadDiaria.getTiempoDestinado() > 0) {
							throw new ExcepcionesCuadrillas("La actividad esta APLAZADA, el tiempo destinado debe ser 0.");
						}
					}
					AgendaDAO dao = new AgendaDAO();
					respuesta = dao.registraActividadDiaria(uid, actividadDiaria);
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "registraActividadDiaria - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "registraActividadDiaria - Datos Salida: " + respuesta);
				return respuesta;
	}
	/**
	 * Metodo para consulta las actividades diarias
	 * @param actividadDiaria recibe actividad diaria
	 * @return regresa respuesta
	 */
	public ActividadDiariaCampoRespuesta consultaActividadDiariaBuzon(ActividadDiariaCampoDTO actividadDiaria) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(actividadDiaria);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaActividadDiariaBuzon - Datos Entrada: " + actividadDiaria);
		ActividadDiariaCampoRespuesta respuesta = new ActividadDiariaCampoRespuesta();
		 respuesta.setHeader( new EncabezadoRespuesta());
		 respuesta.getHeader().setUid(uid);
		 respuesta.getHeader().setEstatus(true);
		 respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		 ActividadDiariaCampoDTO actividadDiariaRespuesta = null;
		 try {
			 if (actividadDiaria.getIdActividadDiaria() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID de la actividad para la busqueda.");
			 }
			 actividadDiariaRespuesta = new AgendaDAO().consultaActividadDiariaBuzon(uid, actividadDiaria);
			 respuesta.setActividadDiaria(actividadDiariaRespuesta);
		 } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "consultaActividadDiariaBuzon - Error: " + ex.getMessage(), ex);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "consultaActividadDiariaBuzon - Error: " + ex.getMessage(), ex);
		    	respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "consultaActividadDiariaBuzon - Datos Salida: " + respuesta);
			return respuesta;
		}
	/**
	 * Metodo para consultar los documentos
	 * @param documentos recibe el id del documento
	 * @return regresa la lista de documentos
	 */
	public ActividadDiariaDocumentosRespuesta consultaActividadDocumentos(ActividadDiariaDocumentosDTO documentos) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(documentos);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaActividadDocumentos - Datos Entrada: " + documentos);
		ActividadDiariaDocumentosRespuesta respuesta = new ActividadDiariaDocumentosRespuesta();
		 respuesta.setHeader( new EncabezadoRespuesta());
		 respuesta.getHeader().setUid(uid);
		 respuesta.getHeader().setEstatus(true);
		 respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		 List<ActividadDiariaDocumentosDTO> documentosRespuesta = null;
		 try {
			 if (documentos.getIdActividadDiaria() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID de la actividad para la busqueda.");
			 }
			 if (documentos.getCodigoActividad() == null || documentos.getCodigoActividad().trim().isEmpty()) {
				 throw new ExcepcionesCuadrillas("Es necesario el codigo de la actividad para la busqueda.");
			 }
			 documentosRespuesta = new AgendaDAO().consultaDocumentosActividad(uid, documentos);
			 respuesta.setDocumentos(documentosRespuesta);
		 } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "consultaActividadDocumentos - Error: " + ex.getMessage(), ex);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "consultaActividadDocumentos - Error: " + ex.getMessage(), ex);
		    	respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "consultaActividadDocumentos - Datos Salida: " + respuesta);
			return respuesta;
	}
	/**
	 * Metodo para autorizar las actividades.
	 * @param actividadDiaria recibe parametros de actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta autorizaActividadDiaria(ActividadDiariaCampoDTO actividadDiaria) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(actividadDiaria);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "autorizaActividadDiaria - Datos Entrada: " + actividadDiaria);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (actividadDiaria.getIdAgendaDetalle() == null || actividadDiaria.getIdAgendaDetalle() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario el id Agenda detalle.");
					}
					if (actividadDiaria.getAutorizacion() == null || actividadDiaria.getAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario la autorizacion.");
					}
					if (actividadDiaria.getComentarioAutorizacion() == null
							|| actividadDiaria.getComentarioAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario un comentario para la autorizacion.");
					}
					if (actividadDiaria.getUsuarioAutorizacion() == null
							|| actividadDiaria.getUsuarioAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario en el envio para la autorizacion.");
					}
					if (!(actividadDiaria.getAutorizacion().trim().equals("S")
							|| actividadDiaria.getAutorizacion().trim().equals("N"))) {
						throw new ExcepcionesCuadrillas("La autorizacion debe ser S o N.");
					}
					AgendaDAO dao = new AgendaDAO();
					respuesta = dao.autorizaActividadBuzon(uid, actividadDiaria);
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "autorizaActividadDiaria - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "autorizaActividadDiaria - Datos Salida: " + respuesta);
				return respuesta;
	}

	/**
	 * Metodo para eliminar las actividades no planeadas.
	 * @param actividadDiaria recibe parametros de actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta eliminaActividadDiaria(ActividadDiariaDetalleDTO actividadDiaria) {
		String uid = GUIDGenerator.generateGUID(actividadDiaria);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "eliminaActividadDiaria - Datos Entrada: " + actividadDiaria);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (actividadDiaria.getIdActividadDiaria() == null || actividadDiaria.getIdActividadDiaria() == 0) {
				throw new ExcepcionesCuadrillas("Es necesario el id Actividad Diaria de la actividad.");
			}
			if (actividadDiaria.getCodigoActividad() == null || actividadDiaria.getCodigoActividad().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo de la actividad.");
			}
			if (actividadDiaria.getUsuarioUltMod() == null || actividadDiaria.getUsuarioUltMod().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario de la trasaccion.");
			}
			AgendaDAO dao = new AgendaDAO();
			respuesta = dao.eliminaActividadDiaria(uid, actividadDiaria);
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "eliminaActividadDiaria - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "eliminaActividadDiaria - Datos Salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo para guardar las coordenadas registradas por las actividades.
	 * @param actividadDiaria recibe parametros de actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta guardarCoordenadasActividadDiaria(ActividadDiariaCampoDTO actividadDiaria) {
		String uid = GUIDGenerator.generateGUID(actividadDiaria);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "guardarCoordenadasActividadDiaria - Datos Entrada: " + actividadDiaria);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (actividadDiaria.getIdActividadDiaria() == null || actividadDiaria.getIdActividadDiaria() == 0) {
				 throw new ExcepcionesCuadrillas(
						 "Es necesario el ID de la Actividad Diaria para el registro de las coordenadas.");
			}
			if (actividadDiaria.getCoordenadasReal() == null || actividadDiaria.getCoordenadasReal().size() < 2)  {
					throw new ExcepcionesCuadrillas("Es necesario al menos dos coordenadas GPS.");
			}
			if (actividadDiaria.getUsuarioAlta() == null || actividadDiaria.getUsuarioAlta().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("Es necesario el usuario de la trasaccion.");
			}
			AgendaDAO dao = new AgendaDAO();
			respuesta = dao.guardarCoordenadasActividadDiaria(uid, actividadDiaria);
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "guardarCoordenadasActividadDiaria - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "guardarCoordenadasActividadDiaria - Datos Salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo para enviar a autorizar las actividades.
	 * @param actividadDiaria recibe parametros de actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta envioAutorizacionActividadDiaria(ActividadDiariaCampoDTO actividadDiaria) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(actividadDiaria);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "autorizaActividadDiaria - Datos Entrada: " + actividadDiaria);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (actividadDiaria.getIdAgendaDetalle() == null || actividadDiaria.getIdAgendaDetalle() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario el id Agenda detalle.");
					}
					if (actividadDiaria.getAutorizacion() == null || actividadDiaria.getAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario la autorizacion.");
					}
					if (actividadDiaria.getComentarioAutorizacion() == null
							|| actividadDiaria.getComentarioAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario un comentario para la autorizacion.");
					}
					if (actividadDiaria.getUsuarioAutorizacion() == null
							|| actividadDiaria.getUsuarioAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario en el envio para la autorizacion.");
					}
					if (!(actividadDiaria.getAutorizacion().trim().equals("S")
							|| actividadDiaria.getAutorizacion().trim().equals("N"))) {
						throw new ExcepcionesCuadrillas("La autorizacion debe ser S o N.");
					}
					AgendaDAO dao = new AgendaDAO();
					respuesta = dao.autorizaActividadBuzon(uid, actividadDiaria);
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "autorizaActividadDiaria - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "autorizaActividadDiaria - Datos Salida: " + respuesta);
				return respuesta;
	}

	/**
	 * Metodo para terminar la captura de las actividades diarias.
	 * @param actividadDiaria recibe valores de actividad
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta terminaActividadDiaria(ActividadDiariaCampoDTO actividadDiaria) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(actividadDiaria);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "registraActividadDiaria - Datos Entrada: " + actividadDiaria);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (actividadDiaria.getIdActividadDiaria() == null || actividadDiaria.getIdActividadDiaria() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario el id Actividad Diaria de la actividad.");
					}
					if (actividadDiaria.getObservaciones() == null || actividadDiaria.getObservaciones().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario una observacion.");
					}
					if (actividadDiaria.getEnvioUsuarioAutorizacion() == null
							|| actividadDiaria.getEnvioUsuarioAutorizacion().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario de la trasaccion.");
					}
					if (actividadDiaria.getCoordenadasReal() == null) {
						throw new ExcepcionesCuadrillas("Es necesario al menos dos coordenadas GPS.");
					}
					if (actividadDiaria.getCoordenadasReal().size() < 2) {
						throw new ExcepcionesCuadrillas("Es necesario al menos dos coordenadas GPS.");
					}

					for ( ActividadDiariaCoordenadasDTO coordenada : actividadDiaria.getCoordenadasReal()) {

						if (coordenada.getOrden() == 0) {
							throw new ExcepcionesCuadrillas("El orden en la coordenada es incorrecto.");
						}
						if (coordenada.getLatitud() == null) {
							throw new ExcepcionesCuadrillas("El atributo de latitud en la coordenada es incorrecto.");
						}
						if (coordenada.getLongitud() == null) {
							throw new ExcepcionesCuadrillas("El atributo de latitud en la coordenada es incorrecto.");
						}
						if (coordenada.getDireccion() == null) {
							coordenada.setDireccion("");
						}
						coordenada.setIdActividadDiaria(actividadDiaria.getIdActividadDiaria());
						coordenada.setUsuarioAlta(actividadDiaria.getEnvioUsuarioAutorizacion());
					}

					AgendaDAO dao = new AgendaDAO();
					respuesta = dao.terminaActividadDiaria(uid, actividadDiaria);
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "registraActividadDiaria - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "registraActividadDiaria - Datos Salida: " + respuesta);
				return respuesta;
	}

	/**
	 * Metodo para consultar los documentos
	 * @param documento recibe el id del documento
	 * @return regresa la lista de documentos
	 */
	public EncabezadoRespuesta registraActividadDiariaDocumentos(ActividadDiariaDocumentosDTO documento) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(documento);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaActividadDocumentos - Datos Entrada: " + documento);
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		 respuesta.setUid(uid);
		 respuesta.setEstatus(true);
		 respuesta.setMensajeFuncional("Consulta correcta.");
		 	 try {
			 if (documento.getIdActividadDiaria() == null) {
				 throw new ExcepcionesCuadrillas("Es necesario el ID de la actividad para subir la imagen.");
			 }
			 if (documento.getCodigoActividad() == null || documento.getCodigoActividad().trim().isEmpty()) {
				 throw new ExcepcionesCuadrillas("Es necesario el codigo de la actividad para subir la imagen.");
			 }
			 if (documento.getUrl() == null || documento.getUrl().trim().isEmpty()) {
				 throw new ExcepcionesCuadrillas("Es necesaria la URL para subir la imagen.");
			 }
			 if (documento.getUsuarioAlta() == null || documento.getUsuarioAlta().trim().isEmpty()) {
				 throw new ExcepcionesCuadrillas("Es necesario el usuario para subir la imagen.");
			 }			 
			 new AgendaDAO().registraActividadDiariaDocumentos(uid, documento, null);
			 respuesta.setCodigo(documento.getUrl());

		 } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "consultaActividadDocumentos - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "consultaActividadDocumentos - Error: " + ex.getMessage(), ex);
		    	respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "consultaActividadDocumentos - Datos Salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo para validar la eliminacion del detalle la agenda de un contrato
	 * @param agenda datos de la agenda
	 * @return respuesta del registro
	 */
	public EncabezadoRespuesta validaEliminaAgendaDetalle(AgendaDetalleDTO agenda) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(agenda);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "validaEliminaAgendaDetalle - Datos Entrada: " + agenda);
		SimpleDateFormat formateador = new SimpleDateFormat("YYYY-mm-dd");
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (agenda.getIdAgenda() <= 0) {
				throw new ExcepcionesCuadrillas("Es necesario el ID de la Agenda.");
			}
			if (agenda.getIdAgendaDetalle() == null || agenda.getIdAgendaDetalle() <= 0) {
				throw new ExcepcionesCuadrillas("Es necesaria el ID DEtalle de la Agenda.");
			}

			AgendaDAO dao = new AgendaDAO();
			respuesta = dao.consultaAgendaDetalleValidacion(uid, agenda);
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "validaEliminaAgendaDetalle - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "validaEliminaAgendaDetalle - Datos Salida: " + respuesta);
		return respuesta;
	}
}
