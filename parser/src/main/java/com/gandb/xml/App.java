package com.gandb.xml;

import java.io.File;


/**
 * XML parser test
 *
 */
public class App {
	private static final int DOM4J_LARGE_FILE_SIZE = 1024 * 1024 * 100; // 100M
	public static final String CONFIGURATION_FILE = "config.xml";

	public static void main(String[] args) {
		String xml="";
		if (args.length < 1 ) {
			System.out.println("Usage: java -jar parser.jar <XML>");
		}else{
			xml=args[0];				
		}		
		App app= new App();
		app.run(xml);
	}
	
	public void run(String xml) {
		try {
			if (xml.isEmpty()) {
				xml="sample.xml";
			}
			    
			System.out.println("Parsing " + xml);
			File xmlfile = new File(xml);

			if (xmlfile.exists()) {
				
				if (xmlfile.length() <= DOM4J_LARGE_FILE_SIZE) {					
					// 1. Use DOM4J parser
					DOM4JParser.parser(CONFIGURATION_FILE, xml);

				} else {					
					// 2. Use SAX parser
					SaxParser saxParser = new SaxParser();
					saxParser.parser(CONFIGURATION_FILE, xml);					
				}
			}else{
				System.out.println(xml + " not exists");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
