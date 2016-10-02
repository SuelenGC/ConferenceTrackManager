package com.suelengc.conferencetrackmanager.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class TrackTest {

	@Test
	public void getAllTalksWhenHaveJustOneSessionTest() {
		// Prepare
		Calendar startTime = Calendar.getInstance();
		TalkSession talkSession1 = new TalkSession(startTime, 180);
		talkSession1.addTalk(new Talk("Test talk 1", 45));
		talkSession1.addTalk(new Talk("Test talk 2", 30));
		
		// Action
		Track track = new Track(Arrays.asList(talkSession1), 1);
		
		// Validates
		int expectedValue = 2;
		assertEquals(expectedValue, track.getAllTalks().size());
	}

	@Test
	public void getAllTalksWhenHaveTwoSessionsTest() {
		// Prepare
		Calendar startTime = Calendar.getInstance();
		
		TalkSession talkSession1 = new TalkSession(startTime, 180);
		talkSession1.addTalk(new Talk("Test talk 1", 45));
		talkSession1.addTalk(new Talk("Test talk 2", 30));
		
		TalkSession talkSession2 = new TalkSession(startTime, 240);
		talkSession1.addTalk(new Talk("Test talk 1", 30));
		talkSession1.addTalk(new Talk("Test talk 2", 60));
		
		// Action
		Track track = new Track(Arrays.asList(talkSession1, talkSession2), 1);
		
		// Validates
		int expectedValue = 4;
		assertEquals(expectedValue, track.getAllTalks().size());
	}
	
	
}
