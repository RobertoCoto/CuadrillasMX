package com.fyg.cuadrillas.negocio;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.ContratoDAO;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;

public class ContratoNegocio {
	/**
	 * Metodo para dar de alta un contrato
	 * @param contrato recibe valores del contrato
	 * @return regresa la respuesta
	 */
	public EncabezadoRespuesta altaContrato(ContratoDTO contrato) {
		//Primero generamos el identificador unico de la transaccion
				String uid = GUIDGenerator.generateGUID(contrato);
				//Mandamos a log el objeto de entrada
				LogHandler.debug(uid, this.getClass(), "altaContrato - Datos Entrada: " + contrato);
				//Variable de resultado
				EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
				try { 
					if (contrato.getNumeroContrato() == null) {
						throw new ExcepcionesCuadrillas("Es necesario el numero de contrato.");
					}
					if (contrato.getTramoInicial() == null || contrato.getTramoInicial().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el tramo inicial.");
					}
					if (contrato.getTramoFinal() == null || contrato.getTramoFinal().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el tramo Final.");
					}
					ContratoDAO dao = new ContratoDAO();
					respuesta = dao.altaContrato(uid, contrato);
				} catch  (ExcepcionesCuadrillas ex) {
					LogHandler.error(uid, this.getClass(), "altaContrato - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				catch  (Exception ex) {
					LogHandler.error(uid, this.getClass(), "altaContrato - Error: " + ex.getMessage(), ex);
					respuesta.setUid(uid);
					respuesta.setEstatus(false);
					respuesta.setMensajeFuncional(ex.getMessage());
					respuesta.setMensajeTecnico(ex.getMessage());
				}
				LogHandler.debug(uid, this.getClass(), "altaContrato - Datos Salida: " + respuesta);
				return respuesta;
	}
}
