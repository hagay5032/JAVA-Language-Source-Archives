package Sodoko;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class is for creating instances of sodoko panels.  
*
* @author Hagay Enoch
* @version 203089917
* 
*/
public class SodokoPanel extends JPanel{

	private JButton cmdSet; // Button for Set the board ' and end the first phase.
	private JButton cmdClear; // Button for clear the board and start new game.
	private boolean beforeSet; // variable represent the first phase, true when the game is the first phase, false otherwise.
	private final int NINE = 9, THREE = 3,  ONE =1 , BOARD_SIZE = 400;
	
	private TextCell[][] btnArr; // array for all 81 buttons for numbers. 
	private ArrayList<TextCell> fixedButtonList; // array for all buttons that selected in the first phase.
	
	/*
	 * Constructs and initializes a SodokoPanel.
	 */
	public SodokoPanel () {
		
		// initialize instance variables 
		fixedButtonList = new ArrayList<TextCell>();
		btnArr = new TextCell[NINE][NINE];
		beforeSet = true;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel ctrlButtons = new JPanel(); // create a new panel for the 2 control buttons 'Set' and 'Clear' .
		JPanel numButtons = new JPanel(); // create a new panel for all 81 buttons of numbers in the sodoko board. 
		
		numButtons.setLayout(new GridLayout(NINE,8));
		numButtons.setSize(BOARD_SIZE, BOARD_SIZE);
	
		// create 2 listeners one for all 81 numbers buttons and the 2nd for the 2 control buttons - 'Set' and 'Clear'. 
		ButtonListener ctrlButton = new ButtonListener();
		ButtonNumListener inputLis = new ButtonNumListener();
		
		for(int i = 0; i<NINE ; i++) {
			for(int j = 0; j<NINE ; j++) {
			
				// initialize a new text button.
				btnArr[i][j] = new TextCell(); 
				btnArr[i][j].setPreferredSize(new Dimension(50, 50));
				
				if(toPaintLightGray(i,j))
					btnArr[i][j].setBackground(Color.lightGray); 
				
				//initialize the button with right index and empty string 
				btnArr[i][j].setIndexX(i);
				btnArr[i][j].setIndexY(j);
				btnArr[i][j].reSetFont();
				
				// attach listener to the new button
				btnArr[i][j].addActionListener(inputLis);
				
				// add the new button to panel
				numButtons.add(btnArr[i][j]);
			}
		}

		//initialize the two control buttons
		cmdSet = new JButton("Set");
		cmdClear = new JButton("Clear");

		// attach listener for the two control buttons 
		cmdSet.addActionListener(ctrlButton);
		cmdClear.addActionListener(ctrlButton);
		
		// add the 2 control buttons to the control panel
		ctrlButtons.add(cmdSet);
		ctrlButtons.add(cmdClear);
		
		// add the 2 panels to this sodokoPanel instance 
		this.add(numButtons);
		this.add(ctrlButtons);		
	}
	
	/*
	 * Return true if the cell (i,j) in the sodoko board is need to paint its background with light-gray color.
	 * @param i - is the index x of the cell.
	 * @param j - is the index y of the cell.
	 * @return true - if the cell (i,j) in the sodoko board is need to paint its background with light-gray color.
	 */
	private boolean toPaintLightGray(int i, int j) {
		// paint the board with weight and gray 3x3 squares 
		if ( (i > 5|| i < 3) && (5 < j ||  j < 3 ) )
			return true; 
		else if ( (6 > i && i > 2) && (6 > j && j > 2) )
			return true; 
		return false;
	}
	
	/*
	 * Return true if there is no duplicates of 'num' in the same column as cell (indexX,indexY). false otherwise.
	 * @param indexX - is the X index of the cell in the sodoko board.
	 * @param indexY - is the Y index of the cell in the sodoko board.
	 * @param num - is the number in the cell (indexX,indexY).
	 * @return true - if there is no duplicates of 'num' in the same column as cell (indexX,indexY). false otherwise. 
	 */
	private boolean checkColumn(int indexX, int indexY,  int num)
	{
		for(int i = 0; i<NINE; i++) {
			if (i == indexX)
				continue;
			if (getNumFromCell(btnArr[i][indexY]) == num)
				return false;
		}
		return true;
	}

	/*
	 * Return true if there is no duplicates of 'num' in the same row as cell (indexX,indexY). false otherwise.
	 * @param indexX - is the X index of the cell in the sodoko board.
	 * @param indexY - is the Y index of the cell in the sodoko board.
	 * @param num - is the number in the cell (indexX,indexY).
	 * @return true - if there is no duplicates of 'num' in the same row as cell (indexX,indexY). false otherwise. 
	 */
	private boolean checkRow(int indexX, int indexY, int num)
	{
		for(int i = 0; i<NINE; i++) {
			if (i == indexY)
				continue;
			if (getNumFromCell(btnArr[indexX][i]) == num)
				return false;
		}
		return true;
	}

	/*
	 * Return true if there is no duplicates of 'num' in the same square 3x3 as cell (indexX,indexY). false otherwise.
	 * @param indexX - is the X index of the cell in the sodoko board.
	 * @param indexY - is the Y index of the cell in the sodoko board.
	 * @param num - is the number in the cell (indexX,indexY).
	 * @return true - if there is no duplicates of 'num' in the same square 3x3 as cell (indexX,indexY). false otherwise. 
	 */
	private boolean checkSquare(int indexX, int indexY, int num)	{

		//getting the indexes of the center of the square, whose containing the cell (indexX,indexY).
		int CntrY = findCenterY(indexY); 
		int CntrX = findCenterX(indexX);

		int numfromCell  = -1;
		for(int i = CntrX-1 ; i < THREE; i++) {
			for(int j = CntrY-1 ; j < THREE; j++) {
				numfromCell = getNumFromCell(btnArr[i][j]);
				if(numfromCell != -1 && (i != indexX || j != indexY) && numfromCell == num)
						return false;
				}
		}
		return true;
	}
	
	/*
	 * This method return the Y index of the cell in the center of the square belonging to the cell in (indexX ,indexY).
	 * @param indexY - is the index Y of the original cell in (indexX,indexY). 
	 * @return the Y index of the cell in the center of the square belonging to the cell in (indexX ,indexY).
	 */
	private int findCenterY(int indexY) {
		int row;
		if(indexY < THREE) 
			row = 1;//row 1
		else if(indexY < 6)
			row = 4;//row 4
		else 		
			row = 7;//row 7
		return row;
	}
	
	/*
	 * This method return the X index of the cell in the center of the square belonging to the cell in (indexX ,indexY).
	 * @param indexX - is the index X of the original cell in (indexX,indexY). 
	 * @return the X index of the cell in the center of the square belonging to the cell in (indexX ,indexY).
	 */
	private int findCenterX(int indexX) {
		int col;
		if(indexX < THREE) 
			col = 1;//column 1
		else if(indexX < 6)
			col = 4;//column 4
		else 		
			col = 7;//column 7
		return col;
	}
	
	/*
	 * Return true if there is no duplicates of 'num' in the same square 3x3 , row and column - as cell (indexX,indexY).  otherwise throws exception.
	 * @param indexX - is the X index of the cell in the sodoko board.
	 * @param indexY - is the Y index of the cell in the sodoko board.
	 * @param num - is the number in the cell (indexX,indexY).
	 * @return true - if there is no duplicates of 'num' in the same square 3x3, row and column - as cell (indexX,indexY).  otherwise throws exception.
	 * @throws will throw an error if there is duplicates instances of 'num' in the same a square 3x3, row or column.
	 */
	private boolean isLogicAction(int indexX,int indexY, int num) throws LogicContradictionException
	{
		if( checkColumn(indexX, indexY, num) && checkRow(indexX, indexY, num) && checkSquare(indexX, indexY, num) )
			return true;
		throw new LogicContradictionException();
	}
	
	/*
	 * Return true if there was any change with any prefixed cells, and if so-fixed them to the right value and prompt an error message.
	 * @return true - if there was any change with any prefixed cells, and if so fixed them to the right value and prompt an error message.
	 */
	private boolean tryToChangedFixedNum() {
		
		// create boolean for prompt error in the first time found a changed prefixed cell.  
		boolean first = true; 		
		
		if(!beforeSet)
			for(int i = 0; i < fixedButtonList.size(); i++) {
				if(! ( (fixedButtonList.get(i)).getText() ).equals( (fixedButtonList.get(i)).getStringInCell()) ) 
					if(first) {
						JOptionPane.showMessageDialog(null, "Cannot change prefixed numbers.","Error",JOptionPane.ERROR_MESSAGE );
						first= false;
					}
					(fixedButtonList.get(i)).setFixFont( (fixedButtonList.get(i)).getNum() );
				}
		return (!first);
	}
	
	/*
	 * This method return the number in the cell that attached to 'txt' button. if there is no number in the cell it return -1.
	 * @param txt - is the text button of the current cell.
	 * @return the number in the cell that attached to 'txt' button. if there is no number in the cell it return -1.
	 */
	private int getNumFromCell(TextCell txt){
		try
		{
			String ss = (txt.getText()).trim(); // get text from the cell.
			if(ss.equals("")) {
				txt.reSetFont();
				return -1;
			}
			else
				return isValidDigit(txt);  
		}
		catch (NumberFormatException | IllegalNumberException exp  ) // catch exception if there was any.
		{
			JOptionPane.showMessageDialog(null, "There was incurrect ipnut.","Error",JOptionPane.ERROR_MESSAGE );
			txt.reSetFont();
			return -1;
		}		
	}
	
	/*
	 * This method return the number in the cell that attached to 'txt' button. if there is no number in the cell it return -1.
	 * @param txt - is the button f the current cell.
	 * @return the number in the cell that attached to 'txt' button. if there is no number in the cell it return -1.
	 * @throws will throw an error if the text isn't a valid number 1-9 .
	 */
	private int isValidDigit(TextCell txt) 
			throws IllegalNumberException,NumberFormatException{
		int num = -1;
		String number = (txt.getText()).trim();
		if(number == null ||  number.length() > 1)  
			return -1;
		
		num = Integer.parseInt(number); // turn the digit character to integer type.
		
		if(num <ONE || num > NINE)   // illegal number
			throw new IllegalNumberException();

		return num;			
	}
	
	/*
	 * This private class ButtonNumListener is for all the 81 cells/buttons of the sodoko board for entering inputs.
	 */
	private class ButtonNumListener implements ActionListener {
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			TextCell txt = (TextCell )e.getSource(); // getting the text button that was prompt the event into 'txt'.
			try 
			{
				int num;
				if(!(tryToChangedFixedNum())) {  // check if there was any changes in the prefixed numbers 
					if(( num = isValidDigit(txt)) != -1) { // check if the input is a valid digit between 1-9.
						if (isLogicAction(txt.getIndexX() ,txt.getIndexY() ,  num)) {// check if the there is no duplicates in the same row, column or square.
							
							// legal input
							
							txt.reSetFont(num); 
							
							if(beforeSet) { 
								// entering the button 'txt' and 'num' to the prefixed list of buttons. 
								txt.setNumInCell(num);
								txt.setStringInCell(" "+num);
								fixedButtonList.add(txt);
							}
						}
						else // there was some duplicates
							txt.reSetFont();
					}
					else // the input was invalid.
						txt.reSetFont();
				}
			}
			catch (NumberFormatException | IllegalNumberException exp) 
			{
				JOptionPane.showMessageDialog(null, "Incurrect ipnut- Please enter a digit between 1 - 9.","Error",JOptionPane.ERROR_MESSAGE );
				txt.reSetFont();
			}
			catch (LogicContradictionException exp) 
			{
				JOptionPane.showMessageDialog(null, "Contradiction- check yourselves.","Error",JOptionPane.ERROR_MESSAGE );
				txt.reSetFont();
			}
		}
	}
	
	/*
	 * This private class ButtonListener is for the 2 control buttons 'Set' and 'Clear'.
	 * <p> The "Set" button is setting all the valid digits that was entered before - to be an unchaged digits with different font for recognizing.
	 * <p> The "Clear" is clearing the board from any numbers. And return the board to the starting position.
	 */
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == cmdSet)  // "Set" button
				if(beforeSet) {
					beforeSet = false;
					
					//  setting all the digits that was enter until now to be unchanged.  
					for(int i = 0; i < fixedButtonList.size(); i++)
						(fixedButtonList.get(i)).setFixFont( (fixedButtonList.get(i)).getNum());
				}
				else { // Already set
					JOptionPane.showMessageDialog(null, "Board already set,Cannot set again.","Error",JOptionPane.ERROR_MESSAGE );
				}
				else { // "Clear" button - initialize the board to the start position.
					for(int i = 0; i < NINE; i++)
						for(int j = 0; j < NINE; j++)
						btnArr[i][j].reSetFont();
					while(!(fixedButtonList.isEmpty())) {
						fixedButtonList.remove(0);
					}
					beforeSet = true;
				}
			}
	}
		
	/*
	 * This private class IllegalNumberException is for exceptions of an illegal numbers.
	 */
	private class IllegalNumberException extends Exception {
		/*
		 * Constructs a new IllegalNumberException.
		 */    
		public IllegalNumberException() {
	        super();
	    }
	}

	/*
	 * This private class LogicContradictionException is for exceptions for duplicates numbers that contradict the rules of the sodoko.
	 */
	private class LogicContradictionException extends Exception {
	    /*
		 * Constructs a new IllegalNumberException.
		 */    
		public LogicContradictionException() {
	        super();
	    }
	}

}





