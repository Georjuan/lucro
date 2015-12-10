/**
 * 
 */
package br.com.lucro.manager.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

/**
 * @author "Georjuan Taylor"
 * Read property parameter from properties file
 */
public class Properties {

	private static final Logger logger = Logger.getLogger(Properties.class);
	
	private static final String PROP_FILE_NAME = "app.properties";
	
	public static final String JPA_ENTITY_NAME = "jpa.entity.name";
	public static final String FILES_CIELO_CHARSET = "files.cielo.charset";

	public static String getProperty(String param) {
		return new Properties().readProperty(param);
	}
	
	private String readProperty(String param) {
		InputStream inputStream = null; String value = null;
		
		try {
			java.util.Properties prop = new java.util.Properties();
			
			inputStream = getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME);
			
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Property file [" + PROP_FILE_NAME + "] not found in the classpath.");
			}

			//Get the property value
			value = prop.getProperty(param);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		
		return value;
	}

}
