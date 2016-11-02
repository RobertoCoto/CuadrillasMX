package com.fyg.cuadrillas.negocio;

import java.util.List;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.EncabezadoRespuesta;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Parametros;
import com.fyg.cuadrillas.dao.ConsultaParametro;
public class ParametrosNegocio {

	public List<Parametros> consultaParametro(Parametros parametro) {
		//Primero generamos el identificador unico de la transaccion
		String uid = GUIDGenerator.generateGUID(parametro);
		//Mandamos a log el objeto de entrada
		LogHandler.debug(uid, this.getClass(), "registraNegocio - Daton Entrada: " + parametro);
		//Variable de resultado
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setUid(uid);
		respuesta.setEstatus(true);
		respuesta.setMensajeFuncional("Consulta correcta.");
		List<Parametros> listaParametro = null;
	    try {
	    	listaParametro = new ConsultaParametro().consultaParametro(uid, parametro);
            System.out.println(listaParametro);
	    } catch (Exception ex) {
	    	LogHandler.error(uid, this.getClass(), "ConsultaMultiSitio - ErrorMultisitio: " + ex.getMessage(), ex);
			respuesta.setUid(uid);
			respuesta.setEstatus(false);
			respuesta.setMensajeFuncional(ex.getMessage());
			respuesta.setMensajeTecnico(ex.getMessage());
	    }
	    LogHandler.debug(uid, this.getClass(), "consultaNegocio - Datos Salida: " + respuesta);
		return listaParametro;
	}

}
