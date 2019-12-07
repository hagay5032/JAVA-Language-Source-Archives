package Reminder;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is for a TitlePanel objects, creates a big title with under line beneath. 
 * 
 * @author Hagay Enoch
 * @version 203089917
 *  
 */
@SuppressWarnings("serial")
public class TitlePanel extends JPanel{

	public TitlePanel() {

		// creates a JLabel that will contain the title
		JLabel lblTitle =new JLabel("Best Reminder Ever -   Not To Forget A Thing! "); 
		Font titleFont = new Font("Arial",Font.ITALIC+Font.BOLD, 18);
		
		// add under-line to the title
		@SuppressWarnings("unchecked")
		Map<TextAttribute, Integer> attributes = (Map<TextAttribute, Integer>) titleFont.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblTitle.setFont(titleFont.deriveFont(attributes));
		
		// add title to the panel
		add(lblTitle);
	}
	
}
