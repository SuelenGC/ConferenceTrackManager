package com.suelengc.conferencetrackmanager.manager;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.suelengc.conferencetrackmanager.exception.FewTalksException;
import com.suelengc.conferencetrackmanager.model.Talk;
import com.suelengc.conferencetrackmanager.model.TalkTest;
import com.suelengc.conferencetrackmanager.model.Track;

public class ConferenceManagerTest {

	@Test
	public void givenAnArrayOfTalks_MustReturnItOrganizedInTracks() {
		// Prepare
		String[] arrayTalks = TalkTest.getArrayOfTalks();
		
		// Action
		ConferenceManager conferenceManager = new ConferenceManager(arrayTalks);
		List<Track> tracks = conferenceManager.generateTracks();
		
		// Validates
		assertFalse("Tracks can not be empty.", tracks.isEmpty());

		// Print Tracks just to test/develop
		Track firstTrack = tracks.get(0);
		firstTrack.print();
		
		Track secondTrack = tracks.get(1);
		secondTrack.print();
	}

	@Test
	public void givenAListOfStringTalks_MustReturnItOrganizedInTracks() {
		// Prepare
		List<String> stringList = TalkTest.getStringListOfTalks();
		
		// Action
		ConferenceManager conferenceManager = new ConferenceManager(stringList);
		List<Track> tracks = conferenceManager.generateTracks();
		
		// Validates
		assertFalse("Tracks can not be empty.", tracks.isEmpty());

		// Print Tracks just to test/develop
//		Track firstTrack = tracks.get(0);
//		firstTrack.print();
//		
//		Track secondTrack = tracks.get(1);
//		secondTrack.print();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenStringListHasNoItems_MustReturnIllegalArgumentException() {
		// Prepare
		List<String> stringList = new ArrayList<String>();
		
		// Action
		ConferenceManager conferenceManager = new ConferenceManager(stringList);
		List<Track> tracks = conferenceManager.generateTracks();
	}
	
	
	@Test(expected = FewTalksException.class)
	public void whenDontHasWnoughtTalks_MustReturnFewTalksException() {
		// Prepare
		List<String> stringList = TalkTest.getFewStringListOfTalks();
		
		// Action
		ConferenceManager conferenceManager = new ConferenceManager(stringList);
		List<Track> tracks = conferenceManager.generateTracks();
	}
}
