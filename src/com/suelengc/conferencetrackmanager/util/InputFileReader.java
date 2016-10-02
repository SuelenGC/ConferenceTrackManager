package com.suelengc.conferencetrackmanager.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

	public List<String> readFromFile(String fileName) {
		List<String> talksString = new ArrayList<String>();
		
		try {
			// Open the file.
			FileInputStream fstream = new FileInputStream(fileName);
			
			// Get object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			
			// Read File Line By Line
			while (strLine != null) {
				talksString.add(strLine);
				strLine = br.readLine();
			}
			
			// Close the input stream
			in.close();
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		return talksString;
	}
}