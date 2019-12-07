package Expressions;

/**
 * This class is an abstract class for an expression
 * 
 * @author Hagay Enoch
 * @version 203089917
 */
public abstract class Expression {
	
	public abstract double calculate();//method for all inherited sons to calculate the expression value
	public abstract boolean equals(Expression exp);//method for all inherited sons to check if there value equals to another expression value
	
}
