package com.suelengc.conferencetrackmanager.main;

import java.util.List;

import com.suelengc.conferencetrackmanager.manager.ConferenceManager;
import com.suelengc.conferencetrackmanager.model.Track;
import com.suelengc.conferencetrackmanager.util.InputFileReader;

public class Main {

	public static void main(String[] args) {
		InputFileReader reader = new InputFileReader();
		List<String> stringList = reader.readFromFile("res/input.txt");
		
		ConferenceManager conferenceManager = new ConferenceManager(stringList);
		List<Track> tracks = conferenceManager.generateTracks();
		
		Track firstTrack = tracks.get(0);
		firstTrack.print();
		
		Track secondTrack = tracks.get(1);
		secondTrack.print();
	}
}
