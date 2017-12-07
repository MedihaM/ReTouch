
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Scheduler class runs a timer as a user completes a lesson, and calculates
 * as well as displays the accuracy, speed, and time on the screen.
 * 
 * <p>
 * elapsedTime is a state variable that keeps track of the amount of time that
 * has passed in a lesson.
 * 
 * <p>
 * Major Revision History:
 * <p>
 * 2017-11-02 Works for proof of concept
 * <p>
 * 2017-11-06 Adjusted formulas and methods
 * 
 * 
 * @author Mediha Munimm
 * @version 2.0
 * @since 2017-11-02
 */
public class Scheduler extends TimerTask {

	static int elapsedTime = 0;
	static Timer timer = new Timer(true);

	/**
	 * This method runs the completeTask method which increases the elapsed
	 * time.
	 */
	@Override
	public void run() {
		completeTask();
	}

	/**
	 * This method increases the elapsed time by one every second.
	 */
	private void completeTask() {
		elapsedTime++;
	}

	/**
	 * This method ends the timer.
	 */
	public static void endTimer() {
		timer.cancel();
	}

	/**
	 * This method starts the timer.
	 */
	public static void runTimer() {
		TimerTask timerTask = new Scheduler();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}

	/**
	 * This method displays the user's lesson/typing information.
	 * 
	 * @param g
	 *            A graphics object
	 * @throws IOException
	 *             On input error.
	 */
	public static void displayTimer(Graphics g) throws IOException {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Default", Font.BOLD, 30));
		g.drawString("Elapsed time: " + Integer.toString(elapsedTime) + "s", 30, 30);
		g.drawString("Accuracy: " + Integer.toString(accuracy()) + "%", 20 + Lesson.width / 3, 30);
		g.drawString("Characters/Minute: " + Integer.toString(counter()), 2 * Lesson.width / 3 - 30, 30);
	}

	/**
	 * This method calculates and returns the (correctly typed) characters per
	 * second.
	 * 
	 * @return int The user's typing speed in characters per minute.
	 */
	public static int counter() {
		int cpm = UserInput.correctCharacters * 60 / elapsedTime;
		return cpm;
	}

	/**
	 * This method calculates and returns the user's typing accuracy.
	 * 
	 * @return int The user's typing accuracy as a percent.
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