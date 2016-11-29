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
	private Integer listaAsistencia;
	/**
	 * Nombres
	 */
	private String nombres;
	/**
	 * Puesto del empleado
	 */
	private String puesto;
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
	 * @return the listaAsistencia
	 */
	public Integer getListaAsistencia() {
		return listaAsistencia;
	}
	/**
	 * @param listaAsistencia the listaAsistencia to set
	 */
	public void setListaAsistencia(Integer listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}
	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
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
}
