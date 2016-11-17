package com.fyg.cuadrillas.dto;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class Parametro extends ObjetoValor {

	/**
	 * UID Unico
	 */
	private static final long serialVersionUID = 5725735561455512596L;
	/**
	 * parametro
	 */
	private String parametro;
	/**
	 * Valor del parametro
	 */
    private String valor;
    /**
     * @return obtiene el valor del parametro
     */
	public String getValor() {
		return valor;
	}
	/**
	 * @return obtiene el parametro
	 */
	public String getParametro() {
		return parametro;
	}
	/**
	 * @param parametro ingresa un parametro
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
}
