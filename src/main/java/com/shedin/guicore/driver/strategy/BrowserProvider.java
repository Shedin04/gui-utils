package com.shedin.guicore.driver.strategy;

import com.shedin.guicore.utility.ConfigurationHelper;
import lombok.experimental.UtilityClass;

import static com.shedin.guicore.constants.StringConstants.*;


@UtilityClass
public class BrowserProvider {

	public static BrowserStrategy getBrowserStrategy() {
		return ConfigurationHelper.getProperty(DRIVER_PROPERTIES_FILE, BROWSER).equals(CHROME) ?
				new ChromeDriverStrategy() :
				new FirefoxDriverStrategy();
	}
}