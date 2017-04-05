package com.fyg.cuadrillas.dto.actividad;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadDiariaDocumentosDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -5439069885623789764L;
	/**id actividad diaria*/
	private Integer idActividadDiaria;
	/** codigo de la actividad*/
	/** descripcion de la actividad*/
	private String descripcionActividad;
	/** consecutivo*/
	private Integer consecutivo;
	/**url*/
	private String url;
	/** usuario alta*/
	private String usuarioAlta;
	/** fecha alta*/
	private String fechaAlta;
	/** estatus*/
	private String estatus;
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
	 * @return the consecutivo
	 */
	public Integer getConsecutivo() {
		return consecutivo;
	}
	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
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
}
