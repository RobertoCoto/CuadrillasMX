package com.fyg.cuadrillas.dto.contrato;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ContratoDocumentoDTO extends ObjetoValor{

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -3234894709252253780L;
	/**
	 * id del documento
	 */
	private Integer idDocumento;
	/**
	 * id del contrato
	 */
	private Integer idContrato;
	/**
	 * nombre del documento
	 */
	private String nombre;
	/**
	 * codigo del documento
	 */
	private String codigoDocumento;
	/**
	 * url del documento
	 */
	private String url;
	/**
	 * usuario alta
	 */
	private String usuarioAlta;
	/**
	 * fechaAlta
	 */
	private String fechaAlta;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * descripcion documento
	 */
	private String descripcionDocumento;
	/**
	 * @return the idDocumento
	 */
	public Integer getIdDocumento() {
		return idDocumento;
	}
	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}
	/**
	 * @return the idContrato
	 */
	public Integer getIdContrato() {
		return idContrato;
	}
	/**
	 * @param idContrato the idContrato to set
	 */
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the codigoDocumento
	 */
	public String getCodigoDocumento() {
		return codigoDocumento;
	}
	/**
	 * @param codigoDocumento the codigoDocumento to set
	 */
	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	/**
	 * @return the descripcionDocumento
	 */
	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}
	/**
	 * @param descripcionDocumento the descripcionDocumento to set
	 */
	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}
}
