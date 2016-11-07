package com.fyg.cuadrillas.negocio.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.CatalogosNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Catalogos;
public class RegistraCatalogoTest {
	/**
	 * Objeto operaciones
	 */
	private CatalogosNegocio registrarCatalogo;
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
		registrarCatalogo = new CatalogosNegocio();
		datoCatalogos = new Catalogos();
		/**
		 * se le envia datos
		 */
		Date fecha = new Date();
		datoCatalogos.setTipo_catalogo("PERFIL_EMP");
		datoCatalogos.setCodigo("AUX");
		datoCatalogos.setDescripcion("Auxiliar");
		datoCatalogos.setFecha_alta(fecha);
		datoCatalogos.setFecha_ult_mod(fecha);
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
