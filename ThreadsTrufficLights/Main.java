package ThreadsTrufficLights;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class is manage the JFrame Container. Creates a new TrafficLightsPanel object 
 * <p> with a two command line argument that determine the delays time for the
 * <p> traffic lights. Adding this TrafficLightsPanel object to the frame and set it visible.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class Main {

	public static void main(String[] args)
	{
		JFrame frm = new JFrame("Traffic lights");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		// getting the two delays time from the command line
		
		try {
			
			if (args.length != 2)
				throw new ArrayIndexOutOfBoundsException();
			
			// transform the 2 parameters into integers
			Long first = Long.parseLong(args[0]);
			Long sec = Long.parseLong(args[1]);
			
			// check if all integers are positive
			if ( first <= 0 || sec <= 0 ) {	
				JOptionPane.showMessageDialog(null, "The parameters must be positive! ","Error",JOptionPane.ERROR_MESSAGE );
				return;
			}
			
			long carsGreenTimeEastWest = first;
			long carsGreenTimeNorthSouth = sec;
	
			// creates a new TrafficLightsPanel object.
			TrafficLightsPanel pnl = new TrafficLightsPanel(carsGreenTimeEastWest , carsGreenTimeNorthSouth);
			
			frm.add(pnl);
			frm.setSize(500,500);
			frm.setVisible(true);
			
		}	
		catch(ArrayIndexOutOfBoundsException | NumberFormatException e ){ 
			JOptionPane.showMessageDialog(null, "comand line parameters must be 2 integers.\n Recommended range is 10,000 - 20,000","Error",JOptionPane.ERROR_MESSAGE );
		}
	}
}
