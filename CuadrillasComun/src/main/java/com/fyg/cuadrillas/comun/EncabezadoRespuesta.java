package com.fyg.cuadrillas.comun;

public class EncabezadoRespuesta extends ObjetoValor {
	/**
	 *
	 */
	private static final long serialVersionUID = 6856742685439609818L;
	/**
	 * Estatus
	 */
	private boolean estatus;
	/**
	 * UID unico de registro
	 */
	private String uid;
	/**
	 * Mensaje tecnico
	 */
	private String mensajeTecnico;
	/**
	 * Mensaje funcional
	 */
	private String mensajeFuncional;
	/**
	 * Codigo generado
	 */
	private String codigo;

	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the mensajeTecnico
	 */
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	/**
	 * @param mensajeTecnico the mensajeTecnico to set
	 */
	public void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}

	/**
	 * @return the mensajeFuncional
	 */
	public String getMensajeFuncional() {
		return mensajeFuncional;
	}

	/**
	 * @param mensajeFuncional the mensajeFuncional to set
	 */
	public void setMensajeFuncional(String mensajeFuncional) {
		this.mensajeFuncional = mensajeFuncional;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
