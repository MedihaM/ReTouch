/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author susan
 */
public class Speed_Accuracy {

    static Scanner keyboard = new Scanner(System.in);
	public static double characters;
        public static double correctCharacters;
        public static double incorrectCharacters;

	public static void main(String[] args) throws InterruptedException, IOException {
		Scheduler.runTimer();

		String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
		Runtime.getRuntime().exec(cmd).waitFor();

		characters = 0;
                correctCharacters = 0;
                incorrectCharacters = 0;

		type('H');
		type('e');
		type('l');
		type('l');
		type('o');

		String[] cmd2 = {"/bin/sh", "-c", "stty cooked </dev/tty"};
		Runtime.getRuntime().exec(cmd2).waitFor();

	}
	
	public static void type(char x) throws IOException {

		System.out.println("\n Type " + x);
		while (true){
			if ((char) System.in.read() == x){
			    characters += 1;
                            correctCharacters++;
				break;
			}
                        else{
                            incorrectCharacters++;
                        }
		}
                double charactersPerMinute = counter(characters, Scheduler.getTime()) * 60;
                double aR = accuracy(correctCharacters, incorrectCharacters);
                System.out.println("\n Characters per minute: " + charactersPerMinute);
                System.out.println("\n Accuracy: "  + aR + "%");
	}

	public static double counter(double c, int t){
	    double cpm = c / t;
	    return cpm;
        }
        
        public static double accuracy(double correct, double incorrect){
            double result = (correct / (correct + incorrect)) * 100;
            return result;
        }
    
}
