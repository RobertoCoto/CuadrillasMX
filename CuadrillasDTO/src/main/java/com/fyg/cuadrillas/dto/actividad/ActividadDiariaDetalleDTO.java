package com.fyg.cuadrillas.dto.actividad;

import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadDiariaDetalleDTO extends ObjetoValor{

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -6802599051567417896L;
	/** id de la actividad diaria*/
	private Integer idActividadDiaria;
	/** codigo actividad*/
	private String codigoActividad;
	/** codigo estado*/
	private String codigoEstado;
	/** codigo listo vencido*/
	private String codigoListoVencido;
	/** codigo listo vencido*/
	private String descripcionActividad;
	/** descripcion estado*/
	private String descripcionEstado;
	/**descripcion listo vencido*/
	private String descripcionListoVencido;
	/**tiempo destinado*/
	private Integer tiempoDestinado;
	/** numero de personas*/
	private Integer numeroPersonas;
	/**numero de unidades*/
	private Integer numeroUnidades;
	/** porcentaje*/
	private Float porcentaje;
	/** observaciones*/
	private String observaciones;
	/** planeada*/
	private String planeada;
	/** fecha Alta*/
	private String fechaAlta;
	/** usuario alta*/
	private String usuarioAlta;
	/** fecha baja*/
	private String fechaBaja;
	/** usuario baja*/
	private String usuarioBaja;
	/** usuario ulti mod*/
	private String usuarioUltmod;
	/** fecha ult mod*/
	private String fechaUltMod;
	/** estatus*/
	private String estatus;
	/** lista documentos*/
	private List<ActividadDiariaDocumentosDTO> documentos;
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
	 * @return the codigoEstado
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}
	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	/**
	 * @return the codigoListoVencido
	 */
	public String getCodigoListoVencido() {
		return codigoListoVencido;
	}
	/**
	 * @param codigoListoVencido the codigoListoVencido to set
	 */
	public void setCodigoListoVencido(String codigoListoVencido) {
		this.codigoListoVencido = codigoListoVencido;
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
	 * @return the descripcionEstado
	 */
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	/**
	 * @param descripcionEstado the descripcionEstado to set
	 */
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	/**
	 * @return the descripcionListoVencido
	 */
	public String getDescripcionListoVencido() {
		return descripcionListoVencido;
	}
	/**
	 * @param descripcionListoVencido the descripcionListoVencido to set
	 */
	public void setDescripcionListoVencido(String descripcionListoVencido) {
		this.descripcionListoVencido = descripcionListoVencido;
	}
	/**
	 * @return the tiempoDestinado
	 */
	public Integer getTiempoDestinado() {
		return tiempoDestinado;
	}
	/**
	 * @param tiempoDestinado the tiempoDestinado to set
	 */
	public void setTiempoDestinado(Integer tiempoDestinado) {
		this.tiempoDestinado = tiempoDestinado;
	}
	/**
	 * @return the numeroPersonas
	 */
	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}
	/**
	 * @param numeroPersonas the numeroPersonas to set
	 */
	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	/**
	 * @return the numeroUnidades
	 */
	public Integer getNumeroUnidades() {
		return numeroUnidades;
	}
	/**
	 * @param numeroUnidades the numeroUnidades to set
	 */
	public void setNumeroUnidades(Integer numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}
	/**
	 * @return the porcentaje
	 */
	public Float getPorcentaje() {
		return porcentaje;
	}
	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
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
	 * @return the planeada
	 */
	public String getPlaneada() {
		return planeada;
	}
	/**
	 * @param planeada the planeada to set
	 */
	public void setPlaneada(String planeada) {
		this.planeada = planeada;
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
	 * @return the fechaBaja
	 */
	public String getFechaBaja() {
		return fechaBaja;
	}
	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	/**
	 * @return the usuarioBaja
	 */
	public String getUsuarioBaja() {
		return usuarioBaja;
	}
	/**
	 * @param usuarioBaja the usuarioBaja to set
	 */
	public void setUsuarioBaja(String usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}
	/**
	 * @return the usuarioUltmod
	 */
	public String getUsuarioUltmod() {
		return usuarioUltmod;
	}
	/**
	 * @param usuarioUltmod the usuarioUltmod to set
	 */
	public void setUsuarioUltmod(String usuarioUltmod) {
		this.usuarioUltmod = usuarioUltmod;
	}
	/**
	 * @return the fechaUltMod
	 */
	public String getFechaUltMod() {
		return fechaUltMod;
	}
	/**
	 * @param fechaUltMod the fechaUltMod to set
	 */
	public void setFechaUltMod(String fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
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
	 * @return the documentos
	 */
	public List<ActividadDiariaDocumentosDTO> getDocumentos() {
		return documentos;
	}
	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<ActividadDiariaDocumentosDTO> documentos) {
		this.documentos = documentos;
	}
}
