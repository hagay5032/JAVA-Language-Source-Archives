package ThreadsTrufficLights;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class is for a flickering a color in BLACK and green,
 * an instance of this class has a Color type that change every half a second
 * between BLACK and green. 
 *  
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class FlickerColor {
	
	private JPanel panel; // a reference to the panel where the graphical object is
	private Color color; // the color of this FlickerColor object 
	private boolean flipflop; // boolean for changing the color every half a second
	
	/*
	 * Creates a new FlickerColor object.
	 * @param pnl - a reference to the panel where the graphical object is.
	 * @param toFlicker - true if this object is suppose to flicker in green and BLACK; false - will make the color BLACK.
	 */
	public FlickerColor(JPanel pnl , boolean toFlicker)
	{
		flipflop = true;
		panel = pnl;
		
		
		if(toFlicker) {
			// creates a timer that will prompt an event of a Listener every half a second.
			Timer time = new Timer(500, new Listener());
			time.setRepeats(true);
			time.start();	
		}
		color = Color.BLACK;
		panel.repaint();
	}
	
	/*
	 * Return the color of this object.
	 * @return the color of this object.
	 */
	public Color getColor()
	{
		return color ;
	}
	
	/*
	 * Setting the color of this object as the given parameter color.
	 * @param clr - is the new color for this object.
	 */
	public void setColor(Color clr)
	{
		color = clr ;
	}

	/*
	 * This class is for a listener that change the color of this object
	 * between green and BLACK.
	 */
	private class Listener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			if(flipflop) 
				setColor(Color.BLACK);
			else
				setColor(Color.GREEN);
		
			flipflop = !flipflop;
			panel.repaint();
		}
	}
}




