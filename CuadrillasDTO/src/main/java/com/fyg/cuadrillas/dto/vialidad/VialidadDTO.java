package com.fyg.cuadrillas.dto.vialidad;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class VialidadDTO extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 3331921401884009464L;
	/**
	 * id de la vialidad
	 */
	private Integer idVialidad;
	/**
	 * nombre de la vialidad
	 */
	private String nombre;
	/**
	 * usuario alta
	 */
	private String usuarioAlta;
	/**
	 * fecha de alta
	 */
	private Date fechaAlta;
	/** 
	 * usuario Baja
	 */
	private String usuarioBaja;
	/**
	 * Fecha de baja
	 */
	private Date fechaBaja;
	/**
	 * usuario ultima modificacion
	 */
	private String usuarioUltMod;
	/**
	 * fecha ult modificacion
	 */
	private Date fechaUltMod;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * Orden 
	 */
	private String orden;
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
	 * @return the orden
	 */
	public String getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}
}
