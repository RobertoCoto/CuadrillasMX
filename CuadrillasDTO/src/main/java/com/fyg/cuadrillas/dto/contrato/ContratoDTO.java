package com.fyg.cuadrillas.dto.contrato;

import java.util.Date;
import java.util.List;

import com.fyg.cuadrillas.comun.ObjetoValor;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.cuadrilla.CuadrillaDTO;

public class ContratoDTO extends ObjetoValor {

	/** Serial UID */
	private static final long serialVersionUID = -1670407171238552004L;
	/** idContrato */
	private Integer idContrato;
	/** codigoVialidad */
	private String codigoVialidad;
	/** codigoContrato */
	private String codigoContrato;
	/** codigoDocumento */
	private String codigoDocumento;
	/** codigoEmpresa */
	private String codigoEmpresa;
	/** numero del contrato */
	private String numeroDocumento;
	/** monto */
	private double monto;
	/** subtotal */
	private double subtotal;
	/** fechaInicio */
	private String fechaInicio;
	/** fechaFin */
	private String fechaFin;
	/** diasDuracion */
	private int diasDuracion;
	/** pctAvance */
	private double pctAvance;
	/** fechaRegistro */
	private Date fechaRegistro;
	/** idCuadrilla */
	private Integer idCuadrilla;
	/** cuadrilla */
	private CuadrillaDTO cuadrilla;
	/** observaciones */
	private String observaciones;
	/** url */
	private String url;
	/** metros */
	private int metros;
	/** coordenadas */
	private List<CoordenadaDTO> coordenadas;
	/** estatus */
	private String estatus;
	/** usuarioAlta */
	private String usuarioAlta;
	/** usuarioBaja */
	private String usuarioBaja;
	/** usuarioUltMod */
	private String usuarioUltMod;
	/** numeroPersonas */
	private Integer numeroPersonas;
	/** horasTotales */
    private Integer horasTotales;
    /** idEmpleadoResidente */
	private Integer idEmpleadoResidente;
	/** nombreResidente */
	private String nombreResidente;
	/** descripcionVialidad */
	private String descripcionVialidad;
	/** nombreCuadrilla */
	private String nombreCuadrilla;
	/** calificacionCuadrilla */
	private Integer calificacionCuadrilla;
	/** horaLaboral */
	private Integer horaLaboral;
	/** fechaRegistroContrato */
	private String fechaRegistroContrato;
	/** fechaActual */
	private String fechaActual;
	/**
	 * @return the idContrato
	 */
	public Integer getIdContrato() {
		return idContrato;
	}
	/**
	 * @param idContrato the idContrato to set
	 */
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
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
	 * @return the codigoContrato
	 */
	public String getCodigoContrato() {
		return codigoContrato;
	}
	/**
	 * @param codigoContrato the codigoContrato to set
	 */
	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}
	/**
	 * @return the codigoDocumento
	 */
	public String getCodigoDocumento() {
		return codigoDocumento;
	}
	/**
	 * @param codigoDocumento the codigoDocumento to set
	 */
	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	/**
	 * @return the codigoEmpresa
	 */
	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}
	/**
	 * @param codigoEmpresa the codigoEmpresa to set
	 */
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}
	/**
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}
	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	/**
	 * @return the diasDuracion
	 */
	public int getDiasDuracion() {
		return diasDuracion;
	}
	/**
	 * @param diasDuracion the diasDuracion to set
	 */
	public void setDiasDuracion(int diasDuracion) {
		this.diasDuracion = diasDuracion;
	}
	/**
	 * @return the pctAvance
	 */
	public double getPctAvance() {
		return pctAvance;
	}
	/**
	 * @param pctAvance the pctAvance to set
	 */
	public void setPctAvance(double pctAvance) {
		this.pctAvance = pctAvance;
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
	/**
	 * @return the cuadrilla
	 */
	public CuadrillaDTO getCuadrilla() {
		return cuadrilla;
	}
	/**
	 * @param cuadrilla the cuadrilla to set
	 */
	public void setCuadrilla(CuadrillaDTO cuadrilla) {
		this.cuadrilla = cuadrilla;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the metros
	 */
	public int getMetros() {
		return metros;
	}
	/**
	 * @param metros the metros to set
	 */
	public void setMetros(int metros) {
		this.metros = metros;
	}
	/**
	 * @return the coordenadas
	 */
	public List<CoordenadaDTO> getCoordenadas() {
		return coordenadas;
	}
	/**
	 * @param coordenadas the coordenadas to set
	 */
	public void setCoordenadas(List<CoordenadaDTO> coordenadas) {
		this.coordenadas = coordenadas;
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
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	/**
	 * @return the numeroPersonas
	 */
	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}
	/**
	 * @param numeroPersonas the numeroPersonas to set
	 */
	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	/**
	 * @return the horasTotales
	 */
	public Integer getHorasTotales() {
		return horasTotales;
	}
	/**
	 * @param horasTotales the horasTotales to set
	 */
	public void setHorasTotales(Integer horasTotales) {
		this.horasTotales = horasTotales;
	}
	/**
	 * @return the idEmpleadoResidente
	 */
	public Integer getIdEmpleadoResidente() {
		return idEmpleadoResidente;
	}
	/**
	 * @param idEmpleadoResidente the idEmpleadoResidente to set
	 */
	public void setIdEmpleadoResidente(Integer idEmpleadoResidente) {
		this.idEmpleadoResidente = idEmpleadoResidente;
	}
	/**
	 * @return the nombreResidente
	 */
	public String getNombreResidente() {
		return nombreResidente;
	}
	/**
	 * @param nombreResidente the nombreResidente to set
	 */
	public void setNombreResidente(String nombreResidente) {
		this.nombreResidente = nombreResidente;
	}
	/**
	 * @return the descripcionVialidad
	 */
	public String getDescripcionVialidad() {
		return descripcionVialidad;
	}
	/**
	 * @param descripcionVialidad the descripcionVialidad to set
	 */
	public void setDescripcionVialidad(String descripcionVialidad) {
		this.descripcionVialidad = descripcionVialidad;
	}
	/**
	 * @return the nombreCuadrilla
	 */
	public String getNombreCuadrilla() {
		return nombreCuadrilla;
	}
	/**
	 * @param nombreCuadrilla the nombreCuadrilla to set
	 */
	public void setNombreCuadrilla(String nombreCuadrilla) {
		this.nombreCuadrilla = nombreCuadrilla;
	}
	/**
	 * @return the calificacionCuadrilla
	 */
	public Integer getCalificacionCuadrilla() {
		return calificacionCuadrilla;
	}
	/**
	 * @param calificacionCuadrilla the calificacionCuadrilla to set
	 */
	public void setCalificacionCuadrilla(Integer calificacionCuadrilla) {
		this.calificacionCuadrilla = calificacionCuadrilla;
	}
	/**
	 * @return the horaLaboral
	 */
	public Integer getHoraLaboral() {
		return horaLaboral;
	}
	/**
	 * @param horaLaboral the horaLaboral to set
	 */
	public void setHoraLaboral(Integer horaLaboral) {
		this.horaLaboral = horaLaboral;
	}
	/**
	 * @return the fechaRegistroContrato
	 */
	public String getFechaRegistroContrato() {
		return fechaRegistroContrato;
	}
	/**
	 * @param fechaRegistroContrato the fechaRegistroContrato to set
	 */
	public void setFechaRegistroContrato(String fechaRegistroContrato) {
		this.fechaRegistroContrato = fechaRegistroContrato;
	}
	/**
	 * @return the fechaActual
	 */
	public String getFechaActual() {
		return fechaActual;
	}
	/**
	 * @param fechaActual the fechaActual to set
	 */
	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}
}
