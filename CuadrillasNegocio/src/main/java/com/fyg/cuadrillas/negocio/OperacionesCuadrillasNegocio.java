package com.fyg.cuadrillas.negocio;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.RFCUtil;
import com.fyg.cuadrillas.dto.Perfil;
import com.fyg.cuadrillas.dto.Usuario;
import com.fyg.cuadrillas.dto.Parametros;
import com.fyg.cuadrillas.dao.ConsultaParametro;
import com.fyg.cuadrillas.dao.ConsultasCuadrillasDAO;
import com.fyg.cuadrillas.dao.OperacionesCuadrillasDAO;


public class OperacionesCuadrillasNegocio {
	/**
	 * Objeto para recibir  datos perfil
	 */
	 private Perfil perfilUsuario;
	 /**
	  * Objeto para recibir datos del parametro;
	  */
	 private Parametros parametroComp;
	 /**
	  * Objeto parametros negocio para traer el valor del parametro
	  */
	 private ParametrosNegocio parametroRecibido;
	/**
	 * Metodo para dar de alta un usuario
	 * @param usuario Recibe valores de usuario
	 * @return regresa la respuesta si fue registrado
	 */
	@SuppressWarnings("static-access")
	public EncabezadoRespuesta altaUsuario(Usuario usuario) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(usuario);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "altaUsuario - Datos Entrada: " + usuario);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		//Para validar curp
		Boolean curpValidado = null;
		//Para validar Sexo
		Boolean sexoValido = null;
		//Para validar rfc
		Boolean rfcValido = null;
		List<Usuario> listaUsuario = null;
		List<Perfil> listaPerfil = null;
		List<Parametros> listaParametro = null;
		try {
			//Validaciones de campos.
			if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario especificar un usuario.");
			} else if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
				throw new ExcepcionesCuadrillas("El campo nombre no puede ir vacio.");
			} else if (usuario.getApellido_pat() == null || usuario.getApellido_pat().isEmpty() ) {
				throw new ExcepcionesCuadrillas("El campo apellido paterno no puede ir vacio.");
			} else if (usuario.getApellido_mat() == null || usuario.getApellido_mat().isEmpty()) {
				throw new ExcepcionesCuadrillas("El campo apellido materno no puede ir vacio.");
			} else if (usuario.getSexo() == null || usuario.getSexo().isEmpty()) {
				throw new ExcepcionesCuadrillas("El campo sexo no puede ir vacio.");
			} else if (usuario.getRfc() == null || usuario.getRfc().isEmpty()) {
				rfcValido = false;
                if (rfcValido.equals(false)) {
                	throw new ExcepcionesCuadrillas("RFC no valido o esta vacio.");
				}
			} else if (usuario.getRfc().trim().length() < 10) {
				rfcValido = true;
			}
			else {
				//validar curp
				String regex =
				 	    "[A-Z]{1}[A-Z]{1}[A-Z]{2}[0-9]{2}"
				 	    + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
				 	    + "[HM]{1}"
				 		+ "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
				 	    + "[B-DF-HJ-NP-TV-Z]{3}"
				 		+ "[0-9A-Z]{1}[0-9]{1}$";

				 	    Pattern patron = Pattern.compile(regex);
				 	    if (!patron.matcher(usuario.getCurp()).matches()) {
				 	    	curpValidado = false;
				 	    } else {
				 	    	curpValidado = true;
				 	    }
			}
			if (curpValidado.equals( false)) {
				throw new ExcepcionesCuadrillas("CURP NO VALIDO.");
			} else {
				//valida Sexo
				String regex = "[FM]{1}";
				Pattern patron = Pattern.compile(regex);
				 if (!patron.matcher(usuario.getSexo()).matches()) {
				    	sexoValido = false;
				    }
				        sexoValido = true;
			}
			if (sexoValido.equals(false)) {
				throw new ExcepcionesCuadrillas("SEXO NO VALIDO.");
			}
			//se trae dato para comparar fecha nac
			listaUsuario = new ConsultasCuadrillasDAO().consultaUsuario(uid, usuario);
			 for (int i = 0; i < listaUsuario.size(); i++) {
				 //se cobtiene el valor del parametro para conpararlo con la fecha
				 parametroComp = new Parametros();
				 parametroComp.setParametro("usuario.edad.ano.minimo");
				 List<Parametros> listaParametros = new ParametrosNegocio().consultaParametro(parametroComp);
				 for (int j = 0; j < listaParametros.size(); j++) {
					int valorParametro = Integer.parseInt(listaParametros.get(j).getValor());
					String anoCalendario = "YYYY";
					SimpleDateFormat dateFormat = new SimpleDateFormat(anoCalendario);
					int anoObtenido = Integer.parseInt(dateFormat.format(listaUsuario.get(i).getFecha_nacimiento()));
					//se inicia comparacion entre año y valor del parametro
					if (anoObtenido < valorParametro) {
						throw new ExcepcionesCuadrillas("El año es menor del permitido.");
					}
				 }
			 }
			 //se incia con la obtencion del perfil
			 perfilUsuario = new Perfil();
			 perfilUsuario.setIdPerfil(usuario.getId_perfil());
			 listaPerfil = new ConsultasCuadrillasDAO().consultaPerfil(uid, perfilUsuario);
			 for (int k = 0; k < listaPerfil.size(); k++) {
				 int idPerfil = listaPerfil.get(k).getIdPerfil();
				 if (idPerfil <= 0) {
					 throw new ExcepcionesCuadrillas("no existe el perfil");
				 }
			 }

			// se inicia con el calculo del RFC
				RFCUtil calcularRFC = new RFCUtil();
				String rfcCalculado  = calcularRFC.calcularRFCPersonaFisica(usuario.getNombre(),usuario.getApellido_pat(),usuario.getApellido_mat(),usuario.getFecha_nacimiento());
				//Se le asigna el rfc calculado al campo rfc_calculado de usuarios
				usuario.setRfc_calculado(rfcCalculado);
				OperacionesCuadrillasDAO dao = new OperacionesCuadrillasDAO();
				respuesta = dao.altaUsuario(uid, usuario);
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "altaUsuario - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "registraNegocio - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "registraNegocio - Daton Salida: " + respuesta);
		return respuesta;
	}
	/**
	 * metodo para dar de baja un usuario
	 * @param usuario recibe valores de usuario
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta bajaUsuario(Usuario usuario) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(usuario);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraSitio - Daton Entrada: " + usuario);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		List<Usuario> listaUsuario = null;
		try {
			//Validaciones Negocio
			listaUsuario = new ConsultasCuadrillasDAO().consultaUsuario(uid, usuario);
			 for (int i = 0; i < listaUsuario.size(); i++) {
              if (listaUsuario.get(i).getUsuario().equals(usuario.getUsuario())) {
            	  if (listaUsuario.get(i).getEstatus().equals("A")) {
            		//Mandamos a la parte del dao
                	  OperacionesCuadrillasDAO dao = new OperacionesCuadrillasDAO();
          			  respuesta = dao.bajaUsuario(uid, usuario);
            	  } else {
            		  throw new ExcepcionesCuadrillas("El usuario ya se encuentra inactivo.");
            	  }
				 } else if (listaUsuario.get(i).getUsuario() == null || listaUsuario.get(i).getUsuario().isEmpty()) {
					 throw new ExcepcionesCuadrillas("No existe el usuario.");
				 }
			 }
		}
		catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaUsuario - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaUsuario - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaUsuario - Datos Salida: " + respuesta);
		return respuesta;
}
}
