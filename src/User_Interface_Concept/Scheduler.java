
/**
 * Based implementation based off of the code that was found at
 * https://www.journaldev.com/1050/java-timer-timertask-example
 * by Pankaj.
 */

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler extends TimerTask {

	int elapsedTime = 0;
	static Timer timer = new Timer(true);
	
	@Override
	public void run() {
		completeTask();
	}

	/*
	 * Increases elapsed time by one every second.
	 */
	private void completeTask() {
		elapsedTime++;
		System.out.println("                                        " + elapsedTime);
	}
	
	public static void endTimer(){
		timer.cancel();
	}

	public static void runTimer() {
		TimerTask timerTask = new Scheduler();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		System.out.println("Timer started");
	}

}