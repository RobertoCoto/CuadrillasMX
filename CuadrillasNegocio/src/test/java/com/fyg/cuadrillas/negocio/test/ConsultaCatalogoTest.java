package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.CatalogoNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.catalogo.CatalogoDTO;
public class ConsultaCatalogoTest {
/**
* objeto para enviar al metodo consulta de catalogo
*/
private CatalogoNegocio catalogoConsulta;
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
		catalogoConsulta = new CatalogoNegocio();
		datoCatalogos = new CatalogoDTO();
		datoCatalogos.setTipoCatalogo("VIALIDAD");
	}
	/**
	 * Metodo test que le envia datos
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaTipoCatalogo() throws Exception {
		String guid = uid.generateGUID(catalogoConsulta);
		LogHandler.debug(guid, this.getClass(), "prueba");

		try {
			catalogoConsulta.consultarCatalogo(datoCatalogos);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), ex.getMessage());
			System.out.println(ex.getMessage());
		}
	}

}
