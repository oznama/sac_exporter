package com.prosa.main;

import java.io.IOException;
import java.io.InputStream;

public class Properties {

	private static final String CONFIG_PROPERTIES = "config.properties";

	private static String PATH_LOG;
	private static String PATH_DEST;
	private static String PATH_REPORTS;
	private static String PATH_IMAGES;

	private static java.util.Properties prop;

	static {
		if (readPropertyFile()) {
			PATH_LOG = prop.getProperty("path.log");
			PATH_DEST = prop.getProperty("path.dest");
			PATH_REPORTS = prop.getProperty("path.reports");
			PATH_IMAGES = prop.getProperty("path.images");
		}
	}

	private static boolean readPropertyFile() {
		boolean isRead = false;
		try (InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(CONFIG_PROPERTIES)) {
			prop = new java.util.Properties();
			prop.load(input);
			isRead = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return isRead;
	}

	public static String getConfigProperties() {
		return CONFIG_PROPERTIES;
	}

	public static String getPATH_LOG() {
		return PATH_LOG;
	}

	public static String getPATH_DEST() {
		return PATH_DEST;
	}

	public static String getPATH_REPORTS() {
		return PATH_REPORTS;
	}

	public static String getPATH_IMAGES() {
		return PATH_IMAGES;
	}

	public static java.util.Properties getProp() {
		return prop;
	}

}
