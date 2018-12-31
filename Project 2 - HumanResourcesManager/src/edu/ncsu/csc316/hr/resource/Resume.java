package edu.ncsu.csc316.hr.resource;
/**
 * As the resume file is being parsed, the DictResume is being 
 * populated, skipping the first line
 * @author Islahuddin Arshad
 *
 */
public class Resume {

	
	/**The number of years of the user*/
	private int years;
	/**The degree of the user*/
	private String degree;
	
	/**
	 * Initializes the DictResume objecy
	 * @param years the number of years of experience of the user
	 * @param degree the degree of the User
	 */
	public Resume(int years, String degree) {
		
		this.years = years;
		this.degree = degree;
	}
	

	/**
	 * Gets the years of the user
	 * @return int the number of years
	 */
	public int getYears() {
		return years;
	}
	
	/**
	 * Gets the degree of the user
	 * @return String the degree of the user
	 */
	public String getDegree() {
		return degree;
	}


	
}
