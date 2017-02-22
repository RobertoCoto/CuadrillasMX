package com.fyg.cuadrillas.dao;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.agenda.AgendaDTO;

public class AgendaDAO {

	/**
	 * Metodo para registrar la agenda de un contrato
	 * @param uid identificador unico de la transaccion
	 * @param agenda datos de la agenda
	 * @return respuesta del registro
	 */
	public EncabezadoRespuesta altaAgenda(String uid, AgendaDTO agenda) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Validamos si ya existe un contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeContrato = (Integer) sessionNTx.selectOne("AgendaDAO.existeAgenda", agenda);
			if (existeContrato > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe un registro del misto "
						+ "tipo de documento y numero documento vigente.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("AgendaDAO.altaAgenda", agenda);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al registrar la agenda.");
			}
			/*
			System.out.println("ID Contrato = " + contrato.getIdContrato());
			if (contrato.getCoordenadas().size() > 0) {
				for (CoordenadaDTO coordenada : contrato.getCoordenadas()) {
					coordenada.setIdContrato(contrato.getIdContrato());
				}
				registraCoordenadas(uid, contrato.getCoordenadas(), sessionTx);
			}
			*/
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();

		} catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!");
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}
}
