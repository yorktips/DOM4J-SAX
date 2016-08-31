package com.gandb.xml;

import org.junit.Test;
import java.util.List;
import java.util.TreeMap;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class SaxParserTest extends TestCase {
	public SaxParserTest(String testName) {
		super(testName);
	}

	@Test
	public void testSaxParser() {
		System.out.println("---- SaxParserTest ---");
		SaxParser saxParser = new SaxParser();
		TreeMap<String, List<MatchedElement>> map = saxParser.parser(
				App.CONFIGURATION_FILE, "sample.xml");
		assertNotNull(map);
		assertTrue(map.size() > 0);
		checkSaxParser(map);
	}

	public void checkSaxParser(TreeMap<String, List<MatchedElement>> map) {

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
