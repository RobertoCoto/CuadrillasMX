package com.fyg.cuadrillas.dto.buzon;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class BuzonDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Tipo de tarea del buzon
	 */
	private String tipoTarea;
	/**
	 * fecha de la tarea
	 */
	private String fechaTarea;
	/**
	 * id general
	 */
	private Integer id;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * id del permiso
	 */
	private Integer idPermiso;
	/**
	 * Descripcion
	 */
	private String descripcion;
	/**
	 * se almacenara parametro imss
	 */
	private Integer notificaImss;
	/**
	 * se almacenara id de la cuadrilla
	 */
	private Integer idCuadrilla;
	/**
	 * @return the tipoTarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}
	/**
	 * @param tipoTarea the tipoTarea to set
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}
	/**
	 * @return the fechaTarea
	 */
	public String getFechaTarea() {
		return fechaTarea;
	}
	/**
	 * @param fechaTarea the fechaTarea to set
	 */
	public void setFechaTarea(String fechaTarea) {
		this.fechaTarea = fechaTarea;
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
	 * @return the idPermiso
	 */
	public Integer getIdPermiso() {
		return idPermiso;
	}
	/**
	 * @param idPermiso the idPermiso to set
	 */
	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the notificaImss
	 */
	public Integer getNotificaImss() {
		return notificaImss;
	}
	/**
	 * @param notificaImss the notificaImss to set
	 */
	public void setNotificaImss(Integer notificaImss) {
		this.notificaImss = notificaImss;
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
