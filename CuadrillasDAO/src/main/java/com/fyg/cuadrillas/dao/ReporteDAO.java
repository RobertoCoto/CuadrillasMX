package com.fyg.cuadrillas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.ExcepcionesCuadrillas;
import com.fyg.cuadrillas.comun.Funciones;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.reporte.PeticionReporteDTO;
import com.fyg.cuadrillas.dto.reporte.ReporteDTO;

public class ReporteDAO {

	/**
	 * Metodo para reporteAsistencia
	 * @param uid unico de registro
	 * @param peticion recibe parametros consulta
	 * @return regresa lista de rows
	 */
	@SuppressWarnings("unchecked")
	public List<ReporteDTO> reporteAsistencia(String uid, PeticionReporteDTO peticion) throws Exception {
		SqlSession sessionNTx = null;
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<ReporteDTO> rows = null;
		try {
			//Abrimos conexion Transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			//Se hace una consulta a la tabla contacto
			rows = sessionNTx.selectList("ReporteDAO.reporteAsistencia", peticion);
			if ( rows.size() == 0) {
				throw new ExcepcionesCuadrillas("No existen registros para el reporte.");
			}
			for (ReporteDTO row : rows) {
				row = (ReporteDTO) Funciones.limpiaObjeto(row);
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
		return rows;
	}
}
