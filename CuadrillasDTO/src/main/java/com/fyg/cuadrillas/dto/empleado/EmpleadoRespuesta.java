package com.fyg.cuadrillas.dto.empleado;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class EmpleadoRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1157140777888913795L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** catalogo */
	private List<EmpleadoDTO> empleado;
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
	 * @return the empleado
	 */
	public List<EmpleadoDTO> getEmpleado() {
		return empleado;
	}
	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(List<EmpleadoDTO> empleado) {
		this.empleado = empleado;
	}
}
