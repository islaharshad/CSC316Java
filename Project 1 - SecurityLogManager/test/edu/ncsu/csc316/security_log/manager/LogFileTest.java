package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests the logfile object
 * @author Islahuddin Arshad
 *
 */
public class LogFileTest {

	/**The smaple logfile to be tested*/
	LogFile one;
	
	/**
	 * Creates a sample logfile object
	 */
	@Before
	public void setUp() {
		
		one = new LogFile("Jon", "1/18/2018 1:29:47PM", "act", "res", 6);
	}

	/**
	 * Gets the user from the logfile
	 */
	@Test
	public void testGetUser() {
		assertEquals("Jon", one.getUser());
	}

	/**
	 *Gets the frequency from the logfile
	 */
	@Test
	public void testGetFrequency() {
		assertEquals(6, one.getFrequency());
	}
	
	/**
	 * Gets the time from the logfile
	 */
	@Test
	public void testGetTime() {
		assertEquals("1/18/2018 1:29:47PM", one.getTime());
	}

	/**
	 * Gets the action from the logfile
	 */
	@Test
	public void testGetAction() {
		assertEquals("act", one.getAction());
	}

	/**
	 * Gets the resouces from the logfile
	 */
	@Test
	public void testGetResource() {
		assertEquals("res", one.getResource());
	}

	/**
	 * Sets the frequency for the logfile
	 */
	@Test
	public void testSetFrequency() {
		one.setFrequency(10);
		assertEquals(10, one.getFrequency());
	}
	/**
	 * Gives a string representation of hte logfile
	 */
	@Test
	public void testToString() {
		assertEquals("Jon 1/18/2018 1:29:47PM act res 6", one.toString());
	}
	
}
