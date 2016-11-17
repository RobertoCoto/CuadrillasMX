package com.fyg.cuadrillas.negocio.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.HerramientaNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Herramienta;
public class AltaHerramientaTest {
	/**
	* objeto para enviar al metodo consulta de catalogo
	*/
	private HerramientaNegocio altaHerramientas;
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
		altaHerramientas = new HerramientaNegocio();
		datoHerramientas = new Herramienta();
		
		Date fecha = new Date();
		datoHerramientas.setNombre("ABUS");
		datoHerramientas.setDescripcion("PRUEBA HERRAMIENTA");
		datoHerramientas.setEstatus("A");
		datoHerramientas.setMantenimiento("PRUEBA");
		datoHerramientas.setCodigoTipoCombustible("DISE");
		datoHerramientas.setCodigoTipoArticulo("NUEV");
		datoHerramientas.setCodigoEstado("BUEN");
		datoHerramientas.setFechaAlta(fecha);
		datoHerramientas.setFechaIngreso(fecha);
		datoHerramientas.setFechaUltMod(fecha);
		datoHerramientas.setEstatus("A");
	}
	/**
	 * manda datos a los metodos de registrar
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test() throws Exception {
		String guid = uid.generateGUID(altaHerramientas);
		try {
			altaHerramientas.registraHerramientas(datoHerramientas);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
