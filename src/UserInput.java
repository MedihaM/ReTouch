package se3XA3;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;

public class UserInput {

	static String[] stringArray = new String[7];

	// position of the current integer [line, char]
	public static int[] currentCharacter = { 0, 0 };

	// number of correctly entered characters
	public static int correctCharacters = 0;

	// number of incorrectly entered characters
	public static int incorrectCharacters = 0;

	static int MAX_LINE = 7; // number of lines
	static int MAX_CHAR = 50; // number of characters per line
	static int[][] charStatus = new int[MAX_LINE][MAX_CHAR];
	// The charStatus = 0 if it is untyped, 1 if it has been typed correctly,
	// 2 if it has been typed incorrectly

	/**
	 * Manages user input and compares it to the expected character.
	 * 
	 * @param jf
	 */
	public static void keyboardInput(JFrame jf) {
		// Add the keyboard input option:
		jf.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent ke) {
				char typedChar = ke.getKeyChar();
				if (typedChar == stringArray[currentCharacter[0]].charAt(currentCharacter[1])) {
					correctCharacters += 1;
					currentCharacter[1] += 1; // Shifts the current character
				} else {
					incorrectCharacters += 1;
				}
			}
		});
	}

	public static void setCharStatus(int line, int c, int value) {
		charStatus[line][c] = value;
	}

	public static int getCharStatus(int line, int c) {
		return charStatus[line][c];
	}

	public static int[] getCurrentCharacter() {
		return currentCharacter;
	}

	/**
	 * Initialization of the characters
	 * 
	 * @throws IOException
	 */
	public static void setUp() throws IOException {
		for (int i = 0; i < MAX_LINE; i++) {
			for (int j = 0; j < MAX_CHAR; j++) {
				setCharStatus(i, j, 0); // Set all characters as
										// untyped
			}
		}
		stringArray = Parser.getStringArr("asdf");
	}

}
