package com.goodydoody.test.site;

/**
 * Site is the root PageObject for accessing other pages
 * 
 * @see <a href=
 *      "https://peterkedemo.wordpress.com/2013/03/30/writing-good-selenium-tests-with-page-objects-and-spring/">
 *      Writing good Selenium tests with Page objects and Spring</a>
 */

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodydoody.test.object.PageObject;
import com.goodydoody.test.page.IndexPage;
import com.goodydoody.test.page.LoginPage;

@PageObject
public class Site {

	private static final String BASE_URL = "http://demo.opencart.com/";

	@Autowired
	private WebDriver driver;

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private IndexPage indexPage;

	public LoginPage gotoLoginPage() {
		driver.get(BASE_URL + "index.php?route=account/login");
		return loginPage;
	}

	public IndexPage gotoIndexPage() {
		driver.get(BASE_URL + "index.php");
		return indexPage;
	}

}
