1) Run in command line:
   1. Define the nodes you are interested in (case insensitive) in config.xml.
      The default configuration is:
      
      Config.xml:
       <?xml version="1.0"?>
       <elements>
          <element>
             <name>ns2:Denomination</name>
             <path></path>
          </element>
          <element>
             <name>ns2:InventoryUnit</name>
             <path></path>
          </element>   
       </elements>

   2. Run parser.jar:
      cd bin
         java -jar parser.jar <XML file>
         (Will use the defult XML file is no paramter specified)
       For example: 
         java -jar parser.jar  york_sample.xml 
         java -jar parser.jar 
         (Will use default sample.xml if no XML specified)

2) Run in Eclipse IDE:
    1. Change config.xml and sample.xml in the resources folder if you want
    2. Select App.java and Run As Application

3) App will use DOM4J if XML file size less than 100M
   App will use SAX if XML file size greater than 100M

