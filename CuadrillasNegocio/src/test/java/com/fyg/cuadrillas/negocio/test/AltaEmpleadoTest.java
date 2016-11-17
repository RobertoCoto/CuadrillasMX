package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoDTO;
import com.fyg.cuadrillas.negocio.EmpleadoNegocio;

public class AltaEmpleadoTest {
	/**
	 * objeto empleadoNegocio
	 */
	private EmpleadoNegocio dataEmpleado;
	/**
	 * Datos del empleado
	 */
	private EmpleadoDTO altaEmpleado;
	/**
	 * Documentos
	 */
	private EmpleadoDocumentoDTO docEmpleado;
	private EmpleadoDocumentoDTO docEmpleado2;
	private EmpleadoDocumentoDTO docEmpleado3;
	private EmpleadoDocumentoDTO docEmpleado4;
	/**
	 * lista para guardar documentos
	 */
	private ArrayList<EmpleadoDocumentoDTO> dataDocumentos;
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
		altaEmpleado = new EmpleadoDTO();
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
