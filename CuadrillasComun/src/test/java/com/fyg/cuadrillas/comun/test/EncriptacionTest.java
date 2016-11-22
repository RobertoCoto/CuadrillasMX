package com.fyg.cuadrillas.comun.test;


import org.junit.Test;

import com.fyg.cuadrillas.comun.Encriptacion;

public class EncriptacionTest {

	@Test
	public void test() throws Exception {
		try {
			Encriptacion.obtenerEncriptacionSHA256("cuadrillas");
			
		} catch (Exception ex) {
			System.out.println("Error");
		}
	}

}
