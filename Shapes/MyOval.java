package Shapes;

import java.awt.Graphics;
/**
 * This class is for shapes of type oval.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class MyOval extends MyBoundedShape{
	/*
	 * Constructs and initializes a MyOval with the appropriate parameters.
	 * @param _x1 - coordinate on the X axis of the upper left point . 
	 * @param _y1 - coordinate on the Y axis of the upper left point.
	 * @param _x2 - the width of the oval. 
	 * @param _y2 - the height of the oval.
	 * @param _clr - the color of the new MyOval object.
	 * @param is_full - true if the oval is full; false otherwise.
	 */
	public MyOval (int _x1, int _y1, int _x2, int _y2, int _clr ,boolean is_full) {
		super(_x1, _y1, _x2, _y2, _clr, is_full);
	}
	
	/*
	 * Determines whether or not two ovals are equal.
	 * Two instances of MyOval are equal if the their height and width are the same.
	 * @param other - an object of MyShape to compared with this MyOval.
	 * @return true -if the object to be compared is an instance of MyOval and has the same height and width
	 * like this MyOval; false otherwise. 
	 */
	public boolean equals(MyShape other) {
		MyOval tmp = (MyOval)other;
		return ( getX2() == tmp.getX2() &&  getY2() == tmp.getY2() );			
	}
	
	/*
	 * This method draw a oval by its parameter-  on a Graphics object g.
	 * @param g - is a graphics object that print a MyOval object by its parameters.
	 */
	public void draw(Graphics g) {
		g.setColor(getColor());
		if(get_full())
			g.fillOval(getX1(), getY1(), getX2(), getY2());
		else
			g.drawOval(getX1(), getY1(), getX2(), getY2());
	}


}
