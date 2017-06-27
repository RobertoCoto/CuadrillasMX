package com.fyg.cuadrillas.negocio.test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

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
	/**
	 * doc1
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

		docEmpleado3.setCodigoEmpDoc("CDOM");
		docEmpleado3.setEstatus("NA");

		docEmpleado4.setCodigoEmpDoc("SOEM");
		docEmpleado4.setEstatus("NA");

		dataDocumentos.add(docEmpleado);
		dataDocumentos.add(docEmpleado2);
		dataDocumentos.add(docEmpleado3);
		dataDocumentos.add(docEmpleado4);

		String strFecha = "1985-03-10";

		/**
		 * Valores a enviar
		 */
		altaEmpleado.setNoEmpleado("EMP0020");
		altaEmpleado.setIdCuadrilla(1);
		altaEmpleado.setNombre("ROBC");
		altaEmpleado.setApellidoPat("MEJORADA");
		altaEmpleado.setApellidoMat("SANDHEZ");
		altaEmpleado.setCodigoEmpresa("TATE");
		altaEmpleado.setSexo("M");
		altaEmpleado.setRfc("MAHJ830101");
		altaEmpleado.setFechaNacimiento(strFecha);
		altaEmpleado.setNss("22233332");
		altaEmpleado.setNoCreditoInfonavit("22323244");
		altaEmpleado.setAltaImss("N");
		altaEmpleado.setCalificacion(10);
		altaEmpleado.setCodigoPuesto("RESI");
		altaEmpleado.setCodigoVialidad("5MAY");
		altaEmpleado.setCodigoArea("AYGE");
		altaEmpleado.setCodigoTalla("CHIC");
		altaEmpleado.setSueldo(1200.00);
		altaEmpleado.setTelefono("5555555555");
		altaEmpleado.setEstatus("A");
		altaEmpleado.setObservaciones("CORRECTO");
		altaEmpleado.setDocumentos(dataDocumentos);
		//altaEmpleado.setFechaIngreso(new Date(2016,10,10));
		altaEmpleado.setUsuarioAlta("SISTEMAS");
		altaEmpleado.setFrecuenciaPago("S");
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
