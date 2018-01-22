package cardgame;
// updated by Brandon Ly April 30th
/*
 * this needs to be a part of the main blackjack game but I will
 * work out a test implementation before moving it over for the actual game
 * currently a bunch of test junk, don't bother with this class
 */


import javax.swing.JPanel;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class graphics extends JPanel implements Runnable, MouseListener, MouseMotionListener{
	


	public graphics() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
		setFocusable(true);  //makes sure listeners are working correctly
		addMouseListener(this);
		addMouseMotionListener(this);
		
	
		
		start();
	}
	
	//poker table dimensions
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	//game loop fields
	private Thread thread;
	private int FPS = 30;
	private long targetTime = 1000 / FPS; // target we want for each cycle of game; how long we want to wait between execution
	private boolean isRunning = false; 
	
	//mouse position relative to window
	public static int MouseX, MouseY;
	private int x = 0;
	
	public void update(){
		x++;
		
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		//makes images look sharp
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.clearRect(0, 0, WIDTH, HEIGHT);
		
		//g2d.drawRect(x , 25, 50, 50);
		
		g2d.dispose(); // disposes of junk after update
		
	}
	

	public void mouseDragged(MouseEvent e) {
		setMousePosition(e);
	}
	
	public void mouseMoved(MouseEvent e) {
		setMousePosition(e);
	}
	
	public void mouseClicked(MouseEvent e) {
		//for debugged and testing
		System.out.println("Mouse clicked");
	}
	/*
	 * used to set mouse position based on where play has mouse currently placed
	 * called in other functions to grab position whenever used
	 */
	private void setMousePosition(MouseEvent e){
		MouseX = e.getX();
		MouseY = e.getY();
		
		//this is printing out mouse positioning to check if it works and for debugging in the future
		System.out.println(MouseX + " " + MouseY);
	}
	
	private void start(){
		isRunning = true;
		thread = new Thread(this, "game loop");
		thread.start(); // calls run method
	}
	
	private void stop(){
		isRunning = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // terminates the thread
	}
	// game loop
	public void run() {
		long start, elapsed, wait;
		
		while(isRunning) {
			start = System.currentTimeMillis();
			
			update();
			repaint(); // calls paint component method
			
			elapsed = System.currentTimeMillis() - start;
			wait = targetTime - elapsed; // if we execute faster than target time we wait
			if(wait < 5) { wait = 5; } // gives program time to redraw everything
			try {
				Thread.sleep(wait); // stops thread to give time to redraw everything
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		stop(); // calls stop in case if it jumps out of while loop and thread has not ended
	}

	
	public static void main(String[] args){
	
		
		   JFrame frame = new JFrame("Poker");
			    
		   frame.add(new graphics());
		   frame.setSize(300, 300);
		   frame.setVisible(true);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.add(new graphics(), BorderLayout.CENTER);
		   frame.pack();
	
	
	 
	}



	/*
	 * these are most likely not going to be used any time soon (or at all)
	 * these methods do need to be here though as they are a part of the mouselistener and mousemotionlistener implementations
	 * and you will get errors if you delete them or comment them out 
	 * 
	 */
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	

}

/*
 * 	/*String path = "weinersack.jpg";
				BufferedImage img;
				img = ImageIO.read(new File(path));
				JLabel label = new JLabel(new ImageIcon(img));
				
			    JFrame frame = new JFrame("Poker");
				frame.add(new graphics());
				frame.getContentPane().add(label);
				frame.setSize(300, 300);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new graphics(), BorderLayout.CENTER);
				frame.pack();
		
				String path = "weinersack.jpg";
		        BufferedImage image = ImageIO.read(new File(path));
		        JLabel label = new JLabel(new ImageIcon(image));
		        JFrame f = new JFrame();
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        f.getContentPane().add(label);
		        f.pack();
		        f.setLocation(200,200);
		        f.setVisible(true);
*/