package edu.ncsu.csc316.security_log.io;

import static org.junit.Assert.*;



import org.junit.Test;

import edu.ncsu.csc316.security_log.info.Entry;
import edu.ncsu.csc316.security_log.util.MyArrayList;



/**
 * Tests the IO and see if the file being read is right
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManagerIOTest {



	/**
	 * Tests the file reader class by verifying all the entries
	 */
	@Test
	public void testAll() {
		SecurityLogManagerIO s = new SecurityLogManagerIO();
		MyArrayList<Entry> entries = new MyArrayList<Entry>();
		entries = s.readEntries("sampleInput.txt");
		
		assertEquals("jtking", ((Entry) entries.get(0)).getName());
		assertEquals("prescription information", ((Entry) entries.get(0)).getResource());
		assertEquals("view", ((Entry) entries.get(0)).getAction());
		assertEquals("01/18/2018 01:22:21PM", ((Entry) entries.get(0)).getTime().toString());
	}

}
