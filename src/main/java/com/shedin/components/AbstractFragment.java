package com.shedin.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public abstract class AbstractFragment {
    private SelenideElement rootElement;

    private final By alert = By.cssSelector("error-message");

    protected AbstractFragment() {
    }

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
}