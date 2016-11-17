package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.HerramientaNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Herramienta;

public class EliminaHerramientasTest {
	/**
	* objeto para enviar al metodo consulta de catalogo
	*/
	private HerramientaNegocio eliminaHerramienta;
	/**
	 * Recibe datos de herramientas
	 */
	private Herramienta datoHerramientas;
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
		eliminaHerramienta = new HerramientaNegocio();
		datoHerramientas = new Herramienta();
		datoHerramientas.setOrden("D");
		datoHerramientas.setEstatus("A");
	}
	/**
	 * Metodo test que le envia datos
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testEliminaHerramientas() throws Exception {
		String guid = uid.generateGUID(eliminaHerramienta);
		try {
			eliminaHerramienta.consultarHerramientas(datoHerramientas);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
