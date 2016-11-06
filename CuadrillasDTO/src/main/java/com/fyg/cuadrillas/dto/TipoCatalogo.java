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
	private String tipo_catalogo;
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
	private Date fecha_alta;
	/**
	 * Fecha de modificacion
	 */
	private Date fecha_ult_mod;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * @return obtiene el tipo catalogo
	 */
	public String getTipo_catalogo() {
		return tipo_catalogo;
	}
	/**
	 * @param tipo_catalogo ingresa un tipo catalogo
	 */
	public void setTipo_catalogo(String tipo_catalogo) {
		this.tipo_catalogo = tipo_catalogo;
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
	 * @return ontiene la fecha de alta
	 */
	public Date getFecha_alta() {
		return fecha_alta;
	}
	/**
	 * @param fecha_alta ingresa la fecha de alta
	 */
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	/**
	 * @return obtiene la fecha de modificacion
	 */
	public Date getFecha_ult_mod() {
		return fecha_ult_mod;
	}
	/**
	 * @param fecha_ult_mod ingresa la fecha de modificacion
	 */
	public void setFecha_ult_mod(Date fecha_ult_mod) {
		this.fecha_ult_mod = fecha_ult_mod;
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
