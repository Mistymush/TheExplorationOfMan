# TheExplorationOfMan

August Beers (adbeers)
4/24/2017
CS3041-HCI
Code submission for project 4:
Providing Help

Running my code:

	I wrote my code in JavaScript using the most up to date SDK.
	I developed this project in the most recent version of Eclipse Neon.
	I would recommend using this tool to run my code, although i'm sure 
	older versions of eclipse will work as well.

	To open the project start up the eclipse editor.

	Then select: File -> Open Projects from File System 
	(in older versions this might be "open project directory")

	On the pop-up select directory as an import source.
 
	Locate my project where it is downloaded on your pc 
	and select the top level folder "TheExplorationOfMan" to import.

	Once the project is open, update you run configurations to 
	run my project from its main class: "TheExplorationOfMAN.java"

	If everything is working, my swing based interface should appear after a second 
	and the console should print out "XML was opened."


Notes about my submission:

	All of my code was written either from my previous experience 
	our inspired from sources listed at the top of each file.	

	Unfortunately I was unable to implement all the features I wanted for this submission.
	
	My design had to primary paths through the interface:
	A search bar, and two navigation menus.

	I did not have time to implement my search bar. 
	Additionally, the back and forward buttons do not work as well.

	The only component which allows navigation of my XML are 
	the two navigation menus which represent the hierarchy of my data.

	Select a menu option with your mouse to see my controllers in action.

	One other major issue I ran into was formatting my XML text.
	For some reason I was unable to display line brakes when text
	was read directly from XML.

	Because of this issue all of my "MAN pages" are place-holders
	and only take up one line.


My Codebase includes the following files:

	TheExplorationOfMAN.java:
		My main file including the definition of my Swing GUI layout and components. 
		I originally designed this layout using java WindowBuilder and then refactored the template
		code it produced to be more readable.

		I also define my two controller classes at the bottom of the initialization() method.

	XMLParser.java:
		This class is merely a utility script which parses my XML data and produces
		an XML state object containing it.

	XMLState.java:
		This class defines the entity of my XML data structure once it is read into memory.
		XML data is parsed into two types of classes, MANcommands and MANcategories. 
		These two classes represent levels one and two of my hierarchy.

		XMLState also provides accessor methods for the controllers defined in the main class to
		have access of the data.

		
