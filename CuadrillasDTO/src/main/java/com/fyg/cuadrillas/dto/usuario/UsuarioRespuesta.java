package com.fyg.cuadrillas.dto.usuario;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;
import com.fyg.cuadrillas.dto.menu.MenuDTO;

public class UsuarioRespuesta extends ObjetoValor {

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
    private UsuarioDTO usuario;
    /**
	 * Lista DTO usuario
	 */
    private List<MenuDTO> menu;
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the usuario
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the menu
	 */
	public List<MenuDTO> getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(List<MenuDTO> menu) {
		this.menu = menu;
	}
}
