package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dao.ReporteDAO;
import com.fyg.cuadrillas.dto.reporte.PeticionReporteDTO;
import com.fyg.cuadrillas.dto.reporte.ReporteDTO;
import com.fyg.cuadrillas.dto.reporte.RespuestaReporteDTO;

public class ReporteNegocio {

	/**
	 * Metodo para generar el reporte de Asistencia
	 * @param peticion fechas reporte
	 * @return regresa lista de asistencias
	 */
	public RespuestaReporteDTO reporteAsistencia(PeticionReporteDTO peticion) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(peticion);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "reporteAsistencia -  Entrada: " + peticion);
		//Variable de resultado
		RespuestaReporteDTO respuesta = new RespuestaReporteDTO();
		respuesta.setHeader( new EncabezadoRespuesta());
		respuesta.getHeader().setUid(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensajeFuncional("Consulta correcta.");

		List<ReporteDTO> reporte = null;
	    try {
	    	reporte = new ReporteDAO().reporteAsistencia(uid, peticion);
	    	respuesta.setReporte(reporte);

	    } catch  (ExcepcionesCuadrillas ex) {
			LogHandler.error(uid, this.getClass(), "reporteAsistencia - Error: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
		} catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "reporteAsistencia - Error: " + ex.getMessage(), ex);
	    	respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensajeFuncional(ex.getMessage());
			respuesta.getHeader().setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "reporteAsistencia - Datos Salida: " + respuesta);
		return respuesta;
	}
}
