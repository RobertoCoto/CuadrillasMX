package com.fyg.cuadrillas.comun;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Clase para calcular el RFC incluyendo la homoclave de una persona en base a
 * su nombre completo y fecha de nacimiento. La generaci&oacute;n del RFC se
 * basa en el documento "IFAI 0610100135506 065 Algoritmo". Se anexan pruebas
 * unitarias en la clase dentro del source folder src/test/java.
 *
 * @author Javier Islas García
 * @version 1.0.0 26/02/2014
 */
public final class RFCUtil {

	/**
	 * Lista de vocales.
	 */
	private final static String[] ARRAY_VOCALES = { "A", "E", "I", "O", "U" };

	/**
	 * Lista de palabras obscenas.
	 */
	private final static String[] ARRAY_PALABRAS_OBSCENAS = { "BUEI", "BATO", "BOFE", "BUEY", "CACA", "CACO", "CAGO",
			"CAKO", "CAGA", "CAKA", "COGI", "COJA", "COJI", "COJO", "COLA", "CULO", "COGE", "COJE", "COJO", "FALO",
			"FOCA", "FETO", "GATA", "GETA", "GUEI", "GUEY", "JETA", "JOTO", "KAKA", "KAGA", "KACA", "KOGE", "KOGI",
			"KOJA", "KOJE", "KOJI", "KACO", "KOLA", "KAGO", "KOJO", "KULO", "LILO", "LOBA", "LOCA", "LOKA", "LOKO",
			"LORA", "LORO", "LOCO", "LOKO", "MALA", "MAMA", "MEAR", "MEON", "MIAR", "MOCO", "MOKO", "MULA", "MULO",
			"MAMO", "MAME", "MEAS", "MION", "MULA", "BUEY", "CACO", "CAGO", "CAKO", "COJA", "COJI", "CULO", "GUEY",
			"KACA", "KAGA", "KOGE", "KAKA", "LOCA", "LOKA", "MAME", "MEAR", "MEON", "MOCO", "NACA", "NACO", "PEDA",
			"PIPI", "PITO", "POPO", "PEDO", "PUTA", "QULO", "RUIN", "PENE", "PUTO", "RATA", "R" + "OBA", "ROBE",
			"ROBO", "SAPO", "SENO", "SOPE", "TETA", "VACA", "VAGA", "VAGO", "VUEI", "VUEY", "WUEI", "WUEY" };

	/**
	 * Lista de sufijos para no ser considerados como nombre en el
	 * c&aacute;lculo en el RFC.
	 */
	private final static String[] ARRAY_SUFIJOS_NOMBRES = { "MARIA", "JOSE", "DE", "DEL", "LOS", "LAS", "LA", "MA",
			"MA.", "J.", "J" };

	/**
	 * Lista de sufijos para no ser considerados como apellidos en el
	 * c&aacute;lculo en el RFC.
	 */
	private final static String[] ARRAY_SUFIJOS_APELLIDOS = { "DE", "LA", "LAS", "MC", "VON", "DEL", "LOS", "Y", "MAC",
			"VAN" };

	/**
	 * Set con la lista de vocales, este Set es para acceder de forma m&aacute;s
	 * r&aacute;pida a la lista de vocales.
	 */
	private final static Set<String> VOCALES = new HashSet<String>(Arrays.asList(ARRAY_VOCALES));

	/**
	 * Set con la lista de sufijos, este Set es para acceder de forma m&aacute;s
	 * r&aacute;pida a la lista de sufijos.
	 */
	private final static Set<String> SUFIJOS_NOMBRES = new HashSet<String>(Arrays.asList(ARRAY_SUFIJOS_NOMBRES));

	/**
	 * Set con la lista de sufijos, este Set es para acceder de forma m&aacute;s
	 * r&aacute;pida a la lista de sufijos.
	 */
	private final static Set<String> SUFIJOS_APELLIDOS = new HashSet<String>(Arrays.asList(ARRAY_SUFIJOS_APELLIDOS));

	/**
	 * Set con la lista de palabras obscenas, este Set es para acceder de forma
	 * m&aacute;s r&aacute;pida a la lista de palabras obscenas.
	 */
	private final static Set<String> PALABRAS_OBSCENAS = new HashSet<String>(Arrays.asList(ARRAY_PALABRAS_OBSCENAS));

	/**
	 * Mapa de equivalencias para obtener el nombre num&eacute;rico.
	 */
	private final static Map<Character, String> EQUIVALENCIAS_NOMBRE_NUMERICO = new HashMap<Character, String>();

	/**
	 * Inicializa los mapas de equivalencias.
	 */

	static {
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('A', "11");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('B', "12");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('C', "13");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('D', "14");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('E', "15");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('F', "16");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('G', "17");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('H', "18");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('I', "19");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('J', "21");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('K', "22");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('L', "23");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('M', "24");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('N', "25");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('O', "26");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('P', "27");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('Q', "28");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('R', "29");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('S', "32");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('T', "33");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('U', "34");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('V', "35");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('W', "36");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('X', "37");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('Y', "38");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('Z', "39");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('&', "10");
		EQUIVALENCIAS_NOMBRE_NUMERICO.put('%', "10");
	}

	/**
	 * Constructor privado, nunca se instanciará la clase, se usará sólo método
	 * estático
	 */
	private RFCUtil() {
	}

	/**
	 * Regresa el RFC calculado de una persona inluyendo la homoclave.
	 *
	 * @param nombres_
	 *            String .- Nombre completo de la persona.
	 * @param apellidoPaterno_
	 *            String .- Nombre completo de la persona.
	 * @param apellidoMaterno_
	 *            String .- Nombre completo de la persona.
	 * @param fechaNacimiento_
	 *            .- Fecha de nacimiento de la persona
	 * @return String El RFC.
	 * @throws Exception
	 *             Cuando falta algún parámetro de entrada.
	 */
	public static String calcularRFCPersonaFisica(final String nombres_, final String apellidoPaterno_,
			final String apellidoMaterno_, final Date fechaNacimiento_) throws Exception {
		StringBuilder rfc = null;
		String nombre;
		String apellidoPaterno;
		String apellidoMaterno = null;
		String apellidoPaternoSinSufijos;
		String apellidoMaternoSinSufijos;
		String apellidoPaternoNotNull;
		String apellidoMaternoNotNull;
		String nombreRFC;
		String homoclaveRFC;
		String fechaNacimientoRFC;
		String digitoVerificadorRFC;
		try {
			validaParametrosEntrada(nombres_, apellidoPaterno_, apellidoMaterno_, fechaNacimiento_);

			// LOGGER.debug("Asignando el apallido materno.");
			apellidoMaternoNotNull = apellidoMaterno_;
			if (apellidoMaternoNotNull == null) {
				apellidoMaternoNotNull = "";
			}

			// LOGGER.debug("Asignando el apallido paterno.");
			apellidoPaternoNotNull = apellidoPaterno_;
			if (apellidoPaternoNotNull == null) {
				apellidoPaternoNotNull = "";
			}

			// LOGGER.debug("Preparando los nombres y apellidos para ser procesados...");
			nombre = rtrimToUpperCase(nombres_);
			apellidoPaterno = replaceSpecialCharacters(rtrimToUpperCase(apellidoPaternoNotNull));
			apellidoMaterno = rtrimToUpperCase(apellidoMaternoNotNull);

			// LOGGER.debug("Parametros preparados.");
			// LOGGER.debug("nombresRFC:           " + nombre);
			// LOGGER.debug("apellidoPaternoRFC:   ++" + apellidoPaterno +
			// "++");
			// LOGGER.debug("apellidoMaternoRFC:   " + apellidoMaterno);

			// LOGGER.debug("Obteniendo nombres y apellidos sin sufijos...");
			nombre = getNombreSinSufijos(nombre);
			apellidoPaternoSinSufijos = getApellidoSinSufijos(apellidoPaterno);
			apellidoMaternoSinSufijos = getApellidoSinSufijos(apellidoMaterno);

			// LOGGER.debug("nombresRFC:           " + nombre);
			// LOGGER.debug("apellidoPaternoSinSufijosRFC:   " +
			// apellidoPaternoSinSufijos);
			// LOGGER.debug("apellidoMaternoSinSufijosRFC:   " +
			// apellidoMaternoSinSufijos);
			// LOGGER.debug("apellidoPaterno:   " + apellidoPaterno);

			// LOGGER.debug("Calculando la parte del RFC en base al nombre...");
			nombreRFC = getNombreRFC(nombre, apellidoPaternoSinSufijos, apellidoMaternoSinSufijos);
			// LOGGER.info("Nombre RFC:           " + nombreRFC);

			// LOGGER.debug("Calculando la parte del RFC en base a la fecha de nacimiento...");
			fechaNacimientoRFC = getFechaNacimientoRFC(fechaNacimiento_);
			// LOGGER.info("Fecha Nacimiento RFC: " + fechaNacimientoRFC);

			// LOGGER.debug("Calculando la homoclave del RFC...");

			homoclaveRFC = getHomoClaveRFC(nombres_, apellidoPaternoNotNull, apellidoMaternoNotNull);
			// LOGGER.info("Homoclave RFC: " + homoclaveRFC);

			rfc = new StringBuilder();
			rfc.append(nombreRFC);
			rfc.append(fechaNacimientoRFC);
			rfc.append(homoclaveRFC);

			// LOGGER.debug("Calculando el digito verificador del RFC...");
			digitoVerificadorRFC = getDigitoVerificador(rfc.toString());
			// LOGGER.debug("Digito Verificador RFC: " + digitoVerificadorRFC);

			rfc.append(digitoVerificadorRFC);
			// LOGGER.info("RFC Calculado:         " + rfc.toString());

			return rfc.toString();
		} catch (Exception exc) {

			throw exc;
		}
	}

	/**
	 * Valida los par&aacute;metros de entrada para calular el RFC.
	 *
	 * @param nombres
	 *            String
	 * @param apellidoPaterno
	 *            String
	 * @param apellidoMaterno
	 *            String
	 * @param fechaNacimiento
	 *            Date
	 * @throws Exception
	 */
	private static void validaParametrosEntrada(String nombres, String apellidoPaterno, String apellidoMaterno,
			Date fechaNacimiento) throws Exception {
		if (nombres == null) {
			throw new Exception("El parametro [nombres] no puede ser nulo.");
		}
		if (nombres.trim().isEmpty()) {
			throw new Exception("El parametro [nombres] no puede ser vacio.");
		}
		if (apellidoPaterno == null) {
			throw new Exception("El parametro [apellidoPaterno] no puede ser nulo.");
		}
		if (apellidoPaterno.trim().isEmpty() && apellidoMaterno.trim().isEmpty()) {
			throw new Exception("Los parametros [apellidoPaterno] y [apellidoMaterno] no pueden ser vacios ambos.");
		}
		if (fechaNacimiento == null) {
			throw new Exception("El parametro [fechaNacimiento] no puede ser nulo.");
		}
	}

	/**
	 * Elimina los espacios en blanco antes y despu&eacute;s del valor enviado
	 * como par&aacute;metero, convierte a may&uacute;sculas todos caracters.
	 *
	 * @param value
	 *            String
	 * @return String
	 */
	private static String rtrimToUpperCase(String value) {
		return value.replaceAll("\\s+$", "").toUpperCase();
	}

	/**
	 * Reemplaza los caracteres '/', '-', 'Ü' por el caracter ' ', solo la
	 * primer ocurrencia de cada uno de ellos.
	 *
	 * @param value
	 *            String
	 * @return String
	 */
	private static String replaceSpecialCharacters(String value) {
		return value.replaceFirst("/", " ").replaceFirst("-", " ").replaceFirst("Ü", " ");
	}

	/**
	 * Regresa el primer nombre significativo, es decir, que no sea un sufijo,
	 * en caso de que solo tenga un nombre aunque sea sufijo, regresa ese
	 * nombre.
	 *
	 * @param nombres
	 *            String
	 * @return String
	 */
	private static String getNombreSinSufijos(String nombres) {
		// Se cambia el algoritmo para pertimir generar RFC como: HEA 800501HC6
		// debido al
		// doble espacio en el nombre como: 'MARIA GABRIELA'.
		String nombre = null;
		String palabra;
		int posicion = 0;
		nombre = nombres;
		while (nombre.indexOf(' ') >= 0) {
			posicion = nombre.indexOf(' ');
			palabra = nombre.substring(0, posicion);
			if (!SUFIJOS_NOMBRES.contains(palabra)) {
				break;
			} else {
				nombre = nombre.substring(posicion + 1, nombre.length());
			}
		}
		return nombre;
	}

	/**
	 * Regresa el primer nombre significativo, es decir, que no sea un sufijo,
	 * en caso de que solo tenga un nombre aunque sea sufijo, regresa ese
	 * nombre.
	 *
	 * @param nombres
	 *            String
	 * @return String
	 */
	private static String getApellidoSinSufijos(String apellidos) {
		// Se cambia el algoritmo al del SP calc_rfc del SEO.
		String apellido = null;
		String palabra;
		int posicion = 0;
		apellido = apellidos;
		while (apellido.indexOf(' ') >= 0) {
			posicion = apellido.indexOf(' ');
			palabra = apellido.substring(0, posicion);
			if (!SUFIJOS_APELLIDOS.contains(palabra)) {
				break;
			} else {
				apellido = apellido.substring(posicion + 1, apellido.length());
			}
		}
		return apellido;
	}

	/**
	 * Regresa el calculo de la primera parte del RFC, esta se calcula en base
	 * al nombre y los apellidos. <br>
	 * <br>
	 * <i><b>Regla 1</b></i>.- Se integra la clave con lo siguientes datos: <br>
	 * &nbsp;&nbsp; 1. La primera letra del apellido paterno y la siguiente
	 * primer vocal del mismo. <br>
	 * &nbsp;&nbsp; 2. La primera letra del apellido materno. <br>
	 * &nbsp;&nbsp; 3. La primera letra de nombre. <br>
	 * <br>
	 * <i><b>Regla 4</b></i>.- En los casos en que el apellido paterno de la
	 * persona f&iacute;sica se componga de una o dos letras, la clave se
	 * formar&aacute; de la siguiente manera: <br>
	 * &nbsp;&nbsp; 1. La primera letra del apellido paterno. <br>
	 * &nbsp;&nbsp; 2. La primera letra del apellido materno. <br>
	 * &nbsp;&nbsp; 3. La primera y segunda letra de nombre. <br>
	 * &nbsp;&nbsp; Ejemplo: <br>
	 * &nbsp;&nbsp;&nbsp; Alvaro de la O Lozano &nbsp;&nbsp;&nbsp;&nbsp; OLAL
	 *
	 * @param nombre
	 *            String
	 * @param apellidoPaternoSinSufijos
	 *            String
	 * @param apellidoMaternoSinSufijos
	 *            String
	 * @return String
	 */
	private static String getNombreRFC(String nombre, String apellidoPaternoSinSufijos, String apellidoMaternoSinSufijos) {
		StringBuilder nombreRFC = new StringBuilder();

		// LOGGER.debug("nombre:" + nombre + ", paterno:" +
		// apellidoPaternoSinSufijos + ", materno:" +
		// apellidoMaternoSinSufijos);

		if (apellidoMaternoSinSufijos.isEmpty()) {

			String primerApellidoPaterno = apellidoPaternoSinSufijos;

			nombreRFC.append(getPrimerLetra(primerApellidoPaterno));
			String segundaLetra = getSegundaLetra(apellidoPaternoSinSufijos);
			if (segundaLetra == null || segundaLetra.isEmpty()) {
				nombreRFC.append("X");
			} else {
				nombreRFC.append(segundaLetra);
			}

			nombreRFC.append(getPrimerLetra(nombre));
			if (nombre.length() > 1) {
				nombreRFC.append(getSegundaLetra(nombre));
			}
		}

		else if (apellidoPaternoSinSufijos.isEmpty()) {

			nombreRFC.append(getPrimerLetra(apellidoMaternoSinSufijos));
			nombreRFC.append(getSegundaLetra(apellidoMaternoSinSufijos));
			nombreRFC.append(getPrimerLetra(nombre));
			nombreRFC.append(getSegundaLetra(nombre));
		}

		else {
			String primerApellidoPaterno = apellidoPaternoSinSufijos;
			nombreRFC.append(getPrimerLetra(primerApellidoPaterno));
			if (primerApellidoPaterno.length() == 1 || primerApellidoPaterno.length() == 2) {
				nombreRFC.append(getPrimerLetra(apellidoMaternoSinSufijos));
				nombreRFC.append(getPrimerLetra(nombre));
				nombreRFC.append(getSegundaLetra(nombre));
			} else {
				nombreRFC.append(getPrimerVocalInternaOrX(primerApellidoPaterno));

				nombreRFC.append(getPrimerLetra(apellidoMaternoSinSufijos));
				nombreRFC.append(getPrimerLetra(nombre));
			}

		}

		if ((nombreRFC.charAt(3) == ' ')
				&& (apellidoPaternoSinSufijos.isEmpty() || apellidoMaternoSinSufijos.isEmpty())
				&& (nombre.charAt(1) == ' ')) {

			nombreRFC = new StringBuilder(nombreRFC.substring(0, 2));
			nombreRFC.append("X");
			nombreRFC.append(getTerceraLetra(nombre));
		}

		if (esPalabraObsena(nombreRFC.toString())) {
			replaceUltimaLetraConX(nombreRFC);// Cambios
		}
		return nombreRFC.toString();
	}

	/**
	 * Regresa verdadero si el par&aacute;metro es una palabra que est&eeacute;
	 * en la lista de palabras obsenas, falso en caso contrario.
	 *
	 * @param palabra
	 *            String
	 * @return boolean
	 */
	private static boolean esPalabraObsena(String palabra) {
		return PALABRAS_OBSCENAS.contains(palabra);
	}

	// /**
	// * Reemplaza la segunda letra de la cadena con el caracter 'X'. <br>
	// * <br>
	// * <i><b>Regla 9</b></i>.- Cuando de las cuatro letras que formen la
	// * expresi&oacute;n alfab&eacute;tica resulte una palabra inconveniente,
	// la
	// * &uacute;ltima letra ser&aacute; sustituida por una "X". <br>
	// *
	// * @param string
	// * StringBuilder
	// */
	// private static void replaceSegundaLetraConX(StringBuilder string) {
	// // En el SP es la segunda letra la que cambia con X.
	// string.replace(1, 2, "X");
	// // Regla 9.
	// // string.replace(3, 4, "X");
	// }

	private static void replaceUltimaLetraConX(StringBuilder string) {
		// En el SP es la segunda letra la que cambia con X.
		string.replace(3, 4, "X");
	}

	/**
	 * Regresa la primer letra de una cadena.
	 *
	 * @param value
	 *            String
	 * @return String
	 */
	private static String getPrimerLetra(String value) {
		return Character.toString(value.charAt(0));
	}

	/**
	 * Regresa la segunda letra de una cadena.
	 *
	 * @param value
	 *            String
	 * @return String
	 */
	private static String getSegundaLetra(String value) {
		if (value.length() <= 1) {
			return null;
		}
		return Character.toString(value.charAt(1));
	}

	/**
	 * Regresa la tercera letra de una cadena.
	 *
	 * @param value
	 *            String
	 * @return String
	 */
	private static String getTerceraLetra(String value) {
		if (value.length() <= 2) {
			return null;
		}
		return Character.toString(value.charAt(2));
	}

	/**
	 * Regresa la primer letra de una cadena.
	 *
	 * @param value
	 *            String
	 * @return String
	 */
	private static String getPrimerVocalInternaOrX(String value) {
		String primerVocal = null;
		// El primer caracter no lo debe tomar en cuenta idx = 1.
		for (int idx = 1; idx < value.length(); idx++) {
			if (VOCALES.contains(value.subSequence(idx, idx + 1))) {
				primerVocal = Character.toString(value.charAt(idx));
				break;
			}
		}
		if (primerVocal == null) {
			primerVocal = "X";
		}
		return primerVocal;
	}

	/**
	 * Regrea la fecha de nacimiento en formato YYMMDD.
	 *
	 * @param fechaNacimiento
	 *            Date
	 * @return String
	 */
	private static String getFechaNacimientoRFC(Date fechaNacimiento) {
		DateFormat formatter = new SimpleDateFormat("yyMMdd");
		return formatter.format(fechaNacimiento);
	}

	/**
	 * Regresa el c&aacute;lculo de la homoclave del RFC.
	 *
	 * @param nombre
	 *            String
	 * @param apellidoPaterno
	 *            String
	 * @param apellidoMaterno
	 *            String
	 * @return String
	 */
	private static String getHomoClaveRFC(String nombre_, String apellidoPaterno_, String apellidoMaterno_) {
		String nombre = RFCUtil.rtrimToUpperCase(nombre_);
		String apellidoPaterno = RFCUtil.rtrimToUpperCase(apellidoPaterno_);
		String apellidoMaterno = RFCUtil.rtrimToUpperCase(apellidoMaterno_);
		String nombreCompleto = apellidoPaterno + " " + apellidoMaterno + " " + nombre;

		// LOGGER.debug("nombreCompleto: " + nombreCompleto);

		// Se obtiene el nombre numerico a 52 posiciones.
		StringBuilder nombreNumerico = new StringBuilder("0");
		String equivalenciaNombreNumerico = "";
		int nombreCompletoLength = nombreCompleto.length();
		for (int idx = 0; idx < nombreCompletoLength; idx++) {
			if (idx < nombreCompletoLength) {

				/*
				 * SI el caracter es 'Ñ', 'Ó' o cualquier caracter que no se
				 * encuentre en la tabla de equivalencias, la equivalencia es la
				 * equivalencia anterior, por eso no se obtiene la equivalencia
				 * para estos caracteres.
				 */
				if (getEquivalenciaNombreNumerico(nombreCompleto.charAt(idx)) != null) {
					equivalenciaNombreNumerico = getEquivalenciaNombreNumerico(nombreCompleto.charAt(idx));
				}

				// LOGGER.debug("CARACTER:" + nombreCompleto.charAt(idx) +
				// ", valor:" + equivalenciaNombreNumerico);

				nombreNumerico.append(equivalenciaNombreNumerico);
			} else {
				nombreNumerico.append("00");
			}
		}

		// Se calcula la suma total el nombre numerico.
		int sumaTotal = 0;
		int homoClaveIdx = 0;
		int homoClaveIdxMas1 = 0;
		for (int idx = 0; nombreNumerico.length() > idx + 1; idx++) {

			// LOGGER.debug("charAt: " + nombreNumerico.charAt(idx));

			homoClaveIdx = Character.getNumericValue(nombreNumerico.charAt(idx));
			homoClaveIdxMas1 = Character.getNumericValue(nombreNumerico.charAt(idx + 1));
			sumaTotal += ((homoClaveIdx * 10) + (homoClaveIdxMas1)) * homoClaveIdxMas1;

			// LOGGER.debug("sumaParcial: " + sumaTotal);
		}

		// LOGGER.debug("sumaTotal: " + sumaTotal);

		// Se obtiene el residuo de los ultimos 3 digitos.
		int cociente = sumaTotal % 1000;

		// Se obtiene el residuo de los ultimos 3 digitos entre 34.
		int modulo = cociente % 34;

		// Se obtiene el cociente entero.
		cociente = (cociente - modulo) / 34;

		// LOGGER.debug("cociente: " + cociente);
		// LOGGER.debug("modulo: " + modulo);

		StringBuilder homoClave = new StringBuilder();
		homoClave.append(getEquivalenciaCocienteResiduo(cociente));
		homoClave.append(getEquivalenciaCocienteResiduo(modulo));

		return homoClave.toString();
	}

	/**
	 * Regresa el c&aacute;lculo del d&iacute;gito verificador.
	 * 
	 * @param rfc
	 *            String
	 * @return String
	 */
	private static String getDigitoVerificador(String rfc) {
		String digitoVerificador = "";
		int numero = 0;
		int parcial = 0;
		char character;

		// LOGGER.debug("rfc.length: " + rfc.length());

		for (int idx = 0; idx < 12; idx++) {
			if (idx >= rfc.length()) {
				numero = 24;
			} else {
				character = rfc.charAt(idx);

				// LOGGER.debug("character: " + character);

				if (character >= '0' && character <= '9') {
					numero = Character.getNumericValue(character);
				} else {
					switch (character) {
					case 'A':
						numero = 10;
						break;
					case 'B':
						numero = 11;
						break;
					case 'C':
						numero = 12;
						break;
					case 'D':
						numero = 13;
						break;
					case 'E':
						numero = 14;
						break;
					case 'F':
						numero = 15;
						break;
					case 'G':
						numero = 16;
						break;
					case 'H':
						numero = 17;
						break;
					case 'I':
						numero = 18;
						break;
					case 'J':
						numero = 19;
						break;
					case 'K':
						numero = 20;
						break;
					case 'L':
						numero = 21;
						break;
					case 'M':
						numero = 22;
						break;
					case 'N':
						numero = 23;
						break;
					case 'O':
						numero = 25;
						break;
					case 'P':
						numero = 26;
						break;
					case 'Q':
						numero = 27;
						break;
					case 'R':
						numero = 28;
						break;
					case 'S':
						numero = 29;
						break;
					case 'T':
						numero = 30;
						break;
					case 'U':
						numero = 31;
						break;
					case 'V':
						numero = 32;
						break;
					case 'W':
						numero = 33;
						break;
					case 'X':
						numero = 34;
						break;
					case 'Y':
						numero = 35;
						break;
					case 'Z':
						numero = 36;
						break;
					case ' ':
						numero = 37;
						break;
					default:
						numero = 0;
					}
				}
			}

			// Se contabiliza el nuevo digito.
			// LOGGER.debug("parcial: " + numero * (14 - (idx+1)));
			parcial += numero * (14 - (idx + 1));
		}

		// LOGGER.debug("parcial Total: " + parcial);

		int parcialRedondeado = parcial % 11;

		// LOGGER.debug("parcialRedondeado: " + parcialRedondeado);

		if (parcialRedondeado == 0) {
			digitoVerificador = "0";
		} else {
			parcial = 11 - parcialRedondeado;
			if (parcial == 10) {
				digitoVerificador = "A";
			} else {
				digitoVerificador = Integer.toString(parcial);
			}
		}

		return digitoVerificador;
	}

	/**
	 * Regresa la equivalencia de caracteres para el cociente y residuo de la
	 * homoclave.
	 *
	 * @param number
	 *            int
	 * @return String
	 */
	private static String getEquivalenciaCocienteResiduo(int number) {
		switch (number) {
		case 0:
			return "1";
		case 1:
			return "2";
		case 2:
			return "3";
		case 3:
			return "4";
		case 4:
			return "5";
		case 5:
			return "6";
		case 6:
			return "7";
		case 7:
			return "8";
		case 8:
			return "9";
		case 9:
			return "A";
		case 10:
			return "B";
		case 11:
			return "C";
		case 12:
			return "D";
		case 13:
			return "E";
		case 14:
			return "F";
		case 15:
			return "G";
		case 16:
			return "H";
		case 17:
			return "I";
		case 18:
			return "J";
		case 19:
			return "K";
		case 20:
			return "L";
		case 21:
			return "M";
		case 22:
			return "N";
		case 23:
			return "P";
		case 24:
			return "Q";
		case 25:
			return "R";
		case 26:
			return "S";
		case 27:
			return "T";
		case 28:
			return "U";
		case 29:
			return "V";
		case 30:
			return "W";
		case 31:
			return "X";
		case 32:
			return "Y";
		default:
			return "Z";
		}
	}

	/**
	 * Regresa la equivalencia num&eacute;rica de un caracter para obtener el
	 * nombre num&eacute;rico.
	 *
	 * @param character
	 *            char
	 * @return String
	 */
	private static String getEquivalenciaNombreNumerico(char character) {
		String equivalencia = null;

		if (EQUIVALENCIAS_NOMBRE_NUMERICO.containsKey(character)) {
			equivalencia = EQUIVALENCIAS_NOMBRE_NUMERICO.get(character);
		} else if (character >= '0' && character <= '9') {
			equivalencia = new DecimalFormat("00").format(Character.getNumericValue(character));
		} else if (character == ' ') {
			equivalencia = "00";
		}

		return equivalencia;
	}

}
