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
	/**
	 * Agenda
	 */
	private AgendaDTO agenda;
	/**
	 * negocio
	 */
	private AgendaNegocio negocio;
	/**
	 * agendaDetalle
	 */
	private AgendaDetalleDTO agendaDetalle;
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

		agendaDetalle = new AgendaDetalleDTO();
		List<AgendaDetalleDTO> detalles = new ArrayList<AgendaDetalleDTO>();
		detalles.add(agendaDetalle);
		agenda.setDiasAgenda(detalles);

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

		AgendaDetalleDTO actividad = new AgendaDetalleDTO();
		actividad.setCodigoActividad("AMUL");
		actividad.setUsuarioAlta("SISTEMAS");

		List<AgendaDetalleDTO> listaActividades = new ArrayList<AgendaDetalleDTO>();
		listaActividades.add(actividad);

		AgendaDetalleDTO material = new AgendaDetalleDTO();
		material.setCodigoMaterial("BOLS");
		material.setUsuarioAlta("SISTEMAS");

		List<AgendaDetalleDTO> listaMateriales = new ArrayList<AgendaDetalleDTO>();
		listaMateriales.add(material);

		agendaDetalle.setAvanceEsperado(40);
		agendaDetalle.setFecha("2017-02-07");
		agendaDetalle.setObservaciones("alta de agenda detalle");
		agendaDetalle.setUsuarioAlta("SISTEMAS");
		agendaDetalle.setCoordenadas(coordenadas);
		agendaDetalle.setActividades(listaActividades);
		agendaDetalle.setMateriales(listaMateriales);
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@Test
	public void testAltaAgenda() throws Exception {
		String guid = "123456789";
		negocio = new AgendaNegocio();
		try {
			negocio.altaAgenda(agenda);
		} catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
}
