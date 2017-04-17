package com.fyg.cuadrillas.comun.test;

import org.junit.Test;

import com.fyg.cuadrillas.comun.GeneradorUsuario;

public class UsuarioTest {
	/**
	 * se configura test
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		try {
			GeneradorUsuario user = new GeneradorUsuario();

			String usuario = user.generaUsuario("ROBERTO", "COTO");
			System.out.println(usuario);

		} catch (Exception ex) {
			System.out.println("Error");
		}
	}

}
