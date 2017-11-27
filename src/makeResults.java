import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The makeResults class constructs the UI page that displays the user's results of the selected lesson.
 * @author Abrar Attia
 * @version 1.0
 * @since 2017-11-09
 */
public class makeResults extends JPanel {
	
	// Button made to select a new lesson
	private static JButton restartL = new JButton("Try Another Lesson!");
	
	// Dimensions of the page
	  static int width = 1200, height = 800;
		
	  /**
	   * This method creates the graphical user interface.
	   */
		public static void makeR() {
			makeResults mr = new makeResults();
			JFrame jf2 = new JFrame();
			// Panel with button
			JPanel panel = new JPanel();
			panel.add(restartL);

			// Create the screen
			jf2.setSize(makeResults.width, makeResults.height);
			jf2.setTitle("ReTouch Lesson Results");
			
			jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf2.add(mr);
			// Button position and function
			restartL.addActionListener(new ButtonListener(jf2));
			restartL.setActionCommand("restart");
			jf2.add(panel, BorderLayout.SOUTH);
			jf2.setVisible(true);
	    }
	  
	    /**
		 * This method draws the graphics on screen and displays the results
		 */
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			// Create rectangle for background
			g2.setColor(Color.WHITE);
			g2.finalize();
			g.fillRect(0, 0, width, height);
			
			// Sets the properties of the text font
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("Arial", Font.PLAIN, 24)); 
			// Displays a message on the screen
			g2.drawString("CONGRATULATIONS! You have completed the lesson! Here are your results:", 60, 60);
			
			// Displays the users final results on the screen
			g.drawString("Elapsed time: " + Integer.toString(Scheduler.elapsedTime) + "s", 150, 150);
			g.drawString("Accuracy: " + Integer.toString(Scheduler.accuracy()) + "%", 20 + makeResults.width / 3, 150);
			g.drawString("Characters/Minute: " + Integer.toString(Scheduler.counter()), 2 * makeResults.width / 3 - 30, 150);
		}

}
