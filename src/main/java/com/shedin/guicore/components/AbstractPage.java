package com.shedin.guicore.components;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.open;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractPage {
	private String pagePath;

	public String getPagePath() {
		return pagePath;
	}

	protected void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public AbstractPage openPage() {
		log.info(this.getClass().getSimpleName() + " page was opened");
		return open(getPagePath(), this.getClass());
	}
}