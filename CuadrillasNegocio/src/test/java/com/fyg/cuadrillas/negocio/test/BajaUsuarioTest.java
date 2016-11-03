package com.fyg.cuadrillas.negocio.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.negocio.OperacionesCuadrillasNegocio;
import com.fyg.cuadrillas.dto.Usuario;

public class BajaUsuarioTest {
	/**
	 * objeto OperacionesCuadrillas
	 */
 private OperacionesCuadrillasNegocio bajaUsuario;
 /**
  * Objeto datos usuario
  */
 private Usuario datosUsuario;
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
		bajaUsuario = new OperacionesCuadrillasNegocio();
		datosUsuario = new Usuario();
		Date fechaMod = new Date();
		datosUsuario.setEstatus("I");
		datosUsuario.setFecha_ult_mod(fechaMod);
		datosUsuario.setUsuario("gomez22");
	}
	/**
	 * Manda los valores al metodo de baja usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaNegocio()throws Exception {
		String guid = uid.generateGUID(bajaUsuario);
		try {
			bajaUsuario.bajaUsuario(datosUsuario);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
}
