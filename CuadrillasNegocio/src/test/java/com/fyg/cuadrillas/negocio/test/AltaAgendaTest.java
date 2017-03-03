package com.fyg.cuadrillas.negocio.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaDetalleDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;

public class AltaAgendaTest {

	private AgendaDTO agenda;
	/**
	 * metodo para inicializar valores
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		agenda = new AgendaDTO();
		agenda.setIdContrato(1);
		agenda.setFechaInicio("2017-02-05");
		agenda.setFechaFin("2017-02-10");
		agenda.setNoSemana(7);
		agenda.setNoHoras(80);
		agenda.setNoTrabajadores(10);
		agenda.setUsuario("SISTEMAS");
		
		List<AgendaDetalleDTO> detalles = new ArrayList<AgendaDetalleDTO>();
		
		AgendaDetalleDTO agendaDetalle = new AgendaDetalleDTO();
		agendaDetalle.setAvanceEsperado(40);
		agendaDetalle.setFecha("2017-02-07");
		agendaDetalle.setObservaciones("alta de agenda detalle");
		agendaDetalle.setUsuarioAlta("SISTEMAS");
		
		CoordenadaDTO coordenada1 = new CoordenadaDTO();
		coordenada1.setOrden(1);
		coordenada1.setDireccion("AV VASCO DE QUIROGA 22");
		coordenada1.setLatitud(19.3507338f);
		coordenada1.setLongitud(-99.0747743f);

		CoordenadaDTO coordenada2 = new CoordenadaDTO();
		coordenada2.setOrden(2);
		coordenada2.setDireccion("AV CONSTITUYENTES 22");
		coordenada2.setLatitud(19.3556158f);
		coordenada2.setLongitud(-99.0967412f);

		List<CoordenadaDTO> coordenadas = new ArrayList<CoordenadaDTO>();
		coordenadas.add(coordenada1);
		coordenadas.add(coordenada2);

		List<String> listaActividades = new ArrayList<String>();
		listaActividades.add("AMUL");
		listaActividades.add("AAAA");
		listaActividades.add("BBBB");

		List<String> listaMateriales = new ArrayList<String>();
		listaMateriales.add("BOLS");
		listaMateriales.add("DDDD");

		agendaDetalle.setCoordenadas(coordenadas);
		agendaDetalle.setActividades(listaActividades);
		agendaDetalle.setMateriales(listaMateriales);

		detalles.add(agendaDetalle);

		agenda.setDiasAgenda(detalles);
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@Test
	public void testAltaAgenda() throws Exception {
		String guid = "123456789";

		System.setProperty("http.proxyHost", "169.169.4.85");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "169.169.4.85");
        System.setProperty("https.proxyPort", "8080");

		AgendaNegocio negocio = new AgendaNegocio();
		try {
			negocio.altaAgenda(agenda);
		} catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
}
