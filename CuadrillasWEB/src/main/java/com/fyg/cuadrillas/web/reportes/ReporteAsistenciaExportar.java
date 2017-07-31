package com.fyg.cuadrillas.web.reportes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.reporte.PeticionReporteDTO;
import com.fyg.cuadrillas.dto.reporte.ReporteDTO;
import com.fyg.cuadrillas.dto.reporte.RespuestaReporteDTO;
import com.fyg.cuadrillas.negocio.ReporteNegocio;
import com.google.gson.Gson;

/**
 * Servlet implementation class ReporteAsistenciaExportar
 */
public class ReporteAsistenciaExportar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/** ARCHIVOCSV. */
	private static final String ARCHIVOCSV = "text/csv";
	/** peticionSb. */
	StringBuilder peticionSb = null;
	/** responseXml */
	String responseXml = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteAsistenciaExportar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RespuestaReporteDTO respuesta = new RespuestaReporteDTO();
		Gson sg = new Gson();		
		final String delimitador = ",";
		byte[] registrosByteArray = null;
		try {

			String fechaInicio = request.getParameter("fechaInicio");
			String fechaFin = request.getParameter("fechaFin");

			//crea objeto de negocio
			final ReporteNegocio negocio = new ReporteNegocio();

			//Lista de direcciones
			PeticionReporteDTO peticion = new PeticionReporteDTO();
			peticion.setFechaInicio(fechaInicio);
			peticion.setFechaFin(fechaFin);
			respuesta = negocio.reporteAsistencia(peticion);
			if (respuesta.getHeader().isEstatus()) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
			StringBuilder sbRegistros = new StringBuilder();
			//Encabezado
			boolean primer = true;
			for ( String nombreColumna : respuesta.getEncabezado()) {
				if (primer) {
					sbRegistros.append(nombreColumna);
					primer = false;
				} else {
					sbRegistros.append(delimitador).append(nombreColumna);
				}				
			}
			sbRegistros.append("\n");
			//Registros
			for (ReporteDTO registro : respuesta.getReporte()) {
				sbRegistros.append(registro.getIdEmpleado()).append(delimitador)
				.append(registro.getNoEmpleado()).append(delimitador)
				.append(registro.getNombreEmpleado()).append(delimitador)
				.append(registro.getFechaIngreso()).append(delimitador)
				.append(registro.getFechaBaja()).append(delimitador)
				.append(registro.getNombreCuadrilla()).append(delimitador)
				.append(registro.getDescPuesto()).append(delimitador)
				.append(registro.getFechaAsistencia()).append(delimitador)
				.append(registro.getComentariosAsistencia()).append(delimitador)				
				.append(registro.getHoraEntradaAsistencia()).append(delimitador)
				.append(registro.getHoraSalidaAsistencia()).append("\n");				
			}
			
			response.setContentType(ARCHIVOCSV);
			response.setHeader("Content-Disposition",
					"Attachment;Filename=\"ReporteAsistencia.csv\"");

			registrosByteArray = sbRegistros.toString().getBytes();
			response.getOutputStream().write(registrosByteArray);
		
		}  catch (Exception e) {
			LogHandler.error("", this.getClass(), "Error servlet", e);
			respuesta.getHeader().setMensajeFuncional("Error: " + e.getMessage());
			respuesta.getHeader().setEstatus(false);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
		}
	}

}
