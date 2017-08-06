package com.fyg.cuadrillas.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.Funciones;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.ContratoDAO;
import com.fyg.cuadrillas.dao.ParametroDAO;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDocumentoDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDocumentoRespuesta;
import com.fyg.cuadrillas.dto.contrato.ContratoRespuesta;



public class ContratoNegocio {

	/**
	 * Metodo para dar de alta un contrato
	 * @param contrato recibe valores del contrato
	 * @return regresa la respuesta
	 */
	public EncabezadoRespuesta altaContrato(ContratoDTO contrato) {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(contrato);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "altaContrato - Datos Entrada: " + contrato);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (contrato.getNumeroDocumento() == null || contrato.getNumeroDocumento().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el Numero de Documento.");
					}
					if (contrato.getCodigoDocumento() == null || contrato.getCodigoDocumento().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el tipo de Documento.");
					}
					if (contrato.getCodigoContrato() == null || contrato.getCodigoContrato().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el tipo de Contrato.");
					}
					/*
					if (contrato.getCodigoVialidad() == null || contrato.getCodigoVialidad().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesaria la Vialidad para el Documento.");
					}
					*/
					if (contrato.getCodigoEmpresa() == null || contrato.getCodigoEmpresa().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesaria la Empresa para el Documento.");
					}
					if (contrato.getMonto() < 0) {
						throw new ExcepcionesCuadrillas("El monto del Documento no puede ser negativo.");
					}
					if (contrato.getSubtotal() < 0) {
						throw new ExcepcionesCuadrillas("El subtotal del Documento no puede ser negativo.");
					}
					if (contrato.getFechaInicio() == null) {
						throw new ExcepcionesCuadrillas("Es necesaria la Fecha de Inicio.");
					}
					if (contrato.getFechaFin() == null) {
						throw new ExcepcionesCuadrillas("Es necesaria la Fecha de Fin.");
					}
					if (contrato.getCoordenadas() == null)  {
						throw new ExcepcionesCuadrillas("Es necesario al menos dos coordenadas GPS.");
					}
					if (contrato.getCoordenadas().size() < 2) {
						throw new ExcepcionesCuadrillas("Es necesario al menos dos coordenadas GPS.");
					}
					if (contrato.getUsuarioAlta() == null || contrato.getUsuarioAlta().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario para la operacion.");
					}
					if (contrato.getUrl() == null || contrato.getUrl().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario la URL del archivo del contrato.");
					}
					if (contrato.getIdCuadrilla() == null || contrato.getIdCuadrilla() <= 0) {
						throw new ExcepcionesCuadrillas("Es necesaria la Cuadrilla asignada al contrato.");
					}
					if (contrato.getObservaciones() == null) {
						contrato.setObservaciones("");
					}

					if (contrato.getSubtotal() > contrato.getMonto()) {
						throw new ExcepcionesCuadrillas("El subtotal no puede ser mayor al total.");
					}
					for ( CoordenadaDTO coordenada : contrato.getCoordenadas()) {

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
					}
					SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

					Date fechaInicio = formateador.parse(contrato.getFechaInicio());
					Date fechaFin = formateador.parse(contrato.getFechaFin());

					//Validacion de Fechas
					System.out.println("Comparacion Fechas " + fechaInicio.compareTo(fechaFin));
					System.out.println("Comparacion Fechas " + fechaInicio.before(fechaFin));
					System.out.println("Comparacion Fechas " + fechaInicio.after(fechaFin));
					
					if ( !fechaInicio.after(fechaFin) ) {
						throw new ExcepcionesCuadrillas("La fecha inicio no puede ser igual o mayor a la fecha fin.");
					}
					//Calculo Dias Duracion
					contrato.setDiasDuracion(Funciones.diasEntreFechas(fechaInicio, fechaFin));

					System.out.println("Dias Duracions " + contrato.getDiasDuracion());
					//Alta Contrato
					if (contrato.getIdContrato() == null || contrato.getIdContrato() == 0) {
						contrato.setFechaRegistro(new Date());
						contrato.setEstatus("A");
					}

					ContratoDAO dao = new ContratoDAO();
					respuesta = dao.altaContrato(uid, contrato);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "altaContrato - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "altaContrato - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "altaContrato - Datos Salida: " + respuesta);
				return respuesta;
	}

	/**
	 * Metodo para dar de baja un contrato.
	 * @param contrato id contrato a dar de baja
	 * @return resultado
	 */
	public EncabezadoRespuesta bajaContrato(ContratoDTO contrato) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(contrato);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "bajaContrato - Datos Entrada: " + contrato);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();

		try {
			if (contrato.getIdContrato() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id del contrato para la baja.");
			}
			if (contrato.getUsuarioBaja() == null || contrato.getUsuarioBaja().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario para la baja.");
			}
			ContratoDAO dao = new ContratoDAO();
			respuesta = dao.bajaContrato(uid, contrato);
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaContrato - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaContrato - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaContrato - Datos Salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo para regresar los contratos
	 * @param contrato por si se desea consultar uno en especifico
	 * @return los contratos
	 */
	public ContratoRespuesta consultaContrato(ContratoDTO contrato) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(contrato);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaContrato - Datos Entrada: " + contrato);
		//Variable de resultado
		ContratoRespuesta respuesta = new ContratoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");

		List<ContratoDTO> listaContrato = null;

	    try {
	    	listaContrato = new ContratoDAO().consultaContrato(uid, contrato);
	    	respuesta.setContrato(listaContrato);
	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "consultaContratoo - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "consultaContratoo - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaContrato - Datos Salida: " + respuesta);
	    return respuesta;
	}
	/**
	 * Metodo para consultar Contratos Activos
	 * @return regresa respuesta
	 */
	public ContratoRespuesta contratoActivo() {
		ContratoDTO con = new ContratoDTO();
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(con);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "contratoActivo - Datos Entrada: " + con);
				//Variable de resultado
				ContratoRespuesta respuesta = new ContratoRespuesta();
				respuesta.setHeader( new EncabezadoRespuesta());
				respuesta.getHeader().setUid(uid);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
				List<ContratoDTO> listaContratosActivos = null;
				try {
					String parametroLaboral = "empleado.hora.laboral";
					String valor = new ParametroDAO().consultaParametro(uid, parametroLaboral);
					con.setHoraLaboral(Integer.parseInt(valor));
					listaContratosActivos = new ContratoDAO().contratoActivo(uid, con);
					respuesta.setContrato(listaContratosActivos);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "contratoActivo - Error: " + ex.getMessage(), ex);
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
				} catch (Exception ex) {
			    	LogHandler.error(uid, this.getClass(), "contratoActivo- Error: " + ex.getMessage(), ex);
			    	respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			    }
			    LogHandler.debug(uid, this.getClass(), "contratoActivo - Datos Salida: " + respuesta);
			    return respuesta;
	}
	/**
	 * Metodo para consultar el documento del contrato
	 * @param contrato recibe valores del contacto
	 * @return regresa respuesta del documento
	 */
	public ContratoRespuesta consultaContratoDocumento(ContratoDTO contrato) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(contrato);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaContratoDocumento - Datos Entrada: " + contrato);
		//Variable de resultado
		ContratoRespuesta respuesta = new ContratoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		List<ContratoDTO> listaContratoDocumento = null;
		try {
			listaContratoDocumento = new ContratoDAO().consultacontratoDocumento(uid, contrato);
			respuesta.setContrato(listaContratoDocumento);
		}  catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "contratoActivo - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "contratoActivo- Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "contratoActivo - Datos Salida: " + respuesta);
	    return respuesta;
	}
	/**
	 * Metodo para modificar un contrato
	 * @param contrato recibe valores del contrato
	 * @return regresa la respuesta
	 */
	public EncabezadoRespuesta modificaContrato(ContratoDTO contrato) {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(contrato);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "modificaContrato - Datos Entrada: " + contrato);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (contrato.getIdContrato() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el id del Contrato para la actualización.");
					}
					if (contrato.getNumeroDocumento() == null || contrato.getNumeroDocumento().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el Numero de Documento.");
					}
					if (contrato.getCodigoDocumento() == null || contrato.getCodigoDocumento().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el tipo de Documento.");
					}
					if (contrato.getCodigoContrato() == null || contrato.getCodigoContrato().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el tipo de Contrato.");
					}
					/*
					if (contrato.getCodigoVialidad() == null || contrato.getCodigoVialidad().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesaria la Vialidad para el Documento.");
					}
					*/
					if (contrato.getCodigoEmpresa() == null || contrato.getCodigoEmpresa().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesaria la Empresa para el Documento.");
					}
					if (contrato.getMonto() < 0) {
						throw new ExcepcionesCuadrillas("El monto del Documento no puede ser negativo.");
					}
					if (contrato.getSubtotal() < 0) {
						throw new ExcepcionesCuadrillas("El subtotal del Documento no puede ser negativo.");
					}
					if (contrato.getFechaInicio() == null) {
						throw new ExcepcionesCuadrillas("Es necesaria la Fecha de Inicio.");
					}
					if (contrato.getFechaFin() == null) {
						throw new ExcepcionesCuadrillas("Es necesaria la Fecha de Fin.");
					}
					if (contrato.getCoordenadas() == null)  {
						throw new ExcepcionesCuadrillas("Es necesario al menos dos coordenadas GPS.");
					}
					if (contrato.getCoordenadas().size() < 2) {
						throw new ExcepcionesCuadrillas("Es necesario al menos dos coordenadas GPS.");
					}
					if (contrato.getUsuarioAlta() == null || contrato.getUsuarioAlta().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario para la operacion.");
					}
					if (contrato.getIdCuadrilla() == null) {
						contrato.setIdCuadrilla(0);
					}
					if (contrato.getObservaciones() == null) {
						contrato.setObservaciones("");
					}
					if (contrato.getUrl() == null) {
						contrato.setUrl("");
					}
					if (contrato.getSubtotal() > contrato.getMonto()) {
						throw new ExcepcionesCuadrillas("El subtotal no puede ser mayor al total.");
					}
					for ( CoordenadaDTO coordenada : contrato.getCoordenadas()) {

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
					}
					SimpleDateFormat formateador = new SimpleDateFormat("YYYY-mm-dd");

					Date fechaInicio = formateador.parse(contrato.getFechaInicio());
					Date fechaFin = formateador.parse(contrato.getFechaFin());

					//Validacion de Fechas
					System.out.println("Comparacion Fechas " + fechaInicio.compareTo(fechaFin));
					System.out.println("Comparacion Fechas " + fechaInicio.before(fechaFin));
					if (fechaInicio.after(fechaFin) ) {
						throw new ExcepcionesCuadrillas("La fecha inicio no puede ser igual o mayor a la fecha fin.");
					}
					//Calculo Dias Duracion
					contrato.setDiasDuracion(Funciones.diasEntreFechas(fechaInicio, fechaFin));

					System.out.println("Dias Duracions " + contrato.getDiasDuracion());
					//Alta Contrato
					if (contrato.getIdContrato() == null || contrato.getIdContrato() == 0) {
						contrato.setFechaRegistro(new Date());
						contrato.setEstatus("A");
					}

					ContratoDAO dao = new ContratoDAO();
					respuesta = dao.modificaContrato(uid, contrato);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "modificaContrato - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "modificaContrato - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "modificaContrato - Datos Salida: " + respuesta);
				return respuesta;
	}
	/**
	 * Metodo para consultar el documento del contrato
	 * @param contratoDocumento recibe valores del contacto
	 * @return regresa respuesta del documento
	 */
	public ContratoDocumentoRespuesta consultaDocumentoCon(ContratoDocumentoDTO contratoDocumento) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(contratoDocumento);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaDocumentoCon - Datos Entrada: " + contratoDocumento);
		//Variable de resultado
		ContratoDocumentoRespuesta respuesta = new ContratoDocumentoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		List<ContratoDocumentoDTO> listaDocumento = null;
		try {
			listaDocumento = new ContratoDAO().consultaDocumentosCon(uid, contratoDocumento);
			respuesta.setContratoDocumento(listaDocumento);
		}  catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "consultaDocumentoCon - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "consultaDocumentoCon- Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaDocumentoCon - Datos Salida: " + respuesta);
	    return respuesta;
	}
	/**
	 * Metodo para consultar el documento del contrato
	 * @param contratoDocumento recibe valores del contacto
	 * @return regresa respuesta del documento
	 */
	public ContratoDocumentoRespuesta documentoCont(ContratoDocumentoDTO contratoDocumento) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(contratoDocumento);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "documentoCont - Datos Entrada: " + contratoDocumento);
		//Variable de resultado
		ContratoDocumentoRespuesta respuesta = new ContratoDocumentoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		List<ContratoDocumentoDTO> listaDocumento = null;
		try {
			listaDocumento = new ContratoDAO().documentoContrato(uid, contratoDocumento);
			respuesta.setContratoDocumento(listaDocumento);
		}  catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "documentoCont - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "documentoCont- Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "documentoCont - Datos Salida: " + respuesta);
	    return respuesta;
	}
	/**
	 * Metodo para registrar nuevos docs
	 * @param documento recibe vals de docs
	 * @return regresa respuesta
	 */
	public EncabezadoRespuesta registraDocumentosExtra(ContratoDocumentoDTO documento) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(documento);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "RegistraDocumentosExtra - Datos Entrada: " + documento);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (documento.getIdContrato() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id del contrato.");
			}
			if (documento.getNombre() == null || documento.getNombre().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el nombre del documento.");
			}
			if (documento.getCodigoDocumento() == null || documento.getCodigoDocumento().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo del documento.");
			}
			if (documento.getUrl() == null) {
				documento.setUrl("");
			}
			ContratoDAO dao = new ContratoDAO();
			respuesta = dao.registraDocumentosExtra(uid, documento);
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "RegistraDocumentosExtra - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "RegistraDocumentosExtra - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "RegistraDocumentosExtra - Datos Salida: " + respuesta);
		return respuesta;
	}
}
