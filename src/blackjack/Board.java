/*
 * created by Brandon Ly, May 4th
 * 
 * where the table itself is generated
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	
	
	private Image table;
	
	public Board() {
		
		initBoard();
		
	}
	
	private void initBoard() {
		
		loadImage();
		
		int w = table.getWidth(this);
		int h = table.getHeight(this);
		setPreferredSize(new Dimension(w,h));
		
	}
	
	private void loadImage(){
		
		ImageIcon ii = new ImageIcon("pokertable.jpg");
		table = ii.getImage();
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		g.drawImage(table, 0, 0, null);
	}
}
