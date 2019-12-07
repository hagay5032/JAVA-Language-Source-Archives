package Quiz;

import java.security.SecureRandom;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


/**
 * This class is a quiz with questions. That each question has four 
 * answers to choose from.
 * <br> 
 * The input for this quiz needs to be in Exam.txt file. 
 * Each question followed with 4 answers that just the first answer is correct.
 * <br>
 * Then the program will be responsible for randomize the places of the answers. 
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
@SuppressWarnings("serial")
public class JPanelQuiz extends JPanel 
{	
	private JButton cmdSubmit; 				// Create the submit button. 
	private JButton cmdReset; 				// Create the Reset button.
	private ArrayList<ButtonGroup> arr; 	// Array list of all ButtonGroups.
	private JRadioButton[] btnsTmpArray; 	// Create an array of Button.
	private ButtonGroup btnGroup; 			// Create a ButtonGroup.
	private SecureRandom randomNumbers; 	// Random number generator.
	private final int MAX = 100; 			// MAX is for creating a random - 
	private final int NUM_OF_ANSWERS = 4; 	// MAX is for creating a random - 
											// number between 0 - MAX.
	
	/*
	 * Construct a JPanelQuiz object. 
	 */
	@SuppressWarnings("resource")
	public JPanelQuiz() 
	{	
		Scanner input = null;
		String line = null; 				// holds line from the text file. 
	    int counter = 0; 					// count the number of questions. 
	    int len = 0; 						// the number of options of answers.
	    int rand = 0; 						// random number for placing the answers.
	    JLabel lblQuestion = null; 			// label holds the question.
	    JPanel jplQuestion = null; 			// panel for each question.
	    JPanel jplButtons = new JPanel(); 	// panel for the buttons. 

		// initialize the ButtonGroup array
		arr = new ArrayList<ButtonGroup>();
		this.setLayout(new BoxLayout(this,  BoxLayout.Y_AXIS));
		
		// initialize the 2 buttons "Submit" and "Reset"
		cmdSubmit = new JButton("Submit");
		cmdReset = new JButton("Reset");
		
		// create random number generator
		randomNumbers = new SecureRandom(); 
	    
    	try
    	{
		    input = new Scanner(new File("exam.txt")).useDelimiter("\n");
		    
		    while(input.hasNext()) 
		    { 
				line = input.next();	
				counter++;
				
				jplQuestion = new JPanel();
				lblQuestion = new JLabel(counter+". "+line);

				// create an array of radio buttons
				btnsTmpArray = new JRadioButton[NUM_OF_ANSWERS]; 
				
				for(int i = 0; i< NUM_OF_ANSWERS && input.hasNext(); i++)
				{
					btnsTmpArray[i] = new JRadioButton(input.next());
				}
				
				// initialize the buttons for the answers
				btnGroup = new ButtonGroup();
				
				btnsTmpArray[0].setActionCommand("Correct"); // the first  
				
				 rand =  randomNumbers.nextInt( MAX );
				 len = btnsTmpArray.length;
				 
				 // placing the answers in a random why in the ButtonGroup object.
				for (int i = 0; i < len; i++) 
				{
					btnGroup.add( btnsTmpArray[i]);
					jplQuestion.add(btnsTmpArray[(rand+i) % len]);
				}
				
				// add the new ButtonGroup to the list of all ButtonGroup.
				arr.add(btnGroup); 
				
				jplQuestion.setAlignmentX( Component.LEFT_ALIGNMENT );
				
				add(lblQuestion);
				add(jplQuestion);
				add(new JSeparator(SwingConstants.HORIZONTAL));
			}
		    input.close();
		}
    	catch(IOException excp)
		{
			System.err.printf("%nException: %s%n", excp);
			System.out.println("Problem with finding or loading the file - exam.txt");
		}
    	
    	// create a listener for the "Submit" and "Reset" buttons.
    	ButtonListener ctrlBtn = new ButtonListener();
    	
    	// attach the listener to the two control buttons.
    	cmdSubmit.addActionListener(ctrlBtn);
    	cmdReset.addActionListener(ctrlBtn);
    	
    	// attach the two control buttons to the button's panel.
    	jplButtons.add(cmdSubmit);
    	jplButtons.add(cmdReset);
    	
    	// this JPanelQuiz instance attach the 'jplButtons' - that is the button's panel.
    	add(jplButtons);
	}
	
	/*
	 * This private class ButtonListener is for the two control buttons - 
	 * "Submit" and "Reset".
	 */
	private class ButtonListener 
			implements ActionListener{ 
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			boolean err = false;  // Boolean that is false if there is no errors, true otherwise.
			String res = ""; 	  // String that will holds the result for theuser.
			String strError = ""; // String that will collect the mistakes.
			int correctAnswerCount = 0; 	// Counter for the correct answer
			ButtonModel tmp;  	  
			
			if (e.getSource() == cmdSubmit) // if the event was a press on the "Submit" Button. 
			{ 
				
				// running over all the ButtonGroups and getting the answers
				for(int i = 0 ; i < arr.size() ; i++) {
			
					tmp = arr.get(i).getSelection();
			
					if(tmp == null) { // the question is still unanswered
						if(!err) { 
							strError = String.valueOf(i+1); 
							err = true; // this is the first error
							}
						else
							strError += " ," + (i+1);	
					}
					else if (!err) // there was no errors until this point
						if(tmp.getActionCommand() != null ) //check if the choosen answer is the correct one
						{
							res += String.valueOf(i+1) +". "+ tmp.getActionCommand()+"\n";
							correctAnswerCount++;
						}
						else //Correct
							res += String.valueOf(i+1) +". wrong\n";
				}	
				if(!err) // if there was any mistakes - prompt a message error window to the user
					JOptionPane.showMessageDialog(null, res+"Your score is- "+ (int)(((double)correctAnswerCount/arr.size())*100));
				else // all question was answered
					JOptionPane.showMessageDialog(null, "Please answer questions number- \n"+ strError,"Error",JOptionPane.ERROR_MESSAGE );
			}
			else // it is the "Reset" button.
			{
				for(int i = 0 ; i < arr.size() ; i++) 
					arr.get(i).clearSelection();
			}
		}
	}
}


