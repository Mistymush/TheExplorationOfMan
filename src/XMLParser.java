/**
 * @author August Beers
 * 4/12/2017
 * 
 * used the following page as reference for this file:
 * https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
 */


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	/*
	XMLParser(){

	}
	*/
	
	public void readMANData(String fileName) throws ParserConfigurationException, SAXException, IOException{
		
		//Open XMLFile
		File xml_file_handle = new File("MANdata.xml");
		
		//Parse XML
		System.out.println("XML is opened here.");
		DocumentBuilderFactory doc_fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder xml_builder = doc_fac.newDocumentBuilder();
		Document xml_doc = xml_builder.parse(xml_file_handle);
		
		System.out.println("XML root node name: " + xml_doc.getDocumentElement().getNodeName());
		
		System.out.println("Help Document Listing:");
		
		//For all nodes in the xml print their contents.
		NodeList articles = xml_doc.getElementsByTagName("MANdoc");
		for (int i =0; i < articles.getLength(); i++){
			Node current_node = articles.item(i);
			
			System.out.print("	Node Found: " + current_node.getNodeName() + "\n");
			
			if(current_node.getNodeType() == Node.ELEMENT_NODE){
				Element current_element = (Element) current_node;
				
				System.out.print("		Article Title: " + current_element.getAttribute("Title") +  "\n");
				System.out.print("		Article Body: " + current_element.getAttribute("Body") + "\n");
			}
			
		}
	}
}
