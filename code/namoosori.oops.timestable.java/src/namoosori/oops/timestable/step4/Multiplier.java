/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.timestable.step4;

public class Multiplier {
	// 
	public Multiplier() {
		// 
	}
	
	public int multiply(int leftNumber, int rightNumber) {
		// 
		if (leftNumber < 1 || rightNumber < 1) {
			String message = null; 
			if (leftNumber < 1) { 
				message = "leftNumber is less than 1."; 
			} else {
				message = "rightNumber is less than 1"; 
			}
			throw new RuntimeException(message); 
		}
		
		int result = leftNumber * rightNumber; 
		
		return result; 
	}
}