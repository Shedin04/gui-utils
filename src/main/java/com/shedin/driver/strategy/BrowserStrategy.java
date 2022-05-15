package com.shedin.driver.strategy;

import org.openqa.selenium.WebDriver;


public interface BrowserStrategy<T> {
	WebDriver getBrowserDriver();

	T getCapabilities();
}