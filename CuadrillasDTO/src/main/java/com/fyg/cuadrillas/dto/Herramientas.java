package com.fyg.cuadrillas.dto;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class Herramientas extends ObjetoValor{
/**
 * Serial UID
 */
 private static final long serialVersionUID = -7463726708107865845L;
 /**
  * Id de herramienta 
  */
 private String id_herramienta;
 /**
  * Nombre de la herramienta
  */
 private String nombre;
 /**
  * Descripcion 
  */
 private String descripcion;
 /**
  * Fecha de ingresa
  */
 private Date fecha_ingreso;
 /**
  * Codigo combustible
  */
 private String codigo_tipo_combustible;
 /**
  * Cdigo Articulo
  */
 private String codigo_tipo_articulo;
 /**
  * Estado
  */
 private String codigo_estado;
 /**
  * Mantenimiento
  */
 private String mantenimiento;
 /**
  * Fecha de alta
  */
 private Date fecha_alta;
 /**
  * fecha ultima mod
  */
 private Date fecha_ult_mod;
 /**
  * estatus
  */
 private String estatus;
 /**
  * Orden
  */
 private String orden;
 /**
  * @return obtiene el id de la herramienta
  */
public String getId_herramienta() {
	return id_herramienta;
}
/**
 * @param id_herramienta ingresa el id de la herramienta
 */
public void setId_herramienta(String id_herramienta) {
	this.id_herramienta = id_herramienta;
}
/**
 * @return obtiene el nombre
 */
public String getNombre() {
	return nombre;
}
/**
 * @param nombre ingresa el nombre
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
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
 * @return obtiene la fecha de ingreso
 */
public Date getFecha_ingreso() {
	return fecha_ingreso;
}
/**
 * @param fecha_ingreso ingresa la fecha de ingreso
 */
public void setFecha_ingreso(Date fecha_ingreso) {
	this.fecha_ingreso = fecha_ingreso;
}
/**
 * @return obtiene el codigo combustible
 */
public String getCodigo_tipo_combustible() {
	return codigo_tipo_combustible;
}
/**
 * @param codigo_tipo_combustible ingresa el codigo del combustible
 */
public void setCodigo_tipo_combustible(String codigo_tipo_combustible) {
	this.codigo_tipo_combustible = codigo_tipo_combustible;
}
/**
 * @return obtiene el tipo de articulo
 */
public String getCodigo_tipo_articulo() {
	return codigo_tipo_articulo;
}
/***
 * @param codigo_tipo_articulo ingresa el tipo de articulo
 */
public void setCodigo_tipo_articulo(String codigo_tipo_articulo) {
	this.codigo_tipo_articulo = codigo_tipo_articulo;
}
/**
 * @return obtiene el codigo del estado
 */
public String getCodigo_estado() {
	return codigo_estado;
}
/**
 * @param codigo_estado ingresa el codigo de estado
 */
public void setCodigo_estado(String codigo_estado) {
	this.codigo_estado = codigo_estado;
}
/**
 * @return obtiene el mantenimiento
 */
public String getMantenimiento() {
	return mantenimiento;
}
/**
 * @param mantenimiento ingresa el mantenimiento
 */
public void setMantenimiento(String mantenimiento) {
	this.mantenimiento = mantenimiento;
}
/**
 * @return obtiene la fecha de alta
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
 * @param fecha_ult_mod ingresa la fecha d modificacion
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
/**
 * @return obtiene el orden
 */
public String getOrden() {
	return orden;
}
/**
 * @param orden ingresa un orden
 */
public void setOrden(String orden) {
	this.orden = orden;
}

}
