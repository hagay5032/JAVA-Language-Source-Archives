package Reminder;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * This class is for a DatePanel objects, that is presented to the user as
 * 3 ComoboBoxs for choosing the year, month, and day.
 * 
 * @author Hagay Enoch
 * @version 203089917
 *  
 */
@SuppressWarnings("serial")
public class TextPanel extends JPanel{
	private TitledBorder ttlBorder; // title for the border
    private EtchedBorder border; // a border for the text area
    private JTextArea jtxt; // text are for entering remainders and get ones.
    
    /*
     * Constructor for TextPanel.
     */
	public TextPanel() {
		
		// initializing the text area
		jtxt = new JTextArea( 16, 58);
		
		Font interfaceFont = new Font("Arial",Font.PLAIN+Font.BOLD, 14);
		
		// create a new panel for the text area
		Font borderFont = new Font("Arial",Font.ITALIC+Font.BOLD, 14);
		
		// create a new border on the text area with title
		border = new EtchedBorder (); 
		ttlBorder = new TitledBorder(border, "Riminder:     ") ;
		ttlBorder.setTitleFont(borderFont );
		setBorder( ttlBorder);
		
		// initialize the text area
	
		jtxt.setEditable(false);		
		jtxt.setFont(interfaceFont);
		
		// add a scroll to the text area
		JScrollPane scroll = new JScrollPane(jtxt);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
		// adding the scroll to the text panel
		add(scroll);
	}
	
	/*
	 * Return a reference to the text area of this object.
	 * @return a reference to the text area of this object.
	 */
	public JTextArea getJText() {
		return jtxt;
	}
	
	/*
	 * Set the title of the border of the text area component.
	 * @param str - is the new title of the border of the text area component.
	 */
	public void setMyTitle(String str) {
		ttlBorder.setTitle(str);
	}
	
	/*
	 * Set the text area component as editable or not , determine by the boolean parameter.
	 * <p> true - for editable,  false - for uneditable. 
	 * @param bool - is a boolean parameter determine if text area component as editable or not 
	 * <p> true - for editable,  false - for uneditable.
	 */
	public void setTextEditable(boolean bool) {
		jtxt.setEditable(bool);
		jtxt.setText("");
	}
	
}

