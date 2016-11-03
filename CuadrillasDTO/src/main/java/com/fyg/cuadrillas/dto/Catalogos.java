package com.fyg.cuadrillas.dto;

import java.util.Date;

public class Catalogos {
/**
 * tipo catalogo
 */
 private String tipo_catalogo;
 /**
  * codigo del catalogo
  */
 private String codigo;
 /**
  * descripcion del catalogo
  */
 private String descripcion;
 /**
  * fecha alta del catalogo
  */
 private Date fecha_alta;
 /**
  * fecha de la modificacion
  */
 private Date fecha_ult_mod;
 /**
  * estatus del catalogo A - Activo I- inactivo
  */
 private String estatus;
 /**
  * @return obtiene el tipo de catalogo
  */
public String getTipo_catalogo() {
	return tipo_catalogo;
}
/**
 * @param tipo_catalogo ingresa el tipo de catalogo
 */
public void setTipo_catalogo(String tipo_catalogo) {
	this.tipo_catalogo = tipo_catalogo;
}
/**
 * @return obtiene el codigo del catalogo
 */
public String getCodigo() {
	return codigo;
}
/**
 * @param codigo ingresa el codigo del catalogo
 */
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
/**
 * @return obtiene la descripcion del catalogo
 */
public String getDescripcion() {
	return descripcion;
}
/**
 * @param descripcion ingresa la descripcion del catalogo
 */
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
/**
 * @return obtiene la fecha de alta
 */
public Date getFecha_alta() {
	return fecha_alta;
}
/**
 * @param fecha_alta ingresa la fecha de la alta
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
