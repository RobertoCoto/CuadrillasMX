package com.fyg.cuadrillas.negocio;

import java.util.regex.Pattern;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.EmpleadoDAO;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.comun.RFCUtil;

public class EmpleadoNegocio {
	@SuppressWarnings("static-access")
	public EncabezadoRespuesta registraEmpleado(Empleado empleado) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(empleado);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraEmpleado - Datos Entrada: " + empleado);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		//Para validar curp
		Boolean curpValidado = null;
		//Para validar Sexo
		Boolean sexoValido = null;
		//Para validar rfc
		Boolean rfcValido = null;
		try {
			//Validaciones Negocio
			if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el nombre del empleado");
			} else if (empleado.getApellido_pat() == null || empleado.getApellido_pat().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el apellido paterno");
			} else if (empleado.getApellido_mat() == null || empleado.getApellido_mat().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el apellido materno");
			} else if (empleado.getSexo() == null || empleado.getSexo().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario expecificar el sexo.");
			} else if (empleado.getRfc() == null || empleado.getRfc().isEmpty()) {
				rfcValido = false;
				if (rfcValido.equals(false)) {
                	throw new ExcepcionesCuadrillas("RFC no valido o esta vacio.");
				}
			}else if (empleado.getRfc().trim().length() < 10) {
				rfcValido = true;
			} else if (empleado.getCurp() == null ||empleado.getCurp().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario la curp");
			} else if (empleado.getCodigo_puesto() == null || empleado.getCodigo_puesto().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo puesto");
			} else if (empleado.getCodigo_vialidad() == null || empleado.getCodigo_vialidad().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo de vialidad.");
			} else if (empleado.getCodigo_area() == null || empleado.getCodigo_area().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el codigo area.");
			} else {
				//validar curp
				String regex =
				 	    "[A-Z]{1}[A-Z]{1}[A-Z]{2}[0-9]{2}"
				 	    + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
				 	    + "[HM]{1}"
				 		+ "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
				 	    + "[B-DF-HJ-NP-TV-Z]{3}"
				 		+ "[0-9A-Z]{1}[0-9]{1}$";

				 	    Pattern patron = Pattern.compile(regex);
				 	    if (!patron.matcher(empleado.getCurp()).matches()) {
				 	    	curpValidado = false;
				 	    } else {
				 	    	curpValidado = true;
				 	    }
			}
			if (curpValidado.equals( false)) {
				throw new ExcepcionesCuadrillas("CURP NO VALIDO.");
			}else {
				//valida Sexo
				String regex = "[FM]{1}";
				Pattern patron = Pattern.compile(regex);
				 if (!patron.matcher(empleado.getSexo()).matches()) {
				    	sexoValido = false;
				    }
				        sexoValido = true;
			}
			if (sexoValido.equals(false)) {
				throw new ExcepcionesCuadrillas("SEXO NO VALIDO.");
			}
			RFCUtil calcularRFC = new RFCUtil();
			String nombre = empleado.getNombre();
			String apellidoPat = empleado.getApellido_pat();
			String apellidoMat = empleado.getApellido_mat();
			String rfcCalculado  = calcularRFC.calcularRFCPersonaFisica(nombre,apellidoPat,apellidoMat,empleado.getFecha_nacimiento());
			//Se le asigna el rfc calculado al campo rfc_calculado de usuarios
			empleado.setRfc_calculado(rfcCalculado);
			EmpleadoDAO dao = new EmpleadoDAO();
			respuesta = dao.registraEmpleado(uid, empleado);
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "registraCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "registraCatalogo - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "registraCatalogo - Datos Salida: " + respuesta);
		return respuesta;
}
}
