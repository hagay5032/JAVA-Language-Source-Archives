package ThreadsTrufficLights;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class TrafficLightsPanel extends JPanel 
{
	// thread that will be responsible for changing the lights as the given delays time.
	private LightsThread lights; 
	
	/*
	 * Creates a new TrafficLightsPanel object.
	 * @param carsGreenTimeEastWest - is the delay time for the cars green light East-West sides.
	 * @param carsGreenTimeNorthSouth - is the delay time for the cars green light North-South sides.
	 */
	public TrafficLightsPanel(long carsGreenTimeEastWest, long carsGreenTimeNorthSouth) {
		
		// creates a new LightsThread 
		lights = new LightsThread(this, carsGreenTimeEastWest, carsGreenTimeNorthSouth);	
		lights.start();
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		// paint all the traffic lights on the panel
		g.setColor(Color.BLACK);
		g.fillOval(100,100, 25, 25);
		g.fillOval(100,125, 25, 25);
		g.fillOval(325,100, 25, 25);
		g.fillOval(325,125, 25, 25);
		g.fillOval(225,25, 25, 25);
		g.fillOval(225,0, 25, 25);
		g.fillOval(225,300, 25, 25);
		g.fillOval(225,275, 25, 25);
		g.fillOval(100,150, 25, 25);
		g.fillOval(325,150, 25, 25);
		g.fillOval(225,50, 25, 25);
		g.fillOval(225,325, 25, 25);
		g.fillRect(100,175, 25, 25);
		g.fillRect(325,175, 25, 25);
		g.fillRect(225,75, 25, 25);
		g.fillRect(225,350, 25, 25);
		g.fillRect(100,200, 25, 25);
		g.fillRect(325,200, 25, 25);
		g.fillRect(225,100, 25, 25);
		g.fillRect(225,375, 25, 25);
		
		g.setColor(lights.getCarEastWestYellow()); 
		g.fillOval(102,127, 21, 21);
		g.fillOval(327,127, 21, 21);
		
		g.setColor(lights.getCarSouthNorthYellow());
		g.fillOval(227,27, 21, 21);
		g.fillOval(227,302, 21, 21);
		
		g.setColor(lights.getCarEastWestRed()); 
		g.fillOval(102,102, 21, 21);
		g.fillOval(327,102, 21, 21);
		
		g.setColor(lights.getCarSouthNorthRed());
		g.fillOval(227,2, 21, 21);
		g.fillOval(227,277, 21, 21);
		
		g.setColor(lights.getCarEastWestGreen());
		g.fillOval(102,152, 21, 21);
		g.fillOval(327,152, 21, 21);
		
		g.setColor(lights.getCarSouthNorthGreen());
		g.fillOval(227,52, 21, 21);
		g.fillOval(227,327, 21, 21);
		
		g.setColor(lights.getPedestrianEastWestRed());
		g.fillRect(102,177, 21, 21);
		g.fillRect(327,177, 21, 21);
		
		g.setColor(lights.getPedestrianSouthNorthRed());
		g.fillRect(227,77, 21, 21);
		g.fillRect(227,352, 21, 21);
		
		g.setColor(lights.getPedestrianEastWestGreen());
		g.fillRect(102,202, 21, 21);
		g.fillRect(327,202, 21, 21);
		
		g.setColor(lights.getPedestrianSouthNorthGreen());
		g.fillRect(227,102, 21, 21);
		g.fillRect(227,377, 21, 21);
		
	}
	
}
