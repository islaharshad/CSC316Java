package edu.ncsu.csc316.security_log.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Sorts and array by action and resource if frequency is same
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManager {

	/**The filepath from the input*/
	private String inputFilePath;
	/**The array to be sorted alphabetically*/
	private MyArrayList<LogFile> sortedAlphabeticArray;
	/**The logs to be taken*/
	private MyArrayList<LogFile> logs;
	/**A temp for logs*/
	private MyArrayList<String> sampleLogs;
	/**The array containing the duplciates*/
	private MyArrayList<LogFile> flushedDuplicatesArray;
	/**The array sorted out by frequency and action*/
	private MyArrayList<LogFile> frequencyAndActionSortedArray;
	/**The array to be moved around*/
	private MyArrayList<LogFile> secondArray;
	/**The array to be sorted by frequency*/
	private MyArrayList<LogFile> sortedFrequency;
	/**The logs to test for array*/
	private LogFile lg;

	private SortByARIfFrequencyIsSame sfa;
	private SortByARIfTimeStampIsSame sta;
	private FlushDuplicates fda;
	private SortAndExtractDates sdta;
	private SortByActionResource sar;

	
	/**
	 * Constructs a new SecurityLogManager given
	 * the path to the input user activity log file.
	 * @param filePath - the path to the user activity log file
	 * @throws FileNotFoundException if file not found
	 * @throws ParseException if unparseable
	 */
	public SecurityLogManager(String filePath) 
	{
	  File file = null;
	try {
		file = checkFile(filePath);
	} catch (FileNotFoundException e) { ////MADE CHANGES
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		this.logs = makeUnsortedList(file);
		if(this.logs.getSize() == 0)
		{
			System.out.println("Err1: Failed to load logs form path: " + filePath);
		}
	} catch (FileNotFoundException e) { //////////////////////MADE CHANGES
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}	
	
	/**
	 * Checks the file if valid or not
	 * @param filePath the filepath to be taken
	 * @return File the file to be returned
	 * @throws FileNotFoundException throw if file not found
	 */
	public File checkFile(String filePath) throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
		File file = new File(filePath);
		int nTries = 0;
		while (!file.exists()) {
			System.out.println("Please enter the file name you wish to read from:");
			if (input.hasNextLine()) {
				inputFilePath = input.nextLine(); /////Chcking
				file = new File(inputFilePath);
			}
			nTries = nTries + 1;
			if(nTries > 4)
				break;
			
		}
		input.close();
		return file;
		
	}
	
	
	/**
	 * Makes an unsorted list by parsing the given file
	 * @param file to be parsed
	 * @return arraylist of logfiles to be populated from the file
	 */
	public MyArrayList<LogFile> makeUnsortedList(File file) throws FileNotFoundException {
		logs = new MyArrayList<LogFile>();
		sampleLogs = new MyArrayList<String>();
		
		
		String logString = "";
		
		
		Scanner read = new Scanner(file);
		while (read.hasNextLine()) {
			String line = read.nextLine();
			sampleLogs.insert(line);
		}
		
		for (int i = 1; i < sampleLogs.getSize(); i++) {
			
			logString = (String) sampleLogs.get(i);
			String[] splitter = logString.split(", ");
			
			lg = (LogFile) new LogFile(splitter[0], splitter[1], splitter[2], splitter[3], 0);
			
			logs.insert(lg); 
			
			
		}
		
		read.close();
		return logs;
	}
	
	/**
	 * Calculates the sum of the frequencies
	 * @param list the list whose frequency needs to be summed
	 * @param num the number to be taken
	 * @return int the sum of frequencies
	 */
	public int getSum(MyArrayList<LogFile> list, int num) {
		if(num < 0)
		{
			return -1;
		}
		else if (num == 0) {
			return ((LogFile) list.get(num)).getFrequency();
		}
		else {
			return ((LogFile) list.get(num)).getFrequency() + getSum(list, num - 1);
		}
	}
	
	
	/**
	 * Produces an operational profile of user activity
	 * performed between the given start and end dates (inclusive)
	 * 
	 * @param start - the start date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @param end - the end date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @return a string representing the operational profile
	 * @throws ParseException 
	 */
	public String generateOperationalProfile(String start, String end) 
	{
		int sum = 0;
		secondArray = new MyArrayList<LogFile>();
		SortByFrequency sf = new SortByFrequency();
		sar = new SortByActionResource();
		sfa = new SortByARIfFrequencyIsSame();
		sdta = new SortAndExtractDates();
		fda = new FlushDuplicates();
		try {
			secondArray = sdta.extract(logs, start, end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} ////sort dates first and then extract them from start to end time
		
		sortedAlphabeticArray = new MyArrayList<LogFile>();
		
		
		
		try {
			sortedAlphabeticArray = sar.sort(secondArray);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} ///Now sort the extracted array above by action + resource
		
		flushedDuplicatesArray = new MyArrayList<LogFile>();
		
		flushedDuplicatesArray = fda.flush(sortedAlphabeticArray); ////duplicates are flushed and their frequency is recorded
		
		sortedFrequency = new MyArrayList<LogFile>();
		
		sortedFrequency = sf.mergeSort(flushedDuplicatesArray); ////now sort by frequency
		
		frequencyAndActionSortedArray = new MyArrayList<LogFile>();
		/////
		frequencyAndActionSortedArray = sfa.sortByAlphaSameFreq(sortedFrequency);	//sort by A + R if frequency is same
		
		sum = getSum(frequencyAndActionSortedArray, frequencyAndActionSortedArray.getSize() - 1);
		////calculate percentage:
		
		double num = 0;
		int scaler = (int) Math.pow(10, 1);
		StringBuilder sb = new StringBuilder();
		sb.append("OperationalProfile[\n");
		for (int k = 0; k < frequencyAndActionSortedArray.getSize(); k++) {
			num = ((double)((LogFile) frequencyAndActionSortedArray.get(k)).getFrequency());
			sb.append("   " + ((LogFile) frequencyAndActionSortedArray.get(k)).getAction() + " " + 
					((LogFile) frequencyAndActionSortedArray.get(k)).getResource() + ": frequency: " +
					((LogFile) frequencyAndActionSortedArray.get(k)).getFrequency() + ", percentage: " +
					(double) Math.round(num / sum * 100 * scaler) / scaler  + "%\n"
					);

		}
		sb.append("]");
		
		return sb.toString();

	}
	
	
	/**
	 * Produces a list of log entries for a given 
	 * user. The output list is sorted chronologically.
	 * 
	 * @param username - the user for which to generate a report
	 * @return a string representing the user report
	 */
	public String getUserReport(String username)
	{
		MyArrayList<LogFile> userList = new MyArrayList<LogFile>();
		MyArrayList<LogFile> finalUserList = new MyArrayList<LogFile>();
		MyArrayList<LogFile> aRSorted = new MyArrayList<LogFile>();
		sar = new SortByActionResource();
		sta = new SortByARIfTimeStampIsSame();
		boolean exists = false;
		
		for (int i = 0; i < logs.getSize(); i++) {
			
			if (username.equals(((LogFile) logs.get(i)).getUser())) {
				exists = true;
				userList.insert(logs.get(i));
			}
		}
		
		 
		if (exists) {
			try {
				aRSorted = sar.sort(userList);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finalUserList = sta.sortByAlphaSameTime(aRSorted);
			
			StringBuilder userString = new StringBuilder();
			userString.append("Activity Report for " + username + "[\n");
			for (int i = 0; i < finalUserList.getSize(); i++) {
				userString.append("   " + ((LogFile) finalUserList.get(i)).getTime() + " - " + 
			    ((LogFile) finalUserList.get(i)).getAction() + " " + 
				((LogFile) finalUserList.get(i)).getResource() + "\n");
				
			}
			userString.append("]");
			
			return userString.toString();
		}
		else {
			return "No activity was recorded";
		}
	}
	
}
