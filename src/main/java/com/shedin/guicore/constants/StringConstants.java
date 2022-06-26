package com.shedin.guicore.constants;

import lombok.experimental.UtilityClass;


@UtilityClass
public final class StringConstants {

	// browsers
	public enum Browsers {;
		public static final String CHROME = "chrome";
		public static final String FIREFOX = "firefox";
	}

	// file paths
	public enum FilePaths {;
		public static final String DRIVER_PROPERTIES_FILE = "driver.properties";
		public static final String PAGE_PROPERTIES_FILE = "page.properties";
	}

	// properties
	public enum DriverProperties {;
		public static final String BROWSER = "default.browser";
		public static final String PAGE_URL = "base.url";
		public static final String SELENIUM_GRID_ENABLED = "selenium.grid.enabled";
		public static final String GRID_PATH = "selenium.grid.path";
	}

	// operators
	public enum BasicOperators {;
		public static final String IS = "is";
	}
}