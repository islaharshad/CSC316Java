package edu.ncsu.csc316.rentals.resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Vertexday object and all its methods
 * @author Islahuddin Arshad
 *
 */
public class VertexDayTest {

	
	/*Vertex day to test*/
	VertexDay vD;
	
	/*Vertex day to test*/
	VertexDay vD1;
	
	/**
	 * Sets up the testing environment
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		vD = new VertexDay();
		vD1 = new VertexDay(0);
	}

	/**
	 * Tests get id
	 */
	@Test
	public void testGetId() {
		assertEquals(0, vD1.getId());
	}
	
	/**
	 * Tests set id
	 */
	@Test
	public void testSetId() {
		vD1.setId(2);
		assertEquals(2, vD1.getId());
	}
	
	/**
	 * Test get distance
	 */
	@Test
	public void testGetDistance() {
		assertEquals(Integer.MAX_VALUE, vD.getDist());
	}
	
	/**
	 * Tests get distance
	 */
	@Test
	public void testSetDistance() {
		vD.setDist(200);
		assertEquals(200, vD.getDist());
	}
	
	/**
	 * Tests get parent
	 */
	@Test
	public void testGetParent() {
		assertEquals(null, vD.getParent());
	}
	
	/**
	 * Tests set parent
	 */
	@Test
	public void testSetParent() {
		vD.setParent(vD1);
		assertEquals(vD1, vD.getParent());
	}
	
	/**
	 * Testing compare
	 */
	@Test
	public void testCompareTo() {
		VertexDay v1 = new VertexDay();
		VertexDay v2 = new VertexDay();
		
		assertEquals(0, v1.compareTo(v2));
	}

}
