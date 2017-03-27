package com.fyg.cuadrillas.dto.catalogo;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class TipoCatalogoRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4048797337446381277L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** catalogo */
	private List<TipoCatalogoDTO> catalogo;
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
	 * @return the catalogo
	 */
	public List<TipoCatalogoDTO> getCatalogo() {
		return catalogo;
	}
	/**
	 * @param catalogo the catalogo to set
	 */
	public void setCatalogo(List<TipoCatalogoDTO> catalogo) {
		this.catalogo = catalogo;
	}

}
