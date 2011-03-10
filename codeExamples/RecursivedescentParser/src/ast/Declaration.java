package ast;

import parser.IVisitor;
import printer.Tab;

public class Declaration extends Program {

	@Override
	public void print(int indent) {
		// TODO Auto-generated method stub
		Tab t = new Tab(indent++);
		System.out.println(t+ "Declaration");
		V.print(indent+1);
		E.print(indent+1);
	}
	
	public Expression E;
	public VName V;

	public Declaration(VName i, Expression e){
		E = e;
		V = i;
	}

	@Override
	public Object visit(IVisitor v, Object arg) {	
		return v.visitDeclaration(this, arg);
	}
	
}
