
public class EncryptingWriter implements Writer{// write in secret form
	//private Writer w;
	private BasicWriter bw;
	private char [] characters;
	private final int LEVEL =3;
	private String BeforeEncrytext;
	private String readyToWriteText;
	public EncryptingWriter(BasicWriter bw, char [] characters, String text){
		//this.w = w;
		this.bw = bw;
		this.characters = characters;
		this.BeforeEncrytext = text;
	}
	
	@Override
	public void write() {
		encrypt(BeforeEncrytext);
		bw.write(readyToWriteText);
		
	}

	public void encrypt(String text)
    {
        char[] plain = text.toCharArray();

        for (int i = 0; i < plain.length; i++) {
            for (int j = 0; j < characters.length; j++) {
                if (j <= characters.length - LEVEL) {
                    if (plain[i] == characters[j]) {
                        plain[i] = characters[j + LEVEL];
                        break;
                    }
                } 
                else if (plain[i] == characters[j]) {
                    plain[i] = characters[j - (characters.length - LEVEL + 1)];
                }
            }
            
        }
     
        readyToWriteText= String.valueOf(plain);
        System.out.println("From the Encrypting Writer: " + readyToWriteText);
    }
	
}
