
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * The Results class allows the makeResults class to be called and assists in the creation of the final results page.
 * @author Abrar Attia
 * @version 1.0
 * @since 2017-11-09
 *
 */
public class Results extends JFrame implements ActionListener {
    
	/**
	 * Calls the makeReults method makeR which creates the final results UI page.
	 */
    public Results() {
    	makeResults.makeR();
    }
   
    /**
     * This method describes what needs to change each frame.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint(); // repaints every 5ms
		
	}

}
