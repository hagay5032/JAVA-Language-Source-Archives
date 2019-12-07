package Sodoko;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * This class is a for Cell objects that represent data structure for text button to a sodoko board,
 * <p> who extends JTextField and as more fields and methods.
 *
 * @author Hagay Enoch
 * @version 203089917
 */
public class TextCell extends JTextField {

	private int indexX; // holds the index X of this button.
	private int indexY; // holds the index Y of this button.
	private int num; // holds the number in this button.
	private String strNum; // holds the string representation of the number in this button.

	/*
	 * Return the X index of this Cell object.
	 * @return the X index of this Cell object.
	 */
	public int getIndexX() {
		return indexX;
	}
	
	/*
	 * Return the Y index of this Cell object.
	 * @return the Y index of this Cell object.
	 */
	public int getIndexY() {
		return indexY;
	}
	
	/*
	 * Return the number in this Cell object.
	 * @return the number in this Cell object.
	 */
	public int getNum() {
		return num;
	}
	
	/*
	 * Return the string representation number in this Cell object.
	 * @return the string representation number in this Cell object.
	 */
	public String getStringInCell() {
		return strNum;
	}
	
	/*
	 * Set the X index of this Cell object.
	 * @param num - is the X index for this Cell object.
	 */
	public void setIndexX(int num) {
		indexX = num;
	}
	
	/*
	 * Set the Y index of this Cell object.
	 * @param num - is the Y index for this Cell object.
	 */
	public void setIndexY(int num) {
		indexY = num;
	}
	
	/*
	 * Set the number of this Cell object.
	 * @param _num - is the number for this Cell object.
	 */
	public void setNumInCell(int _num) {
		num = _num;
	}
	
	/*
	 * Set the string representation number in this Cell object.
	 * @param strNum - is the string representation number for this Cell object.
	 */
	public void setStringInCell(String str) {
		strNum = str;
	}
	
	/*
	 * Set this instance Cell to be an empty string. 
	 */
	public void reSetFont() {
		Font f = new Font("Arial", Font.PLAIN,20);
		setBorder(new LineBorder(Color.black, 1));
		setForeground(Color.BLACK);
		setFont(f);
		setText("");
	}
	
	/*
	 * Set this instance Cell to be a string with two blanks and the valid number. 
	 */
	public  void reSetFont( int num) {
		Font f = new Font("Arial", Font.BOLD,25);
		setForeground(Color.BLACK);
		setFont(f);
		setText("  " + num);
	}
	
	/*
	 * Set this instance Cell to be as fixed font with blue color. 
	 */
	public void setFixFont(int num) {
		Font f = new Font("Arial", Font.BOLD,35);
		setForeground(new Color(80,80,220));
		setFont(f);
		setText(" "+num);
	}
}
