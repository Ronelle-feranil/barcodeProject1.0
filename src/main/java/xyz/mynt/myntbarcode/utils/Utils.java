package xyz.mynt.myntbarcode.utils;

public class Utils {

	/**
	 * 
	 * Generates the system generated Unix Timestamp
	 * 
	 * @return unixTimeStamp
	 */
	public static long generateUnixTimeStamp() {
		
		long timestamp = System.currentTimeMillis() / 1000L;
			
		return timestamp;
	}
	
	/**
	 * Rounds timestamp to nearest 5 minutes
	 * 
	 * @param timestamp
	 * @return rounded timestamp 
	 */
	public static long roundToNearest5thMinute(long timestamp) {
		
		long roundedOff = timestamp - (timestamp % 300);
		
		return roundedOff;
	}
}
