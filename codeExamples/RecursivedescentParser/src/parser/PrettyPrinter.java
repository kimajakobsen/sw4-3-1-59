package parser;

import types.IdentificationTable;
import ast.Addop;
import ast.Declaration;
import ast.Identifier;
import ast.Intliteral;
import ast.Multiop;
import ast.ParseExpression;
import ast.Program;
import ast.SecondarySequantialExpression;
import ast.SecondarySingleExpression;
import ast.SequantialExpression;
import ast.SequantialStatement;
import ast.SingleExpression;
import ast.SingleStatement;
import ast.VName;

public class PrettyPrinter implements IVisitor {

	public IdentificationTable idTable;
	
	private void p(String s){
		System.out.print(s);
	}
	private void pln(String s){
		System.out.println(s);
	}
	
	
	public void check(Program prog){
		idTable = new IdentificationTable();
		prog.visit(this, null);
		
		//idTable.print();
	}
	
	//@Override
	//public Object visitProgram(Program prog, Object arg) {
		// TODO Auto-generated method stub
	//	return null;
	//}

	@Override
	public Object visitSequantialStatement(SequantialStatement stm, Object arg) {
		
		// TODO Auto-generated method stub
		stm.P.visit(this, arg);
		pln(";");
		stm.D.visit(this, arg);
		p(";");
		return null;
	}

	@Override
	public Object visitSingleStatement(SingleStatement singleStatement,	Object arg) {
	
		singleStatement.D.visit(this, arg);
		//pln(";");
		return null;
	}

	@Override
	public Object visitDeclaration(Declaration declaration, Object arg) {
		
		Token a = (Token)declaration.V.visit(this, arg);
		p(" = ");
		declaration.E.visit(this, arg);
		
		idTable.enter(a.spelling, declaration);
		
		return null;
	}

	@Override
	public Object visitSequantialExpression(SequantialExpression se, Object arg) {
		
		se.E.visit(this, arg);
		se.O.visit(this, arg);
		se.V.visit(this,arg);
		
		return null;
	}

	@Override
	public Object visitIdentifier(Identifier identifier, Object arg) {
		//if(idTable.recieve(identifier.T.spelling) != null){
		//	System.out.println("Error identifier not declared");
	//	} else {
			
	//	}
		
		p(identifier.T.spelling);
		if(idTable.recieve(identifier.T.spelling) == null){
			System.out.println("Identifier " + identifier.T.spelling + " was not declared");
			return null;
		}
		return identifier.T;
		//return identifier.T; // identifier.T;
	}

	@Override
	public Object visitSingleExpression(SingleExpression se, Object arg) {
		se.E.visit(this, arg);
		return null;
	}

	@Override
	public Object visitIntLiteral(Intliteral il, Object arg) {
		
		p(il.T.spelling);
		
		return null;
	}

	@Override
	public Object visitMultiop(Multiop mo, Object arg) {
		p(" " + mo.T.spelling + " ");
		return null;
	}

	@Override
	public Object visitParseExpression(ParseExpression pe, Object arg) {
		p("(");
		pe.E.visit(this, arg);
		p(")");
		return null;
	}

	
	

	@Override
	public Object visitSecondarySequentialExpression(
		SecondarySequantialExpression see, Object arg) {
		see.P.visit(this, arg);
		see.O.visit(this, arg);
		see.S.visit(this, arg);
		return null;
	}

	@Override
	public Object visitSecondarySingleExpression(SecondarySingleExpression sse,
			Object arg) {
		sse.P.visit(this, arg);
		return null;
	}

	@Override
	public Object visitVName(VName v, Object arg) {
		p(v.T.spelling);
		return v.T;
	}

	@Override
	public Object visitAddop(Addop op, Object arg) {
		p(" " + op.T.spelling + " ");
		return null;
	}

}
