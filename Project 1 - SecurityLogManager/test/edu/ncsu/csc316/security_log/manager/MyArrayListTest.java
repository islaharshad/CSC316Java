package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the arraylist
 * @author Islahuddin Arshad
 *
 */
public class MyArrayListTest {

	/**The arraylist to be tested*/
	MyArrayList<String> strArr;
	
	/**
	 * Makes a new arraylist to test
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		strArr = new MyArrayList<String>();

		
		
	}

	/**
	 * Tests size
	 */
	@Test
	public void testGetSize() {
		assertEquals(0, strArr.getSize());
	}
	/**
	 * Tests the insert
	 */
	@Test
	public void testInsert() {
		strArr.insert("z");
		strArr.insert("z");
		strArr.insert("z");
		assertEquals(3, strArr.getSize());
		assertEquals("z", strArr.get(0));
	}
	/**
	 * Tests get
	 */
	@Test
	public void testGet() {
		strArr.insert("z");
		assertNotEquals("o", strArr.get(0));

	}
	
	/**
	 * Tests setat method
	 */
	@Test
	public void testSetAt() {
		
		assertEquals(null, strArr.setAt(0, "p"));
	}
	/**
	 * Tests reset method
	 */
	@Test
	public void testReset() {
		strArr.reset();
		assertEquals(0, strArr.getSize());
	}




}
