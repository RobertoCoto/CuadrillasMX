package com.fyg.cuadrillas.dto.empleado;

import java.sql.Blob;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class EmpleadoHuellaDTO extends ObjetoValor {

	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = -5574113039909107757L;
	/**
	 * id de la huella
	 */
	private Integer idHuella;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * imagen huella
	 */
	private Blob huella;
	/**
	 * codigo mano
	 */
	private String codigoMano;
	/**
	 * codigo dedo
	 */
	private String codigoDedo;
	/**
	 * estatus de la huella
	 */
	private String estatus;
	/**
	 * @return the idHuella
	 */
	public Integer getIdHuella() {
		return idHuella;
	}
	/**
	 * @param idHuella the idHuella to set
	 */
	public void setIdHuella(Integer idHuella) {
		this.idHuella = idHuella;
	}
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
	 * @return the huella
	 */
	public Blob getHuella() {
		return huella;
	}
	/**
	 * @param huella the huella to set
	 */
	public void setHuella(Blob huella) {
		this.huella = huella;
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
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}
