package parser;

public class Scanner {

	private char currentChar;
	private byte currentKind;
	private StringBuffer currentSpelling;
	private StringBuffer source;
	private int  count;
	
	public Scanner(StringBuffer source){
		this.source = source;
		currentChar = source.charAt(0);
		count = 0;
	}
	
	public Token scan(){
		while(currentChar == ' '){
			scanSeperator();
		}
		currentSpelling = new StringBuffer("");
		currentKind = scanToken();
		return new Token(currentKind, currentSpelling.toString());
		
	}
	private void scanSeperator(){
		switch(currentChar){
		case ' ':
			takeIt();
			break;
		}
		
	}
	
	private void Take(char echar){
		if(currentChar == echar){
			takeIt();
		}
		else {
			System.out.println("Scan error Error. Expected: " + echar + " got: " + currentChar);
		}
	}
	
	private byte scanToken() {
		
		switch (currentChar){
		case '0':  case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
			takeIt();
			while(isDigit(currentChar)){
				takeIt();
			}
			return Token.INTLITERAL;
		case 'a':case 'b':case 'c':case 'd':	
		case 'e':case 'f':case 'g':case 'h':
		case 'i':case 'j':case 'k':case 'l':
		case 'm':case 'n':case 'o':case 'p':
		case 'q':case 'r':case 's':case 't':
		case 'u':case 'v':case 'x':case 'y':
		case 'z':
			takeIt();
			while(isLetter(currentChar) || isDigit(currentChar)){
				takeIt();
			}
			return Token.IDENTIFIER;
		case '+':
			takeIt();
			return Token.ADDOP;
		case '*':
			takeIt();
			return Token.MULTI;
		case '/':
			takeIt();
			return Token.MULTI;
		case '-':
			takeIt();
			return Token.ADDOP;
		case '(':
			takeIt();
			return Token.LPAREN;
		case ')':
			takeIt();
			return Token.RPAREN;
		case '=':
			takeIt();
			return Token.BECOMES;
		case ';':
			takeIt();
			return Token.SEMICOLON;
		case '\000':
			return Token.EOT;
		default:
			System.out.print("Got no valid input");
		
		}
		return 0;
	}
	
	private void takeIt(){
		currentSpelling.append(currentChar);
		 next();
	}
	
	
	
	private boolean isDigit(char d){
		if(Character.isDigit(d)){		
			return true;
		} else {
			return false;
		}
		
	}
	
	private boolean isLetter(char d){
		if(Character.isLetter(d)){
			return true;
		} else {
			return false;
		}
	}
	
	private void next(){
		count++;
		currentChar = source.charAt(count);
		
	}
	
}
