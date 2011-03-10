package ast;

import parser.IVisitor;
import printer.Tab;

public class SecondarySingleExpression extends SecondaryExpression {
	public PrimaryExpression P;
	
	public SecondarySingleExpression(PrimaryExpression P){
		this.P = P;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t + "Single Secondary Expression");
		P.print(indent+1);
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
	
		return v.visitSecondarySingleExpression(this, arg);
	}
}
