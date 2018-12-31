package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;


import org.junit.Test;
/**
 * Tests the reqiured Hash Table
 * @author Islahuddin Arshad
 *
 */
public class HashTableTest {

	/**
	 * Tests all the methods
	 */
	@Test
	public void testAll() {
		HashTable<String> h = new HashTable<String>();
		
		h.insert("A");
		h.insert("B");
		h.insert("C");

		h.insert("A");
		assertEquals(4, h.size());
		assertEquals("A", h.lookUp("A"));
		assertEquals("C", h.lookUp("C"));
		assertEquals("B", h.lookUp("B"));
		assertEquals("A", h.lookUp("A"));
		assertNull(h.lookUp("M"));
		assertEquals(0, h.getHashTableLength());
		String[] array = new String[10];
		
		h.resolveCollisions(array, 2, "A");
		h.resize();
		h.hasher1("A");
		h.hasher2("B");
		
	}

}
