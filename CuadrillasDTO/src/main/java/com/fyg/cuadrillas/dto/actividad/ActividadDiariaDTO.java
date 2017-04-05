package com.fyg.cuadrillas.dto.actividad;

import com.fyg.cuadrillas.comun.ObjetoValor;

/**
 * @author rcoto
 *
 */
public class ActividadDiariaDTO  extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6352419475061741724L;
	/** idActividadDiaria */
	private Integer idActividadDiaria;
	/** idAgenda */
	private Integer idAgenda;
	/** idAgendaDetalle */
	private Integer idAgendaDetalle;
	/** metrosPlanificados */
	private float metrosPlanificados;
	/** noTrabajadores */
	private int noTrabajadores;
	/** noHoras */
	private int noHoras;
	/** noHorasTrabajadas */
	private int noHorasTrabajadas;
	/** porcentaje */
	private float porcentaje;
	/** observaciones */
	private String observaciones;
	/** observaciones */
	private String comentarioAutorizacion;
	/** Usuario alta */
	private String usuarioAlta;
	/**
	 * @return the idActividadDiaria
	 */
	public Integer getIdActividadDiaria() {
		return idActividadDiaria;
	}
	/**
	 * @param idActividadDiaria the idActividadDiaria to set
	 */
	public void setIdActividadDiaria(Integer idActividadDiaria) {
		this.idActividadDiaria = idActividadDiaria;
	}
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
	 * @return the metrosPlanificados
	 */
	public float getMetrosPlanificados() {
		return metrosPlanificados;
	}
	/**
	 * @param metrosPlanificados the metrosPlanificados to set
	 */
	public void setMetrosPlanificados(float metrosPlanificados) {
		this.metrosPlanificados = metrosPlanificados;
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
	 * @return the noHorasTrabajadas
	 */
	public int getNoHorasTrabajadas() {
		return noHorasTrabajadas;
	}
	/**
	 * @param noHorasTrabajadas the noHorasTrabajadas to set
	 */
	public void setNoHorasTrabajadas(int noHorasTrabajadas) {
		this.noHorasTrabajadas = noHorasTrabajadas;
	}
	/**
	 * @return the porcentaje
	 */
	public float getPorcentaje() {
		return porcentaje;
	}
	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the comentarioAutorizacion
	 */
	public String getComentarioAutorizacion() {
		return comentarioAutorizacion;
	}
	/**
	 * @param comentarioAutorizacion the comentarioAutorizacion to set
	 */
	public void setComentarioAutorizacion(String comentarioAutorizacion) {
		this.comentarioAutorizacion = comentarioAutorizacion;
	}
	/**
	 * @return the usuarioAlta
	 */
	public String getUsuarioAlta() {
		return usuarioAlta;
	}
	/**
	 * @param usuarioAlta the usuarioAlta to set
	 */
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}
}
