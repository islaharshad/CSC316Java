package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Checks to see if sorted by frequency or not
 * @author Islahuddin Arshad
 *
 */
public class SortByFrequencyTest {

	/** The logfile to be check*/
	MyArrayList<LogFile> ch;
	/** The sorted logfile*/
	MyArrayList<LogFile> lg;
	SortByFrequency sf;
	MyArrayList<LogFile> left, right, whole;
	int nRet;
	/**
	 * Inserts the unsorted logfiles into the sorted
	 */
	@Before
	public void setUp() {
		ch = new MyArrayList<LogFile>();
		
		lg = new MyArrayList<LogFile>();
		sf = new SortByFrequency();
		
		lg.insert(new LogFile("Taha", "1/18/2018 01:23:47PM", "check", "resource", 5));
		lg.insert(new LogFile("Moomna", "1/18/2018 01:34:47PM", "check", "redfsource", 56));
		lg.insert(new LogFile("Tasha", "1/18/2018 01:13:47PM", "check", "resofurce", 6));
		lg.insert(new LogFile("Tasha", "1/18/2018 01:13:47PM", "aheck", "resofurce", 6));
		lg.insert(new LogFile("Maha", "1/18/2018 01:03:47PM", "check", "aesoudfgrce", 9));
		lg.insert(new LogFile("Moomna", "1/18/2018 01:34:47PM", "aheck", "redfsource", 56));
		lg.insert(new LogFile("Islahuddin", "1/18/2018 01:09:47PM", "check", "redfgfsource", 12));
		
		left = new MyArrayList<LogFile>();
		right = new MyArrayList<LogFile>();
		whole = new MyArrayList<LogFile>();
		
		left.insert(new LogFile("Taha", "1/18/2018 01:23:47PM", "check", "resource", 5));
		right.insert(new LogFile("Moomna", "1/18/2018 01:34:47PM", "check", "redfsource", 56));
		whole.insert(null);
		whole.insert(null);
		
	}

	/**
	 * Tests the mergesort
	 */
	@Test
	public void testMergeSort() {
		ch = sf.mergeSort(lg);
		
		assertEquals("Moomna 1/18/2018 01:34:47PM aheck redfsource 56", ch.get(0).toString());
		assertEquals("Moomna 1/18/2018 01:34:47PM check redfsource 56", ch.get(1).toString());
		assertEquals("Islahuddin 1/18/2018 01:09:47PM check redfgfsource 12", ch.get(2).toString());
		assertEquals("Maha 1/18/2018 01:03:47PM check aesoudfgrce 9", ch.get(3).toString());
		assertEquals("Tasha 1/18/2018 01:13:47PM aheck resofurce 6", ch.get(4).toString());
		assertEquals("Tasha 1/18/2018 01:13:47PM check resofurce 6", ch.get(5).toString());
		assertEquals("Taha 1/18/2018 01:23:47PM check resource 5", ch.get(6).toString());
		
		
	}
	

	/**
	 * Tests the Sort
	 */
	@Test
	public void testMerge() {
		
		
		nRet = sf.merge(left, right,  whole);
		assertEquals(2, nRet);
		assertEquals("Moomna 1/18/2018 01:34:47PM check redfsource 56", whole.get(0).toString());
		assertEquals("Taha 1/18/2018 01:23:47PM check resource 5", whole.get(1).toString());
		
	}

}
