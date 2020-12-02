package dk.colourit.model;


public class MyDate {

	private int month;

	private int day;

	private int year;

	public MyDate(int argDay, int argMonth, int argYear) {

	}

	public MyDate() {

	}

	public int getDay() {
		return 0;
	}

	public int getMonth() {
		return 0;
	}

	public int getYear() {
		return 0;
	}

	public String getMonthName() {
		return null;
	}

	public void set(int argDay, int argMonth, int argYear) {

	}

	public boolean isLeapYear() {
		return false;
	}

	public void stepForwardOneDay() {

	}

	public void stepForward(int days) {

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
