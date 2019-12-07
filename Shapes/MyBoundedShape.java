package Shapes;

/**
 * This class is for bounded shapes like oval, rectangle, etc.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public abstract class MyBoundedShape extends MyShape {
	private boolean is_full; // instance variable for symbolize if a bounded shape is full with color, true for full; false otherwise.
	
	/*
	 * Constructs and initializes a MyShape with the appropriate parameters.
	 * @param _x1 - (depend in each shape)coordinate on the X axis of the upper left point(in bounded shapes).
	 * @param _y1 - (depend in each shape)coordinate on the Y axis of the upper left point(in bounded shapes).
	 * @param _x2 - the width of the shape.
	 * @param _y2 - the height of the shape.
	 * @param _clr - the color of the new MyShape object.
	 * @param full - true for a full colored shape;false otherwise.
	 */
	public MyBoundedShape (int _x1, int _x2, int _y1, int _y2, int _clr ,boolean full) {
		super(_x1, _y1, _x2, _y2, _clr);
		is_full = full;
	}
	
	/*
	 * Return true if the shape is full; false otherwise.
	 * @return true if the shape is full; false otherwise.
	 */	
	public boolean get_full() {
		return is_full;
	}
	
	/*
	 * Setting the shape to be full or empty. true for full ; false for empty.
	 * @param full - if true then the object is full with color , otherwise the shape not full.
	 */
	public void set_full(boolean full) {
		is_full = full; 
	}
}
