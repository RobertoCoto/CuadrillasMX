package com.fyg.cuadrillas.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Empleado;
import com.fyg.cuadrillas.dto.EmpleadoDocumentos;

public class EmpleadoDAO {
	/**
	 * Objeto que recibira los valores del documento
	 */
	private Empleado objDocumentos;
	private EmpleadoDocumentos documento;
	/**
	 * Metodo Para dar de Alta un Empleado
	 * @param uid unico de registro
	 * @param empleado recibe los valores del empleado
	 * @return regresa respuesta de registro
	 */
	 public EncabezadoRespuesta registraEmpleado(String uid,Empleado empleado) {
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
                
				//Realizamos commit
				LogHandler.debug(uid, this.getClass(), "Commit!!!");
				sessionTx.commit();
				
				objDocumentos = empleado;	
				registraDocumentos(uid,empleado.getObjDocumentos(), sessionTx);
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
   public ArrayList<EmpleadoDocumentos> registraDocumentos(String uid,ArrayList<EmpleadoDocumentos> empleadoDocumentos, SqlSession session) throws Exception {
	   SqlSession sessionTx = null;

		//Logica para saber si es atomica la transaccion
		if ( session == null ) {
			 sessionTx = FabricaConexiones.obtenerSesionTx();
		} else {
			sessionTx = session;
		}
		
		 for(int k = 0; k < empleadoDocumentos.size(); k++) {
			 empleadoDocumentos.get(k).setId_empleado(objDocumentos.getId_empleado());
			
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
		return empleadoDocumentos;
}
   /**
    * Metodo para dar de baja un Empleado
    * @param uid unico de registro
    * @param empleado recibe los valores de empleado
    * @return regresa respuesta
    */
   public EncabezadoRespuesta bajaEmpleado(String uid,Empleado empleado) {
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
			
			objDocumentos = empleado;	
			registraDocumentos(uid,empleado.getObjDocumentos(), sessionTx);
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
public List<Empleado> consultaEmpleado(String uid, Empleado empleado) {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Empleado> listaEmpleado = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			listaEmpleado = sessionNTx.selectList("EmpleadoDAO.consultaEmpleado", empleado);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
           respuesta.setEstatus(false);
   		respuesta.setMensajeFuncional(ex.getMessage());
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
   public EncabezadoRespuesta modificaEmpleado(String uid,Empleado empleado) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("modificacion correcta.");
		try {
			//Abrimos conexion Transaccional
			documento = new EmpleadoDocumentos();
			documento.setId_empleado(empleado.getId_empleado());
			//envia el id al metodo que elimina el documentos
			eliminaDocumentos(uid,documento);
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("EmpleadoDAO.modificaEmpleado", empleado);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar al empleado.");
			}
			//Realizamos commit
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
			sessionTx.commit();
			
			//se envia los nuevos datos para registrar
			objDocumentos = empleado;
			registraDocumentos(uid,empleado.getObjDocumentos(), sessionTx);
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
   public EncabezadoRespuesta eliminaDocumentos(String uid,EmpleadoDocumentos empleadoDocumentos) {
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

