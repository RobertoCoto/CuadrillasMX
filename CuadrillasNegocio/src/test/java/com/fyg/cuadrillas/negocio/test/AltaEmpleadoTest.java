package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.dto.EmpleadoDocumento;
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
	private EmpleadoDocumento docEmpleado;
	private EmpleadoDocumento docEmpleado2;
	private EmpleadoDocumento docEmpleado3;
	private EmpleadoDocumento docEmpleado4;
	/**
	 * lista para guardar documentos
	 */
	private ArrayList<EmpleadoDocumento> dataDocumentos;
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
		docEmpleado = new EmpleadoDocumento();
		docEmpleado2 = new EmpleadoDocumento();
		docEmpleado3 = new EmpleadoDocumento();
		docEmpleado4 = new EmpleadoDocumento();
		
		/**
		 * Se crea un ArrayList para recibir varios docs
		 */
		dataDocumentos = new ArrayList<EmpleadoDocumento>();
		docEmpleado.setCodigoEmpDoc("ACNA");
		docEmpleado.setEstatus("A");
		
		docEmpleado2.setCodigoEmpDoc("CURP");
		docEmpleado2.setEstatus("A");
		
		docEmpleado3.setCodigoEmpDoc("CUVI");
		docEmpleado3.setEstatus("A");
		
		docEmpleado4.setCodigoEmpDoc("RFC");
		docEmpleado4.setEstatus("A");
		
		dataDocumentos.add(docEmpleado);
		dataDocumentos.add(docEmpleado2);
		dataDocumentos.add(docEmpleado3);
		dataDocumentos.add(docEmpleado4);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		String strFecha = "1983-01-01";
		Date fechaNac = formato.parse(strFecha);
		/**
		 * Valores a enviar
		 */
		altaEmpleado.setNombre("Jorge Arturo");
		altaEmpleado.setApellidoPat("Marquez");
		altaEmpleado.setApellidoMat("Hermandez");
		altaEmpleado.setSexo("H");
		altaEmpleado.setRfc("MAHJ830101");
		altaEmpleado.setCurp("MAHJ830101HASRRR09");
		altaEmpleado.setFechaNacimiento(fechaNac);
		altaEmpleado.setCodigoPuesto("AYGE");
		altaEmpleado.setCodigoVialidad("5MAY");
		altaEmpleado.setCodigoArea("AYGE");
		altaEmpleado.setCodigoTalla("CHIC");
		altaEmpleado.setSueldo(1200.00);
		altaEmpleado.setTelefono("5555555555");
		altaEmpleado.setEstatus("A");
		altaEmpleado.setObservaciones("CORRECTO");
		altaEmpleado.setObjDocumentos(dataDocumentos);
		
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
