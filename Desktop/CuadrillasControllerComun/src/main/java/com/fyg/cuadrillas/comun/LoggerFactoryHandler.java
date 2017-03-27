package com.fyg.cuadrillas.comun;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class LoggerFactoryHandler implements LoggerFactory {


	/**
	 * @param name .
	 * @return LogHandler.
	 */
	  public
	  Logger makeNewLoggerInstance(String name) {
	    return new LogHandler(name);
	  }
	}
