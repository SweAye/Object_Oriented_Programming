import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DecoratorTester {
	
	public static void main (String[] args) throws IOException{
		String text = null; 
		 char[] characters = {
			        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			        'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			        'y', 'z', '0', '1', '2', '3', '4', '5',
			        '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			        'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@',
			        '#', '$', '%', '^', '&', '(', ')', '+',
			        '-', '*', '/', '[', ']', '{', '}', '=',
			        '<', '>', '?', '_', '"', '.', ',', ' '
			    };
			   
			 
			//Simple Reading
		//Reader r = new BasicReader("read.txt");
		//r.read();
		
		//Decrypting Reading
		Reader dr = new DecryptingReader (new BasicReader("read.txt"),characters);
		dr.read();
		text = dr.getText();
		System.out.println("Decrypting Reading is:" + text);
		
		Writer bw = new BasicWriter("write.txt", text);
		bw.write();
		
		Writer Ew = new EncryptingWriter(new BasicWriter("write.txt",text), characters, text); 
		Ew.write();
		
	}
}
