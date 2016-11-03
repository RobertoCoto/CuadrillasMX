package com.fyg.cuadrillas.comun;

import java.util.regex.Pattern;

public class ValidaCurp {
		/**
		 * curp valido.
		 *
		 * @param curp the curp str
		 * @return true, if successful
		 */
	 	public static boolean validarCURP(String curp) {
	 		String regex =
	 	    "[A-Z]{1}[A-Z]{1}[A-Z]{2}[0-9]{2}"
	 	    + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
	 	    + "[HM]{1}"
	 		+ "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
	 	    + "[B-DF-HJ-NP-TV-Z]{3}"
	 		+ "[0-9A-Z]{1}[0-9]{1}$";

	 	    Pattern patron = Pattern.compile(regex);
	 	    if (!patron.matcher(curp).matches()) {
	 	    	return false;
	 	    }
	 	    	return true;
	 	  }

		 /**
		 * sexo valido.
		 *
		 * @param sexo the sexo str
		 * @return true, if successful
		 */
		public static boolean validarSexo(String sexo) {
			String regex =
			"[HM]{1}";
		    Pattern patron = Pattern.compile(regex);
		    if (!patron.matcher(sexo).matches()) {
		    	return false;
		    }
		    	return true;
		  }
		/**
		 * rfc valido.
		 *
		 * @param rfc the rfc str
		 * @return true, if successful
		 */
		public static boolean rfcValido(String rfc) {
		    if (rfc == null) {
		      return false;
		    }
		    if (rfc.trim().length() < 10 ) {
		      return false;
		    }
		    return true;
		 }
}
