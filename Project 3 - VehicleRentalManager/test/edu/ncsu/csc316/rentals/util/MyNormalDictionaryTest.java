package edu.ncsu.csc316.rentals.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the normal dictionary
 * @author Islahuddin Arshad
 *
 */
public class MyNormalDictionaryTest {

	
	/**My dictionary*/
	public MyNormalDictionary dict;
	
	/**
	 * Sets up testing
	 */
	@Before
	public void setUp() {
		
		dict = new MyNormalDictionary();
		dict.putHere("A", 1);
		dict.putHere("B", 0);
		dict.putHere("A", 0);
	}

	
	
	/**
	 * Tests the size
	 */
	@Test
	public void testMS() {
		dict.mSorter();
		assertEquals("A", dict.getKeyFrom(0));
		assertEquals("B", dict.getKeyFrom(1));
		assertEquals("A", dict.getKeyFrom(2));
		
		
		
	}
	
	
	/**
	 * Tests the size
	 */
	@Test
	public void testGetSize() {
		assertEquals(3, dict.getSize());
	}
	
	/**
	 * Tests the get key from
	 */
	@Test
	public void testGetKeyFrom() {
		assertEquals("A", dict.getKeyFrom(0));
	}
	
	/**
	 * Tests the get value from
	 */
	@Test
	public void testGetValueFrom() {
		assertEquals(1, dict.getValueFrom(0));
	}

}
