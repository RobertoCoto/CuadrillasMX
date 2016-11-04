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
	private String contrasena;
	/**
	 * mensaje prueba
	 */
	private String mensaje;
	/**
	 * id unico prueba
	 */
	private Integer idPrueba;
	/**
	 * @return obtiene el usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario ingresa un usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	 * @return obtiene el msj
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje ingresa un msj
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return obtiene el id prueba
	 */
	public Integer getIdPrueba() {
		return idPrueba;
	}
	/**
	 * @param idPrueba ingresa el id prueba
	 */
	public void setIdPrueba(Integer idPrueba) {
		this.idPrueba = idPrueba;
	}
}
