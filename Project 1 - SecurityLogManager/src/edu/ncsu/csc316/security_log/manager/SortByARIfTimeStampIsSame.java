package edu.ncsu.csc316.security_log.manager;

import java.text.ParseException;

/**
 * Sorts and array by action and resource if timestamp is same
 * @author Islahuddin Arshad
 *
 */
public class SortByARIfTimeStampIsSame {
 

	/**
	 * Sorts the logfiles by action and resource
	 * if timestamp is the same
	 * @param str the arraylist to be sorted
	 * @return myArrayList<logFile> the extracted arraylist based on sort if timestamp is same
	 */
	public MyArrayList<LogFile> sortByAlphaSameTime(MyArrayList<LogFile> str) {
		MyArrayList<LogFile> finalArray = new MyArrayList<LogFile>();
		MyArrayList<LogFile> str1 = new MyArrayList<LogFile>();
		SortByActionResource strum = new SortByActionResource();
		int counter = 0;
		int j = 0;
 
		for (int i = 0; i < str.getSize(); i++) {
			j = i + 1;

				 
				if ( (j <= str.getSize() - 1) && (((LogFile) str.get(i)).getTime().equals(((LogFile) str.get(j)).getTime()))) {
					str1.insert(str.get(i));
					counter++;
				}
				else {
					
					if (counter > 0) { 
						str1.insert(str.get(i));
						try {
							str1 = strum.sort(str1);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (int k = 0; k < str1.getSize(); k++) {
							finalArray.insert(str1.get(k));
						}
						str1.reset();

					}
					else { 
						finalArray.insert(str.get(i)); 
					}
					
					counter = 0;

					
				}
				
			}
		return finalArray;
	}
}
