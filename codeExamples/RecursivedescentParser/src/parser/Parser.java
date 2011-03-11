package parser;
import ast.*;
public class Parser {

	private Token currentToken;
	private boolean valid = true; 
	private Scanner scanner;
	
	public Parser(StringBuffer s){
		scanner = new Scanner(s);
	}
	
	private Expression parseExpression(){
	//	System.out.println("Exprerssion");
		
		SecondaryExpression E = parseSecundaryExpression();
		Expression V = new SingleExpression(E);
		while(currentToken.kind == Token.ADDOP){
			Addop op = parseAdd();
			E  = parseSecundaryExpression();
			V = new SequantialExpression(E , op , V);
			
		}
		return V;
	}
	
	private SecondaryExpression parseSecundaryExpression(){
	//	System.out.println("Secundary");
		PrimaryExpression E = parsePrimaryExpression();
		SecondaryExpression V = new SecondarySingleExpression(E);
		while(currentToken.kind == Token.MULTI){
			Multiop op = parseMulti();
			E = parsePrimaryExpression();
			V = new SecondarySequantialExpression(V, op, E);
		}
		
		return V;
	}
	
	private Multiop parseMulti(){
		Multiop op;
		op = new Multiop(currentToken);
	//	System.out.println("Multi operator");
		if(currentToken.kind == Token.MULTI){
			
			currentToken = scanner.scan();
		} else {
			
			System.out.println("Expected '*' or '/'. Got: " + currentToken.spelling);
			valid = false;
		}
		
		return op;
	}
	
	private Addop parseAdd(){
		Addop op = new Addop(currentToken);
	//	System.out.println("Add operator");
		if(currentToken.kind == Token.ADDOP){
			currentToken = scanner.scan();
		} else {
			System.out.println("Expected '+' or '-'. Got: " + currentToken.spelling);
			valid = false;
		}
		return op;
	}
	
	private PrimaryExpression parsePrimaryExpression(){
		PrimaryExpression P;
		//System.out.println("Primary");
		switch(currentToken.kind){
		case Token.IDENTIFIER:
			P = parseIdentifier();
			break;
		case Token.LPAREN:
			acceptIt();
			P = new ParseExpression( parseExpression());
			accept(Token.RPAREN);
			break;
		case Token.INTLITERAL:
			P = parseNumeral();
			break;
		default:
			System.out.println("Expected integer, '(' or identifier. Got " + currentToken.spelling);
			valid = false;
			P = null;
		}
		return P;
	}
	
	
	private PrimaryExpression parseNumeral(){
		PrimaryExpression P = new Intliteral(currentToken);
		//System.out.println("Nummeral");
		if(currentToken.kind == Token.INTLITERAL){
			currentToken = scanner.scan();
		} else {
			System.out.println("Excepted integer got " + currentToken.spelling);
			valid = false;
		}
		return P;
	}
	
	private Identifier parseIdentifier(){
		Identifier P = new Identifier(currentToken);
		//System.out.println("Identifier");
		if(currentToken.kind == Token.IDENTIFIER){
			currentToken = scanner.scan();
		} else {
			System.out.println("Excepted identifier. Got: " + currentToken.spelling);
			valid = false;
		}
		return P;
	}
	
	private VName parseVName(){
		VName P = new VName(currentToken);
		//System.out.println("Identifier");
		if(currentToken.kind == Token.IDENTIFIER){
			currentToken = scanner.scan();
		} else {
			System.out.println("Excepted identifier. Got: " + currentToken.spelling);
			valid = false;
		}
		return P;
	}
	
	private void acceptIt(){
		currentToken = scanner.scan();
	}
	
	private void accept(byte expkind){
		if(currentToken.kind == expkind){
			currentToken = scanner.scan();
		} else {
			System.out.println("Expected Something not. Got: " + currentToken.spelling);
			valid = false;
		}
			
	}
	
	private Declaration parseDeclaration(){
		VName i = parseVName();
		accept(Token.BECOMES);
		Expression E = parseExpression();
		
		/*
		//SecondaryExpression V = new SecondarySingleExpression(E);
		while(currentToken.kind == Token.MULTI){
			Multiop op = parseMulti();
			E = parsePrimaryExpression();
			V = new SecondarySequantialExpression(V, op, E);
		}
		Declaraton d = 
		*/
		return new Declaration(i,E);
	}
	
	
	private Statement parseStatement(){
		
		
		Declaration D = parseDeclaration();
		
		//Expression V = null; new SingleExpression(E);
		Statement P = new SingleStatement(D);
		accept(Token.SEMICOLON);
		
		while(currentToken.kind != Token.EOT){
				D = parseDeclaration();
				P = new SequantialStatement(P, D);
				accept(Token.SEMICOLON);
		}
		//accept(Token.SEMICOLON);
		return P;
		
	}
	
	public Program parseProgram(){
		
		return parseStatement();
	}
	
	public AST parse (){
		currentToken = scanner.scan();
		
		AST ast = parseProgram();
		if(currentToken.kind != Token.EOT){
			System.out.println("Never reached end of file");
			valid = false;
		}
		
		if(valid){
			System.out.println("File systax is valid");
		} else {
			System.out.println("Error occered");
		}
		return ast;
	}

}
