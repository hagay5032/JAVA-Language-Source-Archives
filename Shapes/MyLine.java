package Shapes;

import static java.lang.Math.sqrt;

import java.awt.Graphics;

/**
 * This class is for shapes of type line.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class MyLine extends MyShape{

	/*
	 * Constructs and initializes a MyLine with the appropriate parameters.
	 * @param _x1 - coordinate on the X axis of the first point . 
	 * @param _y1 - coordinate on the Y axis of the first point.
	 * @param _x2 - coordinate on the X axis of the second point . 
	 * @param _y2 - coordinate on the Y axis of the second point.
	 * @param _clr - the color of the new MyLine object.
	 * @param is_full - true if when the line is full; false otherwise.
	 */
	public MyLine(int _x1, int _y1, int _x2, int _y2, int _clr) {
		super(_x1, _y1, _x2, _y2, _clr);
	}

	/*
	 * Determines whether or not two lines are equal.
	 * Two instances of MyLine are equal if the their lengths are the same.
	 * @param other - an object of MyShape to compared with this MyLine.
	 * @return true -if the object to be compared is an instance of MyLine and has the same length
	 * like this MyLine; false otherwise. 
	 */	
	public boolean equals(MyShape other) {
		return ( length() == ((MyLine)other).length() );
	}
	
	/*
	 * Return the length of a line. 
	 * @return the length of a line.  
	 */	
	public double length() {
		return ( sqrt( (getX1()-getX2())*(getX1()-getX2()) + (getY1()-getY2())*(getY1()-getY2()) ) );
	}

	/*
	 * This method draw a line by its parameter-  on a Graphics object g.
	 * @param g - is a graphics object that print a MyLine object by its parameters.
	 */
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
	
}
