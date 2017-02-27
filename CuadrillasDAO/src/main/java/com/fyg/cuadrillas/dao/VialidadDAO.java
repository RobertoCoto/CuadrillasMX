package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.vialidad.VialidadCoordenadasDTO;
import com.fyg.cuadrillas.dto.vialidad.VialidadDTO;

public class VialidadDAO {
	/**
	 * Metodo para registrar una vialidad
	 * @param uid unico de registro
	 * @param vialidad recibe valores de vialidad
	 * @return regresa la respuesta
	 */
	public EncabezadoRespuesta altaVialidad(String uid, VialidadDTO vialidad) {
		SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("registro correcto.");
		try {
			//Validamos si el catalogo ya existe
			sessionTx = FabricaConexiones.obtenerSesionNTx();
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.insert("VialidadDAO.registraVialidad", vialidad);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al registrar el catalogo.");
			}
			//registramos nuestras coordenadas
			if (vialidad.getCoordenadas().size() > 0) {
				for (VialidadCoordenadasDTO coordenadas : vialidad.getCoordenadas()) {
					coordenadas.setIdVialidad(vialidad.getIdVialidad());
				}
				registraCoordenadas(uid, vialidad.getCoordenadas(), sessionTx);
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
		}
		return respuesta;
	}
	/**
	 * Metodo para dar de baja una vialidad
	 * @param uid unico de registro
	 * @param vialidad recibe valores de vialidad
	 * @return regresa una respuesta
	 */
	public EncabezadoRespuesta bajaVialidad(String uid, VialidadDTO vialidad) {
		SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("La baja de la vialidad fue correcta.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("VialidadDAO.inactivaVialidad", vialidad);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("No fue posible dar de baja la vialidad.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
		} catch (Exception ex) {
			//Realizamos rollBack
			LogHandler.debug(uid, this.getClass(), "RollBack!!!");
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return respuesta;
	}
	/**
	 * Metodo para consultar la vialidad
	 * @param uid unico de registro
	 * @param vialidad recibe valores de vialidaad
	 * @return regresa  respuesta
	 * @throws Exception si surge error
	 */
	@SuppressWarnings("unchecked")
	public List<VialidadDTO> consultaVialidad(String uid, VialidadDTO vialidad) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<VialidadDTO> listaVialidad = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se hace una consulta a la tabla
			if ( vialidad.getOrden().equals("A")) {
				listaVialidad = sessionNTx.selectList("VialidadDAO.consultaVialidadAsc", vialidad);
			} else {
				listaVialidad = sessionNTx.selectList("VialidadDAO.consultaVialidadDesc", vialidad);
			}
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaVialidad;
	}
	/**
	 * Metodo para registrar coordenadas de las vialidades
	 * @param uid unico de registro
	 * @param coordenadas recibe valores de coordenadas
	 * @param session indica session
	 * @throws Exception si surge una excepcion
	 */
	public void registraCoordenadas(String uid, List<VialidadCoordenadasDTO> coordenadas, SqlSession session) throws Exception {
		  SqlSession sessionTx = null;
			//Logica para saber si es atomica la transaccion
			if ( session == null ) {
				 sessionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sessionTx = session;
			}
			//Validamos el registro
			int registros = sessionTx.insert("VialidadDAO.registraCoordenadas", coordenadas);
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
	 * Metodo para eliminar coordenadas
	 * @param uid unico de registro
	 * @param vialidad recibe valores de vialidad
	 * @param session crea una session
	 * @throws Exception si surge un error
	 */
	public void eliminaCoordenadas(String uid, VialidadDTO vialidad,  SqlSession session) throws Exception  {
		int registros = session.delete("VialidadDAO.eliminaCoordenadas", vialidad);
		LogHandler.debug(uid, this.getClass(), "Registros eliminados " + registros);
	}
}
