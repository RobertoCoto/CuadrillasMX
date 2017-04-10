package com.fyg.cuadrillas.dto.actividad;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadDiariaDocumentosRespuesta extends ObjetoValor {

	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = 9066784413452518735L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** Lista actividad */
	private List<ActividadDiariaDocumentosDTO> documentos;
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
	 * @return the documentos
	 */
	public List<ActividadDiariaDocumentosDTO> getDocumentos() {
		return documentos;
	}

	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<ActividadDiariaDocumentosDTO> documentos) {
		this.documentos = documentos;
	}
}
