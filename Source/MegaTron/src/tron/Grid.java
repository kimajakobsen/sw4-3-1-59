package tron;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Grid  extends JPanel implements Drawable {

	public Cell[][] cells;

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		cells = new Cell[30][30]();
	}

	public void setGridColor(int posX, int posY, Color c){



	}


}

}
