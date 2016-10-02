package com.suelengc.conferencetrackmanager.model;

import java.util.Calendar;

import com.suelengc.conferencetrackmanager.util.DateTimeUtil;

public class EventSession extends Session {

	private static final int DEFAULT_MAX_DURATION = 180;
	private String title;
	
	public EventSession(Calendar startTimeIn24H, int maxDurationInMinutes, String title) {
		super(startTimeIn24H, maxDurationInMinutes);
		this.setTitle(title);
	}
	
	public EventSession(Calendar startTimeIn24H, String title) {
		super(startTimeIn24H, DEFAULT_MAX_DURATION); 
		this.setTitle(title);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return DateTimeUtil.dateToString(this.getStartTime().getTime(), "hh:mma") + " " + this.getTitle();
	}
	
}
