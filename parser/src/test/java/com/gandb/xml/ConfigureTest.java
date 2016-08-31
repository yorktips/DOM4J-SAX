package com.gandb.xml;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.TreeMap;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class ConfigureTest extends TestCase {

	public ConfigureTest(String testName) {
		super(testName);
	}

	@Before
	public void setUp() {
		System.out.println("---- Initializing tests ----");
		try {
			InputStream in = AppTest.class.getResourceAsStream("/"
					+ App.CONFIGURATION_FILE);
			if (in == null)
				fail(App.CONFIGURATION_FILE + " not found");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testConfiguration() {
		System.out.println("---- ConfigureTest ---");
		Configure configure = new Configure(App.CONFIGURATION_FILE);

		TreeMap<String, List<MatchedElement>> map = configure.getElementMap();
		assertNotNull(map);
		assertTrue(map.size() > 0);
	}

}
