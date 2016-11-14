package com.fyg.cuadrillas.dto;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class Empleado extends ObjetoValor {
/**
 * Serial UID
 */
private static final long serialVersionUID = -6992168000842348278L;
/**
 * Id unico del empleado
 */
private Integer id_empleado;
/**
 * Nombre del empleado
 */
private String nombre;
/**
 * Apellido Paterno del usuario
 */
private String apellido_pat;
/**
 * Apellido Materno del usuario
 */
private String apellido_mat;
/**
 * Sexo del usuario
 */
private String sexo;
/**
 * RFC del usuario
 */
private String rfc;
/**
 * rfc_calculado del empleado
 */
private String rfc_calculado;
/**
 * Curp del usuario
 */
private String curp;
/**
 * Fecha_nacimiento del empleado
 */
private Date fecha_nacimiento;
/**
 * Fecha de ingreso del empleado
 */
private Date fecha_ingreso;
/**
 * codigo puesto
 */
private String codigo_puesto;
/**
 * codigo vialidad
 */
private String codigo_vialidad;
/**
 * codigo del area
 */
private String codigo_area;
/**
 * Codigo Talla
 */
private String codigo_talla;
/**
 * Sueldo del empleado
 */
private Double sueldo;
/**
 * Numero de seguro social
 */
private String nss;
/**
 * Numero del credito infonavit
 */
private String no_credito_infonavit;
/**
 * Numero de telefono
 */
private String telefono;
/**
 * Fecha_alta del usuario
 */
private Date fecha_alta;
/**
 * Fecha_baja del usuario
 */
private Date fecha_baja;
/**
 * Codigo del tipo de salida
 */
private String codigo_tipo_salida;
/**
 * Codigo causas salida
 */
private String codigo_causa_salida;
/**
 * Fecha ultima modificacion
 */
private Date fecha_ult_mod;
/**
 * estatus del usuario
 */
private String estatus;
/**
 * Recibira los documentos del empleado
 */
private EmpleadoDocumentos objDocumentos;
/**
 * @return regresa el id_empleado
 */
public Integer getId_empleado() {
	return id_empleado;
}
/**
 * @param id_empleado ingresa el id empleado
 */
public void setId_empleado(Integer id_empleado) {
	this.id_empleado = id_empleado;
}
/**
 * @return regresa el nombre
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
 * @return regresa el apellido paterno
 */
public String getApellido_pat() {
	return apellido_pat;
}
/**
 * @param apellido_pat ingresa el apellido paterno
 */
public void setApellido_pat(String apellido_pat) {
	this.apellido_pat = apellido_pat;
}
/**
 * @return regresa el apellido materno
 */
public String getApellido_mat() {
	return apellido_mat;
}
/**
 * @param apellido_mat ingresa el apellido materno
 */
public void setApellido_mat(String apellido_mat) {
	this.apellido_mat = apellido_mat;
}
/**
 * @return regresa el sexo
 */
public String getSexo() {
	return sexo;
}
/**
 * @param sexo ingresa el sexo
 */
public void setSexo(String sexo) {
	this.sexo = sexo;
}
/**
 * @return regresa el rfc
 */
public String getRfc() {
	return rfc;
}
/**
 * @param rfc ingresa el rfc
 */
public void setRfc(String rfc) {
	this.rfc = rfc;
}
/**
 * @return regresa el rfc calculado
 */
public String getRfc_calculado() {
	return rfc_calculado;
}
/**
 * @param rfc_calculado ingresa el rfc calculado
 */
public void setRfc_calculado(String rfc_calculado) {
	this.rfc_calculado = rfc_calculado;
}
/**
 * @return regresa la curp
 */
public String getCurp() {
	return curp;
}
/**
 * @param curp ingresa la curp
 */
public void setCurp(String curp) {
	this.curp = curp;
}
/**
 * @return regresa la fecha de nacimiento
 */
public Date getFecha_nacimiento() {
	return fecha_nacimiento;
}
/**
 * @param fecha_nacimiento ingresa la fecha de nacimiento
 */
public void setFecha_nacimiento(Date fecha_nacimiento) {
	this.fecha_nacimiento = fecha_nacimiento;
}
/**
 * @return regresa la fecha de ingreso
 */
public Date getFecha_ingreso() {
	return fecha_ingreso;
}
/**
 * @param fecha_ingreso ingresa la fecha
 */
public void setFecha_ingreso(Date fecha_ingreso) {
	this.fecha_ingreso = fecha_ingreso;
}
/**
 * @return regresa el codigo puesto
 */
public String getCodigo_puesto() {
	return codigo_puesto;
}
/**
 * @param codigo_puesto ingresa el codigo puesto
 */
public void setCodigo_puesto(String codigo_puesto) {
	this.codigo_puesto = codigo_puesto;
}
/**
 * @return regresa la vialidad
 */
public String getCodigo_vialidad() {
	return codigo_vialidad;
}
/**
 * @param codigo_vialidad ingresa el codigo vialidad
 */
public void setCodigo_vialidad(String codigo_vialidad) {
	this.codigo_vialidad = codigo_vialidad;
}
/**
 * @return regresa el codigo area
 */
public String getCodigo_area() {
	return codigo_area;
}
/**
 * @param codigo_area ingresa el codigo area
 */
public void setCodigo_area(String codigo_area) {
	this.codigo_area = codigo_area;
}
/**
 * @return regresa el codigo talla
 */
public String getCodigo_talla() {
	return codigo_talla;
}
/**
 * @param codigo_talla ingresa el codigo talla
 */
public void setCodigo_talla(String codigo_talla) {
	this.codigo_talla = codigo_talla;
}
/**
 * @return regresa el monto del sueldo
 */
public Double getSueldo() {
	return sueldo;
}
/**
 * @param sueldo ingresa el monto del sueldo
 */
public void setSueldo(Double sueldo) {
	this.sueldo = sueldo;
}
/**
 * @return regresa el numero de seguro social
 */
public String getNss() {
	return nss;
}
/**
 * @param nss ingresa el numero de seguro social
 */
public void setNss(String nss) {
	this.nss = nss;
}
/**
 * @return regresa el credito infonavit
 */
public String getNo_credito_infonavit() {
	return no_credito_infonavit;
}
/**
 * @param no_credito_infonavit ingresa el credito infonavit
 */
public void setNo_credito_infonavit(String no_credito_infonavit) {
	this.no_credito_infonavit = no_credito_infonavit;
}
/**
 * @return regresa el numero de telefono
 */
public String getTelefono() {
	return telefono;
}
/**
 * @param telefono ingresa el numero de telefono
 */
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
/**
 * @return regresa la fecha de alta
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
 * @return regresa la fecha de baja
 */
public Date getFecha_baja() {
	return fecha_baja;
}
/**
 * @param fecha_baja ingresa la fecha de baja
 */
public void setFecha_baja(Date fecha_baja) {
	this.fecha_baja = fecha_baja;
}
/**
 * @return regresa el codigo de salida
 */
public String getCodigo_tipo_salida() {
	return codigo_tipo_salida;
}
/**
 * @param codigo_tipo_salida ingresa el codigo de salida
 */
public void setCodigo_tipo_salida(String codigo_tipo_salida) {
	this.codigo_tipo_salida = codigo_tipo_salida;
}
/**
 * @return regresa el codigo de causa
 */
public String getCodigo_causa_salida() {
	return codigo_causa_salida;
}
/**
 * @param codigo_causa_salida ingresa el codigo de causa
 */
public void setCodigo_causa_salida(String codigo_causa_salida) {
	this.codigo_causa_salida = codigo_causa_salida;
}
/**
 * @return regresa la fecha de ult mod.
 */
public Date getFecha_ult_mod() {
	return fecha_ult_mod;
}
/**
 * @param fecha_ult_mod ingresa la fecha ult. mod
 */
public void setFecha_ult_mod(Date fecha_ult_mod) {
	this.fecha_ult_mod = fecha_ult_mod;
}
/**
 * @return regresa el estatus
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
 * @return the objDocumentos
 */
public EmpleadoDocumentos getObjDocumentos() {
	return objDocumentos;
}
/**
 * @param objDocumentos ingresa los documentos
 */
public void setObjDocumentos(EmpleadoDocumentos objDocumentos) {
	this.objDocumentos = objDocumentos;
}
}
