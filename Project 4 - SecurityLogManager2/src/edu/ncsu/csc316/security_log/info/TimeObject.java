package edu.ncsu.csc316.security_log.info;

/**
 * Implements the time stamp and make sure the time zone is correct and
 * is used to compare two time stamps
 * @author Islahuddin Arshad
 *
 */
public class TimeObject implements Comparable<TimeObject> {

	/*The time zone*/
	private char timeZone;
	/*The second*/
	private int second;
	/*The minute*/
	private int minute;
	/*The hour*/
	private int hour;
	/*The day*/
	private int day;
	/*The month*/
	private int month;
	/*The year*/
	private int year;
	/*The number representation of time stamp*/
	private long number;
	/*The string representation of time stamp*/
	private String stringer;
	
	
	/**
	 * Initializes the time object and parses the stamp to get 
	 * month , year, day etc.
	 * @param stamp the string represenation of time stamp
	 */
	public TimeObject(String stamp) {
		timeZone = stamp.charAt(19);
		second = Integer.parseInt(stamp.substring(17, 19));
		minute = Integer.parseInt(stamp.substring(14, 16));
		hour = Integer.parseInt(stamp.substring(11, 13));
		month = Integer.parseInt(stamp.substring(0, 2));
		day = Integer.parseInt(stamp.substring(3, 5));
		year = Integer.parseInt(stamp.substring(6, 10));
		
		
		
		
	
		
		
		
		
		
		StringBuilder sb = new StringBuilder();
		int ten = 10;
		
		if (month < ten) {
			sb.append('0');
		}
		sb.append(month);
		sb.append('/');
		
		if (day < ten) {
			sb.append('0');
		}
		sb.append(day);
		sb.append('/');
		
		if (year < ten) {
			sb.append('0');
		}
		sb.append(year);
		sb.append(' ');
		
		if (hour < ten) {
			sb.append('0');
		}
		sb.append(hour);
		sb.append(":");
		
		if (minute < ten) {
			sb.append('0');
		}
		sb.append(minute);
		sb.append(":");
		
		if (second < ten) {
			sb.append('0');
		}
		sb.append(second);
		sb.append(timeZone);
		sb.append("M");

		stringer = sb.toString();
		int twelve = 12;
		number = second;
		number = number + minute * 100;
		number = number + hour * 10000;
		if (hour == twelve) {
			number = number - (twelve * 10000);
		}
		if (timeZone == 'P') {
			number = number + (twelve * 10000); 
		}
		number = number + (day * 1000000);
		number = number + (month * 100000000);
		number = number + (year * 10000000000L);
		
	}
	
	
	/**
	 * Compares two time stamps by numberical value
	 */
	@Override
	public int compareTo(TimeObject object) {
		return Long.compare(getNumber(), object.getNumber());
	}
	
	/**
	 * Gets the number representation of time stamp
	 * @return long the number to return
	 */
	public long getNumber() {
		return number;
	}
	
	/**
	 * Gets the string representation of the time stamp
	 */
	@Override
	public String toString() {
		return stringer;
	}
	

	
	
}
