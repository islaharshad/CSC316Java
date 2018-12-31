package edu.ncsu.csc316.security_log.util;

import edu.ncsu.csc316.security_log.info.Entry;
import edu.ncsu.csc316.security_log.info.TimeObject;

/**
 * Sorts the entries based on specific criteria
 * @author Islahuddin Arshad
 *
 */
public class MySort {

	/*The log entries to be sorted*/
	private static MyArrayList<Entry> logEntries;
	
	/**
	 * Sorts by name and then time
	 * @param logs the entries to be sorted
	 */
	public static void mSByNameAndTime(MyArrayList<Entry> logs) {
		logEntries = logs;
		mSByNameAndTime(0, logEntries.getSize() - 1);
		logEntries = null;
	}
	
	
	/**
	 * Helper method to merge sort by name and time
	 * @param s the start of the entry list
	 * @param e the end of the entry list
	 */
	private static void mSByNameAndTime(int s, int e) {
		
//		Long t1 = System.currentTimeMillis();
		//System.out.println(System.currentTimeMillis());
		
		if (s < e) {
			int m = (s + e) / 2;
			mSByNameAndTime(s, m);
			mSByNameAndTime(m + 1, e);

			int size = e - s + 1;
			MyArrayList<Entry> checkEntries = new MyArrayList<>(size);
			int lc = s;
			int rc = m + 1;
			while (checkEntries.getSize() != size) {
				if (lc > m) {
					checkEntries.insert(logEntries.get(rc++));
				}
				else if (rc > e) {
					checkEntries.insert(logEntries.get(lc++));
				}
				else {
					String rcAction = ((Entry) logEntries.get(rc)).getName();
					String lcAction = ((Entry) logEntries.get(lc)).getName();
					
					if (lcAction.compareTo(rcAction) < 0) {
						checkEntries.insert(logEntries.get(lc++));
					}
					else if (lcAction.compareTo(rcAction) > 0) {
						checkEntries.insert(logEntries.get(rc++));
					}
					else {
						
						TimeObject rcTime = ((Entry) logEntries.get(rc)).getTime();

						TimeObject lcTime = ((Entry) logEntries.get(lc)).getTime();
						
						if (lcTime.compareTo(rcTime) < 0) {
							checkEntries.insert(logEntries.get(lc++));
						}
						else if (lcTime.compareTo(rcTime) > 0) {
							checkEntries.insert(logEntries.get(rc++));
						}
						else {

							String rAR = new StringBuilder()
									.append(((Entry) logEntries.get(rc)).getAction())
									.append(" ")
									.append(((Entry) logEntries.get(rc)).getResource())
									.toString();

							String lAR = new StringBuilder()
									.append(((Entry) logEntries.get(lc)).getAction())
									.append(" ")
									.append(((Entry) logEntries.get(lc)).getResource())
									.toString();
							
							if (lAR.compareTo(rAR) > 0) {
								checkEntries.insert(logEntries.get(rc++));
							}
							else {
								checkEntries.insert(logEntries.get(lc++));
							}
						}
					}
				}
			}

			int i = s;
			while (i <= e) {
				logEntries.setAt(i, checkEntries.get(i - s));
				i++;
			}
			
		}
		
//		Long t2 = System.currentTimeMillis();
//		System.out.println(t2-t1);
	}
	
	
	/**
	 * Merge sort by time
	 * @param logs the entries to be sorted by time
	 */
	public static void mSByTime(MyArrayList<Entry> logs) {
		logEntries = logs;
		if (logEntries != null) {
			mSByTime(0, logEntries.getSize() - 1);
			logEntries = null;
		}
		
	}
	
	/**
	 * Helper method to merge sort by time
	 * @param s the start time
	 * @param e the end time
	 */
	private static void mSByTime(int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			mSByTime(s, m);
			mSByTime(m + 1, e);
			
			int size = e - s + 1;
			MyArrayList<Entry> checkEntries = new MyArrayList<Entry>(size);
			int lc = s;
			int rc = m + 1;
			while (checkEntries.getSize() != size) {
				if (lc > m) {
					checkEntries.insert(logEntries.get(rc++));
				}
				else if (rc > e) {
					checkEntries.insert(logEntries.get(lc++));
				}
				else if (((Entry) logEntries.get(lc)).getTime().compareTo(((Entry) logEntries.get(rc)).getTime()) < 0) {
					checkEntries.insert(logEntries.get(lc++));
				}
				else if (((Entry) logEntries.get(lc)).getTime().compareTo(((Entry) logEntries.get(rc)).getTime()) > 0) {
					checkEntries.insert(logEntries.get(rc++));
				}
				else {

					String rcStr = new StringBuilder()
							.append(((Entry) logEntries.get(rc)).getAction())
							.append(" ")
							.append(((Entry) logEntries.get(rc)).getResource())
							.toString();
					String lcStr = new StringBuilder()
							.append(((Entry) logEntries.get(lc)).getAction())
							.append(" ")
							.append(((Entry) logEntries.get(lc)).getResource())
							.toString();

					if (lcStr.compareTo(rcStr) > 0) {
						checkEntries.insert(logEntries.get(rc++));
					}
					else {
						checkEntries.insert(logEntries.get(lc++));
					}
				}
			}
			
			int i = s;
			while (i <= e) {
				logEntries.setAt(i, checkEntries.get(i - s));
				i++;
			}
			
		}
	}
	
	
	/**
	 * Sorts by action and resource
	 * @param logs the entries to be sorted by action and resource
	 */
	public static void mSByAR(MyArrayList<Entry> logs) {
		logEntries = logs;
		mSByAR(0, logEntries.getSize() - 1);
		logEntries = null;
	}
	
	/**
	 * Helper method to merge sort action and resouce
	 * @param s the start of the entry list
	 * @param e the end of the entry list
	 */
	private static void mSByAR(int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			mSByAR(s, m);
			mSByAR(m + 1, e);

			
			int size = e - s + 1;
			MyArrayList<Entry> checkEntries = new MyArrayList<>(size);
			int lc = s;
			int rc = m + 1;
			while (checkEntries.getSize() != size) {
				if (lc > m) {
					checkEntries.insert(logEntries.get(rc++));
				}
				else if (rc > e) {
					checkEntries.insert(logEntries.get(lc++));
				}
				else {
					String rcA = ((Entry) logEntries.get(rc)).getAction();
					String lcA = ((Entry) logEntries.get(lc)).getAction();
					

					if (lcA.compareTo(rcA) < 0) {
						checkEntries.insert(logEntries.get(lc++));
					}
					else if (lcA.compareTo(rcA) > 0) {
						checkEntries.insert(logEntries.get(rc++));
					}
					else {
						
						String rcR = ((Entry) logEntries.get(rc)).getResource();
						String lcR = ((Entry) logEntries.get(lc)).getResource();
						
						if (lcR.compareTo(rcR) > 0) {
							checkEntries.insert(logEntries.get(rc++));
						}
						else {
							checkEntries.insert(logEntries.get(lc++));
						}
					}
				}
			}

			int i = s;
			while (i <= e) {
				logEntries.setAt(i, checkEntries.get(i - s));
				i++;
			}
		}
	}
	
}
