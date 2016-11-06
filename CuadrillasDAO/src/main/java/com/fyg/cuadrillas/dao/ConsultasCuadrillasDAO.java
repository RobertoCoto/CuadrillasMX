package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.resources.FabricaConexiones;
import com.fyg.cuadrillas.dto.Catalogos;
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
	 * Metodo para consultar usuario
	 * @param uid unico
	 * @param usuario recibe valores de usuario
	 * @return regresa resultado de usuarios
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> consultaUsuario(String uid, Usuario usuario) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Usuario> listaUsuario = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaUsuario = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaUsuario", usuario);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaUsuario;
	}
	/**
	 * Metodo para consultar el perfil existente
	 * @param uid unico
	 * @param perfil recibe valores perfil
	 * @return regresa resultados
	 */
	@SuppressWarnings("unchecked")
	public List<Perfil> consultaPerfil(String uid, Perfil perfil) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Perfil> listaPerfil = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaPerfil = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaPerfil", perfil);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaPerfil;
	}
	/**
	 * Metodo para consultar los catalogos
	 * @param uid unico de registro
	 * @param catalogo valores de catalogos
	 * @return regresa una lista de catalogos
	 */
	@SuppressWarnings("unchecked")
	public List<Catalogos> consultaCatalogo(String uid, Catalogos catalogo) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Catalogos> listaCatalogos = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaCatalogos = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaCatalogo", catalogo);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaCatalogos;
	}
	/**
	 * Metodo para consultar los catalogos
	 * @param uid unico de registro
	 * @param catalogoOV valores de catalogos
	 * @return regresa una lista de catalogos
	 */
	@SuppressWarnings("unchecked")
	public List<Catalogos> consultaListaCatalogo(String uid, Catalogos catalogoOV) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Catalogos> listaCatalogos = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaCatalogos = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaListaCatalogo", catalogoOV);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaCatalogos;
	}
	/**
	 * Metodo para consultar Herramientas
	 * @param uid unico de registro
	 * @param herramientasOV recibe valores de herramienta
	 * @return regresa lista de herramientas
	 */
	@SuppressWarnings("unchecked")
	public List<Herramientas> consultaHerramientas(String uid, Herramientas herramientasOV) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Herramientas> listaHerramientas = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaHerramientas = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaHerramientas", herramientasOV);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaHerramientas;
	}
	/**
	 * Metodo general para consultar
	 * @param uid unico de registro
	 * @param herramientasOV recibe valores de herramientas
	 * @return regresa una lista de herramientas
	 */
	@SuppressWarnings("unchecked")
	public List<Herramientas> consultaListaHerramientas(String uid, Herramientas herramientasOV) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Herramientas> listaHerramientas = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaHerramientas = sessionNTx.selectList("ConsultasCuadrillasDAO.consultaListaHerramientas", herramientasOV);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
            respuesta.setEstatus(false);
    		respuesta.setMensajeFuncional(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaHerramientas;
	}
}
