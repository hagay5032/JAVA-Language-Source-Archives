package Reminder;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.util.HashMap;

/**
 * This class is for creating a Controller Panel included elite GUI and 
 * many cool stuff - "event-oriented" scenarios. 
 * Ths class give the user a convenient way for creating reminders files, or imports 
 * an existing reminders file. 
 * All the reminders are store in a serialized file as a hash table, that the date is 
 * the key and the reminders are the values of the hash table.
 * 
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
@SuppressWarnings("serial")
public class ControllerPanel extends JPanel{
	
    private JButton cmdSave; // button for update a reminder of a specific date
    private JButton cmdGetReminder; // button for getting a reminder of a specific date
    private TextPanel txtPnl; // text are for entering remainders and get ones.
    private FilePanel filePnl; // file panel that dealing with all the file managements.
    private DatePanel datePnl;// file panel that dealing with all the date managements.
    
    /*
     * Create a new ControllerPanel object 
     */
    public ControllerPanel() {  
	
		this.setLayout(new BoxLayout(this,  BoxLayout.Y_AXIS)); 
		
		// create a new listener for the control buttons
		ButtonCtrlListener ctrlListener = new ButtonCtrlListener();
		
		// initialize the to Buttons 'Save' and 'Get Reminder' 
		cmdSave = new JButton("Save");
		cmdGetReminder = new JButton("Get Reminder");		
		
		// setting the 2 control buttons to be disabled until the current date is a valid date
		cmdSave.setEnabled(false);
		cmdGetReminder.setEnabled(false);
		
		// add listener for the two control buttons
		cmdSave.addActionListener(ctrlListener);
		cmdGetReminder.addActionListener(ctrlListener);
		
		// create a new panel for the control buttons
		JPanel ctrlPanel = new JPanel();
		ctrlPanel.add(cmdSave);
		ctrlPanel.add(cmdGetReminder );
		
    	//************************************** TITLE PANEL ***************************//
		// initializing the title panel
		TitlePanel titlePnl  = new TitlePanel();
		
		//************************************** TEXT PANEL ***************************//		
		
		// initializing the text management panel
		txtPnl = new  TextPanel();

		//************************************** DATE PANEL ***************************//		
		
		// initializing the date management panel
		// and passing a reference to the control buttons and the text panel
		datePnl = new DatePanel(txtPnl , cmdSave , cmdGetReminder);

		//************************************** FILE PANEL ***************************//

	    // initializing the file management panel
		// and passing a reference to the date panel
		filePnl = new FilePanel(datePnl);

		//******************************************************************//
				
		// add all panels to this ControllerPanel 
		add(titlePnl);
		add(filePnl);
		add(datePnl);
		add(txtPnl);
		add(ctrlPanel);
	
	} // end of constructor for ControllerPanel
	
	/*
	 * This private class ButtonCtrlListener is for the 4 control 
	 * buttons- <p> 'Save'  ,  'Get Reminder'  , 'New File' and 'Import File'.
	 * <p> The "Save" - button for update a reminder of a specific date
	 * <p> The "GetReminder" - button for getting a reminder of a specific date
	 * <p> The "cmdImportFile" - button for importing an existing file
	 * <p> The "cmdNewFile" - button for creating a new file
	 */
	private class ButtonCtrlListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		 {
			// create a new FileReadWriteHashMap 
			FileReadWriteHashMap fileRW = new FileReadWriteHashMap();
			
			// getting a reference to the hash table from the file panel
			HashMap<MyDate, String> hash = filePnl.getHash(); 
			
			// getting a reference to the file from the file panel
			File remindrFile = filePnl.getReminderFile(); 
			
			// getting a reference to the text area from the text panel
			JTextArea jtxt = txtPnl.getJText();
			
			// getting a reference to the text area from the date panel
			MyDate date =  datePnl.getMyDate();
			
			if(e.getSource() == cmdSave) { // "Save" button
				String str = jtxt.getText(); // get text from the text button
				
				// NOTICE: must to create a new MyDate file , for the sake of not creating an aliasing !
				hash.put(new MyDate(date), str);// put the text in the hash table with the current date as key
				try {
					fileRW.writeHashMap(remindrFile, hash); // write the hash table into the current file
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == cmdGetReminder) { // "Get Reminder" button
				String str = hash.get(date); // getting a reminder from the hash table corresponding to this date 
				jtxt.setText(str); // set the reminder on the text area
				repaint(); // repaint the text area for showing the updated text area 
 			}
		}
	}
	
	
}
