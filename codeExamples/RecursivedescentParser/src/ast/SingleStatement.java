package ast;

import parser.IVisitor;
import printer.Tab;

public class SingleStatement extends Statement{

	@Override
	 public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t+ "Statement");
		D.print(indent+1);
		
	}
	public Declaration D;
	
	public SingleStatement(Declaration d){
		D = d;
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		
		return v.visitSingleStatement(this, arg);
	}

}
