package com.fyg.cuadrillas.dao;

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
		 	SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("El empleado ha sido registrado exitosamente.");
			try {
				
				//Validamos si ya existe el noEmpleado 
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				int existeNoEmpleado= (Integer) sessionNTx.selectOne("EmpleadoDAO.existeNoEmpleado", empleado);
				if (existeNoEmpleado > 0) {
					throw new ExcepcionesCuadrillas("Error al registrar, ya existe el numero del empleado.");
				}
				
				int existeRFCCalculado= (Integer) sessionNTx.selectOne("EmpleadoDAO.existeRfcCalculado", empleado);
				if (existeRFCCalculado > 0) {
					throw new ExcepcionesCuadrillas("Error al registrar, ya existe el RFC calculado del empleado.");
				}
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
				
				if (empleado.getDocumentosNO().size() > 0) {
					for (EmpleadoDocumentoDTO documento : empleado.getDocumentosNO()) {
						documento.setIdEmpleado(empleado.getIdEmpleado());
					}
					registraDocumentos(uid, empleado.getDocumentosNO(), sessionTx);
				}
				
				if (empleado.getDocumentosNA().size() > 0) {
					for (EmpleadoDocumentoDTO documento : empleado.getDocumentosNA()) {
						documento.setIdEmpleado(empleado.getIdEmpleado());
					}
					registraDocumentos(uid, empleado.getDocumentosNA(), sessionTx);
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
				FabricaConexiones.close(sessionNTx);
			}
			return respuesta;
	}

   /**
    * Metodo para dar de baja un Empleado
    * @param uid unico de registro
    * @param empleado recibe los valores de empleado
    * @return regresa respuesta
    */
   public EncabezadoRespuesta bajaEmpleado(String uid, EmpleadoDTO empleado) {
	 	SqlSession sessionTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("El empleado ha sido dado de baja exitosamente.");
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
   public EmpleadoDTO consultaEmpleado(String uid, EmpleadoDTO empleado) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		EmpleadoDTO emp = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla
			LogHandler.debug(uid, this.getClass(), "consultando");
			emp = (EmpleadoDTO) sessionNTx.selectOne("EmpleadoDAO.consultaEmpleado", empleado);
			LogHandler.info(uid, this.getClass(), "consultaEmpleado: " + emp);
		}
		catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return emp;
	}
   /**
    * Metodo para consultar empleados para asistencia
    * @param uid unico de registro
    * @param empleado recibe valores de empleado
    * @return regresa una lista de empleado
    * @throws Exception se crea una excepcion
    */
   @SuppressWarnings("unchecked")
public List<EmpleadoDTO> consultaGeneral(String uid, EmpleadoDTO empleado)throws Exception{
	   SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<EmpleadoDTO> listaEmpleado = null;
		try { 
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla 
			LogHandler.debug(uid, this.getClass(), "Consultando");
			listaEmpleado = sessionNTx.selectList("EmpleadoDAO.consultaEmpleado", empleado);
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
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
   public EncabezadoRespuesta modificaEmpleado(String uid, EmpleadoDTO empleado) {
	 	SqlSession sessionTx = null;
	 	SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("El empleado se ha modificado exitosamente.");
		try {
			//validaciones conexion transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			int existeNoEmpleado= (Integer) sessionNTx.selectOne("EmpleadoDAO.existeNoEmpleadoDato", empleado);
			if (existeNoEmpleado > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe el numero del empleado.");
			}
			
			int existeRFCCalculado= (Integer) sessionNTx.selectOne("EmpleadoDAO.existeRfcCalculadoDato", empleado);
			if (existeRFCCalculado > 0) {
				throw new ExcepcionesCuadrillas("Error al registrar, ya existe el RFC calculado del empleado.");
			}
			//abrimos conexion transaccional
			sessionTx = FabricaConexiones.obtenerSesionTx();
	        int registros = sessionTx.update("EmpleadoDAO.modificaEmpleado", empleado);
			if ( registros == 0) {
				throw new ExcepcionesCuadrillas("Error al modificar al empleado.");
			}

			//se envia los nuevos datos para registrar
			eliminaDocumentos(uid, empleado, sessionTx);
			if (empleado.getDocumentos().size() > 0) {
				for (EmpleadoDocumentoDTO documento : empleado.getDocumentos()) {
					documento.setIdEmpleado(empleado.getIdEmpleado());
				}
				registraDocumentos(uid, empleado.getDocumentos(), sessionTx);
			}
			
			if (empleado.getDocumentosNO().size() > 0) {
				for (EmpleadoDocumentoDTO documento : empleado.getDocumentosNO()) {
					documento.setIdEmpleado(empleado.getIdEmpleado());
				}
				registraDocumentos(uid, empleado.getDocumentosNO(), sessionTx);
			}
			
			if (empleado.getDocumentosNA().size() > 0) {
				for (EmpleadoDocumentoDTO documento : empleado.getDocumentosNA()) {
					documento.setIdEmpleado(empleado.getIdEmpleado());
				}
				registraDocumentos(uid, empleado.getDocumentosNA(), sessionTx);
			}
			//Realizamos commit
			sessionTx.commit();
			LogHandler.debug(uid, this.getClass(), "Commit!!!");
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
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
   }
   /**
    * consulta todos los empleados existentes
    * @param uid recibe solo uid
    * @return regresa toda la lista de empleados
    * @throws Exception crea una excepcion
    */
   @SuppressWarnings("unchecked")
public List<EmpleadoDTO> consultaGeneralEmpleado(String uid)throws Exception{
	   SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<EmpleadoDTO> listaEmpleado = null;
		try {
			//Abrimos conexion Transaccional
			LogHandler.debug(uid, this.getClass(), "Abriendo");
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.debug(uid, this.getClass(), "Consultando");
			//Se hace una consulta a la tabla contacto
			listaEmpleado = sessionNTx.selectList("empleadoDAO.consultaEmpleado");
			if ( listaEmpleado.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen catalogos definidos.");
			}
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
			throw new Exception(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return listaEmpleado;
   }

   /**
	  * Metodo Para registrar los documentos del empleado
	  * @param uid uid unico
	  * @param empleadoDocumentos recibe los documentos del empleado
	  * @param session crea una session
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
	    * Metodo para consultar documentos
	    * @param uid unico de consulta
	    * @param empleadoDocumento recibe los valores del id Empleado para doc.
	    * @return retorna lista documento
	    */
	   @SuppressWarnings("unchecked")
	public List<EmpleadoDocumentoDTO> consultaDocumentos(String uid, EmpleadoDocumentoDTO empleadoDocumentos) throws Exception {
			SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Consulta correcta.");
			List<EmpleadoDocumentoDTO> listaDocumento = null;
			try {
				//Abrimos conexion Transaccional
				LogHandler.debug(uid, this.getClass(), "Abriendo");
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.debug(uid, this.getClass(), "Consultando");
				//Se hace una consulta a la tabla
			
				listaDocumento = sessionNTx.selectList("EmpleadoDAO.consultaDocumentos", empleadoDocumentos);
				LogHandler.info(uid, this.getClass(), "consultaDocumentos: " + listaDocumento);
			}
			catch (Exception ex) {
				LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
				throw new Exception(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sessionNTx);
			}
			return listaDocumento;
		}
	   /**
	    * Metodo para consultar los colaboradores 
	    * @param uid unico de empleado
	    * @param empleado recibe parametro de empleado
	    * @return regresa la lista de colaboradores
	    * @throws Exception si surge una excepcion
	    */
	   @SuppressWarnings("unchecked")
	public List<EmpleadoDTO> consultaColaborador(String uid, EmpleadoDTO empleado) throws Exception {
			SqlSession sessionNTx = null;
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUid(uid);
			respuesta.setEstatus(true);
			respuesta.setMensajeFuncional("Consulta correcta.");
			List<EmpleadoDTO> listaColaborador = null;
			try {
				//Abrimos conexion Transaccional
				LogHandler.debug(uid, this.getClass(), "Abriendo");
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.debug(uid, this.getClass(), "Consultando");
				//Se hace una consulta a la tabla
			
				listaColaborador = sessionNTx.selectList("EmpleadoDAO.consultaColaboradores", empleado);
				if ( listaColaborador.size() == 0) {
					throw new ExcepcionesCuadrillas("No existen colaboradores en esta cuadrilla.");
				}
			}
			catch (Exception ex) {
				LogHandler.error(uid, this.getClass(), "Error: " + ex.getMessage(), ex);
				throw new Exception(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sessionNTx);
			}
			return listaColaborador;
		}
}
