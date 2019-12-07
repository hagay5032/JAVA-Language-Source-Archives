package GenericSet;

import java.security.SecureRandom;
import java.util.Scanner;
/**
 * This Class is manage the interface with the user, 
 * 
 * This is section B of this task.
 * Its creates a 3 random Integer Generic sets, And prints them to the screen.
 * It also make a union from the first set and the second set. And print the result.
 * Then its make intersect from the first set and the third set. And print the result.
 * Then it asks from the user to enter 2 Integers for creating a fourth set.
 * Then it print if the forth set is a subset of any other sets.
 * Then it asks from the user to enter a third Integer for for checking if this integer
 * is a member in the first set. 
 * Then insert the input integer to the second set. 
 * And then delete it from the third set.
 * 
 * This is section C of this task.
 * Now Its creates a set of 5 Persons(type Person). 
 * And then uses the minimum method (- a static method in this class) and prints 
 * the smallest Person to the screen.  * 
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class Main {

	public static void main(String[] args)  {
		
		SecureRandom randomNumbers = new SecureRandom(); // create random number generator
	
		int rndNum; 
		
		// create a four GenericSet objects
		GenericSet<Integer> set1 = new GenericSet<>();
		GenericSet<Integer> set2 = new GenericSet<>();
		GenericSet<Integer> set3 = new GenericSet<>();
		GenericSet<Integer> set4 = new GenericSet<>();
		 
		// creates exactly 10 random Integers in each set( of set1,set2,set3)
		for (int i = 0; i < 10  || set1.quantity() < 10; i++) {
			rndNum = randomNumbers.nextInt(100);
			set1.insert(rndNum);
		}
		for (int i = 0; i < 10  || set2.quantity() < 10; i++) {
			rndNum = randomNumbers.nextInt(100);
			set2.insert(rndNum);
		}	rndNum = randomNumbers.nextInt(100);
		for (int i = 0; i < 10  || set3.quantity() < 10; i++) {
			rndNum = randomNumbers.nextInt(100);
			set3.insert(rndNum);
		}
		
		// print the three sets
		System.out.println("set1 - "+ set1);
		System.out.println("set2 - "+ set2);
		System.out.println("set3 - "+ set3);
		
		// union between the first set and the second set(result is placed in the first set).
		set1.union(set2);
		System.out.println("The union group between 'set1' and 'set2' is now:\n'set1'- "+ set1);
		
		// intersect between the first set and the third set(result is placed in the first set).
		set1.intersect(set3);
		System.out.println("\"The intersect group between 'set1' and 'set3' is now:\n'set1'- "+ set1);
		
		// asking for the user for input - two integers for creating the forth class.
		// Getting the input is protected by a static method in this class - getInt(int).
		System.out.print("For creating the fourth group -");
		set4.insert( getInt("first"));
		set4.insert(getInt("second"));
		
		// print to the screen if the forth set is a subset of any other set.
		if(set1.isSubset(set4))
			System.out.println("'set4' is a subset of 'set1'.");
		else
			System.out.println("'set4' is not a subset of 'set1'.");	
		if(set2.isSubset(set4))
			System.out.println("'set4' is a subset of 'set2'.");
		else
			System.out.println("'set4' is not a subset of 'set2'.");
		if(set3.isSubset(set4))
			System.out.println("'set4' is a subset of 'set3'.");
		else
			System.out.println("'set4' is not a subset of 'set3'.");
			
		// asking for the user for integer input for checking if this integer
		// is a member in the first set. And print the result
		int third = getInt("third");
		if(set1.isMember(third))
			System.out.println("\n"+third+" is a member in 'set1'. ");
		else
			System.out.println(third+" is not a member in 'set1'. ");
		
		
		// insert the input integer to the second set. And print the result	 
		set2.insert(third);
		System.out.println("After adding "+third +" to 'set2'- "+set2);
	
		//delete the input integer from the third set.And print the result
		set3.delete(third);
		System.out.println("After removing "+third +" from 'set3'- "+set3);
		
		System.out.println("\n**********************  END OF QUESTION 1 SECTIONS B  *************************");
	
		// creates a 10 Persons ( NOTICE: just five of them has a different age)
		Person p1 = new Person("A",11111111,10);
		Person p2 = new Person("B",11122111,10);
		Person p3 = new Person("C",11113311,20);
		Person p4 = new Person("D",11441111,5);
		Person p5 = new Person("E",11115511,20);
		Person p6 = new Person("F",11111111,7);
		Person p7 = new Person("G",11122111,11);
		Person p8 = new Person("H",11113311,20);
		Person p9 = new Person("I",11441111,7);
		Person p10 = new Person("J",11115511,20);

		// creates a GenericSet of 5 Persons( NOTICE: just five of th 10 Persons
		// has a different age)
		GenericSet<Person> personSet = new GenericSet<>();
		personSet.insert(p1);
		personSet.insert(p2);
		personSet.insert(p3);
		personSet.insert(p4);
		personSet.insert(p5);
		personSet.insert(p6);
		personSet.insert(p7);
		personSet.insert(p8);
		personSet.insert(p9);
		personSet.insert(p10);
		
		// print the persons set
		System.out.println("personSet: \n"+personSet  );
		
		// print the smallest person in the set
		System.out.println("\nThe smallest person in the group is - \n" + minimum(personSet));
		
		System.out.println("**********************  THE END  *************************");
		
	}
	
	/*
	 * This static method is getting a GenericSet of type E and return the smallest 
	 * element in the set.
	 * @param set - is a GenericSet of type E.
	 * @return E - the smallest element in the set.
	 */
	public static <E extends Comparable<E>> E minimum(GenericSet<E> set) 
	{	
		boolean first = true; // boolean for the first initializing the E 'min'. 
		E min = null;
		
		//creating an iterator that will move on every element in the set.
		for( E it : set)
		{ 
			if(first) // if this is the first element - then initialize 'min'.
			{ 
				min = it;
				first = false;
			}
			
			// if the current minimum element is bigger then another element- then update 'min'.
			if( min.compareTo(it) > 0) 
				min = it;
		}
		return min;
	}
	
	/*
	 * This method is for validate the integer input from the user.
	 * if the input was incorrect it ask again for an integer input.
	 * @param str - is a String represent the number of the integer for input.
	 * @return the integer input from the user.
	 */
	public static int getInt(String str) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean continueLoop = true;
		int num = 0;
		do 
		{
			try 
			{
				System.out.print("\nPlease enter the "+str+" integer, And then press the 'ENTER' key: ");
		
				num = scan.nextInt();
				continueLoop = false; // stop the loop
			}
			catch(Exception e) // there was an invalid input
			{
				scan.nextLine(); // discard from the invalid input
				System.out.println(e); 
				System.out.print("You must enter integers. Please try again. ");	
			}
		}while(continueLoop);
		return num;
		
	}
	
}
