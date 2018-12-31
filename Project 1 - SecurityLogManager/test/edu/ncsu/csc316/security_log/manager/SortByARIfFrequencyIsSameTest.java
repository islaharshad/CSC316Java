package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test if the sort for action and resource works if freq is same
 * @author Islahuddin Arshad
 *
 */
public class SortByARIfFrequencyIsSameTest {

	/**The original logfile*/
	MyArrayList<LogFile> str;
	/**The unoriginal logfile*/
	MyArrayList<LogFile> str1;
	
	
	SortByARIfFrequencyIsSame sfa;
	/**
	 * Sets up the test
	 */
	@Before
	public void setUp() {
		str = new MyArrayList<LogFile>();
		str1 = new MyArrayList<LogFile>();
		

		str.insert(new LogFile("Jon", "1/18/2018 1:30:47PM", "zet", "press", 4));
		str.insert(new LogFile("Jon", "1/18/2018 1:31:47PM", "check", "resd", 4));
		str.insert(new LogFile("Jon", "1/18/2018 1:32:47PM", "look", "redfs", 4));
		str.insert(new LogFile("Jon", "1/18/2018 1:33:47PM", "make", "refs", 3));
		str.insert(new LogFile("Jon", "1/18/2018 1:33:47PM", "make", "fgfs", 3));
		str.insert(new LogFile("Jon", "1/18/2018 1:33:47PM", "make", "fgfs", 2));
		str.insert(new LogFile("Jon", "1/18/2018 1:33:47PM", "make", "zgfs", 1));
		str.insert(new LogFile("Jon", "1/18/2018 1:33:47PM", "make", "agfs", 1));
	}

	/**
	 * Tests the main method
	 */
	@Test
	public void testsortByAlphaSameFreq() {
		sfa = new SortByARIfFrequencyIsSame();
		str1 = sfa.sortByAlphaSameFreq(str);
		assertEquals("Jon 1/18/2018 1:31:47PM check resd 4", str1.get(0).toString());
		assertEquals("Jon 1/18/2018 1:32:47PM look redfs 4", str1.get(1).toString());
		assertEquals("Jon 1/18/2018 1:30:47PM zet press 4", str1.get(2).toString());
		
		assertEquals("Jon 1/18/2018 1:33:47PM make fgfs 3", str1.get(3).toString());
		assertEquals("Jon 1/18/2018 1:33:47PM make refs 3", str1.get(4).toString());
		
		assertEquals("Jon 1/18/2018 1:33:47PM make fgfs 2", str1.get(5).toString());
		
		assertEquals("Jon 1/18/2018 1:33:47PM make agfs 1", str1.get(6).toString());
		assertEquals("Jon 1/18/2018 1:33:47PM make zgfs 1", str1.get(7).toString());
	}

}
