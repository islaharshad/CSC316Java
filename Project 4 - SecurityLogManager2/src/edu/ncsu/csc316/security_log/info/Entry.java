package edu.ncsu.csc316.security_log.info;

/**
 * This class sets the entry object being read from the file
 * @author Islahuddin Arshad
 *
 */
public class Entry {

	/*The time object*/
	private TimeObject time;
	/*The action*/
	private String action;
	/*The resource*/
	private String resource;
	/*The username*/
	private String name;
	/*The frequency*/
	private int frequency;
	
	/**
	 * Constructs the entry object which is constructed from
	 * reading the file
	 * @param name the user name
	 * @param time the time stamp
	 * @param action the action
	 * @param resource the resource
	 * @param frequency the frequency
	 */
	public Entry(String name, String time, String action, String resource, int frequency) {
		this.time = new TimeObject(time);
		this.name = name;
		this.resource = resource;
		this.action = action;
		this.frequency = frequency;
	}
	
	/**
	 * Sets the frequency
	 * @param freq the frequency to set
	 */
	public void setFrequency(int freq) {
		this.frequency = freq;
	}
	/**
	 * Gets the frequency
	 * @return int the frequency
	 */
	public Integer getFrequency() {
		return frequency;
	}
	/**
	 * Increments the frequency
	 */
	public void incrementFrequency() {
		
		this.frequency++;
		
	}
 	
	/**
	 * Gets the resource
	 * @return String the resource
	 */
	public String getResource() {
		return resource;
	}
	
	/**
	 * Gets the action
	 * @return String the action
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * Gets the time
	 * @return String the action
	 */
	public TimeObject getTime() {
		return time;
	}
	
	/**
	 * Gets the user name
	 * @return String the user name
	 */
	public String getName() {
		return name;
	}
	
//	public void setFrequency(int frequency) {
//		this.frequency = frequency;
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		return true;
	}
	
	
	

	
}
