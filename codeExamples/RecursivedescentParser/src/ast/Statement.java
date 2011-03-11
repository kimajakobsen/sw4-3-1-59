package ast;

import parser.IVisitor;

abstract public class Statement extends Program{


	public abstract void print(int indent);

	public abstract Object visit(IVisitor v, Object arg);
	
	
}
