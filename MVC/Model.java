import java.util.ArrayList;
/**
 * This is the MVC's model part of the program
 * @author Aye Swe
 *
 */

public class Model {
	
	ArrayList<String> texts;
	
	
	public Model (){
	
		texts = new ArrayList<String>();
	
		
	}
	
	public void addTexts(String s){
		
		texts.add(s);
		
	}
	
	public ArrayList<String> getTextArray(){
		
		return texts;
	}

	
} 