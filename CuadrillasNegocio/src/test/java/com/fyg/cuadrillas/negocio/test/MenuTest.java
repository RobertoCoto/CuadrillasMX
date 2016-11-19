package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.menu.MenuDTO;
import com.fyg.cuadrillas.negocio.MenuNegocio;

public class MenuTest {
	/**
	 * objeto de menu negocio
	 */
private MenuNegocio menuDatos;
/**
 * Datos menu
 */
private MenuDTO menu;
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
	menuDatos = new MenuNegocio();	
}
/**
 * Manda los valores al metodo 
 * @throws Exception
 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultarMenu() {
		String guid = uid.generateGUID(menuDatos);
		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");
		try {
			menuDatos.consultarMenuIdPerfil(guid, 1);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}

	}

}
