package edu.ncsu.csc316.security_log.manager;

import java.text.ParseException;

/**
 * Sorts the logFile by action and resource
 * @author Islahuddin Arshad
 *
 */
public class SortByActionResource {

	/**The arraylist to be sorted*/
	public static MyArrayList<LogFile> sortedAlphaLog;
	
	
	/**
	 * Sorts the logfiles by action and resource
	 * the start and end time
	 * @param unsortedList the list to be sorted
	 * @return myArrayList<logFile> the extracted arraylist based on sort
	 * @throws ParseException if date can't be parced
	 */
	public MyArrayList<LogFile> sort(MyArrayList<LogFile> unsortedList) throws ParseException {
		SortByActionResource  sbar = new SortByActionResource();
		return sbar.mergeSortByActionResource(unsortedList);
		
	}
	
	/**
	 * Merges and sorted by action and resource
	 * @param unsortedList the list to be sorted
	 * @return myArrayList<logFile> the extracted arraylist based on sort
	 * @throws ParseException exception thrown if not parsed right
	 */
	public MyArrayList<LogFile> mergeSortByActionResource(MyArrayList<LogFile> unsortedList) throws ParseException {
		MyArrayList<LogFile> leftArray = new MyArrayList<LogFile>();
		MyArrayList<LogFile> rightArray = new MyArrayList<LogFile>();
		
		 
		int mid;
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
			
			leftArray = mergeSortByActionResource(leftArray); ///giving out error
			rightArray = mergeSortByActionResource(rightArray); ///giving out error
			sortActionResource(unsortedList, leftArray, rightArray);
		}
		
		return unsortedList;
		
		
	}
	

	/**
	 * Sorts the logfiles by date
	 * @param a the unsorted list
	 * @param leftArray the unsorted list
	 * @param rightArray the unsorted list
	 */
	public void sortActionResource(MyArrayList<LogFile> a, MyArrayList<LogFile> leftArray, MyArrayList<LogFile> rightArray) {
		
		
		MyArrayList<LogFile> emptyArray = new MyArrayList<LogFile>();
		int lc = 0;
		int rc = 0;
		int ac = 0;
		int ec = 0;
		while (lc < leftArray.getSize() && rc < rightArray.getSize()) {
			if  ((((LogFile) leftArray.get(lc)).getAction() + ((LogFile) leftArray.get(lc)).getResource()).compareTo(((LogFile) rightArray.get(rc)).getAction() + ((LogFile) rightArray.get(rc)).getResource()) < 0) { ///////////////////HOWW!!?????????????????????
				
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
	
	