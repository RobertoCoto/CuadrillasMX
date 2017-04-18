package com.fyg.cuadrillas.dto.usuario;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class UsuarioDTO extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1571417524130812122L;
	/**
	 * Usuario
	 */
	private String usuario;
	/**
	 * nombreUsuario
	 */
	private String nombreUsuario;
	/**
	 * Id unico del perfil
	 */
	private Integer idPerfil;
	/**
	 * id del empleado
	 */
	private Integer idEmpleado;
	/**
	 * nombreUsuario
	 */
	private String nombrePerfil;
	/**
	 * nombre
	 */
	private String nombre;
	/**
	 * apellido paterno
	 */
	private String apellidoPat;
	/**
	 * apeliido materno
	 */
	private String apellidoMat;
	/**
	 * sexo
	 */
	private String sexo;
	/**
	 * rfc
	 */
	private String rfc;
	/**
	 * rfc calculado
	 */
	private String rfcCalculado;
	/**
	 * fecha de nacimiento
	 */
	private String fechaNacimiento;
	/**
	 * Contrasena del usuario
	 */
	private String contrasena;
	/**
	 * Si cambia contrasena o no
	 */
	private String cambioContrasena;
	/**
	 * contrasena Anterior
	 */
	private String contrasenaAnterior;
	/**
	 * contrasena Nueva
	 */
	private String contrasenaNueva;
	/**
	 * repetir contrasena nueva
	 */
	private String repetirContrasenaNueva;
	/**
	 * Fecha de ultimo acceso
	 */
	private Date fechaUltimoAcceso;
	/**
	 * Fecha_alta del usuario
	 */
	private Date fechaAlta;
	/**
	 * Fecha ultima modificacion
	 */
	private Date fechaUltMod;
	/**
	 * estatus del usuario
	 */
	private String estatus;
	/**
	 * Id unico del perfil
	 */
	private Integer idCuadrilla;
	/**
	 * @return obtiene el usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario ingresa el  usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
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
	 * @return obtiene la contraseña
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena ingresa la contraseña
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @return obtiene el cambio de contraseña
	 */
	public String getCambioContrasena() {
		return cambioContrasena;
	}
	/**
	 * @param cambioContrasena ingresa el cambio de contraseña
	 */
	public void setCambioContrasena(String cambioContrasena) {
		this.cambioContrasena = cambioContrasena;
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
	 * @return the fechaUltimoAcceso
	 */
	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	/**
	 * @param fechaUltimoAcceso the fechaUltimoAcceso to set
	 */
	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the nombrePerfil
	 */
	public String getNombrePerfil() {
		return nombrePerfil;
	}
	/**
	 * @param nombrePerfil the nombrePerfil to set
	 */
	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the contrasenaAnterior
	 */
	public String getContrasenaAnterior() {
		return contrasenaAnterior;
	}
	/**
	 * @param contrasenaAnterior the contrasenaAnterior to set
	 */
	public void setContrasenaAnterior(String contrasenaAnterior) {
		this.contrasenaAnterior = contrasenaAnterior;
	}
	/**
	 * @return the contrasenaNueva
	 */
	public String getContrasenaNueva() {
		return contrasenaNueva;
	}
	/**
	 * @param contrasenaNueva the contrasenaNueva to set
	 */
	public void setContrasenaNueva(String contrasenaNueva) {
		this.contrasenaNueva = contrasenaNueva;
	}
	/**
	 * @return the repetirContrasenaNueva
	 */
	public String getRepetirContrasenaNueva() {
		return repetirContrasenaNueva;
	}
	/**
	 * @param repetirContrasenaNueva the repetirContrasenaNueva to set
	 */
	public void setRepetirContrasenaNueva(String repetirContrasenaNueva) {
		this.repetirContrasenaNueva = repetirContrasenaNueva;
	}
	/**
	 * @return the idCuadrilla
	 */
	public Integer getIdCuadrilla() {
		return idCuadrilla;
	}
	/**
	 * @param idCuadrilla the idCuadrilla to set
	 */
	public void setIdCuadrilla(Integer idCuadrilla) {
		this.idCuadrilla = idCuadrilla;
	}

}
