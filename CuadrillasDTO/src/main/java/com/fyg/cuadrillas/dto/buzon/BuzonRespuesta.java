package com.fyg.cuadrillas.dto.buzon;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class BuzonRespuesta  extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -7728390602571436546L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** catalogo */
	private List<BuzonDTO> buzon;
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
	 * @return the buzon
	 */
	public List<BuzonDTO> getBuzon() {
		return buzon;
	}

	/**
	 * @param buzon the buzon to set
	 */
	public void setBuzon(List<BuzonDTO> buzon) {
		this.buzon = buzon;
	}
}
