package com.fyg.cuadrillas.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;





import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.RFCUtil;
import com.fyg.cuadrillas.dao.EmpleadoDAO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoRespuesta;
import com.fyg.cuadrillas.dto.empleado.EmpleadoRespuesta;

public class EmpleadoNegocio {

	/** The LONGITUD_RFC. */
	private static final  int LONGITUD_RFC = 10;
	/** The LONGITUD_TELEFONO. */
	private static final  int LONGITUD_TELEFONO = 10;

	/**
	 * Metodo para dar de alta un empleado
	 * @param empleado recibe valores de empleado
	 * @return regresa respuesta de baja
	 */
	public EncabezadoRespuesta registraEmpleado(EmpleadoDTO empleado) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(empleado);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraEmpleado - Datos Entrada: " + empleado);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();

		try {
			if (empleado.getNoEmpleado() == null || empleado.getNoEmpleado().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El numero de empleado es necesario en el alta del empleado.");
			}
			if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El nombre es necesario en el alta del empleado.");
			}
			if (empleado.getApellidoPat() == null || empleado.getApellidoPat().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El apellido paterno es necesario en el alta del empleado.");
			}
			if (empleado.getApellidoMat() == null || empleado.getApellidoMat().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El apellido materno es necesario en el alta del empleado.");
			}
			if (empleado.getSexo() == null || empleado.getSexo().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El sexo es necesario en el alta del empleado.");
			}
			if (!(empleado.getSexo().equalsIgnoreCase("F") || empleado.getSexo().equalsIgnoreCase("M"))) {
				throw new ExcepcionesCuadrillas("El sexo del empleado es incorrecto.");
			}
			if (empleado.getRfc() == null || empleado.getRfc().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El RFC es necesario en el alta del empleado.");
			}
			if (empleado.getRfc().trim().length() < LONGITUD_RFC) {
				throw new ExcepcionesCuadrillas("La longitud del RFC debe ser minimo " + LONGITUD_RFC + " caracteres.");
			}
			if (empleado.getCodigoEmpresa() == null || empleado.getCodigoEmpresa().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("La empresa es necesaria en el alta del empleado.");
			}
			if (empleado.getCodigoPuesto() == null || empleado.getCodigoPuesto().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El puesto es necesario en el alta del empleado.");
			}
			 if (empleado.getCodigoArea() == null || empleado.getCodigoArea().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo area.");
			}
			 if (empleado.getCodigoTalla() == null || empleado.getCodigoTalla().isEmpty()) {
					throw new ExcepcionesCuadrillas("Es necesario el codigo area.");
				}
			if (empleado.getSueldo() <= 0) {
				throw new ExcepcionesCuadrillas("El sueldo es necesario en el alta del empleado.");
			}
			if ( empleado.getTelefono() == null) {
				empleado.setTelefono("");
			}
			if (!empleado.getTelefono().trim().isEmpty()) {
				if (empleado.getTelefono().trim().length() != LONGITUD_TELEFONO) {
					throw new ExcepcionesCuadrillas("La longitud del telefono debe ser de " + LONGITUD_TELEFONO + " caracteres.");
				}
			}

			if (empleado.getFrecuenciaPago() == null) {
				empleado.setFrecuenciaPago("");
			}
			if (empleado.getDocumentos().size() == 0) {
			 				throw new ExcepcionesCuadrillas("La lista de documentos es necesaria.");
			 			}
			 			for (EmpleadoDocumentoDTO documento : empleado.getDocumentos()) {
			 				documento.setIdEmpleado(empleado.getIdEmpleado());
			 				if (documento.getCodigoEmpDoc() == null || documento.getCodigoEmpDoc().trim().isEmpty()) {
			 					throw new ExcepcionesCuadrillas("El codigo del documento es obligatorio.");
			 				}
			 				if (documento.getEstatus() == null || documento.getCodigoEmpDoc().trim().isEmpty()) {
			 					throw new ExcepcionesCuadrillas("El codigo del documento es obligatorio.");
			 				}
			 }
			if (empleado.getUsuarioAlta() == null || empleado.getUsuarioAlta().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El usuario es necesario en el alta del empleado.");
			}
			if (empleado.getCodigoArea() == null || empleado.getCodigoArea().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El area es necesario en el alta del empleado.");
			}
			if (empleado.getFechaNacimiento() == null || empleado.getFechaNacimiento().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("La fecha de nacimiento es necesaria en el alta del empleado.");
			}

			 SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		     String strFecha = empleado.getFechaNacimiento();
		     Date fechaDate = formato.parse(strFecha);
			//RFC Calculado
			String rfcCalculado  = RFCUtil.calcularRFCPersonaFisica(empleado.getNombre(),
						empleado.getApellidoPat(),
						empleado.getApellidoMat(),
						fechaDate);
			//Se le asigna el rfc calculado al campo rfc_calculado de usuarios
			empleado.setRfcCalculado(rfcCalculado);
			EmpleadoDAO dao = new EmpleadoDAO();
			//Consultamos si ya existe
			respuesta = dao.registraEmpleado(uid, empleado);
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "registraEmpleado - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "registraEmpleado - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "registraEmpleado- Datos Salida: " + respuesta);
		return respuesta;
}
	/**
	 * Metodo para dar de baja un empleado
	 * @param empleado recibe valores de empleado
	 * @return regresa respuesta de baja
	 */
	public EncabezadoRespuesta bajaEmpleado(EmpleadoDTO empleado) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(empleado);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "bajaEmpleado- Datos Entrada: " + empleado);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		EmpleadoDTO emp = null;
		try {

			if (empleado.getIdEmpleado() == null || empleado.getIdEmpleado().intValue() <= 0) {
				throw new ExcepcionesCuadrillas("El No de empleado es necesario para la baja.");
			}
			if (empleado.getCodigoTipoSalida() == null || empleado.getCodigoTipoSalida().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El tipo de salida es necesario para la baja.");
			}
			if (empleado.getCodigoCausaSalida() == null || empleado.getCodigoCausaSalida().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("La causa de la salida es necesario para la baja.");
			}
			if (empleado.getUsuarioBaja() == null || empleado.getUsuarioBaja().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El Usuario es necesario para la baja.");
			}

			empleado.setNombre(null);
			empleado.setApellidoPat(null);
			empleado.setApellidoMat(null);
			EmpleadoDAO dao = new EmpleadoDAO();
			//Validaciones Negocio
			emp = dao.consultaEmpleado(uid, empleado);

			if (emp == null) {
				throw new ExcepcionesCuadrillas("El empleado solicitado no existe.");
			}

			if (emp.getEstatus().equals("I")) {
				throw new ExcepcionesCuadrillas("El empleado ya se encuentra dado de baja.");
			}

	        respuesta = dao.bajaEmpleado(uid, empleado);

		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaEmpleado - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaEmpleado - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaEmpleado - Datos Salida: " + respuesta);
		return respuesta;
}
	/**
	 * Metodo para modificar empleado
	 * @param empleado recibe valores de empleado
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta modificaEmpleado(EmpleadoDTO empleado) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(empleado);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "modificaEmpleado- Datos Entrada: " + empleado);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if (empleado.getIdEmpleado() == null || empleado.getIdEmpleado().intValue() <= 0) {
				throw new ExcepcionesCuadrillas("El No de empleado es necesario para la actualizacion.");
			}
			if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El nombre es necesario en la actualizacion del empleado.");
			}
			if (empleado.getApellidoPat() == null || empleado.getApellidoPat().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El apellido paterno es necesario en la actualizacion del empleado.");
			}
			if (empleado.getSexo() == null || empleado.getSexo().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El sexo es necesario en la actualizacion del empleado.");
			}
			if (!(empleado.getSexo().equalsIgnoreCase("F") || empleado.getSexo().equalsIgnoreCase("M"))) {
				throw new ExcepcionesCuadrillas("El sexo del empleado es incorrecto.");
			}
			if (empleado.getRfc() == null || empleado.getRfc().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El RFC es necesario en la actualizacion del empleado.");
			}
			if (empleado.getRfc().trim().length() < LONGITUD_RFC) {
				throw new ExcepcionesCuadrillas("La longitud del RFC debe ser minimo " + LONGITUD_RFC + " caracteres.");
			}
			if (empleado.getCodigoEmpresa() == null || empleado.getCodigoEmpresa().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("La empresa es necesaria en la actualizacion del empleado.");
			}
			if (empleado.getCodigoPuesto() == null || empleado.getCodigoPuesto().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El puesto es necesario en la actualizacion del empleado.");
			}
			if (empleado.getCodigoArea() == null || empleado.getCodigoArea().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo area en la actualizacion del empleado.");
			}
			if (empleado.getSueldo() <= 0) {
				throw new ExcepcionesCuadrillas("El sueldo es necesario en en la actualizacion del empleado. del empleado.");
			}
			if ( empleado.getTelefono() == null) {
				empleado.setTelefono("");
			}
			if (!empleado.getTelefono().trim().isEmpty()) {
				if (empleado.getTelefono().trim().length() != LONGITUD_TELEFONO) {
					throw new ExcepcionesCuadrillas("La longitud del telefono debe ser de " + LONGITUD_TELEFONO + " caracteres.");
				}
			}
			if (empleado.getFrecuenciaPago() == null) {
				empleado.setFrecuenciaPago("");
			}
			if (empleado.getDocumentos().size() == 0) {
 				throw new ExcepcionesCuadrillas("La lista de documentos es necesaria.");
 			}
 			for (EmpleadoDocumentoDTO documento : empleado.getDocumentos()) {
 				documento.setIdEmpleado(empleado.getIdEmpleado());
 				if (documento.getCodigoEmpDoc() == null || documento.getCodigoEmpDoc().trim().isEmpty()) {
 					throw new ExcepcionesCuadrillas("El codigo del documento es obligatorio.");
 				}
 				if (documento.getEstatus() == null || documento.getCodigoEmpDoc().trim().isEmpty()) {
 					throw new ExcepcionesCuadrillas("El codigo del documento es obligatorio.");
 				}
 			}
			if (empleado.getUsuarioAlta() == null || empleado.getUsuarioAlta().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El usuario es necesario en en la actualizacion del empleado.");
			}
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		     String strFecha = empleado.getFechaNacimiento();
		     Date fechaDate = formato.parse(strFecha);
			//RFC Calculado
			String rfcCalculado  = RFCUtil.calcularRFCPersonaFisica(empleado.getNombre(),
						empleado.getApellidoPat(),
						empleado.getApellidoMat(),
						fechaDate);
			//Se le asigna el rfc calculado al campo rfc_calculado de usuarios
			empleado.setRfcCalculado(rfcCalculado);
			EmpleadoDAO dao = new EmpleadoDAO();

			//Modificacion
 		    respuesta = dao.modificaEmpleado(uid, empleado);
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "modificaEmpleado - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "modificaEmpleado - Datos Salida: " + respuesta);
		return respuesta;
}
	/**
	 * Metodo para consultar empleados
	 * @param empleado recibe valores de empleados
	 * @return regresa lista de empleado
	 */
	public EmpleadoRespuesta consultaEmpleado(EmpleadoDTO empleado) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(empleado);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaEmpleado - Datos Entrada: " + empleado);
		//Variable de resultado
		EmpleadoRespuesta respuesta = new EmpleadoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");

		List<EmpleadoDTO> listaEmpleado = null;

	    try {
	    	if (empleado.getIdEmpleado() == null)
	    	{
	    		throw new ExcepcionesCuadrillas("Es necesario el id del empleado para la busqueda.");
	    	}
	    	 listaEmpleado = new EmpleadoDAO().consultaGeneral(uid, empleado);
	    	 respuesta.setEmpleado(listaEmpleado);
	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "ConsultaEmpleado - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "ConsultaEmpleado - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaEmpleado - Datos Salida: " + respuesta);
	    return respuesta;
	}
	/**
	 * Devuelve lista general de empleados sin consultar ID
	 * @return regresa lista de empleado
	 * @throws Exception si se crea un error
	 */
	public EmpleadoRespuesta consultaGeneral() throws Exception {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(new String(""));
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "consultaGeneral - Daton Entrada: ");
				EmpleadoRespuesta respuesta = new EmpleadoRespuesta();
				respuesta.setHeader( new EncabezadoRespuesta());
				respuesta.getHeader().setUid(uid);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
				List<EmpleadoDTO> listaEmpleado = null;
						try {
							listaEmpleado = new EmpleadoDAO().consultaGeneralEmpleado(uid);
							respuesta.setEmpleado(listaEmpleado);
						} catch  (ExcepcionesCuadrillas ex) {
							LogHandler.error(uid, this.getClass(), "consultaGeneral - Error: " + ex.getMessage(), ex);
							respuesta.getHeader().setEstatus(false);
							respuesta.getHeader().setMensajeFuncional(ex.getMessage());
							respuesta.getHeader().setMensajeTecnico(ex.getMessage());
						} catch (Exception ex) {
					    	LogHandler.error(uid, this.getClass(), "consultaGeneral - Error: " + ex.getMessage(), ex);
					    	respuesta.getHeader().setEstatus(false);
							respuesta.getHeader().setMensajeFuncional(ex.getMessage());
							respuesta.getHeader().setMensajeTecnico(ex.getMessage());
					    }
					    LogHandler.debug(uid, this.getClass(), "consultaGeneral - Datos Salida: " + respuesta);
						return respuesta;
	}
	/**
	 * Metodo para consultar los documentos
	 * @param empleadoDocumento recibe valores de los docs
	 * @return regresa lista de documentos
	 */
	public EmpleadoDocumentoRespuesta consultaDocumento(EmpleadoDocumentoDTO empleadoDocumento) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(empleadoDocumento);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaDocumento - Datos Entrada: " + empleadoDocumento);
		//Variable de resultado
		EmpleadoDocumentoRespuesta respuesta = new EmpleadoDocumentoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");

		List<EmpleadoDocumentoDTO> listaDocumento = null;

	    try {
	    	if (empleadoDocumento.getIdEmpleado() == null)
	    	{
	    		throw new ExcepcionesCuadrillas("Es necesario el id del empleado para la busqueda.");
	    	}
	    	 listaDocumento = new EmpleadoDAO().consultaDocumentos(uid, empleadoDocumento);
	    	 respuesta.setEmpleadoDocumento(listaDocumento);
	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "consultaDocumento - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "consultaDocumento - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaDocumento - Datos Salida: " + respuesta);
	    return respuesta;
	}
	/**
	 * Metodo para consultar los colaboradores
	 * @param empleado recibe parametros de empleado
	 * @return regresa lista de colaboradores
	 */
	public EmpleadoRespuesta consultaColaborador(EmpleadoDTO empleado) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(empleado);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "consultaColaborador - Datos Entrada: " + empleado);
				//Variable de resultado
				EmpleadoRespuesta respuesta = new EmpleadoRespuesta();
				respuesta.setHeader( new EncabezadoRespuesta());
				respuesta.getHeader().setUid(uid);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensajeFuncional("Consulta correcta.");

				List<EmpleadoDTO> listaColaborador = null;

			    try {
			    	if (empleado.getIdCuadrilla() == null)
			    	{
			    		throw new ExcepcionesCuadrillas("Es necesario el id de la cuadrilla para la busqueda.");
			    	}
			    	listaColaborador = new EmpleadoDAO().consultaColaborador(uid, empleado);
			    	respuesta.setEmpleado(listaColaborador);
			    } catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "consultaColaborador - Error: " + ex.getMessage(), ex);
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
				} catch (Exception ex) {
			    	LogHandler.error(uid, this.getClass(), "consultaColaborador - Error: " + ex.getMessage(), ex);
			    	respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			    }
			    LogHandler.debug(uid, this.getClass(), "consultaColaborador - Datos Salida: " + respuesta);
			    return respuesta;
	}
	/**
	 * Metodo para notificar al imss
	 * @param empleado recibe valores del usuario
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta notificaImss(EmpleadoDTO empleado) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(empleado);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "notificaImss - Datos Entrada: " + empleado);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try {
					if (empleado.getIdEmpleado() == null || empleado.getIdEmpleado().intValue() <= 0) {
						throw new ExcepcionesCuadrillas("El ID de empleado es necesario para la notificación al imss.");
					}
					if (empleado.getUsuarioAutImss() == null || empleado.getUsuarioAutImss().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario para la notificacion al imss.");
					}
					EmpleadoDAO dao = new EmpleadoDAO();
					respuesta = dao.notificaImss(uid, empleado);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "registraEmpleado - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "registraEmpleado - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "registraEmpleado- Datos Salida: " + respuesta);
				return respuesta;
	}
}
