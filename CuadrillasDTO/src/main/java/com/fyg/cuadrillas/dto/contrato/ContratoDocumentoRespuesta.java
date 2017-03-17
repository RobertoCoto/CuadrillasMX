package com.fyg.cuadrillas.dto.contrato;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class ContratoDocumentoRespuesta extends ObjetoValor{

	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = 6290573353579817118L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** lista*/
	private List<ContratoDocumentoDTO> contratoDocumento;
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
	 * @return the contratoDocumento
	 */
	public List<ContratoDocumentoDTO> getContratoDocumento() {
		return contratoDocumento;
	}

	/**
	 * @param contratoDocumento the contratoDocumento to set
	 */
	public void setContratoDocumento(List<ContratoDocumentoDTO> contratoDocumento) {
		this.contratoDocumento = contratoDocumento;
	}
}
