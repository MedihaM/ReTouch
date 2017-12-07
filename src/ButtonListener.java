import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;

/**
 * The Button Listener page sets the functionality of buttons pressed to start a
 * new lesson or change the current lesson.
 * <p>
 * Major Revision History:
 * <p>
 * 2017-11-27 Buttons created and functioning
 * <p>
 * 2017-11-29 Buttons formatted properly
 * 
 * @author Abrar Attia
 * @version 2.0
 * @since 2017-11-27
 *
 */
public class ButtonListener implements ActionListener {
	// The current page
	JFrame caller = null;

	/**
	 * This method sets the current frame/page opened.
	 * 
	 * @param caller
	 *            The currently displayed frame
	 */
	public ButtonListener(JFrame caller) {
		this.caller = caller;
	}

	/**
	 * This method determines the actions that should be performed when a button
	 * is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// THe button command
		String cmd = e.getActionCommand();

		// The actions for the button on the lesson page or on the results page
		if (cmd.equals("back") || cmd.equals("restart")) {
			// Resets all the set variables that affect the current lesson
			caller.dispose();
			UserInput.currentCharacter[0] = 0;
			UserInput.currentCharacter[1] = 0;
			UserInput.correctCharacters = 0;
			UserInput.incorrectCharacters = 0;
			// Resets the timer
			Scheduler.elapsedTime = 0;
			Scheduler.endTimer();
			Scheduler.timer = new Timer(true);

			for (int i = 0; i < 8; i++) {
				Parser.stringArr[i] = null;
			}
			UserInput.firstIncorrectChar = -1;

			// new SelectionPage();
			new SelectionPage().setVisible(true);
			// new Lesson();

		}
	}

}
