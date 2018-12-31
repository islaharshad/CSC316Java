package edu.ncsu.csc316.rentals.io;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.rentals.resource.EdgeEntry;
import edu.ncsu.csc316.rentals.util.MyArrayList;


/**
 * Tests the rental reader object
 * @author Islahuddin Arshad
 *
 */
public class RentalReaderTest {

	/*The reader object to test*/
	RentalReader reader;
	
	/*List of edges*/
	MyArrayList<EdgeEntry> list;
	
	/**
	 * Sets up the reader
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		reader = new RentalReader("ex1.txt");
		list = new MyArrayList<EdgeEntry>();
		
	}

	/**
	 * Tests read rental
	 */
	@Test
	public void testReadRental() {
		list = reader.readRental("ex1.txt");
		
		assertEquals(4, ((EdgeEntry) list.get(list.getSize() - 1)).getEndDay());
		assertEquals(0, ((EdgeEntry) list.get(0)).getStartDay());
		assertEquals("Chevrolet", ((EdgeEntry) list.get(0)).getMake());
		assertEquals("Tahoe", ((EdgeEntry) list.get(0)).getModel());
	}

}
