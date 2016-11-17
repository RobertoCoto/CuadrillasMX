package com.fyg.cuadrillas.dto;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class MenuDTO extends ObjetoValor {
	/**
	 * SERIAL IUD
	 */
	private static final long serialVersionUID = 4344121314586766381L;
	/**
	 * ID padre
	 */
	private Integer idPadre;
	/**
	 * Menu
	 */
	private String menu;
	/**
	 * Descripcion del menu
	 */
	private String descripcion;
	/**
	 * Url del menu
	 */
	private String url;
	/**
	 * @return obtiene el id padre
	 */
	public Integer getIdPadre() {
		return idPadre;
	}
	/**
	 * @param idPadre ingresa el id_padre
	 */
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	/**
	 * @return obtiene el menu
	 */
	public String getMenu() {
		return menu;
	}
	/**
	 * @param menu ingresa el menu
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
	/**
	 * @return obtiene la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion ingresa la descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return obtiene la url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url ingresa la url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
