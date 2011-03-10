package types;

import java.util.ArrayList;
import java.util.HashMap;

import ast.Declaration;

public class IdentificationTable {
	
	public HashMap<String, Declaration> table;
	
	private ArrayList<String> s;
	
	public IdentificationTable(){
		table = new HashMap<String, Declaration>();
		s = new ArrayList<String>();
	}
	
	public void enter(String id,Declaration attr ){
		
		table.put(id, attr);
		s.add(id);
	}
	
	public Declaration recieve(String id){
		return table.get(id);
	}

	public void print() {
		System.out.println();
		for (String se :  s){
			System.out.println(se);
			table.get(se).print(0);
		}
		
	}
}
