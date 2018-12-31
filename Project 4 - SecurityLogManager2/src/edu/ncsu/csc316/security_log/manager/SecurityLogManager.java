package edu.ncsu.csc316.security_log.manager;
import java.util.concurrent.atomic.AtomicBoolean;
import edu.ncsu.csc316.security_log.dictionary.HashTable;
import edu.ncsu.csc316.security_log.dictionary.MySimpleDictionary;
import edu.ncsu.csc316.security_log.info.Entry;
import edu.ncsu.csc316.security_log.info.TimeObject;
import edu.ncsu.csc316.security_log.io.SecurityLogManagerIO;
import edu.ncsu.csc316.security_log.util.MyArrayList;
import edu.ncsu.csc316.security_log.util.MySort;

/**
 * The security log manager generates the user report and orgranizational report
 * 
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManager {

	
	/* The entries read from file */
	private MyArrayList<Entry> entries;
	/* The security io class being called */
	private SecurityLogManagerIO input;
	/* Start time of the time object */
	private TimeObject startT;
	/* End time of the time object */
	private TimeObject endT;

	

	/**
	 * Builds the entry object being read from path
	 * 
	 * @param path
	 *            the file path
	 */
	public SecurityLogManager(String path) {
		entries = new MyArrayList<Entry>();
		input = new SecurityLogManagerIO();
		entries = input.readEntries(path);
	}

	/**
	 * Gets the user report given a user name
	 * 
	 * @param username
	 *            the user name given
	 * @return String the appropriate format for user report
	 */
	public String getUserReport(String username) {
		
		HashTable<Entry> entryHash = new HashTable<Entry>();
		MyArrayList<Entry> list = new MyArrayList<Entry>();

		StringBuilder finalSb = new StringBuilder();

		finalSb.append("Activity Report for ");
		finalSb.append(username);
		finalSb.append("[\n");
		boolean found = false;
		for (int i = 0; i < entries.getSize(); i++) {
			Entry listEntry = (Entry) entries.get(i);
			if (listEntry.getName().equals(username)) {
				found = true;
				entryHash.insert(listEntry);
				list.insert(listEntry);
			}
		}

		MySort.mSByNameAndTime(list);

		for (int t = 0; t < list.getSize(); t++) {
			Entry uniqueEntry = (Entry) list.get(t);
			finalSb.append("   ");
			finalSb.append(uniqueEntry.getTime());
			finalSb.append(" - ");
			finalSb.append(uniqueEntry.getAction());
			finalSb.append(" ");
			finalSb.append(uniqueEntry.getResource());
			finalSb.append("\n");
		}

		if (!found) {
			finalSb.append("   No activity was recorded.\n");

		}
		finalSb.append("]");

		return finalSb.toString();

	}


	

	/**
	 * Generates the organizational profile given the start and end time
	 * @param start the start time
	 * @param end the end time
	 * @return String the appropriate formatted operational profile
	 */
	public String generateOperationalProfile(String start, String end) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("OperationalProfile");
		sb.append("[\n");
		
		startT = new TimeObject(start);
		endT = new TimeObject(end);
		

		Entry entry = null;
		HashTable<Entry> hashTable = new HashTable<Entry>();
		
		MyArrayList<Entry> entryList = new MyArrayList<Entry>();

		boolean entryFound = false;
		for (int i = 0; i < entries.getSize(); i++) {
			Entry entryToCheck = ((Entry) entries.get(i));
			if (entryToCheck.getTime().compareTo(startT) > 0 && entryToCheck.getTime().compareTo(endT) < 0) {
				entryFound = true;
				entry = hashTable.lookUp(entryToCheck);
				if (entry == null) {
					entryToCheck.setFrequency(1);
					hashTable.insert(entryToCheck);
					entryList.insert(entryToCheck);
				}
				else { 
					entry.incrementFrequency();
					hashTable.insert(entry);
					entryList.insert(entry);
				}
			}
			
		}
		AtomicBoolean isDuplicate = new AtomicBoolean(false);
		MyArrayList<Entry> uniqueList = new MyArrayList<>();
		System.out.println(entryList.getSize());
		for (int k = 0; k < entryList.getSize(); k++) {
			isDuplicate.set(false);
			Entry preEntry = (Entry) entryList.get(k);
			preEntry.setFrequency(1);
			if (uniqueList.getSize() > 0) {
				for (int l = 0; l < uniqueList.getSize(); l++) {
					Entry uniqueEntry = (Entry) uniqueList.get(l);
					if (preEntry.equals(uniqueEntry)) {
						isDuplicate.set(true);
						uniqueEntry.incrementFrequency();
					}
				}
				if (!isDuplicate.get()) {
					uniqueList.insert(preEntry);
				}
			}
			else {
				uniqueList.insert(preEntry);
			}
		}
		///StringBuilder dictionaryBuilder = new StringBuilder();
		int total = 0;
		MySimpleDictionary<String, Integer> occurance = new MySimpleDictionary<String, Integer>();
		for (int i = 0; i < uniqueList.getSize(); i++) {
			total += ((Entry) uniqueList.get(i)).getFrequency();
			//Entry uniqueEntry = (Entry) uniqueList.get(i);
			///dictionaryBuilder.append(uniqueList.get(i)).getAction());
			occurance.insert(((Entry) uniqueList.get(i)).getAction() + " " + ((Entry) uniqueList.get(i)).getResource(), ((Entry) uniqueList.get(i)).getFrequency());
		}
		
		occurance.mergeSorter();
		if (entryFound) {
			for (int z = 0; z < occurance.getMySize(); z++) {
				sb.append("   ");
				sb.append(occurance.getMyKey(z));
				sb.append(": frequency: ");
				sb.append(String.valueOf(occurance.getMyValue(z)));
				sb.append(", percentage: ");
				double p = Math.round((double) occurance.getMyValue(z) / (double) total * 1000.0) / 10.0; //gives the percentage
				sb.append(String.valueOf(p));
				sb.append("%");
				sb.append("\n");
			}
		}
		else {
			sb.append("No activity was recorded.");
		}

		
		sb.append("]");
		
		return sb.toString();

	}
	
	

}
