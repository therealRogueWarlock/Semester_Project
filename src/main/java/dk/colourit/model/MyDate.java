package dk.colourit.model;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate {

	private int day;
	private int month;
	private int year;

	public MyDate(int argDay, int argMonth, int argYear) {
		day = argDay;
		month = argMonth;
		year = argYear;
	}

	public MyDate() {

	}

	public int getDay()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}

	public String getMonthName() {
		return null;
	}

	public void set(int argDay, int argMonth, int argYear) {
		day = argDay;
		month = argMonth;
		year = argYear;
	}

	public boolean isLeapYear() {
		return false;
	}

	public int numberOfDaysInMonth() {
		return 0;
	}

	public int yearsBetween(MyDate myDate) {
		return 0;
	}

	public int daysBetween(MyDate myDate) {
		return 0;
	}

	public boolean isBefore(MyDate myDate) {
		return false;
	}

	public MyDate copy()
	{
		return new MyDate(day, month, year);
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof MyDate))
			return false;
		MyDate other = (MyDate) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	public String toString() {
		return null;
	}

	public static MyDate now()
	{
		GregorianCalendar cal = new GregorianCalendar(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR);
		MyDate date = new MyDate(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR);
		return date;
	}

}
