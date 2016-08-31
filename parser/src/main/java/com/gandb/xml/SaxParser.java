package com.gandb.xml;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

	public TreeMap<String, List<MatchedElement>> parser(String configure,
			String xml) {
		try {
			File inputFile = new File(xml);
			if (!inputFile.exists() || inputFile.isDirectory()) {
				System.out.println(xml + " doesn't exists");
				return null;
			}

			Configure conf = new Configure(configure);
			if (conf != null) {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();

				SaxXMLHandler userhandler = new SaxXMLHandler(conf);
				saxParser.parse(inputFile, userhandler);
				TreeMap<String, List<MatchedElement>> map = conf
						.getElementMap();

				Set<String> keys = map.keySet();
				for (String key : keys) {
					List<MatchedElement> elements = map.get(key);

					for (MatchedElement element : elements) {
						String out = new String(element.getCh(),
								element.getStart(), element.getLength());
						System.out.println("Node " + key + " found with value "
								+ out);
					}
				}

				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

class SaxXMLHandler extends DefaultHandler {
	private List<MatchedElement> elements;
	private TreeMap<String, List<MatchedElement>> map;
	private HashMap<String, Boolean> isProcessingFlags = new HashMap<String, Boolean>();

	public SaxXMLHandler(Configure conf) {
		this.map = conf.getElementMap();
		Set<String> keys = this.map.keySet();
		for (String key : keys) {
			isProcessingFlags.put(key, false);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		Set<String> keys = map.keySet();
		for (String key : keys) {
			if (qName.equalsIgnoreCase(key)) {
				isProcessingFlags.put(key, true);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		Set<String> keys = map.keySet();
		for (String key : keys) {
			if (qName.equalsIgnoreCase(key)) {
				// System.out.println("End Element :" + qName);
			}
		}
	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException {
		Set<String> keys = map.keySet();
		for (String key : keys) {
			if (isProcessingFlags.get(key)) {
				elements = map.get(key);
				MatchedElement element = new MatchedElement();
				element.setStart(start);
				element.setLength(length);
				element.setCh(ch);
				elements.add(element);
				isProcessingFlags.put(key, false);
			}
		}

	}
}