/**
 * @author August Beers
 * 4/23/2017
 * 
 * used the following page as reference for this file:
 * http://www.codejava.net/java-se/swing/jpanel-basic-tutorial-and-examples
 */

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

import javax.swing.*;


//Class which contains program head.
public class TheExplorationOfMAN {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//Read in the parser Data
		//XMLParser parser = new XMLParser();
		//parser.readMANData("MANdata.xml");
		
		//Launch a JFrame
		JFrame my_frame = new JFrame("The Exploration of MAN");
		my_frame.setVisible(true);
		my_frame.setSize(600, 600);
		my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Attach A JPanel
		
		
	}

}
