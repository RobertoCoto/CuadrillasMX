package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.negocio.CatalogosNegocio;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Catalogos;
public class ConsultaCatalogoTest {
/**
* objeto para enviar al metodo consulta de catalogo
*/
private CatalogosNegocio catalogoConsulta;
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
		catalogoConsulta = new CatalogosNegocio();
		datoCatalogos = new Catalogos();
		datoCatalogos.setOrden("D");
		datoCatalogos.setEstatus("A");
	}
	/**
	 * Metodo test que le envia datos
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaTipoCatalogo() throws Exception {
		String guid = uid.generateGUID(catalogoConsulta);
		try {
			catalogoConsulta.consultarCatalogo(datoCatalogos);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
