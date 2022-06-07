package com.shedin.guicore.driver.strategy;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

@Log4j2
class ChromeDriverStrategy implements BrowserStrategy<ChromeOptions> {

	@Override
	public WebDriver getBrowserDriver() {
		chromedriver().setup();
		WebDriver driver = new ChromeDriver(getCapabilities());
		log.info("ChromeDriver was created");
		return driver;
	}

	@Override
	public ChromeOptions getCapabilities() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		return options;
	}
}