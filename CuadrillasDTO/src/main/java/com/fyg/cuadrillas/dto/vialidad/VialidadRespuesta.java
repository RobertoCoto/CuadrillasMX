package com.fyg.cuadrillas.dto.vialidad;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;
public class VialidadRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4713426097525848471L;
	/**
	 * Header
	 */
	private EncabezadoRespuesta header;
	/** vialidad */
	private List<VialidadDTO> vialidad;
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
	 * @return the vialidad
	 */
	public List<VialidadDTO> getVialidad() {
		return vialidad;
	}
	/**
	 * @param vialidad the vialidad to set
	 */
	public void setVialidad(List<VialidadDTO> vialidad) {
		this.vialidad = vialidad;
	}
}
