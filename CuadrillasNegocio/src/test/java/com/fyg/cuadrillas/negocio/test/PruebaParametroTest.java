package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.ParametrosNegocio;
import com.fyg.cuadrillas.dto.Parametros;

public class PruebaParametroTest {
	private ParametrosNegocio datoParametro;
	private Parametros buscaParametro;
	
	/**
	 * SetUp
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
    datoParametro = new ParametrosNegocio();
	buscaParametro = new Parametros();
	buscaParametro.setParametro("usuario.edad.ano.minimo");
	}
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaNegocio()throws Exception {
		try {
			datoParametro.consultaParametro(buscaParametro);
		}
		catch (Exception ex) {
		}
	}
}
