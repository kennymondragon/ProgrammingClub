/*
 * created by Brandon Ly, May 4th
 * 
 * entry point of game
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {
	
	public Application(){
		initUI();
	}
	
	private void initUI(){
		add(new Board());
		
		setSize(250,200);
		
		setTitle("Poker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }
}
