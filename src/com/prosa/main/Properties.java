package com.prosa.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Properties {
	
	private static final String CONFIG_PROPERTIES = "config.properties";
	
	public static String PATH_LOG;
	public static String PATH_DEST;
	public static String PATH_REPORTS;
	
	public static String DB_HOST;
	public static String DB_PORT;
	public static String DB_NAME;
	public static String DB_USER;
	public static String DB_PSWD;
	
	private static java.util.Properties prop;
	
	static {
		if(readPropertyFile()) {
			PATH_LOG = prop.getProperty("path.log");
			PATH_DEST = prop.getProperty("path.dest");
			PATH_REPORTS = prop.getProperty("path.reports");
			DB_HOST = prop.getProperty("database.host");
			DB_PORT = prop.getProperty("database.port");
			DB_NAME = prop.getProperty("database.name");
			DB_USER = prop.getProperty("database.user");
			DB_PSWD = decodePswd(prop.getProperty("database.pswd"));
		}
	}
	
	private static boolean readPropertyFile() {
		boolean isRead = false;
		try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_PROPERTIES)) {
			prop = new java.util.Properties();
			prop.load(input);
			isRead = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return isRead;
	}
	
	private static String decodePswd(String pswdEncode) {
		if(pswdEncode == null) return null;
		byte[] decodedBytes = Base64.getDecoder().decode(pswdEncode);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

}
