package com.suelengc.conferencetrackmanager.model;

import java.util.ArrayList;

public class Talks extends ArrayList<Talk> {

	public int getTotalTalkTimeInMinutes() {
		int sum = 0;
		for (Talk talk : this) {
			sum += talk.getDurationInMinutes();
		}
		return sum;
	}
	
}
