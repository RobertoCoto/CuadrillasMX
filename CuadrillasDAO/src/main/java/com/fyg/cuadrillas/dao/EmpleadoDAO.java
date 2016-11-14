package com.fyg.cuadrillas.dao;

import java.util.ArrayList;

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
		        int registros = sessionTx.update("EmpleadoDAO.registraEmpleado", empleado);
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
   }

