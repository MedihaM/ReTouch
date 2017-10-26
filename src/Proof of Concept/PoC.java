import java.util.Scanner;
import java.io.IOException;

public class PoC {

	static Scanner keyboard = new Scanner(System.in);

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
	
	public static void type(char x) throws IOException {

		System.out.println("Type " + x);
		while (true){
			if ((char) System.in.read() == x){
				break;
			}
		}	
	}

}
