package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.BuzonDAO;
import com.fyg.cuadrillas.dto.buzon.BuzonDTO;
import com.fyg.cuadrillas.dao.ParametroDAO;
import com.fyg.cuadrillas.dto.buzon.BuzonRespuesta;
public class BuzonNegocio {

	/**
	 * Metodo para consultar las tareas disponibles
	 * @return regresa lista de tareas
	 */
	public BuzonRespuesta consultaTarea() {
		//
		BuzonDTO buzon = new BuzonDTO();
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(new String(""));
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "consultaTarea - Datos Entrada: ");
		BuzonRespuesta respuesta = new BuzonRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");
		List<BuzonDTO> listaTarea = null;
		try {
			//hace consulta de nuetro parametro
			String parametroImss = "empleado.notifica.imss";
			String valor = new ParametroDAO().consultaParametro(uid, parametroImss);
			buzon.setNotificaImss(Integer.parseInt(valor));
			listaTarea = new BuzonDAO().consultaTareas(uid, buzon);
			respuesta.setBuzon(listaTarea);
		} catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "consultaTarea - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "consultaTarea - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaTarea - Datos Salida: " + respuesta);
		return respuesta;
	}
}
