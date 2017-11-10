import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Results extends JFrame implements ActionListener {
    
    public Results() {
    	makeResults.makeR();
    }
   
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint(); // repaints every 5ms
		
	}

}