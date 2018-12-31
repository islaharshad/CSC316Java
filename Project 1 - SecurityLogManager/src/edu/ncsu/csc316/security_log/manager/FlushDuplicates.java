package edu.ncsu.csc316.security_log.manager;


/**
 * Flushes all duplicates and adds onto frequency
 * of occurances
 * @author Islahuddin Arshad
 *
 */
public class FlushDuplicates {
	
	/**
	 *Flushes all duplicates and adds to frequency in arraylist
	 *of logfiles
	 * @param sortedAlphabeticArray the array to be checked for duplicates and flushing
	 * @return myArrayList<logFile> arraylist of logfiles with not duplicates
	 */
	public MyArrayList<LogFile> flush(MyArrayList<LogFile> sortedAlphabeticArray) {
		MyArrayList<LogFile> temp = new MyArrayList<LogFile>();
		String check = ((LogFile) sortedAlphabeticArray.get(0)).getAction() + " " + ((LogFile) sortedAlphabeticArray.get(0)).getResource();
	
		int num = 0;
		int checker = 0; 

		while (checker < sortedAlphabeticArray.getSize()) {
			String check1 = ((LogFile) sortedAlphabeticArray.get(checker)).getAction() + " " + ((LogFile) sortedAlphabeticArray.get(checker)).getResource();
			if (check.equals(check1)) {
				num++;
			}
			else {
				
				((LogFile) sortedAlphabeticArray.get(--checker)).setFrequency(num);
				temp.insert((LogFile)sortedAlphabeticArray.get(checker));
				checker++;
				num = 1;
				check = check1;
				
			}
			checker++;
			
		}

		((LogFile) sortedAlphabeticArray.get(--checker)).setFrequency(num);
		temp.insert((LogFile)sortedAlphabeticArray.get(checker));
		return temp;
	}

}
	
	
	
	