package ast;

import types.Type;

abstract public class Expression extends AST{
	//public Expression E;
	public abstract void print(int indent);
	
	public Type type;
}
