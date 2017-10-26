/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

	/*
	 * Increases elapsed time by one every second.
	 */
	private void completeTask() {
		elapsedTime++;
		//System.out.println(elapsedTime);
	}
	
	public static void endTimer(){
		timer.cancel();
	}

	public static void runTimer() {
		TimerTask timerTask = new Scheduler();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		System.out.println("Timer started");
	}
	public static int getTime(){
		return elapsedTime;
	}

}
