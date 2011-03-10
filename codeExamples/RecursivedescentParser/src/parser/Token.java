package parser;

import printer.Tab;

public class Token {

	public byte kind;
	public String spelling;
	
	public Token(byte kind, String spelling){
		this.kind = kind;
		this.spelling = spelling;
		if(kind == IDENTIFIER){
			for (int k = ADDOP; k<= MULTI; k++ ){
				//if(spelling)
			}
			// Should make
		}
		
	}
	
	public final static byte 
		IDENTIFIER = 0, INTLITERAL = 1, ADDOP =2, MULTI = 3, LPAREN = 4, RPAREN = 5,BECOMES=6,SEMICOLON=7,COLON=8, EOT = 9;
	
	private final static String[] spellings = {
		"identifier", "integer-literal","+-", "*/" , "(", ")","=",";",":", "EOT"
		
	};
	
	public void print(int indent){
		Tab t = new Tab(indent);
		System.out.println(t + spelling);
	}
	
}
