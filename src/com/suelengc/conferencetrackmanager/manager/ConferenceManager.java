package com.suelengc.conferencetrackmanager.manager;

import java.util.ArrayList;
import java.util.List;

import com.suelengc.conferencetrackmanager.exception.FewTalksException;
import com.suelengc.conferencetrackmanager.model.Talk;
import com.suelengc.conferencetrackmanager.model.Talks;
import com.suelengc.conferencetrackmanager.model.Track;
import com.suelengc.conferencetrackmanager.parser.TalkParser;

public class ConferenceManager {
	private static final int MINIMUM_TIME_PER_TRACK = 360;
	private Talks talks;
	private List<Track> tracks = new ArrayList<Track>();
	private TrackManager trackManager = new TrackManager();
	private TalkParser parser = new TalkParser();
	
	public ConferenceManager(String[] arrayString) {
		if (arrayString.length == 0) {
			throw new IllegalArgumentException("arrayString could not be null!");
		}
		
		this.talks = parser.toTalkList(arrayString);
	}
	
	public ConferenceManager(List<String> stringList) {
		if (stringList == null || stringList.size() == 0) {
			throw new IllegalArgumentException("stringList could not be null or has size zero!");
		}
		
		this.talks = parser.toTalkList(stringList);
	}

	public List<Track> generateTracks() {
		if (this.isInsufficientTalks()) {
			throw new FewTalksException("You need more talks.");
		}
		
		this.putLightningTalksToEnd();
		
		int trackCount = 1;
		while (!this.talks.isEmpty()) {
			Track track = this.trackManager.generateTrack(this.talks, trackCount++);
			this.tracks.add(track);
			
			this.talks.removeAll(track.getAllTalks());
		}
		
		return this.tracks;
	}

	private boolean isInsufficientTalks() {
		return this.talks.getTotalTalkTimeInMinutes() / MINIMUM_TIME_PER_TRACK < 1;
	}
	
	private void putLightningTalksToEnd() {
		List<Talk> lightningTalks = new ArrayList<Talk>();
		
		for (Talk talk : this.talks) {
			if (talk.getDurationInMinutes() == 5) {
				lightningTalks.add(talk);
			}
		}
		
		this.talks.removeAll(lightningTalks);
		this.talks.addAll(lightningTalks);
	}	
}
