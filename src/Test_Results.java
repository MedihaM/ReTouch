
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.assertj.core.api.*;
import org.assertj.core.api.Assertions;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static java.awt.event.KeyEvent.*;
//To run tests: Open in eclipse, have pom.xml file in project & test files in src folder.
/**
 * This class tests the Results class.
 * This meets the testing required for the following functional requirements:
 * FREQ 11: The system displays the elapsed time, from when the user began the Lesson.
 * FREQ 12: The system displays the user’s typing accuracy
 * FREQ 13: The system displays the user’s typing speed
 * FREQ 15: The results (time, typing accuracy, and typing speed) are displayed to the user.
 * FC-1: Calculated accuracy of user to match the expected characters.
 * F-2: The total time taken in comparison to the expected time and the user’s speed calculation (the total characters per second).

 * @author Abrar Attia
 * @version 1.0
 * @since 2017-12-02
 *
 */
public class Test_Results{
	
	private FrameFixture window;

	String firstLine = "The brown fox jumps quick over lazy dog but joy a";
	
	@Before
	public void setUp() throws Exception {
		// Runs the selection page and opens the "all" lesson
		SelectionPage frame = GuiActionRunner.execute(() -> new SelectionPage());
		window = new FrameFixture(frame);
		window.show();
		
		Thread.sleep(1500);
		window.comboBox("jComboBox1").selectItem(0);
		Thread.sleep(1500);
		window.button("jButton1").click();
		Thread.sleep(1500);
	
		
	}

	@After
	public void tearDown() throws Exception {
		window.cleanUp();
	}
	
	// Tests that user input of first character is recorded and correct
	@Test
	public void resultsSelectionTest1() throws InterruptedException {
		Thread.sleep(1500);
		// Find the new page: the main lesson page
		FrameFixture mainFrame = findFrame("selectedLesson").withTimeout(10000).using(window.robot());
		// Send in the first character in the line
		mainFrame.robot().type(firstLine.charAt(0));
		// Confirms that the current character is now the second character in the first line
		// Send in the second character as incorrect
		mainFrame.robot().type(firstLine.charAt(0));
		mainFrame.pressAndReleaseKeys(VK_BACK_SPACE);

		// Inserts all the required characters with 1 mistake
		for (int i = 1; i < firstLine.length(); i++){
			mainFrame.robot().type(firstLine.charAt(i));
		}
		
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		String secondLine = "Little Boy fishes very highly anticipated how tan";
		String thirdLine = "lazy dog say alfalfa sophisticated blueberry quiz";
		String fourthLine = "bubble poor quality words Basement o Frickin HeCK";
		String fifthLine = "why so people young FINGERtips neighbour salsa yo";
		String sixthLine = "coordinate toilet black purse i generally stay in";
		String seventhLine = "the fourty dollar range when I purchase nice bows";
		
		for (int i = 0; i < secondLine.length(); i++){mainFrame.robot().type(secondLine.charAt(i));}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < thirdLine.length(); i++){mainFrame.robot().type(thirdLine.charAt(i));}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < fourthLine.length(); i++){mainFrame.robot().type(fourthLine.charAt(i));}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < fifthLine.length(); i++){mainFrame.robot().type(fifthLine.charAt(i));}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < sixthLine.length(); i++){mainFrame.robot().type(sixthLine.charAt(i));}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		for (int i = 0; i < seventhLine.length(); i++){mainFrame.robot().type(seventhLine.charAt(i));}
		mainFrame.pressAndReleaseKeys(VK_ENTER);
		
		Thread.sleep(1000);
		// confirms that the time is being recorded
		assertThat(Scheduler.elapsedTime).isNotEqualTo(null);
		// confirms that the accuracy is recorded and displayed
		assertThat(Scheduler.accuracy()).isEqualTo(99);
		// confirms that the user speed is recorded, displayed, and correct
		assertThat(Scheduler.counter()).isCloseTo(350, within(60));
		// confirms that the elapsed time is recorded, displayed, and correct
		assertThat(Scheduler.elapsedTime).isCloseTo(50, within(10));

	}
}
