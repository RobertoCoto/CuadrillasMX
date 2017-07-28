package com.fyg.cuadrillas.dto.reporte;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class RespuestaReporteDTO  extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1385026523328963459L;
	/** header */
	private EncabezadoRespuesta header;
	/** reporte */
	private List<ReporteDTO> reporte;
	/** encabezado */
	private List<String> encabezado;
	
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
	 * @return the reporte
	 */
	public List<ReporteDTO> getReporte() {
		return reporte;
	}
	/**
	 * @param reporte the reporte to set
	 */
	public void setReporte(List<ReporteDTO> reporte) {
		this.reporte = reporte;
	}
	/**
	 * @return the encabezado
	 */
	public List<String> getEncabezado() {
		return encabezado;
	}
	/**
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(List<String> encabezado) {
		this.encabezado = encabezado;
	}

}
