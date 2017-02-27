package com.fyg.cuadrillas.comun;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;



/**
 * The Class LogHandler para log4j.
 *
 * @author Gerardo Corzo
 */
public class LogHandler extends Logger {
	/** The no uid. */
	private static final String NO_UID = " NO UID ";

	/** The no class. */
	private static final String NO_CLASS = " NO CLASS ";

	/** The no msg. */
	private static final String NO_MSG = " NO MSG ";

	/** The separador. */
	private static final String SEPARADOR = " :: ";

	/** The log . */
	private static Logger logger;
  /**
   * fabrica de logger
   */
  private static final  LoggerFactoryHandler MYFACTORY = new LoggerFactoryHandler();
	  /**
	     Just calls the parent constuctor.
	   * @param name .
	   */
	  public LogHandler(final String name) {
	    super(name);
	  }

	  /**
	     This method overrides {@link Logger#getInstance} by supplying
	     its own factory type as a parameter.
	  * @param name .
	  * @return Logger
	  */
	  public  static  Category getInstance(final String name) {
	    return Logger.getLogger(name, MYFACTORY);
	  }

	  /**
	     This method overrides {@link Logger#getLogger} by supplying
	     its own factory type as a parameter.
	  * @param name .
	  * @return Logger
	  */
	  public  static  Logger getLogger(final String name) {
	    return Logger.getLogger(name, MYFACTORY);
	  }


		/**
		 * Format msg.
		 *
		 * @param uid the uid
		 * @param clase the clase
		 * @param msg the msg
		 * @return the string
		 */
		private static String formatMsg(final String uid, final Class<?> clase, final String msg ) {
			return ( uid != null ? uid : NO_UID ) + SEPARADOR + ( clase != null ? clase.getSimpleName()
					: NO_CLASS ) + SEPARADOR + ( msg != null ? msg : NO_MSG );
		}


		/**
		 * Format exception.
		 *
		 * @param exception the exception
		 * @return the string
		 */
		private static String formatException(final Exception exception) {
			return  exception.getCause() + SEPARADOR + exception.getMessage() + SEPARADOR
					+ formatStackTrace(exception.getStackTrace() );
		}

		/**
		 * Format stack trace.
		 *
		 * @param stackElements the stack elements
		 * @return the string
		 */
		private static synchronized String formatStackTrace(final StackTraceElement[] stackElements) {
			StringBuffer buffer = new StringBuffer();
			for ( int i = 0; i < stackElements.length; i++) {
				buffer.append( "\n\t" );
				buffer.append( stackElements[i].toString() );
			}
			return buffer.toString();
		}

		/**
		 * Debug.
		 *
		 * @param uid the uid
		 * @param clase the clase
		 * @param msg the msg
		 */
		public static void debug(final String uid, final Class<?> clase, final String msg) {
			logger = Logger.getLogger(clase);
			logger.debug( formatMsg( uid, clase, msg  ) );
		}

		/**
		 * Info.
		 *
		 * @param uid the uid
		 * @param clase the clase
		 * @param msg the msg
		 */
		public static void info(final String uid,  final Class<?> clase, final String msg) {
			logger = Logger.getLogger(clase);
			logger.info( formatMsg( uid, clase, msg ) );
		}

		/**
		 * Warn.
		 *
		 * @param uid the uid
		 * @param clase the clase
		 * @param msg the msg
		 */
		public static void warn(final String uid, final Class<?> clase, final String msg) {
			logger = Logger.getLogger(clase);
			logger.warn( formatMsg( uid, clase, msg ) );
		}

		/**
		 * Error.
		 *
		 * @param uid the uid
		 * @param clase the clase
		 * @param msg the msg
		 * @param exception the exception
		 */
		public static void error(final String uid, final Class<?> clase, final String msg, Exception exception) {
			logger = Logger.getLogger(clase);
			logger.error( formatMsg(uid, clase, msg) +  SEPARADOR + formatException(exception));
			System.out.println("ERROR" + formatMsg(uid, clase, msg) +  SEPARADOR + formatException(exception));
		}

		/**
		 * Trace.
		 *
		 * @param uid the uid
		 * @param clase the clase
		 * @param msg the msg
		 */
		public static void trace(final String uid, final Class<?> clase, final String msg) {
			logger = Logger.getLogger(clase);
			logger.trace( formatMsg(uid, clase, msg));
			}
}

