package ast;
import parser.*;
import printer.Tab;
import types.Type;
public class Identifier extends PrimaryExpression {
	public Token T;
	public Type type;
	
	public Identifier (Token T){
		this.T  = T;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t + "Identifier");
		T.print(indent+1);
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		// TODO Auto-generated method stub
		return v.visitIdentifier(this, arg);
	}
	
	public AST decl;
}
