package parser;

import treedrawer.Drawer;
import ast.AST;
import ast.Program;

public class Compiler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer b = new StringBuffer("k = (3433303003 + 5555) * 10; a =     5    +  2  ; sdfsd=4                 *(a + 4) + (7); \000");
		//	Scanner scanner = new Scanner(b);
			Parser parser = new Parser(b);
			Program ast = (Program) parser.parse();
		//	ast.print(0);
			
			PrettyPrinter checker = new PrettyPrinter();
			checker.check(ast);
			//Token cur;
			
			Drawer d = new Drawer();
			
			d.draw(ast);
			
	}	
}
