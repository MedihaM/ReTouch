import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class makeResults extends JPanel {
	
	  static int width = 1200, height = 800;
		
		public static void makeR() {
			makeResults mr = new makeResults();
			JFrame jf2 = new JFrame();

			// Create the screen
			jf2.setSize(makeResults.width, makeResults.height);
			jf2.setTitle("ReTouch Lesson Results");
			
			JPanel panel = new JPanel();
			JLabel jlabel = new JLabel("CONGRATULATIONS! You have completed the lesson! Here are your results:");
			jlabel.setFont(new Font("Serif", Font.PLAIN, 14));
			panel.add(jlabel);
			jf2.add(panel);
			
			jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf2.add(mr);
			jf2.setVisible(true);
	    }
	  
	    /**
		 * Draws the graphics on screen
		 * 
		 */
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			// Create rectangle for background
			g2.setColor(Color.WHITE);
			g2.finalize();
			g.fillRect(0, 0, width, height);
			
			g2.setColor(Color.BLACK);
			
			g2.setFont(new Font("Arial", Font.PLAIN, 24)); 
			g2.drawString("CONGRATULATIONS! You have completed the lesson! Here are your results:", 60, 60);
			
			g.drawString("Elapsed time: " + Integer.toString(Scheduler.elapsedTime) + "s", 150, 150);
			g.drawString("Accuracy: " + Integer.toString(Scheduler.accuracy()) + "%", 20 + Lesson.width / 3, 150);
			g.drawString("Characters/Minute: " + Integer.toString(Scheduler.counter()), 2 * Lesson.width / 3 - 30, 150);
		}

}