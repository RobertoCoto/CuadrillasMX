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
import com.fyg.cuadrillas.dto.contrato.ContratoRespuesta;



public class ContratoNegocio {

	/** The METROS_KM. */
	private static final  int METROS_KM = 1000;

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
					if (contrato.getCodigoVialidad() == null || contrato.getCodigoVialidad().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesaria la Vialidad para el Documento.");
					}
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
					if ( !fechaInicio.before(fechaFin) ) {
						throw new ExcepcionesCuadrillas("La fecha inicio no puede ser igual o mayor a la fecha fin.");
					}
					//Calculo Dias Duracion
					contrato.setDiasDuracion(Funciones.diasEntreFechas(fechaInicio, fechaFin));

					System.out.println("Dias Duracions " + contrato.getDiasDuracion());

					//Calculo Distancia Total Contrato
					double metros = 0;
					for ( int i = 0; i < (contrato.getCoordenadas().size() - 1); i++) {
						double distancia = Funciones.distanciaCoord(
								contrato.getCoordenadas().get(i).getLatitud(),
								contrato.getCoordenadas().get(i).getLongitud(),
								contrato.getCoordenadas().get(i + 1).getLatitud(),
								contrato.getCoordenadas().get(i + 1).getLongitud());
						System.out.println("distancia =" + distancia);
						metros += distancia;
					}
					contrato.setMetros((int) metros * METROS_KM);

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
				LogHandler.debug(uid, this.getClass(), "altaContrato - Datos Entrada: " + contrato);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (contrato.getIdContrato()== null) {
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
					if (contrato.getCodigoVialidad() == null || contrato.getCodigoVialidad().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesaria la Vialidad para el Documento.");
					}
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
					if ( !fechaInicio.before(fechaFin) ) {
						throw new ExcepcionesCuadrillas("La fecha inicio no puede ser igual o mayor a la fecha fin.");
					}
					//Calculo Dias Duracion
					contrato.setDiasDuracion(Funciones.diasEntreFechas(fechaInicio, fechaFin));

					System.out.println("Dias Duracions " + contrato.getDiasDuracion());

					//Calculo Distancia Total Contrato
					double metros = 0;
					for ( int i = 0; i < (contrato.getCoordenadas().size() - 1); i++) {
						double distancia = Funciones.distanciaCoord(
								contrato.getCoordenadas().get(i).getLatitud(),
								contrato.getCoordenadas().get(i).getLongitud(),
								contrato.getCoordenadas().get(i + 1).getLatitud(),
								contrato.getCoordenadas().get(i + 1).getLongitud());
						System.out.println("distancia =" + distancia);
						metros += distancia;
					}
					contrato.setMetros((int) metros * METROS_KM);

					//Alta Contrato
					if (contrato.getIdContrato() == null || contrato.getIdContrato() == 0) {
						contrato.setFechaRegistro(new Date());
						contrato.setEstatus("A");
					}

					ContratoDAO dao = new ContratoDAO();
					respuesta = dao.modificaContrato(uid, contrato);
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
}
