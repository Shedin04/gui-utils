package com.shedin.utility;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Log4j2
public class ConfigurationHelper {

	private ConfigurationHelper() {}

	public static String getProperty(String file, String key) {
		Properties prop = new Properties();
		try (FileInputStream fis = new FileInputStream(file)) {
			prop.load(fis);
		}
		catch (IOException e) {
			log.warn(e.getMessage());
		}
		return prop.getProperty(key);
	}
}