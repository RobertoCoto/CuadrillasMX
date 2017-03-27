package com.fyg.cuadrillas.dto.catalogo;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class CatalogoDTO extends ObjetoValor {
/**
 * serial uid
 */
 private static final long serialVersionUID = 4652921152042148878L;
/**
 * tipo catalogo
 */
 private String tipoCatalogo;
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
 private Date fechaAlta;
 /**
  * fecha de la modificacion
  */
 private Date fechaUltMod;
 /**
  * estatus del catalogo A - Activo I- inactivo
  */
 private String estatus;
 /**
  * Orden
  */
 private String orden;
 /**
  * usuarioAlta
  */
 private String usuarioAlta;
 /**
  * usuarioUltMod
  */
 private String usuarioUltMod;

 /**
  * @return obtiene el tipo de catalogo
  */
public String getTipoCatalogo() {
	return tipoCatalogo;
}
/**
 * @param tipoCatalogo ingresa el tipo de catalogo
 */
public void setTipoCatalogo(String tipoCatalogo) {
	this.tipoCatalogo = tipoCatalogo;
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
public Date getFechaAlta() {
	return fechaAlta;
}
/**
 * @param fechaAlta ingresa la fecha de la alta
 */
public void setFechaAlta(Date fechaAlta) {
	this.fechaAlta = fechaAlta;
}
/**
 * @return obtiene la fecha de modificacion
 */
public Date getFechaUltMod() {
	return fechaUltMod;
}
/**
 * @param fechaUltMod ingresa la fecha de modificacion
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
 * @param orden ingresa el orden
 */
public void setOrden(String orden) {
	this.orden = orden;
}
/**
 * @return the usuarioAlta
 */
public String getUsuarioAlta() {
	return usuarioAlta;
}
/**
 * @param usuarioAlta the usuarioAlta to set
 */
public void setUsuarioAlta(String usuarioAlta) {
	this.usuarioAlta = usuarioAlta;
}
/**
 * @return the usuarioUltMod
 */
public String getUsuarioUltMod() {
	return usuarioUltMod;
}
/**
 * @param usuarioUltMod the usuarioUltMod to set
 */
public void setUsuarioUltMod(String usuarioUltMod) {
	this.usuarioUltMod = usuarioUltMod;
}

}
