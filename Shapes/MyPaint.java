package Shapes;

import java.security.SecureRandom;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class is a JPanel component that paint on the screen two arrays of different shapes.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class MyPaint extends JPanel{
	
	final static int BIGGEST = 300;	
	final static int LIST_SIZE = 6;
	
	//private and random numbers for creating the random shapes
	static SecureRandom randomNUMbers = new SecureRandom(); 	
	final int NUM1 = randomNUMbers.nextInt( BIGGEST );
	final int NUM2 = randomNUMbers.nextInt( BIGGEST );
	final int NUM3 = randomNUMbers.nextInt( BIGGEST );
	final int NUM4 = randomNUMbers.nextInt( BIGGEST );
	final int NUM5 = randomNUMbers.nextInt( BIGGEST );

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// create two lists of shapes
		ArrayList<MyShape> listShape = new ArrayList<MyShape>(LIST_SIZE);
		ArrayList<MyShape> listShape2 = new ArrayList<MyShape>(LIST_SIZE);
		
		// create random shapes 
		MyRectangle rec = new MyRectangle(NUM1, NUM2, NUM3, NUM4, NUM5<<8 ,true);
		MyRectangle rec2 = new MyRectangle(NUM5, NUM4, NUM3, NUM2, NUM1<<16 ,false);
	
		MyOval ov = new MyOval(NUM2, NUM1, NUM2, NUM3, NUM2<<4 ,true);
		MyOval ov2 = new MyOval(NUM3, NUM5, NUM4, NUM4, NUM2<<12 ,false);
		
		MyLine ln = new MyLine(NUM1, NUM1, NUM2, NUM3, NUM2);
		MyLine ln2 = new MyLine(NUM5, NUM4, NUM4, NUM5, NUM3<<16);
		
		// adding shapes to the first list
		listShape.add(rec);
		listShape.add(rec2);
		listShape.add(ov);
		listShape.add(ov2);
		listShape.add(ln);
		listShape.add(ln2);
		
		// clone all shapes with changes and adding them to the second list
		for(int i = 0;  i < listShape.size(); i++) {
			MyShape shape = (listShape.get(i)).clone();
			shape.setX1(shape.getX1()+10);
			shape.setY1(shape.getY1()+10);
			if(!( shape instanceof MyLine))
				((MyBoundedShape)shape).set_full(!(((MyBoundedShape)shape).get_full()));
			listShape2.add(shape);
		}
		
		// print all shapes to the screen
		for(int i = 0;  i < listShape.size(); i++) {
			(listShape.get(i)).draw(g);
			(listShape2.get(i)).draw(g);
		}
	}	
}
