package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests the flushing of duplicates
 * @author Islahuddin Arshad
 *
 */
public class FlushDuplicatesTest {

	/**The file to be checked*/
	MyArrayList<LogFile> lg;
	/**The finished and flushed file*/
	MyArrayList<LogFile> flush;
	
	FlushDuplicates fda;
	/**
	 * The setup methods tests if the files are
	 * flushed accordingly
	 */
	@Before
	public void setUp() {
		lg = new MyArrayList<LogFile>();
		flush = new MyArrayList<LogFile>();
		
		lg.insert(new LogFile("Islahuddin", "1/18/2018 1:29:47PM", "a", "aaaabase", 0)); 
		lg.insert(new LogFile("Islahuddin", "1/18/2018 1:29:47PM", "a", "aaaabase", 0)); 
		lg.insert(new LogFile("Moomna", "1/17/2018 1:25:01PM", "a", "school", 0)); 
		lg.insert(new LogFile("Moomna", "1/17/2018 1:25:01PM", "a", "school", 0)); 
		lg.insert(new LogFile("Tasha", "1/08/2018 1:25:01PM", "a", "school", 0)); 
	}

	/**
	 * Tests the flush method from the setup above
	 */
	@Test
	public void testFlush() {
	
		fda = new FlushDuplicates();
		flush = fda.flush(lg);
		
		assertEquals("Islahuddin 1/18/2018 1:29:47PM a aaaabase 2", flush.get(0).toString());
		assertEquals("Tasha 1/08/2018 1:25:01PM a school 3", flush.get(1).toString());

	}
	
	

}
