package Reminder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is for a DatePanel objects, that is presented to the user as
 * 3 ComoboBoxs for choosing the year, month, and day.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *  
 */
@SuppressWarnings("serial")
public class DatePanel extends JPanel{

    private JComboBox<String> comboDays ,comboMonths ,comboYears;// 3 ComboBox for getting the date
    private boolean yearSelected; // true - if a year is selected in the ComboBox, false otherwise
    private boolean monthSelected; // true - if a month is selected in the ComboBox, false otherwise
    private MyDate date; // will hold the current date that Represented by the 3 comboBox of the date 
    private JLabel lblDate; // "Date" label
    private JLabel  lblSlash1; // just slash( nothing special )
    private JLabel  lblSlash2; // just slash( nothing special )
   
    //****************************** instance variables that passing as a references *****************************//
    
    private JButton cmdSave; // button for update a reminder of a specific date
    private JButton cmdGetReminder; // button for getting a reminder of a specific date
    private TextPanel textPnl ; // a panel text for this program 
    
    /*
     * Constructor for DatePanel - that get a references to the control buttons and the text panel
     * @param _textPnl - a TextPanel object for passing a reference for an existing TextPanel.
     * @param _cmdSave - a JButton object for passing a reference for an existing JButton.
     * @param _cmdGetReminder - a JButton object for passing a reference for an existing JButton.
     */
    public DatePanel(TextPanel _textPnl, JButton _cmdSave, JButton _cmdGetReminder) {
    	  
		// initializing all this instance variables to be the suitable reference that was given as parameter.
    	textPnl = _textPnl;
    	cmdSave =_cmdSave;
    	cmdGetReminder = _cmdGetReminder;

		// initializing the date
		date = new MyDate();
    	
    	Font interfaceFont = new Font("Arial",Font.PLAIN+Font.BOLD, 14);
		 	
		// Create and initialize 3 list of choices to the 3 ComboBoxs
		String[] years = new String[100]; 
		String[] months = {"Select Month","1","2","3","4","5","6","7","8","9","10","11","12"}; 
		String[] days = new String[1];
		days[0] = "Select Day";
		years[0] = "Select Year";
		for(int i = 1; i < 100; i++)
			years[i] = ""+(2000+i);
		
		// Initialize the Date components
		lblDate = new JLabel("Date: ");
		lblSlash1 = new JLabel("  /  ");
		lblSlash2 = new JLabel("  /  ");
		comboDays = new JComboBox<String>(days);
		comboMonths = new JComboBox<String>(months);
		comboYears = new JComboBox<String>(years);
		
		// setting font
		comboDays.setFont(interfaceFont);
		comboMonths.setFont(interfaceFont);
		comboYears.setFont(interfaceFont);
		lblDate.setFont(interfaceFont);
		lblSlash1.setFont(interfaceFont);
		lblSlash2.setFont(interfaceFont);
		
		// setting all 3 ComboBoxs to be disabled until a file had been chosen
		comboMonths.setEnabled(false);
		comboYears.setEnabled(false);
		comboDays.setEnabled(false);
		
		// create a new listener for the three ComboBoxs
		ButtonDateListener listner = new ButtonDateListener();
		
		// add listener for the three ComboBoxs
		comboYears.addActionListener(listner);
		comboMonths.addActionListener(listner);
		comboDays.addActionListener(listner);
		
		// add the 3 ComboBoxs to this panel
		add(lblDate);
		add(comboDays);
		add(lblSlash1);
		add(comboMonths);
		add(lblSlash2);
		add(comboYears);
    }
	
	/*
	 * Return a reference to the date of this object.
	 * @return a reference to the date of this object.
	 */
    public MyDate getMyDate() {
    	return date;
    }
    
    /*
	 * This method is called after a file was initialize successfully.
	 * Then this method change the years and months to be editable and
	 * <p> change the color of this panel.
	 */
	public void readyForInput() {
		comboYears.setEnabled(true);
		comboMonths.setEnabled(true);
		setBackground(Color.green);
		textPnl.setBackground(Color.yellow);
	}
    
	/*
	 * This private class ButtonDatelListener is for the 3 ComboBoxs 
	 * <p> buttons- each selected entry is determine the suitable part of the date
	 * <p> and all three together combine a full valid date.
	 */
	private class ButtonDateListener implements ActionListener{
		 
		// creating an array of string with one entry - for the disable days-ComboBox 
	 	 private String[] days = {"Select Day"} ; 
		
		public void actionPerformed(ActionEvent e)
		 {
			 if(e.getSource() == comboYears) { // year selected
				 
				// getting the selected year
				 String str = (String)comboYears.getSelectedItem();
				 if (str.equals("Select Year")) { // not a year 
					 yearSelected = false;
					 
					 // set the days ComboBox to be disable
					 comboDays.setModel( new DefaultComboBoxModel<String>(days));
					 comboDays.setEnabled(false);
				 }
				 else{
					// a year was selected
					 yearSelected = true;
					 int y = Integer.parseInt( str); 
					 date.setYear(y); // setting the current year in the date
					 
					if(monthSelected) { 
						// if a valid month is also selected, then - setting the days-ComboBox
						// with the appropriate number of days that suitable for this year and month.
						setDaysInCombo();
					}
				 }
				 // after choosing a year the days is still unchosen, 
				 // then - disable all buttons that needs the date to be complete
				 setDateIsIncomplit();
			 }
			 else if(e.getSource() == comboMonths) { // month selected
				 
				// getting the selected month
				 String str = (String)comboMonths.getSelectedItem();
				 if (str.equals("Select Month")) {
				 	 monthSelected = false;
					 
				 	 // set the days ComboBox to be disable
				 	 comboDays.setModel( new DefaultComboBoxModel<String>(days));
				 	 comboDays.setEnabled(false);
				 } 
				 else {
					// a month was selected
					 monthSelected = true;
					 int m = Integer.parseInt( str);
					 date.setMonth(m);// setting the current month in the date
					 if(yearSelected) { 
						 // if a valid year is also selected , then - setting the days-ComboBox
						 // with the appropriate number of days that suitable for this year and month.
						 setDaysInCombo();	 
					 }
				 }
				 // after choosing a month the days is still unchosen, 
				 // then - disable all buttons that needs the date to be complete
				 setDateIsIncomplit();    
			 }
			 else if(e.getSource() == comboDays) { // day selected
				 
				 // getting the selected day
				 String str = (String)comboDays.getSelectedItem();
				 if (str.equals("Select Day")) // not a day 
					 setDateIsIncomplit();
				 else {
					 // a day was selected !!!    NOW THE DATE IS COMPLETE !
					 int d = Integer.parseInt( str);
					 date.setDay(d); // setting the current day in the date
					 textPnl.setMyTitle("Riminder:    "+date); // setting the valid date in the border title
					 repaint();
					 
					 // setting the "Save" and "Get Reminder" enable , and the text to be editable with empty string
					 cmdGetReminder.setEnabled(true); 
					 cmdSave.setEnabled(true);
					 textPnl.setTextEditable(true);
				 }
			 }   
		 }
		 
		/*
		 * This method is activate after initializing correctly and fully 
		 * <p> the date in the three ComboBoxs of the date section.  
		 * <p> It is set the title of the border to with out any date.
		 * <p> It disable the "Save" and  "Get Reminder" buttons.
		 * <p> It set the text area to be uneditable with an empty string.
		 * <p> And it enable the ComboBoxs of months and years.
		 */
		 private void setDateIsIncomplit() 
		 {
			 textPnl.setMyTitle("Riminder:     ");
			 textPnl.setTextEditable(false);
			 repaint();
			 cmdGetReminder.setEnabled(false);
			 cmdSave.setEnabled(false);
		 }
		 
		 /*
		  * This method is activate after there is a selected month and year 
		  * <p> in the ComboBoxs (of year and month) - and calculate the number of days 
		  * <p> that should be in this specific month and year. It set the days-ComboBox enable 
		  * <p> with a list of days that was calculated for this time - month and year.
		  */
		 private void setDaysInCombo() {
			 /*
			  this array represent the number of days in each month of the year. For example the
			  first value in the array is 31 - that mean that in the first month of the year 
			  there is 31 days */
			 int DaysiInMonts[] = {31,28,31,30,31,30,31,31,30,31,30,31};
			 
			 int num, m;
			 
			 // calculating if this is a special month that there is 29 days in it
			 if( (m = date.getMonth()) == 2 && isLeapYear(date.getYear()))
					num = 29;
			 else
				num = DaysiInMonts[m-1];
			 
			// create the new days list size as 'num+1' for the "Select Day"
			 String[] days = new String[num+1]; 
			 
			 // initializing the string array with the appropriate sum of days
			 days[0]="Select Day";
			 for(int i = 1; i < num+1 ; i++)
				 days[i]= ""+i;

			 // setting the list of entries in the days-ComboBox
			 comboDays.setModel( new DefaultComboBoxModel<String>( days ));
			 
			 // set enable the days-ComboBox
			 comboDays.setEnabled(true);
		 }
		 
		 /*
		  * Return true if the year given as parameter is a leap year; false otherwise.
		  * @return true - if the year given as parameter is a leap year; false otherwise.
		  */
		 private boolean isLeapYear(int year) {
			if(( year%4 == 0 && year%100 != 0 ) || year%400 == 0 )
				return true;
			return false;	
		 }
	
	}
 
}
