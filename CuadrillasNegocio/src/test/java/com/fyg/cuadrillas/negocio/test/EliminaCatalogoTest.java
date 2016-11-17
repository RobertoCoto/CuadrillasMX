package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.CatalogoNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.catalogo.CatalogoDTO;
public class EliminaCatalogoTest {
	/**
	 * Objeto operaciones
	 */
	private CatalogoNegocio eliminarCatalogo;
	/**
	 * objeto catalogo
	 */
	private CatalogoDTO datoCatalogos;
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
		eliminarCatalogo = new CatalogoNegocio();
		datoCatalogos = new CatalogoDTO();
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
