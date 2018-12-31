package edu.ncsu.csc316.rentals.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.rentals.resource.VertexDay;
import edu.ncsu.csc316.rentals.util.MinHeapForVertexDay.SampleVertexIterator;

/**
 * Testing the heap for vertex day
 * @author Islahuddin Arshad
 *
 */
public class MinHeapForVertexDayTest {

	
	/*First vertex day*/
	VertexDay v1;
	/*Second vertex day*/
	VertexDay v2;
	/*Third vertex day*/
	VertexDay v3;
	/*The heap to test*/
	MinHeapForVertexDay heap;
	
	/**
	 * Sets up testing the heap
	 */
	@Before
	public void setUp() {
		
		v1 = new VertexDay();
		v2 = new VertexDay();
		v3 = new VertexDay(2);
		heap = new MinHeapForVertexDay();
	
		heap.insert(v1);
		heap.insert(v2);
		heap.insert(v3);
	}

	/**
	 * Tests if empty
	 */
	@Test
	public void testIsEmpty() {
		assertFalse(heap.isEmpty());
	}

	/**
	 * Tests delete minimum
	 */
	@Test
	public void testDeleteMinimum() {
		assertEquals(v1, heap.deleteMinimum());
	}
	
	/**
	 * Tests the size
	 */
	@Test
	public void testSize() {
		assertEquals(3, heap.size());
	}
	
	/**
	 * Tests the iterator
	 */
	@Test
	public void testSampleVertexIterator() {
		
		MyArrayList<VertexDay> ex = new MyArrayList<VertexDay>();
		
		
		v1 = new VertexDay();
		v2 = new VertexDay();
		v3 = new VertexDay(2);
		ex.insert(v1);
		ex.insert(v2);
		ex.insert(v3);
		
		//MinHeapForVertexDay.SampleVertexIterator s = new SampleVertexIterator(ex);
		MinHeapForVertexDay.SampleVertexIterator s = new SampleVertexIterator(ex);
		s.next();
		s.remove();
		assertEquals(true, s.hasNext());
		
	}
	
	

}
