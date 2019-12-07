package Reminder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.JFileChooser;

/*
 * This class is for managing and control the readind/writing 
 * the hash table object into/from the file that is store this hash table as an object.
 * 
 * @author Hagay Enoch
 * @version 203089917
 */
public class FileReadWriteHashMap {

   /*
	* This method writes a hash table object into a file.
	* @param f - is the file to write to it the hash table.
	* @param hash - if the hash table.
    */
	public void writeHashMap(File f, HashMap<MyDate, String > hash) throws IOException
	    {
		// creating a piped output stream the will store serialized objects
		ObjectOutputStream out = new ObjectOutputStream 
							(new FileOutputStream(f));

	    out.writeObject(hash);
		out.close();
	    }
	  
	/*
	 * This method get a file supposed to be a file that contain a hash table of the reminders.
	 * and read the hash table from the file and return the hash table as an object. 
	 * @param f - is the file to get the hash table.
	 * @return an hash table as an object.
	 * @throw IOexception - if there was a problem with loading the hash table object,
	 *  or any other malfunction with the file system
	 */	  
	@SuppressWarnings("unchecked")
	public HashMap<MyDate, String > readHashMap(File f) throws IOException
	{
		@SuppressWarnings("resource")
		ObjectInputStream in = new ObjectInputStream
	                            (new FileInputStream(f));
	    HashMap<MyDate, String > map = null;
	    try 
	    {
	      	map = (HashMap<MyDate, String>) in.readObject();
	    }
	    catch(ClassNotFoundException e){}
	    return map;
	}

	/*
	 * This method get a file name with or without a path and try to create a file in the
	 * specified path .
	 * @param fileName - is the file name with or without a path.
	 * @return a new created file if succeeded; null otherwise, and prompt error message;
	 */
	public File createFile(String fileName) throws IOException
	{
		File f = new File(fileName);
	    if(f.createNewFile())
	      	return f;
	     return null;
	}
	
	/*
	 * This method is asking form the user to select an existing reminder file.
	 * @return a new file that is just created in the file system.
	 */
	public File getFile()
	{
		File currentDir = new File("C://");
		JFileChooser fc = new JFileChooser(currentDir );
	    fc.showOpenDialog(null);
	    return fc.getSelectedFile();
	}
	
}
