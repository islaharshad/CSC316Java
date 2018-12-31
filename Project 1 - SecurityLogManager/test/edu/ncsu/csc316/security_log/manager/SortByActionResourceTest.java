package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests sort by action and resource
 * @author Islahuddin Arshad
 *
 */
public class SortByActionResourceTest {

	/** The original arraylist*/
	MyArrayList<LogFile> str;
	/**The final arrayList*/
	MyArrayList<LogFile> str1;
	SortByActionResource strum;
	/**
	 * Sets up the test
	 */
	@Before
	public void setUp() {
		
		str = new MyArrayList<LogFile>();
		str1 = new MyArrayList<LogFile>();
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "zct", "res", 6));
		str.insert(new LogFile("Jon", "1/18/2018 1:29:47PM", "act", "res", 5));
		str.insert(new LogFile("Jon", "1/18/2018 1:30:47PM", "get", "press", 4));

	}

	/**
	 * Tests the sorting
	 * @throws ParseException
	 */
	@Test
	public void testSort() throws ParseException {
		strum = new SortByActionResource();
		str1 = strum.sort(str);
		
		assertEquals("Jon 1/18/2018 1:29:47PM act res 5", str1.get(0).toString());
		assertEquals("Jon 1/18/2018 1:29:47PM zct res 6", str1.get(2).toString());
	}

}
