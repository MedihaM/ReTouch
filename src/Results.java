import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * The Results class allows the makeResults class to be called and assists in
 * the creation of the final results page.
 * 
 * @author Abrar Attia
 * @version 1.0
 * @since 2017-11-09
 *
 */
@SuppressWarnings("serial")
public class Results extends JFrame implements ActionListener {

	/**
	 * Calls the makeReults method makeR which creates the final results UI
	 * page.
	 */
	public Results() {
		MakeResults.makeR();
	}

	/**
	 * This method describes what needs to change each frame.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint(); // repaints every 5ms

	}

}
