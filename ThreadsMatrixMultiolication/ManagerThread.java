package ThreadsMatrixMultiolication;

import java.time.Duration;
import java.time.Instant;

/**
 * This class is for creating one thread for calculating how much time in milliseconds,
 * this program run. And manage the distribution of work between all nXp calculate-threads, 
 * And execute them. After all threads finish to print there results then this 
 * thread print the time it took for all the calculations.
 * 
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class ManagerThread extends Thread {
	
	private int[][] matA; // reference to the first matrix
	private int[][] matB; // reference to the second matrix	
	
	/*
	 * Creates a managerThread that gets a references to the 2 matrices
	 * @param _matA - is a reference to the first matrix.
	 * @param _matB - is a reference to the second matrix.
	 */
	public ManagerThread(int[][] _matA, int[][] _matB){
		matA= _matA;
		matB = _matB;
	}
	
	@Override
	public synchronized void run() 
	{			
		Instant startTime = Instant.now();
	
		// creates the nXp threads
		createsWorker();
		
		try { wait();} // wait until the last thread will finish to print his calculation
		catch(InterruptedException e) {}
		
		Instant endTime = Instant.now();
	
		System.out.println("\n\n Total time in milliseconds: "+ Duration.between(startTime, endTime).toMillis());
	}
	
	/*
	 * A method to wake this object up.
	 */
	public synchronized void wakeUp()
	{
		notifyAll();
	}
	
	
	/*
	 * This method creates all the nXp threads that there printed results
	 * will assemble the matrix of results.
	 */
	public void createsWorker() {
		
		// creating a new Monitor for passing as reference to all calculate-threads
		Monitor M = new Monitor(matA, matB, this);
		
		// creating an integer that will pass to each thread and will be the 
		// thread turn number for printing in the monitor. 
		int threadNum = 0;		
		
		System.out.print("\n\nProduct Matrix Result: ");	
		
		/* create the nXp threads each is given a single row and column to
		 *  calculate  the sum of the multiplication and prints the results 
		 *  in the right order as the passing argument - 'threadNum' 
		 */
		for (int i = 0; i < matA.length; i++) {
			for (int j = 0; j < matB[0].length; j++) {	
				
			// creates a new threads and execute its  
			(new CalculatThread(matA, matB, i, j, threadNum, M)).start();
				
				threadNum++;
			}
		}
	}
	
}










