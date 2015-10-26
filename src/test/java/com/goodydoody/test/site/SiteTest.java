package com.goodydoody.test.site;

/**
 * Site Test is used for creating test cases
 * 
 * @see <a href=
 *      "https://peterkedemo.wordpress.com/2013/03/30/writing-good-selenium-tests-with-page-objects-and-spring/">
 *      Writing good Selenium tests with Page objects and Spring</a>
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.goodydoody.test.SeleniumTestCaseContext;
import com.goodydoody.test.SeleniumTestExecutionListener;
import com.goodydoody.test.page.IndexPage;
import com.goodydoody.test.page.LoginPage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SeleniumTestCaseContext.class)
@TestExecutionListeners({ SeleniumTestExecutionListener.class, DependencyInjectionTestExecutionListener.class })
public class SiteTest {

	@Autowired
	private Site site;

	@Before
	public void testLogin() {
		LoginPage page = site.gotoLoginPage();
		page.setEmail("demo").setPassword("demo").clickSubmit();
	}

	@Test
	public void testIndex() {
		IndexPage page = site.gotoIndexPage();
		page.gotoDesktopsCategory().gotoLaptopsCategory().gotoComponentsCategory()
				.gotoTabletsCategory();
	}

}