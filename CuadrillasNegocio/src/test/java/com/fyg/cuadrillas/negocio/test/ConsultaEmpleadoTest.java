package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.EmpleadoDTO;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;
public class ConsultaEmpleadoTest {
	/**
	 * objeto empleadoNegocio
	 */
	private EmpleadoNegocio dataEmpleado;
	/**
	 * Datos del empleado
	 */
	private EmpleadoDTO consultaEmpleado;
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
		dataEmpleado = new EmpleadoNegocio();
		consultaEmpleado = new EmpleadoDTO();
		consultaEmpleado.setIdEmpleado(1);
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testConsultaEmpleado() {
		String guid = uid.generateGUID(consultaEmpleado);
		try {
			dataEmpleado.consultaEmpleado(consultaEmpleado);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
