package ThreadsMatrixMultiolication;

/**
 * This class is for a multithreads program for calculate a multiplication of 2 matrices.
 * <p> An instance of this class is calculating a multiplication of a specifics row and column 
 * <p> of 2 matrices. Each instance of this class get a reference to the 2 matrices
 * <p> and a specific indexes for a row and column, and a reference to a Monitor that 
 * <p> responsible on the printing order of the threads.
 *  
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class CalculatThread extends Thread{

	private int[][] matA; // first matrix
	private int[][] matB; // second matrix
	private int indexA; // index of the row in the first matrix
	private int indexB; // index of the column in the second matrix
	private int turn; // the number for this threads to print his result
	private Monitor M; // the Monitor that passes as reference 
	
	/*
	 * Creates a new CalculatThread instance
	 * @param A - is the first matrix(passing as reference).
	 * @param B - is the second matrix(passing as reference).
	 * @param _indexA - index of the row in the first matrix.
	 * @param _indexB - index of the column in the second matrix.
	 * @param _turn - the number for this threads to print his result.
	 * @param _M - a reference to the Monitor(passing as reference).
	 */
	public CalculatThread (int[][] A, int[][] B, int _indexA, int _indexB, int _turn, Monitor _M) {
		matA = A;
		matB = B;
		indexA = _indexA;
		indexB = _indexB;
		turn = _turn;
		M = _M;
	}
	
	@Override
	public void run() {
		
		// calculate the result
		int sum = 0;
		for (int i = 0 ; i < matA[0].length; i++) {	
			sum += matA[indexA][i] * matB[i][indexB];
		}
		
		// prints the result
		M.printRes(turn, sum );
	}
}




