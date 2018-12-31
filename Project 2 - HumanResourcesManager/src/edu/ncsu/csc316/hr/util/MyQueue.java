package edu.ncsu.csc316.hr.util;

import java.util.NoSuchElementException;



/**
 * Implements the queue using the linked list data structure
 * @author Islahuddin Arshad
 *
 * @param <Element> the element to be used as objects
 */
public class MyQueue<Element> {
	
	 
	/**The linkedList used for queue*/
	private MyLinkedList<Object> list;

	/**
	 * Sets the queue
	 */
	public MyQueue() {
		list = new MyLinkedList<Object>();
	}

//	/**
//	 * Removes the particular element at the index
//	 * @param ind the index to be removed at
//	 * @return the element to be removed
//	 */
//	public Object remove(int ind) {
//		return list.remove(ind);
//	}
	/**
	 * Gets the first object in the queue
	 * @return Object the first object in queue
	 */
	public Object peeker() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return list.get(0);
	}
	
	/**
	 * Checks if the list is empty
	 * @return true if empty, else returns false
	 */
	public boolean isEmpty() {
		return list.getSize() == 0;
	}
	/**
	 * Adds the object at the end of the queue
	 * @param element the object to add at the end of the queue
	 */
	public void enqueue(Object element) {
		list.add(list.getSize(), element);
		
	}
	
	/**
	 * Removes the object at begining of the queue
	 */
	public void dequeue() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		list.remove(0);
	}
	
	/**
	 * Gets the size of the queue
	 * @return int the size
	 */
	public int getSize() {
		return list.getSize();
	}
	
}
