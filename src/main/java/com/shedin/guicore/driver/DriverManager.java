package com.shedin.guicore.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.shedin.guicore.constants.StringConstants;
import com.shedin.guicore.utility.ConfigurationHelper;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import java.util.Optional;


@Log4j2
public class DriverManager extends WebDriverRunner {

	private DriverManager() {}

	public static void setDriver() {
		log.info("Driver was started");
		WebDriver driver = WebDriverFactory.createNewDriver();
		Configuration.baseUrl = ConfigurationHelper.getProperty(StringConstants.PAGE_PROPERTIES_FILE, StringConstants.PAGE_URL);
		WebDriverRunner.setWebDriver(driver);
	}

	public static void closeDriver() {
		log.info("Driver was closed");
		Optional.of(getWebDriver()).ifPresent(WebDriver::quit);
	}

	public static String getCurrentURL(){
		return getWebDriver().getCurrentUrl();
	}
}