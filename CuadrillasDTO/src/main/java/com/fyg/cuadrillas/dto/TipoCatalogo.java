package com.fyg.cuadrillas.dto;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class TipoCatalogo extends ObjetoValor {
	/**
	 * SerialUID
	 */
	private static final long serialVersionUID = -3593302729744180648L;
	/**
	 * Tipo Catalogo
	 */
	private String tipoCatalogo;
	/**
	 * 	Orden
	 */
	private String orden;
	/**
	 * descripcion del catalogo
	 */
	private String descripcion;
	/**
	 * Fecha de alta
	 */
	private Date fechaAlta;
	/**
	 * Fecha de modificacion
	 */
	private Date fechaUltMod;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * @return obtiene el tipo catalogo
	 */
	public String getTipoCatalogo() {
		return tipoCatalogo;
	}
	/**
	 * @param tipoCatalogo ingresa un tipo catalogo
	 */
	public void setTipoCatalogo(String tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
	/**
	 * @return obtiene el codigo
	 */
	public String getOrden() {
		return orden;
	}
	/**
	 * @param orden ingresa el codigo
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}
	/**
	 * @return obtiene la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion ingresa la descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return obtiene el estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus ingresa el estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}
