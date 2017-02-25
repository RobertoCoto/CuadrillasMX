package com.fyg.cuadrillas.dto.agenda;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class AgendaRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** catalogo */
	private List<AgendaDTO> agenda;
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
	 * @return the agenda
	 */
	public List<AgendaDTO> getAgenda() {
		return agenda;
	}

	/**
	 * @param agenda the agenda to set
	 */
	public void setAgenda(List<AgendaDTO> agenda) {
		this.agenda = agenda;
	}
}
