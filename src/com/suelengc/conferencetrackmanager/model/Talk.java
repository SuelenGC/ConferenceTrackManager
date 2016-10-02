package com.suelengc.conferencetrackmanager.model;

import java.util.Calendar;

import com.suelengc.conferencetrackmanager.util.DateTimeUtil;

public class Talk implements Comparable<Talk> {

	private String title;
	private Calendar start, finish;
	private int durationInMinutes;

	public Talk(String title, int duration) {
		this.title = title;
		this.setDurationInMinutes(duration);
	}

	public String getTitle() {
		return this.title;
	}

	public int getDurationInMinutes() {
		return this.durationInMinutes;
	}

	public void setStartAndFinishTime(Calendar start) {
		this.start = start;
		this.setFinishTime();
	}

	public Calendar getFinishTime() {
		return this.finish;
	}

	public Calendar getStartTime() {
		return this.start;
	}

	@Override
	public int compareTo(Talk o) {
		return o.getDurationInMinutes() - this.getDurationInMinutes();
	}

	@Override
	public String toString() {
		String talkInString = "";
		
		if (start != null) {
			 talkInString = DateTimeUtil.dateToString(this.getStartTime().getTime(), "hh:mma") + " "; 
		}
		
		return talkInString + this.getTitle();
	}

	void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	private void setFinishTime() {
		this.finish = (Calendar) this.getStartTime().clone();
		this.finish.add(Calendar.MINUTE, this.getDurationInMinutes());
	}
	
	public void print() {
		System.out.println(this);
	}
}
