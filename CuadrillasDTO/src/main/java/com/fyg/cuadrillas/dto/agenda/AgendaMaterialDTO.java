package com.fyg.cuadrillas.dto.agenda;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class AgendaMaterialDTO extends ObjetoValor{
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4472891796931901393L;
	/**
	 * Id agenda detalle
	 */
	private Integer idAgendaDetalle;
	/**
	 * codigo del material
	 */
	private String codigoMaterial;
	/**
	 * descripcion del material
	 */
	private String descripcionMaterial;
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
	 * @return the descripcionMaterial
	 */
	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}
	/**
	 * @param descripcionMaterial the descripcionMaterial to set
	 */
	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
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
