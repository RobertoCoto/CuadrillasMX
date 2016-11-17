package com.fyg.cuadrillas.dto;

import java.util.ArrayList;
import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class EmpleadoDTO extends ObjetoValor {
/**
 * Serial UID
 */
private static final long serialVersionUID = -6992168000842348278L;
/**
 * Id unico del empleado
 */
private Integer idEmpleado;
/**
 * Nombre del empleado
 */
private String nombre;
/**
 * Apellido Paterno del usuario
 */
private String apellidoPat;
/**
 * Apellido Materno del usuario
 */
private String apellidoMat;
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
private String rfcCalculado;
/**
 * Curp del usuario
 */
private String curp;
/**
 * Fecha_nacimiento del empleado
 */
private Date fechaNacimiento;
/**
 * Fecha de ingreso del empleado
 */
private Date fechaIngreso;
/**
 * codigo puesto
 */
private String codigoPuesto;
/**
 * codigo vialidad
 */
private String codigoVialidad;
/**
 * codigo del area
 */
private String codigoArea;
/**
 * Codigo Talla
 */
private String codigoTalla;
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
private String noCreditoInfonavit;
/**
 * Numero de telefono
 */
private String telefono;
/**
 * Fecha_alta del usuario
 */
private Date fechaAlta;
/**
 * Fecha_baja del usuario
 */
private Date fechaBaja;
/**
 * Codigo del tipo de salida
 */
private String codigoTipoSalida;
/**
 * Codigo causas salida
 */
private String codigoCausaSalida;
/**
 * Fecha ultima modificacion
 */
private Date fechaUltMod;
/**
 * estatus del usuario
 */
private String estatus;
/**
 * observaciones del empleado
 */
private String observaciones;
/**
 * Recibira los documentos del empleado
 */
private ArrayList<EmpleadoDocumentoDTO> objDocumentos;
/**
 * @return regresa el idEmpleado
 */
public Integer getIdEmpleado() {
	return idEmpleado;
}
/**
 * @param id_empleado ingresa el id empleado
 */
public void setIdEmpleado(Integer idEmpleado) {
	this.idEmpleado = idEmpleado;
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
public String getApellidoPat() {
	return apellidoPat;
}
/**
 * @param ApellidoPat ingresa el apellido paterno
 */
public void setApellidoPat(String apellidoPat) {
	this.apellidoPat = apellidoPat;
}
/**
 * @return regresa el apellido materno
 */
public String getApellidoMat() {
	return apellidoMat;
}
/**
 * @param apellido_mat ingresa el apellido materno
 */
public void setApellidoMat(String apellidoMat) {
	this.apellidoMat = apellidoMat;
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
public String getRfcCalculado() {
	return rfcCalculado;
}
/**
 * @param rfc_calculado ingresa el rfc calculado
 */
public void setRfcCalculado(String rfcCalculado) {
	this.rfcCalculado = rfcCalculado;
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
public Date getFechaNacimiento() {
	return fechaNacimiento;
}
/**
 * @param fecha_nacimiento ingresa la fecha de nacimiento
 */
public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
/**
 * @return regresa la fecha de ingreso
 */
public Date getFechaIngreso() {
	return fechaIngreso;
}
/**
 * @param fechaIngreso ingresa la fecha
 */
public void setFechaIngreso(Date fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
}
/**
 * @return regresa el codigo puesto
 */
public String getCodigoPuesto() {
	return codigoPuesto;
}
/**
 * @param codigoPuesto ingresa el codigo puesto
 */
public void setCodigoPuesto(String codigoPuesto) {
	this.codigoPuesto = codigoPuesto;
}
/**
 * @return regresa la vialidad
 */
public String getCodigoVialidad() {
	return codigoVialidad;
}
/**
 * @param codigoVialidad ingresa el codigo vialidad
 */
public void setCodigoVialidad(String codigoVialidad) {
	this.codigoVialidad = codigoVialidad;
}
/**
 * @return regresa el codigo area
 */
public String getCodigoArea() {
	return codigoArea;
}
/**
 * @param codigoArea ingresa el codigo area
 */
public void setCodigoArea(String codigoArea) {
	this.codigoArea = codigoArea;
}
/**
 * @return regresa el codigo talla
 */
public String getCodigoTalla() {
	return codigoTalla;
}
/**
 * @param codigoTalla ingresa el codigo talla
 */
public void setCodigoTalla(String codigoTalla) {
	this.codigoTalla = codigoTalla;
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
public String getNoCreditoInfonavit() {
	return noCreditoInfonavit;
}
/**
 * @param noCreditoInfonavit ingresa el credito infonavit
 */
public void setNoCreditoInfonavit(String noCreditoInfonavit) {
	this.noCreditoInfonavit = noCreditoInfonavit;
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
 * @return regresa la fecha de baja
 */
public Date getFechaBaja() {
	return fechaBaja;
}
/**
 * @param fechaBaja ingresa la fecha de baja
 */
public void setFechaBaja(Date fechaBaja) {
	this.fechaBaja = fechaBaja;
}
/**
 * @return regresa el codigo de salida
 */
public String getCodigoTipoSalida() {
	return codigoTipoSalida;
}
/**
 * @param codigoTipoSalida ingresa el codigo de salida
 */
public void setCodigoTipoSalida(String codigoTipoSalida) {
	this.codigoTipoSalida = codigoTipoSalida;
}
/**
 * @return regresa el codigo de causa
 */
public String getCodigoCausaSalida() {
	return codigoCausaSalida;
}
/**
 * @param codigoCausaSalida ingresa el codigo de causa
 */
public void setCodigoCausaSalida(String codigoCausaSalida) {
	this.codigoCausaSalida = codigoCausaSalida;
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
public ArrayList<EmpleadoDocumentoDTO> getObjDocumentos() {
	return objDocumentos;
}
/**
 * @param objDocumentos the objDocumentos to set
 */
public void setObjDocumentos(ArrayList<EmpleadoDocumentoDTO> objDocumentos) {
	this.objDocumentos = objDocumentos;
}
/**
 * @return the observaciones
 */
public String getObservaciones() {
	return observaciones;
}
/**
 * @param observaciones the observaciones to set
 */
public void setObservaciones(String observaciones) {
	this.observaciones = observaciones;
}
}
