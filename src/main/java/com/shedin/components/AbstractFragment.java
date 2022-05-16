package com.shedin.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractFragment {
    private WebElement rootElement;

    protected AbstractFragment(WebDriver driver) {
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public boolean isDisplayed() {
        return getRootElement().isDisplayed();
    }
}