package com.fyg.cuadrillas.dao;



import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.dto.PruebaDTO;
import com.fyg.cuadrillas.dao.ConsultasCuadrillasDAO;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
public class TestConsulta {
  private ConsultasCuadrillasDAO datoPruebas;
    private PruebaDTO pruebas;
	private GUIDGenerator uid;
	
	@Before
	public void setUp() throws Exception {
		datoPruebas = new ConsultasCuadrillasDAO();
		
		pruebas  = new PruebaDTO();
		pruebas.setIdPrueba(1);
	}

	@Test
	@SuppressWarnings("static-access")
	public void testConsultaPrueba() throws Exception {
		
		String guid = uid.generateGUID(datoPruebas);
		try {
			datoPruebas.consultaPrueba(guid, pruebas);
			LogHandler.info(guid,this.getClass(), "PRUEBA  CONSULTA JUNIT");
		}
		catch (Exception ex) {
			LogHandler.info(guid,this.getClass(), "Error");
		}
	}

}
