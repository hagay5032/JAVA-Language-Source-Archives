package Reminder;

import java.io.Serializable;

/**
 * This class is fore representing a date - with days, months and years.
 * 
 * @author Hagay Enoch
 * @version 203089917
 */
@SuppressWarnings("serial")
public class MyDate implements Serializable{
	
	// instance variables
	private int year;
	private int month;
	private int day;

	/*
	 * Default constructor - create a new MyDate object 
	 */
	public MyDate() {}
	
	/*
	 * Create a new MyDate object with the given parameters
	 * @param _year - the year
	 * @param _month - the month
	 * @param _day - the day
	 */
	public MyDate(int _year, int _month , int _day) {
		day = _day;
		month = _month;
		year = _year;
	}
	
	/*
	 * Copy constructor - create a new MyDate object with the same parameters as the given MyDate object 'other'.
	 * @param _year - the year
	 * @param _month - the month
	 * @param _day - the day
	 */
	public MyDate(MyDate other) {
		day = other.day;
		month = other.month;
		year = other.year;
	}
	
	@Override
	public boolean equals(Object o){
		MyDate other = (MyDate) o;
		if(year == other.year && month == other.month && day == other.day )
			return true;
		return false;
	}
	
	@Override
    public int hashCode() {
		return year+month*10000+ day*1000000;
    }
	
	/*
	 * Set the year of the date
	 * @param _year - is the new year for the date.
	 */
	public void setYear(int _year) {
		year = _year;
	}
	
	/*
	 * Set the month of the date
	 * @param _month - is the new year for the date.
	 */
	public void setMonth(int _month) {
		month = _month;
	}

	/*
	 * Set the day of the date
	 * @param _day - is the new day for the date.
	 */
	public void setDay(int _day) {
		day = _day;
	}
	
	/*
	 * Return the day of the date.
	 * @return the day of the date.
	 */
	public int getDay() {
		return day;
	}
	
	/*
	 * Return the month of the date.
	 * @return the month of the date.
	 */
	public int getMonth() {
		return month;
	}
	
	/*
	 * Return the year of the date.
	 * @return the year of the date.
	 */
	public int getYear() {
		return year;
	}
	
	/*
	 * Return the string representation of a MyDate object.
	 * @return the string representation of a MyDate object
	 */
	public String toString() {
		String res = "";
		if( day < 10)
			res = "0";
		res += ""+day+"/";
		if( month < 10)
			res += "0";
		res += ""+month+"/";
		res += ""+year;
		return res;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
