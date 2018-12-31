package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the sorting of action and resource if time is same
 * @author Islahuddin Arshad
 *
 */
public class SortByARIfTimeStampIsSameTest {

	/**The orginal array to be tested*/
	MyArrayList<LogFile> str;
	/**The sorted array*/
	MyArrayList<LogFile> str1;
	
	SortByARIfTimeStampIsSame sta;
	/**
	 * Set up of the orginal array
	 */
	@Before
	public void setUp() {
		str = new MyArrayList<LogFile>();
		str1 = new MyArrayList<LogFile>();
		
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "zct", "res", 6));
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "kct", "res", 5));
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "dct", "res", 5));
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "act", "res", 5));
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "zct", "res", 5)); 
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "mct", "res", 5));
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "zct", "res", 5)); 
		
	}

	/**
	 * Tests the sorting of action and resource if time is same
	 */
	@Test
	public void testSortByAlphaSameTime() {
		sta = new SortByARIfTimeStampIsSame();
		str1 = sta.sortByAlphaSameTime(str);
		assertEquals("Jon 1/18/2018 1:29:47PM act res 5", str1.get(0).toString());
		assertEquals("Jon 1/18/2018 1:29:47PM dct res 5", str1.get(1).toString());
		assertEquals("Jon 1/18/2018 1:29:47PM kct res 5", str1.get(2).toString());
		assertEquals("Jon 1/18/2018 1:29:47PM mct res 5", str1.get(3).toString());
		assertEquals("Jon 1/18/2018 1:29:47PM zct res 5", str1.get(4).toString());
		assertEquals("Jon 1/18/2018 1:29:47PM zct res 5", str1.get(5).toString());
		assertEquals("Jon 1/18/2018 1:29:47PM zct res 6", str1.get(6).toString());
	}

}
