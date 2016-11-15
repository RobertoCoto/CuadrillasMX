package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.dto.EmpleadoDocumentos;
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
	 * SetUp
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataEmpleado = new EmpleadoNegocio();
		modificaEmpleado = new Empleado();
		docEmpleado = new EmpleadoDocumentos();
		docEmpleado2 = new EmpleadoDocumentos();
		docEmpleado3 = new EmpleadoDocumentos();
		docEmpleado4 = new EmpleadoDocumentos();
		
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
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		String strFecha = "1983-01-01";
		Date fechaNac = formato.parse(strFecha);
		
		modificaEmpleado.setNombre("ARMANDO");
		modificaEmpleado.setApellido_pat("GONZALEZ");
		modificaEmpleado.setApellido_mat("PEREZ");
		modificaEmpleado.setFecha_nacimiento(fechaNac);
		modificaEmpleado.setRfc("GOPA19830101");
		modificaEmpleado.setObjDocumentos(dataDocumentos);
		modificaEmpleado.setObservaciones("CORRECTO");
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
