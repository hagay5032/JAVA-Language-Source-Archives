package Sodoko;

import javax.swing.JFrame;

/**
 * This class is manage the JFrame Container. Adding the sodokoPanel object , and set it visible.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// setting the frame properties
		JFrame frm = new JFrame("Sodoko");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(500, 500);
		
		SodokoPanel sdkPnl = new SodokoPanel(); 
		
		frm.add(sdkPnl); // attached the sodokoPanel object to the frame. 
		frm.setVisible(true);
	}
}
