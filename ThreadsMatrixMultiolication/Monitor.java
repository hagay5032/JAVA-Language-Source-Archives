package ThreadsMatrixMultiolication;

/**
 * This class is manage the printing of CalculatThreads and prints the results 
 * <p> in the right order.  
 *  
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class Monitor {
	
	private int turnNumber; // counter for which of the threads is the next to print 
	private int lastThreadNum; // the number of the last thread
	private int[][] matA; // the first matrix
	private int[][] matB; // the second matrix
	private ManagerThread man; // reference to the manager-thread for wake him up

	/*
	 * Creates a new Monitor object.
	 * @param _matA - is a reference to the first matrix.	 
	 * @param _matB - is a reference to the second matrix. 
	 * @param _man - is a reference to the manager-thread. 
	 */
	public Monitor (int[][] _matA, int[][] _matB, ManagerThread _man) {
		man = _man;
		matA = _matA; 
		matB = _matB; 
		turnNumber = 0;
		lastThreadNum = (matA.length*matB[0].length)-1; // number of the last thread 
	}
	
	/*
	 * This method prints a result of a calculatThread in the order that the threads 
	 * created. And all the results will assemble a matrix that will be the result of
	 * the multiplication between the two matrices.
	 * @param threadNum - this number - is like a ticket-number to this thread turn to print his result.
	 * @param res - this number is the calculated result for printing.
	 */
	public synchronized void printRes(int threadNum, int res) {
		
		// if the turn is different from the thread number that needs to print next
		// then this thread is putting to sleep 
		while( threadNum != turnNumber)
		{
			try{
				wait();
			} catch (InterruptedException e) {}
		}
		
		//turn is equal to count then- its a sign that this thread is need to print next. 
		
		// before printing the result - check if need to start a new line with an open brackets.
		if(turnNumber%matB[0].length == 0)
			System.out.print("\n [");		
		
		System.out.print(res); // printing the calculated result
		
		// after printing the result - check if need to print a comma or a close brackets.
		if(turnNumber%matB[0].length == matB[0].length-1)
			System.out.print("]");
		else 
			System.out.print(", ");
		
		turnNumber++; // increase the number of the thread that will print next
		
		notifyAll(); // wake all the sleeping thread on this Monitor
		
		if(threadNum == lastThreadNum) // last thread need to wake the manger-thread 
			man.wakeUp();
	}
	
	
}
