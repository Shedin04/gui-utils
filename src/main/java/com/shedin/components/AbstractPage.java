package com.shedin.components;

import com.shedin.driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.shedin.driver.DriverManager.openURL;

@Log4j2
public abstract class AbstractPage {
	private String pageURL;
	protected WebDriver driver;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	public AbstractPage openPage() {
		log.info(this.getClass().getSimpleName() + " page was opened");
		openURL(getPageURL());
		return this;
	}
}