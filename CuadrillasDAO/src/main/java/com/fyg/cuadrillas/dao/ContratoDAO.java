package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoDTO;

public class ContratoDAO {
	/**
	 * Metodo para dar de alta un contrato
	 * @param uid unico de registro
	 * @param contrato recoibe valores de contrato
	 * @return regresa la respuesta
	 */
	public EncabezadoRespuesta altaContrato(String uid, ContratoDTO contrato) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Validamos si ya existe un contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeContrato= (Integer) sessionNTx.selectOne("ContratoDAO.existeContrato", contrato);
			if (existeContrato > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe un registro del misto tipo de documento y numero documento vigente.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("ContratoDAO.altaContrato", contrato);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al registrar el contrato.");
			}
			System.out.println("ID Contrato = " + contrato.getIdContrato());
			if (contrato.getCoordenadas().size() > 0) {
				for (CoordenadaDTO coordenada : contrato.getCoordenadas()) {
					coordenada.setIdContrato(contrato.getIdContrato());
				}
				registraCoordenadas(uid, contrato.getCoordenadas(), sessionTx);
			}
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
	
	public void registraCoordenadas(String uid, List<CoordenadaDTO> coordenadas, SqlSession session)
			   throws Exception {
		   SqlSession sessionTx = null;
			//Logica para saber si es atomica la transaccion
			if ( session == null ) {
				 sessionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sessionTx = session;
			}
			//Validamos el registro
			int registros = sessionTx.insert("ContratoDAO.registraCoordenadasContrato", coordenadas);
			if ( registros == 0) {
				if ( session == null ) {
					FabricaConexiones.rollBack(sessionTx);
					FabricaConexiones.close(sessionTx);
				}
				throw new ExcepcionesCuadrillas("No se pudo registrar.");
			}
			//La conexion no es atomica realizamos commit
			if ( session == null ) {
				LogHandler.debug(uid, this.getClass(), "Commit conexion.");
				sessionTx.commit();
			}
			//La conexion no es atomica cerramos
			if ( session == null ) {
				LogHandler.debug(uid, this.getClass(), "Cerramos conexion.");
				FabricaConexiones.close(sessionTx);
			}
	 }

	 /**
	  * Metodo para eliminar los documentos registrados
	 * @param uid identificador unico
	 * @param empleado objeto empleado
	 * @param session transaccional
	 * @throws Exception error
	 */
	public void eliminaDocumentos(String uid, EmpleadoDTO empleado, SqlSession session)
		   throws Exception {
		int registros = session.delete("EmpleadoDAO.eliminaDocumentos", empleado);
		LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
		//La conexion no es atomica realizamos commit
	 }

	/**
	 * Metodo para dar de baja un contrato
	 * @param uid unico de registro
	 * @param contrato recibe valores de contrat
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta bajaContrato (String uid, ContratoDTO contrato) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("baja correcto.");
		try {
			//Validamos si ya esta dado de baja el contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeBajaContrato= (Integer) sessionNTx.selectOne("ContratoDAO.existeBajaContrato", contrato);
			if (existeBajaContrato > 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja, el contrato ya se encuentra inactivo.");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("ContratoDAO.bajaContrato", contrato);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja el contrato.");
			}
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
