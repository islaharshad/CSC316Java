package edu.ncsu.csc316.security_log.manager;

import java.text.ParseException;



/**
 * Sorts the logFile and extracts the dates accordingly
 * @author Islahuddin Arshad
 *
 */
public class SortAndExtractDates {
	
	
	
	/**
	 * Sortes the logfiles by time and then extracts it from
	 * the start and end time
	 * @param list the list to be extracted from
	 * @param start the start time
	 * @param end the end time
	 * @return myArrayList<logFile> the extracted array based on time
	 */
	public MyArrayList<LogFile> extract(MyArrayList<LogFile> list, String start, String end) throws ParseException {
		MyArrayList<LogFile> secondArray = new MyArrayList<LogFile>();
		SortByDates sd = new SortByDates();
		int timeIndex = 0;
//		Date stime = sd.convertString(start);
//		Date etime = sd.convertString(end);
 
		
		MyArrayList<LogFile> sortedTimeArray = SortByDates.sort(list);
		
		

		
		
		
		while (sd.compareDates(((LogFile) sortedTimeArray.get(timeIndex)).getTime(), start) <= 0) {
			timeIndex++;
		}
		
		
		while (((timeIndex < sortedTimeArray.getSize()) && sd.compareDates(((LogFile) sortedTimeArray.get(timeIndex)).getTime(), end) <= 0)) {
			secondArray.insert(sortedTimeArray.get(timeIndex)); 
			timeIndex++;
		}
		
		
		
		
		
		return secondArray;
	}
}
