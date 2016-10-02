package com.suelengc.conferencetrackmanager.model;

import java.util.Calendar;

public abstract class Session {
	private int maxDurationInMinutes;
	private Calendar startTime;
	private Calendar finishTime;
	
	Session(){}

	Session(Calendar startTime) {
		this.setStartTime(startTime);
	}

	Session(Calendar startTime, int maxDurationInMinutes) {
		this(startTime);
		this.setMaxDurationInMinutes(maxDurationInMinutes);
	}
	
	public Calendar getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public int getMaxDurationInMinutes() {
		return maxDurationInMinutes;
	}

	public void setMaxDurationInMinutes(int maxDurationInMinutes) {
		this.maxDurationInMinutes = maxDurationInMinutes;
	}
	
	public void print() {
		System.out.println(this);
	}
}
