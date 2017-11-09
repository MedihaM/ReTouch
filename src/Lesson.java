/**
 * 
 * Based off of https://www.youtube.com/watch?v=I3usNR8JrEE
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Lesson extends JPanel implements ActionListener {

	static int width = 1200, height = 800;

	// Timer is the GUI version of sleep
	Timer timer = new Timer(5, this); // this refers to actionlistener, 5 ms

	/**
	 * Draws the graphics on screen
	 * 
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		
		// Create rectangle for background
		g.setColor(Color.WHITE);
		g2.finalize();
		g.fillRect(0, 0, width, height);

		try {
			// Display characters
			DisplayCharacters.displayCharacters(g);
			DisplayCharacters.displayCurrentCharacter(g);

			// Show timer
			Scheduler.displayTimer(g);
		} catch (IOException e) {
			e.printStackTrace();
		}

		timer.start(); // start the timer, and then actionlistener

	}

	/**
	 * Describes what needs to change each frame
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint(); // repaints every 5ms
	}

	/**
	 * Creates the graphical user interface
	 */
	public static void makeJFrame() {
		Lesson t = new Lesson();
		JFrame jf = new JFrame();

		// Accept keyboard input
		UserInput.keyboardInput(jf);

		// Create the screen
		jf.setSize(Lesson.width, Lesson.height);
		jf.setTitle("ReTouch");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		jf.setVisible(true);

	}

	/**
	 * Create the JFrame and start the program
	 * 
	 * @throws IOException
	 * 
	 */
        /*
	public static void main(String[] args) throws IOException {
		UserInput.setUp();
		Scheduler.runTimer();
		makeJFrame();
	}*/
}
