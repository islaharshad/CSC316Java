package edu.ncsu.csc316.hr.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.hr.resource.Employee;
import edu.ncsu.csc316.hr.tree.Tree;

/**
 * Parses the employee tree and builds it as a form of general tree
 * @author Islahuddin Arshad
 *
 */
public class EmployeeReader {
 
	/**File path to employee file*/
	public String filePathToEmployee;
	/**Employee file*/
	public File employeeFile;
	/**Scanner used to build tree*/
	public Scanner employeeScanner;
	/**General tree to added*/
	public Tree employeeTree;
	/**Employee read from a line*/
	public Employee employeeFromLine;
	
	/**
	 * Initiates the employee reader object
	 * @param filePathToEmployee the path to employee file
	 */
	public EmployeeReader(String filePathToEmployee) {
		this.filePathToEmployee = filePathToEmployee;
		
	}
	
	/**
	 * This method takes in a string line from the employee file
	 * and returns the line as an employee object
	 * @param line the employee line to be read
	 * @return Employee the employee object to return
	 */
	public Employee readLineToEmployee(String line) {
		////remove/trim space
		String[] employeeSplit = line.split(",");
		if(employeeSplit.length < 3)
		{
			System.out.println("Line Split Error : " + line);
			return null;
		}
		Employee employeeAtLine = new Employee("", "", "");
		employeeAtLine.setFirstName(employeeSplit[0].trim());
		employeeAtLine.setLastName(employeeSplit[1].trim());
		employeeAtLine.setResumeID(employeeSplit[2].trim());
		employeeAtLine.setParent(null);
		return employeeAtLine;
	}
	
	/**
	 * Builds a tree from employee file by parsing individual lines
	 * @param filePathToEmployee the file path of the employee file
	 * @return Employee the employee at the root of the tree
	 * @throws FileNotFoundException if file not found 
	 */
	public Employee buildTree(String filePathToEmployee) {
		
		
		
		employeeFile = new File(filePathToEmployee);
		try {
			employeeScanner = new Scanner(employeeFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		///Create a new tree of employees
		employeeTree = new Tree(null);
		//Current employee
		Employee currentEmployee = readLineToEmployee(employeeScanner.nextLine());
		
		Employee employeeAtTree = new Employee("", "", "");
		
		///employeeTree.root = currentEmployee;
		employeeTree.setRoot(currentEmployee);
		///discard the second line of the file
	    employeeScanner.nextLine();
	    
	    String currentLine = "";
	    while (employeeScanner.hasNextLine()) {
	    	///get the current line
	    	currentLine = employeeScanner.nextLine().trim();
	    	if (!currentLine.equals("(") && !currentLine.equals(")")) {
	    		///reads the currentline and fills the employee object
	    		employeeAtTree = readLineToEmployee(currentLine);
	    		///Make currentEmployee the parent of employeeAtTree
	    		employeeAtTree.setParent(currentEmployee);
	    		///Add the employee at tree as one of the children for current employee MANUALLLY
	    		currentEmployee.getChildren().insert(employeeAtTree);
	    		////PROBLEMO!!!! 
	    	}
	    	else if (currentLine.equals("(")) {
	    		///set the current employee to last of its own children//move the currentemployee point to its last child
	    		currentEmployee = (Employee) currentEmployee.getChildren().get(currentEmployee.getChildren().getSize() - 1);
	    	}
	    	else if (currentLine.equals(")")) {
	    		if (currentEmployee.getParent() == null) {
	    			break;
	    		}
	    		else { 
	    			currentEmployee = currentEmployee.getParent();
	    		}
	    	}
	    }
	    
		return employeeTree.root;
	}
}
