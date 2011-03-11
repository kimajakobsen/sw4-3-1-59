package tron;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Grid  extends JPanel implements Drawable {

	public Cell[][] cells;
	private int x = 30;
	private int y = 30;


	public Grid(){
		cells = new Cell[x][y];

		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; i++){
				cells[i][j] = new Cell();
			}
		}
	}

	@Override
	public void draw() {
		
		// TODO Auto-generated method stub




	}

	public void setGridColor(int posX, int posY, Color c){
		cells[posX][posY].setColor(c);


	}


}

