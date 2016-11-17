package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;

public class BajaEmpleadoTest {
	/**
	 * objeto empleadoNegocio
	 */
	private EmpleadoNegocio dataEmpleado;
	/**
	 * Datos del empleado
	 */
	private EmpleadoDTO bajaEmpleado;
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
		bajaEmpleado = new EmpleadoDTO();
		bajaEmpleado.setIdEmpleado(1);
		bajaEmpleado.setCodigoCausaSalida("CRAP");
		bajaEmpleado.setCodigoTipoSalida("CRMA");
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
