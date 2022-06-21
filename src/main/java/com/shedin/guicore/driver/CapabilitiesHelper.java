package com.shedin.guicore.driver;

import com.shedin.guicore.utility.ConfigurationHelper;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.shedin.guicore.constants.StringConstants.Browsers.CHROME;
import static com.shedin.guicore.constants.StringConstants.Browsers.FIREFOX;


@UtilityClass
public class CapabilitiesHelper {
	private static final DesiredCapabilities capabilities = new DesiredCapabilities();

	public static DesiredCapabilities getCapabilities() {
		switch (ConfigurationHelper.getBrowser()) {
			case CHROME: {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("start-maximized");
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				break;
			}
			case FIREFOX: {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--window-size=1280,1024");
				capabilities.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
				break;
			}
			default: {
				throw new IllegalArgumentException(
						ConfigurationHelper.getBrowser() + " - browser isn't supported");
			}
		}
		return capabilities;
	}
}