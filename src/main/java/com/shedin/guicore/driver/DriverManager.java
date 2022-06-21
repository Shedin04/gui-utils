package com.shedin.guicore.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.shedin.guicore.constants.StringConstants;
import com.shedin.guicore.utility.ConfigurationService;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import java.util.Optional;


@Log4j2
@UtilityClass
public class DriverManager extends WebDriverRunner {

	public static void setDriver() {
		WebDriver driver = WebDriverFactory.createNewDriver();
		Configuration.baseUrl = ConfigurationService.getProperty(StringConstants.FilePaths.PAGE_PROPERTIES_FILE,
																 StringConstants.DriverProperties.PAGE_URL);
		WebDriverRunner.setWebDriver(driver);
		log.info("Driver was started");
	}

	public static void closeDriver() {
		Optional.of(getWebDriver()).ifPresent(WebDriver::quit);
		WebDriverRunner.closeWebDriver();
		log.info("Driver was closed");
	}

	public static String getCurrentURL() {
		return getWebDriver().getCurrentUrl();
	}
}