package com.fyg.cuadrillas.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDocumentoDTO;

public class EmpleadoDAO {

	/**
	 * Metodo Para dar de Alta un Empleado
	 * @param uid unico de registro
	 * @param empleado recibe los valores del empleado
	 * @return regresa respuesta de registro
	 */
	 public EncabezadoRespuesta registraEmpleado(String uid, EmpleadoDTO empleado) {
		 	SqlSession sessionTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("registro correcto.");
			try {
				//Abrimos conexion Transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
		        int registros = sessionTx.insert("EmpleadoDAO.registraEmpleado", empleado);
				if ( registros == 0) {
					throw new ExcepcionesCuadrillas("Error al registrar el empleado.");
				}

				if (empleado.getDocumentos().size() > 0) {
					for (EmpleadoDocumentoDTO documento : empleado.getDocumentos()) {
						documento.setIdEmpleado(empleado.getIdEmpleado());
					}
					registraDocumentos(uid, empleado.getDocumentos(), sessionTx);
				}
				//Realizamos commit
				LogHandler.debug(uid, this.getClass(), "Commit!!!");
				sessionTx.commit();
			}
			catch (Exception ex) {
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
	  * Metodo Para registrar los documentos del empleado
	  * @param uid uid unico
	  * @param empleadoDocumentos recibe los documentos del empleado
	  * @param session crea una session
	  * @return regresa la respuesta
	  * @throws Exception si surge alguna excepcion
	  */
   public void registraDocumentos(String uid, List<EmpleadoDocumentoDTO> empleadoDocumentos, SqlSession session) 
		   throws Exception {
	   SqlSession sessionTx = null;
		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
	
		//Validamos el registro
		int registros = sessionTx.insert("EmpleadoDAO.registraDocumentos", empleadoDocumentos);
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
    * Metodo para dar de baja un Empleado
    * @param uid unico de registro
    * @param empleado recibe los valores de empleado
    * @return regresa respuesta
    */
   public EncabezadoRespuesta bajaEmpleado(String uid,EmpleadoDTO empleado) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("baja correcto.");
		try {
			//Abrimos conexion Transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("EmpleadoDAO.bajaEmpleado", empleado);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al dar de baja.");
			}
           
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
			
				
			registraDocumentos(uid,empleado.getDocumentos(), sessionTx);
		}
		catch (Exception ex) {
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
    * Metodo para consultar empleados
    * @param uid unico de consulta
    * @param empleado recibe los valores del empleado
    * @return retorna lista Empleado
    */
   @SuppressWarnings("unchecked")
public List<EmpleadoDTO> consultaEmpleado(String uid, EmpleadoDTO empleado)throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<EmpleadoDTO> listaEmpleado = null;
		try {
			//Abrimos conexion Transaccional
			System.out.println("Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			System.out.println("Consultando");
			//Se hace una consulta a la tabla
			listaEmpleado = sessionNTx.selectList("EmpleadoDAO.consultaEmpleado", empleado);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaEmpleado;
	}
   /**
    * Metodo para modificar los datos del empleado
    * @param uid unico de registro
    * @param empleado recibe valores de empleado
    * @return regresa la respuesta
    */
   public EncabezadoRespuesta modificaEmpleado(String uid,EmpleadoDTO empleado) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("modificacion correcta.");
		try {
			//Abrimos conexion Transaccional
			//documento = new EmpleadoDocumentoDTO();
			//documento.setIdEmpleado(empleado.getIdEmpleado());
			//envia el id al metodo que elimina el documentos
			//eliminaDocumentos(uid,documento);
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("EmpleadoDAO.modificaEmpleado", empleado);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar al empleado.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
			
			//se envia los nuevos datos para registrar
			//objDocumentos = empleado;
			registraDocumentos(uid,empleado.getDocumentos(), sessionTx);
		}
		catch (Exception ex) {
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
   public EncabezadoRespuesta eliminaDocumentos(String uid,EmpleadoDocumentoDTO empleadoDocumentos) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("eliminacion correcta.");
		try {
			//Abrimos conexion Transaccional
			
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("EmpleadoDAO.eliminaDocumentos", empleadoDocumentos);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar al empleado.");
			}
         
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
			
		}
		catch (Exception ex) {
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
   }

