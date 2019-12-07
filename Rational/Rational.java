package Rational;

/**
 * Rational is a class for all rational numbers,
 * which allow the user to make any rational number object.
 * Each Rational object has two instance variables the numerator and
 * the denominator.  
 * Additionally Each object has operations to -
 *  - check if his rational number greater than another Rational object.
 *  - check if his rational number equals to another rational number of an other Rational object.
 *  - returning a sum of its rational number plus another rational number of an other Rational object.
 *  - returning a sum of its rational number minus another rational number of an other Rational object.
 *  - returning a sum of its rational number multiply another rational number of an other Rational object.
 *  - returning the numerator.
 *  - returning the denominator.
 *  - reduce the rational number to its lowest terms. 
 *  
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class Rational {
	 /**
	  *  instance variables - num is the numerator and
	  * den is the denominator of the rational number 
	  */
	private int num, den;
	
	/**
	 * Creates a new Rational object that represents the rational number num/den.
	 * @param num - is the numerator of the rational number.
	 * @param den - is the denominator of the rational number.
	 */
	public Rational (int numerator ,int denominator ){
		if (denominator == 0) {
			num = 0;
			den = 1;
		}
		else {
			num = numerator;
			den = denominator;
		} 
	}	
	
	/**
	 * Determines whether or not this Rational number are greater than other Rational object.
	 * @param other - an object to be compared with this Rational.
	 * @return true if the object to be compared is an instance of Rational and his rational number is less then this rational number; false otherwise.
	 */
	public boolean greaterThan(Rational other){
		return ( num*other.den > den*other.num);
	}

	/**
	 * Determines whether or not two Rational numbers are equal.
	 * Two instances of Rational are equal if the values of their num and den are the same respectively.
	 * @param other - an object to be compared with this Rational.
	 * @return true if the object to be compared is an instance of Rational and has the same values; false otherwise. 
	 */
	public boolean equals(Rational other){
		return ( num*other.den == den*other.num);
	}	
	
	/**
	 * Returns the sum of its rational number plus another rational number of an other Rational object.
	 * @param other - a Rational object.
	 * @return Rational object with the sum of the two Rational objects.
	 */
	public Rational plus(Rational other){
		int _num = den*other.num + num*other.den;
		int _den  = den*other.den;
		return new Rational(_num, _den);
	}	
	
	/**
	 * Returns the sum of its rational number minus another rational number of an other Rational object.
	 * @param other - a Rational object.
	 * @return Rational object with the sum of the 1st Rational objects minus the 2nd Rational objects. 
	 */
	public Rational minus(Rational other){
		int _num = num*other.den - den*other.num;
		int _den  = den*other.den;
		return new Rational(_num, _den);
	}	
	
	/**
	 * Returns the product of its rational number multiply another rational number of an other Rational object.
	 * @param other - a Rational object.
	 * @return Rational object with the product of the two Rational objects.
	 */
	public Rational multiply(Rational other){
		int _num = num*other.num;
		int _den  = den*other.den;
		return new Rational(_num, _den);
	}	
	
	/**
	 * Returns the numerator of the Rational object.
	 * @return the numerator.
	 */
	public int getNumerator(){
		return num;
	}	
	
	/**
	 * Returns the denominator of the Rational object.
	 * @return the denominator.
	 */
	public int getDenominator(){
		return den;
	}
	
	/**
	 * Returns a string representation of this Rational object as "numerator/denominator".
	 * @return a string representation of this Rational
	 */
	public String toString(){
		if (num < 0) 
			return "(" + num + "/" + den+")";
		else	
			return num + "/" + den;
	}
	
	/**
	 * Returns a new Rational object that has fraction in lowest terms that equivalent to 
	 * the rational number of the calling Rational object.
	 * @return a new Rational object that has fraction in lowest terms that equivalent to 
	 * the rational number of the calling Rational object.
	 */
	public Rational reduce(){
		int neg = 1;
		if( num < 0 ) {
			num = num*(-1);
			neg = -1;
		}
		int res = gcd(num, den);
		return new Rational(neg*(num/res), den/res);
	}
	
	/**
	 * Returns the greatest common divisor of two integers - this is known as the Euclidean algoritm.
	 *@param x - is the 1st integer.
	 *@param y - is the 2nd integer.
	 * @return the greatest common divisor of two integers
	 */
	private int gcd( int x , int y) {
		if (y == 0)
			return x;
		return gcd(y, x%y);
	}
	
}

