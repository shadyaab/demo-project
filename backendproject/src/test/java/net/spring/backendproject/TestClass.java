package net.spring.backendproject;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TestClass {

	public static void main(String[] args) {
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DATE, -5);
		calender.set(Calendar.HOUR_OF_DAY, 15);
		calender.set(Calendar.MINUTE, 42);
		calender.set(Calendar.SECOND, 57);
		System.out.println(calender.getTime());
		
		System.out.println(new Timestamp((calender.getTime()).getTime()));
		
//		Date date = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		System.out.println(cal);
//		System.out.println(date.toString());
//		
//		Date date1 = new Date();
//		System.out.println(date1);
//		System.out.println(date1.getTime());
	}

}
