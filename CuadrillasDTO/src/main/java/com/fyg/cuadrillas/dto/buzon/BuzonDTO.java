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
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * id del permiso
	 */
	private Integer idPermiso;
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
}
