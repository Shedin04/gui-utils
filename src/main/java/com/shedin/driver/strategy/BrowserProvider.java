package com.shedin.driver.strategy;

import com.shedin.utility.ConfigurationHelper;

import static com.shedin.constants.StringConstants.*;


public class BrowserProvider {

	private BrowserProvider() {}

	public static BrowserStrategy getBrowserStrategy() {
		return ConfigurationHelper.getProperty(DRIVER_PROPERTIES_FILE, BROWSER).equals(CHROME) ?
				new ChromeDriverStrategy() :
				new FirefoxDriverStrategy();
	}
}