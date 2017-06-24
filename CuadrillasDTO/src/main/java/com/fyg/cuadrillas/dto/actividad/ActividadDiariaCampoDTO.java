package com.fyg.cuadrillas.dto.actividad;

import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;
import com.fyg.cuadrillas.dto.CoordenadaDTO;

public class ActividadDiariaCampoDTO extends ObjetoValor {

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
	/** noHorasTrabajadas */
	private int noHorasRestantes;
	/** porcentajeCompletas */
	private float porcentajeCompletas;
	/** porcentaje */
	private float porcentajeDia;
	/** observaciones */
	private String observaciones;
	/** observaciones */
	private String comentarioAutorizacion;
	/** Usuario alta */
	private String usuarioAlta;
	/**Envio autorizacion*/
	private String envioAutorizacion;
	/** usuario autorizacion*/
	private String envioUsuarioAutorizacion;
	/** autorizacion*/
	private String autorizacion;
	/** fecha de la autorizacion*/
	private String fechaAutorizacion;
	/** usuario aut*/
	private String usuarioAutorizacion;
	/** lista de actividades diaria detalle*/
	private List<ActividadDiariaDetalleDTO> actividadDiariaDetalle;
	/** lista coordenadas*/
	private List<ActividadDiariaCoordenadasDTO> coordenadasReal;
	/** lista coordenadas*/
	private List<CoordenadaDTO> coordenadasEsperado;
	/** fecha de alta*/
	private String fechaAlta;
	/**usuario baja*/
	private String usuarioBaja;
	/** usuario ult mod*/
	private String usuarioUltMod;
	/** fecha ult mod*/
	private String fechaUltMod;
	/** estatus*/
	private String estatus;
	/** descripcion vialidad */
	private String descripcionVialidad;
	/** nombre del residente */
	private String nombreResidente;
	/** noActividades */
	private int noActividades;
	/** noActividadesTerminadas */
	private int noActividadesTerminadas;
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
	 * @return the usuarioAutorizacion
	 */
	public String getUsuarioAutorizacion() {
		return usuarioAutorizacion;
	}
	/**
	 * @param usuarioAutorizacion the usuarioAutorizacion to set
	 */
	public void setUsuarioAutorizacion(String usuarioAutorizacion) {
		this.usuarioAutorizacion = usuarioAutorizacion;
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
	 * @return the coordenadasReal
	 */
	public List<ActividadDiariaCoordenadasDTO> getCoordenadasReal() {
		return coordenadasReal;
	}
	/**
	 * @param coordenadasReal the coordenadasReal to set
	 */
	public void setCoordenadasReal(
			List<ActividadDiariaCoordenadasDTO> coordenadasReal) {
		this.coordenadasReal = coordenadasReal;
	}
	/**
	 * @return the coordenadasEsperado
	 */
	public List<CoordenadaDTO> getCoordenadasEsperado() {
		return coordenadasEsperado;
	}
	/**
	 * @param coordenadasEsperado the coordenadasEsperado to set
	 */
	public void setCoordenadasEsperado(
			List<CoordenadaDTO> coordenadasEsperado) {
		this.coordenadasEsperado = coordenadasEsperado;
	}
	/**
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the usuarioBaja
	 */
	public String getUsuarioBaja() {
		return usuarioBaja;
	}
	/**
	 * @param usuarioBaja the usuarioBaja to set
	 */
	public void setUsuarioBaja(String usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
	}
	/**
	 * @return the usuarioUltMod
	 */
	public String getUsuarioUltMod() {
		return usuarioUltMod;
	}
	/**
	 * @param usuarioUltMod the usuarioUltMod to set
	 */
	public void setUsuarioUltMod(String usuarioUltMod) {
		this.usuarioUltMod = usuarioUltMod;
	}
	/**
	 * @return the fechaUltMod
	 */
	public String getFechaUltMod() {
		return fechaUltMod;
	}
	/**
	 * @param fechaUltMod the fechaUltMod to set
	 */
	public void setFechaUltMod(String fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
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
	 * @return the descripcionVialidad
	 */
	public String getDescripcionVialidad() {
		return descripcionVialidad;
	}
	/**
	 * @param descripcionVialidad the descripcionVialidad to set
	 */
	public void setDescripcionVialidad(String descripcionVialidad) {
		this.descripcionVialidad = descripcionVialidad;
	}
	/**
	 * @return the nombreResidente
	 */
	public String getNombreResidente() {
		return nombreResidente;
	}
	/**
	 * @param nombreResidente the nombreResidente to set
	 */
	public void setNombreResidente(String nombreResidente) {
		this.nombreResidente = nombreResidente;
	}
	/**
	 * @return the noHorasRestantes
	 */
	public int getNoHorasRestantes() {
		return noHorasRestantes;
	}
	/**
	 * @param noHorasRestantes the noHorasRestantes to set
	 */
	public void setNoHorasRestantes(int noHorasRestantes) {
		this.noHorasRestantes = noHorasRestantes;
	}
	/**
	 * @return the porcentajeCompletas
	 */
	public float getPorcentajeCompletas() {
		return porcentajeCompletas;
	}
	/**
	 * @param porcentajeCompletas the porcentajeCompletas to set
	 */
	public void setPorcentajeCompletas(float porcentajeCompletas) {
		this.porcentajeCompletas = porcentajeCompletas;
	}
	/**
	 * @return the porcentajeDia
	 */
	public float getPorcentajeDia() {
		return porcentajeDia;
	}
	/**
	 * @param porcentajeDia the porcentajeDia to set
	 */
	public void setPorcentajeDia(float porcentajeDia) {
		this.porcentajeDia = porcentajeDia;
	}
	/**
	 * @return the noActividades
	 */
	public int getNoActividades() {
		return noActividades;
	}
	/**
	 * @param noActividades the noActividades to set
	 */
	public void setNoActividades(int noActividades) {
		this.noActividades = noActividades;
	}
	/**
	 * @return the noActividadesTerminadas
	 */
	public int getNoActividadesTerminadas() {
		return noActividadesTerminadas;
	}
	/**
	 * @param noActividadesTerminadas the noActividadesTerminadas to set
	 */
	public void setNoActividadesTerminadas(int noActividadesTerminadas) {
		this.noActividadesTerminadas = noActividadesTerminadas;
	}

}
