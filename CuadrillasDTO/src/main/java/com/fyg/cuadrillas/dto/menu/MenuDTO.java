package com.fyg.cuadrillas.dto.menu;

import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class MenuDTO extends ObjetoValor {
	/**
	 * SERIAL IUD
	 */
	private static final long serialVersionUID = 4344121314586766381L;
	/**
	 * Nombre del menu
	 */
	private Integer idMenu;
	/**
	 * Nombre del menu
	 */
	private Integer idPadre;
	/**
	 * Nombre del menu
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
	/** hijos Menu */
	private List<MenuDTO> hijos;
	/**
	 * @return the idMenu
	 */
	public Integer getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	/**
	 * @return the idPadre
	 */
	public Integer getIdPadre() {
		return idPadre;
	}
	/**
	 * @param idPadre the idPadre to set
	 */
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the hijos
	 */
	public List<MenuDTO> getHijos() {
		return hijos;
	}
	/**
	 * @param hijos the hijos to set
	 */
	public void setHijos(List<MenuDTO> hijos) {
		this.hijos = hijos;
	}
}
