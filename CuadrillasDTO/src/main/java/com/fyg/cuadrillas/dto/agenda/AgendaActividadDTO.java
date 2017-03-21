package com.fyg.cuadrillas.dto.agenda;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class AgendaActividadDTO extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -6892476560598894553L;
	/**
	 * Id agenda detalle
	 */
	private Integer idAgendaDetalle;
	/**
	 * codigo de la actividad
	 */
	private String codigoActividad;
	/**
	 * descripcionActividad
	 */
	private String descripcionActividad;
	/**
	 * usuario alta
	 */
	private String usuarioAlta;
	/**
	 * fecha Alta
	 */
	private String fechaAlta;
	/**
	 * estatus 
	 */
	private String estatus;
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
	 * @return the descripcionActividad
	 */
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	/**
	 * @param descripcionActividad the descripcionActividad to set
	 */
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
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
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}
