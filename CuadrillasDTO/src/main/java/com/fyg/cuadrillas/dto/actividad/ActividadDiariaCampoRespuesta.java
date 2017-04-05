package com.fyg.cuadrillas.dto.actividad;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadDiariaCampoRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1997924974728983980L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** Lista actividad */
	private ActividadDiariaCampoDTO actividadDiaria;
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
	 * @return the actividadDiaria
	 */
	public ActividadDiariaCampoDTO getActividadDiaria() {
		return actividadDiaria;
	}

	/**
	 * @param actividadDiaria the actividadDiaria to set
	 */
	public void setActividadDiaria(ActividadDiariaCampoDTO actividadDiaria) {
		this.actividadDiaria = actividadDiaria;
	}
}
