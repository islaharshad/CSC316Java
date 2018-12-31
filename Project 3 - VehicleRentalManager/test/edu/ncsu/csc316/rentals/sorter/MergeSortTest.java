package edu.ncsu.csc316.rentals.sorter;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


import edu.ncsu.csc316.rentals.resource.EdgeEntry;
import edu.ncsu.csc316.rentals.util.MyArrayList;

/**
 * Tests all the methods of merge sort class
 * @author Islahuddin Arshad
 *
 */
public class MergeSortTest {
	
	/**List of edge entries*/
	MyArrayList<EdgeEntry> list;
	/**Merge sort object*/
	MergeSort sort;
	/**First edge entry*/
	EdgeEntry e1;
	/**Third edge entry*/
	EdgeEntry e3;
	/**Fourth edge entry*/
	EdgeEntry e4;
	/**Sixth edge entry*/
	EdgeEntry e6;


	/**
	 * Sets up testing for merge sort class
	 */
	@Before
	public void setUp() {
		
		sort = new MergeSort();
		
		list = new MyArrayList<EdgeEntry>();
		e1 = new EdgeEntry(0, 1, 85, "Chevrolet", "Tahoe");
		e3 = new EdgeEntry(1, 4, 220, "Ford", "Explorer");
		e4 = new EdgeEntry(3, 4, 50, "Honda", "Accord");
		e6 = new EdgeEntry(2, 4, 90, "Ford", "Explorer");
		
		list.insert(e1);
		list.insert(e3);
		list.insert(e4);
		list.insert(e6);
		
		
	}

	/**
	 * Test the merge sort method
	 */
	@Test
	public void testMergeSort() {
		sort.mergeSort(list);
		assertEquals(0, ((EdgeEntry) list.get(0)).getStartDay());
		assertEquals(1, ((EdgeEntry) list.get(1)).getStartDay());
		assertEquals(2, ((EdgeEntry) list.get(2)).getStartDay());
		assertEquals(3, ((EdgeEntry) list.get(3)).getStartDay());
		
	}

}
