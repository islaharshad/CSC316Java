package edu.ncsu.csc316.rentals.util;

import edu.ncsu.csc316.rentals.resource.EdgeEntry;

/**
 * MySplayerTree class is an implementation of a splay tree
 * It has the methods of insert, getMake, getModel, delete,
 * exists, and splayer. It is used to make a tree by reading in
 * the dictionary and to extract values from it. Taken from the last
 * project
 * @author Islahuddin Arshad 
 *
 */
public class MySplayDictionary {

	/**The root node of DictNode*/
	private DictNode base;
	
	
	/**
	 * Initializes the Dictionary Node to be used in the tree
	 * It has left, right values. It also has to variables inside it.
	 * Once is string variable denoting a start and end day and the other one is
	 * @author Islahuddin Arshad
	 *
	 */
	private class DictNode {
		/*The right node*/
		private DictNode r;
		/*The left node*/
		private DictNode l;
		/*The value, edge entry*/
		private EdgeEntry v;
		/*The key, start and end days*/
		private String k;
		
		/**
		 * Initializes the DictNode object
		 * @param k the resumeID as the key
		 * @param v the Resume as the value
		 */
		public DictNode(String k, EdgeEntry v) {
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
	 * @param k the EdgeEntry
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
	 * @param k the EdgeEntry to delete
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
	 * @param v the EdgeEntry value to insert
	 */
	public void insert(String k, EdgeEntry v) {
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
	 * Returns the make of the root of the dict tree
	 * @param k the start and end day to which make is mapped
	 * @return String the make of the car
	 */
	public String getMakeFromDict(String k) {
		base = splayer(base, k);
		int compareNumber = k.compareTo(base.k); 
		if (compareNumber == 0) {
			return base.v.getMake();
		}
		else {
			return null;
		}
	}
	/**
	 * Returns the model of the root of dict tree
	 * @param k the start and end day to which the model is mapped
	 * @return String the model of the car
	 */
	public String getModelFromDict(String k) {
		base = splayer(base, k);
		int compareNumber = k.compareTo(base.k);
		if (compareNumber != 0) {
			return null;
		}
		else {
			return base.v.getModel();
		}
	}
	
	
	
	/**
	 * Returns the dictionary object of the root of dict tree
	 * @param k the edge entry object to which the dictionary is mapped
	 * @return EdgeEntry the dictionary to return
	 */
	public EdgeEntry getDictObject(String k) {
		base = splayer(base, k);
		int compareNumber = k.compareTo(base.k);
		if (compareNumber != 0) {
			return null;
		}
		else {
			return base.v;
		}
	}

	
	/**
	 * checks if the dictionary value mapped with edge entry exists
	 * @param k the start and end day to be checked
	 * @return true if the edgeEntry exists
	 */
	public boolean exists(String k) {
		return getDictObject(k) != null;
	}
	
	
}
	

