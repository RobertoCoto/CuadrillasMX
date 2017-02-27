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
	private int avanceEsperado;
	/** observaciones */
	private String observaciones;
	/** coordenadas */
	private List<CoordenadaDTO> coordenadas;
	/** actividades */
	private List<AgendaDetalleDTO> actividades;
	/** materiales */
	private List<AgendaDetalleDTO> materiales;
	/**
	 * Usuario alta
	 */
	private String usuarioAlta;
	/**
	 * codigo actividad
	 */
	private String codigoActividad;
	/**
	 * ccodigo Material
	 */
	private String codigoMaterial;
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
	public List<AgendaDetalleDTO> getActividades() {
		return actividades;
	}
	/**
	 * @param actividades the actividades to set
	 */
	public void setActividades(List<AgendaDetalleDTO> actividades) {
		this.actividades = actividades;
	}
	/**
	 * @return the materiales
	 */
	public List<AgendaDetalleDTO> getMateriales() {
		return materiales;
	}
	/**
	 * @param materiales the materiales to set
	 */
	public void setMateriales(List<AgendaDetalleDTO> materiales) {
		this.materiales = materiales;
	}
	/**
	 * @return the codigoActividad
	 */
	public String getCodigoActividad() {
		return codigoActividad;
	}
	/**
	 * @param codigoActividad the codigoActividad to set
	 */
	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}
	/**
	 * @return the codigoMaterial
	 */
	public String getCodigoMaterial() {
		return codigoMaterial;
	}
	/**
	 * @param codigoMaterial the codigoMaterial to set
	 */
	public void setCodigoMaterial(String codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
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
}
