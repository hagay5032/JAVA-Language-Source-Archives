package Rational;


import java.util.Scanner;

/**
 * 	This interactive program - request from the user two rational numbers and
 *  performing all methods of the class Rational on this two numbers.
 * 
 * @author Hagay Enoch
 * @version 203089917
 * 
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("This program input is 2 rational numbers , The user enter  4 integers"
				+ " representing this two numbers\n"
				+ "and then the program execute all operation that rational object can do. ");
		
		System.out.println("For the first number Please enter the numerator(NOTE: this number need to be an integer): ");
		int firstNum = scan.nextInt();
		System.out.println("For the first number Please enter the denominator(NOTE: this number need to be an integer): ");
		int firstDen = enterADenominator();
		System.out.println("For the second number Please enter the numerator(NOTE: this number need to be an integer): ");
		int secNum = scan.nextInt();
		System.out.println("For the second number Please enter the denominator(NOTE: this number need to be an integer): ");
		int secDen = enterADenominator();

		if( firstDen < 0) {
			// switching the minus sign to be at the numerator.
			firstNum = firstNum * (-1);
			firstDen = firstDen * (-1);
		}
			
		if( secDen < 0) {	
			// switching the minus sign to be at the numerator.
			secNum = secNum * (-1);
			secDen = secDen * (-1);
		}
		
		Rational first = new Rational(firstNum, firstDen);
		Rational second = new Rational(secNum, secDen);

		System.out.println("The first rational number is: "+ first);
		System.out.println("The second rational number is: "+ second);
		
		if( first.greaterThan(second))
			System.out.println("The first number is greater than the second.");
		
		if( first.equals(second))
			System.out.println("The two numbers are equals.");
		
		Rational pls = first.plus(second);
		pls = pls.reduce();
		System.out.println(first + "+" + second + "=" + pls);
	 	
	 	Rational min = first.minus(second);
	 	min = min.reduce(); 
	 	System.out.println(first + "-" + second + "=" + min );

	 	Rational mul = first.multiply(second);
	 	mul = mul.reduce(); 
	 	System.out.println(first + "*" + second + "="  + mul);
	 	System.out.println("The numerator of this number is: " + mul.getNumerator());
	 	System.out.println("The denominator of this number is: " + mul.getDenominator());
		
	 	scan.close();
	}
	
	private static int enterADenominator() {
		Scanner scan = new Scanner(System.in);
		int den = scan.nextInt();
		while(den == 0) {
			System.out.println("A denominator cannot be zero, please enter a diffrenet number.");
			den = scan.nextInt();
		}
		scan.close();
		return den;
	}
}
