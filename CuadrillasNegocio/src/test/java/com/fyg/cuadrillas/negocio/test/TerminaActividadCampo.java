package com.fyg.cuadrillas.negocio.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCampoDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaCoordenadasDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;

public class TerminaActividadCampo {

	private ActividadDiariaCampoDTO actividadDiaria;
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@Test
	public void testAltaAgenda() throws Exception {
		String guid = "123456789";
		AgendaNegocio negocio = new AgendaNegocio();
		try {
			actividadDiaria = new ActividadDiariaCampoDTO();
			actividadDiaria.setIdActividadDiaria(2);
			actividadDiaria.setEnvioUsuarioAutorizacion("usaurio");
			actividadDiaria.setObservaciones("observaciones de envio");
			List<ActividadDiariaCoordenadasDTO> coordenadasReal = new ArrayList<ActividadDiariaCoordenadasDTO>();
			ActividadDiariaCoordenadasDTO coordenada1 = new ActividadDiariaCoordenadasDTO();
			coordenada1.setOrden(1);
			coordenada1.setLatitud(19.3507338f);
			coordenada1.setLongitud(-99.0747743f);

			ActividadDiariaCoordenadasDTO coordenada2 = new ActividadDiariaCoordenadasDTO();
			coordenada2.setOrden(2);
			coordenada2.setLatitud(19.3556158f);
			coordenada2.setLongitud(-99.0967412f);

			coordenadasReal.add(coordenada1);
			coordenadasReal.add(coordenada2);
			actividadDiaria.setCoordenadasReal(coordenadasReal);

			negocio.terminaActividadDiaria(actividadDiaria);
		} catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}
}
