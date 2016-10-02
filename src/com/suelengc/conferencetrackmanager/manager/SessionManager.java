package com.suelengc.conferencetrackmanager.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.suelengc.conferencetrackmanager.model.Talk;
import com.suelengc.conferencetrackmanager.model.TalkSession;

public class SessionManager {
	
	public List<Talk> fillSessionWithTalks(TalkSession session, List<Talk> talks) {
		List<Talk> inputedTalks = new ArrayList<Talk>(talks);

		int remainingTime = session.getMaxDurationInMinutes();
		Calendar auxTime = (Calendar) session.getStartTime().clone();

		for (Talk talk : talks) {
			if (hasTimeForTalk(remainingTime, talk)) {

				int nextRemainingTime = remainingTime - talk.getDurationInMinutes();
				if (afterThisTalkWillHaveTimeForAtLeast30MinTalk(talk, nextRemainingTime)) {
					continue;
				}

				// Update remaining session time
				remainingTime -= talk.getDurationInMinutes();

				// Set current talk start hour
				talk.setStartAndFinishTime((Calendar) auxTime.clone());

				// Add talk to this session
				session.addTalk(talk);

				// Update talkStartHour to next talk
				auxTime.add(Calendar.MINUTE, talk.getDurationInMinutes());

				// Remove this talk from inputed talk list
				inputedTalks.remove(talk);
			}

			// If this session do not have more time, quit
			if (remainingTime == 0) {
				break;
			}
		}
		
		//Update session finish time
		session.setFinishTime(auxTime);

		// Return remaining talks that do not fits in this session
		return inputedTalks;
	}
	
	private boolean hasTimeForTalk(int remainingTime, Talk talk) {
		return remainingTime / talk.getDurationInMinutes() >= 1;
	}
	
	private boolean afterThisTalkWillHaveTimeForAtLeast30MinTalk(Talk talk, int nextRemainingTime) {
		boolean remainingTimeFitAtLeast30MinTalk = !(nextRemainingTime / 15 <= 1);
		return nextRemainingTime > 0 && !remainingTimeFitAtLeast30MinTalk;
	}
}
