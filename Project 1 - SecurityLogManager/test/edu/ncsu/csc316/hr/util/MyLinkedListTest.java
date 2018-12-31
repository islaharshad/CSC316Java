package edu.ncsu.csc316.hr.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.hr.resource.Employee;
import edu.ncsu.csc316.hr.util.MyLinkedList;

/**
 * Tests the my linked list class
 * @author Islahuddin Arshad
 *
 */
public class MyLinkedListTest {

	/**First list to test*/ 
	MyLinkedList<String> list;
	
	/**Second list to test*/
	MyLinkedList<String> list2;
	
	/**Third list to test*/
	MyLinkedList<String> list3;
	
	/**Fourth list to test*/
	MyLinkedList<String> list4;
	
	/**Fifth list to test*/
	MyLinkedList<Employee> list5;
	
	/**
	 * Sets up the test cases for my linked list
	 */
	@Before
	public void setUp() {
		list = new MyLinkedList<String>();
		list2 = new MyLinkedList<String>();
		list3 = new MyLinkedList<String>();
		list4 = new MyLinkedList<String>();
		list5 = new MyLinkedList<Employee>();
	}



	/**
	 * Tests the remove method
	 */
	@Test
	public void testRemove() {
		list4.insert("taha");
		list4.insert("maha");
		list4.insert("maha1");
		list4.insert("maha2");
		list4.insert("maha3");
		list4.insert("maha4");
		
		list4.remove(0);
		assertEquals(5, list4.getSize());
	}

//	@Test
//	public void testGetLast() {
//		list4.adder("taha");
//		list4.adder("maha");
//		list4.adder("maha1");
//		list4.adder("maha2");
//		list4.adder("maha3");
//		list4.adder("maha4");
//		assertEquals("maha4", list4.getLast());
//	}
	
	/**
	 * Tests the set method
	 */
	@Test
	public void testSet() {
		list3.insert("Taha");
		
		assertEquals("Taha", list3.setAt(0, "Maha"));
		assertEquals(1, list3.getSize());
		assertFalse(list3.isEmpty());
	}
	
	/**
	 * Tests the isEmpty method
	 */
	@Test
	public void testIsEmpty() {
		list3.insert("Taha");
		assertFalse(list3.isEmpty());
	}
	/**
	 * Tests the size method
	 */
	@Test
	public void testSize() {
		assertEquals(0, list.getSize());
	}
	
	/**
	 * Tests the add method to add at an index
	 */
	@Test
	public void testAdd() {
		list.add(0, "What");
		list.add(1, "is");
		assertEquals("What", list.get(0));
		assertEquals("is", list.get(1));
	}
	
	/**
	 * Tests the adder mether to add at the end
	 */
	@Test
	public void testAdder() {
		list2.insert("it");
		list2.insert("?");
		assertEquals(2, list2.getSize());
		assertEquals("it", list2.get(0));
		assertEquals("?", list2.get(1));
	}
	

	
}
