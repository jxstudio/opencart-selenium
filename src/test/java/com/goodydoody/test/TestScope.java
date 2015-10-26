package com.goodydoody.test;

/**
 * It holds a map where test scoped beans are cached, ensuring that only one instance is created.<br/>
 * It also has a reset method for clearing the cache before each test run
 * 
 * @see <a href=
 *      "https://peterkedemo.wordpress.com/2013/03/30/writing-good-selenium-tests-with-page-objects-and-spring/">
 *      Writing good Selenium tests with Page objects and Spring</a>
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class TestScope implements Scope {

	private Map<String, Object> cache = new HashMap<>();

	public void reset() {
		cache.clear();
	}

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		if (!cache.containsKey(name)) {
			cache.put(name, objectFactory.getObject());
		}
		return cache.get(name);
	}

	@Override
	public Object remove(String name) {
		return cache.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return null;
	}

}