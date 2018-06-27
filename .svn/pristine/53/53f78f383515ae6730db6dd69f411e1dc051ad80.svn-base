package com.kitri.project.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MakeCalendar {
	public Calendar cal;

	public MakeCalendar() {
		this.cal = new GregorianCalendar();
	}
	
	public int calcEndDate(String year, String month) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month); 
		cal.set(y, m-1, 1);
		int d = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		System.out.println(y+" / " + m + " / " + d);
		System.out.println("calc d : " + d);
		return d;
	}
	
}
