package edu.ncsu.csc316.security_log.info;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Tests the time object class
 * @author Islahuddin Arshad
 *
 */
public class TimeObjectTest {


	/**
	 * Tests all method from get numbers to each variable in the time
	 * object
	 */
	@Test
	public void testAll() {
		TimeObject to = new TimeObject("01/18/2018 01:22:21PM");
		assertEquals(20180118132221L, to.getNumber());
		assertEquals("01/18/2018 01:22:21PM", to.toString());
		
		TimeObject to2 = new TimeObject("01/18/2018 12:58:14PM");
		
		assertEquals(-1, to2.compareTo(to));
	}

	
}
