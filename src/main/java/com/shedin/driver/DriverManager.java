package com.shedin.driver;

import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;


@Log4j2
public class DriverManager extends WebDriverRunner {
	private static WebDriver driver;

	private DriverManager() {}

	public static WebDriver getDriver() {
		if (driver == null) {
			log.info("Driver was started");
			driver = WebDriverFactory.createNewDriver();
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			log.info("Driver was closed");
			driver.quit();
			driver = null;
		}
	}

	public static void openURL(String url) {
		getDriver().get(url);
	}
}