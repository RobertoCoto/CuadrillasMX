package com.fyg.cuadrillas.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.dto.PruebaDTO;
import com.fyg.cuadrillas.dao.OperacionesCuadrillasDAO;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
public class TestConexion {
    /**
     * objeto cuadrillas
     */
	private OperacionesCuadrillasDAO datoPrueba;
	/**
	 * objeto pruebaDTO
	 */
	private PruebaDTO pruebas;
	/**
	 * GUID unico generado
	 */
	private GUIDGenerator uid;
	/**
	 * Metodo para hacer prueba
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		 datoPrueba = new OperacionesCuadrillasDAO();
		 /**
		  * se le envian los datos a actividad
		  */
		pruebas = new PruebaDTO();
		pruebas.setUsuario("HUSKY");
		pruebas.setContrasena("123456");
		pruebas.setMensaje("mensaje de apoyo shabo");
	}
	/**
	 * Metodo que envia los datos test
	 * @throws Exception
	 */
	@Test
	@SuppressWarnings("static-access")
	public void testRegistraActividad() throws Exception {

		String guid = uid.generateGUID(datoPrueba);
		try {
			datoPrueba.registraPrueba(guid, pruebas);
			LogHandler.info(guid, this.getClass(), "PRUEBA JUNIT");
		}
		catch (Exception ex) {
			LogHandler.info(guid, this.getClass(), "Error");
		}
	}

}
