package dk.colourit.model;


import java.text.DecimalFormat;
import java.util.Calendar;

public class MyDate {

	private int day;
	private int month;
	private int year;
	private DecimalFormat dayMonthFormat = new DecimalFormat("00.##");
	private DecimalFormat yearFormat = new DecimalFormat("0000.##");


	public MyDate(int argDay, int argMonth, int argYear) {
		day = argDay;
		month = argMonth;
		year = argYear;
	}

	public MyDate() {
		//Burde dette ikke være nok, til at oprette MyDate med dags dato?
		now();
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

	public boolean isLeapYear()
	{
		if (year % 4 == 0)
		{
			if (year % 400 == 0)
			{
				return true;
			}
			else if (year % 100 == 0)
			{
				return false;
			}
			else
				return true;
		}
		else
			return false;
	}

	public int numberOfDaysInMonth()  {
		if (month == 1 || month == 3 || month == 5 || month == 7 ||
				month == 8 || month == 10 || month == 12)
		{
			return 31;
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11)
		{
			return 30;
		}
		else if (month == 2 && isLeapYear())
		{
			return 29;
		}
		else if (month == 2)
		{
			return 28;
		}
		else
			//System.out.println("You mistyped the month!");
			return -1;
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

	public String toString()   //format.format() to use the decimal format created on line 10-11
	{
		return "Date: " + dayMonthFormat.format(day) + "/" + dayMonthFormat.format(month) + " - " + yearFormat.format(year);
	}

	public static MyDate now()
	{
		return new MyDate(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR);
	}

}
