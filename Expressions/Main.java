package Expressions;



import java.util.ArrayList;
import java.security.SecureRandom;

/**
 * This class execute a number of operations on Expression objects to check correctness  
 * 
 * @author Hagay Enoch
 * @version 203089917
 */
public class Main {
	private final static int BIGGEST = 10;
	
	public static void main(String[] args) {
		
		//Generate a list of 15 random expressions
		SecureRandom randomNumbers = new SecureRandom(); 
		ArrayList<Expression> lis  = new ArrayList<Expression>( BIGGEST );;
		
		Expression first_exp = new AtomicExpression(randomNumbers.nextInt( BIGGEST ));
		Expression sec_exp = new AtomicExpression(randomNumbers.nextInt( BIGGEST ));
		lis.add( new AtomicExpression(randomNumbers.nextInt( BIGGEST )));
		lis.add( new AtomicExpression(randomNumbers.nextInt( BIGGEST )));
		lis.add( new AdditionExpression(first_exp, sec_exp ));
		Expression third_exp = new AtomicExpression(randomNumbers.nextInt( BIGGEST ));
		Expression fourth_exp = new AtomicExpression(randomNumbers.nextInt( BIGGEST ));
		lis.add( new SubtractionExpression(third_exp, fourth_exp ));
		
		int count = 4;
		int first, sec;
		
		for(int i = 0 ; i<6; i++) {
			first = randomNumbers.nextInt( count );
			sec = randomNumbers.nextInt( count );
			lis.add( new SubtractionExpression(lis.get(first),lis.get(sec)));
			lis.add( new AdditionExpression(lis.get(sec),lis.get(first)));
			count += 2;
		}
		
		// print each expression and it's value
		for(int i = 0; i < lis.size() ; i++){
			Expression tmp = lis.get(i);
			System.out.println("Expression number "+ i +" in the list is "+tmp+" it's sum is " + tmp.calculate());
		}

		// for each expression prints all indexes  in the list of other expressions that equals to it 
		boolean first_equal;
		for(int i = 0; i < lis.size() ; i++){
			Expression tmp = lis.get(i);
			first_equal = true;
			for(int j = 0; j < lis.size(); j++) {
				if( tmp.equals(lis.get(j)) && i != j) {
					if(first_equal) {
						System.out.print(" \n Expression number "+ i +" in the list- equals to expressions in places numbers - "+j);
						first_equal = false;
					}
					else
						System.out.print(", "+j);
				}
			}
			if(first_equal)
				System.out.print("\n Expression number "+ i +" in the list is uniqe and there is no other experssion eaules to it.");
		}	
	}
}

