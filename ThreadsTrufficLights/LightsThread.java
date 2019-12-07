package ThreadsTrufficLights;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * This class is manage the changes of the traffic lights as the given delays time
 * for each traffic lights.
 * An instance of this class get two delays time that determine the time for the green
 * lights to each direction.
 *  
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class LightsThread extends Thread{
	
	private long delay, carsGreenTimeEastWest, carsGreenTimeNorthSouth; // delays time;
	private JPanel pnl; // reference to the panel of the graphical component.
	
	// colors for the traffics lights
	private Color carSouthNorthGreen;
	private Color carSouthNorthRed;

	private Color carSouthNorthYellow;
	private Color carEastWestYellow;

	private Color carEastWestGreen;
	private Color carEastWestRed;

	private FlickerColor PedestrianSouthNorthGreen;
	private Color PedestrianSouthNorthRed;

	private FlickerColor PedestrianEastWestGreen;
	private Color PedestrianEastWestRed;
	
	/*
	 * Creates a new thread that switch the traffics light as the given delays time.
	 * @param panel - is a reference to the panel where the graphical component is.
	 * @param greenTimeEastWest - its the delay time for the green traffic light for the direction east-west. 
	 * @param greenTimeNorthSouth - its the delay time for the green traffic light for the direction north-south. 
	 */
	public LightsThread(JPanel panel, long greenTimeEastWest, long greenTimeNorthSouth)
	{
		// initializing the reference to the graphical panel 
		pnl = panel;
		
		// initializing the delays time 
		carsGreenTimeEastWest = greenTimeEastWest;
		carsGreenTimeNorthSouth = greenTimeNorthSouth;
		
		// creating the light as green for North-South sides
		greenForNorthSouth();		
	}
	
	/*
	 * Creating the light as green for North-South sides
	 */
	public void greenForNorthSouth() {

		//initializing the lights
		carSouthNorthGreen =  Color.GREEN;
		carSouthNorthYellow =  Color.BLACK;
		carSouthNorthRed = Color.BLACK;
		PedestrianSouthNorthGreen = new FlickerColor(pnl , false);
		PedestrianSouthNorthRed  = Color.RED;
		
		carEastWestGreen = Color.BLACK;
		carEastWestYellow =  Color.BLACK;
		carEastWestRed = Color.RED;
		PedestrianEastWestGreen = new FlickerColor(pnl , true);
		PedestrianEastWestRed  = Color.BLACK;
		
		//initializing the delay
		delay = carsGreenTimeNorthSouth;
	}

	/*
	 * Creating the light as green for East-West sides.
	 */
	public void greenForEsatWest() {
		
		//initializing the lights
		carSouthNorthGreen =  Color.BLACK;
		carSouthNorthYellow =  Color.BLACK;
		carSouthNorthRed = Color.RED;
		PedestrianSouthNorthGreen = new FlickerColor(pnl , true);
		PedestrianSouthNorthRed  = Color.BLACK; ;
		
		carEastWestGreen = Color.green;
		carEastWestYellow =  Color.BLACK;
		carEastWestRed = Color.BLACK;
		PedestrianEastWestGreen = new FlickerColor(pnl , false);
		PedestrianEastWestRed  = Color.RED;
		
		carEastWestYellow =  Color.BLACK;
		carSouthNorthYellow =  Color.BLACK;
		//initializing the delay
		delay = carsGreenTimeEastWest;
	}
	
	/*
	 * Creating the light as yellow for East-West sides.
	 */
	public void getReadyStopNorthSouth() {
		
		//initializing the lights
		carSouthNorthGreen =  Color.BLACK;
		carSouthNorthYellow =  Color.YELLOW;
		carSouthNorthRed = Color.BLACK;
		PedestrianSouthNorthGreen = new FlickerColor(pnl , false);
		PedestrianSouthNorthRed  = Color.RED; ;
		
		carEastWestGreen = Color.BLACK;
		carEastWestYellow =  Color.BLACK;
		carEastWestRed = Color.RED;
		PedestrianEastWestGreen = new FlickerColor(pnl , false);
		PedestrianEastWestRed  = Color.RED;
	}
	
	/*
	 * Creating the light as yellow for East-West sides.
	 */
	public void getReadyStopEsatWest() {
		
		//initializing the lights
		carSouthNorthGreen =  Color.BLACK;
		carSouthNorthYellow =  Color.BLACK;
		carSouthNorthRed = Color.RED;
		PedestrianSouthNorthGreen = new FlickerColor(pnl , false);
		PedestrianSouthNorthRed  = Color.RED; ;
		
		carEastWestGreen = Color.BLACK;
		carEastWestYellow =  Color.YELLOW;
		carEastWestRed = Color.BLACK;
		PedestrianEastWestGreen = new FlickerColor(pnl , false);
		PedestrianEastWestRed  = Color.RED;
	}
	
	/*
	 * Creating the light as yellow for East-West sides.
	 */
	public void getReadyDriveNorthSouth() {
		
		//initializing the lights
		carSouthNorthGreen =  Color.BLACK;
		carSouthNorthYellow =  Color.YELLOW;
		carSouthNorthRed = Color.RED;
		PedestrianSouthNorthGreen = new FlickerColor(pnl , false);
		PedestrianSouthNorthRed  = Color.RED; ;
		
		carEastWestGreen = Color.BLACK;
		carEastWestYellow =  Color.BLACK;
		carEastWestRed = Color.RED;
		PedestrianEastWestGreen = new FlickerColor(pnl , false);
		PedestrianEastWestRed  = Color.RED;
	}
	
	/*
	 * Creating the light as yellow for East-West sides.
	 */
	public void getReadyDriveEsatWest() {
		
		//initializing the lights
		carSouthNorthGreen =  Color.BLACK;
		carSouthNorthYellow =  Color.BLACK;
		carSouthNorthRed = Color.RED;
		PedestrianSouthNorthGreen = new FlickerColor(pnl , false);
		PedestrianSouthNorthRed  = Color.RED; ;
		
		carEastWestGreen = Color.BLACK;
		carEastWestYellow =  Color.YELLOW;
		carEastWestRed = Color.RED;
		PedestrianEastWestGreen = new FlickerColor(pnl , false);
		PedestrianEastWestRed  = Color.RED;
	}
	
	
	// getting methods
	public Color getCarSouthNorthYellow()
	{
		return carSouthNorthYellow;
	}
	public Color getCarEastWestYellow()
	{
		return carEastWestYellow;
	}
	public Color getPedestrianEastWestRed()
	{
		return PedestrianEastWestRed;
	}
	public Color getCarEastWestRed()
	{
		return carEastWestRed;
	}
	public Color getCarEastWestGreen()
	{
		return carEastWestGreen ;
	}
	public Color getPedestrianEastWestGreen() {
		return PedestrianEastWestGreen.getColor();
	}
	public Color getPedestrianSouthNorthGreen() {
		return PedestrianSouthNorthGreen.getColor();
	}
	public Color getPedestrianSouthNorthRed()
	{
		return PedestrianSouthNorthRed ;
	}
	public Color getCarSouthNorthRed()
	{
		return carSouthNorthRed ;
	}
	public Color getCarSouthNorthGreen()
	{
		return carSouthNorthGreen ;
	}

	@Override
	public void run() {
		
		// creates a boolean flag to change the lights 
		boolean flipflop = false;
		
		while(true) {
			
			// sleep the 'delay' time each iteration of this while loop
			try{
				Thread.sleep(delay);
			}
			catch(InterruptedException e){}
			
			// changing the lights.
			if(flipflop)
			{
				getReadyStopEsatWest();// give the East-West sides yellow
				try{
					Thread.sleep(3000);
				}
				catch(InterruptedException e){}
				getReadyDriveNorthSouth();
			}
			else
			{
				getReadyStopNorthSouth();// give the East-West sides yellow
				try{
					Thread.sleep(3000);
				}
				catch(InterruptedException e){}
				getReadyDriveEsatWest();
			}

			// sleep the 2 second 
			try{
				Thread.sleep(3000);
			}
			catch(InterruptedException e){}
			
			// changing the lights.
			if(flipflop)
				greenForNorthSouth(); // give the North-South sides green
			else 
				greenForEsatWest();// give the East-West sides green
			
			// change the flipflop
			flipflop = !flipflop;
			
		}
	}
}

