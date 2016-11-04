package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.OperacionesCuadrillasNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Catalogos;
public class EliminaCatalogoTest {
	/**
	 * Objeto operaciones
	 */
	private OperacionesCuadrillasNegocio eliminarCatalogo;
	/**
	 * objeto catalogo
	 */
	private Catalogos datoCatalogos;
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
		eliminarCatalogo = new OperacionesCuadrillasNegocio();
		datoCatalogos = new Catalogos();
		datoCatalogos.setCodigo("CABO");
		datoCatalogos.setEstatus("I");
	}
	/**
	 * Metodo test que le envia datos
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testEliminaCatalogo() throws Exception {
		String guid = uid.generateGUID(eliminarCatalogo);
		try {
			eliminarCatalogo.eliminaCatalogo(datoCatalogos);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
