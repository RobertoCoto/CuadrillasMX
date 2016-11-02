package com.fyg.cuadrillas.dto;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class Usuario extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1571417524130812122L;
	/**
	 * Usuario
	 */
	private String usuario;
	/**
	 * Nombre del usuario
	 */
	private String nombre;
	/**
	 * Apellido Paterno del usuario
	 */
	private String apellido_pat;
	/**
	 * Apellido Materno del usuario
	 */
	private String apellido_mat;
	/**
	 * Sexo del usuario
	 */
	private char sexo;
	/**
	 * RFC del usuario
	 */
	private String rfc;
	/**
	 * rfc_calculado del usuario
	 */
	private String rfc_calculado;
	/**
	 * Curp del usuario
	 */
	private String curp;
	/**
	 * Fecha_nacimiento del usuario
	 */
	private Date fecha_nacimiento;
	/**
	 * Id unico del perfil
	 */
	private Integer id_perfil;
	/**
	 * Contrasena del usuario
	 */
	private String contrasena;
	/**
	 * Si cambia contrasena o no
	 */
	private char cambio_contrasena;
	/**
	 * Fecha_alta del usuario
	 */
	private Date fecha_alta;
	/**
	 * Fecha ultima modificacion
	 */
	private Date fecha_ult_mod;
	/**
	 * estatus del usuario
	 */
	private char estatus;
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
	 * @return obtiene el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre ingresa el nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return obtiene el apellido paterno
	 */
	public String getApellido_pat() {
		return apellido_pat;
	}
	/**
	 * @param apellido_pat ingresa el apellido paterno
	 */
	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}
	/**
	 * @return obtiene el apellido materno
	 */
	public String getApellido_mat() {
		return apellido_mat;
	}
	/**
	 * @param apellido_mat ingresa el apellido materno
	 */
	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}
	/**
	 * @return obtiene el sexo del usuario
	 */
	public char getSexo() {
		return sexo;
	}
	/**
	 * @param sexo ingresa el sexo del usuario
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return obtiene el rfc
	 */
	public String getRfc() {
		return rfc;
	}
	/**
	 * @param rfc ingresa el rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	/**
	 * @return obtiene el rfc calculado
	 */
	public String getRfc_calculado() {
		return rfc_calculado;
	}
	/**
	 * @param rfc_calculado ingresa el rfc calculado
	 */
	public void setRfc_calculado(String rfc_calculado) {
		this.rfc_calculado = rfc_calculado;
	}
	/**
	 * @return obtiene el curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp ingresa el curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 * @return obtiene la fecha
	 */
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	/**
	 * @param fecha_nacimiento ingresa la fecha
	 */
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	/**
	 * @return obtiene el id del perfil
	 */
	public Integer getId_perfil() {
		return id_perfil;
	}
	/**
	 * @param id_perfil ingresa el id del perfil
	 */
	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
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
	public char getCambio_contrasena() {
		return cambio_contrasena;
	}
	/**
	 * @param cambio_contrasena ingresa el cambio de contraseña
	 */
	public void setCambio_contrasena(char cambio_contrasena) {
		this.cambio_contrasena = cambio_contrasena;
	}
	/**
	 * @return obtiene la fecha de alta
	 */
	public Date getFecha_alta() {
		return fecha_alta;
	}
	/**
	 * @param fecha_alta ingresa la fecha de alta
	 */
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	/**
	 * @return obtiene la fecha de la ultima modificacion
	 */
	public Date getFecha_ult_mod() {
		return fecha_ult_mod;
	}
	/**
	 * @param fecha_ult_mod ingresa la fecha de la ultima mod
	 */
	public void setFecha_ult_mod(Date fecha_ult_mod) {
		this.fecha_ult_mod = fecha_ult_mod;
	}
	/**
	 * @return obtiene el estatus
	 */
	public char getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus ingresa el estatus
	 */
	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}
	}
