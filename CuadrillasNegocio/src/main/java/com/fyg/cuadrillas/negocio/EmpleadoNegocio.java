package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.RFCUtil;
import com.fyg.cuadrillas.dao.EmpleadoDAO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoDTO;
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
			if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El nombre es necesario en el alta del empleado.");
			}
			if (empleado.getApellidoPat() == null || empleado.getApellidoPat().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El apellido paterno es necesario en el alta del empleado.");
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
			if (empleado.getCodigoPuesto() == null || empleado.getCodigoPuesto().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El puesto es necesario en el alta del empleado.");
			}
			if (empleado.getCodigoVialidad() == null || empleado.getCodigoVialidad().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo de vialidad.");
			} else if (empleado.getCodigoArea() == null || empleado.getCodigoArea().isEmpty()) {
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
				throw new ExcepcionesCuadrillas("La lista de documentos es necesaria en la peticion de alta del empleado.");
			}
			for (EmpleadoDocumentoDTO documento : empleado.getDocumentos()) {
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
			//RFC Calculado
			String rfcCalculado  = RFCUtil.calcularRFCPersonaFisica(empleado.getNombre(),
						empleado.getApellidoPat(),
						empleado.getApellidoMat(),
						empleado.getFechaNacimiento());
			//Se le asigna el rfc calculado al campo rfc_calculado de usuarios
			empleado.setRfcCalculado(rfcCalculado);

			EmpleadoDAO dao = new EmpleadoDAO();
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
			if (empleado.getCodigoCausaSalida() == null || empleado.getCodigoCausaSalida().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("La causa de la salida es necesario para la baja.");
			}
			if (empleado.getCodigoTipoSalida() == null || empleado.getCodigoTipoSalida().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("La tipo de la salida es necesario para la baja.");
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
			if (empleado.getCodigoPuesto() == null || empleado.getCodigoPuesto().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("El puesto es necesario en la actualizacion del empleado.");
			}
			if (empleado.getCodigoVialidad() == null || empleado.getCodigoVialidad().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo de vialidad en la actualizacion del empleado.");
			} else if (empleado.getCodigoArea() == null || empleado.getCodigoArea().isEmpty()) {
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
				throw new ExcepcionesCuadrillas("La lista de documentos es necesaria en la peticion de actualizacion del empleado. del empleado.");
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
			//RFC Calculado
			String rfcCalculado  = RFCUtil.calcularRFCPersonaFisica(empleado.getNombre(),
						empleado.getApellidoPat(),
						empleado.getApellidoMat(),
						empleado.getFechaNacimiento());
			//Se le asigna el rfc calculado al campo rfc_calculado de usuarios
			empleado.setRfcCalculado(rfcCalculado);
			EmpleadoDAO dao = new EmpleadoDAO();

			//Validaciones Negocio
			EmpleadoDTO emp = dao.consultaEmpleado(uid, empleado);
			if (emp == null) {
				throw new ExcepcionesCuadrillas("El empleado solicitado no existe.");
			}
			if (emp.getEstatus().equals("I")) {
				throw new ExcepcionesCuadrillas("El empleado ya se encuentra dado de baja.");
			}

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
	    	if(empleado.getIdEmpleado() == null)
	    	{
	    		throw new ExcepcionesCuadrillas("Es necesario el id del empleado para la busqueda.");
	    	}
	    	 listaEmpleado = null;//new EmpleadoDAO().consultaEmpleado(uid, empleado);
	    	 respuesta.setEmpleado(listaEmpleado);
	    }catch  (ExcepcionesCuadrillas ex) {
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
}
