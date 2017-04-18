package com.fyg.cuadrillas.dto;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class PerfilDTO extends ObjetoValor {
/**
 * Serial UID
 */
private static final long serialVersionUID = 1700620383878923573L;
/**
 * Id unico de perfil
 */
private Integer idPerfil;
/**
 * Nombre del perfil
 */
private String nombre;
/**
 * Descripcion del perfil
 */
private String descripcion;
/**
 * Estatus del perfil
 */
private char estatus;
/**
 * codigo puesto
 */
private String codigoPuesto;
/**
 * @return obtiene el id del perfil
 */
public Integer getIdPerfil() {
	return idPerfil;
}
/**
 * @param idPerfil ingresa el id del perfil
 */
public void setIdPerfil(Integer idPerfil) {
	this.idPerfil = idPerfil;
}
/**
 * @return obtiene el nombre del perfil
 */
public String getNombre() {
	return nombre;
}
/**
 * @param nombre ingresa un nombre
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}
/**
 * @return obtiene la descripcion del perfil
 */
public String getDescripcion() {
	return descripcion;
}
/**
 * @param descripcion ingresa la descripcion del perfil
 */
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
/**
 * @return obtiene el estatus del perfil
 */
public char getEstatus() {
	return estatus;
}
/**
 * @param estatus ingresa un estatus del perfil
 */
public void setEstatus(char estatus) {
	this.estatus = estatus;
}
/**
 * @return the codigoPuesto
 */
public String getCodigoPuesto() {
	return codigoPuesto;
}
/**
 * @param codigoPuesto the codigoPuesto to set
 */
public void setCodigoPuesto(String codigoPuesto) {
	this.codigoPuesto = codigoPuesto;
}
}
