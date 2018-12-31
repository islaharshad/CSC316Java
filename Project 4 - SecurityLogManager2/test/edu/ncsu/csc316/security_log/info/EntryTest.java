package edu.ncsu.csc316.security_log.info;

import static org.junit.Assert.*;



import org.junit.Test;

/**
 * Tests the entry class
 * @author Islahuddin Arshad
 *
 */
public class EntryTest {

	/**
	 * Tests all method from get action, get resource, get name, get time string
	 */
	@Test
	public void testAll() {
		Entry e = new Entry("jtking", "01/18/2018 01:22:21PM", "view", "prescription information", 0);
		
		assertEquals("01/18/2018 01:22:21PM", e.getTime().toString());
		assertEquals("jtking", e.getName());
		assertEquals("view", e.getAction());
		assertEquals("prescription information", e.getResource());
		e.getFrequency();
		e.incrementFrequency();
		e.getFrequency();
	}
	


}
