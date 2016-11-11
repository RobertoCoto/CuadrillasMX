package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;

public class AltaEmpleadoTest {
	/**
	 * objeto empleadoNegocio
	 */
	private EmpleadoNegocio dataEmpleado;
	/**
	 * Datos del empleado
	 */
	private Empleado altaEmpleado;
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
		altaEmpleado = new Empleado();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		String strFecha = "1983-01-01";
		Date fechaNac = formato.parse(strFecha);
		/**
		 * Valores a enviar
		 */
		altaEmpleado.setNombre("Jorge Arturo");
		altaEmpleado.setApellido_pat("Marquez");
		altaEmpleado.setApellido_mat("Hermandez");
		altaEmpleado.setSexo("H");
		altaEmpleado.setRfc("JOMH830101");
		altaEmpleado.setCurp("JOMH830101HASRRR09");
		altaEmpleado.setFecha_nacimiento(fechaNac);
		altaEmpleado.setCodigo_puesto("AYGE");
		altaEmpleado.setCodigo_vialidad("5MAY");
		altaEmpleado.setCodigo_area("AYGE");
		altaEmpleado.setCodigo_talla("CHIC");
		altaEmpleado.setSueldo(1200.00);
		altaEmpleado.setTelefono("5555555555");
		altaEmpleado.setEstatus("A");
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testRegistraEmpleado() throws Exception {
		String guid = uid.generateGUID(altaEmpleado);
		try {
			dataEmpleado.registraEmpleado(altaEmpleado);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
