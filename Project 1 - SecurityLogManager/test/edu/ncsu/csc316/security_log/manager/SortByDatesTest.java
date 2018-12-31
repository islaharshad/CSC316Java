package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

/**
 * Checks the sort by dates
 * @author Islahuddin Arshad
 *
 */
public class SortByDatesTest {

	/**The orifinal array to be tested*/
	MyArrayList<LogFile> lg;
	/**The final array which is sorted*/
	MyArrayList<LogFile> lgFinal;
	///SortByDates sd;
	
	/**
	 * Sets up the original array
	 */
	@Before
	public void setUp() {
		
		lg  = new MyArrayList<LogFile>();
		lgFinal = new MyArrayList<LogFile>();
		//sd = new SortByDates();
		lg.insert(new LogFile("Taha", "1/18/2018 1:21:21PM", "get", "information", 0));
		lg.insert(new LogFile("Islahuddin", "1/19/2018 1:23:47PM", "recieve", "database" , 0)); 
		lg.insert(new LogFile("Moomna", "1/17/2018 1:25:01PM", "act", "school", 0)); 
		lg.insert(new LogFile("Islahuddin", "1/18/2018 1:29:47PM", "recieve", "database", 0));
	}

	/**
	 * Test the sorting of the dates
	 */
	@Test
	public void testSort() throws ParseException {
		lgFinal = SortByDates.sort(lg);
		
		assertEquals("Moomna 1/17/2018 1:25:01PM act school 0", lgFinal.get(0).toString());
		assertEquals("Taha 1/18/2018 1:21:21PM get information 0", lgFinal.get(1).toString());
		assertEquals("Islahuddin 1/18/2018 1:29:47PM recieve database 0", lgFinal.get(2).toString());
		assertEquals("Islahuddin 1/19/2018 1:23:47PM recieve database 0", lgFinal.get(3).toString());
	}
	
	
}
