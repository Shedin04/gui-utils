package com.shedin.guicore.driver.strategy;

import com.shedin.guicore.utility.ConfigurationHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.shedin.guicore.constants.StringConstants.DRIVER_PROPERTIES_FILE;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FirefoxDriverStrategy implements BrowserStrategy<FirefoxOptions> {

	@Override
	public WebDriver getBrowserDriver() {
		firefoxdriver().setup();
		if (Boolean.parseBoolean(ConfigurationHelper.getProperty(DRIVER_PROPERTIES_FILE, "selenium.grid.enabled"))) {
			return firefoxdriver().remoteAddress(ConfigurationHelper.getProperty(DRIVER_PROPERTIES_FILE, "selenium.grid.path"))
					.capabilities(getCapabilities())
					.create();
		}
		return new FirefoxDriver(getCapabilities());
	}

	@Override
	public FirefoxOptions getCapabilities() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--window-size=1280,1024");
		return options;
	}
}