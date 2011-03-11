package ast;
import parser.*;
import printer.Tab;


public class Multiop extends AST{
	public Token T;
	
	public Multiop(Token T){
		this.T = T;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t + "MultiOperator");
		T.print(indent+1);
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		return v.visitMultiop(this, arg);
		
	}
}
