package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	private EmpleadoDocumentoDTO docEmpleado2;
	private EmpleadoDocumentoDTO docEmpleado3;
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
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		String strFecha = "1983-01-01";
		Date fechaNac = formato.parse(strFecha);
		
		modificaEmpleado.setNombre("ARMANDO");
		modificaEmpleado.setApellidoPat("GONZALEZ");
		modificaEmpleado.setApellidoMat("PEREZ");
		modificaEmpleado.setFechaNacimiento(fechaNac);
		modificaEmpleado.setRfc("GOPA19830101");
		modificaEmpleado.setDocumentos(dataDocumentos);
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
