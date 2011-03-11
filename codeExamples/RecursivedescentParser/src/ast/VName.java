package ast;

import parser.IVisitor;
import parser.Token;
import printer.Tab;

public class VName extends AST {

	public Token T;
	
	public VName (Token T){
		this.T  = T;
	}

	@Override
	public void print(int indent) {
		Tab t = new Tab(indent++);
		System.out.println(t + "VName");
		T.print(indent+1);
		
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		return v.visitVName(this, arg);
		
	}
	
}
