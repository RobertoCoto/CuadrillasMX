package com.fyg.cuadrillas.dto.actividad;

import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadDiariaCampoDTO extends ObjetoValor{

	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = 4235971882930461423L;
	/**id actividad*/
	private Integer idActividadDiaria;
	/** id de la agenda*/
	private Integer idAgenda;
	/**id de la agenda detalle*/
	private Integer idAgendaDetalle;
	/** metros planificados*/
	private Float metrosPlanificado;
	/** no trabajadores*/
	private Integer noTrabajadores;
	/**numero de horas*/
	private Integer noHoras;
	/** numero de horas trabajadas*/
	private Integer noHorasTrabajadas;
	/** porcentaje*/
	private Float porcentaje;
	/** observaciones*/
	private String observaciones;
	/** envio autorizacion*/
	private String envioAutorizacion;
	/** envio usuario Autorizacion*/
	private String envioUsuarioAutorizacion;
	/** autorizacion*/
	private String autorizacion;
	/** fecha de la autorizacion*/
	private String fechaAutorizacion;
	/** comentarios autorizacion*/
	private String comentarioAutorizacion;
	/** lista de actividades diaria detalle*/
	private List<ActividadDiariaDetalleDTO> actividadDiariaDetalle;
	/** estatus*/
	private String estatus;
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
	 * @return the metrosPlanificado
	 */
	public Float getMetrosPlanificado() {
		return metrosPlanificado;
	}
	/**
	 * @param metrosPlanificado the metrosPlanificado to set
	 */
	public void setMetrosPlanificado(Float metrosPlanificado) {
		this.metrosPlanificado = metrosPlanificado;
	}
	/**
	 * @return the noTrabajadores
	 */
	public Integer getNoTrabajadores() {
		return noTrabajadores;
	}
	/**
	 * @param noTrabajadores the noTrabajadores to set
	 */
	public void setNoTrabajadores(Integer noTrabajadores) {
		this.noTrabajadores = noTrabajadores;
	}
	/**
	 * @return the noHoras
	 */
	public Integer getNoHoras() {
		return noHoras;
	}
	/**
	 * @param noHoras the noHoras to set
	 */
	public void setNoHoras(Integer noHoras) {
		this.noHoras = noHoras;
	}
	/**
	 * @return the noHorasTrabajadas
	 */
	public Integer getNoHorasTrabajadas() {
		return noHorasTrabajadas;
	}
	/**
	 * @param noHorasTrabajadas the noHorasTrabajadas to set
	 */
	public void setNoHorasTrabajadas(Integer noHorasTrabajadas) {
		this.noHorasTrabajadas = noHorasTrabajadas;
	}
	/**
	 * @return the porcentaje
	 */
	public Float getPorcentaje() {
		return porcentaje;
	}
	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(Float porcentaje) {
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
	 * @return the envioAutorizacion
	 */
	public String getEnvioAutorizacion() {
		return envioAutorizacion;
	}
	/**
	 * @param envioAutorizacion the envioAutorizacion to set
	 */
	public void setEnvioAutorizacion(String envioAutorizacion) {
		this.envioAutorizacion = envioAutorizacion;
	}
	/**
	 * @return the envioUsuarioAutorizacion
	 */
	public String getEnvioUsuarioAutorizacion() {
		return envioUsuarioAutorizacion;
	}
	/**
	 * @param envioUsuarioAutorizacion the envioUsuarioAutorizacion to set
	 */
	public void setEnvioUsuarioAutorizacion(String envioUsuarioAutorizacion) {
		this.envioUsuarioAutorizacion = envioUsuarioAutorizacion;
	}
	/**
	 * @return the autorizacion
	 */
	public String getAutorizacion() {
		return autorizacion;
	}
	/**
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}
	/**
	 * @return the fechaAutorizacion
	 */
	public String getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(String fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
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
	 * @return the actividadDiariaDetalle
	 */
	public List<ActividadDiariaDetalleDTO> getActividadDiariaDetalle() {
		return actividadDiariaDetalle;
	}
	/**
	 * @param actividadDiariaDetalle the actividadDiariaDetalle to set
	 */
	public void setActividadDiariaDetalle(
			List<ActividadDiariaDetalleDTO> actividadDiariaDetalle) {
		this.actividadDiariaDetalle = actividadDiariaDetalle;
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
