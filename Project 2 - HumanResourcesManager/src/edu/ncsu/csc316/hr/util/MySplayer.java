package edu.ncsu.csc316.hr.util;

import edu.ncsu.csc316.hr.resource.Resume;

/**
 * MySplayers class is an implementation of a splay tree
 * It has the methods of insert, getYears, getDegree, delete,
 * exists, and splayer. It is used to make a tree by reading in
 * the dictionary and to extract values from it
 * @author Islahuddin Arshad 
 *
 */
public class MySplayer { ///<String extends Comparable<String>, DictResume> {

	/**The root node of DictNode*/
	private DictNode base;
	
	/**
	 * Initializes the Dictionary Node to be used in the tree
	 * It has left, right values. It also has to variables inside it.
	 * Once is string variable denoting a resumeID and the other one is
	 * a value of DictResume contaning the number of years and degrees
	 * @author Islahuddin Arshad
	 *
	 */
	private class DictNode {
		/*The right node*/
		private DictNode r;
		/*The left node*/
		private DictNode l;
		/*The value, resume*/
		private Resume v;
		/*The key, resumeID*/
		private String k;
		
		/**
		 * Initializes the DictNode object
		 * @param k the resumeID as the key
		 * @param v the Resume as the value
		 */
		public DictNode(String k, Resume v) {
			this.k = k;
			this.v = v;
		}
	}
	
	/**
	 * Zags the node to the left
	 * @param node the node to turn left
	 * @return DictNode the turned node
	 */
	private DictNode turnLeft(DictNode node) {
		DictNode lefter = node.r;
		node.r = lefter.l;
		lefter.l = node;
		return lefter;
		
	}
	
	/**
	 * Zigs the node to the right
	 * @param node the node to turn right
	 * @return DictNode the turned node
	 */
	private DictNode turnRight(DictNode node) {
		DictNode righter = node.l;
		node.l = righter.r;
		righter.r = node;
		return righter;
	}
	
	/**
	 * Splays the node by bringing it up so that
	 * it can be either inserted or deleted
	 * @param node the node to splay
	 * @param k the resumeID
	 * @return DictNode the splayed node
	 */
	private DictNode splayer(DictNode node, String k) {
		if (node == null) {
			return null;
		}
		
		int firstToCompare = k.compareTo(node.k);
		
		if (firstToCompare < 0) {
			if (node.l == null) {
				return node;
			}
			int secondToCompare = k.compareTo(node.l.k);
			if (secondToCompare < 0) {
				node.l.l = splayer(node.l.l, k);
				node = turnRight(node);
			}
			else if (secondToCompare > 0) {
				node.l.r = splayer(node.l.r, k);
				if (node.l.r != null) {
					node.l = turnLeft(node.l);
				}
			}
				
			if (node.l == null) {
				return node;
			}
			else {
				return turnRight(node);
			}
		}
		
		else if (firstToCompare > 0) {
			if (node.r == null) {
				return node;
			}
			
			int secondToCompare = k.compareTo(node.r.k);
			if (secondToCompare < 0) {
				node.r.l = splayer(node.r.l, k);
				if (node.r.l != null) {
					node.r = turnRight(node.r);
				}
			}
			
			else if (secondToCompare > 0) {
				node.r.r = splayer(node.r.r, k);
				node = turnLeft(node);
			}
			
			if (node.r == null) {
				return node;
			}
			else {
				return turnLeft(node);
			}
		}
		
		else {
			return node;
		}
				
	}
	
	/**
	 * Deletes the node by calling the splay method
	 * @param k the resumeID to delete
	 */
	public void delete(String k) {
		//if base is null, simply return
		if (base == null) {
			return;
		}
		///splay the node contanined the key
		base = splayer(base, k);
		
		//compare
		int compareNumber = k.compareTo(base.k);
		///if same, then splay the left tree at set as base
		if (compareNumber == 0) {
			if (base.l != null) {
				DictNode node = base.r;
				base = base.l;
				splayer(base, k);
				base.r = node;
			}
			else {
				//else set the base to right
				base = base.r;
			}
		}
	}
	
	/**
	 * Inserts the node into the splay tree
	 * like binary search trees
	 * @param k the resumeID to insert
	 * @param v the DictResume value to insert
	 */
	public void insert(String k, Resume v) {
		if (base == null) {
			base = new DictNode(k, v);
			return;
		}
		
		base = splayer(base, k);
		
		int compareNumber = k.compareTo(base.k);
		
		if (compareNumber < 0) {
			DictNode node = new DictNode(k, v);
			node.l = base.l;
			node.r = base;
			base.l = null;
			base = node;
			

		}
		else if (compareNumber > 0) {

			DictNode node = new DictNode(k, v);
			node.r = base.r;
			node.l = base;
			base.r = null;
			base = node;
			

		}
		else {
			base.v = v;
		}
		
	}
	
	
	/**
	 * Returns the years of the root of the dict tree
	 * @param k the resumeID to which the experience years are mapped
	 * @return int the years to return
	 */
	public int getYearsFromDict(String k) {
		base = splayer(base, k);
		

		
		
		int compareNumber = k.compareTo(base.k); ///returns a -6!!
		if (compareNumber == 0) {
			return base.v.getYears();
		}
		else {
			return -1;
		}
	}
	/**
	 * Returns the degree of the root of dict tree
	 * @param k the resumeID to which the degree is mapped
	 * @return String the degree to return
	 */
	public String getDegreeFromDict(String k) {
		base = splayer(base, k);
		int compareNumber = k.compareTo(base.k);
		if (compareNumber != 0) {
			return null;
		}
		else {
			return base.v.getDegree();
		}
	}
	
	
	
	/**
	 * Returns the dictionary object of the root of dict tree
	 * @param k the resumeID to which the dictionary is mapped
	 * @return DictResume the dictionary to return
	 */
	public Resume getDictObject(String k) {
		base = splayer(base, k);
		int compareNumber = k.compareTo(base.k);
		if (compareNumber != 0) {
			return null;
		}
		else {
			return base.v;
		}
	}
//	/**
//	 * Converts to string
//	 * @param k the string to convert
//	 * @return String the converted string
//	 */
//	public String stringer(String k) {
//		return k;
//	}
//	
//	public void print(DictNode root) {
//		if (root != null) {
//			System.out.println(root.k);
//			print(root.l);
//			print(root.r);
//		}
//	}
	
	/**
	 * checks if the dictionary value mapped with resumeID exists
	 * @param k the resumeID to be checked
	 * @return true if the resumeID exists
	 */
	public boolean exists(String k) {
		return getDictObject(k) != null;
	}
	
	
}
	

