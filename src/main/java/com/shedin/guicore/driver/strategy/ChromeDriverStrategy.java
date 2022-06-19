package com.shedin.guicore.driver.strategy;

import com.shedin.guicore.utility.ConfigurationHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.shedin.guicore.constants.StringConstants.DRIVER_PROPERTIES_FILE;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class ChromeDriverStrategy implements BrowserStrategy<ChromeOptions> {

	@Override
	public WebDriver getBrowserDriver() {
		chromedriver().setup();
		if (Boolean.parseBoolean(ConfigurationHelper.getProperty(DRIVER_PROPERTIES_FILE, "selenium.grid.enabled"))) {
			return chromedriver().remoteAddress(ConfigurationHelper.getProperty(DRIVER_PROPERTIES_FILE, "selenium.grid.path"))
					.capabilities(getCapabilities())
					.create();
		}
		return new ChromeDriver(getCapabilities());
	}

	@Override
	public ChromeOptions getCapabilities() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		return options;
	}
}