package com.shedin.components;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public abstract class AbstractPage {
	private String pagePath;

	protected AbstractPage() {}

	public String getPagePath() {
		return pagePath;
	}

	protected void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public void openPage() {
		log.info(this.getClass().getSimpleName() + " page was opened");
		open(getPagePath(), this.getClass());
	}
}