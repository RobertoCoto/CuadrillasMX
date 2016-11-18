package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.fyg.cuadrillas.dto.usuario.UsuarioDTO;

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
		datosUsuario.setUsuario("Gomez22");
		datosUsuario.setContrasena("12345678");
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testLoginUsuario()  throws Exception{
		String guid = uid.generateGUID(loginUser);
		try {
			loginUser.loginUsuario(datosUsuario);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
