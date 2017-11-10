import java.util.Scanner;
import java.io.IOException;

/**
 * The PoC program demonstrates the use of single character input in parallel with a constant running timer.
 * @author Mediha Munimm
 * @version 1.0
 * @since 2017-10-16
 *
 */
public class PoC {

	static Scanner keyboard = new Scanner(System.in);

	/**
	 * The main method starts a timer and calls the type function with multiple characters
	 * @param args Unused
	 * @throws InterruptedException On interruption error
	 * @throws IOException On input error
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		Scheduler.runTimer();

		String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
		Runtime.getRuntime().exec(cmd).waitFor();


		type('H');
		type('e');
		type('l');
		type('l');
		type('o');

		String[] cmd2 = {"/bin/sh", "-c", "stty cooked </dev/tty"};
		Runtime.getRuntime().exec(cmd2).waitFor();

	}
	
	/**
	 * This method prints a character and waits for user to type it
	 * @param x The character that is expected to be typed
	 * @throws IOException On input error
	 */
	public static void type(char x) throws IOException {

		System.out.println("Type " + x);
		while (true){
			if ((char) System.in.read() == x){
				break;
			}
		}	
	}

}
