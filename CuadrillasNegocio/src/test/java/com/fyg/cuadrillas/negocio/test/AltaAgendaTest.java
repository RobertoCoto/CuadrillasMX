package com.fyg.cuadrillas.negocio.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;
import com.fyg.cuadrillas.dto.agenda.AgendaDetalleDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;

public class AltaAgendaTest {
	
	private AgendaDTO agenda;
	private AgendaNegocio negocio;
	private AgendaDetalleDTO agendaDetalle;
	
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
		agendaDetalle.setAvanceEsperado(40);
		agendaDetalle.setFecha("2017-02-07");
		agendaDetalle.setObservaciones("alta de agenda detalle");
		agendaDetalle.setUsuarioAlta("SISTEMAS");
		
		
		List<AgendaDetalleDTO> detalles = new ArrayList<AgendaDetalleDTO>();
		detalles.add(agendaDetalle);
		agenda.setDiasAgenda(detalles);
		
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAltaAgenda() throws Exception {
		String guid = "123456789";
		negocio = new AgendaNegocio();
		
		try {
			negocio.altaAgenda(agenda);
		}catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
	

}
