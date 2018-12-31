package edu.ncsu.csc316.hr.util;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.hr.resource.Employee;



/**
 * These test cases are copied from the last project: security log manager
 * @author Islahuddin Arshad
 *
 */
public class MyArrayListTest {

	/**The arraylist to be tested*/
	MyArrayList<String> strArr;
	
	/**
	 * Makes a new arraylist to test
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		strArr = new MyArrayList<String>();

		
		
	}

	/**
	 * Tests size
	 */
	@Test
	public void testGetSize() {
		assertEquals(0, strArr.getSize());
	}
	/**
	 * Tests the insert
	 */
	@Test
	public void testInsert() {
		strArr.insert("z");
		strArr.insert("z");
		strArr.insert("z");
		assertEquals(3, strArr.getSize());
		assertEquals("z", strArr.get(0));
	}
	/**
	 * Tests get
	 */
	@Test
	public void testGet() {
		strArr.insert("z");
		assertNotEquals("o", strArr.get(0));

	}
	
	/**
	 * Tests setat method
	 */
	@Test
	public void testSetAt() {
		
		assertEquals(null, strArr.setAt(0, "p"));
	}
	/**
	 * Tests reset method
	 */
	@Test
	public void testReset() {
		strArr.reset();
		assertEquals(0, strArr.getSize());
	}
	
	/**
	 * Tests getting employees by list of children and full name
	 */
	@Test
	public void testEmployeesByFullName() {
		
		
		Employee e1 = new Employee("Islahuddin", "Arshad", "R41");
		
		Employee e2 = new Employee("Taha", "Adnan", "R51");
		
		Employee e3 = new Employee("Moomna", "Arshad", "R61");
		
		Employee e4 = new Employee("Ummiya", "Arshad", "R71");
		
		MyLinkedList<Employee> list = new MyLinkedList<Employee>();
		list.insert(e1);
		list.insert(e2);
		list.insert(e3);
		list.insert(e4);
		
		assertEquals(e3, list.getEmployeeByFullName(list, "Moomna Arshad"));
		assertNull(list.getEmployeeByFullName(list, "Joe Saza"));
	}


}
