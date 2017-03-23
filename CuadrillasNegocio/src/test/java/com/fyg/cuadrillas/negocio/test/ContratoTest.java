package com.fyg.cuadrillas.negocio.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;
import com.fyg.cuadrillas.negocio.ContratoNegocio;
import com.google.gson.Gson;

public class ContratoTest {
	/**
	 * metodo
	 */
	private ContratoDTO contrato;
	/**
	 * metodo
	 * @throws Exception si genera error
	 */
	@Before
	public void setUp() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		contrato = new ContratoDTO();
		contrato.setNumeroDocumento("A-12345567");
		contrato.setUsuarioAlta("usuario");
		contrato.setCodigoDocumento("CONT");
		contrato.setCodigoContrato("ARVE");
		contrato.setCodigoVialidad("UNIV");
		contrato.setCodigoEmpresa("TATE");
		contrato.setFechaInicio("2015-12-01");
		contrato.setFechaFin("2016-12-01");
		contrato.setUrl("01-03-2017 030305 DSC_0002.JPG");
		CoordenadaDTO coordenada1 = new CoordenadaDTO();
		coordenada1.setOrden(1);
		coordenada1.setLatitud(19.3507338f);
		coordenada1.setLongitud(-99.0747743f);

		CoordenadaDTO coordenada2 = new CoordenadaDTO();
		coordenada2.setOrden(2);
		coordenada2.setLatitud(19.3556158f);
		coordenada2.setLongitud(-99.0967412f);

		List<CoordenadaDTO> coordenadas = new ArrayList<CoordenadaDTO>();
		coordenadas.add(coordenada1);
		coordenadas.add(coordenada2);
		contrato.setCoordenadas(coordenadas);
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@Test
	public void testRegistraContrato() throws Exception {
		String guid = "123456789";

		/*System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");
*/
        ContratoNegocio negocio = new ContratoNegocio();

		try {
			Gson sg = new Gson();
			System.out.println(sg.toJson(contrato));
			//negocio.altaContrato(contrato);
			negocio.altaContrato(contrato);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
}
