package com.gandb.xml;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
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
	public void testApp() {
		System.out.println("---- Test App ---");
		App app = new App();
		// app.run("");
	}

}
