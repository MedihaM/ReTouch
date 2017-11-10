/**
 * Based implementation based off of the code that was found at
 * https://www.journaldev.com/1050/java-timer-timertask-example
 * by Pankaj.
 */

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class implements a timer
 * @author Mediha Munimm
 * @version 1.0
 * @since 2017-10-16
 */
public class Scheduler extends TimerTask {

	static int elapsedTime = 0;
	static Timer timer = new Timer(true);
	
	@Override
	/**
	 * This method runs the completeTask method
	 */
	public void run() {
		completeTask();
	}

	/**
	 * This method increases the elapsed time by one every second
	 */
	private void completeTask() {
		elapsedTime++;
		System.out.println(elapsedTime);
	}
	
	/**
	 * This method stops the timer
	 */
	public static void endTimer(){
		timer.cancel();
	}

	/**
	 * This method starts the timer
	 */
	public static void runTimer() {
		TimerTask timerTask = new Scheduler();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		System.out.println("Timer started");
	}
	
	/**
	 * This method returns the elapsed time
	 * @return The elapsed time
	 */
	public static int getTime(){
		return elapsedTime;
	}

}
