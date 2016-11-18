package com.fyg.cuadrillas.dto.menu;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;
import com.fyg.cuadrillas.dto.menu.MenuDTO;

public class MenuRespuesta extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -7062681654828548047L;
	/**
	 * Header
	 */
	private EncabezadoRespuesta header;
	/**
	 * Lista DTO usuario
	 */
    private List<MenuDTO> menu;
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	public List<MenuDTO> getMenu() {
		return menu;
	}
	public void setMenu(List<MenuDTO> menu) {
		this.menu = menu;
	}
}
