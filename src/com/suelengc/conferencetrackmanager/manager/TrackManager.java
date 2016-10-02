package com.suelengc.conferencetrackmanager.manager;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.suelengc.conferencetrackmanager.model.EventSession;
import com.suelengc.conferencetrackmanager.model.Session;
import com.suelengc.conferencetrackmanager.model.Talk;
import com.suelengc.conferencetrackmanager.model.TalkSession;
import com.suelengc.conferencetrackmanager.model.Track;
import com.suelengc.conferencetrackmanager.util.DateTimeUtil;

public class TrackManager {

	private static final int LUNCH_SESSION_START_HOUR = 12;
	private static final int AFTERNOON_SESSION_START_HOUR = 13;
	private static final int MORNING_SESSION_START_HOUR = 9;
	private static final String LUNCH = "Lunch";
	private static final String NETWORKING_EVENT = "Networking Event";
	private static final int HOUR_IN_MINUTES = 60;

	public Track generateTrack(List<Talk> talks, int trackId) {
		SessionManager sessionManager = new SessionManager();
		
		int startHoursIn24H, startMinutes;
		
		//Get Morning Session
		startHoursIn24H = MORNING_SESSION_START_HOUR;
		TalkSession morning = new TalkSession(DateTimeUtil.toCalendar(startHoursIn24H), HOUR_IN_MINUTES * 3);
		talks = sessionManager.fillSessionWithTalks(morning, talks);
		
		//Get Afternoon Session
		startHoursIn24H = AFTERNOON_SESSION_START_HOUR;
		TalkSession afternoon = new TalkSession(DateTimeUtil.toCalendar(startHoursIn24H), HOUR_IN_MINUTES * 4);
		talks = sessionManager.fillSessionWithTalks(afternoon, talks);
		
		//Get Lunch Session
		startHoursIn24H = LUNCH_SESSION_START_HOUR;
		EventSession lunch = new EventSession(DateTimeUtil.toCalendar(startHoursIn24H), HOUR_IN_MINUTES, LUNCH);
		
		//Get Networking Session
		startHoursIn24H = afternoon.getFinishTime().get(Calendar.HOUR_OF_DAY);
		startMinutes = afternoon.getFinishTime().get(Calendar.MINUTE);
		EventSession networking = new EventSession(DateTimeUtil.toCalendar(startHoursIn24H, startMinutes), NETWORKING_EVENT);

		List<Session> sessions = Arrays.asList(morning, lunch, afternoon, networking);
		
		return new Track(sessions, trackId);
	}

}
