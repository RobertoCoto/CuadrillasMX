package com.fyg.cuadrillas.dto.empleado;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class EmpleadoHuellaRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4560503549889746712L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** catalogo */
	private EmpleadoHuellaDTO empleadoHuella;
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
	public EmpleadoHuellaDTO getEmpleadoHuella() {
		return empleadoHuella;
	}
	public void setEmpleadoHuella(EmpleadoHuellaDTO empleadoHuella) {
		this.empleadoHuella = empleadoHuella;
	}
}
