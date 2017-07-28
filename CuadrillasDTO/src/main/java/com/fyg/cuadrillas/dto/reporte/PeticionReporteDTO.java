package com.fyg.cuadrillas.dto.reporte;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class PeticionReporteDTO  extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7059581859293650623L;
	private String fechaInicio;
	private String fechaFin;
	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
