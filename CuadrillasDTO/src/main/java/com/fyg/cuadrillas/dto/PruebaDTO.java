package com.fyg.cuadrillas.dto;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class PruebaDTO extends ObjetoValor {

	/**
	 * Default Generated ID
	 */
	private static final long serialVersionUID = 7415283443636800489L;
	/**
	 * usuario prueba
	 */
	private String usuario;
	/**
	 * contraseña prueba;
	 */
	private String contraseña;
	/**
	 * mensaje prueba
	 */
	private String mensaje;
	/**
	 * id unico prueba
	 */
	private Integer idPrueba;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getIdPrueba() {
		return idPrueba;
	}
	public void setIdPrueba(Integer idPrueba) {
		this.idPrueba = idPrueba;
	}
}
