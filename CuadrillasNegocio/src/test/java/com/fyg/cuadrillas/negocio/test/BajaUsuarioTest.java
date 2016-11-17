package com.fyg.cuadrillas.negocio.test;


import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.fyg.cuadrillas.dto.UsuarioDTO;

public class BajaUsuarioTest {
	/**
	 * objeto OperacionesCuadrillas
	 */
 private UsuariosNegocio bajaUsuario;
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
		bajaUsuario = new UsuariosNegocio();
		datosUsuario = new UsuarioDTO();
		datosUsuario.setEstatus("I");
		datosUsuario.setUsuario("gomez22");
	}
	/**
	 * Manda los valores al metodo de baja usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testBajaUsuario()throws Exception {
		String guid = uid.generateGUID(bajaUsuario);
		try {
			bajaUsuario.bajaUsuario(datosUsuario);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
}
