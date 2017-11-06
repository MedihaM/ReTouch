import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

/**
 * Based implementation based off of the code that was found at
 * https://www.journaldev.com/1050/java-timer-timertask-example
 * by Pankaj.-
 */

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler extends TimerTask {

	static int elapsedTime = 0;
	static Timer timer = new Timer(true);

	@Override
	public void run() {
		completeTask();
	}

	/**
	 * Increases elapsed time by one every second.
	 */
	private void completeTask() {
		elapsedTime++;
	}

	/**
	 * Ends the timer
	 */
	public static void endTimer() {
		timer.cancel();
	}

	/**
	 * Starts the timer
	 */
	public static void runTimer() {
		TimerTask timerTask = new Scheduler();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}

	/**
	 * Displays the user's lesson/typing information
	 * 
	 * @param g
	 * @throws IOException
	 */
	public static void displayTimer(Graphics g) throws IOException {
		g.setColor(Color.GRAY);
		g.setFont(new Font("Calibri", Font.BOLD, 35));
		g.drawString("Elapsed time: " + Integer.toString(elapsedTime) + "s", 30, 30);
		g.drawString("Accuracy: " + Integer.toString(accuracy()) + "%", 20 + Lesson.width / 3, 30);
		g.drawString("Characters/Minute: " + Integer.toString(counter()), 2 * Lesson.width / 3, 30);
	}

	/**
	 * Calculates and returns the (correctly typed) characters per second
	 * 
	 * @param c
	 * @param t
	 * @return the user's typing speed in characters per minute
	 */
	public static int counter() {
		int cpm = UserInput.correctCharacters * 60 / elapsedTime;
		return cpm;
	}

	/**
	 * Calculates and returns the user's typing accuracy
	 * 
	 * @return
	 */
	public static int accuracy() {
		if (UserInput.correctCharacters + UserInput.incorrectCharacters > 0) {
			int result = (UserInput.correctCharacters * 100)
					/ (UserInput.correctCharacters + UserInput.incorrectCharacters);
			return result;
		} else {
			return 0;
		}
	}

}
