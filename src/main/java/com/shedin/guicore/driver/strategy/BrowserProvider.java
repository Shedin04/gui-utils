package com.shedin.guicore.driver.strategy;

import com.shedin.guicore.utility.ConfigurationHelper;
import lombok.experimental.UtilityClass;

import static com.shedin.guicore.constants.StringConstants.Browsers.CHROME;


@UtilityClass
public class BrowserProvider {

	public static BrowserStrategy getBrowserStrategy() {
		return ConfigurationHelper.getBrowser().equals(CHROME) ?
				new ChromeDriverStrategy() :
				new FirefoxDriverStrategy();
	}
}