package com.fyg.cuadrillas.dto.actividad;

import java.util.Date;
import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -3786704476128984542L;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * fecha recibida actividad;
	 */
	private String fechaDiaria;
	/**
	 * id de la actividad
	 */
	private Integer idActividad;
	/**
	 * id de la cuadrilla
	 */
	private Integer idCuadrilla;
	/**
	 * tramo inicial planificado
	 */
	private String tramoInicialPlanificado;
	/**
	 * tramo final planificado
	 */
	private String tramoFinalPlanificado;
	/**
	 * alcance planificado
	 */
	private Float alcancePlanificado;
	/**
	 * trami inicial real
	 */
	private String tramoInicialReal;
	/**
	 * tramo final real
	 */
	private String tramoFinalReal;
	/**
	 * alcance real
	 */
	private Float alcanceReal;
	/**
	 * actividad realizada
	 */
	private String actividad;
	/**
	 * prioridad de la actividad
	 */
	private String prioridad;
	/**
	 * estado de la actividad
	 */
	private String estado;
	/**
	 * tiempo estimado
	 */
	private Integer tiempoEstimado;
	/**
	 * numero de personas
	 */
	private Integer numeroPersonas;
	/**
	 * numero de unidades
	 */
	private Integer numeroUnidades;
	/**
	 * porcentaje contemplado
	 */
	private Float porcentajeCompletado;
	/**
	 * listo /vencido
	 */
	private String listoVencido;
	/**
	 * observaciones de la actividad
	 */
	private String observacionesActividades;
	/**
	 * porcentaje horas trabajadas
	 */
	private Float horasTotalTabajadas;
	/**
	 * porcentaje de las actividades completas
	 */
	private Float actividadesCompletas;
	/**
	 * horas restantes
	 */
	private Integer horasRestantes;
	/**
	 *  porcentaje actividades del dia
	 */
	private Float  actividadesDia;
	/**
	 * observaciones
	 */
	private String observaciones;
	/**
	 * usuario Alta
	 */
	private String usuarioAlta;
	/**
	 * fecha Alta
	 */
	private Date fechaAlta;
	/**
	 * usuario baja
	 */
	private String usuarioBaja;
	/**
	 * fecha baja
	 */
	private Date fechaBaja;
	/**
	 * fecha ult mod
	 */
	private Date fechaUltMod;
	/**
	 * usuario ultima mod
	 */
	private String usuarioUltMod;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * estatus de la autorizacion
	 */
	private String autorizacion;
	/**
	 * Usuario Autorizacion
	 */
	private String usuarioAutorizacion;
	/**
	 * fecha de la autorizacion
	 */
	private Date  fechaAutorizacion;
	/**
	 * agenda Detalle
	 */
	private Integer idAgendaDetalle;
	/**
	 * id contrato
	 */
	private Integer idContrato;
	/**
	 * agenda
	 */
	private Integer idAgenda;
	/**
	 * nombre del residente
	 */
	private String nombreResidente;
	/**
	 * codigo actividad
	 */
	private String codigoActividad;
	/**
	 * descripcion actividad
	 */
	private String descripcionActividad;
	/**
	 * fecha resultado
	 */
	private String fechaActividad;
	/**
	 * lista actividades
	 */
	private List<ActividadDTO> listaActividades;
	/**
	 * materiales
	 */
	private List<ActividadDTO> listaMateriales;
	/**
	 * coordenadas
	 */
	private List<ActividadDTO> listaCoordenadas;
	/**
	 * codigo Material
	 */
	 private String codigoMaterial;
	/**
	 * descripcion material
	 */
	private String descripcionMaterial;
	/**
	 * id de la coordenada
	 */
	private Integer idCoordenada;
	/**
	 * numero orden
	 */
	private Integer orden;
	/**
	 * la direccion
	 */
	private String direccion;
	/**
	 * la latitud
	 */
	private Float latitud;
	/**
	 * la longitud
	 */
	private Float longitud;
	/**
	 * @return the idActividad
	 */
	public Integer getIdActividad() {
		return idActividad;
	}
	/**
	 * @param idActividad the idActividad to set
	 */
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
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
	/**
	 * @return the tramoInicialPlanificado
	 */
	public String getTramoInicialPlanificado() {
		return tramoInicialPlanificado;
	}
	/**
	 * @param tramoInicialPlanificado the tramoInicialPlanificado to set
	 */
	public void setTramoInicialPlanificado(String tramoInicialPlanificado) {
		this.tramoInicialPlanificado = tramoInicialPlanificado;
	}
	/**
	 * @return the tramoFinalPlanificado
	 */
	public String getTramoFinalPlanificado() {
		return tramoFinalPlanificado;
	}
	/**
	 * @param tramoFinalPlanificado the tramoFinalPlanificado to set
	 */
	public void setTramoFinalPlanificado(String tramoFinalPlanificado) {
		this.tramoFinalPlanificado = tramoFinalPlanificado;
	}
	/**
	 * @return the alcancePlanificado
	 */
	public Float getAlcancePlanificado() {
		return alcancePlanificado;
	}
	/**
	 * @param alcancePlanificado the alcancePlanificado to set
	 */
	public void setAlcancePlanificado(Float alcancePlanificado) {
		this.alcancePlanificado = alcancePlanificado;
	}
	/**
	 * @return the tramoInicialReal
	 */
	public String getTramoInicialReal() {
		return tramoInicialReal;
	}
	/**
	 * @param tramoInicialReal the tramoInicialReal to set
	 */
	public void setTramoInicialReal(String tramoInicialReal) {
		this.tramoInicialReal = tramoInicialReal;
	}
	/**
	 * @return the tramoFinalReal
	 */
	public String getTramoFinalReal() {
		return tramoFinalReal;
	}
	/**
	 * @param tramoFinalReal the tramoFinalReal to set
	 */
	public void setTramoFinalReal(String tramoFinalReal) {
		this.tramoFinalReal = tramoFinalReal;
	}
	/**
	 * @return the alcanceReal
	 */
	public Float getAlcanceReal() {
		return alcanceReal;
	}
	/**
	 * @param alcanceReal the alcanceReal to set
	 */
	public void setAlcanceReal(Float alcanceReal) {
		this.alcanceReal = alcanceReal;
	}
	/**
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}
	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	/**
	 * @return the prioridad
	 */
	public String getPrioridad() {
		return prioridad;
	}
	/**
	 * @param prioridad the prioridad to set
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the tiempoEstimado
	 */
	public Integer getTiempoEstimado() {
		return tiempoEstimado;
	}
	/**
	 * @param tiempoEstimado the tiempoEstimado to set
	 */
	public void setTiempoEstimado(Integer tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	/**
	 * @return the numeroPersonas
	 */
	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}
	/**
	 * @param numeroPersonas the numeroPersonas to set
	 */
	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	/**
	 * @return the numeroUnidades
	 */
	public Integer getNumeroUnidades() {
		return numeroUnidades;
	}
	/**
	 * @param numeroUnidades the numeroUnidades to set
	 */
	public void setNumeroUnidades(Integer numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}
	/**
	 * @return the porcentajeContemplado
	 */
	public Float getPorcentajeCompletado() {
		return porcentajeCompletado;
	}
	/**
	 * @param porcentajeCompletado the porcentajeContemplado to set
	 */
	public void setPorcentajeCompletado(Float porcentajeCompletado) {
		this.porcentajeCompletado = porcentajeCompletado;
	}
	/**
	 * @return the listoVencido
	 */
	public String getListoVencido() {
		return listoVencido;
	}
	/**
	 * @param listoVencido the listoVencido to set
	 */
	public void setListoVencido(String listoVencido) {
		this.listoVencido = listoVencido;
	}
	/**
	 * @return the observacionesActividades
	 */
	public String getObservacionesActividades() {
		return observacionesActividades;
	}
	/**
	 * @param observacionesActividades the observacionesActividades to set
	 */
	public void setObservacionesActividades(String observacionesActividades) {
		this.observacionesActividades = observacionesActividades;
	}
	/**
	 * @return the horasTotalTabajadas
	 */
	public Float getHorasTotalTabajadas() {
		return horasTotalTabajadas;
	}
	/**
	 * @param horasTotalTabajadas the horasTotalTabajadas to set
	 */
	public void setHorasTotalTabajadas(Float horasTotalTabajadas) {
		this.horasTotalTabajadas = horasTotalTabajadas;
	}
	/**
	 * @return the actividadesCompletas
	 */
	public Float getActividadesCompletas() {
		return actividadesCompletas;
	}
	/**
	 * @param actividadesCompletas the actividadesCompletas to set
	 */
	public void setActividadesCompletas(Float actividadesCompletas) {
		this.actividadesCompletas = actividadesCompletas;
	}
	/**
	 * @return the horasRestantes
	 */
	public Integer getHorasRestantes() {
		return horasRestantes;
	}
	/**
	 * @param horasRestantes the horasRestantes to set
	 */
	public void setHorasRestantes(Integer horasRestantes) {
		this.horasRestantes = horasRestantes;
	}
	/**
	 * @return the actividadesDia
	 */
	public Float getActividadesDia() {
		return actividadesDia;
	}
	/**
	 * @param actividadesDia the actividadesDia to set
	 */
	public void setActividadesDia(Float actividadesDia) {
		this.actividadesDia = actividadesDia;
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
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
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
	 * @return the fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}
	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	/**
	 * @return the fechaUltMod
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}
	/**
	 * @param fechaUltMod the fechaUltMod to set
	 */
	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
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
	 * @return the fechaAutorizacion
	 */
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
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
	 * @return the fechaDiaria
	 */
	public String getFechaDiaria() {
		return fechaDiaria;
	}
	/**
	 * @param fechaDiaria the fechaDiaria to set
	 */
	public void setFechaDiaria(String fechaDiaria) {
		this.fechaDiaria = fechaDiaria;
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
	 * @return the codigoActividad
	 */
	public String getCodigoActividad() {
		return codigoActividad;
	}
	/**
	 * @param codigoActividad the codigoActividad to set
	 */
	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}
	/**
	 * @return the descripcionActividad
	 */
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	/**
	 * @param descripcionActividad the descripcionActividad to set
	 */
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}
	/**
	 * @return the fechaActividad
	 */
	public String getFechaActividad() {
		return fechaActividad;
	}
	/**
	 * @param fechaActividad the fechaActividad to set
	 */
	public void setFechaActividad(String fechaActividad) {
		this.fechaActividad = fechaActividad;
	}
	/**
	 * @return the listaActividades
	 */
	public List<ActividadDTO> getListaActividades() {
		return listaActividades;
	}
	/**
	 * @param listaActividades the listaActividades to set
	 */
	public void setListaActividades(List<ActividadDTO> listaActividades) {
		this.listaActividades = listaActividades;
	}
	/**
	 * @return the listaMateriales
	 */
	public List<ActividadDTO> getListaMateriales() {
		return listaMateriales;
	}
	/**
	 * @param listaMateriales the listaMateriales to set
	 */
	public void setListaMateriales(List<ActividadDTO> listaMateriales) {
		this.listaMateriales = listaMateriales;
	}
	/**
	 * @return the listaCoordenadas
	 */
	public List<ActividadDTO> getListaCoordenadas() {
		return listaCoordenadas;
	}
	/**
	 * @param listaCoordenadas the listaCoordenadas to set
	 */
	public void setListaCoordenadas(List<ActividadDTO> listaCoordenadas) {
		this.listaCoordenadas = listaCoordenadas;
	}
	/**
	 * @return the codigoMaterial
	 */
	public String getCodigoMaterial() {
		return codigoMaterial;
	}
	/**
	 * @param codigoMaterial the codigoMaterial to set
	 */
	public void setCodigoMaterial(String codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}
	/**
	 * @return the descripcionMaterial
	 */
	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}
	/**
	 * @param descripcionMaterial the descripcionMaterial to set
	 */
	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}
	/**
	 * @return the idCoordenada
	 */
	public Integer getIdCoordenada() {
		return idCoordenada;
	}
	/**
	 * @param idCoordenada the idCoordenada to set
	 */
	public void setIdCoordenada(Integer idCoordenada) {
		this.idCoordenada = idCoordenada;
	}
	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the latitud
	 */
	public Float getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public Float getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
}
