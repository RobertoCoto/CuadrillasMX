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
		datoCatalogos.setTipoCatalogo("VIALIDAD");;
		
	}
	/**
	 * Metodo test que le envia datos
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaTipoCatalogo() throws Exception {
		
		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");
        
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
