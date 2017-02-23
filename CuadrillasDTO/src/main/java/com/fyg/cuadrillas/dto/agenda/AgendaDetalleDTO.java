package com.fyg.cuadrillas.dto.agenda;

import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;
import com.fyg.cuadrillas.dto.CoordenadaDTO;

public class AgendaDetalleDTO  extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5414801533183797568L;

	/** idAgendaDetalle */
	private int idAgendaDetalle;
	/** idAgenda */
	private int idAgenda;
	/** fecha */
	private String fecha;
	/** avanceEsperado */
	private int avanceEsperado;
	/** observaciones */
	private String observaciones;
	/** coordenadas */
	private List<CoordenadaDTO> coordenadas;
	/** actividades */
	private List<String> actividades;
	/** materiales */
	private List<String> materiales;
	/**
	 * @return the idAgendaDetalle
	 */
	public int getIdAgendaDetalle() {
		return idAgendaDetalle;
	}
	/**
	 * @param idAgendaDetalle the idAgendaDetalle to set
	 */
	public void setIdAgendaDetalle(int idAgendaDetalle) {
		this.idAgendaDetalle = idAgendaDetalle;
	}
	/**
	 * @return the idAgenda
	 */
	public int getIdAgenda() {
		return idAgenda;
	}
	/**
	 * @param idAgenda the idAgenda to set
	 */
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the avanceEsperado
	 */
	public int getAvanceEsperado() {
		return avanceEsperado;
	}
	/**
	 * @param avanceEsperado the avanceEsperado to set
	 */
	public void setAvanceEsperado(int avanceEsperado) {
		this.avanceEsperado = avanceEsperado;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the coordenadas
	 */
	public List<CoordenadaDTO> getCoordenadas() {
		return coordenadas;
	}
	/**
	 * @param coordenadas the coordenadas to set
	 */
	public void setCoordenadas(List<CoordenadaDTO> coordenadas) {
		this.coordenadas = coordenadas;
	}
	/**
	 * @return the actividades
	 */
	public List<String> getActividades() {
		return actividades;
	}
	/**
	 * @param actividades the actividades to set
	 */
	public void setActividades(List<String> actividades) {
		this.actividades = actividades;
	}
	/**
	 * @return the materiales
	 */
	public List<String> getMateriales() {
		return materiales;
	}
	/**
	 * @param materiales the materiales to set
	 */
	public void setMateriales(List<String> materiales) {
		this.materiales = materiales;
	}

}
