package com.goodydoody.test.object;

/**
 * Bean Post Processor initialization, for Selenium to initialize page beans, i.e. to proxy all WebElement fields in them 
 * 
 * @see <a href=
 *      "https://peterkedemo.wordpress.com/2013/03/30/writing-good-selenium-tests-with-page-objects-and-spring/">
 *      Writing good Selenium tests with Page objects and Spring</a>
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PageObjectBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private WebDriver driver;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(PageObject.class)) {
			PageFactory.initElements(driver, bean);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}