package Expressions;


/**
 * This class is a atomic expression.
 * 
 * @author Hagay Enoch
 * @version 203089917
 */
public class AtomicExpression extends Expression {
	
	private int num; // the value of the atomic expression 
	
	/*
	 * Create a new AtomicExpression object. 
	 * @param val - is the value to initiate the atomic expression.
	 */
	public AtomicExpression(int val) {
		num = val;
	}
	
	/*
	 * Return the value of the AtomicExpression object. 
	 * @return Return the value of AtomicExpression object.
	 */
	public double calculate() {
	return num;
	}
	
	/*
	 * Return true if the value of the expression equals to the value of the other expression. 
	 * @return Return true if the value of the expression equals to the value of the other expression, 'false' otherwise.
	 */
	public boolean equals(Expression other) {
		return (calculate() == other.calculate());
	}
	
	/*
	 * Return a string representation of AtomicExpression object. 
	 * @return Return a string representation of AtomicExpression object.
	 */
	public String toString() {
		String str =  ""+num;
		return str;
	}
}


