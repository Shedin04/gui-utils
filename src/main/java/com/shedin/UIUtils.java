package com.shedin;


public class UIUtils {

	public static void openPage(String url) {
		DriverManager.getDriver().get(url);
		DriverManager.closeDriver();
	}
}