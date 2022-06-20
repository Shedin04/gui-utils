package com.shedin.guicore.driver.strategy;

import com.shedin.guicore.utility.ConfigurationHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.shedin.guicore.constants.StringConstants.Browsers.FIREFOX;
import static com.shedin.guicore.driver.CapabilitiesHelper.getCapabilities;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FirefoxDriverStrategy implements BrowserStrategy<FirefoxOptions> {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.getInstance(FIREFOX).setup();
		if (ConfigurationHelper.isGridEnabled()) {
			return firefoxdriver().remoteAddress(ConfigurationHelper.getGridPath())
					.capabilities(getCapabilities())
					.create();
		}
		return new FirefoxDriver(getCapabilities());
	}
}