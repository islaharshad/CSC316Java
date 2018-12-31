package edu.ncsu.csc316.hr.resource;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.hr.util.MyLinkedList;

/**
 * Tests the DictResume class when reading resume file
 * @author Islahuddin Arshad
 *
 */
public class ResumeTest {
	/**Makes the resumes*/
	MyLinkedList<Resume> resumes;
	/**
	 * Sets up the class
	 */
	@Before
	public void setUp() {
		resumes = new MyLinkedList<Resume>();
		resumes.insert(new Resume(1, "C"));
		resumes.insert(new Resume(2, "A"));
		resumes.insert(new Resume(1, "B"));
		resumes.insert(new Resume(9, "B"));
		resumes.insert(new Resume(7, "N"));
		resumes.insert(new Resume(1, "A"));
		resumes.insert(new Resume(5, "M"));
		
	}


	
	/**
	 * Tests the number of years' experience
	 */
	@Test
	public void testGetYears() {
		assertEquals(2, resumes.get(1).getYears());
	}
	
	/**
	 * Tests the degree of a user
	 */
	@Test
	public void testGetDegree() {
		assertEquals("B", resumes.get(3).getDegree());
	}
 
}



