package com.suelengc.conferencetrackmanager.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.suelengc.conferencetrackmanager.util.InputFileReader;

public class InputFileReaderTest {

	@Test
	public void readFromFileTest() {
		// Action
		InputFileReader reader = new InputFileReader();
		
		List<String> stringList = reader.readFromFile("res/input.txt");
		
		// Validates
		String expectedFirstString = "Writing Fast Tests Against Enterprise Rails 60min";
		String firstString = stringList.get(0);
		assertEquals(expectedFirstString, firstString);
		
		
		String expectedSecondString = "Overdoing it in Python 45min";
		String secondString = stringList.get(1);
		assertEquals(expectedSecondString, secondString);
		
	}

}
