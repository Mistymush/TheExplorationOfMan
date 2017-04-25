/**
 * @author August Beers
 * 4/12/2017
 * 
 * used the following page as reference for this file:
 * https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
 * 
 * I used https://linux.die.net/man to source my simple MAN help examples.
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
	
	public XMLState readMANData(String fileName) throws ParserConfigurationException, SAXException, IOException{
		
		//Open XMLFile
		File xml_file_handle = new File(fileName);
		
		//XMLState to hold read in data.
		XMLState new_state = new XMLState();
		
		//Parse XML
		System.out.println("XML was opened.");
		DocumentBuilderFactory doc_fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder xml_builder = doc_fac.newDocumentBuilder();
		Document xml_doc = xml_builder.parse(xml_file_handle);
		
		//For all top level "MANcategory" nodes produce a MANcategory class and add it to the state class.
		NodeList articles = xml_doc.getElementsByTagName("MANcategory");
		for (int i =0; i < articles.getLength(); i++){
			Node current_node = articles.item(i);
			
			if(current_node.getNodeType() == Node.ELEMENT_NODE){
				Element current_element = (Element) current_node;
				
				XMLState.MANcategory new_category =  new_state.new MANcategory(current_element.getAttribute("Title"),
													current_element.getAttribute("Body"));
			
				//For all child nodes of each category produce an MANcommand class and add each to our state class.
				NodeList children = current_element.getChildNodes();
				for (int j =0; j < children.getLength(); j++){
					
					Node current_child = children.item(j);
					if(current_child.getNodeType() == Node.ELEMENT_NODE){
						Element current_child_element = (Element) current_child;
						
						XMLState.MANcommand new_command = new_state.new MANcommand(current_child_element.getAttribute("Title"),
								current_child_element.getAttribute("Body"));
						
						//add this cmd page to our state and register it with a category.
						new_category.addSubCommand(new_command.getTitle());
						new_state.addCommand(new_command);
					}	
				}
				
				//add our fully defined category to the state
				new_state.addCatagory(new_category);
			}
		}
		
		//return the state in its final form.
		return new_state;
	}
}
