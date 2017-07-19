package com.fyg.cuadrillas.dto.asistencia;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class RegistroHuella extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5334477672606588350L;
	/** idEmpleado */
	private Integer idEmpleado;
	/** fileEncoded */
	private String fileEncoded;
	/** codigoMano */
	private String codigoMano;
	/** codigoDedo */
	private String codigoDedo;
	/** fileName */
	private String fileName;

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

	/**
	 * @return the codigoMano
	 */
	public String getCodigoMano() {
		return codigoMano;
	}

	/**
	 * @param codigoMano the codigoMano to set
	 */
	public void setCodigoMano(String codigoMano) {
		this.codigoMano = codigoMano;
	}

	/**
	 * @return the codigoDedo
	 */
	public String getCodigoDedo() {
		return codigoDedo;
	}

	/**
	 * @param codigoDedo the codigoDedo to set
	 */
	public void setCodigoDedo(String codigoDedo) {
		this.codigoDedo = codigoDedo;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
