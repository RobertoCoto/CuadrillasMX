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
		docEmpleado.setEstatus("SI");
		
		docEmpleado2.setCodigoEmpDoc("CURP");
		docEmpleado2.setEstatus("NO");
		
		docEmpleado3.setCodigoEmpDoc("CUVI");
		docEmpleado3.setEstatus("NA");
		
		docEmpleado4.setCodigoEmpDoc("RFC");
		docEmpleado4.setEstatus("NA");
		
		dataDocumentos.add(docEmpleado);
		dataDocumentos.add(docEmpleado2);
		dataDocumentos.add(docEmpleado3);
		dataDocumentos.add(docEmpleado4);

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		String strFecha = "1985-03-06";
		Date fechaNac = formato.parse(strFecha);
		/**
		 * Valores a enviar
		 */
		altaEmpleado.setNombre("MARIO IVAN");
		altaEmpleado.setApellidoPat("MEJORADA");
		altaEmpleado.setApellidoMat("HERRERA");
		altaEmpleado.setSexo("M");
		altaEmpleado.setRfc("MAHJ830101");		
		altaEmpleado.setFechaNacimiento(fechaNac);
		altaEmpleado.setCodigoPuesto("AYGE");
		altaEmpleado.setCodigoVialidad("5MAY");
		altaEmpleado.setCodigoArea("AYGE");
		altaEmpleado.setCodigoTalla("CHIC");
		altaEmpleado.setSueldo(1200.00);
		altaEmpleado.setTelefono("5555555555");
		altaEmpleado.setEstatus("A");
		altaEmpleado.setObservaciones("CORRECTO");
		altaEmpleado.setDocumentos(dataDocumentos);
		//altaEmpleado.setFechaIngreso(new Date(2016,10,10));
		altaEmpleado.setUsuarioAlta("usuario");
		
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testRegistraEmpleado() throws Exception {
		String guid = uid.generateGUID(altaEmpleado);
		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");
		try {
			dataEmpleado.registraEmpleado(altaEmpleado);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
