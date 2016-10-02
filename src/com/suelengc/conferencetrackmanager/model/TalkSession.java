package com.suelengc.conferencetrackmanager.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.suelengc.conferencetrackmanager.util.DateTimeUtil;

public class TalkSession extends Session {

	private List<Talk> talks = new ArrayList<Talk>();

	public TalkSession(Calendar startTimeIn24H, int maxDurationInMinutes) {
		super(startTimeIn24H, maxDurationInMinutes);
	}

	public List<Talk> getTalks() {
		return this.talks;
	}

	public Talk getLastTalk() {
		if (this.talks == null || this.talks.size() == 0) {
			return null;
		}
		return this.talks.get(this.talks.size() - 1);
	}

	public void addTalk(Talk talk) {
		this.talks.add(talk);
	}

	@Override
	public String toString() {
		StringBuilder talksInString = new StringBuilder();
		for (Talk talk : talks) {
			talksInString.append(talk.toString());
			
			if (!getLastTalk().equals(talk) ) {
				talksInString.append("\n");
			}
		}
		return talksInString.toString();
	}
}
