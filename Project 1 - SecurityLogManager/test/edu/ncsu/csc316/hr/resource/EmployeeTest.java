package edu.ncsu.csc316.hr.resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the employee class by checking if the parameters
 * return and get specfications as needed
 * @author Islahuddin Arshad
 *
 */
public class EmployeeTest {

	/**Creates a test employee*/
	Employee test;
	
	/**
	 * Creates a new employee to test
	 */
	@Before
	public void setUp() {
		test = new Employee("First", "Last", "ResumeID");
	}

	/**
	 * Tests get first name of employee
	 */
	@Test
	public void testGetFirstName() {
		assertEquals("First", test.getFirstName());
	}
	
	/**
	 * Tests getting the last name
	 */
	@Test
	public void testGetLastName() {
		assertEquals("Last", test.getLastName());
	}
	/**
	 * Tests getting the resume ID
	 */
	@Test
	public void testGetResumeID() {
		assertEquals("ResumeID", test.getResumeID());
	}
	/**
	 * Tests setting the first name
	 */
	@Test
	public void testSetFirstName() {
		test.setFirstName("Taha");
		assertEquals("Taha", test.getFirstName());
	}
	/**
	 * Tests setting the last name
	 */
	@Test
	public void testSetLastName() {
		test.setLastName("Maha");
		assertEquals("Maha", test.getLastName());
	}
	/**
	 * Tests setting the reusume ID
	 */
	@Test
	public void testSetResumeID() {
		test.setResumeID("1234");
		assertEquals("1234", test.getResumeID());
	}
	
	/**
	 * Tests getting the parent
	 */
	@Test
	public void testGetParent() {
		assertNull(test.getParent());
	}
	
	/**
	 * Tests setting the parent
	 */
	@Test
	public void testSetParent() {
		test.setParent(null);
		assertNull(test.getParent());
	}
	
	/**
	 * Tests getting the full name
	 */
	@Test
	public void testGetFullName() {
		assertEquals("First Last", test.getFullName());
	}
//	
//	@Test
//	public void testSetFullName() {
//		test.setFullName("Tea Pot");
//		assertEquals("Tea Pot", test.getFullName());
//	}

}
