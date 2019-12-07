package Shapes;

import java.awt.Color;
import java.awt.*;

/**
 * This class is an abstract class for shapes.
 *
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public abstract class MyShape 
					implements Cloneable{
	
	//instance variables
	private int x1; // (depend in each shape)coordinate on the X axis of the first point(in lines), or upper left point(in bounded shapes)  
	private int y1; // (depend in each shape)coordinate on the Y axis of the first point(in lines), or upper left point(in bounded shapes)
	private int x2; // (depend in each shape)coordinate on the x axis of the second point(in lines), or the width of the shape(in bounded shapes)   
	private int y2; // (depend in each shape)coordinate on the Y axis of the second point(in lines), or the height of the shape(in bounded shapes)
	private Color clr; // the color of the shape.
	
	/*
	 * Constructs and initializes a MyShape with the appropriate parameters.
	 * @param _x1 - (depend in each shape)coordinate on the X axis of the first point(in lines), or upper left point(in bounded shapes)  
	 * @param _y1 - (depend in each shape)coordinate on the Y axis of the first point(in lines), or upper left point(in bounded shapes)
	 * @param _x2 - (depend in each shape)coordinate on the x axis of the second point(in lines), or the width of the shape(in bounded shapes)   
	 * @param _y2 - (depend in each shape)coordinate on the Y axis of the second point(in lines), or the height of the shape(in bounded shapes)
	 * @param _clr - the color of the new MyShape object.
	 */
	public MyShape(int _x1, int _y1, int _x2, int _y2, int _clr) {
		x1 = _x1;
		y1 = _y1;
		x2 = _x2;
		y2 = _y2;
		clr = new Color(_clr);
	}
	
	// declare a methods that all inherited classes will have to override
	public abstract boolean equals(MyShape s);
	public abstract void draw(Graphics g); 
	
	@Override
	public MyShape clone() {
		MyShape shape;
	    try{
	    	shape = (MyShape) super.clone();
	    }
	    catch (CloneNotSupportedException e){
	        throw new Error();
	    }
	    // Deep clone member fields here
	    return shape;
	}
	
	/*
	 * Return an integer that symbolizes one of two things (depend in the shape)its a coordinate on the X axis of- 
	 * 1. The first point(in lines).
	 * 2. Upper left point(in bounded shapes).  
	 * @return x1 - the coordinate on the X axis of the upper left point  
	 */
	public int getX1() {
		return x1;
	}
	
	/*
	 * Return an integer that symbolizes one of two things (depend in the shape) its a coordinate on the Y axis of-
	 * 1. The first point(in lines).
	 * 2. Upper left point(in bounded shapes).  
	 * @return y1 - an integer that symbolizes one of two things (depend in the shape) its a coordinate on the Y axis of-
	 * <p>1. The first point(in lines).
	 * <p>2. Upper left point(in bounded shapes).  
	 */
	public int getY1() {
		return y1;
	}
	
	/*
	 * Return an integer that symbolizes one of two things (depend in the shape)-
	 * 1. The coordinate on the X axis of the first point(in lines).
	 * 2. The the width of the shape(in bounded shapes).  
	 * @return x2 - an integer that symbolizes one of two things (depend in the shape)-
	 * <p>1. The coordinate on the X axis of the first point(in lines).
	 * <p>2. The the width of the shape(in bounded shapes).  
	 */
	public int getX2() {
		return x2;
	}
	
	/*
	 * Return an integer that symbolizes one of two things (depend in the shape)-
	 * 1. The coordinate on the Y axis of the first point(in lines).
	 * 2. The the height of the shape(in bounded shapes).  
	 * @return x2 - an integer that symbolizes one of two things (depend in the shape)-
	 * <p>1. The coordinate on the Y axis of the first point(in lines).
	 * <p>2. The the height of the shape(in bounded shapes).  
	 */
	public int getY2() {
		return y2;
	}	
	
	/*
	 * Return the color of the shape. 
	 * @return clr - the color of the shape.
	 */
	public Color getColor() {
		return clr;
	}	
	
	/*
	 * Setting x1 to the given integer parameter.
	 * @param val - the new integer to set x1.
	 */
	public void setX1(int val) {
		 x1 = val;
	}
	
	/*
	 * Setting y1 to the given integer parameter.
	 * @param val - the new integer to set y1.
	 */
	public void setY1(int val) {
		y1 = val;
	}
	
	/*
	 * Setting x2 to the given integer parameter.
	 * @param val - the new integer to set x2.
	 */
	public void setX2(int val) {
		x2 = val;
	}
	
	/*
	 * Setting y2 to the given integer parameter.
	 * @param val - the new integer to set y2.
	 */
	public void setY2(int val) {
		y2 = val;
	}
	
	/*
	 * Setting the shape color to the be the new given color parameter.
	 * @param _clr - the new color.
	 */
	public void setColor(Color _clr) {
		clr =_clr;
	}	
}
