package com.suelengc.conferencetrackmanager.util;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class DateTimeUtilTest {

	@Test
	public void dateToStringTest() {
		// Prepare
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, 14);
		date.set(Calendar.MINUTE, 35);
		
		// Action
		String dateToString = DateTimeUtil.dateToString(date.getTime(), "hh:mma");
		
		// Validates
		String expected = "02:35PM";
		assertEquals(expected, dateToString);
	}

	@Test
	public void toCalendarWithoutMinutesTest() {
		// Action
		Calendar returnedDate = DateTimeUtil.toCalendar(16);
		
		// Validates
		Calendar expectedDate = Calendar.getInstance();
		expectedDate.set(Calendar.HOUR_OF_DAY, 16);
		expectedDate.set(Calendar.MINUTE, 0);
		
		assertEquals(expectedDate.get(Calendar.MINUTE), returnedDate.get(Calendar.MINUTE));
		assertEquals(expectedDate.get(Calendar.HOUR_OF_DAY), returnedDate.get(Calendar.HOUR_OF_DAY));
	}
	
	@Test
	public void toCalendarWithMinutesTest() {
		// Action
		Calendar returnedDate = DateTimeUtil.toCalendar(14, 35);
		
		// Validates
		Calendar expectedDate = Calendar.getInstance();
		expectedDate.set(Calendar.HOUR_OF_DAY, 14);
		expectedDate.set(Calendar.MINUTE, 35);
		
		assertEquals(expectedDate.get(Calendar.MINUTE), returnedDate.get(Calendar.MINUTE));
		assertEquals(expectedDate.get(Calendar.HOUR_OF_DAY), returnedDate.get(Calendar.HOUR_OF_DAY));
	}
}
