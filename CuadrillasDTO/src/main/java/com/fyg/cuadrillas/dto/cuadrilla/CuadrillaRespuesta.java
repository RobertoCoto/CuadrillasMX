package com.fyg.cuadrillas.dto.cuadrilla;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class CuadrillaRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4102824258640948530L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** lista*/
	private List<CuadrillaDTO> cuadrilla;
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
	 * @return the cuadrilla
	 */
	public List<CuadrillaDTO> getCuadrilla() {
		return cuadrilla;
	}
	/**
	 * @param cuadrilla the cuadrilla to set
	 */
	public void setCuadrilla(List<CuadrillaDTO> cuadrilla) {
		this.cuadrilla = cuadrilla;
	}
}
