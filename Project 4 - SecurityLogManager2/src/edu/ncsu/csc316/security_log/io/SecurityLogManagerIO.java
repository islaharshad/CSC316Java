package edu.ncsu.csc316.security_log.io;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import edu.ncsu.csc316.security_log.info.Entry;
import edu.ncsu.csc316.security_log.util.MyArrayList;

/**
 * Reads the entry files and converts them into log entry objects
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManagerIO {

	/**
	 * Reads the entries from the file
	 * @param nameOfFile the name of the file to reade from
	 * @return MyArrayList<Entry> the read enty objects
	 */
	public MyArrayList<Entry> readEntries(String nameOfFile) {
		
		MyArrayList<Entry> logEntries = new MyArrayList<Entry>();
		String lineToRead;
		int one;
		int two;
		int three;
		
		String name;
		String time;
		String action;
		String resource;
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(nameOfFile))) {
			br.readLine();
			while ((lineToRead = br.readLine()) != null) {
				one = lineToRead.indexOf(',');
				two = lineToRead.indexOf(',', one + 1);
				three = lineToRead.indexOf(',', two + 1);
				
				resource = lineToRead.substring(three + 2);
				action = lineToRead.substring(two + 2, three);
				time = lineToRead.substring(one + 2, two);
				name = lineToRead.substring(0, one);
				
				logEntries.insert(new Entry(name, time, action, resource, 0));
			}
			
		} catch (IOException e) {
			System.exit(1);
		}
		return logEntries;
	}
}
