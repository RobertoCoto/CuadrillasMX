package com.fyg.cuadrillas.comun;

import java.util.Date;

public class Funciones {
	/**
	 * Method checkAlpha
	 * @param str receive value
	 * @return return respuesta
	 */
	public static boolean checkAlpha(String str) {
		boolean respuesta = false;
		if ((str).matches("([a-z]|[A-Z]|\\s)+")) {
		respuesta = true;
		}
		return respuesta;
	}
/**
 * Method checkNonAlpha
 * @param str receive value
 * @return respuesta
 */
	public static boolean checkNonAlpha(String str) {
		boolean respuesta = false;
		if ((str).matches("([0-9]|\\-)+")) {
		respuesta = true;
		}
		return respuesta;
	}
	/**
	 * Method diasEntreFechas
	 * @param fechaInicio receive value
	 * @param fechaFin receive value
	 * @return respuesta
	 */
	public static int diasEntreFechas(Date fechaInicio, Date fechaFin) {
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
		return  (int) (( fechaFin.getTime() - fechaInicio.getTime() ) / MILLSECS_PER_DAY);
	}
/**
 * Method distanciaCoord
 * @param lat1 value
 * @param lng1 value
 * @param lat2 value
 * @param lng2 value
 * @return distancia
 */
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
        //double radioTierra = 3958.75;//en millas
        double radioTierra = 6371; //en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;
        return distancia;
    }
}
