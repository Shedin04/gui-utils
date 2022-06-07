package com.shedin.guicore.components;

import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractFragment {
	private SelenideElement rootElement;

	private final By alert = By.cssSelector(".error-message-container.error");

	protected SelenideElement getRootElement() {
		return rootElement;
	}

	public void setRootElement(SelenideElement element) {
		this.rootElement = element;
	}

	public boolean isDisplayed() {
		return getRootElement().isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return $(alert).isDisplayed();
	}

	public String getAlertMessage() {
		return $(alert).getText();
	}
}