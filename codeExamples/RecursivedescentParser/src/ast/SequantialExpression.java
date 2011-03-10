package ast;

import parser.IVisitor;
import printer.Tab;

public class SequantialExpression extends Expression {
	
	public SecondaryExpression V;
	public Addop O;
	public Expression E;
	
	public SequantialExpression(SecondaryExpression V, Addop O, Expression E){
		this.E = E;
		this.V = V;
		this.O = O;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t + "Sequantial Expression");
		E.print(indent+1);
		O.print(indent+1);
		V.print(indent+1);
	
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		return v.visitSequantialExpression(this,arg);
	}
}
