package com.fyg.cuadrillas.dto;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class EmpleadoDocumento extends ObjetoValor{
	/**
	 * Serial uid
	 */
	private static final long serialVersionUID = -7297474146942071070L;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * documento entregado
	 */
	private String codigoEmpDoc;
	/**
	 * Fecha_alta del documento
	 */
	private Date fechaAlta;
	/**
	 * Fecha ultima modificacion
	 */
	private Date fechaUltMod;
	/**
	 * estatus 
	 */
	private String estatus;
	/**
	 * @return the idEmpleado obtiene el id empleado
	 */
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @param id_empleado the id_empleado to set
	 */
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * @return the codigoEmpDoc
	 */
	public String getCodigoEmpDoc() {
		return codigoEmpDoc;
	}
	/**
	 * @param codigoEmpDoc the codigo del documento to set
	 */
	public void setCodigoEmpDoc(String codigoEmpDoc) {
		this.codigoEmpDoc = codigoEmpDoc;
	}
	/**
	 * @return regresa la fecha de alta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta ingresa la fecha de alta
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return regresa la fecha de ult mod.
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}
	/**
	 * @param fechaUltMod ingresa la fecha ult. mod
	 */
	public void setFechaUltMod(Date fechaUltMod) {
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
	
}
