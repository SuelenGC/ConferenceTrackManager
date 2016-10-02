package com.suelengc.conferencetrackmanager.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class TalkTest {

	@Test
	public void createNewTalkTest() {
		// Action
		Talk talk = new Talk("My test talk 45min", 45);

		// Validates
		String expectedTitle = "My test talk 45min";
		assertEquals(expectedTitle, talk.getTitle());

		int expectedDuration = 45;
		assertEquals(expectedDuration, talk.getDurationInMinutes());
	}

	@Test
	public void setStartAndFinishMethodTest() {
		// Prepare
		String title = "My test talk 45min";
		int duration = 45;

		// Action
		Talk talk = new Talk(title, duration);
		Calendar startTime = Calendar.getInstance();
		startTime.set(Calendar.HOUR_OF_DAY, 12);
		startTime.set(Calendar.MINUTE, 1);
		talk.setStartAndFinishTime(startTime);

		// Validates
		int expectedStartHour = 12;
		assertEquals(expectedStartHour,
				talk.getStartTime().get(Calendar.HOUR_OF_DAY));

		int expectedStartMinute = 1;
		assertEquals(expectedStartMinute,
				talk.getStartTime().get(Calendar.MINUTE));

		int expectedFininshtHour = 12;
		assertEquals(expectedFininshtHour,
				talk.getFinishTime().get(Calendar.HOUR_OF_DAY));

		int expectedFininshtMinute = 46;
		assertEquals(expectedFininshtMinute,
				talk.getFinishTime().get(Calendar.MINUTE));

	}

	public static List<String> getStringListOfTalks() {
		List<String> talksStringList = new ArrayList<String>();

		talksStringList.add("Writing Fast Tests Against Enterprise Rails 60min");
		talksStringList.add("Overdoing it in Python 45min");
		talksStringList.add("Lua for the Masses 30min");
		talksStringList.add("Ruby Errors from Mismatched Gem Versions 45min");
		talksStringList.add("Common Ruby Errors 45min");
		talksStringList.add("Rails for Python Developers lightning");
		talksStringList.add("Communicating Over Distance 60min");
		talksStringList.add("Accounting-Driven Development 45min");
		talksStringList.add("Woah 30min");
		talksStringList.add("Sit Down and Write 30min");
		talksStringList.add("Pair Programming vs Noise 45min");
		talksStringList.add("Rails Magic 60min");
		talksStringList.add("Ruby on Rails: Why We Should Move On 60min");
		talksStringList.add("Clojure Ate Scala (on my project) 45min");
		talksStringList.add("Programming in the Boondocks of Seattle 30min");
		talksStringList.add("Ruby vs. Clojure for Back-End Development 30min");
		talksStringList.add("Ruby on Rails Legacy App Maintenance 60min");
		talksStringList.add("A World Without HackerNews 30min");
		talksStringList.add("User Interface CSS in Rails Apps 30min");

		return talksStringList;
	}
	
	public static List<String> getFewStringListOfTalks() {
		List<String> talksStringList = new ArrayList<String>();

		talksStringList.add("Writing Fast Tests Against Enterprise Rails 60min");
		talksStringList.add("Overdoing it in Python 45min");
		talksStringList.add("Lua for the Masses 30min");
		talksStringList.add("Ruby Errors from Mismatched Gem Versions 45min");
		talksStringList.add("Common Ruby Errors 45min");
		talksStringList.add("Rails for Python Developers lightning");
		talksStringList.add("Communicating Over Distance 60min");
		
		return talksStringList;
	}

	public static String[] getArrayOfTalks() {
		String[] arrayTalks = {
				"Writing Fast Tests Against Enterprise Rails 60min",
				"Overdoing it in Python 45min", "Lua for the Masses 30min",
				"Ruby Errors from Mismatched Gem Versions 45min",
				"Common Ruby Errors 45min",
				"Rails for Python Developers lightning",
				"Communicating Over Distance 60min",
				"Accounting-Driven Development 45min", "Woah 30min",
				"Sit Down and Write 30min", "Pair Programming vs Noise 45min",
				"Rails Magic 60min",
				"Ruby on Rails: Why We Should Move On 60min",
				"Clojure Ate Scala (on my project) 45min",
				"Programming in the Boondocks of Seattle 30min",
				"Ruby vs. Clojure for Back-End Development 30min",
				"Ruby on Rails Legacy App Maintenance 60min",
				"A World Without HackerNews 30min",
				"User Interface CSS in Rails Apps 30min" };

		return arrayTalks;
	}

	public static ArrayList<Talk> getListOfTalks() {
		ArrayList<Talk> talks = new ArrayList<Talk>();

		talks.add(new Talk("Writing Fast Tests Against Enterprise Rails 60min",
				60));
		talks.add(new Talk("Overdoing it in Python 45min", 45));
		talks.add(new Talk("Lua for the Masses 30min", 30));
		talks.add(new Talk("Ruby Errors from Mismatched Gem Versions 45min", 45));
		talks.add(new Talk("Common Ruby Errors 45min", 45));
		talks.add(new Talk("Rails for Python Developers lightning", 5));
		talks.add(new Talk("Communicating Over Distance 60min", 60));

		return talks;
	}
}
