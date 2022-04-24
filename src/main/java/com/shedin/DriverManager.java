package com.shedin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class DriverManager {
	private static WebDriver driver;

	private static void setUpDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		setUpDriver();
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}