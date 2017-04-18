package com.fyg.cuadrillas.comun;

public class GeneradorUsuario {
/**
 * Metodo para generar usuario
 * @param nombre recibe el nombre
 * @param apellidoPaterno recibe un apellido
 * @return retorna usuario
 */
	public String generaUsuario(String nombre, String apellidoPaterno) {
		String usuario = "";
		char pr = nombre.charAt(0);
		usuario = pr + "" + apellidoPaterno;
		return usuario.toLowerCase();
	}
	
	public String generaUsuarioDobleCaracter(String nombre, String apellidoPaterno) {
		String usuario = "";
		char nombreP = nombre.charAt(0);
		char nombreS = nombre.charAt(1);
		usuario = nombreP + "" + nombreS + "" + apellidoPaterno;
		return usuario.toLowerCase();
	}
}
