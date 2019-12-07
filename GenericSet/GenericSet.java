package GenericSet;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This Class is a generic class for structure type -  Sets.
 * That can produce any generic type of set. 
 * 
 * @author Hagay Enoch
 * @version 203089917
 *
 */
public class GenericSet<T> implements Iterable<T>{

	// the array of the element type T
	private ArrayList<T> elements;
	
	/*
	 * Default constructor - create a new generic set of type T without any elements 
	 */
	public GenericSet() {
		elements = new ArrayList<T>();
	}

	/*
	 * Create a new generic set of type T with initializing elements 
	 * <p> given as parameter in the array.
	 * @param arr - is an array of type T, that will initialized the GenericSet elements.
	 */
	public GenericSet(T[] arr) {
		elements = new ArrayList<T>();	
		for(int i = 0 ;  i < arr.length ; i++) {
			elements.add(arr[i]);
		}
	}
	
	/*
	 * This method merge this GenericSet object with an other GenericSet object 
	 * <p> given as parameter. The result placed in the caller object.
	 * <p> NOTICE: there are no duplicates elements in the GenericSet. 
	 * @param other - is a GenericSet object, that will be united with this GenericSet
	 * <p> object.
	 */
	public void union(GenericSet<T> other) {
		for(T i : other.elements)  
				insert(i);
	}
	
	/*
	 * This method intersect this GenericSet object with an other GenericSet object 
	 * <p> given as parameter. The result placed in the caller object . 
	 * @param other - is a GenericSet object, that will be intersect with this 
	 * <p> GenericSet object.
	 */
	public void intersect(GenericSet<T> other) {
		
		// this flag holds false each iteration and switch to true just if an element 
		// is found in both sets 
		boolean isDup = false;
		
		// temporary array for storing all results
		ArrayList<T> tmp = new ArrayList<T>();
		
		// check for duplicates in both sets
		for(T i : other.elements)  
		{
			for(T j : elements) 
			{
				if(i.equals(j)) 
				{
					isDup = true; // element is found in both sets 
					break;
				}
			}
			if(isDup)
				tmp.add(i);
			isDup = false;
		}
		elements = tmp;
	}
	
	/*
	 * Return true - if this GenericSet object contain all elements of the other 
	 * <p> GenericSet object given as parameter; false otherwise. 
	 * @param other - is a GenericSet object, for checking if it a subset of 
	 * <p> this GenericSet object.
	 * @return true - if this GenericSet object contain all elements of the other 
	 * <p> GenericSet object given as parameter; false otherwise. 
	 */
	public boolean isSubset(GenericSet<T> other) {
		boolean isDup = false;
		
		for(T i : other.elements)  {
			
			for(T j : elements)  
				if(i.equals(j)) 
				{ // this element is included in this GenericSet object.
					isDup = true;
					break;
				}
			if(!isDup) // this element is not include in this GenericSet object. 
				return false; 
			isDup = false;
		}
		return true;
	}

	/*
	 * Return true if the element given as parameter is a member in this GenericSet
	 * <p> object; false otherwise.
	 * @param obj - is an element of type T.  
	 * @return true - if the element given as parameter is a member in this GenericSet
	 * <p> object; false otherwise.
	 */
	public boolean isMember(T obj) {
		for(T i : elements) 
			if(obj.equals(i))
				return true;	

		return false;
	}
	
	/*
	 * This method is inserting a T element given as parameter to this GenericSet
	 * <p> object, Just if this element not already exists in this set.
	 * @param obj - is an element of type T.
	 */
	public void insert(T obj) {
		for(T i : elements)  
				if(((T)obj).equals(i))
					return ;

		elements.add((T) obj);
	}
	
	/*
	 * This method is deleting a T element given as parameter from this GenericSet
	 * <p> object, Just if this element is already exists in this set.
	 * @param obj - is an element of type T.
	 */
	public void delete(T obj) {
    	for(T i : elements) 
				if(obj.equals(i)) {
					elements.remove(i);
					return ;	
				}
		return;
	}
	
	@Override
	public Iterator<T> iterator() {
             return elements.iterator();
    }
    @Override
    public String toString() {
    	return elements.toString();
    }
    
    
    /*
     * Return the size of the set.
     * @return the size of the set.
     */
    public int quantity() {
    	return elements.size();
    }
    

}
