import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;

public class ButtonListener implements ActionListener {
	JFrame caller = null;

	public ButtonListener(JFrame caller) {
		this.caller = caller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("back") || cmd.equals("restart")) {
			/**
			 * if (caller instanceof SelectionPage) { new Lesson(); }else { new
			 * SelectionPage(); }
			 **/
			caller.dispose();
			UserInput.currentCharacter[0] = 0;
			UserInput.currentCharacter[1] = 0;
			UserInput.correctCharacters = 0;
			UserInput.incorrectCharacters = 0;
			Scheduler.elapsedTime = 0;
			Scheduler.endTimer();
			Scheduler.timer = new Timer(true);
			// Parser.stringArr = new String[7];

			for (int i = 0; i < 8; i++) {
				Parser.stringArr[i] = null;
			}
			UserInput.firstIncorrectChar = -1;
			// SelectionPage.chosen = " ";
			new SelectionPage();
			new Lesson();

		}
	}
	
}