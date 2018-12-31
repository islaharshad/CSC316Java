package edu.ncsu.csc316.rentals.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the arraylist class
 * @author Islahuddin Arshad
 *
 */
public class MyArrayListTest {
	/*The arraylist to be tested*/
	MyArrayList<String> list;

	/**
	 * Sets up the testing
	 */
	@Before
	public void setUp() {
		
		list = new MyArrayList<String>();
		
		list.insert("A");
		list.insert("B");
		list.insert("C");
		list.insert("D");
		list.insert("E");
	}

	/**
	 * Tests the insert method
	 */
	@Test
	public void testInsert() {
		assertEquals("A", list.get(0));
	}
	
	/**
	 * Tests the get method
	 */
	@Test
	public void testGet() {
		assertEquals("E", list.get(4));
	}
	
	
	/**
	 * Tests the get size method
	 */
	@Test
	public void testGetSize() {
		assertEquals(5, list.getSize());
	}
	
	/**
	 * Tests the reset method
	 */
	@Test
	public void testReset() {
		list.reset();
		assertEquals(0, list.getSize());
	}

	/**
	 * Tests the set at method
	 */
	@Test
	public void testSetAt() {
		list.setAt(0, "T");
		assertEquals("T", list.get(0));
	}

	/**
	 * Tests the delete method
	 */
	@Test
	public void testDelete() {
		list.delete(0);
		assertEquals(4, list.getSize());
	}
}
