package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.fyg.cuadrillas.dto.UsuarioDTO;

public class AltaUsuarioTest {
	/**
	 * objeto OperacionesCuadrillas
	 */
 private UsuariosNegocio altaUser;
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
		altaUser = new UsuariosNegocio();
		datosUsuario = new UsuarioDTO();
		datosUsuario.setUsuario("ma.gonzales");
		datosUsuario.setIdPerfil(1);
		datosUsuario.setContrasena("gonzales22gb");
		datosUsuario.setCambioContrasena("N");
		datosUsuario.setEstatus("A");
	}

	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAltaUsuario() {
		String guid = uid.generateGUID(altaUser);
		try {
			altaUser.altaUsuario(datosUsuario);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
