package com.fyg.cuadrillas.dto.asistencia;

import java.sql.Time;
import java.util.Date;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class AsistenciaDTO extends ObjetoValor {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -5220617460196328147L;
	/**
	 * Lista Asistencia
	 */
	private Integer idAsistencia;
	/**
	 * nombre
	 */
	private String nombre;
	/**
	 * codigo_puesto
	 */
	private String codigoPuesto;
	/**
	 * Fecha
	 */
	private Date fecha;
	/**
	 * Comentarios
	 */
	private String comentarios;
    /**
     * Hora de entrada
     */
	private Time horaEntrada;
 	/**
 	 * Hora de Salida
 	 */
	private Time horaSalida;
	/**
	 * obtiene el idEmpleado
	 */
	private Integer idEmpleado;
	/**
	 * usuario Alta
	 */
	private String usuarioAlta;
	/**
	 * fecha Alta
	 */
	private Date fechaAlta;
	/**
	 * usuario baja
	 */
	private String usuarioBaja;
	/**
	 * fecha baja
	 */
	private Date fechaBaja;
	/**
	 * fecha ult mod
	 */
	private Date fechaUltMod;
	/**
	 * usuario ultima mod
	 */
	private String usuarioUltMod;
	/**
	 * estatus
	 */
	private String estatus;
	/**
	 * @return the idAsistencia
	 */
	public Integer getIdAsistencia() {
		return idAsistencia;
	}
	/**
	 * @param idAsistencia the idAsistencia to set
	 */
	public void setIdAsistencia(Integer idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}
	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	/**
	 * @return the horaEntrada
	 */
	public Time getHoraEntrada() {
		return horaEntrada;
	}
	/**
	 * @param horaEntrada the horaEntrada to set
	 */
	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	/**
	 * @return the horaSalida
	 */
	public Time getHoraSalida() {
		return horaSalida;
	}
	/**
	 * @param horaSalida the horaSalida to set
	 */
	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
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
