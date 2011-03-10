package ast;

import parser.IVisitor;
import printer.Tab;

public class SequantialStatement extends Statement{

	@Override
	public void print(int indent) {
		
		Tab t = new Tab(indent++);
		System.out.println(t+ "Sequantial Statement");
		D.print(indent+1);
		P.print(indent+1);
		
	}
	public Statement P;
	public Declaration D;
	
	
	public SequantialStatement(Statement p, Declaration d){
		D = d;
		P = p;
	}
	
	public Object visit(IVisitor v, Object arg){
		return v.visitSequantialStatement(this, arg);
	}
}
