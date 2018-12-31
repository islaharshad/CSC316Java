package edu.ncsu.csc316.hr.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.hr.manager.HumanResourcesManager;

/**
 * This is the ui class that tests the overall program
 * @author Islahuddin Arshad
 *
 */
public class HumanResourcesManagerUI {

	/**
	 * The main method for testing
	 * @param args the arguments in the main method
	 * @throws FileNotFoundException thrown if file is not found
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		HumanResourcesManager hr = null;
		String employeePathName = "";
		String resumePathName = "";
		String organizationalProfile = "";
		String removeEmployeeFirstName = "";
		String removeEmployeeLastName = "";
		String interimEmployee = "";
		Scanner input = new Scanner(System.in);
		
		//for testing purposes
//		System.out.println("Please enter employee information and resume filepaths:");
//		System.out.print("Employee information filepath: ");
//		employeePathName = input.nextLine();
//		System.out.print("Employee resume filepath: ");
//		resumePathName = input.nextLine();
		
		//testing
		employeePathName = "C:\\Users\\Islahuddin Arshad\\git\\csc316-001-P2-35\\HumanResourcesManager\\input\\employee.txt";
		
		//testing
		resumePathName = "C:\\Users\\Islahuddin Arshad\\git\\csc316-001-P2-35\\HumanResourcesManager\\input\\resume.txt";
		
		
		
		
		
		File employeeFile = new File(employeePathName);
		File resumeFile = new File(resumePathName);
		
		//Check if the files exist or not
		while (!employeeFile.exists() && !resumeFile.exists()) {
			System.out.println("Please enter employee information and resume filepaths:");
			System.out.print("Employee information filepath: ");
			employeePathName = input.nextLine();
			System.out.print("Employee resume filepath: ");
			resumePathName = input.nextLine();
			
			employeeFile = new File(employeePathName);
			resumeFile = new File(resumePathName);
		}
		
		///create a new hr since the files now exist
		hr = new HumanResourcesManager(employeePathName, resumePathName);
		//continue...
		System.out.println("Success!");
		System.out.println("Press 1 to generate Orgnanizational profile from the employee information file.");
		System.out.println("Press 2 to remove a specified employee");
		System.out.println("Press 'Q'/'q' to quit");
		int inputAnswer = input.nextInt();
		
		if (inputAnswer == 1) {
			organizationalProfile = hr.generateOrganizationalProfile();
			if (!organizationalProfile.equals("No active employees.")) {
				System.out.println(organizationalProfile);
			}
			else {
				System.out.println("No active employees");
			}
			
		}
		else if (inputAnswer == 2) {
			System.out.println("What is the first name of the employee you would like to remove?");
			removeEmployeeFirstName = input.next();
			input.nextLine();
			System.out.println("What is the last name of the employee you would like to remove?"); 
			removeEmployeeLastName = input.next();
			///input.nextLine();
			///System.out.println(removeEmployeeFirstName + " " + removeEmployeeLastName);
			interimEmployee = hr.removeEmployee(removeEmployeeFirstName, removeEmployeeLastName);
			
			while (interimEmployee.equals("Employee was not found.")) {
				System.out.println("");
				System.out.println("");
				System.out.println("Employee was not found.");
				System.out.println("What is the first name of the employee you would like to remove?");

				removeEmployeeFirstName = input.next();
				System.out.println("What is the last name of the employee you would like to remove?"); 
				//input.nextLine();
				removeEmployeeLastName = input.next();
				///System.out.println(removeEmployeeFirstName + " " + removeEmployeeLastName);
				interimEmployee = hr.removeEmployee(removeEmployeeFirstName, removeEmployeeLastName);
			}
			
			///An active employee exists
			System.out.println("Sucess!");
			System.out.println(removeEmployeeFirstName + " " + removeEmployeeLastName + " was removed.");
			System.out.println(hr.generateOrganizationalProfile());
			
			
		}
		if (input.next().equalsIgnoreCase("Q")) {
			System.exit(0);
		}
		
		input.close();

	}
}
