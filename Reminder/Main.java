package Reminder;

import javax.swing.JFrame;

/**
 * This class is manage the JFrame Container. Adding the ReminderPanel object 
 * <p> and set it visible.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// setting the frame properties
		JFrame frm = new JFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setTitle("Calender Reminder");
		
		ControllerPanel pnl = new ControllerPanel();
		
		frm.add(pnl); // attached the ReminderPanel object to the frame.
		frm.setSize(500, 200);
		frm.pack();
		frm.setLocationRelativeTo ( null );
		frm.setVisible(true);
		
	}
}
