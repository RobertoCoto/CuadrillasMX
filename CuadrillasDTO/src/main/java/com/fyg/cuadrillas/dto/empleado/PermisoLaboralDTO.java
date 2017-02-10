package com.fyg.cuadrillas.dto.empleado;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class PermisoLaboralDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -2088104195131297800L;
	/**
	 * id permiso
	 */
	private Integer idPermiso;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * comentarios
	 */
	private String  comentarios;
	/**
	 * goce de sueldo
	 */
	private String goceSueldo;
	/**
	 * Fecha solicitada
	 */
	private Date fechaSolicitada;
	/**
	 * fecha de la solicitud
	 */
	private String fechaSolicitud;
	/**
	 * rango de la fecha minima
	 */
	private String fechaSolicitudMinimo;
	/**
	 * rango de la fecha maximo
	 */
	private String fechaSolicitudMaximo;
	/**
	 * rango de la hora minimo
	 */
	private String horaSolicitudMinimo;
	/**
	 * rango de la hora maxima
	 */
	private String horaSolicitudMaxima;
	/**
	 * tipo de permiso
	 */
	private String codigoPermiso;
	/**
	 * estatus de la autorizacion
	 */
	private String autorizacion;
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
	 * estatus
	 */
	private String estatus;
	/**
	 * Usuario Autorizacion
	 */
	private String usuarioAutorizacion;
	/**
	 * fecha de la autorizacion
	 */
	private Date  fechaAutorizacion;
	/**
	 * estatus de la autorizacion
	 */
	private String estatusAutorizacion;
	/**
	 * @return the idPermiso
	 */
	public Integer getIdPermiso() {
		return idPermiso;
	}
	/**
	 * @param idPermiso the idPermiso to set
	 */
	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
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
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}
	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	/**
	 * @return the codigoPermiso
	 */
	public String getCodigoPermiso() {
		return codigoPermiso;
	}
	/**
	 * @param codigoPermiso the codigoPermiso to set
	 */
	public void setCodigoPermiso(String codigoPermiso) {
		this.codigoPermiso = codigoPermiso;
	}
	/**
	 * @return the autorizacion
	 */
	public String getAutorizacion() {
		return autorizacion;
	}
	/**
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
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
	 * @return the usuarioAutorizacion
	 */
	public String getUsuarioAutorizacion() {
		return usuarioAutorizacion;
	}
	/**
	 * @param usuarioAutorizacion the usuarioAutorizacion to set
	 */
	public void setUsuarioAutorizacion(String usuarioAutorizacion) {
		this.usuarioAutorizacion = usuarioAutorizacion;
	}
	/**
	 * @return the fechaAutorizacion
	 */
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}
	/**
	 * @return the estatusAutorizacion
	 */
	public String getEstatusAutorizacion() {
		return estatusAutorizacion;
	}
	/**
	 * @param estatusAutorizacion the estatusAutorizacion to set
	 */
	public void setEstatusAutorizacion(String estatusAutorizacion) {
		this.estatusAutorizacion = estatusAutorizacion;
	}
	/**
	 * @return the fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	/**
	 * @return the fechaSolicitudMinimo
	 */
	public String getFechaSolicitudMinimo() {
		return fechaSolicitudMinimo;
	}
	/**
	 * @param fechaSolicitudMinimo the fechaSolicitudMinimo to set
	 */
	public void setFechaSolicitudMinimo(String fechaSolicitudMinimo) {
		this.fechaSolicitudMinimo = fechaSolicitudMinimo;
	}
	/**
	 * @return the fechaSolicitudMaximo
	 */
	public String getFechaSolicitudMaximo() {
		return fechaSolicitudMaximo;
	}
	/**
	 * @param fechaSolicitudMaximo the fechaSolicitudMaximo to set
	 */
	public void setFechaSolicitudMaximo(String fechaSolicitudMaximo) {
		this.fechaSolicitudMaximo = fechaSolicitudMaximo;
	}
	/**
	 * @return the horaSolicitudMinimo
	 */
	public String getHoraSolicitudMinimo() {
		return horaSolicitudMinimo;
	}
	/**
	 * @param horaSolicitudMinimo the horaSolicitudMinimo to set
	 */
	public void setHoraSolicitudMinimo(String horaSolicitudMinimo) {
		this.horaSolicitudMinimo = horaSolicitudMinimo;
	}
	/**
	 * @return the horaSolicitudMaxima
	 */
	public String getHoraSolicitudMaxima() {
		return horaSolicitudMaxima;
	}
	/**
	 * @param horaSolicitudMaxima the horaSolicitudMaxima to set
	 */
	public void setHoraSolicitudMaxima(String horaSolicitudMaxima) {
		this.horaSolicitudMaxima = horaSolicitudMaxima;
	}
	/**
	 * @return the goceSueldo
	 */
	public String getGoceSueldo() {
		return goceSueldo;
	}
	/**
	 * @param goceSueldo the goceSueldo to set
	 */
	public void setGoceSueldo(String goceSueldo) {
		this.goceSueldo = goceSueldo;
	}
	/**
	 * @return the fechaSolicitada
	 */
	public Date getFechaSolicitada() {
		return fechaSolicitada;
	}
	/**
	 * @param fechaSolicitada the fechaSolicitada to set
	 */
	public void setFechaSolicitada(Date fechaSolicitada) {
		this.fechaSolicitada = fechaSolicitada;
	}
}
