package com.fyg.cuadrillas.negocio.test;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fyg.cuadrillas.comun.GUIDGenerator;
import com.fyg.cuadrillas.comun.LogHandler;
import com.fyg.cuadrillas.negocio.UsuariosNegocio;
import com.fyg.cuadrillas.dto.Usuario;

public class AltaUsuarioTest {
	/**
	 * objeto OperacionesCuadrillas
	 */
 private UsuariosNegocio altaUser;
 /**
  * Objeto datos usuario
  */
 private Usuario datosUsuario;
 /**
  * Guid unico generado
  */
	private GUIDGenerator uid;
	/**
	 * SetUp
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		altaUser = new UsuariosNegocio();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
		String strFecha = "1982-01-08";
		Date fechaNac = formato.parse(strFecha);
		Date fechaAlta = new Date();
		Date fechaMod = new Date();
		datosUsuario = new Usuario();
		datosUsuario.setUsuario("ma.gonzales");
		datosUsuario.setNombre("Marcos Alberto");
		datosUsuario.setApellido_pat("Gonzales");
		datosUsuario.setApellido_mat("Perez");
		datosUsuario.setSexo("M");
		datosUsuario.setRfc("GOPM020801HV7");
		datosUsuario.setCurp("GOPR020801HDFNRC04");
		datosUsuario.setFecha_nacimiento(fechaNac);
		datosUsuario.setId_perfil(1);
		datosUsuario.setContrasena("gonzales22gb");
		datosUsuario.setCambio_contrasena("N");
		datosUsuario.setFecha_alta(fechaAlta);
		datosUsuario.setFecha_ult_mod(fechaMod);
		datosUsuario.setEstatus("A");
	}

	/**
	 * Manda los valores al metodo de alta usuario
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testAltaUsuario() {
		String guid = uid.generateGUID(altaUser);
		try {
			altaUser.altaUsuario(datosUsuario);
		}
		catch (Exception ex) {
			LogHandler.debug(guid, this.getClass(), "Error");
		}
	}

}
