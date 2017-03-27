package com.fyg.cuadrillas.dto.empleado;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class EmpleadoDocumentoRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -6490828723946619846L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** permiso */
	private List<EmpleadoDocumentoDTO> empleadoDocumento;
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
	 * @return the empleadoDocumento
	 */
	public List<EmpleadoDocumentoDTO> getEmpleadoDocumento() {
		return empleadoDocumento;
	}

	/**
	 * @param empleadoDocumento the empleadoDocumento to set
	 */
	public void setEmpleadoDocumento(List<EmpleadoDocumentoDTO> empleadoDocumento) {
		this.empleadoDocumento = empleadoDocumento;
	}
}
