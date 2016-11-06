package com.fyg.cuadrillas.negocio.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.OperacionesCuadrillasNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Herramientas;
public class AltaHerramientaTest {
	/**
	* objeto para enviar al metodo consulta de catalogo
	*/
	private OperacionesCuadrillasNegocio altaHerramientas;
	/**
	 * Recibe datos de herramientas
	 */
	private Herramientas datoHerramientas;
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
		altaHerramientas = new OperacionesCuadrillasNegocio();
		datoHerramientas = new Herramientas();
		
		Date fecha = new Date();
		datoHerramientas.setNombre("ABUS");
		datoHerramientas.setDescripcion("PRUEBA HERRAMIENTA");
		datoHerramientas.setEstatus("A");
		datoHerramientas.setMantenimiento("PRUEBA");
		datoHerramientas.setCodigo_tipo_combustible("DISE");
		datoHerramientas.setCodigo_tipo_articulo("NUEV");
		datoHerramientas.setCodigo_estado("BUEN");
		datoHerramientas.setFecha_alta(fecha);
		datoHerramientas.setFecha_ingreso(fecha);
		datoHerramientas.setFecha_ult_mod(fecha);
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
