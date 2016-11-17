package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.HerramientaNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.HerramientaDTO;
public class ConsultaHerramientasTest {
	/**
	* objeto para enviar al metodo consulta de catalogo
	*/
	private HerramientaNegocio consultaHerramienta;
	/**
	 * Recibe datos de herramientas
	 */
	private HerramientaDTO datoHerramientas;
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
		consultaHerramienta = new HerramientaNegocio();
		datoHerramientas = new HerramientaDTO();
		datoHerramientas.setOrden("D");
		datoHerramientas.setEstatus("A");
	}
	/**
	 * Metodo test que le envia datos
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultarHerramientas() {
		String guid = uid.generateGUID(consultaHerramienta);
		try {
			consultaHerramienta.consultarHerramientas(datoHerramientas);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
