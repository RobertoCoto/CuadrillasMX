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
     * lista de usuarios
     */
    private List<UsuarioDTO> lista;
    /**
	 * Lista DTO usuario
	 */
    private List<MenuDTO> menu;
    /**
	 * Estatus
	 */
	private boolean estatus;
	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
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
	/**
	 * @return the lista
	 */
	public List<UsuarioDTO> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<UsuarioDTO> lista) {
		this.lista = lista;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
