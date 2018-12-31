package edu.ncsu.csc316.security_log.manager;



/**
 * Constructs the logFile object that contains the user information
 * @author Islahuddin Arshad
 *
 */
public class LogFile {

	/**The username of the user*/
	private String username;
	/**The timestamp of the user*/
	private String time;
	/**The action performed by the user*/
	private String action;
	/**The resource used by the user*/
	private String resource;
	/**The frequency of the same logFile*/
	private int frequency;
	
	/**
	 * Initializes the logFile
	 * @param username name of the user
	 * @param time time of logfile
	 * @param action with logfile
	 * @param resource resource used in logfile
	 * @param frequency of logfile
	 */
	public LogFile(String username, String time, String action, String resource, int frequency) {
		this.username = username;
		this.time = time;
		this.action = action;
		this.resource = resource;
		this.frequency = frequency;
	}
	
	/**
	 * Allows to call the user
	 * @return the user to be called
	 */
	public String getUser() {
		return username;
	}

	/**
	 * Sets the frequency of logfiles
	 * @param frequency the frequency of logfiles
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Gets time of logfile access
	 * @return String the time of loegfile access
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Gets the action of logfile entry
	 * @return String the action in logfile
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Gets the action in logfile
	 * @return String the resource in logfile
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * Gets the frequency of logfile
	 * @return int the frequency of logfiles
	 */
	public int getFrequency() {
		return frequency;
	}
	/**
	 * Gets the string version of logfiles
	 * @return String to be taken from logfiles
	 */
	@Override
	public String toString() {
		return "" + this.getUser() + " " + this.getTime() + " " + this.getAction() + " " + this.getResource() + " " + this.getFrequency();
	}
	
	
	


	
	
}
