package com.fyg.cuadrillas.dto.usuario;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

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
    private List<UsuarioDTO> usuario;
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
	public List<UsuarioDTO> getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<UsuarioDTO> usuario) {
		this.usuario = usuario;
	}
}
