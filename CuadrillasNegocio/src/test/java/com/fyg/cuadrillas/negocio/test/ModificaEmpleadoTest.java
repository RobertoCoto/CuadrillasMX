package com.fyg.cuadrillas.negocio.test;

import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoDTO;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;

public class ModificaEmpleadoTest {
	/**
	 * objeto empleadoNegocio
	 */
	private EmpleadoNegocio dataEmpleado;
	/**
	 * Datos del empleado
	 */
	private EmpleadoDTO modificaEmpleado;
	/**
	  * Guid unico generado
	  */
	private GUIDGenerator uid;
	/**
	 * Documentos
	 */
	private EmpleadoDocumentoDTO docEmpleado;
	/**
	 * doc
	 */
	private EmpleadoDocumentoDTO docEmpleado2;
	/**
	 * doc2
	 */
	private EmpleadoDocumentoDTO docEmpleado3;
	/**
	 * doc3
	 */
	private EmpleadoDocumentoDTO docEmpleado4;
	/**
	 * lista para guardar documentos
	 */
	private ArrayList<EmpleadoDocumentoDTO> dataDocumentos;
	/**
	 * SetUp
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataEmpleado = new EmpleadoNegocio();
		modificaEmpleado = new EmpleadoDTO();
		docEmpleado = new EmpleadoDocumentoDTO();
		docEmpleado2 = new EmpleadoDocumentoDTO();
		docEmpleado3 = new EmpleadoDocumentoDTO();
		docEmpleado4 = new EmpleadoDocumentoDTO();
		/**
		 * Se crea un ArrayList para recibir varios docs
		 */
		dataDocumentos = new ArrayList<EmpleadoDocumentoDTO>();
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
		String strFecha = "1983-01-01";
		modificaEmpleado.setIdEmpleado(3);
		modificaEmpleado.setNombre("ARMANDO");
		modificaEmpleado.setApellidoPat("GONZALEZ");
		modificaEmpleado.setApellidoMat("PEREZ");
		modificaEmpleado.setFechaNacimiento(strFecha);
		modificaEmpleado.setRfc("GOPA19830101");
		modificaEmpleado.setDocumentos(dataDocumentos);
		modificaEmpleado.setObservaciones("CORRECTO");
		modificaEmpleado.setSexo("M");
		modificaEmpleado.setCodigoPuesto("AYGE");
		modificaEmpleado.setCodigoVialidad("5MAY");
		modificaEmpleado.setCodigoArea("AYGE");
		modificaEmpleado.setCodigoTalla("CHIC");
		modificaEmpleado.setSueldo(10);
		modificaEmpleado.setNss("xxx");
		modificaEmpleado.setNoCreditoInfonavit("1213");
		modificaEmpleado.setUsuarioAlta("MAYITO");
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testModificaEmpleado() throws Exception {
		String guid = uid.generateGUID(modificaEmpleado);
		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");
		try {
			dataEmpleado.modificaEmpleado(modificaEmpleado);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
