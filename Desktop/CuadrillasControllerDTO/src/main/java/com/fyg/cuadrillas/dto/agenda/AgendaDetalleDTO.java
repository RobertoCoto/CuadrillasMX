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
	private Integer idAgendaDetalle;
	/** idAgenda */
	private int idAgenda;
	/** fecha */
	private String fecha;
	/** avanceEsperado */
	private float avanceEsperado;
	/** observaciones */
	private String observaciones;
	/** coordenadas */
	private List<CoordenadaDTO> coordenadas;
	/** actividades */
	private List<AgendaActividadDTO> actividades;
	/** materiales */
	private List<AgendaMaterialDTO> materiales;
	/** Usuario alta */
	private String usuarioAlta;
	/** idActividadDiaria */
	private Integer idActividadDiaria;
	/**
	 * @return the idAgendaDetalle
	 */
	public Integer getIdAgendaDetalle() {
		return idAgendaDetalle;
	}
	/**
	 * @param idAgendaDetalle the idAgendaDetalle to set
	 */
	public void setIdAgendaDetalle(Integer idAgendaDetalle) {
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
	public float getAvanceEsperado() {
		return avanceEsperado;
	}
	/**
	 * @param avanceEsperado the avanceEsperado to set
	 */
	public void setAvanceEsperado(float avanceEsperado) {
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
	public List<AgendaActividadDTO> getActividades() {
		return actividades;
	}
	/**
	 * @param actividades the actividades to set
	 */
	public void setActividades(List<AgendaActividadDTO> actividades) {
		this.actividades = actividades;
	}
	/**
	 * @return the materiales
	 */
	public List<AgendaMaterialDTO> getMateriales() {
		return materiales;
	}
	/**
	 * @param materiales the materiales to set
	 */
	public void setMateriales(List<AgendaMaterialDTO> materiales) {
		this.materiales = materiales;
	}
	/**
	 * @return the usuarioAlta
	 */
	public String getUsuarioAlta() {
		return usuarioAlta;
	}
	/**
	 * @param usuarioAlta the usuarioAlta to set
	 */
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}
	/**
	 * @return the idActividadDiaria
	 */
	public Integer getIdActividadDiaria() {
		return idActividadDiaria;
	}
	/**
	 * @param idActividadDiaria the idActividadDiaria to set
	 */
	public void setIdActividadDiaria(Integer idActividadDiaria) {
		this.idActividadDiaria = idActividadDiaria;
	}

}
