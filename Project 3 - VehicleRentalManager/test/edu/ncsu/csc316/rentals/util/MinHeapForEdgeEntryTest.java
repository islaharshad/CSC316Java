package edu.ncsu.csc316.rentals.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.rentals.resource.EdgeEntry;

/**
 * Tests the method for min heap
 * @author Islahuddin Arshad
 *
 */
public class MinHeapForEdgeEntryTest {

	/**Heap to test*/
	MinHeapForEdgeEntry heap;
	/**First edge entry*/
	EdgeEntry e1;
	/**Second edge entry*/
	EdgeEntry e2;
	/**Third edge entry*/
	EdgeEntry e3;
	/**Fourth edge entry*/
	EdgeEntry e4;
	
	/**
	 * Tests the set up method for min heap for edge entry
	 */
	@Before
	public void setUp() {
		
		heap = new MinHeapForEdgeEntry();
		
		e1 = new EdgeEntry(0, 1, 85, "Chevrolet", "Tahoe");
		e2 = new EdgeEntry(0, 3, 255, "Toyota", "Prius");
		e3 = new EdgeEntry(1, 4, 220, "Ford", "Explorer");
		e4 = new EdgeEntry(3, 4, 50, "Honda", "Accord");
		heap.insert(e1);
		heap.insert(e2);
		heap.insert(e3);
		heap.insert(e4);
	
	}

	
	/**
	 * Tests the size method
	 */
	@Test
	public void testSize() {
		assertEquals(4, heap.size());
	}
	
	
	/**
	 * Tests the delete min method
	 */
	@Test
	public void testDeleteMinimum() {
		assertEquals(e4, heap.deleteMinimum());
	}
	
	/**
	 * Tests the contains method
	 */
	@Test
	public void testContains() {
		assertTrue(heap.contains(e2));
	}
	

	
}
