package ast;

import parser.IVisitor;

abstract public class AST {

	public abstract void print(int indent);




	public abstract Object visit(IVisitor v, Object arg);

}

