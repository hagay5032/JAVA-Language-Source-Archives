package Quiz;

import java.io.IOException;

import javax.swing.*;


public class Main {
	
	public static void main(String[] args) 
			throws IOException
	{
	
		JFrame frame = new JFrame("Sea Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
	      	    
		JPanelQuiz p = new JPanelQuiz();       

        frame.add(new JScrollPane(p));
		frame.setVisible(true);
	} 
}