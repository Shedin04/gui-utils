package com.shedin.guicore.driver.strategy;

import com.shedin.guicore.utility.ConfigurationHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.shedin.guicore.constants.StringConstants.Browsers.CHROME;
import static com.shedin.guicore.driver.CapabilitiesHelper.getCapabilities;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class ChromeDriverStrategy implements BrowserStrategy<ChromeOptions> {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.getInstance(CHROME).setup();
		if (ConfigurationHelper.isGridEnabled()) {
			return chromedriver().remoteAddress(ConfigurationHelper.getGridPath())
					.capabilities(getCapabilities())
					.create();
		}
		return new ChromeDriver(getCapabilities());
	}
}