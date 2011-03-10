package printer;

public class Tab {
	private StringBuffer s;
	public Tab(int i){
		s = new StringBuffer("");
		for(int k = 0; k < i; k++){
			s.append("\t");
		}
	}
	
	public String toString(){
		return s.toString();
	}
}
