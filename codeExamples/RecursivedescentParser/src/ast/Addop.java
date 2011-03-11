package ast;
import parser.*;
import printer.Tab;
public class Addop extends AST{
	public Token T;
	
	public Addop(Token T){
		this.T = T;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t + "Add Operator");
		T.print(indent+1);
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		return v.visitAddop(this, arg);
	
		
	}
	
}
