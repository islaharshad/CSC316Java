package edu.ncsu.csc316.rentals.resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Edge entry object for all its methods
 * @author Islahuddin Arshad
 *
 */
public class EdgeEntryTest {
	
	/*Edge to test*/
	EdgeEntry e1;

	/**
	 * Sets up the testing for edgeentry
	 */
	@Before
	public void setUp() {
		
		
		e1 =	new EdgeEntry(0, 1, 85, "Chevrolet", "Tahoe");
//		EdgeEntry e2 =	new EdgeEntry(0,3,255,"Toyota","Prius");
//		EdgeEntry e3 =	new EdgeEntry(1,4,220,"Ford","Explorer");
//		EdgeEntry e4 =  new EdgeEntry(3,4,50,"Honda","Accord");
//		EdgeEntry e5 =	new EdgeEntry(1,2,65,"Jeep","Compass");
//		EdgeEntry e6 =	new EdgeEntry(2,4,90,"Ford","Explorer");
//		EdgeEntry e7 =	new EdgeEntry(2,3,55,"Kia","Soul");
//		EdgeEntry e8 =	new EdgeEntry(0,4,500,"Honda","CRV");
//		EdgeEntry e9 =	new EdgeEntry(0,2,180,"Chevrolet","Silverado");
//		EdgeEntry e10 =	new EdgeEntry(1,3,90,"Jeep","Cherokee");
	}

	/**
	 * Test get start day
	 */
	@Test
	public void testGetStartDay() {
		assertEquals(0, e1.getStartDay());
	}
	
	/**
	 * Test get end day
	 */
	@Test
	public void testGetEndtDay() {
		assertEquals(1, e1.getEndDay());
	}
	/**
	 * Test get cost
	 */
	@Test
	public void testGetCost() {
		assertEquals(85, e1.getCost());
	}
	
	/**
	 * Test get make
	 */
	@Test
	public void testGetMake() {
		assertEquals("Chevrolet", e1.getMake());
	}
	/**
	 * Tes get model
	 */
	@Test
	public void testGetModel() {
		assertEquals("Tahoe", e1.getModel());
	}
	
	/**
	 * Test get start day
	 */
	@Test
	public void testSetStartDay() {
		e1.setStartDay(4);
		assertEquals(4, e1.getStartDay());
	}
	/**
	 * Test set end day
	 */
	@Test
	public void testSetEndDay() {
		e1.setEndDay(45);
		assertEquals(45, e1.getEndDay());
		
	}
	/**
	 * Test set cost
	 */
	@Test
	public void testSetCost() {
		e1.setCost(23);
		assertEquals(23, e1.getCost());
		
	}
	/**
	 * Test set make
	 */
	@Test
	public void testSetMake() {
		e1.setMake("Toyota");
		assertEquals("Toyota", e1.getMake());
	}
	/**
	 * Tests set model
	 */
	@Test
	public void testSetModel() {
		e1.setModel("Camry");
		assertEquals("Camry", e1.getModel());
	}
	
	/**
	 * Testing the equals method
	 */
	@Test
	public void testEquals() {
		assertTrue(e1.equals(e1));
	}
	

	/**
	 * Testing the compare to method
	 */
	@Test
	public void testCompareTo() {
		assertEquals(0, e1.compareTo(e1));
	}
	
}
