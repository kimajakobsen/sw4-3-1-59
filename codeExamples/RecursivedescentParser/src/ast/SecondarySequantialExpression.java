package ast;
import parser.*;
import printer.Tab;
public class SecondarySequantialExpression extends SecondaryExpression {
	
	public SecondaryExpression S;
	public Multiop O;
	public PrimaryExpression P;
	
	public SecondarySequantialExpression(SecondaryExpression S, Multiop O, PrimaryExpression P){
		this.S = S;
		this.O = O;
		this.P = P;
	}
	
	public void print(int indent){
		Tab t = new Tab(indent++);
		System.out.println(t + " Sequantial Secondary Expression");
		S.print(indent+1);
		O.print(indent+1);
		P.print(indent+1);
	}

	@Override
	public Object visit(IVisitor v, Object arg) {
		
		return v.visitSecondarySequentialExpression(this, arg);
	}
}
