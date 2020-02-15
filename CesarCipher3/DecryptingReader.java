
public class DecryptingReader implements Reader {// back to plain text

	
	private BasicReader br;
	private String textBeforeDecrpt;
	private String textAfterDecrypt;
	private char [] charArray;
	private final int LEVEL =3;
	public DecryptingReader(BasicReader br,char [] charArray){
		
		this.br = br;
		this.charArray = charArray;
	}
	public void read() {
	 
		br.read();
		textBeforeDecrpt = br.getText();
		decrypt (textBeforeDecrpt);
	}
	
	
	 public void decrypt(String text)// print it in plain text
	    {
	        char[] cipher = text.toCharArray();
	        for (int i = 0; i < cipher.length; i++) {
	            for (int j = 0; j < charArray.length; j++) {
	                if (j >= LEVEL && cipher[i] == charArray[j]) {
	                    cipher[i] = charArray[j - LEVEL];
	                    break;
	                }
	                if (cipher[i] == charArray[j] && j < LEVEL) {
	                    cipher[i] = charArray[(charArray.length - LEVEL +1) + j];
	                    break;
	                }
	            }
	        }
	        textAfterDecrypt= String.valueOf(cipher);
	   	
	
}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return textAfterDecrypt;
	}
}
