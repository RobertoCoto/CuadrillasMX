package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;
import com.fyg.cuadrillas.dto.usuario.UsuarioRespuesta;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;

public class LoginUsuarioTest {
	/**
	 * objeto Usuario negocio
	 */
	 private UsuariosNegocio loginUser;
	/**
	  * Objeto datos usuario
	  */
	 private UsuarioDTO datosUsuario;
	 /**
	  * Guid unico generado
	  */
		private GUIDGenerator uid;
		/**
		 * SetUp
		 * @throws Exception
		 */

	@Before
	public void setUp() throws Exception {
		loginUser = new UsuariosNegocio();
		datosUsuario = new UsuarioDTO();
		datosUsuario.setUsuario("mimejorada");
		datosUsuario.setContrasena("mimejorada");
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testLoginUsuario()  throws Exception {
		String guid = uid.generateGUID(loginUser);
		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");
		try {
			UsuarioRespuesta respuesta = loginUser.loginUsuario(datosUsuario);
			System.out.println(respuesta);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
