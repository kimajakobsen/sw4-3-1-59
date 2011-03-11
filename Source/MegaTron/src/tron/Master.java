package tron;



import java.awt.Color;

import javax.swing.JFrame;

public class Master {

	public static Grid grid; 
	
	public static void main(String[] args){
		 JFrame window = new JFrame("Thinking Box");
	     grid = new Grid();
	     //TBMPanel content = new TBMPanel();
	     window.setContentPane(grid);
	      window.pack();  // Set size of window to preferred size of its contents.
	      window.setResizable(true);  // User can't change the window's size.
	      window.setLocation(100,100);
	      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      window.setVisible(true);
		
		//grid = new Grid();
		System.out.println("dhhdd");
	}
	
	void RedTron(){
		
		
	}
	
	
	void setGridColor(int posX, int posY, Color c){
		grid.setGridColor(posX,posY,c);
		
	}
}
