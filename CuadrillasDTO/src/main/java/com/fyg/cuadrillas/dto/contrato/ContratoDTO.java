package com.fyg.cuadrillas.dto.contrato;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ContratoDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1670407171238552004L;
	/**
	 * idContrato
	 */
	private Integer idContrato;
	/**
	 * numero del contrato
	 */
	private Integer numeroContrato;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * fecha del registro
	 */
	private Date fechaRegistro;
	/**
	 * id vialidad
	 */
	private Integer idVialidad;
	/**
	 * tramo inicial
	 */
	private String tramoInicial;
	/**
	 * tramo final
	 */
	private String tramoFinal;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * @return the idContrato
	 */
	public Integer getIdContrato() {
		return idContrato;
	}
	/**
	 * @param idContrato the idContrato to set
	 */
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	/**
	 * @return the numeroContrato
	 */
	public Integer getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
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
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	 * @return the tramoInicial
	 */
	public String getTramoInicial() {
		return tramoInicial;
	}
	/**
	 * @param tramoInicial the tramoInicial to set
	 */
	public void setTramoInicial(String tramoInicial) {
		this.tramoInicial = tramoInicial;
	}
	/**
	 * @return the tramoFinal
	 */
	public String getTramoFinal() {
		return tramoFinal;
	}
	/**
	 * @param tramoFinal the tramoFinal to set
	 */
	public void setTramoFinal(String tramoFinal) {
		this.tramoFinal = tramoFinal;
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
