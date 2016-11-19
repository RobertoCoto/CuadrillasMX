package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.ParametroNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.ParametroDTO;

public class PruebaParametroTest {
	/**
	 * Objeto parametroNegocio
	 */
	private ParametroNegocio datoParametro;
	/**
	 * Objeto para recibir valores del parametro
	 */
	private String buscaParametro;
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
		datoParametro = new ParametroNegocio();
		buscaParametro = "usuario.edad.ano.minimo";
	}
	/**
	 * Metodo test que le envia datos al parametro
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaNegocio()throws Exception {

		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");

		String guid = uid.generateGUID(datoParametro);
		try {
			//datoParametro.consultaParametro(guid, buscaParametro);
			datoParametro.consultaParametro(guid, "sueldo.puesto.maximo");
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), ex.getMessage());
		}
	}
}
