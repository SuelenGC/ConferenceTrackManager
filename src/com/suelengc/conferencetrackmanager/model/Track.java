package com.suelengc.conferencetrackmanager.model;

import java.util.ArrayList;
import java.util.List;

import com.suelengc.conferencetrackmanager.util.DateTimeUtil;

public class Track {
	private int trackId;
	private List<Session> sessions;
	
	public Track(List<Session> sessions, int trackId) {
		this.sessions = sessions;
		this.trackId = trackId;
	}
	
	public List<Talk> getAllTalks() {
		List<Talk> allTalks = new ArrayList<Talk>();
		
		for (Session session : sessions) {
			if (session instanceof TalkSession) {
				TalkSession talkSession = (TalkSession) session;
				allTalks.addAll(talkSession.getTalks());
			}
		}
		
		return allTalks;
	}
	
	public void print() {
		System.out.println("\nTrack " + this.trackId);
		for (Session session : sessions) {
			session.print();
		}
	}
}
