package Shapes;

import javax.swing.JFrame;

/**
 * This class is manage the JFrame Container. Adding to it an object of MyPaint, and set it visible.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class Main {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Testing"); 

		// setting the frame properties
		// set that a press on the X button of the frame causes the program(thread) to terminate.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Leonardo da Vinci - \"Shapes of my heart\""); 
		frame.setSize(400, 400);
		
		MyPaint p = new MyPaint();
		
		frame.add(p); // attached the MyPaint object to the frame. 
		frame.setVisible(true);	
	}
}
