package com.fyg.cuadrillas.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.comun.RFCUtil;
import com.fyg.cuadrillas.comun.Encriptacion;
import com.fyg.cuadrillas.dao.PerfilDAO;
import com.fyg.cuadrillas.dao.UsuarioDAO;
import com.fyg.cuadrillas.dto.PerfilDTO;
import com.fyg.cuadrillas.dto.menu.MenuRespuesta;
import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;
import com.fyg.cuadrillas.dto.usuario.UsuarioRespuesta;

public class UsuariosNegocio {
	/** The LONGITUD_RFC. */
	private static final  int LONGITUD_PSSWD = 8;

	/**
		 * Metodo para dar de alta un usuario
		 * @param usuario Recibe valores de usuario
		 * @return regresa la respuesta si fue registrado
		 */
		public EncabezadoRespuesta altaUsuario(UsuarioDTO usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "altaUsuario - Datos Entrada: " + usuario);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			//Para perfiles
			List<PerfilDTO> listaPerfil = null;
			try {
				//Validaciones de campos.
				if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
					throw new ExcepcionesCuadrillas("Es necesario especificar un usuario.");
				}
				 //se incia con la obtencion del perfil
				 PerfilDTO perfilUsuario = new PerfilDTO();
				 perfilUsuario.setIdPerfil(usuario.getIdPerfil());
				 listaPerfil = new PerfilDAO().consultaPerfil(uid, perfilUsuario);
				 for (int k = 0; k < listaPerfil.size(); k++) {
					 int idPerfil = listaPerfil.get(k).getIdPerfil();
					 if (idPerfil <= 0) {
						 throw new ExcepcionesCuadrillas("no existe el perfil");
					 }
				 }
				 SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			     String strFecha = usuario.getFechaNacimiento();
			     Date fechaDate = formato.parse(strFecha);

				//RFC Calculado
					String rfcCalculado  = RFCUtil.calcularRFCPersonaFisica(usuario.getNombre(),
								usuario.getApellidoPat(),
								usuario.getApellidoMat(),
								fechaDate);
					//Se le asigna el rfc calculado al campo rfc_calculado de usuarios
					usuario.setRfcCalculado(rfcCalculado);
				//encriptacion de contraseña
				String encriptaContrasena = Encriptacion.obtenerEncriptacionSHA256(usuario.getContrasena());
				//Se le asigna la contrasena encriptada
				usuario.setContrasena(encriptaContrasena);

				//se le envian los datos al DAO
					UsuarioDAO dao = new UsuarioDAO();
					respuesta = dao.altaUsuario(uid, usuario);
			} catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "altaUsuario - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			catch  (Exception ex) {
				LogHandler.error(uid, this.getClass(), "altaUsuario- Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			LogHandler.debug(uid, this.getClass(), "altaUsuario - Daton Salida: " + respuesta);
			return respuesta;
		}
		/**
		 * metodo para dar de baja un usuario
		 * @param usuario recibe valores de usuario
		 * @return regresa una respuesta
		 */
		public EncabezadoRespuesta bajaUsuario(UsuarioDTO usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "registraSitio - Daton Entrada: " + usuario);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			List<UsuarioDTO> listaUsuario = null;
			try {
				//Validaciones Negocio
				listaUsuario = new UsuarioDAO().consultaUsuario(uid, usuario);
				 for (int i = 0; i < listaUsuario.size(); i++) {
	              if (listaUsuario.get(i).getUsuario().equals(usuario.getUsuario())) {
	            	  if (listaUsuario.get(i).getEstatus().equals("A")) {
	            		//Mandamos a la parte del dao
	            		  UsuarioDAO dao = new UsuarioDAO();
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
	/**
	 * Metodo para realizar login de usuario
	 * @param usuario recibe valores del usuario
	 * @return retorna los datos del usuario
	 */
		public UsuarioRespuesta loginUsuario(UsuarioDTO usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "loginUsuario - Datos Entrada: " + usuario);
			//Variable de resultado
			UsuarioRespuesta respuesta = new UsuarioRespuesta();
			respuesta.setHeader( new EncabezadoRespuesta());
			respuesta.getHeader().setUid(uid);
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
			UsuarioDTO loginUsuario = null;
		    try {
		    	//validaciones de los campos
		    	if (usuario.getUsuario() == null || usuario.getUsuario().trim().isEmpty()) {
		    		throw new ExcepcionesCuadrillas("Es necesario el usuario.");
		    	}
		    	if (usuario.getContrasena() == null || usuario.getContrasena().trim().isEmpty()) {
		    		throw new ExcepcionesCuadrillas("Es necesaria la contraseña.");
		    	}
		    	String encriptaPass = Encriptacion.obtenerEncriptacionSHA256(usuario.getContrasena());
		    	//se le asigna para iniciar sesion
		    	usuario.setContrasena(encriptaPass);
		    	loginUsuario = new UsuarioDAO().loginUsuario(uid, usuario);

		    	if (!loginUsuario.getEstatus().equals("A")) {
		    		throw new ExcepcionesCuadrillas("El usuario esta inactivo.");
		    	}

		    	final MenuNegocio menu = new MenuNegocio();
		    	MenuRespuesta respuestaMenu = menu.consultarMenuIdPerfil(uid, loginUsuario.getIdPerfil());
		    	if (!respuestaMenu.getHeader().isEstatus()) {
		    		throw new ExcepcionesCuadrillas("No fue posible cargar el menu del perfil solicitado.");
		    	}
		    	ParametroNegocio datoParametro = new ParametroNegocio();
		    	String idPerfilResidente = datoParametro.consultaParametro(uid, "perfil.residente");

		    	if (!idPerfilResidente.trim().equals(loginUsuario.getIdPerfil().toString())) {
		    		loginUsuario.setIdCuadrilla(0);
		    		LogHandler.debug(uid, this.getClass(), "Usuario No Residente");

		    	} else {
		    		LogHandler.debug(uid, this.getClass(), "Usuario  Residente idCuadrilla=" + loginUsuario.getIdCuadrilla());
		    	}

		    	loginUsuario.setNombrePerfil(loginUsuario.getNombrePerfil().toUpperCase());
		    	respuesta.setUsuario(loginUsuario);
		    	respuesta.setMenu(respuestaMenu.getMenu());
		    } catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "loginUsuario - Error: " + ex.getMessage(), ex);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "loginUsuario - Error: " + ex.getMessage(), ex);
		    	respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "loginUsuario - Datos Salida: " + respuesta);
		    return respuesta;
		}
		/**
		 * Metodo para modificar la contraseña
		 * @param usuario recibe el valor del usuario
		 * @return regresa respuesta
		 */
		public EncabezadoRespuesta modificaContrasena(UsuarioDTO usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "modificaContrasena - Datos Entrada: " + usuario);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();

			try {
				if (usuario.getContrasenaAnterior() == null || usuario.getContrasenaAnterior().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo esta vacio, favor de ingresar la contraseña anterior.");
				}
				if (usuario.getContrasenaNueva() == null || usuario.getContrasenaNueva().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo esta vacio, favor de ingresar la contraseña nueva.");
				}
				if (usuario.getRepetirContrasenaNueva() == null || usuario.getRepetirContrasenaNueva().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo esta vacio, favor de repetir la nueva contraseña.");
				}
				if (usuario.getContrasenaNueva().trim().length() < LONGITUD_PSSWD) {
					throw new ExcepcionesCuadrillas("La contraseña nueva debe tener minimo " + LONGITUD_PSSWD + " caracteres.");
				}
				if (usuario.getRepetirContrasenaNueva().trim().length() < LONGITUD_PSSWD) {
					throw new ExcepcionesCuadrillas("La contraseña debe tener minimo " + LONGITUD_PSSWD + " caracteres.");
				}
				if (usuario.getRepetirContrasenaNueva().equals(usuario.getContrasenaNueva())) {
					//encriptacion de contraseña
					String contrasenaNueva = Encriptacion.obtenerEncriptacionSHA256(usuario.getContrasenaNueva());
					usuario.setContrasenaNueva(contrasenaNueva);
				} else {
					throw new ExcepcionesCuadrillas("No coincide la nueva contraseña, intente de nuevo.");
				}
				if (usuario.getContrasenaNueva().equals(usuario.getContrasena())) {
					throw new ExcepcionesCuadrillas("No se permite utilizar la misma contraseña anterior.");
				}
				//Se encripta la contraseña anterior
				String encriptaContrasena = Encriptacion.obtenerEncriptacionSHA256(usuario.getContrasenaAnterior());
				//Se le asigna la contrasena encriptada
				usuario.setContrasenaAnterior(encriptaContrasena);
				//se envia al dao
				UsuarioDAO dao = new UsuarioDAO();
				respuesta = dao.modificaContrasena(uid, usuario);

			} catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "modificaContrasena - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			catch  (Exception ex) {
				LogHandler.error(uid, this.getClass(), "modificaContrasena - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			LogHandler.debug(uid, this.getClass(), "modificaContrasena - Datos Salida: " + respuesta);
			return respuesta;

		}

		/**
		 * Metodo para recuperar la contraseña
		 * @param usuario recibe el valor del usuario
		 * @return regresa respuesta
		 */
		public EncabezadoRespuesta recuperaContrasena(UsuarioDTO usuario) {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(usuario);
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "recuperaContrasena - Datos Entrada: " + usuario);
			//Variable de resultado
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();

			try {
				if (usuario.getContrasenaNueva() == null || usuario.getContrasenaNueva().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo esta vacio, favor de ingresar la contraseña nueva.");
				}
				if (usuario.getRepetirContrasenaNueva() == null || usuario.getRepetirContrasenaNueva().trim().isEmpty()) {
					throw new ExcepcionesCuadrillas("El campo esta vacio, favor de repetir la nueva contraseña.");
				}
				if (usuario.getRepetirContrasenaNueva().equals(usuario.getContrasenaNueva())) {
					//encriptacion de contraseña
					String contrasenaNueva = Encriptacion.obtenerEncriptacionSHA256(usuario.getContrasenaNueva());
					usuario.setContrasenaNueva(contrasenaNueva);
				} else {
					throw new ExcepcionesCuadrillas("No coincide la nueva contraseña, intente de nuevo.");
				}
				if (usuario.getContrasenaNueva().trim().length() < LONGITUD_PSSWD) {
					throw new ExcepcionesCuadrillas("La contraseña nueva debe tener minimo " + LONGITUD_PSSWD + " caracteres.");
				}
				if (usuario.getRepetirContrasenaNueva().trim().length() < LONGITUD_PSSWD) {
					throw new ExcepcionesCuadrillas("La contraseña debe tener minimo " + LONGITUD_PSSWD + " caracteres.");
				}
				//se envia al dao
				UsuarioDAO dao = new UsuarioDAO();
				respuesta = dao.recuperaContrasena(uid, usuario);

			} catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "recuperaContrasena - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			catch  (Exception ex) {
				LogHandler.error(uid, this.getClass(), "recuperaContrasena - Error: " + ex.getMessage(), ex);
				respuesta.setUid(uid);
				respuesta.setEstatus(false);
				respuesta.setMensajeFuncional(ex.getMessage());
				respuesta.setMensajeTecnico(ex.getMessage());
			}
			LogHandler.debug(uid, this.getClass(), "recuperaContrasena - Datos Salida: " + respuesta);
			return respuesta;

		}

		/**
		 * Metodo para consultar todos los usuarios
		 * @return regresa lista de usuarios
		 */
		public UsuarioRespuesta consultaListaUsuario() {
			//Primero generamos el identificador unico de la transaccion
			String uid = GUIDGenerator.generateGUID(new String(""));
			//Mandamos a log el objeto de entrada
			LogHandler.debug(uid, this.getClass(), "consultaListaUsuario - Daton Entrada: ");
			//Variable de resultado
			UsuarioRespuesta respuesta = new UsuarioRespuesta();
			respuesta.setHeader( new EncabezadoRespuesta());
			respuesta.getHeader().setUid(uid);
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
			List<UsuarioDTO> listaUsuario = null;
			try {
				listaUsuario = new UsuarioDAO().consultaListaUsuario(uid);
				respuesta.setLista(listaUsuario);
			} catch  (ExcepcionesCuadrillas ex) {
				LogHandler.error(uid, this.getClass(), "consultaListaUsuario - Error: " + ex.getMessage(), ex);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			} catch (Exception ex) {
		    	LogHandler.error(uid, this.getClass(), "consultaListaUsuario - Error: " + ex.getMessage(), ex);
		    	respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensajeFuncional(ex.getMessage());
				respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		    }
		    LogHandler.debug(uid, this.getClass(), "consultaListaUsuario - Datos Salida: " + respuesta);
			return respuesta;
		}
		/**
		 * Metodo para realizar login de usuario WS
		 * @param usuario recibe valores del usuario
		 * @return retorna los datos del usuario
		 */
			public UsuarioRespuesta loginUsuarioWS(UsuarioDTO usuario) {
				//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(usuario);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "loginUsuarioWS - Datos Entrada: " + usuario);
				//Variable de resultado
				UsuarioRespuesta respuesta = new UsuarioRespuesta();
				respuesta.setHeader( new EncabezadoRespuesta());
				respuesta.getHeader().setUid(uid);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
				UsuarioDTO loginUsuario = null;
			    try {
			    	//validaciones de los campos
			    	if (usuario.getUsuario() == null || usuario.getUsuario().trim().isEmpty()) {
			    		throw new ExcepcionesCuadrillas("Es necesario el usuario.");
			    	}
			    	if (usuario.getContrasena() == null || usuario.getContrasena().trim().isEmpty()) {
			    		throw new ExcepcionesCuadrillas("Es necesaria la contraseña.");
			    	}
			    	String encriptaPass = Encriptacion.obtenerEncriptacionSHA256(usuario.getContrasena());
			    	//se le asigna para iniciar sesion
			    	usuario.setContrasena(encriptaPass);
			    	loginUsuario = new UsuarioDAO().loginUsuarioWS(uid, usuario);

			    	if (!loginUsuario.getEstatus().equals("A")) {
			    		throw new ExcepcionesCuadrillas("El usuario esta inactivo.");
			    	}
			    	ParametroNegocio datoParametro = new ParametroNegocio();
			    	String idPerfilResidente = datoParametro.consultaParametro(uid, "perfil.residente");

			    	if (!idPerfilResidente.trim().equals(loginUsuario.getIdPerfil().toString())) {
			    		loginUsuario.setIdCuadrilla(0);
			    		LogHandler.debug(uid, this.getClass(), "Usuario No Residente");

			    	} else {
			    		LogHandler.debug(uid, this.getClass(), "Usuario  Residente idCuadrilla=" + loginUsuario.getIdCuadrilla());
			    	}

			    	loginUsuario.setNombrePerfil(loginUsuario.getNombrePerfil().toUpperCase());
			    	respuesta.setUsuario(loginUsuario);
			    } catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "loginUsuario - Error: " + ex.getMessage(), ex);
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
				} catch (Exception ex) {
			    	LogHandler.error(uid, this.getClass(), "loginUsuario - Error: " + ex.getMessage(), ex);
			    	respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensajeFuncional(ex.getMessage());
					respuesta.getHeader().setMensajeTecnico(ex.getMessage());
			    }
			    LogHandler.debug(uid, this.getClass(), "loginUsuario - Datos Salida: " + respuesta);
			    return respuesta;
			}
}
