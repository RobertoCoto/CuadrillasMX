package com.fyg.cuadrillas.dto.contrato;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ContratoDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1670407171238552004L;
	/**
	 * idContrato
	 */
	private Integer idContrato;
	/**
	 * numero del contrato
	 */
	private Integer numeroContrato;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * fecha del registro
	 */
	private Date fechaRegistro;
	/**
	 * id vialidad
	 */
	private Integer idVialidad;
	/**
	 * latitud inicial
	 */
	private float latitudInicial;
	/**
	 * longitud inicial
	 */
	private float longitudInicial;
	/**
	 * latitud final
	 */
	private float latitudFinal;
	/**
	 * longitud final
	 */
	private float longitudFinal;
	/**
	 * observaciones
	 */
	private String observaciones;
	/**
	 * url
	 */
	private String url;
	
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * usuario Alta
	 */
	private String usuarioAlta;
	/**
	 * fecha Alta
	 */
	private Date fechaAlta;
	/**
	 * usuario baja
	 */
	private String usuarioBaja;
	/**
	 * fecha baja
	 */
	private Date fechaBaja;
	/**
	 * fecha ult mod
	 */
	private Date fechaUltMod;
	/**
	 * usuario ultima mod
	 */
	private String usuarioUltMod;
	/**
	 * direccion inicial
	 */
	private String direccionInicial;
	/**
	 * direccion final
	 */
	private String direccionFinal;
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
	 * @return the numeroContrato
	 */
	public Integer getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	/**
	 * @return the idEmpleado
	 */
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the idVialidad
	 */
	public Integer getIdVialidad() {
		return idVialidad;
	}
	/**
	 * @param idVialidad the idVialidad to set
	 */
	public void setIdVialidad(Integer idVialidad) {
		this.idVialidad = idVialidad;
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
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
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
	 * @return the fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}
	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	/**
	 * @return the fechaUltMod
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}
	/**
	 * @param fechaUltMod the fechaUltMod to set
	 */
	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}
	/**
	 * @return the usuarioUltMod
	 */
	public String getUsuarioUltMod() {
		return usuarioUltMod;
	}
	/**
	 * @param usuarioUltMod the usuarioUltMod to set
	 */
	public void setUsuarioUltMod(String usuarioUltMod) {
		this.usuarioUltMod = usuarioUltMod;
	}
	/**
	 * @return the latitudInicial
	 */
	public float getLatitudInicial() {
		return latitudInicial;
	}
	/**
	 * @param latitudInicial the latitudInicial to set
	 */
	public void setLatitudInicial(float latitudInicial) {
		this.latitudInicial = latitudInicial;
	}
	/**
	 * @return the longitudInicial
	 */
	public float getLongitudInicial() {
		return longitudInicial;
	}
	/**
	 * @param longitudInicial the longitudInicial to set
	 */
	public void setLongitudInicial(float longitudInicial) {
		this.longitudInicial = longitudInicial;
	}
	/**
	 * @return the latitudFinal
	 */
	public float getLatitudFinal() {
		return latitudFinal;
	}
	/**
	 * @param latitudFinal the latitudFinal to set
	 */
	public void setLatitudFinal(float latitudFinal) {
		this.latitudFinal = latitudFinal;
	}
	/**
	 * @return the longitudFinal
	 */
	public float getLongitudFinal() {
		return longitudFinal;
	}
	/**
	 * @param longitudFinal the longitudFinal to set
	 */
	public void setLongitudFinal(float longitudFinal) {
		this.longitudFinal = longitudFinal;
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
	 * @return the direccionInicial
	 */
	public String getDireccionInicial() {
		return direccionInicial;
	}
	/**
	 * @param direccionInicial the direccionInicial to set
	 */
	public void setDireccionInicial(String direccionInicial) {
		this.direccionInicial = direccionInicial;
	}
	/**
	 * @return the direccionFinal
	 */
	public String getDireccionFinal() {
		return direccionFinal;
	}
	/**
	 * @param direccionFinal the direccionFinal to set
	 */
	public void setDireccionFinal(String direccionFinal) {
		this.direccionFinal = direccionFinal;
	} 
}
