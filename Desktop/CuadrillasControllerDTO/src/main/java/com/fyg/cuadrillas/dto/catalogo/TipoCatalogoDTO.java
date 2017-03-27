package com.fyg.cuadrillas.dto.catalogo;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class TipoCatalogoDTO extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5578316171510032137L;
	/**
	 * tipo catalogo
	 */
	 private String tipoCatalogo;
	 /**
	  * descripcion del catalogo
	  */
	 private String descripcion;
	/**
	 * @return the tipoCatalogo
	 */
	public String getTipoCatalogo() {
		return tipoCatalogo;
	}
	/**
	 * @param tipoCatalogo the tipoCatalogo to set
	 */
	public void setTipoCatalogo(String tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
