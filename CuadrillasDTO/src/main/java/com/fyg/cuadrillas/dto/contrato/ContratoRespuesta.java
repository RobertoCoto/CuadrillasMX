package com.fyg.cuadrillas.dto.contrato;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class ContratoRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8383409622284773014L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** lista*/
	private List<ContratoDTO> contrato;
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
	 * @return the contrato
	 */
	public List<ContratoDTO> getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(List<ContratoDTO> contrato) {
		this.contrato = contrato;
	}
}
