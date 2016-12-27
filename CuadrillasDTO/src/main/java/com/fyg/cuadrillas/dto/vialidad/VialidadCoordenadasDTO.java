package com.fyg.cuadrillas.dto.vialidad;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class VialidadCoordenadasDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 2069351886963162085L;
	/**
	 * id de las coordenadas
	 */
	private Integer idCoordenada;
	/**
	 * id de la vialidad
	 */
	private Integer idVialidad;
	/**
	 * latitud
	 */
	private Float latitud;
	/**
	 * lingitud
	 */
	private Float longitud;
	/**
	 * @return the idCoordenada
	 */
	public Integer getIdCoordenada() {
		return idCoordenada;
	}
	/**
	 * @param idCoordenada the idCoordenada to set
	 */
	public void setIdCoordenada(Integer idCoordenada) {
		this.idCoordenada = idCoordenada;
	}
	/**
	 * @return the idVialidad
	 */
	public Integer getIdVialidad() {
		return idVialidad;
	}
	/**
	 * @param idVialidad the idVialidad to set
	 */
	public void setIdVialidad(Integer idVialidad) {
		this.idVialidad = idVialidad;
	}
	/**
	 * @return the latitud
	 */
	public Float getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public Float getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
}
