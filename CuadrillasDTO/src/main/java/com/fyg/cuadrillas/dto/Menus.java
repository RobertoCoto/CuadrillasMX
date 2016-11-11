package com.fyg.cuadrillas.dto;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class Menus extends ObjetoValor {
	/**
	 * SERIAL IUD
	 */
	private static final long serialVersionUID = 4344121314586766381L;
	private Integer id_padre;
	private String menu;
	private String descripcion;
	private String url;
	public Integer getId_padre() {
		return id_padre;
	}
	public void setId_padre(Integer id_padre) {
		this.id_padre = id_padre;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
}
