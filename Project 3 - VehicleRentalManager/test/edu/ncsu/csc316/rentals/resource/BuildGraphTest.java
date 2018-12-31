package edu.ncsu.csc316.rentals.resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the graph and all its methods
 * @author Islahuddin Arshad
 *
 */
public class BuildGraphTest {

	
	/**First edge entry*/
	EdgeEntry e1;
	/**Second edge entry*/
	EdgeEntry e2;
	/**Third edge entry*/
	EdgeEntry e3;
	/**Fourth edge entry*/
	EdgeEntry e4;
	/**Fifth edge entry*/
	EdgeEntry e5;
	/**Sixth edge entry*/
	EdgeEntry e6;
	/**The graph to test*/
	BuildGraph g;
	
	/**
	 * Sets the up the edges to be inserted into a graph
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		g = new BuildGraph(5);
		e1 = new EdgeEntry(0, 1, 85, "Chevrolet", "Tahoe");
		e2 = new EdgeEntry(0, 3, 255, "Toyota", "Prius");
		e3 = new EdgeEntry(1, 4, 220, "Ford", "Explorer");
		e4 = new EdgeEntry(3, 4, 50, "Honda", "Accord");
		e5 = new EdgeEntry(1, 2, 65, "Jeep", "Compass");
		e6 = new EdgeEntry(2, 4, 90, "Ford", "Explorer");
		
		g.insertEdgeEntry(e1);
		g.insertEdgeEntry(e2);
		g.insertEdgeEntry(e3);
		g.insertEdgeEntry(e4);
		g.insertEdgeEntry(e5);
		g.insertEdgeEntry(2, 4, 90, "Ford", "Explorer");
	}

	/**
	 * Tests insert edge entry
	 */
	@Test
	public void testInsertEdgeEntry() {
		assertTrue(g.hasEdgeEntry(e1));
		
	}
	
	/**
	 * Tests delete edge entry
	 */
	@Test
	public void testDeleteEdgeEntry() {
		g.deleteEdgeEntry(0, 1);
		assertFalse(g.hasEdgeEntry(e1));
	}
	
//	/**
//	 * Tests the neighbor check
//	 */
//	@Test
//	public void testNeighbor() {
//		g.neighbor(2);
//	}
	

}
