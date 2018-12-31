package edu.ncsu.csc316.hr.resource;



import edu.ncsu.csc316.hr.util.MyLinkedList;

/**
 * The employee class that creastes and deals with the employee object
 * @author Islahuddin Arshad
 *
 */
public class Employee {

	/**The first name of the employee*/
	private String firstName;
	/**The last name of the employee*/
	private String lastName;
	/**The resumeID of the employee*/
	private String resumeID;
	/**The parent employee*/  
	private Employee parent;
	/**The employee's full name*/
	private String fullName;
	/**The list of an employee's children*/
	private MyLinkedList<Employee> children;
	
	/**
	 * Constructs the employee object
	 * @param firstName the fisrt name of the employee
	 * @param lastName the last name of the employee
	 * @param resumeID the resumeID of the employee
	 */
	public Employee(String firstName, String lastName, String resumeID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.resumeID = resumeID;
		children = new MyLinkedList<Employee>();
	}
	/**
	 *Gets the first name of the employee
	 * @return String the first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 *Gets the last name of the employee
	 * @return String the last name of the employee
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 *Gets the resume ID of the employee
	 * @return String the resumeID of the employee
	 */
	public String getResumeID() {
		return resumeID;
	}
	
	/**
	 * Gets the full name of the employee
	 * @return String the full name of the employee
	 */
	public String getFullName() {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName);
		sb.append(" ");
		sb.append(lastName);
		setFullName(sb.toString());
		return fullName;
	}
	
	/**
	 * Gets the parent of the employee
	 * @return Employee the parent of the employee
	 */
	public Employee getParent() {
		return parent;
	}
	
	
	/**
	 * Gets the children of the employee
	 * @return MyArrayList<Employee> the children arraylist of the employee
	 */
	public MyLinkedList<Employee> getChildren() {
		return children;
	}
	
	/**
	 * Sets the first name of the employee
	 * @param firstName first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Sets te last name of the employee
	 * @param lastName last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Sets the resume ID of the employee
	 * @param strResumeID resume ID to set
	 */
	public void setResumeID(String strResumeID) {
		this.resumeID = strResumeID;
	}
	
	/**
	 * Sets the full name of the employee
	 * @param fullName full name to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * Sets the parent of the employee
	 * @param parent the parent to set
	 */
	public void setParent(Employee parent) {
		this.parent = parent;
	}
	
//	/**
//	 * Sets the children as needed
//	 * @param children
//	 */
//	public void setChildren(MyArrayList<Employee> children) {
//		this.children = children;
//		
//	}
//	
//	public void setEmployee(Employee emp) {
//		this.setFirstName(emp.getFirstName());
//	    this.setLastName(emp.getLastName());
//	    this.setFullName(emp.getFullName());
//	    this.setResumeID(emp.getResumeID());
//	    this.setParent(emp.getParent());
//	    this.setChildren(emp.getChildren());
//	}
	    
	
}
