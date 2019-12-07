package Reminder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

/**
 * This class is for a FilePanel objects, this class is asking for the user to choose between
 * two options - "Import an Existing file" or "Creates a new file".
 * And after the selection it present a separator and the name of the file. 
 * Additionally it contain the hash table of all the reminders.
 * And as a references to the control buttons and the text panel  of the program, - this is mainly for
 * disable them if the date is not fully determine , And vice versa for enable them if the date is 
 * fully determine.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *  
 */
@SuppressWarnings("serial")
public class FilePanel extends JPanel{
	private JLabel  lblFileName; // the file name-where the hash table of the reminders is.
	private JCheckBox cmdImportFile; // button for importing an existing file/
	private JCheckBox cmdNewFile; // creating a new file
	private ButtonGroup grp;  // button group for the two file chooser buttons
	private JPanel fileNamePanel; // a panel for storing and display the file name that chosen by the user
	private JLabel  lblChooseFile; // title for choosing a the reminder file
	private File reminderFile; // file for storing the hash table of reminders
	private DatePanel datePnl; // a DatePanel for this program
	private HashMap<MyDate,String> hash;
	
    /*
     * Constructor for FilePanel - that get a reference to the date panel
     * @param _datePnl - a DatePanel object for passing a reference for an existing DatePanel .
     */
	@SuppressWarnings("unchecked")
	public FilePanel(DatePanel _datePnl) {
		
		// initializing this DatePanel instance variable to be the reference that was given as parameter.
		datePnl = _datePnl;
		
		// initializing the hash table
		hash = new HashMap<MyDate,String>(10);
		
		this.setLayout(new BoxLayout(this,  BoxLayout.Y_AXIS));
		
		Font interfaceFont = new Font("Arial",Font.PLAIN+Font.BOLD, 14);
		
		//create a new listener for choosing the file 
		ButtonFileListener fileListener = new ButtonFileListener();
		
		// Initialize the file components
		lblChooseFile = new JLabel("Please pick one of the folowing: ");
		cmdImportFile = new JCheckBox("Import Exist Reminder File");
		cmdNewFile = new JCheckBox("Create A New Reminder File");
		lblFileName = new JLabel("File Name: ");
		
		// add under-line to the title
		Map<TextAttribute, Integer> attributes = (Map<TextAttribute, Integer>) interfaceFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		attributes = (Map<TextAttribute, Integer>) interfaceFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblChooseFile.setFont(interfaceFont.deriveFont(attributes));
		
		// add listener for the two file choosing buttons
		cmdImportFile.addActionListener(fileListener);
		cmdNewFile.addActionListener(fileListener);
	
		// create a new button group - for the two file choosing buttons 
		grp = new ButtonGroup(); 
		
		// adding the two file choosing buttons to the group - that implies just one choice
		grp.add(cmdNewFile);
		grp.add(cmdImportFile);
		
		// setting font
		cmdNewFile.setFont(interfaceFont);
		cmdImportFile.setFont(interfaceFont);
		
		// setting color
		cmdNewFile.setForeground(Color.BLUE);
		cmdImportFile.setForeground(Color.BLUE);
		lblChooseFile.setForeground(Color.BLUE);
		
		// creating 3 JPanels - for the file choosing interface
		fileNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel fileButton1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel fileButton2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel fileButton3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				
		// adding each component to distinct JPanel
		fileButton1.add(lblChooseFile);
		fileButton2.add(cmdNewFile);
		fileButton3.add(cmdImportFile);
		fileNamePanel.add(lblFileName);
		
		// add the three panels to this ReminderPanel
		add(fileButton1);
		add(fileButton2);
		add(fileButton3);
		
		// add separator
		add(new JSeparator(SwingConstants.HORIZONTAL));
		
		// add the file name panel
		add(fileNamePanel);
	}
	
	/*
	 * Return a reference to the file of this object.
	 * @return a reference to the file of this object.
	 */
	public File getReminderFile() {
		return reminderFile;
	}
	/*
	 * Return a reference to the hash table of this object.
	 * @return a HashMap<MyDate,String> object that is a reference to the hash table of this object.
	 */
	public HashMap<MyDate,String> getHash() {
		return hash;
	}
	
	/*
	 * This private class ButtonCtrlListener is for the 4 control 
	 * buttons- <p> 'Save'  ,  'Get Reminder'  , 'New File' and 'Import File'.
	 * <p> The "Save" - button for update a reminder of a specific date
	 * <p> The "GetReminder" - button for getting a reminder of a specific date
	 * <p> The "cmdImportFile" - button for importing an existing file
	 * <p> The "cmdNewFile" - button for creating a new file
	 */
	private class ButtonFileListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		 {
			// create a new FileReadWriteHashMap 
			FileReadWriteHashMap fileRW = new FileReadWriteHashMap();
			
			 if(e.getSource() == cmdImportFile) { // "Get Reminder" button
				reminderFile = fileRW.getFile(); // Opening an existing file 
				boolean setFile = false;
				
				if(reminderFile  != null) {
					// import file succeeded
					fileIsSet(reminderFile.getName(), "Import file succeeded");
					
					try { // initializing the hash to be the current hash from the file 
						hash = fileRW.readHashMap(reminderFile); // read from the file and getting the hash table 
						setFile = true;
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"Error! Please check again if the file is a Reminder file!\n Recomend action - Exit the program", "Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}	
				}
			    if(!setFile)
			       	grp.clearSelection();
			}
			else if(e.getSource() == cmdNewFile) { // "New File" button
				
				// getting from the user a name for the new file
				String fileName = JOptionPane.showInputDialog(null, "Enter file path:");
				boolean setFile = false;
				if(fileName != null) {
					
		            try{
	                	reminderFile = fileRW.createFile(fileName); // create a new file
	                	if(reminderFile  != null)
	                		// creating new file succeeded
	                 		fileIsSet(fileName,"Reminder File Created");
	            		    
	            		    // write an empty hash table into the new file
	            		    fileRW.writeHashMap(reminderFile, hash);
	                		setFile = true;
	 				}
	                catch(IOException ex){
	                	JOptionPane.showMessageDialog(null,"Error with creating the file!\nPlease check again -\n  1) If the file name is valid.\n  2) If a file with the same name\n     already exists at the same directory.", "Error",JOptionPane.ERROR_MESSAGE);
	                }  
		        }	
			    if(!setFile)
			       	grp.clearSelection();
			}
		}
		
		/*
		 * This method is activate after initializing correctly the 
		 * <p> file which supposably contain the hash table.
		 * <p> This method prompt a message - notify the user about 
		 * <p> the succeeded load or create a file.
		 * <p> it is set the name of the file as label in the GUI
		 * <p> it disable the "Import File" , "New File" buttons.
		 * <p> and it enable the ComboBoxs of months and years.
		 * @param fileName - the name of the file.
		 * @param msg - the message for notify the user.
		 */
		public void fileIsSet(String fileName, String msg) {
			JOptionPane.showMessageDialog(null, msg);
			lblFileName.setText("Reminder File: "+ fileName);
			cmdImportFile.setEnabled(false);
			cmdNewFile.setEnabled(false);
			lblChooseFile.setForeground(Color.LIGHT_GRAY.darker());
			datePnl.readyForInput();
			fileNamePanel.setBackground(Color.orange);
		}
	}
	
	
}
