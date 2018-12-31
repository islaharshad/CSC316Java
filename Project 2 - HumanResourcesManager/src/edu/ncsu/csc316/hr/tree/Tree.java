package edu.ncsu.csc316.hr.tree;
import edu.ncsu.csc316.hr.resource.Employee;

import edu.ncsu.csc316.hr.util.MyLinkedList;
import edu.ncsu.csc316.hr.util.MyQueue;
/**
 * This class lookups, and helps print out the general tree read
 * @author Islahuddin Arshad
 *
 */
public class Tree {

	/**The root employee*/
	public Employee root;
	/**
	 * Initiates the tree
	 * @param root the root of the employee
	 */
	public Tree(Employee root) {
		this.root = root;
	}
	
//	/**
//	 * Returns the root of the tree
//	 * @return Employee root of the tree
//	 */
//	public Employee getRoot() {
//		return root;
//	}
	/**
	 * Sets the root of the tree
	 * @param root the root employee of the tree
	 */
	public void setRoot(Employee root) {
		this.root = root;
	}
	
	/**
	 * Looksup the employee in the general tree, if not found, returns null
	 * @param firstName the first name of the employee
	 * @param lastName the last name of the employee
	 * @param root the root employee in the tree
	 * @return the employee that is found, else return null
	 */
	public Employee lookUp(String firstName, String lastName, Employee root) {
		
		if(root.getFirstName().equals(firstName) && root.getLastName().equals(lastName)) {
			return root;  
		}
		MyLinkedList<Employee> kids = root.getChildren();
		Employee reserve = null;
		int check = 0;
		while (reserve == null && check < kids.getSize()) {
			reserve = lookUp(firstName, lastName, (Employee)kids.get(check));				
			check++;
		}
		return reserve;   
	}
	
	
	
	
	/**
	 * Looksup the index of children
	 * @param employeeToFind employee to find the index of 
	 * @param root the employee's parent
	 * @return int the employee's index
	 */
	public int lookUpIndex(Employee employeeToFind, Employee root) {
		int counter = 0;
		if(root == null)
			return -1;
		while (!root.getChildren().get(counter).equals(employeeToFind)) {
			counter++;
		}
		return counter;
	}

	
//	/**
//	 * Removes the employee at the leaf node by setting node to null
//	 * @param emp the employee to remove
//	 */
//	public void remove(Employee emp) {
//		emp.setFirstName("");
//		emp.setLastName("");
//		emp.setFullName("");
//		
//	}
		
		
		
		
//		
//		
//		///setting the size of siblings to one less
//		///get the sibling size of the promote employee
//		int sizeOfPromoteSibling = emp.getParent().getChildren().getSize();
//		//decrease it by one
//		sizeOfPromoteSibling--;
//		//Set it as the new size of children
//		emp.getParent().getChildren().setSize(sizeOfPromoteSibling);
	
	
	/**
	 * Gets the level order traversal of the Employee tree
	 * @param root the root employee of the employee tree
	 * @return StringBuilder the string builder version of the traversal
	 */
	public String getLevelOrder(Employee root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return "Not active employees.";
		}
		
		MyQueue<Employee> q = new MyQueue<Employee>();
		q.enqueue(root);
		
		
		///if the queue is empty that even the root is null, would output, "No active employees."
		if (q.isEmpty()) {
			return "No active employees.";
		}
		while (!q.isEmpty()) {
			////Inefficient 
			//for (int qSize = q.getSize(); qSize > 0; qSize--) {
				Employee res = (Employee) q.peeker();
				q.dequeue();
				
				sb.append("   ");
				
				sb.append(res.getFullName());
				sb.append("\n");
				///sb.append("   " + res.getFullName() + "\n");
				int checker = 0;
				while (checker < res.getChildren().getSize()) {
					if (!((Employee) res.getChildren().get(checker)).getFullName().equals(" ")) {
						q.enqueue((Employee) res.getChildren().get(checker));
					//remove the blank line!!!!
//					if (((Employee) res.getChildren().get(checker)).getFullName().equals(" ")) {
//						q.remove(checker);
//					}
					}
					checker++;
				}
			//}
		}
		return sb.toString();
		
	}

	
	
	
}
