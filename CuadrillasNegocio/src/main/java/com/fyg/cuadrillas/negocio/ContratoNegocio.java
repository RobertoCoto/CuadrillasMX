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
					if (contrato.getDireccionInicial() == null || contrato.getDireccionInicial().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario la direccion inicial.");
					}
					if (contrato.getDireccionFinal() == null || contrato.getDireccionFinal().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario la direccion Final.");
					}
					if (contrato.getLatitudInicial() < 0 ) {
						throw new ExcepcionesCuadrillas("Es necesario la latitud inicial.");
					}
					if (contrato.getLongitudInicial() < 0 ) {
						throw new ExcepcionesCuadrillas("Es necesario la longitud inicial.");
					}
					if (contrato.getLatitudFinal() < 0 ) {
						throw new ExcepcionesCuadrillas("Es necesario la latitud Final.");
					}
					if (contrato.getLongitudFinal() < 0 ) {
						throw new ExcepcionesCuadrillas("Es necesario la longitud final.");
					}
					if (contrato.getUrl() == null || contrato.getUrl().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario adjuntar la localizacion del documento.");
					}
					if (contrato.getUsuarioAlta() == null || contrato.getUsuarioAlta().trim().isEmpty()) {
						throw new ExcepcionesCuadrillas("Es necesario el usuario alta.");
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
	
	public EncabezadoRespuesta bajaContrato (ContratoDTO contrato) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(contrato);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "bajaContrato - Datos Entrada: " + contrato);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		try {
			if(contrato.getNumeroContrato() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el numero de contrato.");
			}
			if(contrato.getIdEmpleado() == null) {
				throw new ExcepcionesCuadrillas("Es necesario el id empleado.");
			}
			if (contrato.getUsuarioBaja() == null || contrato.getUsuarioBaja().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario baja.");
			}
			if (contrato.getUsuarioUltMod() == null || contrato.getUsuarioUltMod().trim().isEmpty()) {
				throw new ExcepcionesCuadrillas("Es necesario el usuario.");
			}
			ContratoDAO dao = new ContratoDAO();
			respuesta = dao.bajaContrato(uid, contrato);
			
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "bajaContrato - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		catch  (Exception ex) {
			LogHandler.error(uid, this.getClass(), "bajaContrato - Error: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
		}
		LogHandler.debug(uid, this.getClass(), "bajaContrato - Datos Salida: " + respuesta);
		return respuesta;
	}
}
