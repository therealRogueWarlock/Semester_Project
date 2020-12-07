package dk.colourit.model;


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

	public MyDate copy() {
		return null;
	}

	public boolean equals(MyDate myDate) {
		return false;
	}

	public String toString() {
		return null;
	}

	public static MyDate now() {
		return null;
	}

}
