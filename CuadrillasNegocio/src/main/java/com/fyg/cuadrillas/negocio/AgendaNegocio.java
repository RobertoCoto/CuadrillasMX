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
						throw new ExcepcionesCuadrillas("Es necesario el id de la actividad diaria.");
					}
					if (actividadDiaria.getCodigoActividad() == null || actividadDiaria.getCodigoActividad().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el codigo de la actividad.");
					}
					if (actividadDiaria.getCodigoListoVencido() == null
							|| actividadDiaria.getCodigoListoVencido().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el codigo listo vencido.");
					}
					if (actividadDiaria.getNumeroPersonas() == null || actividadDiaria.getNumeroPersonas() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario el numero de personas.");
					}
					if (actividadDiaria.getNumeroUnidades() == null || actividadDiaria.getNumeroUnidades() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario el numero de unidades.");
					}
					if (actividadDiaria.getPorcentaje() == null || actividadDiaria.getPorcentaje() == 0) {
						throw new ExcepcionesCuadrillas("Es necesario el porcentaje avanzado.");
					}
					if (actividadDiaria.getObservaciones() == null || actividadDiaria.getObservaciones().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario una observacion.");
					}
					if (actividadDiaria.getUsuarioAlta() == null || actividadDiaria.getUsuarioAlta().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario de la trasaccion.");
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
						throw new ExcepcionesCuadrillas("Es necesario el envio para la autorizacion.");
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
	}
