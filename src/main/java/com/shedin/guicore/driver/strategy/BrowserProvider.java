package com.shedin.guicore.driver.strategy;

import com.shedin.guicore.utility.ConfigurationHelper;

import static com.shedin.guicore.constants.StringConstants.*;


public class BrowserProvider {

	private BrowserProvider() {}

	public static BrowserStrategy getBrowserStrategy() {
		return ConfigurationHelper.getProperty(DRIVER_PROPERTIES_FILE, BROWSER).equals(CHROME) ?
				new ChromeDriverStrategy() :
				new FirefoxDriverStrategy();
	}
}