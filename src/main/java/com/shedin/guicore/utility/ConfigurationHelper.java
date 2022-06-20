package com.shedin.guicore.utility;

import lombok.experimental.UtilityClass;

import java.util.Locale;

import static com.shedin.guicore.constants.StringConstants.DriverProperties.BROWSER;
import static com.shedin.guicore.constants.StringConstants.FilePath.DRIVER_PROPERTIES_FILE;
import static com.shedin.guicore.constants.StringConstants.FilePath.PAGE_PROPERTIES_FILE;


@UtilityClass
public class ConfigurationHelper {
	private static final String PATH = ".path";
	private static final String SELENIUM_GRID_ENABLED = "selenium.grid.enabled";
	private static final String GRID_PATH = "selenium.grid.path";
	private static String browser;
	private static String gridUrl;

	public static String getBrowser() {
		if (browser == null) {
			browser = ConfigurationService.getProperty(DRIVER_PROPERTIES_FILE, BROWSER);
		}
		return browser;
	}

	public static boolean isGridEnabled() {
		return Boolean.parseBoolean(ConfigurationService.getProperty(DRIVER_PROPERTIES_FILE, SELENIUM_GRID_ENABLED));
	}

	public static String getGridPath() {
		if (gridUrl == null) {
			gridUrl = ConfigurationService.getProperty(DRIVER_PROPERTIES_FILE, GRID_PATH);
		}
		return gridUrl;
	}

	public static String getPagePath(String pageName) {
		return ConfigurationService.getProperty(PAGE_PROPERTIES_FILE, pageName.toLowerCase(Locale.ROOT) + PATH);
	}
}