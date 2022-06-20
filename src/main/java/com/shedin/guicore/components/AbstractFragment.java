package com.shedin.guicore.components;

import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractFragment {
	@Setter
	@Getter
	private By rootElementLocator;
	private SelenideElement rootElement;

	public boolean isDisplayed() {
		return getRootElement().isDisplayed();
	}

	public SelenideElement getRootElement() {
		if (rootElement == null) {
			rootElement = $(getRootElementLocator());
		}
		return rootElement;
	}
}