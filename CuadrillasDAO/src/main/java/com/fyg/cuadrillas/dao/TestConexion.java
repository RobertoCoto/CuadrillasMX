package com.fyg.cuadrillas.dao;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.dto.PruebaDTO;
import com.fyg.cuadrillas.dao.OperacionesCuadrillasDAO;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
public class TestConexion {

	private OperacionesCuadrillasDAO datoPrueba;
	private PruebaDTO pruebas;
	private GUIDGenerator uid;
	@Before
	public void setUp() throws Exception {
		 datoPrueba = new OperacionesCuadrillasDAO();
		 
		 /**
		  * se le envian los datos a actividad
		  */
		pruebas = new PruebaDTO();
		pruebas.setUsuario("HUSKY");
		pruebas.setContraseña("123456");
		pruebas.setMensaje("mensaje de apoyo shabo");
	}
	
	@Test
	@SuppressWarnings("static-access")
	public void testRegistraActividad() throws Exception {
		
		String guid = uid.generateGUID(datoPrueba);
		try {
			datoPrueba.registraPrueba(guid, pruebas);
			LogHandler.info(guid,this.getClass(), "PRUEBA JUNIT");
		}
		catch (Exception ex) {
			LogHandler.info(guid,this.getClass(), "Error");
		}
	}

}
