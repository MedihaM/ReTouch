/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.IOException;
/**
 * This class demonstrates the accuracy and speed calculations of users input
 * @author susan
 * @version 1.0
 * @since 2017-10-23
 */
public class Speed_Accuracy {

    static Scanner keyboard = new Scanner(System.in);
	public static double characters;
    public static double correctCharacters;
    public static double incorrectCharacters;

    /**
     * The main method runs a timer while requesting for user input of certain characters. While also starting a counter
     * to track user accuracy and speed.
     * @param args Unused
     * @throws InterruptedException On interruption error
     * @throws IOException On input error
     */
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
	
	/**
	 * This method prints a character and waits for user to type it
	 * @param x The character that is expected to be typed
	 * @throws IOException On input error
	 */
	public static void type(char x) throws IOException {

		System.out.println("\n Type " + x);
		while (true){
			if ((char) System.in.read() == x){
                   correctCharacters++;
				break;
			}
			else{
				incorrectCharacters++;
			}
		}
                double charactersPerMinute = counter(correctCharacters, Scheduler.getTime()) * 60;
                double aR = accuracy(correctCharacters, incorrectCharacters);
                System.out.println("\n Characters per minute: " + charactersPerMinute);
                System.out.println("\n Accuracy: "  + aR + "%");
	}

	/**
	 * This method works as a counter to track the characters per minute
	 * @param c Number of characters
	 * @param t Time in seconds
	 * @return The characters per second calculation
	 */
	public static double counter(double c, int t){
	    double cpm = c / t;
	    return cpm;
        }
        
		/**
		 * This method calculates the user accuracy
		 * @param correct The number of characters inputed correctly
		 * @param incorrect The number of characters inputed incorrectly
		 * @return The accuracy of the user
		 */
        public static double accuracy(double correct, double incorrect){
            double result = (correct / (correct + incorrect)) * 100;
            return result;
        }
    
}
