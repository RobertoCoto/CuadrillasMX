package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;

public class ModificaEmpleadoTest {
	/**
	 * objeto empleadoNegocio
	 */
	private EmpleadoNegocio dataEmpleado;
	/**
	 * Datos del empleado
	 */
	private Empleado modificaEmpleado;
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
		modificaEmpleado = new Empleado();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		String strFecha = "1983-01-01";
		Date fechaNac = formato.parse(strFecha);
		
		modificaEmpleado.setNombre("ARMANDO");
		modificaEmpleado.setApellido_pat("GONZALEZ");
		modificaEmpleado.setApellido_mat("PEREZ");
		modificaEmpleado.setFecha_nacimiento(fechaNac);
		modificaEmpleado.setSueldo(1400.00);
		modificaEmpleado.setNss("1234DF3");
		modificaEmpleado.setTelefono("12345678");
		modificaEmpleado.setNo_credito_infonavit("4432212FERA233");
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testModificaEmpleado() throws Exception {
		String guid = uid.generateGUID(modificaEmpleado);
		try {
			dataEmpleado.bajaEmpleado(modificaEmpleado);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
