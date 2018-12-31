package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the SecurityLogManager
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManagerTest {

	/**The orginal arraylist to be tested*/
	MyArrayList<LogFile> str;
	/**A temp arrraylist to put the variables in */
	MyArrayList<LogFile> str1;
	/**The SecurityLogManager to checked */
	SecurityLogManager slm;
	/**The new file that needs to be created */
	File file;
	/**The file path to get the file from*/
	String filepath;
	/**The start date*/
	String start;
	/**The end date*/
	String end;
	/**The operational string to be tested*/
	String operationalString;
	/**The username to be tested*/
	String username;
	
	/**
	 * Sets up the testing for SecurtyLogManager
	 */
	@Before
	public void setUp() {
		String inputStr = new String(
				"USERNAME, TIMESTAMP, ACTION, RESOURCE\r\n" +
		"jtking, 1/18/2018 01:22:21PM, view, prescription information\r\n" +
		"mbbrown, 1/18/2018 01:23:47PM, create, immunization order\r\n" +
		"ssoulcrusher, 1/18/2018 01:22:01PM, delete, prescription information\r\n" +
		"jdschmidt, 1/18/2018 01:24:21PM, view, prescription information\r\n" +
		"jtking, 1/18/2018 12:58:14PM, delete, demographics information\r\n");
		
		try(FileOutputStream fos = new FileOutputStream("sampleInput.txt");
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
		filepath = "sampleInput.txt";		
//		filepath = "C:\\Users\\Islahuddin Arshad\\git\\csc316-001-P1-35\\SecurityLogManager\\src\\edu\\ncsu\\csc316\\security_log\\manager\\textFile.txt";
		slm = new SecurityLogManager(filepath);
		str = new MyArrayList<LogFile>();
		try {
			file = slm.checkFile(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * Test if the file is valid
	 * @throws FileNotFoundException if the file is not valid
	 */
	@Test
	public void testCheckFile() throws FileNotFoundException {
		assertEquals("sampleInput.txt", slm.checkFile(filepath).toString());
	}
	

	/**
	 *Tests the operational profile
	 * @throws ParseException if the dates cannot be parsed
	 */
	@Test
	public void getOperationalProfile() throws ParseException {
		start = "1/18/2018 12:00:00PM";
		end = "1/18/2018 03:00:00PM";
		assertEquals("OperationalProfile[\n   "
				+ "view prescription information: frequency: 2, percentage: 40.0%\n"
				+ "   create immunization order: frequency: 1, percentage: 20.0%\n"
				+ "   delete demographics information: frequency: 1, percentage: 20.0%\n"
				+ "   delete prescription information: frequency: 1, percentage: 20.0%\n]", slm.generateOperationalProfile(start, end));
		
		
	}
	
	/**
	 * Tests the sum of frequencies of the final output
	 */
	@Test
	public void testGetSum() {
		str.insert(new LogFile("a", "1/17/2018 12:00:00AM", "act", "res", 1));
		str.insert(new LogFile("a", "1/17/2018 12:00:00AM", "zact", "res", 3));
		assertEquals(4, slm.getSum(str, str.getSize() - 1));
		str.reset();
		assertEquals(-1, slm.getSum(str, str.getSize() - 1));
		
	}
	
	/**
	 * Tests the users report output from the username
	 */
	@Test
	public void testGetUserReport() {
		username = "jtking";
		assertEquals("Activity Report for jtking[\n"
				+ "   1/18/2018 12:58:14PM - delete demographics information\n"
				+ "   1/18/2018 01:22:21PM - view prescription information\n]", slm.getUserReport(username));
	}


}
