package com.fyg.cuadrillas.dto;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class CoordenadaDTO extends ObjetoValor {

	/** serialVersionUID */
	private static final long serialVersionUID = 5058719064050928933L;
	/** id Contrato*/
	private int idContrato;
	/** id Agenda */
	private int idAgenda;
	/**id agenda detalle*/
	private Integer idAgendaDetalle;
	/** orden */
	private int orden;
	/** direccion */
	private String direccion;
	/** latitud */
	private Float latitud;
	/** longitud */
	private Float longitud;

	/**
	 * @return the idContrato
	 */
	public int getIdContrato() {
		return idContrato;
	}
	/**
	 * @param idContrato the idContrato to set
	 */
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	/**
	 * @return the orden
	 */
	public int getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(int orden) {
		this.orden = orden;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the latitud
	 */
	public Float getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public Float getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
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
}
