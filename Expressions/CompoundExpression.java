package Expressions;


/**
 * This class is an abstract class for a compound expression
 * 
 * @author Hagay Enoch
 * @version 203089917
 */
public abstract class CompoundExpression extends Expression {
	protected Expression exp_one;
	protected Expression exp_two;
	
	public CompoundExpression (Expression a,Expression b) {
		this.exp_one = a;
		this.exp_two = b;
	}
	
	/*
	 * Return true if the value of the expression equals to the value of the other expression. 
	 * @return Return true if the value of the expression equals to the value of the other expression, 'false' otherwise.
	 */
	public boolean equals(Expression other) {
		return (calculate() == other.calculate());
	}
	
}
