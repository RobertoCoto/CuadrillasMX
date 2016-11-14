package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.dto.EmpleadoDocumentos;
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
	 * Documentos
	 */
	private EmpleadoDocumentos docEmpleado;
	private EmpleadoDocumentos docEmpleado2;
	private EmpleadoDocumentos docEmpleado3;
	private EmpleadoDocumentos docEmpleado4;
	/**
	 * lista para guardar documentos
	 */
	private ArrayList<EmpleadoDocumentos> dataDocumentos;
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
		altaEmpleado.setRfc("MAHJ830101");
		altaEmpleado.setCurp("MAHJ830101HASRRR09");
		altaEmpleado.setFecha_nacimiento(fechaNac);
		altaEmpleado.setCodigo_puesto("AYGE");
		altaEmpleado.setCodigo_vialidad("5MAY");
		altaEmpleado.setCodigo_area("AYGE");
		altaEmpleado.setCodigo_talla("CHIC");
		altaEmpleado.setSueldo(1200.00);
		altaEmpleado.setTelefono("5555555555");
		altaEmpleado.setEstatus("A");
		
		/**
		 * Se crea un ArrayList para recibir varios docs
		 */
		dataDocumentos = new ArrayList<EmpleadoDocumentos>();
		docEmpleado.setCodigo_emp_doc("ACNA");
		docEmpleado.setEstatus("A");
		
		docEmpleado2.setCodigo_emp_doc("CURP");
		docEmpleado2.setEstatus("A");
		
		docEmpleado3.setCodigo_emp_doc("CUVI");
		docEmpleado3.setEstatus("A");
		
		docEmpleado4.setCodigo_emp_doc("RFC");
		docEmpleado4.setEstatus("A");
		
		dataDocumentos.add(docEmpleado);
		dataDocumentos.add(docEmpleado2);
		dataDocumentos.add(docEmpleado3);
		dataDocumentos.add(docEmpleado4);
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
