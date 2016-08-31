package com.gandb.xml;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class DOM4JParser {

	public static TreeMap<String, List<MatchedElement>> parser(String configuration, String xml) {

		Configure conf= new Configure(configuration);
		if (conf == null) 
			return null;
		 	
		TreeMap<String, List<MatchedElement>> map = conf.getElementMap();
		if (map == null || map.size() < 1) {
			System.out.println("There should be a configuration file where you can define the nodes\n" + 
					"(i.e. ns2:Denomination) he is interested in (case insensitive)");
			return null;
		}
		
		try {
			File inputFile = new File(xml);
			if(!inputFile.exists() || inputFile.isDirectory()) {
				System.out.println(xml + " doesn't exists");
				return null;
			}

			SAXReader reader = new SAXReader();
			Document document = reader.read(inputFile);
			
			Set<String> keys = map.keySet();
			for (String key : keys) {
				List<MatchedElement> elements = map.get(key);
				List<Node> nodes = document.selectNodes("//" + key);

				for (Node node : nodes) {
					MatchedElement element = new MatchedElement();
					String strvalue = node.getStringValue();
					element.setCh(strvalue.toCharArray());
					elements.add(element);
				}
			}

			for (String key : keys) {
				List<MatchedElement> elements = map.get(key);
				for (MatchedElement element : elements) {
					System.out.println("Node " + key + " found with value "
							+ String.valueOf(element.getCh()));
				}
			}

			return map;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}