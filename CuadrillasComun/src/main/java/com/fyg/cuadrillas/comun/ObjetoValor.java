package com.fyg.cuadrillas.comun;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * The Class ObjetoValor.
 *
 * @author Mario Mejorada
 * Objeto Serializable que ser&aacute; la base para todos los mensajes.
 */
public abstract class ObjetoValor implements Serializable {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8L;

	/** The tipo. */
	private int tipo;

	/**
	 * Instancia una nueva objeto valor.
	 */
	public ObjetoValor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene tipo.
	 *
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * Establece tipo.
	 *
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer stringbuffer = new StringBuffer();
		StringBuffer stringbufferObjects =  new StringBuffer();
		try {
            Method m[] = this.getClass().getDeclaredMethods();
            for (Method miM : m) {
            	if ( stringbuffer.length() > 0 ) {
					stringbuffer.append(" | ");
				}
            	if ( miM.getName().startsWith("get") ||  miM.getName().startsWith("is") ) {
            		stringbuffer.append( miM.getName() );
            		stringbuffer.append("=" );
            		Object res = (Object) miM.invoke( this );
            		if ( res != null ) {
            			if ( res.getClass().isArray() ) {
            				Object[] array = (Object[]) res;

            				for (Object miO : array ) {
            					if ( stringbufferObjects.length() > 0 ) {
									stringbufferObjects.append( ", " );
								}
            					if ( miO != null ) {
									stringbufferObjects.append(  miO.toString() );
								}
            				}
            				stringbuffer.append(stringbufferObjects  );
            			} else {
							stringbuffer.append(  res.toString() );
						}
            		} else {
						stringbuffer.append( res );
					}
            	}
            }
         }
         catch (Throwable e) {
        	 e.printStackTrace();
         }
         stringbuffer.insert(0, this.getClass().getName() + "[");
         stringbuffer.append("]");
         return   stringbuffer.toString();
	}
}
