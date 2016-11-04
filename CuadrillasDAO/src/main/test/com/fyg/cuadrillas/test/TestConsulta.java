package com.fyg.cuadrillas.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.dto.PruebaDTO;
import com.fyg.cuadrillas.dao.ConsultasCuadrillasDAO;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
public class TestConsulta {
	/**
	 * Objeto Consultas
	 */
    private ConsultasCuadrillasDAO datoPruebas;
    /**
     * Objeto PruebaDTO
     */
    private PruebaDTO pruebas;
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
		datoPruebas = new ConsultasCuadrillasDAO();
		pruebas  = new PruebaDTO();
		pruebas.setIdPrueba(1);
	}
    /**
     * Test
     * @throws Exception
     */
	@Test
	@SuppressWarnings("static-access")
	public void testConsultaPrueba() throws Exception {
		String guid = uid.generateGUID(datoPruebas);
		try {
			datoPruebas.consultaPrueba(guid, pruebas);
			LogHandler.info(guid, this.getClass(), "PRUEBA  CONSULTA JUNIT");
		}
		catch (Exception ex) {
			LogHandler.info(guid, this.getClass(), "Error");
		}
	}
}
