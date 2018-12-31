package edu.ncsu.csc316.security_log.manager;




import java.text.ParseException;

import java.text.SimpleDateFormat;



/**
 * Sorts the array by dates
 * @author Islahuddin Arshad
 *
 */
public class SortByDates {

	/**The date object to be converted*/
	//private static Date date;
	/**The arraylist to be sorted*/
	//private static MyArrayList<LogFile> sortedLogList;
	/**The dateformat to be formatted with*/
	//private static DateFormat dFormat;

	
	/**
	 * Sorts the logfiles by date
	 * @param lg the unsorted list
	 * @return myArrayList<logFile> the extracted arraylist based on sort
	 * @throws ParseException if parse is unsuccesfull
	 */
	public static MyArrayList<LogFile> sort(MyArrayList<LogFile> lg) throws ParseException {
		SortByDates sd = new SortByDates();
		//sortedLogList = new MyArrayList<LogFile>();
		//sortedLogList = mergeSortByTimeStamp(lg);
		return sd.mergeSortByTimeStamp(lg); //sortedLogList;
	}
	
	/**
	 * Sorts the logfiles by date
	 * @param unsortedList the unsorted list
	 * @return myArrayList<logFile> the extracted arraylist based on sort
	 * @throws ParseException if parse is unsuccesfull
	 */
	public MyArrayList<LogFile> mergeSortByTimeStamp(MyArrayList<LogFile> unsortedList) throws ParseException {
		
		MyArrayList<LogFile> leftArray = new MyArrayList<LogFile>();
		MyArrayList<LogFile> rightArray = new MyArrayList<LogFile>();
		
		
		int mid;
		if (unsortedList.getSize() == 0)
		{
			return unsortedList;
		}
		if (unsortedList.getSize() == 1) {
			return unsortedList;
		}
		else {
			mid = unsortedList.getSize() / 2;
			
			int firstCounter = 0;
			while (firstCounter < mid) {
				leftArray.insert(unsortedList.get(firstCounter));
				firstCounter++;
			}
			int secondCounter = mid;
			while (secondCounter < unsortedList.getSize()) {
				rightArray.insert(unsortedList.get(secondCounter));
				secondCounter++;
			}
			
			
			leftArray = mergeSortByTimeStamp(leftArray);
			rightArray = mergeSortByTimeStamp(rightArray);
			mergeTimeStamp(unsortedList, leftArray, rightArray);
		}
		
		
		
		
		return unsortedList;
		
	}
	///
	
//	/**
//	 * Sorts the logfiles by date
//	 * @param lg the unsorted list
//	 * @param index the index to be unsorted at
//	 * @return Date the date object to be returned
//	 * @throws ParseException if parse is unsuccessful
//	 */
//	public Date convert(MyArrayList<LogFile> lg, int index) throws ParseException {
//		dFormat = new SimpleDateFormat("mm/dd/yy hh:mm:ssa");  ////check
//		String time = ((LogFile) lg.get(index)).getTime();
//		return dFormat.parse(time); //date;
//	}
//	
//	/**
//	 * Converts the string to date
//	 * @param timeString string to be converted
//	 * @return Date the convertedDate
//	 * @throws ParseException
//	 */
//	public Date convertString(String timeString) throws ParseException {
//		
//		dFormat = new SimpleDateFormat("mm/dd/yy hh:mm:ssa"); ///check
//		
//		return dFormat.parse(timeString); //date;
//	}
//
//	
	
	
	////
	
	
	/**
	 * Compares the string dates of the start and end time
	 * @param startTime the start timestamp
	 * @param endTime the end timestamp
	 * @return int if the start is less than end returns -1
	 */
	public int compareDates(String startTime, String endTime) {
		String[] sT = startTime.split("/|\\:| ");
		String[] eT = endTime.split("/|\\:| ");
		
		String sAMorPM = startTime.substring(Math.max(startTime.length() - 2, 0));
		String eAMorPM = endTime.substring(Math.max(endTime.length() - 2, 0));
		int sMonth = Integer.parseInt(sT[0]);
		int eMonth = Integer.parseInt(eT[0]);
		
		int sDay = Integer.parseInt(sT[1]);
		int eDay = Integer.parseInt(eT[1]);
		
		int sYear = Integer.parseInt(sT[2]);
		int eYear = Integer.parseInt(eT[2]);
		
		int sHour = Integer.parseInt(sT[3]);
		int eHour = Integer.parseInt(eT[3]);
		
		int sMinute = Integer.parseInt(sT[3]);
		int eMinute = Integer.parseInt(eT[3]);
		
		int sSecond = Integer.parseInt(sT[4]);
		int eSecond = Integer.parseInt(eT[4]);
			
			
		if (sYear > eYear) {
			return 1;
		}
		else if (sYear < eYear) {
			return -1;
		}
		else {
			if (sMonth > eMonth) {
				return 1;
			}
			else if (sMonth < eMonth) {
				return -1;
			}
			else {
				if (sDay > eDay) {
					return 1;
				}
				else if (sDay < eDay) {
					return -1;
				}
				else {
					if (sAMorPM.equals("AM") && eAMorPM.equals("PM")) {
						return -1;
					}
					else if (sAMorPM.equals("PM") && eAMorPM.equals("AM")) {
						return 1;
					}
					else {
						if (sHour > eHour) {
							return 1;
						}
						else if (sHour < eHour) {
							return -1;
						}
						else {
							if (sMinute > eMinute) {
								return 1;
							}
							else if (sMinute < eMinute) {
								return -1;
							}
							else {
								if (sSecond > eSecond) {
									return 1;
								}
								else if (sSecond < eSecond) {
									return -1;
								}
								else {
									return 0;
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Sorts the logfiles by date
	 * @param a the unsorted list
	 * @param leftArray the unsorted list
	 * @param rightArray the unsorted list
	 * @throws ParseException if parse is unsuccesful
	 */
	public void mergeTimeStamp(MyArrayList<LogFile> a, MyArrayList<LogFile> leftArray, MyArrayList<LogFile> rightArray) throws ParseException {
		
		
		MyArrayList<LogFile> emptyArray = new MyArrayList<LogFile>();
		int lc = 0;
		int rc = 0;
		int ac = 0;
		int ec = 0;
		while (lc < leftArray.getSize() && rc < rightArray.getSize()) {
			if  (compareDates(((LogFile) leftArray.get(lc)).getTime(), ((LogFile) rightArray.get(rc)).getTime()) < 0) {
//				if  (convert(leftArray, lc).compareTo(convert(rightArray, rc)) < 0) {
				a.setAt(ac, leftArray.get(lc));
				lc++;
			}
			else {
				a.setAt(ac, rightArray.get(rc));
				rc++;
			}
			ac++;
			
		}
		
		if (lc >= leftArray.getSize()) {
			emptyArray = rightArray;
			ec = rc;
		}
		else {
			emptyArray = leftArray;
			ec = lc;
		}
		int last = ec;
		while (last < emptyArray.getSize()) {
			a.setAt(ac, emptyArray.get(last));
			last++;
			ac++;
		}
		
		
	}
}
