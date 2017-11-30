/**
 * 
 * Based off of https://www.youtube.com/watch?v=I3usNR8JrEE
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The Lesson class constructs the UI page that displays the lesson characters and accepts user input.
 * @author Mediha Munimm
 * @version 1.0
 * @since 2017-11-06
 *
 */
 @SuppressWarnings("serial")
public class Lesson extends JPanel implements ActionListener {
	 
	// Button for trying a different lesson
	private static JButton newL = new JButton("Try a Different Lesson");
	
	// Dimensions of the page
	static int width = 1200, height = 800;

	// Timer is the GUI version of sleep
	Timer timer = new Timer(5, this); // this refers to actionlistener, 5 ms

	/**
	 * This method draws the graphics on the screen.
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Image img1 = Toolkit.getDefaultToolkit().getImage("img/BG.jpg");
		g2.drawImage(img1, -5, 0, null);

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
	 * This method describes what needs to change each frame.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint(); // repaints every 5ms
	}

	/**
	 * This method creates the graphical user interface.
	 */
	public static void makeJFrame() {
		Lesson t = new Lesson();
		JFrame jf = new JFrame();
		jf.setName("lesson");
		// Panel on page with button
		JPanel panel = new JPanel();
		newL.setPreferredSize(new Dimension(265, 50));
		newL.setFont(new Font("Default", Font.PLAIN, 16));
		newL.setName("newL");
		panel.add(newL);
		
		// Accept keyboard input
		UserInput.keyboardInput(jf);

		// Create the screen
		jf.setSize(Lesson.width, Lesson.height);
		jf.setTitle("ReTouch");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t, BorderLayout.CENTER);
		// Button position and function
		newL.addActionListener(new ButtonListener(jf));
		newL.setActionCommand("back");
		newL.setFocusable(false);
		jf.add(panel, BorderLayout.SOUTH);
		jf.setVisible(true);

	}
	

}
