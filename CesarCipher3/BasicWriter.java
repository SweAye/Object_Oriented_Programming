import java.io.FileWriter;
import java.io.IOException;

public class BasicWriter implements Writer {

	
	private String fileName = null;
	private String text = null;
	public BasicWriter(String fileName, String text){
		this.fileName = fileName;
		this.text = text;
	}
	@Override
	
	public void write() {
		System.out.println("Writing to a file");
		// TODO Auto-generated method stub
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.write(text);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//overloaded write
	public void write (String texToWrite){
		System.out.println("Writing from a overloaded writer file");
		// TODO Auto-generated method stub
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.write(texToWrite);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
