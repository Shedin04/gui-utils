package com.shedin.guicore.driver.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FirefoxDriverStrategy implements BrowserStrategy<FirefoxOptions> {

	@Override
	public WebDriver getBrowserDriver() {
		firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(getCapabilities());
		log.info("FirefoxDriver was created");
		return driver;
	}

	@Override
	public FirefoxOptions getCapabilities() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--window-size=1280,1024");
		return options;
	}
}