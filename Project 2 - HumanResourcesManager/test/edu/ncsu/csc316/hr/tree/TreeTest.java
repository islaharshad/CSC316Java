package edu.ncsu.csc316.hr.tree;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.hr.resource.Employee;

/**
 * This method tests the tree method in terms of its lookup method
 * @author Islahuddin Arshad
 *
 */
public class TreeTest {

	/**Initializes the tree*/
	public Tree tree;
	
	/**
	 * Tests the tree by setting root to null
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		tree = new Tree(null);
	}

	/**
	 * Tests the lookup method
	 */
	@Test
	public void testLookup() {
		Employee e1 = new Employee("Islahuddin", "Arshad", "R41");
		
		Employee e2 = new Employee("Taha", "Adnan", "R51");
		
		Employee e3 = new Employee("Moomna", "Arshad", "R61");
		
		Employee e4 = new Employee("Ummiya", "Arshad", "R71");
		
		Employee e5 = new Employee("Sundas", "Arshad", "R67");
		
		
		
		
		
		e1.getChildren().insert(e2);
		e1.getChildren().insert(e3);
		e3.getChildren().insert(e4);
		e3.getChildren().insert(e5);
		assertEquals(e5, tree.lookUp("Sundas", "Arshad", e1));
		assertEquals(e2, tree.lookUp("Taha", "Adnan", e1));
		assertEquals(e1, tree.lookUp("Islahuddin", "Arshad", e1));
	}

}
