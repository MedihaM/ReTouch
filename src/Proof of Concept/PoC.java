import java.util.Scanner;

public class PoC {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		Scheduler.runTimer();

		type("Hello");
		type("how");
		type("are");
		type("you");
		type("doing");

	}
	
	public static void type(String x){
		System.out.println("Type " + x);
		while (true){
			if (keyboard.nextLine().equals(x)){
				break;
			}
		}	
	}

}
