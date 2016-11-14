package com.fyg.cuadrillas.web;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.dto.Usuario;
import com.fyg.cuadrillas.web.JSONServiceUsuario;
public class MenuTest {
	private JSONServiceUsuario datos;
	private Usuario user;
	
	@Before
	public void setUp() throws Exception {
		datos = new JSONServiceUsuario();
		user = new Usuario();
		
		
	}
	@Test
	public void testJsonUsuario() throws Exception {
		try {
			String Usuarios = "jo.marquez";
			String Contrasena = "12345678";
			datos.jsonUsuario(Usuarios, Contrasena);
		}
		catch (Exception ex) {
			
		}
	}

}
