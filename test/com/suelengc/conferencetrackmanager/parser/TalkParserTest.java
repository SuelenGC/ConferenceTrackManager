package com.suelengc.conferencetrackmanager.parser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.suelengc.conferencetrackmanager.model.Talk;
import com.suelengc.conferencetrackmanager.model.TalkTest;
import com.suelengc.conferencetrackmanager.parser.TalkParser;

public class TalkParserTest {

	private TalkParser parser;

	@Before
	public void setup() {
		this.parser = new TalkParser();
	}
	
	@Test
	public void givenStringTalkWith60Min_MustReturnTalk() {
		// Prepare
		String talkInputed = "Writing Fast Tests Against Enterprise Rails 60min";
		
		// Action
		Talk talk = parser.toTalk(talkInputed);
		
		// Validates
		String expectedTitle = "Writing Fast Tests Against Enterprise Rails 60min";
		assertEquals(expectedTitle, talk.getTitle());
		
		int expectedDurationInMinutes = 60;
		assertEquals(expectedDurationInMinutes, talk.getDurationInMinutes());
	}
	
	@Test
	public void givenArrayOfTalks_MustReturnListOfTalks() {
		//Prepare 
		String[] array = TalkTest.getArrayOfTalks();
		
		// Action
		List<Talk> talks = this.parser.toTalkList(array);
		
		// Validates
		Talk secondTalk = talks.get(1);
		String expectedTitle = "Overdoing it in Python 45min";
		assertEquals(expectedTitle, secondTalk.getTitle());
		
		int expectedDurationInMinutes = 45;
		assertEquals(expectedDurationInMinutes, secondTalk.getDurationInMinutes());
	}
	
	@Test
	public void givenStringLightningTalk_MustReturnTalkWithDurationFive() {
		// Prepare
		String talkInputed = "Rails for Python Developers lightning";
		
		// Action
		Talk talk = parser.toTalk(talkInputed);
		
		// Validates
		String expectedTitle = "Rails for Python Developers lightning";
		assertEquals(expectedTitle, talk.getTitle());
		
		int expectedDurationInMinutes = 5;
		assertEquals(expectedDurationInMinutes, talk.getDurationInMinutes());
	}

}
