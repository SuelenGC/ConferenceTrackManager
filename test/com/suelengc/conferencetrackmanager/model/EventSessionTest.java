package com.suelengc.conferencetrackmanager.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class EventSessionTest {

	@Test
	public void setTitleWhenNewInstanceTest() {
		// Action
		EventSession newSession = new EventSession(Calendar.getInstance(), "My New Session");
		
		// Validates
		String expectedSessionTitle = "My New Session";
		assertEquals(expectedSessionTitle, newSession.getTitle());
	}

}
