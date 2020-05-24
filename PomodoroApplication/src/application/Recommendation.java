package application;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Recommendation {
	
	
	public static int nowMonth() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		return month;
	}
	
	
	private static int amountWorkDay = 8;
	private static int amountWorkWeek = amountWorkDay*7;
	private static int amountWorkMonth = amountWorkDay*nowMonth();
	
	public static int getAmountWorkDay() {
		return amountWorkDay;
	}
	
	public static int getAmountWorkWeek() {
		return amountWorkWeek;
	}
	
	public static int getAmountWorkMonth() {
		return amountWorkMonth;
	}
	
	
	
	
}
