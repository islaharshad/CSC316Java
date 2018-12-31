package edu.ncsu.csc316.rentals.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.rentals.resource.VertexDay;



/**
 * Tests the manager object
 * @author Islahuddin Arshad
 *
 */
public class VehicleRentalManagerTest {

	/*The manager objet to test*/
	VehicleRentalManager manager;
	/**
	 * Sets up the testing for manager object
	 */
	@Before
	public void setUp() {
		
		manager = new VehicleRentalManager("ex1.txt");
		
	}

	/**
	 * Tests the getlength for vertex day
	 */
	@Test
	public void testGetLength() {

		VertexDay v = null;
		
		assertEquals(-1, manager.getLength(v));
	}
	/**
	 * Tests the get query results
	 */
	@Test
	public void testGetQueryResults() {////removed the bracket
		assertEquals("Available rentals for day 1\n   "
				+ "$85.00 Chevrolet Tahoe for day 1 to day 2\n   "
				+ "$180.00 Chevrolet Silverado for day 1 to day 3\n   "
				+ "$255.00 Toyota Prius for day 1 to day 4\n   "
				+ "$500.00 Honda CRV for day 1 to day 5\n]"
				 , manager.getRentalsForDay(1));
		
		assertEquals("Available rentals for day 9\n   No rentals available.\n]", manager.getRentalsForDay(9));
	}
	

	/**
	 * Tests the get rentals
	 */
	@Test
	public void testGetRentals() {
		assertEquals("Rental total is $225.00\n[\n"
					+ "   From day 1 to day 2: $85.00, Chevrolet Tahoe\n" +
					 "   From day 2 to day 4: $90.00, Jeep Cherokee\n" +
					 "   From day 4 to day 5: $50.00, Honda Accord\n]", manager.getRentals(1, 5));
		
		assertEquals("Rental total is $225.00\n[\n"
				+ "   From day 1 to day 2: $85.00, Chevrolet Tahoe\n" +
				 "   From day 2 to day 4: $90.00, Jeep Cherokee\n" +
				 "   From day 4 to day 5: $50.00, Honda Accord\n"
				+ "   No rentals available on day 5\n]", manager.getRentals(1, 6));
	}

}
