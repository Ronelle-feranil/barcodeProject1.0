package xyz.mynt.myntbarcode.utils;

import java.util.Random;

/**
 * 
 * @author karl.cubilo
 *
 */
public class GeneratorUtils {
	
	/**
	 * 
	 * Generator for random numbers
	 * 
	 * @param start
	 * @param end
	 * @param random
	 * @return
	 */
	public static long generateRandomNumber(int start, long end, Random random){
	    if ( start > end ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    long range = end - (long)start + 1;
	    long fraction = (long)(range * random.nextDouble());
	    long randomNumber =  fraction + (long)start;    
	    
	    return randomNumber;
	  }
}
