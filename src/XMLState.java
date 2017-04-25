import java.util.ArrayList;

/**
 * This file defines the necessary classes to describe the 
 * internal state of the exploration of MAN.
 * @author adbeers
 *
 */
public class XMLState {
	
	/**
	 * MANcommand
	 * A Generic man page containing a title and a description.
	 */
	public class MANcommand{
		String title;
		String body;
		
		MANcommand(String titel, String body){
			this.title = titel;
			this.body = body;
		}
		
		public String getTitle(){
			return title;
		}
		
		public String getBody(){
			return body;
		}
	}
	
	/**
	 * MANcatagory
	 * A summary of MAN pages
	 * Adds to the class above by possessing a list of sub commands 
	 * which belong to this category.
	 */
	public class MANcategory extends MANcommand {
		
		ArrayList<String> subCommands = new ArrayList<String>();
		
		MANcategory(String titel, String body) {
			super(titel, body);
		}
		
		public void addSubCommand(String new_cmd){
			subCommands.add(new_cmd);
		}
	}
	
	/**
	 * Data Structures to hold read in MAN page help information.
	 */
	ArrayList<MANcategory> XMLcatagories = new ArrayList<MANcategory>();
	ArrayList<MANcommand> XMLcommands = new ArrayList<MANcommand>();
	
	public void addCatagory(MANcategory new_catagory){
		XMLcatagories.add(new_catagory);
	}
	
	public void addCommand(MANcommand new_command){
		XMLcommands.add(new_command);
	}
	
	public String[] getCategories(){
		String[] cat_names = new String[XMLcatagories.size()];
		
		for(int i = 0; i < XMLcatagories.size(); i++){
			cat_names[i] = XMLcatagories.get(i).getTitle();
		}
		
		return(cat_names);
	}
	
	public MANcategory getCategoryByName(String category){
		MANcategory cat = null;
		for(int i = 0; i < XMLcatagories.size(); i++){
			if(XMLcatagories.get(i).getTitle().equals(category)){
				cat = XMLcatagories.get(i);
			}
		}
		
		if(cat == null){
			System.out.println("failed to find category");
			System.exit(0);
		}
		
		return cat;	
	}
	
	public MANcommand getCommandByName(String cmd_name){
		MANcommand cmd = null;
		for(int i = 0; i < XMLcommands.size(); i++){
			if(XMLcommands.get(i).getTitle().equals(cmd_name)){
				cmd = XMLcommands.get(i);
			}
		}
		
		if(cmd == null){
			System.out.println("failed to find cmd");
			System.exit(0);
		}
		
		return cmd;	
	}
	
	public String[] getCategorieCommands(String category){
		
		MANcategory cat = getCategoryByName(category);

		String[] cmd_names = new String[cat.subCommands.size()];
		
		for(int i = 0; i < cat.subCommands.size(); i++){
			cmd_names[i] = cat.subCommands.get(i);
		}
		
		return(cmd_names);
	}
}

