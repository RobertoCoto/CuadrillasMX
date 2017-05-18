package com.fyg.cuadrillas.negocio.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.HerramientaNegocio;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.herramienta.HerramientaDTO;
public class AltaHerramientaTest {
	/**
	* objeto para enviar al metodo consulta de catalogo
	*/
	private HerramientaNegocio altaHerramientas;
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
		altaHerramientas = new HerramientaNegocio();
		datoHerramientas = new HerramientaDTO();
		datoHerramientas.setNombre("HErramienta para uso rudo");
		datoHerramientas.setDescripcion("PRUEBA HERRAMIENTA");
		datoHerramientas.setCodigoTipo("NUEV");
		datoHerramientas.setCodigoEstatus("DANA");
		datoHerramientas.setMarca("Marca Buena");
		datoHerramientas.setModelo("Sin Modelo");
		datoHerramientas.setNoSerie("Xd2lidodl-2330-djkdkdk");
		datoHerramientas.setUsuarioAlta("mario");
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
			EncabezadoRespuesta respuesta = altaHerramientas.registrarHerramienta(datoHerramientas);
			LogHandler.debug(guid, this.getClass(), "Resultado " + respuesta);

			datoHerramientas.setIdHerramienta(1);
			datoHerramientas.setNombre("HErramienta para uso rudo actualizado");
			EncabezadoRespuesta respuesta2 = altaHerramientas.actualizaHerramienta(datoHerramientas);
			LogHandler.debug(guid, this.getClass(), "Resultado " + respuesta2);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
