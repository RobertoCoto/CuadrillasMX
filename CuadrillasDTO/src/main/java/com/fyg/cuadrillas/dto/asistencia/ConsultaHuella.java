package com.fyg.cuadrillas.dto.asistencia;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ConsultaHuella extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 958551450548051024L;
	/** idEmpleado */
	private Integer idEmpleado;
	/** fileEncoded */
	private String fileEncoded;
	/**
	 * @return the idEmpleado
	 */
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * @return the fileEncoded
	 */
	public String getFileEncoded() {
		return fileEncoded;
	}
	/**
	 * @param fileEncoded the fileEncoded to set
	 */
	public void setFileEncoded(String fileEncoded) {
		this.fileEncoded = fileEncoded;
	}
}
