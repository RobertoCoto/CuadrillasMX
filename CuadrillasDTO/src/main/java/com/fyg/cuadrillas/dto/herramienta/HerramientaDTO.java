package com.fyg.cuadrillas.dto.herramienta;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class HerramientaDTO extends ObjetoValor{
/**
 * Serial UID
 */
 private static final long serialVersionUID = -7463726708107865845L;
 /**
  * Id de herramienta 
  */
 private String idHerramienta;
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
 private Date fechaIngreso;
 /**
  * Codigo combustible
  */
 private String codigoTipoCombustible;
 /**
  * Cdigo Articulo
  */
 private String codigoTipoArticulo;
 /**
  * Estado
  */
 private String codigoEstado;
 /**
  * Mantenimiento
  */
 private String mantenimiento;
 /**
  * Fecha de alta
  */
 private Date fechaAlta;
 /**
  * fecha ultima mod
  */
 private Date fechaUltMod;
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
public String getIdHerramienta() {
	return idHerramienta;
}
/**
 * @param idHerramienta ingresa el id de la herramienta
 */
public void setIdHerramienta(String idHerramienta) {
	this.idHerramienta = idHerramienta;
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
public Date getFechaIngreso() {
	return fechaIngreso;
}
/**
 * @param fechaIngreso ingresa la fecha de ingreso
 */
public void setFechaIngreso(Date fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
}
/**
 * @return obtiene el codigo combustible
 */
public String getCodigoTipoCombustible() {
	return codigoTipoCombustible;
}
/**
 * @param codigoTipoCombustible ingresa el codigo del combustible
 */
public void setCodigoTipoCombustible(String codigoTipoCombustible) {
	this.codigoTipoCombustible = codigoTipoCombustible;
}
/**
 * @return obtiene el tipo de articulo
 */
public String getCodigoTipoArticulo() {
	return codigoTipoArticulo;
}
/***
 * @param codigoTipoArticulo ingresa el tipo de articulo
 */
public void setCodigoTipoArticulo(String codigoTipoArticulo) {
	this.codigoTipoArticulo = codigoTipoArticulo;
}
/**
 * @return obtiene el codigo del estado
 */
public String getCodigoEstado() {
	return codigoEstado;
}
/**
 * @param codigoEstado ingresa el codigo de estado
 */
public void setCodigoEstado(String codigoEstado) {
	this.codigoEstado = codigoEstado;
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
