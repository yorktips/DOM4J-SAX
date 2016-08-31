package com.gandb.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Configure {
	private String file;
	private TreeMap<String, List<MatchedElement>> elementMap;

	public Configure(String file) {
		this.file = file;
		elementMap = getConf(file);
	}

	public TreeMap<String, List<MatchedElement>> getElementMap() {
		return elementMap;
	}

	public static TreeMap<String, List<MatchedElement>> getConf(String file) {
		TreeMap<String, List<MatchedElement>> map = null;
		try {
			File inputFile = new File(file);
			if (!inputFile.exists() || inputFile.isDirectory()) {
				System.out.println(file + " doesn't exists");
				return null;
			}

			SAXReader reader = new SAXReader();
			Document document = reader.read(inputFile);
			List<Node> nodes = document.selectNodes("//name");
			map = new TreeMap<String, List<MatchedElement>>();

			for (Node node : nodes) {
				String key = node.getStringValue();
				if (key != null && !key.trim().isEmpty()) {
					map.put(key, new ArrayList<MatchedElement>());
				}
			}

		} catch (DocumentException e) {
			// e.printStackTrace();
			return null;
		}

		return map;
	}
}
