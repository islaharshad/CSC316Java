package edu.ncsu.csc316.hr.manager;

import static org.junit.Assert.*;


import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.hr.resource.Employee;
import edu.ncsu.csc316.hr.resource.Resume;
import edu.ncsu.csc316.hr.util.MySplayer;

/**
 * Tests the human resource manager to check if its
 * methods work fine or not
 * @author Islahuddin Arshad
 *
 */
public class HumanResourcesManagerTest { 

	/**Builds a new human resource manager*/
	public HumanResourcesManager hr;
	/**Builds a new splay tree*/
	public MySplayer mS;
	
	
	/**
	 * Sets up the human resource test method
	 * @throws FileNotFoundException 
	 */
	@Before
	public void setUp() throws FileNotFoundException {
		//String employeePath = "C:\\Users\\Islahuddin Arshad\\git\\csc316-001-P2-35\\HumanResourcesManager\\input\\employee.txt";
		String employeePath = "employeeFilePath1.txt";
		//String resumePath = "C:\\Users\\Islahuddin Arshad\\git\\csc316-001-P2-35\\HumanResourcesManager\\input\\resume.txt";
		String resumePath = "resumeFilePath1.txt";
		
		
//		String inputStr = new String(
//				"Sarah, Jones, R200581294\r\n" +
//		"(\r\n" +
//		"   John, Smith, R000634703\r\n" +
//		"   Jane, Doe, R040123346\r\n" +
//		"   (\r\n" +
//		"      Thomas, Webb, R829476581\r\n" +
//		"      (\r\n" +
//		"         Jessica, Daniels, R228401745\r\n" +
//		"         Kyle, DeMarcino, R123582991\r\n" +
//		"      )\r\n" +
//		"   )\r\n" +
//		"   Suzanne, Meadows, R891429182\r\n" +
//		")\r\n");
//
//		
//		try(FileOutputStream fos = new FileOutputStream("employeeFilePath2.txt");
//			    Writer w = new OutputStreamWriter(fos, "UTF8"))
//			{
//			    w.write(inputStr);
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		String employeePath = "employeeFilePath2.txt";
		
		hr = new HumanResourcesManager(employeePath, resumePath);

//		assertTrue(mS.exists("R040123346"));
		
	}

	/**
	 * Tests the whether organizational profile does the
	 * level order traversal that it needs to do and return
	 * the output in correct format
	 */
	@Test
	public void testGetOrganizationalProfile() {
	assertEquals("OrganizationalProfile[\n   Sarah Jones\n   John Smith\n   Jane Doe\n   Suzanne Meadows\n   Thomas Webb\n   Jessica Daniels\n   Kyle DeMarcino\n]", hr.generateOrganizationalProfile());
	hr.removeEmployee("Sarah", "Jones");
//		//Problem: remove employee
	assertEquals("OrganizationalProfile[\n   Jane Doe\n   John Smith\n   Thomas Webb\n   Suzanne Meadows\n   Jessica Daniels\n   Kyle DeMarcino\n]", hr.generateOrganizationalProfile());
	}
	
	
	/**
	 * Tests the remove employee method that returns the first
	 * interim employee to be promoted
	 */
	@Test
	public void testRemoveEmployee() {
		
		
		
		assertEquals("Jane Doe", hr.removeEmployee("Sarah", "Jones"));
		
		assertEquals("Suzanne Meadows", hr.removeEmployee("Jane", "Doe"));
		
		//Have it fixed
		assertEquals("Jessica Daniels", hr.removeEmployee("Thomas", "Webb"));
		
		assertEquals("Kyle DeMarcino", hr.removeEmployee("Jessica", "Daniels"));
		
		
	}
	

	/**
	 * Tests which employee to promote
	 */
	@Test
	public void testPromoteEmployee() {
		mS = new MySplayer();
		Employee e1 = new Employee("Islahuddin", "Arshad", "R41");
		Resume res1 = new Resume(5, "A");
		
		Employee e2 = new Employee("Taha", "Adnan", "R51");
		Resume res2 = new Resume(5, "A");
		
		Employee e3 = new Employee("Moomna", "Arshad", "R61");
		Resume res3 = new Resume(5, "M");
		
		Employee e4 = new Employee("Ummiya", "Arshad", "R71");
		Resume res4 = new Resume(5, "A");
		
		
		e1.getChildren().insert(e2);
		e1.getChildren().insert(e3);
		e1.getChildren().insert(e4);
		
		mS.insert("R41", res1);
		mS.insert("R51", res2);
		mS.insert("R61", res3);
		mS.insert("R71", res4);
	 
		
		assertEquals(e3, hr.employeeToPromote(e1, mS));
		
		////next test
		MySplayer mS1 = new MySplayer();
		
		Employee e5 = new Employee("Islahuddin", "Arshad", "R21");
		Resume res5 = new Resume(5, "P");
		
		Employee e6 = new Employee("Taha", "Adnan", "R31");
		Resume res6 = new Resume(5, "A");
		 
		Employee e7 = new Employee("Moomna", "Arshad", "R41");
		Resume res7 = new Resume(5, "M");
		
		Employee e8 = new Employee("Ummiya", "Arshad", "R51");
		Resume res8 = new Resume(5, "A");
		
		e5.getChildren().insert(e6);
		e5.getChildren().insert(e7);
		e7.getChildren().insert(e8);
		
		mS1.insert("R21", res5);
		mS1.insert("R31", res6);
		mS1.insert("R41", res7);
		mS1.insert("R51", res8);
		
		assertEquals(e7, hr.employeeToPromote(e5, mS1));
		
		
		
	////next test
		MySplayer mS2 = new MySplayer();
			
		Employee e9 = new Employee("Islahuddin", "Arshad", "R12");
		Resume res9 = new Resume(5, "P");
			
		Employee e10 = new Employee("Taha", "Adnan", "R13");
		Resume res10 = new Resume(5, "A");
			
		Employee e11 = new Employee("Moomna", "Arshad", "R14");
		Resume res11 = new Resume(5, "M");
			
		Employee e12 = new Employee("Ummiya", "Arshad", "R15");
		Resume res12 = new Resume(5, "P");
			
		e9.getChildren().insert(e10);
		e9.getChildren().insert(e11);
		e9.getChildren().insert(e12);
			
		mS2.insert("R12", res9);
		mS2.insert("R13", res10);
		mS2.insert("R14", res11);
		mS2.insert("R15", res12);
			
		assertEquals(e12, hr.employeeToPromote(e9, mS2));
		
		
		//////
		
		MySplayer mS3 = new MySplayer();
		
		Employee e13 = new Employee("Islahuddin", "Arshad", "R45");
		Resume res13 = new Resume(5, "P");
			
		Employee e14 = new Employee("Taha", "Adnan", "R46");
		Resume res14 = new Resume(5, "B");
			
		Employee e15 = new Employee("Moomna", "Arshad", "R47");
		Resume res15 = new Resume(5, "M");
		
		
		e13.getChildren().insert(e14);
		e13.getChildren().insert(e15);

		
		mS3.insert("R45", res13);
		mS3.insert("R46", res14);
		mS3.insert("R47", res15);
		
		///have it fixed
		assertEquals(e15, hr.employeeToPromote(e13, mS3));
		
	}

}
