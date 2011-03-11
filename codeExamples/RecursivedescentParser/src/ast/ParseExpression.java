package ast;

import parser.IVisitor;
import printer.Tab;

public class ParseExpression extends PrimaryExpression {
	public Expression E;
	
	public ParseExpression (Expression E){
		this.E = E;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t+ "ParseExpression");
		E.print(indent+1);
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		return v.visitParseExpression(this, arg);
		
	}
}
