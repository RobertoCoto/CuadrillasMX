package com.fyg.cuadrillas.dto;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class EmpleadoDocumentos extends ObjetoValor{
	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = -7297474146942071070L;
	/**
	 * id del empleado
	 */
	private Integer id_empleado;
	/**
	 * documento entregado
	 */
	private String codigo_emp_doc;
	/**
	 * Fecha_alta del documento
	 */
	private Date fecha_alta;
	/**
	 * Fecha ultima modificacion
	 */
	private Date fecha_ult_mod;
	/**
	 * estatus 
	 */
	private String estatus;
	/**
	 * @return the id_empleado
	 */
	public Integer getId_empleado() {
		return id_empleado;
	}
	/**
	 * @param id_empleado the id_empleado to set
	 */
	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}
	/**
	 * @return the codigo_emp_doc
	 */
	public String getCodigo_emp_doc() {
		return codigo_emp_doc;
	}
	/**
	 * @param codigo_emp_doc the codigo_emp_doc to set
	 */
	public void setCodigo_emp_doc(String codigo_emp_doc) {
		this.codigo_emp_doc = codigo_emp_doc;
	}
	/**
	 * @return the fecha_alta
	 */
	public Date getFecha_alta() {
		return fecha_alta;
	}
	/**
	 * @param fecha_alta the fecha_alta to set
	 */
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	/**
	 * @return the fecha_ult_mod
	 */
	public Date getFecha_ult_mod() {
		return fecha_ult_mod;
	}
	/**
	 * @param fecha_ult_mod the fecha_ult_mod to set
	 */
	public void setFecha_ult_mod(Date fecha_ult_mod) {
		this.fecha_ult_mod = fecha_ult_mod;
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
