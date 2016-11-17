package com.fyg.cuadrillas.dto;

import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class Usuario extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1571417524130812122L;
	/**
	 * Usuario
	 */
	private String usuario;
	/**
	 * Id unico del perfil
	 */
	private Integer idPerfil;
	/**
	 * Contrasena del usuario
	 */
	private String contrasena;
	/**
	 * Si cambia contrasena o no
	 */
	private String cambioContrasena;
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
	 * nombre del perfil
	 */
	private String perfilNombre;
	/**
	 * id del menu
	 */
	private Integer perfilMenu;
	/**
	 * numero de orden
	 */
	private Integer perfilOrden;
	/**
	 * Nombre del menu
	 */
	private String menu;
	/**
	 * descripcion del menu
	 */
	private String menuDescripcion;
	/**
	 * url del menu
	 */
	private String menuUrl;
	/**
	 * id del padre
	 */
	private Integer idPadre;
	/**
	 * id del menu
	 */
	private Integer idMenu;
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
	 * @return the perfilNombre
	 */
	public String getPerfilNombre() {
		return perfilNombre;
	}
	/**
	 * @param perfilNombre the perfilNombre to set
	 */
	public void setPerfilNombre(String perfilNombre) {
		this.perfilNombre = perfilNombre;
	}
	/**
	 * @return the perfilMenu
	 */
	public Integer getPerfilMenu() {
		return perfilMenu;
	}
	/**
	 * @param perfilMenu the perfilMenu to set
	 */
	public void setPerfilMenu(Integer perfilMenu) {
		this.perfilMenu = perfilMenu;
	}
	/**
	 * @return the perfilOrden
	 */
	public Integer getPerfilOrden() {
		return perfilOrden;
	}
	/**
	 * @param perfilOrden the perfilOrden to set
	 */
	public void setPerfilOrden(Integer perfilOrden) {
		this.perfilOrden = perfilOrden;
	}
	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
	/**
	 * @return the menuDescripcion
	 */
	public String getMenuDescripcion() {
		return menuDescripcion;
	}
	/**
	 * @param menuDescripcion the menuDescripcion to set
	 */
	public void setMenuDescripcion(String menuDescripcion) {
		this.menuDescripcion = menuDescripcion;
	}
	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}
	/**
	 * @param menuUrl the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	/**
	 * @return the idPadre
	 */
	public Integer getIdPadre() {
		return idPadre;
	}
	/**
	 * @param idPadre the idPadre to set
	 */
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	/**
	 * @return the idMenu
	 */
	public Integer getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
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
	}
