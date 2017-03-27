package com.fyg.cuadrillas.dto.vialidad;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class VialidadCoordenadasRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 9163911224204979146L;
	/**
	 * Header
	 */
	private EncabezadoRespuesta header;
	/** vialidad Coordenadas */
	private List<VialidadCoordenadasDTO> coordenadas;
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
	 * @return the coordenadas
	 */
	public List<VialidadCoordenadasDTO> getCoordenadas() {
		return coordenadas;
	}

	/**
	 * @param coordenadas the coordenadas to set
	 */
	public void setCoordenadas(List<VialidadCoordenadasDTO> coordenadas) {
		this.coordenadas = coordenadas;
	}
}
