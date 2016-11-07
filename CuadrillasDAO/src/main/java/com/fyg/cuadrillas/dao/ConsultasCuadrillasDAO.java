package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.resources.FabricaConexiones;
import com.fyg.cuadrillas.dto.Herramientas;
import com.fyg.cuadrillas.dto.Perfil;
import com.fyg.cuadrillas.dto.PruebaDTO;
import com.fyg.cuadrillas.dto.Usuario;


public class ConsultasCuadrillasDAO {
	/**
	 * Metododo de prueba para consultar
	 * @param uid Id unico de registro
	 * @param prueba valores de prueba
	 * @return regresa una lista de prueba
	 */
	@SuppressWarnings("unchecked")
	public List<PruebaDTO> consultaPrueba(String uid, PruebaDTO prueba) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<PruebaDTO> listaPrueba = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaPrueba = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaPrueba", prueba);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaPrueba;
	}
	/**
	 * Metodo para registrar datos prueba
	 * @param uid id unico de registro
	 * @param prueba , recibe valores de prueba
	 * @return regresa respuesta de registro
	 */
	 public EncabezadoRespuesta registraPrueba(String uid, PruebaDTO prueba) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Registro correcto.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
	     	int registros = sessionTx.insert("OperacionesCuadrillasDAO.insertaPrueba", prueba);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("Error en registrar.");
				}
				//Realizamos commit
				LogHandler.debug(uid, this.getClass(), "Commit!!!");
				sessionTx.commit();
			}
			catch (Exception ex) {
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
}
