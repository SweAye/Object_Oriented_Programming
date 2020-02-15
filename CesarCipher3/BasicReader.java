import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BasicReader implements Reader{

	private Reader br = null;
	private int getInt;
	private double getDouble;
	private String getString;
	private String text= "";
	
	
	private String fileName = null;
	public BasicReader(String fileName){
		
		this.fileName = fileName;
		
	}
	public void read()
	
	{
		System.out.println("Reading from BasicReader:");
    try (FileReader fr = new FileReader(fileName);
            Scanner scanner=new Scanner(fr)){
        while (scanner.hasNext()) {
            if(scanner.hasNextInt()) {
            
                getInt= scanner.nextInt();
               text += String.valueOf(getInt);
            } else if(scanner.hasNextDouble()) {
                
           	 getDouble = (int) scanner.nextDouble();
           	 text += String.valueOf(getDouble);
            } else if(scanner.hasNext()) {
                getString= scanner.next();
                text += String.valueOf(getString);
            }
        }
        
        System.out.println("BasicReading: " + text);
        fr.close();
    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public String getText(){
		
		return text;
	}

}
