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
	 * fecha de la solicitud
	 */
	private Date fechaSolicitud;
	/**
	 * rango de la fecha minima
	 */
	private Date fechaSolicitudMinimo;
	/**
	 * rango de la fecha maximo
	 */
	private Date fechaSolicitudMaximo;
	/**
	 * rango de la hora minimo
	 */
	private Date horaSolicitudMinimo;
	/**
	 * rango de la hora maxima
	 */
	private Date horaSolicitudMaxima;
	/**
	 * tipo de permiso
	 */
	private String tipoPermiso;
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
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	/**
	 * @return the fechaSolicitudMinimo
	 */
	public Date getFechaSolicitudMinimo() {
		return fechaSolicitudMinimo;
	}
	/**
	 * @param fechaSolicitudMinimo the fechaSolicitudMinimo to set
	 */
	public void setFechaSolicitudMinimo(Date fechaSolicitudMinimo) {
		this.fechaSolicitudMinimo = fechaSolicitudMinimo;
	}
	/**
	 * @return the fechaSolicitudMaximo
	 */
	public Date getFechaSolicitudMaximo() {
		return fechaSolicitudMaximo;
	}
	/**
	 * @param fechaSolicitudMaximo the fechaSolicitudMaximo to set
	 */
	public void setFechaSolicitudMaximo(Date fechaSolicitudMaximo) {
		this.fechaSolicitudMaximo = fechaSolicitudMaximo;
	}
	
	/**
	 * @return the tipoPermiso
	 */
	public String getTipoPermiso() {
		return tipoPermiso;
	}
	/**
	 * @param tipoPermiso the tipoPermiso to set
	 */
	public void setTipoPermiso(String tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
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
	 * @return the horaSolicitudMinimo
	 */
	public Date getHoraSolicitudMinimo() {
		return horaSolicitudMinimo;
	}
	/**
	 * @param horaSolicitudMinimo the horaSolicitudMinimo to set
	 */
	public void setHoraSolicitudMinimo(Date horaSolicitudMinimo) {
		this.horaSolicitudMinimo = horaSolicitudMinimo;
	}
	/**
	 * @return the horaSolicitudMaxima
	 */
	public Date getHoraSolicitudMaxima() {
		return horaSolicitudMaxima;
	}
	/**
	 * @param horaSolicitudMaxima the horaSolicitudMaxima to set
	 */
	public void setHoraSolicitudMaxima(Date horaSolicitudMaxima) {
		this.horaSolicitudMaxima = horaSolicitudMaxima;
	} 
}
