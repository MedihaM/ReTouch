
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.junit.Assert.*;

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


public class SelectionPage_Test{
	
	private FrameFixture window;
	private FrameFixture lessonPage;
	
	@Before
	public void setUp() throws Exception {
		SelectionPage frame = GuiActionRunner.execute(() -> new SelectionPage());
		window = new FrameFixture(frame);
		window.show();
		  
	}

	@After
	public void tearDown() throws Exception {
		window.cleanUp();
		//window.close();
		
	}

	// FREQ1 in Test Plan: Lesson types provided and button can be clicked
	@Test
	public void lessonSelectionTest1() throws InterruptedException {
		Thread.sleep(3500);
		window.comboBox("jComboBox1").selectItem(1);
		Thread.sleep(1500);
		window.button("jButton1").click();
	}

	// FREQ1 in Test Plan: Correct lesson page opens when certain lesson is selected and 'start' button clicked.
	@Test
	public void lessonSelectionTest2() throws InterruptedException {
		Thread.sleep(1500);
		window.comboBox("jComboBox1").selectItem(2);
		Thread.sleep(1500);
		window.button("jButton1").click();
		
		Robot robot = BasicRobot.robotWithNewAwtHierarchy();
		
		lessonPage = findFrame("lesson").using(robot);
		lessonPage.requireVisible();
		lessonPage.show();
		lessonPage.cleanUp();
	}
}
