package com.fyg.cuadrillas.dto.menu;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class MenuDTO extends ObjetoValor {
	/**
	 * SERIAL IUD
	 */
	private static final long serialVersionUID = 4344121314586766381L;
	/**
	 * ID perfil
	 */
	private Integer idPerfil;
	/**
	 * id menu
	 */
	private Integer idMenuPerfil;
	/**
	 * Orden
	 */
	private Integer orden;
	/**
	 * Estatus del perfil
	 */
	private String estatusPerfil;
	/***
	 * id del menu 
	 */
	private String idMenu;
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
	 * estatus
	 */
	private String estatus;
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
	/**
	 * @return the idPerfil
	 */
	public Integer getIdPerfil() {
		return idPerfil;
	}
	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	/**
	 * @return the idMenuPerfil
	 */
	public Integer getIdMenuPerfil() {
		return idMenuPerfil;
	}
	/**
	 * @param idMenuPerfil the idMenuPerfil to set
	 */
	public void setIdMenuPerfil(Integer idMenuPerfil) {
		this.idMenuPerfil = idMenuPerfil;
	}
	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	/**
	 * @return the estatusPerfil
	 */
	public String getEstatusPerfil() {
		return estatusPerfil;
	}
	/**
	 * @param estatusPerfil the estatusPerfil to set
	 */
	public void setEstatusPerfil(String estatusPerfil) {
		this.estatusPerfil = estatusPerfil;
	}
	/**
	 * @return the idMenu
	 */
	public String getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
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
}
