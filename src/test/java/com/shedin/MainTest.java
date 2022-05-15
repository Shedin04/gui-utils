package com.shedin;

import com.shedin.driver.DriverManager;
import org.openqa.selenium.WebDriver;


public class MainTest {
	public static final String URL = "https://semantic-ui.com/modules/dropdown.html";
	public static final String API_PATH = "public/v2/users";

	public static void main(String[] args) {
		WebDriver driver = DriverManager.getDriver();
		driver.get(URL);
		DriverManager.closeDriver();
	}
}