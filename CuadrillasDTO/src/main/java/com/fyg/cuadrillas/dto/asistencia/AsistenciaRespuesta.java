package com.fyg.cuadrillas.dto.asistencia;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class AsistenciaRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -679840902203050424L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** Lista asistencia */
	private List<AsistenciaDTO> asistencia;
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
	 * @return the asistencia
	 */
	public List<AsistenciaDTO> getAsistencia() {
		return asistencia;
	}
	/**
	 * @param asistencia the asistencia to set
	 */
	public void setAsistencia(List<AsistenciaDTO> asistencia) {
		this.asistencia = asistencia;
	}
}
