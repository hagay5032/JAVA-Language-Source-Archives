package GenericSet;

/**
 * This class represent a Person
 * 
 * @author Hagay Enoch
 * @version 203089917
 */
public class Person implements Comparable<Person>{

	private int age; // the age of the person
	private int id; // the ID of the person 
	private String name; // the name of the person
	
	/*
	 * Create a new Person object with the given parameters
	 * @param _name = the name of the person
	 * @param _id = the ID of the person 
	 * @param _age = the age of the person
	 */
	public Person(String _name, int _id, int _age) {
		age = _age;
		id = _id;
		name = _name;
	}
	
	@Override
	public int compareTo(Person other) {
		if(age > other.age)
			return 1;
		else if(age < other.age)
			return -1;
		return 0;
	}
	
	@Override
	public boolean equals(Object other) {
		return (age == ((Person)other).age );
	}

	@Override
	public String toString() {
		return "(Name: "+name+", ID: "+id+", Age: "+age+")\n";
	}
	
	
	
	
}
