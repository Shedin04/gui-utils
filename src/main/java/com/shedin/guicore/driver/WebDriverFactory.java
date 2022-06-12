package com.shedin.guicore.driver;

import com.shedin.guicore.driver.strategy.BrowserProvider;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;


@UtilityClass
public class WebDriverFactory {

	public static WebDriver createNewDriver() {
		return BrowserProvider.getBrowserStrategy().getBrowserDriver();
	}
}