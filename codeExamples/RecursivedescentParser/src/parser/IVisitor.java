package parser;

import ast.*;

public interface IVisitor {
	//public Object visitProgram(Program prog, Object arg);
	public Object visitAddop(Addop op, Object arg);
	public Object visitSequantialStatement(SequantialStatement stm, Object arg);
	
	public Object visitSingleStatement(SingleStatement singleStatement,
			Object arg);
	
	public Object visitDeclaration(Declaration declaration, Object arg);
	
	public Object visitSequantialExpression(
			SequantialExpression sequantialExpression, Object arg);
	
	public Object visitIdentifier(Identifier identifier, Object arg);

	public Object visitSingleExpression(SingleExpression se, Object arg);
	
	public Object visitIntLiteral(Intliteral il, Object arg);
	
	public Object visitMultiop(Multiop mo, Object arg);
	
	public Object visitParseExpression(ParseExpression pe, Object arg);
	
	//public Object visitPrimaryExpression(PrimaryExpression pe, Object arg);
	
	//public Object visitSecondaryExpression(SecondaryExpression se, Object arg);
	
	
	public Object visitSecondarySequentialExpression(SecondarySequantialExpression see, Object arg);
	
	public Object visitSecondarySingleExpression(SecondarySingleExpression sse, Object arg);
	
	public Object visitVName(VName v, Object arg);
}
