/*
	 * This class take care of reading input from a test file
	 * and  String Value back to caller
	 */

	import java.io.*;
	import java.lang.SecurityException;
	import java.util.Formatter;
	import java.util.FormatterClosedException;
	import java.util.NoSuchElementException;
	import java.util.Scanner;
	import java.lang.IllegalStateException;
	import java.util.StringTokenizer;

	
		// This class can take manual testing or Test Cases which purposed by the
		// .txt files


public class UserInput {
	
			private Scanner myscanner;
		private String Value = "";
		int len1;
		int len2;
		int len3;

		// Constructor from the test input file .txt
		public UserInput(String inputFile) {

			try {
				myscanner = new Scanner(new File(inputFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(1);

			}
			try {
				while (myscanner.hasNext()) {

					setValue(myscanner.nextLine());
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			String[] token = Value.split(" ");
			for (String s : token){
				System.out.println(s);
			}
			System.out.printf("%s",token[0]);
			System.out.printf("%s",token[1]);
			System.out.printf("%s",token[2]);

			
		System.out.println("\n" + (len1 = (Integer.parseInt(token[0]))));
		System.out.println(len2 = (Integer.parseInt(token[1])));
		System.out.println(len3 = (Integer.parseInt(token[2])));

			// System.out.printf("test1Value is : %s\ntest2Value is : %s",
			// test1Value, test2Value);

			// System.out.println("\nReturning from the Input Class Constructor");

		}

		// Another Constructor for manual input from the console
		public UserInput() {

			myscanner = new Scanner(System.in);
			
			System.out.println("Please Enter 3 integer space between them");
			// Here add many ValitateInput method to serialize the input values
			// before system crush or get wrong value get in
			Value = myscanner.nextLine();
			tokenizeString(Value);
			}

		public String getValue() {

			return this.Value;

		}

		public void setValue(String s) {
			this.Value = s;
		}

		public void tokenizeString(String v) {

			String[] token = v.split(" ");
			for (String s : token){
				System.out.println(s);
			}
			System.out.printf("%s",token[0]);
			System.out.printf("%s",token[1]);
			System.out.printf("%s",token[2]);

			
		System.out.println("\n" + (len1 = (Integer.parseInt(token[0]))));
		System.out.println(len2 = (Integer.parseInt(token[1])));
		System.out.println(len3 = (Integer.parseInt(token[2])));
		
		}
		
			public int getleng1() {
			
			return len1;
		}

		public int getleng2() {
			return len2;
		}

		public int getleng3() {
			return len3;
		}
		
		public void printlLength(){
			
			System.out.println(len1+"\t" +len2+"\t"+len3);
		}
	}
	


