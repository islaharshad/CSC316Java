package edu.ncsu.csc316.rentals.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.rentals.resource.EdgeEntry;

/**
 * Testing the splay dictionary
 * @author Islahuddin Arshad
 *
 */
public class MySplayDictionaryTest {

	/**The splay dictionary*/
	MySplayDictionary d;
	/**First edge entry*/
	EdgeEntry e1;
	/**Second edge entry*/
	EdgeEntry e2;
	/**Third edge entry*/
	EdgeEntry e3;
	/**Fourth edge entry*/
	EdgeEntry e4;
	
	
	/**
	 * Tests the set up for splay method
	 * @throws Exception
	 */
	@Before 
	public void setUp() {
		
		d = new MySplayDictionary();
		
		e1 = new EdgeEntry(0, 1, 85, "Chevrolet", "Tahoe");
		e2 = new EdgeEntry(0, 3, 255, "Toyota", "Prius");
		e3 = new EdgeEntry(1, 4, 220, "Ford", "Explorer");
		e4 = new EdgeEntry(3, 4, 50, "Honda", "Accord");
		
		d.insert("01", e1);
		d.insert("03", e2);
		d.insert("14", e3);
		  
		 
	}

	/**
	 * Tests delete
	 */
	@Test
	public void testDelete() {
		d.delete("01");
		assertEquals(false, d.exists("01"));
	}
	

	/**
	 * Tests insert
	 */
	@Test
	public void testInsert() {
		d.insert("34", e4);
		assertEquals(true, d.exists("34"));
	}
	
	/**
	 * Tests get make from dict
	 */
	@Test
	public void testGetMakeFromDict() {
		assertEquals("Toyota", d.getMakeFromDict("03"));
	}
	
	/**
	 * Tests get model from dict
	 */
	@Test
	public void testGetModelFromDict() {
		assertEquals("Explorer", d.getModelFromDict("14"));
	}

}
