package Shapes;

import java.awt.Graphics;

/**
 * This class is for shapes of type rectangle.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class MyRectangle extends MyBoundedShape {
	
	/*
	 * Constructs and initializes a MyRectangle with the appropriate parameters.
	 * @param _x1 - coordinate on the X axis of the upper left point . 
	 * @param _y1 - coordinate on the Y axis of the upper left point.
	 * @param _x2 - the width of the rectangle. 
	 * @param _y2 - the height of the rectangle.
	 * @param _clr - the color of the new MyRectangle object.
	 * @param is_full - true if when the rectangle is full; false otherwise.
	 */
	public MyRectangle (int _x1, int _y1, int _x2, int _y2, int _clr ,boolean is_full) {
		super(_x1, _y1, _x2, _y2, _clr, is_full);
	}
	
	/*
	 * Determines whether or not two rectangles are equal.
	 * Two instances of MyRectangle are equal if the their height and width are the same.
	 * @param other - an object of MyShape to compared with this MyRectangle.
	 * @return true -if the object to be compared is an instance of MyRectangle and has the same height and width
	 * like this MyRectangle; false otherwise. 
	 */
	public boolean equals(MyShape other) {
		MyRectangle tmp = (MyRectangle)other;
		return ( getX2() == tmp.getX2() &&  getY2() == tmp.getY2() );			
	}
	
	/*
	 * This method draw a rectangle by its parameter-  on a Graphics object g.
	 * @param g - is a graphics object that print a MyRectangle by its parameters.
	 */
	public void draw(Graphics g) {
		g.setColor(getColor());
		if(get_full())
			g.fillRect(getX1(), getY1(), getX2(), getY2());
		else
			g.drawRect(getX1(), getY1(), getX2(), getY2());
	}
	

}
