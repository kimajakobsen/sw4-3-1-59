package ast;

import parser.IVisitor;
import printer.Tab;


public class SingleExpression extends Expression {
	public Expression E;
	public SingleExpression(Expression e2){
		this.E = e2;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t + "Single Expression");
		E.print(indent+1);
		
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		// TODO Auto-generated method stub
		return v.visitSingleExpression(this, arg);
	}
}