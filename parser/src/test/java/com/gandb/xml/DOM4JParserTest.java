package com.gandb.xml;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.TreeMap;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class DOM4JParserTest extends TestCase {
	public DOM4JParserTest(String testName) {
		super(testName);
	}

	@Test
	public void testDOM4JParser() {
		System.out.println("---- DOM4JParserTest ---");
		TreeMap<String, List<MatchedElement>> map = DOM4JParser.parser(
				App.CONFIGURATION_FILE, "sample.xml");
		assertNotNull(map);
		assertTrue(map.size() > 0);
		checkDom4jParserValue(map);
	}

	public void checkDom4jParserValue(TreeMap<String, List<MatchedElement>> map) {

		if (map == null || map.get("ns2:Denomination") == null
				|| map.get("ns2:InventoryUnit") == null)
			fail("Test place could not be found using the radar method.");

		assertTrue(map.size() == 2);
		assertNotNull(map.get("ns2:Denomination"));
		assertNotNull(map.get("ns2:InventoryUnit"));
		assertTrue(map.get("ns2:Denomination").size() > 0);
		assertNotNull(map.get("ns2:Denomination").size() > 0);
	}
}
