package com.shedin.guicore.driver;

import com.shedin.guicore.driver.strategy.BrowserProvider;
import org.openqa.selenium.WebDriver;


public class WebDriverFactory {

	private WebDriverFactory() {}

	public static WebDriver createNewDriver() {
		return BrowserProvider.getBrowserStrategy().getBrowserDriver();
	}
}