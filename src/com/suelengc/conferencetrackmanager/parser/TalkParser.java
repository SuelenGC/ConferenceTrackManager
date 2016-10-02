package com.suelengc.conferencetrackmanager.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.suelengc.conferencetrackmanager.model.Talk;
import com.suelengc.conferencetrackmanager.model.Talks;

public class TalkParser {

	private static final String LIGHTNING = "lightning";

	public Talk toTalk(String strTalk) {
		String title = strTalk;
		int duration = this.getDuration(strTalk);
		
		return new Talk(title, duration);
	}

	public Talks toTalkList(String[] arrayTalks) {
		Talks talks = new Talks();
		
		Talk talk;
		for (int index = 0; index < arrayTalks.length; index++) {
			talk =  this.toTalk(arrayTalks[index]);
			talks.add(talk);
		}
		
		return talks;
	}
	
	public Talks toTalkList(List<String> talksStringList) {
		Talks talks = new Talks();
		
		Talk talk;
		for (String stringTalk : talksStringList) {
			talk =  this.toTalk(stringTalk);
			talks.add(talk);	
		}
		
		return talks;
	}
	
	private int getDuration(String strTalk) {
		String strDuration = strTalk.substring(strTalk.lastIndexOf(" ")).replace("min", "").trim();
		
		if (strDuration.equals(LIGHTNING)) {
			return 5;
			
		} else {
			return Integer.parseInt(strDuration);
		}
	}
}
