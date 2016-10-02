package com.suelengc.conferencetrackmanager.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	public static Calendar toCalendar(int startHourIn24H, int startMinutes) {
		Calendar beginHour = Calendar.getInstance();
		beginHour.set(Calendar.HOUR, startHourIn24H);
		beginHour.set(Calendar.MINUTE, startMinutes);
		return beginHour;
	}
	
	public static Calendar toCalendar(int startHourIn24H) {
		return toCalendar(startHourIn24H, 0);
	}
	
}
