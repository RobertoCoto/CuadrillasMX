package com.fyg.cuadrillas.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.CoordenadaDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDTO;
import com.fyg.cuadrillas.dto.contrato.ContratoDocumentoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;

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
		respuesta.setMensajeFuncional("El contrato ah sido registrado correctamente.");
		try {
			//Validamos si ya existe un contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeContrato = (Integer) sessionNTx.selectOne("ContratoDAO.existeContrato", contrato);
			if (existeContrato > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe un registro del misto "
						+ "tipo de documento y numero documento vigente.");
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

	/**
	 * Metodo para registrar las coordenadas de un contrato
	 * @param uid identificador unico de la transaccion
	 * @param coordenadas lista de coordenada
	 * @param session transaccional
	 * @throws Exception
	 */
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
	public EncabezadoRespuesta bajaContrato(String uid, ContratoDTO contrato) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("baja correcto.");
		try {
			//Validamos si ya esta dado de baja el contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeBajaContrato = (Integer) sessionNTx.selectOne("ContratoDAO.existeBajaContrato", contrato);
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

	/**
	 * Metodo para consultar contratos
	 * @param uid identificador unico
	 * @param contrato datos para filtros
	 * @return lista de contratos
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ContratoDTO> consultaContrato(String uid, ContratoDTO contrato) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<ContratoDTO> listaContrato = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla
			LogHandler.debug(uid, this.getClass(), "Consultando");
			listaContrato = sessionNTx.selectList("ContratoDAO.consultaContrato", contrato);
			for (ContratoDTO c : listaContrato) {
					List<CoordenadaDTO> coordenadas = null;
					coordenadas = sessionNTx.selectList("ContratoDAO.consultaContratoCoordenadas", c);
					c.setCoordenadas(coordenadas);
			}
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaContrato;
	  }
	/**
	 * Metodo para consultar contratos activos
	 * @param uid unico de registro
	 * @param contrato recibe valores de contrato
	 * @return regresa una lista de contrato
	 * @throws Exception si existe un error
	 */
	@SuppressWarnings("unchecked")
	public List<ContratoDTO> contratoActivo(String uid, ContratoDTO contrato) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<ContratoDTO> listaContratoActivo = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla
			listaContratoActivo = sessionNTx.selectList("ContratoDAO.contratoActivo", contrato);
			if ( listaContratoActivo.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen contratos actualmente.");
			}
			for (ContratoDTO c : listaContratoActivo) {
				List<CoordenadaDTO> coordenadas = null;
				coordenadas = sessionNTx.selectList("ContratoDAO.consultaContratoCoordenadas", c);
				c.setCoordenadas(coordenadas);
		    }
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaContratoActivo;
	}
	/**
	 * Metodo para consultar contratos activos
	 * @param uid unico de registro
	 * @param contrato recibe valores de contrato
	 * @return regresa una lista de contrato
	 * @throws Exception si existe un error
	 */
	@SuppressWarnings("unchecked")
	public List<ContratoDTO> consultacontratoDocumento(String uid, ContratoDTO contrato) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<ContratoDTO> listaContratoDocumento = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla
			listaContratoDocumento = sessionNTx.selectList("ContratoDAO.consultaContratoDocumento", contrato);
			if ( listaContratoDocumento.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen documentos actualmente.");
			}
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaContratoDocumento;
	}
	/**
	 * Metodo para modificar un contrato
	 * @param uid unico de registro
	 * @param contrato recoibe valores de contrato
	 * @return regresa la respuesta
	 */
	public EncabezadoRespuesta modificaContrato(String uid, ContratoDTO contrato) {
		SqlSession sessionTx = null;
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("el contrato se ha modificado correctamente.");
		try {
			//Validamos si ya existe un contrato
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeContrato = (Integer) sessionNTx.selectOne("ContratoDAO.existeContrato", contrato);
			if (existeContrato != 1) {
				throw new ExcepcionesCuadrillas("Error al actualizar, no existe contrato ");
			}
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("ContratoDAO.modificaContrato", contrato);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al actualizar el contrato.");
			}
			System.out.println("ID Contrato = " + contrato.getIdContrato());
			//elimina las coordenadas anteriores
			EliminaCoordenadas(uid, contrato.getIdContrato(), sessionTx );
			if (contrato.getCoordenadas().size() > 0) {
				for (CoordenadaDTO coordenada : contrato.getCoordenadas()) {
					coordenada.setIdContrato(contrato.getIdContrato());
				}
				registraCoordenadas(uid, contrato.getCoordenadas(), sessionTx);
			}
			
			if (contrato.getContratoDocumento().size() > 0) {
				for (ContratoDocumentoDTO documento : contrato.getContratoDocumento()) {
					documento.setIdContrato(contrato.getIdContrato());
				}
				registraDocumentosExtra(uid, contrato.getContratoDocumento(), sessionTx);
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
/**
 * Metodo para registrar los documentos extra del contrato
 * @param uid unico de registro
 * @param contratoDocumento recibe valores de documento
 * @param session abre session bd
 * @throws Exception si surge una excepcion
 */
public void registraDocumentosExtra(String uid, List<ContratoDocumentoDTO> contratoDocumento, SqlSession session) throws Exception {
	SqlSession sessionTx = null;
	//Logica para saber si es atomica la transaccion
	if ( session == null ) {
		 sessionTx = FabricaConexiones.obtenerSesionTx();
	} else {
		sessionTx = session;
	}
	//Validamos el registro
	int registros = sessionTx.insert("ContratoDAO.registraContratoDocumentosExtra", contratoDocumento);
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
	 * metodo para eliminar la coordenada
	 * @param uid unico de registro
	 * @param coordenadas recibe valores de coordenada
	 * @param session abre session bd
	 * @throws Exception si surge un error
	 */
public void EliminaCoordenadas(String uid, int idContrato , SqlSession session) throws Exception {
	HashMap<Object, Object> parametros = new HashMap<Object, Object>();
	parametros.put("id_contrato", idContrato);
	int registros = session.delete("ContratoDAO.eliminaCoordenadass", parametros);
	LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
	}
}
