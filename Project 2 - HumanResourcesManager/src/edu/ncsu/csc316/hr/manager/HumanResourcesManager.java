package edu.ncsu.csc316.hr.manager;
import java.io.FileNotFoundException;

import edu.ncsu.csc316.hr.io.EmployeeReader;
import edu.ncsu.csc316.hr.io.ResumeReader;
import edu.ncsu.csc316.hr.resource.Employee;
import edu.ncsu.csc316.hr.tree.Tree;
import edu.ncsu.csc316.hr.util.MySplayer;

/**
 * The human resource manager class creates a new human resource
 * object for ui to process
 * @author Islahuddin Arshad
 *
 */
public class HumanResourcesManager {

	/**The general employee tree*/
	public Tree generalEmployeeTree;
	
	/**The splay tree filled with resume dictionaries*/
	public MySplayer splayedResume;
	/**The employee reader object*/
	public EmployeeReader eR;
	/**The resume reader object*/ 
	public ResumeReader rR;
	/**The root employee*/
	public Employee rootEmployee;
	
	
	/**
	 * Constructs a new HR manager with the given input files
	 * 
	 * @param pathToEmployeeFile
	 *            - the path to the employee input file
	 * @param pathToResumeFile
	 *            - the path to the resume input file
	 * @throws FileNotFoundException if file not found 
	 */
	public HumanResourcesManager(String pathToEmployeeFile, String pathToResumeFile) {
	    rootEmployee = new Employee("", "", "");
		eR = new EmployeeReader(pathToEmployeeFile);
	    rR = new ResumeReader(pathToResumeFile);
	    
	    generalEmployeeTree = new Tree(rootEmployee); //changed
	    
	    //splayedResume = new MySplayer();
	    
		rootEmployee = eR.buildTree(pathToEmployeeFile);
		splayedResume = rR.readResume(pathToResumeFile);
	}
	
	
	/**
	 * Returns the string representation of the organizational
	 * profile of the company using the given input employee file.
	 * 
	 * @return String the properly formated organizational profile
	 */
	public String generateOrganizationalProfile() {
		StringBuilder sb = new StringBuilder();
		if (generalEmployeeTree.getLevelOrder(rootEmployee).equals("No active employees.")) {
			return "No active employees.";
		}
			sb.append("OrganizationalProfile[\n");
			if (rootEmployee != null) {
				sb.append(generalEmployeeTree.getLevelOrder(rootEmployee));
			}
			
			sb.append("]");
		    return sb.toString();

//		return "No active employees.";
	}
	
//	/**
//	 * Testing
//	 * @param r splayer
//	 * @return if exists
//	 */
//	public String tester(MySplayer r) {
//		String check = "";
//		if (r.exists("R200581294")) {
//			check += "Sarah ";
//		}
//		if (r.exists("R000634703")) {
//			check += "John ";
//		}
//		if (r.exists("R040123346")) {
//			check += "Jane ";
//		}
//		if (r.exists("R829476581")) {
//			check += "Thomas ";
//		}
//		if (r.exists("R228401745")) {
//			check += "Jessica ";
//		}
//		if (r.exists("R123582991")) {
//			check += "Kyle ";
//		}
//		if (r.exists("R891429182")) {
//			check += "Suzanne";
//		}
//		return check;
//	}
	
	
	
	
	/**
	 * Returns a string representation of the interim employee
	 * who replaces the removed employee.
	 * 
	 * @param first - the first name of the employee to remove
	 * @param last - the last name of the employee to remove
	 * @return the name of the employee who was promoted to interim supervisor
	 */
	public String removeEmployee(String first, String last) {
		
		int n = 1;
		
//		String check1 = tester(splayedResume);
//		check1 = "";
		
		
		
		
		
		Employee employeeToRemove = new Employee("", "", "");
		Employee employeeToPromote = new Employee("", "", "");
		
		///Lookup for employee to remove
		employeeToRemove = generalEmployeeTree.lookUp(first, last, rootEmployee);
		
		///if employee does not exist in the general tree OR the exmployee's resume ID cannot be mapped to an employee object, we 
		///return "Employee was not found."
		
		if (employeeToRemove == null || !splayedResume.exists(employeeToRemove.getResumeID())) {
			return "Employee was not found.";
		}
		
		//check this out!!!
		//tester(splayedResume);
		//splayedResume.exists("Abcd");
		
		String firstInterimName = "";
		
		///delete removed employee info from resume///CHECKKKKKKK
		//splayedResume.delete(employeeToRemove.getResumeID());
		
		
//		String check3 = tester(splayedResume);
//		check3 = "";
		
		if (employeeToRemove.getParent() == null && employeeToRemove.getChildren().getSize() == 0) {
			employeeToRemove.setFirstName(" ");
			employeeToRemove.setLastName(" ");
			employeeToRemove.setFullName(" ");
			return "Succesfully removed";
//			Employee p = employeeToPromote.getParent();
//			int index = generalEmployeeTree.lookUpIndex(employeeToPromote, p);
//			
//			p.getChildren().remove(index);
		}
		else {
			while (employeeToRemove != null && employeeToRemove.getChildren() != null && employeeToRemove.getChildren().getSize() != 0) {
				
//				String check4 = tester(splayedResume);
//				check4 = "";
				
				//Get promote employee
				employeeToPromote = employeeToPromote(employeeToRemove, splayedResume);
				
				if (n == 1) {
					firstInterimName = employeeToPromote.getFullName();
					n--;
				}
				
				///set full name of promoted employee to full name of removed employee
				employeeToRemove.setFullName(employeeToPromote.getFullName());
				employeeToRemove.setFirstName(employeeToPromote.getFirstName());
				employeeToRemove.setLastName(employeeToPromote.getLastName());
				employeeToRemove.setResumeID(employeeToPromote.getResumeID()); ///change added, now splay should work

				employeeToRemove = employeeToRemove.getChildren().getEmployeeByFullName(employeeToRemove.getChildren(), employeeToRemove.getFullName());
				
			}
			if (employeeToPromote.getChildren().getSize() == 0) {
				Employee p = employeeToPromote.getParent();
				if (p != null) {
					int index = generalEmployeeTree.lookUpIndex(employeeToPromote, p);
				
					p.getChildren().remove(index);
				}
//				else {
//					System.out.println("Unexpected null root");
//				}
				///generalEmployeeTree.remove(employeeToPromote);	
			}
		}
			
			
//			
//			Employee p = employeeToRemove.getParent();
//			int index = generalEmployeeTree.lookUpIndex(employeeToRemove, p);
//			
//			p.getChildren().remove(index);
			//generalEmployeeTree.remove(employeeToRemove);	
		
		
		
		
		return firstInterimName;


	}
	

	/**
	 * Converts the degree to a number signifiying its worth
	 * @param degree the degree to check
	 * @return the significance number corresponding with number
	 */
	public int convertDegreeToInt(String degree) {
		if (degree.equals("P")) {
			return 5;
		}
		else if (degree.equals("M")) {
			return 4;
		}
		else if (degree.equals("B")) {
			return 3;
		}
		else if (degree.equals("A")) {
			return 2;
		}
		else if (degree.equals("N")) {
			return 1;
		}
		else if (degree.equals("L")) {
			return 0;
		}
		return -1;
	}
	

	/**
	 * Promotes the employee based on exp years, employee supervised, degree
	 * last and first names
	 * @param replacingEmployee the employee who children are being checked and compared
	 * @param resumes the resumes from which the employees years and number degrees are gotten
	 * @return Employee the employee who meets the criteria to be promoted
	 */
	public Employee employeeToPromote(Employee replacingEmployee, MySplayer resumes) {
		
		Employee promotedEmployee = new Employee("", "", "");
		
//		int n = 1;
//		
//		String highestDegree = "L"; //// changed to L
		int compareDegree1 = 0;
		int compareHighestDegree = 0;
		
		
		int mostYearExp = 0;

		int mostEmployeesSupervised = 0;
		int counter = 0;
		while (counter < replacingEmployee.getChildren().getSize()) {
			///String child = ((Employee) replacingEmployee.getChildren().get(counter)).getFirstName();
			///get initial years of exp
			int yearExp = resumes.getYearsFromDict(((Employee) replacingEmployee.getChildren().get(counter)).getResumeID());
			///get initial number of employees supervised
			int employeesSupervised = ((Employee) replacingEmployee.getChildren().get(counter)).getChildren().getSize();
			//get initial degree
			String degree = resumes.getDegreeFromDict(((Employee) replacingEmployee.getChildren().get(counter)).getResumeID());
			//compare years of experience
			if (yearExp > mostYearExp) {
				mostYearExp = yearExp;
				////
				mostEmployeesSupervised = employeesSupervised; 
				compareHighestDegree = convertDegreeToInt(degree);
				////
				
				promotedEmployee = (Employee) replacingEmployee.getChildren().get(counter);
			}
			else if (yearExp == mostYearExp) {
				///compare the number of employees supervised
				if (employeesSupervised > mostEmployeesSupervised) {
					mostEmployeesSupervised = employeesSupervised;
					promotedEmployee = (Employee) replacingEmployee.getChildren().get(counter);
				}
				else if (employeesSupervised == mostEmployeesSupervised) {
					
					///compare the degrees ////CHECK!!!
					compareDegree1 = convertDegreeToInt(degree); ///converts "A" to 2
//					if (n == 1) {
//						compareHighestDegree = convertDegreeToInt(highestDegree); ///converts "L" to 0
//						n--;
//					} 
					
//					if (degreeComparator(degree, highestDegree) > 0) {
					if (compareDegree1 > compareHighestDegree) { ///2 is larger than 0
						compareHighestDegree = compareDegree1;
						
//						highestDegree.equals(degree); /////flipped
						promotedEmployee = (Employee) replacingEmployee.getChildren().get(counter);
					}
					else if (compareDegree1 == compareHighestDegree) {
						///compare last names 
						if (((Employee) replacingEmployee.getChildren().get(counter)).getLastName().compareTo(promotedEmployee.getLastName()) < 0) {
							/////DO check if the last names are the same
							promotedEmployee = (Employee) replacingEmployee.getChildren().get(counter);
						}
						else if (((Employee) replacingEmployee.getChildren().get(counter)).getLastName().compareTo(promotedEmployee.getLastName()) == 0 &&
								(((Employee) replacingEmployee.getChildren().get(counter)).getFirstName().compareTo(promotedEmployee.getFirstName()) < 0) ) {
							///compare first names
							//if (((Employee) replacingEmployee.getChildren().get(counter)).getFirstName().compareTo(promotedEmployee.getFirstName()) < 0) {
								////DO check if the first names are the same
								promotedEmployee = (Employee) replacingEmployee.getChildren().get(counter);
							//} 
						}
					} 
				}
			}
			counter++;
		}
		return promotedEmployee;
	}
	
}
	
	

