package com.goodydoody.test;

/**
 * The listener has two responsibilities: <br/>
 * 1) Resetting the test scope before each test <br/>
 * 2) Closing the Selenium driver, i.e. the browser, after each test
 *
 * @see <a href=
 *      "https://peterkedemo.wordpress.com/2013/03/30/writing-good-selenium-tests-with-page-objects-and-spring/">
 *      Writing good Selenium tests with Page objects and Spring</a>
 */

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		testContext.getApplicationContext().getBean(TestScope.class).reset();
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		testContext.getApplicationContext().getBean(WebDriver.class).quit();
	}

}