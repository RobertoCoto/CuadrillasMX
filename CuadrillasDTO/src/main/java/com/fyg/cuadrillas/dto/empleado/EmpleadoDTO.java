package com.fyg.cuadrillas.dto.empleado;

import java.util.Date;
import java.util.List;

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
	 * frecuenciaPago
	 */
	private String frecuenciaPago;
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
	private List<EmpleadoDocumentoDTO> documentos;
	/** usuarioAlta	 */
	private String usuarioAlta;
	/** usuarioBaja	 */
	private String usuarioBaja;
	/** usuarioUltMod	 */
	private String usuarioUltMod;
	/**
	 * @return the idEmpleado
	 */
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellidoPat
	 */
	public String getApellidoPat() {
		return apellidoPat;
	}
	/**
	 * @param apellidoPat the apellidoPat to set
	 */
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}
	/**
	 * @return the apellidoMat
	 */
	public String getApellidoMat() {
		return apellidoMat;
	}
	/**
	 * @param apellidoMat the apellidoMat to set
	 */
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}
	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	/**
	 * @return the rfcCalculado
	 */
	public String getRfcCalculado() {
		return rfcCalculado;
	}
	/**
	 * @param rfcCalculado the rfcCalculado to set
	 */
	public void setRfcCalculado(String rfcCalculado) {
		this.rfcCalculado = rfcCalculado;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
	/**
	 * @return the codigoVialidad
	 */
	public String getCodigoVialidad() {
		return codigoVialidad;
	}
	/**
	 * @param codigoVialidad the codigoVialidad to set
	 */
	public void setCodigoVialidad(String codigoVialidad) {
		this.codigoVialidad = codigoVialidad;
	}
	/**
	 * @return the codigoArea
	 */
	public String getCodigoArea() {
		return codigoArea;
	}
	/**
	 * @param codigoArea the codigoArea to set
	 */
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	/**
	 * @return the codigoTalla
	 */
	public String getCodigoTalla() {
		return codigoTalla;
	}
	/**
	 * @param codigoTalla the codigoTalla to set
	 */
	public void setCodigoTalla(String codigoTalla) {
		this.codigoTalla = codigoTalla;
	}
	/**
	 * @return the sueldo
	 */
	public Double getSueldo() {
		return sueldo;
	}
	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	/**
	 * @return the frecuenciaPago
	 */
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}
	/**
	 * @param frecuenciaPago the frecuenciaPago to set
	 */
	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}
	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}
	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}
	/**
	 * @return the noCreditoInfonavit
	 */
	public String getNoCreditoInfonavit() {
		return noCreditoInfonavit;
	}
	/**
	 * @param noCreditoInfonavit the noCreditoInfonavit to set
	 */
	public void setNoCreditoInfonavit(String noCreditoInfonavit) {
		this.noCreditoInfonavit = noCreditoInfonavit;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}
	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	/**
	 * @return the codigoTipoSalida
	 */
	public String getCodigoTipoSalida() {
		return codigoTipoSalida;
	}
	/**
	 * @param codigoTipoSalida the codigoTipoSalida to set
	 */
	public void setCodigoTipoSalida(String codigoTipoSalida) {
		this.codigoTipoSalida = codigoTipoSalida;
	}
	/**
	 * @return the codigoCausaSalida
	 */
	public String getCodigoCausaSalida() {
		return codigoCausaSalida;
	}
	/**
	 * @param codigoCausaSalida the codigoCausaSalida to set
	 */
	public void setCodigoCausaSalida(String codigoCausaSalida) {
		this.codigoCausaSalida = codigoCausaSalida;
	}
	/**
	 * @return the fechaUltMod
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}
	/**
	 * @param fechaUltMod the fechaUltMod to set
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
	/**
	 * @return the documentos
	 */
	public List<EmpleadoDocumentoDTO> getDocumentos() {
		return documentos;
	}
	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<EmpleadoDocumentoDTO> documentos) {
		this.documentos = documentos;
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
	 * @return the usuarioBaja
	 */
	public String getUsuarioBaja() {
		return usuarioBaja;
	}
	/**
	 * @param usuarioBaja the usuarioBaja to set
	 */
	public void setUsuarioBaja(String usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
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
