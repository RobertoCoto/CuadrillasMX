package com.fyg.cuadrillas.dto.herramienta;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class HerramientaRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -6464456034296854303L;
	private EncabezadoRespuesta header;
	/** Herramienta */
	private List<HerramientaDTO> herramienta;
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
	 * @return the herramienta
	 */
	public List<HerramientaDTO> getHerramienta() {
		return herramienta;
	}
	/**
	 * @param herramienta the herramienta to set
	 */
	public void setHerramienta(List<HerramientaDTO> herramienta) {
		this.herramienta = herramienta;
	}
}
