package com.fyg.cuadrillas.dto.agenda;

import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;

public class AgendaDTO extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 356484323175106651L;

	/** idAgenda */
	private int idAgenda;
	/**idContrato*/
	private Integer idContrato;
	/** contrato */
	private ContratoDTO contrato;
	/** fechaInicio */
	private String fechaInicio;
	/** fechaFin */
	private String fechaFin;
	/** noSemana */
	private int noSemana;
	/** noTrabajadores */
	private int noTrabajadores;
	/** noHoras */
	private int noHoras;
	/** diasAgenda */
	private List<AgendaDetalleDTO> diasAgenda;
	/** fechaFin */
	private String usuario;

	/**
	 * @return the idAgenda
	 */
	public int getIdAgenda() {
		return idAgenda;
	}
	/**
	 * @param idAgenda the idAgenda to set
	 */
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	/**
	 * @return the contrato
	 */
	public ContratoDTO getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(ContratoDTO contrato) {
		this.contrato = contrato;
	}
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
	/**
	 * @return the noSemana
	 */
	public int getNoSemana() {
		return noSemana;
	}
	/**
	 * @param noSemana the noSemana to set
	 */
	public void setNoSemana(int noSemana) {
		this.noSemana = noSemana;
	}
	/**
	 * @return the diasAgenda
	 */
	public List<AgendaDetalleDTO> getDiasAgenda() {
		return diasAgenda;
	}
	/**
	 * @param diasAgenda the diasAgenda to set
	 */
	public void setDiasAgenda(List<AgendaDetalleDTO> diasAgenda) {
		this.diasAgenda = diasAgenda;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the noTrabajadores
	 */
	public int getNoTrabajadores() {
		return noTrabajadores;
	}
	/**
	 * @param noTrabajadores the noTrabajadores to set
	 */
	public void setNoTrabajadores(int noTrabajadores) {
		this.noTrabajadores = noTrabajadores;
	}
	/**
	 * @return the noHoras
	 */
	public int getNoHoras() {
		return noHoras;
	}
	/**
	 * @param noHoras the noHoras to set
	 */
	public void setNoHoras(int noHoras) {
		this.noHoras = noHoras;
	}
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
}
