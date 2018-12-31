package edu.ncsu.csc316.hr.util;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * MyQueue is tested for its methods
 * suported by linked list
 * @author Islahuddin Arshad
 *
 */
public class MyQueueTest {

	/*Sets up a queue to test*/
	MyQueue<String> q;
	/**
	 * Sets up testing for queue
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		q = new MyQueue<String>();
		
	}

	/**
	 * Tests the enqueue method
	 */
	@Test
	public void testEnqueue() {
		q.enqueue("Taha");
		q.enqueue("Maha");
		assertEquals("Taha", q.peeker());
	}
	/**
	 * Tests the dequeue method
	 */
	@Test
	public void testDequeue() {
		q.enqueue("Islahuddin");
		q.enqueue("Arshad");
		q.dequeue();
		assertEquals("Arshad", q.peeker());
	}
	
	/**
	 * Tests the is empty method
	 */
	@Test
	public void testIsEmpty() {
		q.enqueue("Tasha");
		assertFalse(q.isEmpty());
	}


	/**
	 * Tests the get size method
	 */
	@Test
	public void testGetSize() {
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(3, q.getSize());
	}
}
