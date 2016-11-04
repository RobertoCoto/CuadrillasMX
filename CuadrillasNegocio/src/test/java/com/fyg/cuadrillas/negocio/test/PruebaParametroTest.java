package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.ParametrosNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Parametros;

public class PruebaParametroTest {
	/**
	 * Objeto parametroNegocio
	 */
	private ParametrosNegocio datoParametro;
	/**
	 * Objeto para recibir valores del parametro
	 */
	private Parametros buscaParametro;
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
    datoParametro = new ParametrosNegocio();
	buscaParametro = new Parametros();
	buscaParametro.setParametro("usuario.edad.ano.minimo");
	}
	/**
	 * Metodo test que le envia datos al parametro
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaNegocio()throws Exception {
		String guid = uid.generateGUID(datoParametro);
		try {
			datoParametro.consultaParametro(buscaParametro);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
}
