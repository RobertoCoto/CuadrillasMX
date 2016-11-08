package com.fyg.cuadrillas.comun;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	/**
	 * Obtiene el HASH de cualquier cadena en SHA-256
	 * @param cadena para hacer Hashing SHA2
	 * @param HEX_FORMAT 
	 * @return String SHA-256
	 * @throws NoSuchAlgorithmException
	 */
	public static String getSHA256(final String cadena, int HEX_FORMAT) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try {
			md.update(cadena.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException es) {
			throw new NoSuchAlgorithmException(es.getMessage());
		}

        byte[] byteData = md.digest();

        //Convertir el byte al formato hex
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, HEX_FORMAT).substring(1));
        }

    	return sb.toString();
	}

}
