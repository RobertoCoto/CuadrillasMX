package com.fyg.cuadrillas.dto.actividad;

import com.fyg.cuadrillas.comun.ObjetoValor;

public class ActividadDTO extends ObjetoValor {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -3786704476128984542L;
	private Integer idActividad;
	private Integer idCuadrilla;
	private String tramoInicialPlanificado;
	private String tramoFinalPlanificado;
	private Float alcancePlanificado;
	private String tramoInicialReal;
	private String tramoFinalReal;
	private Float alcanceReal;
	
}
