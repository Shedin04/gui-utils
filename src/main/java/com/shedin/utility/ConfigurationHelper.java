package com.shedin.utility;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Log4j2
public class ConfigurationHelper {

	private ConfigurationHelper() {}

	public static String getProperty(String file, String key) {
		ClassLoader classLoader = ConfigurationHelper.class.getClassLoader();
		Properties prop = new Properties();
		try {
			prop.load(classLoader.getResourceAsStream(file));
		}
		catch (IOException e) {
			log.warn(e.getMessage());
		}
		return prop.getProperty(key);
	}

	interface Loader {}
}