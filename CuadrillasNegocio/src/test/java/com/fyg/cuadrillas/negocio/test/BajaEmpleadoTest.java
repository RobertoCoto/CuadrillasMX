package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;

public class BajaEmpleadoTest {
	/**
	 * objeto empleadoNegocio
	 */
	private EmpleadoNegocio dataEmpleado;
	/**
	 * Datos del empleado
	 */
	private Empleado bajaEmpleado;
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
		bajaEmpleado = new Empleado();
		bajaEmpleado.setId_empleado(1);
		bajaEmpleado.setCodigo_causa_salida("CRAP");
		bajaEmpleado.setCodigo_tipo_salida("CRMA");
		bajaEmpleado.setEstatus("A");
		}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testBajaEmpleado() throws Exception {
		String guid = uid.generateGUID(bajaEmpleado);
		try {
			dataEmpleado.bajaEmpleado(bajaEmpleado);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
