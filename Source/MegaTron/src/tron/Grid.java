package tron;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Grid  extends JPanel implements Drawable {

	public Cell[][] cells;
	private int x = 30;
	private int y = 30;


	public Grid(){
		
		cells = new Cell[x][y];

		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++){
				cells[i][j] = new Cell();
			}
		}
		this.setPreferredSize(new Dimension(x * Cell.width,y * Cell.height));
		repaint();
	}

	@Override
	public void draw() {
		
		// TODO Auto-generated method stub




	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(2,2,2,2);
		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++){
				cells[i][j].setColor(Color.black);
				g.setColor(Color.black);
				g.drawRect(j * Cell.width, i * Cell.height, Cell.width, Cell.height);
			}
		}
	
		
	}

	public void setGridColor(int posX, int posY, Color c){
		cells[posX][posY].setColor(c);
		repaint();

	}


}

