package edu.ncsu.csc316.hr.util;

import edu.ncsu.csc316.hr.resource.Employee;

/**
 * The linked list class creates a linkedlist
 * @author Islahuddin Arshad
 *
 * @param <Object> the object to carry
 */
public class MyLinkedList<Object> {

	/**The back of the linkedlist*/
	private Node<Object> b;
	/**The front of the linkedList*/
	private Node<Object> f;
	/**The size of the linkedlist*/
	private int size;
	
	/**
	 * Initialzes the linkedlist constructor
	 */
	public MyLinkedList() {
		b = null;
		f = null;
		size = 0;
	}
	
	/**
	 * Returns the size of the linkedList
	 * @return the size of the list
	 */
	public int getSize() {
		return size;
	}
	
	
 	/**
	 * Adds the index of the element at the specified
	 * location
	 * @param index the index to add the element at
	 * @param e the element to add
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(int index, Object e) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (e == null) {
			throw new NullPointerException();
		}
		
		if (index == 0) {
			f = new Node(e, f);
			b = f;
		}
		else {
			Node c = f;
			int counter = 0;
			while (counter < index - 1) {
				c = c.next;
				counter++;
			}
			c.next = new Node(e, c.next);
			b = c;
		}
		size = size + 1;
	}
	/**
	 * Gets an element at index 
	 * @param i the index at which the element is needed
	 * @return the element at the index
	 */
	public Object get(int i) {
		Node<Object> c = f;
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		int check = 0;
		while (check < i) {
			c = c.next;
			check++;
		}
		return (Object) c.data;
	}
	
	/**
	 * Replaces the object at index and inserts another
	 * @param i the index at which to insert the object
	 * @param ele element to be inserted at the index
	 * @return Object object that is replaced
	 */
	public Object setAt(int i, Object ele) {
		Object replace = null;
		Node<Object> c = f;
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		int check = 0;
		while (check < i) {
			c = c.next;
			check++;
		}
		replace = c.data;
		c.data = ele;
		
		return replace;
	}
	/**
	 * Checks if the list is empty
	 * @return false if not empty
	 */
	public boolean isEmpty() {
		return size == 0;
	} 
	

	

	
	/**
	 * Removes the particular element at the index
	 * @param ind the index to be removed at
	 * @return the element to be removed
	 */
	@SuppressWarnings("unchecked")
	public Object remove(int ind) {
		if (ind < 0 || ind >= size) {
			throw new IndexOutOfBoundsException();
		}
		Object checker;
		if (ind == 0) {
			checker = f.data;
			f = f.next;
		}
		else {
			@SuppressWarnings("rawtypes")
			Node c = f;
			int i = 0;
			while (i < ind - 1) {
				c = c.next;
				i++;
			}
			checker = (Object) c.next.data;
			c.next = c.next.next;
			if (ind == size - 1) {
				b = c;
			}
			
		}
		size = size - 1;
		return checker;
		

		
	}
	
	


	/**
	 * Custom method just for employee classs
	 * @param list the list of children employees to search for
	 * @param fullName the fullname of employee to match
	 * @return Employee the employee to which it's full name matches
	 */
	public Employee getEmployeeByFullName(MyLinkedList<Employee> list, String fullName) {
		for (int i = 0; i < list.getSize(); i++) {
			if (((Employee) list.get(i)).getFullName().equals(fullName)) {
				return (Employee) list.get(i);
			}
		}
		return null;
	}
	
	
	/**
	 * Adds the element at the end
	 * @param ele the element to add
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(Object ele) {
		if (ele == null) {
			throw new NullPointerException();
		}
		
		if (f == null) {
			f = new Node(ele, f);
			b = f;
			size = size + 1;
		}
		else if (f.next == null) {
			b = new Node(ele, null);
			f.next = b;
			size = size + 1;
		}
		else {
			Node check = b;
			b = new Node(ele, null);
			check.next = b;
			size = size + 1;
		}
	}
	
	
	
	
	
	
	
	/**
	 * This class initializes the node
	 * and its referance
	 * @author Islahuddin Arshad
	 * @param <Object> the object to carry
	 */
	public class Node<Object> {
		/**The data contained by the node*/
		private Object data;
		/**The referance to the next node*/
		private Node<Object> next;
	
		/**
		 * This initializes the node by having
		 * an information filed and a referance to the next
		 * field
		 * @param i the object of the node
		 * @param next the next object of the node
		 */
		public Node(Object i, Node<Object> next) {
			this.data = i;
			this.next = next;
		}
	}
}
