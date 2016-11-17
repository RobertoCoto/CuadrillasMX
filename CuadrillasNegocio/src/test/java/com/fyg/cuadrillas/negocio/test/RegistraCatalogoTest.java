package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.CatalogoNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.catalogo.CatalogoDTO;
public class RegistraCatalogoTest {
	/**
	 * Objeto operaciones
	 */
	private CatalogoNegocio registrarCatalogo;
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
		registrarCatalogo = new CatalogoNegocio();
		datoCatalogos = new CatalogoDTO();
		/**
		 * se le envia datos
		 */
		datoCatalogos.setTipoCatalogo("PERFIL_EMP");
		datoCatalogos.setCodigo("AUX");
		datoCatalogos.setDescripcion("Auxiliar");
		datoCatalogos.setEstatus("A");
	}
	/**
	 * Metodo test que le envia datos
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testRegistraCatalogo() throws Exception {
		String guid = uid.generateGUID(datoCatalogos);
		try {
			registrarCatalogo.registraCatalogo(datoCatalogos);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
