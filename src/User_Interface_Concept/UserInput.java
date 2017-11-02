/**
 * 
 *  http://www.javaexamples.org/java/java.awt.event/keytyped-in-keylistener.html
 */

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UserInput extends JFrame implements ActionListener{

	public UserInput() throws IOException {
		
		super("title");
		Frame frame = new Frame();
		
		// Choose the lesson
		String lesson = Parser.getGString("asdf");
		
		
		JLabel label = new JLabel(lesson, SwingConstants.CENTER);
		label.setFont(new Font("Courier", Font.PLAIN, 35));
		label.setForeground(Color.blue);
		frame.add(label, BorderLayout.NORTH);


		// Add the text (keyboard input) box
		TextField textField = new TextField();
		frame.add(textField, BorderLayout.SOUTH);

		frame.setSize(1200, 800);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				// Use System.exit(0) to close the screen
				System.exit(0);
			}
		});
		textField.addKeyListener(new KeyAdapter() {
			/**
			 * When you type the character "a" into the text field you will see
			 * an information dialog box
			 */
			public void keyTyped(KeyEvent ke) {
				char keyChar = ke.getKeyChar();
				if (keyChar == 'a') {
					System.out.print("A");
				} else {
					System.out.print(keyChar);
				}
								
			}

		});

	}

	public static void main(String[] args) throws IOException {
		new UserInput();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}