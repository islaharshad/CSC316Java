package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the extraction and sortation of logfile lists
 * @author Islahuddin Arshad
 *
 */
public class SortAndExtractDatesTest {

	/**The unsorted and unextracted file from dates*/
	MyArrayList<LogFile> lg;
	/**The sorted and extracted file from dates*/
	MyArrayList<LogFile> lgFinal;
	/**The start time*/
	String start;
	/**The end time*/
	String end;
	
	SortAndExtractDates sdta;
	
	/**
	 * Tests the sort and extractions
	 */
	@Before
	public void setUp() {
		
		lg = new MyArrayList<LogFile>();
		lgFinal = new MyArrayList<LogFile>();
		lg.insert(new LogFile("Taha", "1/18/2018 1:21:21PM", "get", "information", 0));
		lg.insert(new LogFile("Islahuddin", "1/18/2018 1:23:47PM", "recieve", "database", 4));
		lg.insert(new LogFile("Moomna", "1/18/2018 1:25:00PM", "act", "school", 5));
		lg.insert(new LogFile("Moomna", "1/18/2018 1:25:01PM", "act", "school", 5));
		lg.insert(new LogFile("Islahuddin", "1/18/2018 1:29:47PM", "recieve", "database", 4));
		start = "1/18/2018 1:21:21PM";
		end =  "1/18/2018 1:25:00PM";
	}

	/**
	 * Tests the extraction of dates
	 * @throws ParseException
	 */
	@Test
	public void testExtract() throws ParseException {
		
		sdta = new SortAndExtractDates();
		lgFinal = sdta.extract(lg, start, end);
		assertEquals("Islahuddin 1/18/2018 1:23:47PM recieve database 4", lgFinal.get(0).toString());
		assertEquals("Moomna 1/18/2018 1:25:01PM act school 5", lgFinal.get(1).toString());
		///assertEquals("Moomna 1/17/2018 1:25:00PM act school 5", lgFinal.get(2));
		
		
	}

}
