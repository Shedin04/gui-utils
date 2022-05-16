package com.shedin.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.shedin.utility.ConfigurationHelper;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

import static com.shedin.constants.StringConstants.PAGE_PROPERTIES_FILE;
import static com.shedin.constants.StringConstants.PAGE_URL;


@Log4j2
public class DriverManager extends WebDriverRunner {

	private DriverManager() {}

	public static void setDriver() {
		log.info("Driver was started");
		WebDriver driver = WebDriverFactory.createNewDriver();
		Configuration.baseUrl = ConfigurationHelper.getProperty(PAGE_PROPERTIES_FILE, PAGE_URL);
		WebDriverRunner.setWebDriver(driver);
	}

	public static void closeDriver() {
		log.info("Driver was closed");
		Optional.of(getWebDriver()).ifPresent(WebDriver::quit);
	}
}