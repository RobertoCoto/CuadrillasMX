package com.fyg.cuadrillas.comun;

/** Shamelessly ripped from generated XDoclet source, because I don't want to generate util classes.
*
* @author XDoclet.sf.net
* @version $Id: GUIDGenerator.java 5585 2008-05-01 20:55:00Z anatom $
*/
public class GUIDGenerator {

	/**
	 * Instancia una nueva GUID generator.
	 */
	public GUIDGenerator() { }
    /** Cached per JVM server IP. */
    private static String hexServerIP = null;

    // initialise the secure random instance
    /** The Constant seeder. */
    private static final java.security.SecureRandom seeder = new java.security.SecureRandom();

    /**
     * A 32 byte GUID generator (Globally Unique ID). These artificial keys SHOULD <strong>NOT </strong> be seen by the user,
     * not even touched by the DBA but with very rare exceptions, just manipulated by the database and the programs.
     *
     * Usage: Add an id field (type java.lang.String) to your EJB,
     * and add setId(XXXUtil.generateGUID(this)); to the ejbCreate method.
     *
     * @param o the o
     * @return the string
     */
    public static final String generateGUID(Object o) {
        StringBuffer tmpBuffer = new StringBuffer(16);
        if (hexServerIP == null) {
            java.net.InetAddress localInetAddress = null;
            try {
                localInetAddress = java.net.InetAddress.getLocalHost();
            } catch (Exception uhe) {
           	 hexServerIP = hexFormat(getInt("127.0.0.1".getBytes()), 8);
            }
            byte serverIP[] = localInetAddress.getAddress();
            hexServerIP = hexFormat(getInt(serverIP), 8);
        }

        String hashcode = hexFormat(System.identityHashCode(o), 8);
        tmpBuffer.append(hexServerIP);
        tmpBuffer.append(hashcode);

        long timeNow      = System.currentTimeMillis();
        int timeLow       = (int) timeNow & 0xFFFFFFFF;
        int node          = seeder.nextInt();

        StringBuffer guid = new StringBuffer(32);
        guid.append(hexFormat(timeLow, 8));
        guid.append(tmpBuffer.toString());
        guid.append(hexFormat(node, 8));
        return guid.toString();
    }

    /**
     * Obtiene int.
     *
     * @param bytes the bytes
     * @return int
     */
    private static int getInt(byte bytes[]) {
        int i = 0;
        int j = 24;
        for (int k = 0; j >= 0; k++) {
            int l = bytes[k] & 0xff;
            i += l << j;
            j -= 8;
        }
        return i;
    }

    /**
     * Hex format.
     *
     * @param i the i
     * @param j the j
     * @return the string
     */
    private static String hexFormat(int i, int j) {
        String s = Integer.toHexString(i);
        return padHex(s, j) + s;
    }

    /**
     * Pad hex.
     *
     * @param s the s
     * @param i the i
     * @return the string
     */
    private static String padHex(String s, int i) {
        StringBuffer tmpBuffer = new StringBuffer();
        if (s.length() < i) {
            for (int j = 0; j < i - s.length(); j++) {
                tmpBuffer.append('0');
            }
        }
        return tmpBuffer.toString();
    }
}

