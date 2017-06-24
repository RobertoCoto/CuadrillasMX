package com.fyg.cuadrillas.negocio.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDetalleDTO;
import com.fyg.cuadrillas.dto.actividad.ActividadDiariaDocumentosDTO;
import com.fyg.cuadrillas.negocio.AgendaNegocio;

public class AltaActividadDiaria {
	/**
	 * Actividad diaria
	 */
	private ActividadDiariaDetalleDTO actividadDiaria;
	/**
	 * docs
	 */
	private ActividadDiariaDocumentosDTO documentos;
	/**
	 * docs 2
	 */
	private ActividadDiariaDocumentosDTO documentos1;
	/**
	 * listadocs
	 */
	private List<ActividadDiariaDocumentosDTO> listaDocumentos;
	/**
	 * metodo para inicializar valores
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		actividadDiaria = new ActividadDiariaDetalleDTO();
		actividadDiaria.setIdActividadDiaria(5);
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

		documentos = new ActividadDiariaDocumentosDTO();
		documentos.setConsecutivo(1);
		documentos.setUrl("233-32foto1.jpg");
		documentos1 = new ActividadDiariaDocumentosDTO();
		documentos1.setConsecutivo(2);
		documentos1.setUrl("233-32foto2.jpg");

		listaDocumentos = new ArrayList<ActividadDiariaDocumentosDTO>();
		listaDocumentos.add(documentos);
		listaDocumentos.add(documentos1);
		actividadDiaria.setDocumentos(listaDocumentos);
	}
	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@Test
	public void testAltaAgenda() throws Exception {
		String guid = "123456789";
		
		int a = 3;
		int t = 1;
		float p = t / (float) a ;
		System.out.println(p);
			
		AgendaNegocio negocio = new AgendaNegocio();
		try {
			//negocio.registraActividadDiaria(actividadDiaria);
		} catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
