package com.suelengc.conferencetrackmanager.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TalkSessionTest {

	@Test
	public void getTalksWhenDontHaveTalksTest() {
		// Action
		TalkSession talkSession = new TalkSession(Calendar.getInstance(), 180);
		
		// Validates
		int expectedValue = 0;
		assertEquals(expectedValue, talkSession.getTalks().size());
	}

	@Test
	public void getTalksWhenHaveTalksTest() {
		// Action
		TalkSession talkSession = new TalkSession(Calendar.getInstance(), 180);
		talkSession.addTalk(new Talk("Test talk 1", 45));
		talkSession.addTalk(new Talk("Test talk 2", 30));
		
		// Validates
		int expectedValue = 2;
		assertEquals(expectedValue, talkSession.getTalks().size());
	}
	
	@Test
	public void getLastTalkWhenDontHaveTalksTest() {
		// Action
		TalkSession talkSession = new TalkSession(Calendar.getInstance(), 180);
		
		// Validates
		assertNull(talkSession.getLastTalk());
	}
	
	@Test
	public void getLastTalkWhenHaveTalksTest() {
		// Action
		TalkSession talkSession = new TalkSession(Calendar.getInstance(), 180);
		talkSession.addTalk(new Talk("Test talk 1", 45));
		talkSession.addTalk(new Talk("Test talk 2", 30));
		
		// Validates
		Talk lastTalk = talkSession.getLastTalk();
		assertNotNull(lastTalk);
		assertEquals("Test talk 2", lastTalk.getTitle());
		assertEquals(30, lastTalk.getDurationInMinutes());
	}
}
