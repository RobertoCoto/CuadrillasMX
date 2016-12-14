package com.fyg.cuadrillas.dto.actividad;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadRespuesta extends ObjetoValor{

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 5057405298186522048L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** Lista asistencia */
	private List<ActividadDTO> actividad;
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
	 * @return the actividad
	 */
	public List<ActividadDTO> getActividad() {
		return actividad;
	}
	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(List<ActividadDTO> actividad) {
		this.actividad = actividad;
	}
}
