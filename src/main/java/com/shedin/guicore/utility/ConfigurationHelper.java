package com.shedin.guicore.utility;

import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;


@Log4j2
@NoArgsConstructor
public class ConfigurationHelper {

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
}