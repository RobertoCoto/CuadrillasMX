package com.fyg.cuadrillas.comun;

public class Funciones {

	public static boolean checkAlpha(String str) { 
		boolean respuesta = false; 
		if ((str).matches("([a-z]|[A-Z]|\\s)+")) { 
		respuesta = true; 
		} 
		return respuesta; 
	} 

	public static boolean checkNonAlpha(String str){ 
		boolean respuesta = false; 
		if ((str).matches("([0-9]|\\-)+")) { 
		respuesta = true; 
		} 
		return respuesta; 
	} 
}
