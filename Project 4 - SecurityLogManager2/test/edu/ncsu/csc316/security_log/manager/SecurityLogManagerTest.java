package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;


import org.junit.Test;


/**
 * Tests the securiy log manager for its methods
 * @author Islahuddin Arshad
 *
 */
public class SecurityLogManagerTest {



	/**
	 * Tests the security log manager class both the 
	 * the generate operational profile and the user report
	 */
	@Test
	public void testAll() {
		
		SecurityLogManager m = new SecurityLogManager("sampleInput.txt");
		
		assertEquals("OperationalProfile[\n   "
				+ "view prescription information: frequency: 2, percentage: 40.0%\n   "
				+ "create immunization order: frequency: 1, percentage: 20.0%\n   "
				+ "delete demographics information: frequency: 1, percentage: 20.0%\n   "
				+ "delete prescription information: frequency: 1, percentage: 20.0%\n]", m.generateOperationalProfile("01/17/2018 12:00:00AM", "01/20/2018 12:00:00PM"));
		
		
		
		assertEquals("Activity Report for jtking[\n   "
				+ "01/18/2018 12:58:14PM - delete demographics information\n   "
				+ "01/18/2018 01:22:21PM - view prescription information\n]", m.getUserReport("jtking"));
	}
	
	
	

}
