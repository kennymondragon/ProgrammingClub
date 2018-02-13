//package cardgame;
/*
 * created by Brandon Ly, May 4th
 * 
 * where the table itself is generated
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
	
	private final int T_WIDTH = 350;
	private final int T_HEIGHT = 350;
	private final int INITIAL_X = -40;
	private final int INITIAL_Y = -40;
	private final int DELAY = 25;

	private Image table;
	private Timer timer;
	private int x, y;
	
	public Board() {
		
		initBoard();
		
	}
	
	private void initBoard() {
		
		loadImage();
		
		x = INITIAL_X;
		y = INITIAL_Y;

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(T_WIDTH, T_HEIGHT));
        setDoubleBuffered(true);

		
        timer = new Timer(DELAY, this);
        timer.start();
	}
	
	private void loadImage(){
		
		ImageIcon ii = new ImageIcon("kingofhearts.jpg");
		table = ii.getImage();
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		g.drawImage(table, 0, 0, null);
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	       x += 1;
	       y += 1;

	        if (y > T_HEIGHT) {

	            y = INITIAL_Y;
	            x = INITIAL_X;
	        }

	        repaint();
	 }

		
	
}
