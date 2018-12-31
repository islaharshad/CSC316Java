package edu.ncsu.csc316.hr.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.hr.resource.Resume;

/**
 * Tests the splayer class that stores the resume ID and dictionary
 * @author Islahuddin Arshad
 *
 */
public class MySplayerTest {

	/**The splayer tree is created*/
	public MySplayer mS;
	
	/**First Resume Object*/
	public Resume res;
	/**Second Resume Object*/
	public Resume res1;
	/**Third Resume Object*/
	public Resume res2;
	/**Fourth Resume Object*/
	public Resume res3;
	/**Fifth Resume Object*/
	public Resume res4;
	
	/**
	 * Sets up the splay dictionary
	 */
	@Before
	public void setUp() {
		
		mS = new MySplayer();
		res = new Resume(2, "P");
		res1 = new Resume(3, "A");
		res2 = new Resume(5, "B");
		res3 = new Resume(5, "P");
		res4 = new Resume(6, "N");
		
	}
	
	

	/**
	 * Tests the insert method of dictionary
	 */
	@Test
	public void testInsert() {
		mS.insert("R123456", res);
		mS.insert("R789101", res1);
		mS.insert("R112131", res2);
		mS.insert("R345762", res3);
		mS.insert("R456234", res4);
		assertEquals(res4, mS.getDictObject("R456234"));
	}
	
	/**
	 * Tests the delete method of dictionary
	 */
	@Test
	public void testDelete() {
		mS.insert("R123456", res);
		mS.insert("R456234", res4);
		mS.delete("R123456");
		assertNotNull(mS.getDictObject("R456234"));
	}
	
	/**
	 * Tests the getter method for getting years experience from dictionray
	 */
	@Test
	public void testGetYearsFromDict() {
		mS.insert("R123456", res);
		mS.insert("R456234", res4);
		assertEquals(2, mS.getYearsFromDict("R123456"));
	}
	
	/**
	 * Tests the getter method for getting degree from dictionray
	 */
	@Test
	public void testGetDegreeFromDict() {
		mS.insert("R123456", res);
		mS.insert("R456234", res4);
		assertEquals("P", mS.getDegreeFromDict("R123456"));
	}
	/**
	 * Test whether a node exists or not
	 */
	@Test
	public void testExists() {
		mS.insert("R123456", res);
		assertTrue(mS.exists("R123456"));
		assertFalse(mS.exists("R183456"));
	}

}
