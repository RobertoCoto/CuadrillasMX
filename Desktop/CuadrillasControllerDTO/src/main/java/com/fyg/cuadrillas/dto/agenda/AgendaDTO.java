package com.fyg.cuadrillas.dto.agenda;

import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;

public class AgendaDTO extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 356484323175106651L;

	/** idAgenda */
	private Integer idAgenda;
	/**idContrato */
	private Integer idContrato;
	/**idCuadrilla */
	private Integer idCuadrilla;
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
	/** coordenadas */
	private List<CoordenadaDTO> coordenadas;
	/** fechaFin */
	private String usuario;
	/**
	 * id agenda detalle
	 */
	private Integer idAgendaDetalle;
	/**
	 * agendaDetalle
	 */
	private Integer agendaDetalle;
	/**
	 * fecha agenda
	 */
	private String fechaAgenda;
	/**
	 * avance
	 */
	private Integer avanceEsperado;
	/**
	 * obsevraciones
	 */
	private String observacionesDetalle;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * fecha para la busqueda
	 */
	private String fechaBusqueda;
	/**
	 * @return the idAgenda
	 */
	public Integer getIdAgenda() {
		return idAgenda;
	}
	/**
	 * @param idAgenda the idAgenda to set
	 */
	public void setIdAgenda(Integer idAgenda) {
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
	/**
	 * @return the coordenadas
	 */
	public List<CoordenadaDTO> getCoordenadas() {
		return coordenadas;
	}
	/**
	 * @param coordenadas the coordenadas to set
	 */
	public void setCoordenadas(List<CoordenadaDTO> coordenadas) {
		this.coordenadas = coordenadas;
	}
	/**
	 * @return the idAgendaDetalle
	 */
	public Integer getIdAgendaDetalle() {
		return idAgendaDetalle;
	}
	/**
	 * @param idAgendaDetalle the idAgendaDetalle to set
	 */
	public void setIdAgendaDetalle(Integer idAgendaDetalle) {
		this.idAgendaDetalle = idAgendaDetalle;
	}
	/**
	 * @return the fechaAgenda
	 */
	public String getFechaAgenda() {
		return fechaAgenda;
	}
	/**
	 * @param fechaAgenda the fechaAgenda to set
	 */
	public void setFechaAgenda(String fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}
	/**
	 * @return the avanceEsperado
	 */
	public Integer getAvanceEsperado() {
		return avanceEsperado;
	}
	/**
	 * @param avanceEsperado the avanceEsperado to set
	 */
	public void setAvanceEsperado(Integer avanceEsperado) {
		this.avanceEsperado = avanceEsperado;
	}
	/**
	 * @return the observacionesDetalle
	 */
	public String getObservacionesDetalle() {
		return observacionesDetalle;
	}
	/**
	 * @param observacionesDetalle the observacionesDetalle to set
	 */
	public void setObservacionesDetalle(String observacionesDetalle) {
		this.observacionesDetalle = observacionesDetalle;
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
	/**
	 * @return the agendaDetalle
	 */
	public Integer getAgendaDetalle() {
		return agendaDetalle;
	}
	/**
	 * @param agendaDetalle the agendaDetalle to set
	 */
	public void setAgendaDetalle(Integer agendaDetalle) {
		this.agendaDetalle = agendaDetalle;
	}
	/**
	 * @return the fechaBusqueda
	 */
	public String getFechaBusqueda() {
		return fechaBusqueda;
	}
	/**
	 * @param fechaBusqueda the fechaBusqueda to set
	 */
	public void setFechaBusqueda(String fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
	/**
	 * @return the idCuadrilla
	 */
	public Integer getIdCuadrilla() {
		return idCuadrilla;
	}
	/**
	 * @param idCuadrilla the idCuadrilla to set
	 */
	public void setIdCuadrilla(Integer idCuadrilla) {
		this.idCuadrilla = idCuadrilla;
	}

}
