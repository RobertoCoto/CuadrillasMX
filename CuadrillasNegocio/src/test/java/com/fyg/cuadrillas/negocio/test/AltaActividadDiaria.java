package com.fyg.cuadrillas.negocio.test;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDetalleDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;

public class AltaActividadDiaria {
	/**
	 * Actividad diaria
	 */
	private ActividadDiariaDetalleDTO actividadDiaria;
	/**
	 * metodo para inicializar valores
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		actividadDiaria = new ActividadDiariaDetalleDTO();
		actividadDiaria.setIdActividadDiaria(1);
		actividadDiaria.setCodigoActividad("AMUL");
		actividadDiaria.setCodigoPrioridad("ALTA");
		actividadDiaria.setCodigoEstado("PROG");
		actividadDiaria.setCodigoListoVencido("PRIO");
		actividadDiaria.setTiempoDestinado(12);
		actividadDiaria.setNumeroPersonas(8);
		actividadDiaria.setNumeroUnidades(1);
		actividadDiaria.setPorcentaje(40f);
		actividadDiaria.setObservaciones("PRUEBA TEST OBS");
		actividadDiaria.setUsuarioAlta("mimejorada");
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@Test
	public void testAltaAgenda() throws Exception {
		String guid = "123456789";
		AgendaNegocio negocio = new AgendaNegocio();
		try {
			negocio.registraActividadDiaria(actividadDiaria);
		} catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
