package edu.ncsu.csc316.security_log.util;



import java.util.Arrays;


/**
 * Constructs a custom array (imported from project (1) - security log manager
 * @author Islahuddin Arshad
 * @param <Element> the element to be inserted
 */
public class MyArrayList<Element> {

	/**Initial size of arrayr*/
	private int size = 0;
	/**An array of objects*/
	private Object[] array;
	
	/**
	 * Constructs an array of five elements
	 */
	public MyArrayList() {
		array = new Object[5];
	}
	
	/**
	 * Initialzies to a capacity
	 * @param cap the capacity to initialize
	 */
	public MyArrayList(int cap) {
		array = new Object[cap];
	}
	
	/**
	 * Retrieves the object at an index
	 * @param index the index to get object from
	 * @return Object the object get from index
	 */
	public Object get(int index) {
		if (index < size) {
			return array[index];
		} 
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	

	/**
	 * Resets the array
	 */
	public void reset() {
		size = 0;
	}
	


	/**
	 * Gets the size of the array
	 * @return int the size of the array
	 */
	public int getSize() {
		return size;
	}
	
	

	/**
	 * Allows to insert an object at the end
	 * @param obj the object to be inserted
	 */
	public void insert(Object obj) {
		if (size == array.length) {
			int doubleSize = array.length * 2;
			array = Arrays.copyOf(array, doubleSize);
		}
		array[size] = obj;
		size++;
	}

		

	/**
	 * Replaces the object at index and inserts another
	 * @param index the index at which to insert the object
	 * @param obj object to be inserted at the index
	 * @return Object that is replaced
	 */
	public Object setAt(int index, Object obj) {
		Object replace = null;
		for (int i = 0; i < array.length; i++) {
			if (i == index) {
				replace = array[i];
				array[i] = obj;
			}
		}
		return replace;
	}

	/**
	 * Removes the object at index
	 * @param index the index to be removed at
	 * @return Object the object to remove
	 */
	public Object delete(int index) {
		if (index < 0 || index > getSize() - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		Object rem = array[index];
		
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		array[size - 1] = null;
		size--;
		return rem;
	}


//	/**
//	 * Inserts object at a given index
//	 * @param index index to insert the object at
//	 * @param ele the object to be inserted
//	 */
//	public void insert(int index, Object ele) {
//		
//		if (index < 0 || index > size) {
//			throw new IndexOutOfBoundsException();
//		} 
//		
////		if (ele == null) {
////			throw new NullPointerException();
////		}
//		ensureCapacity(size + 1);
//		
//		for (int i = size; i >= index + 1; i--) {
//			array[i] = array[i - 1];
//		}
//		array[index] = ele;
//		size++;
//	}
	
//	/**
//	 * Ensures enough capacity
//	 * @param capacity the capacity to ensure
//	 */
//	public void ensureCapacity(int capacity) {
//		if (capacity > array.length) {
//			int newCap = array.length * 2 + 1;
//			array = Arrays.copyOf(array, newCap);
//		}
//	}

}

