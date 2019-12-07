package ThreadsMatrixMultiolication;

import java.security.SecureRandom;
import javax.swing.JOptionPane;

/**
 * This class manage a multiplication of two matrices A in size nXm and B
 * <p> in size mXp that there sizes are given in the command line as 4 integers.  
 * <p> Then the program initialize the matrices with random numbers.
 * <p> Then it creates nXp threads that each is calculate a single 
 * <p> multiplication of a single row and a single column. Then each thread is 
 * <p> printing his result with the monitor - that print the results in 
 * <p> the right order.
 * 
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class Main {
	// 0....MAX is the range of the random numbers in the matrices   
	private final static int MAX = 10;
	
	public static void main(String[] args) {

		try 
		{
		// check if there is 4 parameters in the commend line
		if ( 4 != args.length ) 
			throw new ArrayIndexOutOfBoundsException();

		// transform the 4 parameters into integers
		int first = Integer.parseInt(args[0]);
		int sec = Integer.parseInt(args[1]);
		int third = Integer.parseInt(args[2]);
		int fourth = Integer.parseInt(args[3]);
			
		// check if all integers are positive
		if ( first <= 0 || sec <= 0 || third <= 0 || fourth <= 0 ){
			JOptionPane.showMessageDialog(null, "The parameters must be positive! ","Error",JOptionPane.ERROR_MESSAGE );
			return;
		}

		// creates the 2 matrices 
		int[][] matA = new int [first][sec];
		int[][] matB = new int [third][fourth];
		int tmp;
		
		// check if the rows in the first matrix are equals to the columns in the second matrix
		if (!(args[1].equals(args[2]))) {
			JOptionPane.showMessageDialog(null, "The length of the rows in the first matrix\nMust be the same as the length of the column in the second matrix","Error",JOptionPane.ERROR_MESSAGE );
			return;
		}
		
		// creates a SecureRandom object for creating random numbers 
		SecureRandom randomNumbers = new SecureRandom();
		
		// initialize the first matrix and print it to the standard output
		System.out.print("Matrix A: ");
		for (int i = 0 ; i < matA.length; i++) {	
			System.out.print("\n [");
			for (int j = 0 ; j < matA[0].length; j++) {
				tmp = randomNumbers.nextInt(MAX);
				matA[i][j] = tmp;
				if (j != matA[0].length-1)
					System.out.print(tmp+ ", ");
				else
				System.out.print(tmp +"]");		
			}
		}	

		// initialize the second matrix and print it to the standard output
		System.out.print("\n\nMatrix B: ");
		for (int i = 0 ; i < matB.length; i++) {	
			System.out.print("\n [");
			for (int j = 0 ; j < matB[0].length; j++) {
				tmp = randomNumbers.nextInt(MAX);
				matB[i][j] = tmp;
				if (j != matB[0].length-1)
					System.out.print(tmp+ ", ");
				else
				System.out.print(tmp +"]");		
			}
		}
	
		// creates the thread that will activate all the calculations
		ManagerThread man = new ManagerThread(matA , matB);
		man.start();
		
		}
		catch(ArrayIndexOutOfBoundsException | NumberFormatException e ){ 
			JOptionPane.showMessageDialog(null, "comand line parameters must be 4 positive integers\n for the sizes of the 2 metrices","Error",JOptionPane.ERROR_MESSAGE );
		}
	}
}


