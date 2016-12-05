package com.fyg.cuadrillas.dto.empleado;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ObjetoValor;

public class PermisoLaboralRespuesta extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 8162869939874565734L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** permiso */
	private List<PermisoLaboralDTO> permiso;
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the permiso
	 */
	public List<PermisoLaboralDTO> getPermiso() {
		return permiso;
	}
	/**
	 * @param permiso the permiso to set
	 */
	public void setPermiso(List<PermisoLaboralDTO> permiso) {
		this.permiso = permiso;
	}
}
