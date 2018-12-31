package edu.ncsu.csc316.hr.io;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc316.hr.resource.Employee;

/**
 * Tests the employeeReader class to make the sure the tree is built right
 * @author Islahuddin Arshad
 *
 */
public class EmployeeReaderTest {

	/**Employee Reader object*/
	public EmployeeReader eR;
	/**Employee file path*/
	public String employeeFilePath;
	/**The root employee*/
	public Employee rootEmployee;
	
	/**
	 * Sets up the employee reader
	 */
	@Before
	public void setUp() {
//		employeeFilePath = "C:\\Users\\Islahuddin Arshad\\git\\csc316-001-P2-35\\HumanResourcesManager\\input\\employee.txt";
		
		
		String inputStr = new String(
				"Sarah, Jones, R200581294\r\n" +
		"(\r\n" +
		"   John, Smith, R000634703\r\n" +
		"   Jane, Doe, R040123346\r\n" +
		"   (\r\n" +
		"      Thomas, Webb, R829476581\r\n" +
		"      (\r\n" +
		"         Jessica, Daniels, R228401745\r\n" +
		"         Kyle, DeMarcino, R123582991\r\n" +
		"      )\r\n" +
		"   )\r\n" +
		"   Suzanne, Meadows, R891429182\r\n" +
		")\r\n");

		
		try(FileOutputStream fos = new FileOutputStream("employeeFilePath1.txt");
			    Writer w = new OutputStreamWriter(fos, "UTF8"))
			{
			    w.write(inputStr);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		employeeFilePath = "employeeFilePath1.txt";
		
		
		
		
//		employeeFilePath = "/HumanResourcesManager/test/employee.txt";
		eR = new EmployeeReader(employeeFilePath);
		rootEmployee = new Employee("", "", "");
		
	}

	/** 
	 * Builds the employee tree from the file
	 * @throws FileNotFoundException if file not found
	 */
	@Test
	public void testBuildTree() {
		rootEmployee = eR.buildTree(employeeFilePath);
		assertEquals("Sarah Jones", rootEmployee.getFullName());
		assertEquals("Jane Doe", ((Employee) rootEmployee.getChildren().get(1)).getFullName());
		assertEquals("Suzanne Meadows", ((Employee) rootEmployee.getChildren().get(2)).getFullName());
	}

}
