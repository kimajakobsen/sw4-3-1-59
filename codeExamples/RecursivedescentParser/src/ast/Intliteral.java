package ast;
import parser.*;
import printer.Tab;
public class Intliteral extends PrimaryExpression {
	public Token T;
	public Intliteral (Token T){
		this.T  = T;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t+ "Integer Literal");
		T.print(indent+1);
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		return v.visitIntLiteral(this, arg);
		
	}
}
