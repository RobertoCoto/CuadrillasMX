package com.fyg.cuadrillas.dto.usuario;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class UsuarioDTO extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1571417524130812122L;
	/**
	 * Usuario
	 */
	private String usuario;
	/**
	 * Id unico del perfil
	 */
	private Integer idPerfil;
	/**
	 * Contrasena del usuario
	 */
	private String contrasena;
	/**
	 * Si cambia contrasena o no
	 */
	private String cambioContrasena;
	/**
	 * Fecha de ultimo acceso
	 */
	private Date fechaUltimoAcceso;
	/**
	 * Fecha_alta del usuario
	 */
	private Date fechaAlta;
	/**
	 * Fecha ultima modificacion
	 */
	private Date fechaUltMod;
	/**
	 * estatus del usuario
	 */
	private String estatus;
	/**
	 * @return obtiene el usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario ingresa el  usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return obtiene el id del perfil
	 */
	public Integer getIdPerfil() {
		return idPerfil;
	}
	/**
	 * @param idPerfil ingresa el id del perfil
	 */
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	/**
	 * @return obtiene la contraseña
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena ingresa la contraseña
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @return obtiene el cambio de contraseña
	 */
	public String getCambioContrasena() {
		return cambioContrasena;
	}
	/**
	 * @param cambioContrasena ingresa el cambio de contraseña
	 */
	public void setCambioContrasena(String cambioContrasena) {
		this.cambioContrasena = cambioContrasena;
	}
	/**
	 * @return regresa la fecha de alta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta ingresa la fecha de alta
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return regresa la fecha de ult mod.
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}
	/**
	 * @param fechaUltMod ingresa la fecha ult. mod
	 */
	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}
	/**
	 * @return obtiene el estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus ingresa el estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the fechaUltimoAcceso
	 */
	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	/**
	 * @param fechaUltimoAcceso the fechaUltimoAcceso to set
	 */
	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}
	}
